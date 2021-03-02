package com.wisea.transac.tp.product.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.search.properties.ElasticSearchClientProperties;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.*;
import com.wisea.transac.common.entity.*;
import com.wisea.transac.common.po.product.*;
import com.wisea.transac.common.utils.AssemblyPriceUtil;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.CommAttriInfoVo;
import com.wisea.transac.common.vo.CommPubInfoInfoVo;
import com.wisea.transac.common.vo.product.AssembyPriceVo;
import com.wisea.transac.common.vo.product.CammSalesReleaseMageListVo;
import com.wisea.transac.common.vo.product.CommPubInfoListVo;
import com.wisea.transac.common.vo.product.LevelSqecQuatePriceVo;
import com.wisea.transac.common.vo.seller.StallsMageInfoVo;
import com.wisea.transac.tp.product.search.*;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.collapse.CollapseBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.wisea.transac.tp.product.search.ElasticSearchRestHighLevelClient.COMMON_OPTIONS;
import static com.wisea.transac.tp.product.search.ElasticSearchRestHighLevelClient.convertSort;

/**
 * @Description: 商品搜索服务类
 * @author: wangs
 * @date :2018/9/26
 */
@Service
@Transactional(readOnly = true)
@EnableConfigurationProperties(ElasticSearchClientProperties.class)
public class CommditySearchService extends BaseService {

    @Autowired
    Environment environment;
    @Autowired
    ElasticSearchClientProperties myProps;
    @Autowired
    CommPubInfoMapper commPubInfoMapper;
    @Autowired
    ElasticSearchRestHighLevelClient elasticsearchRestHighLevelClient;
    @Autowired
    CommSaleSetMapper commSaleSetMapper;
    @Autowired
    CommSaleCatgMapper commSaleCatgMapper;
    @Autowired
    CommVarietMageMapper commVarietMageMapper;
    @Autowired
    JedisDao jedisDao;
    @Autowired
    MeasUnitMageMapper measUnitMageMapper;
    @Autowired
    SellerGoodsService sellerGoodsService;
    @Autowired
    LevelSpecQuoteMapper levelSpecQuoteMapper;
    @Autowired
    CommAttriSetService commAttriSetService;


    /**
     * 添加到索引库
     *
     * @param commPubInfoGetPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo addIndexSearch(CommPubInfoGetPo commPubInfoGetPo) {

        ResultPoJo<?> poJo = new ResultPoJo<>(ConstantError.NOMAL);
        // 组装商品信息
        CommditySearchPojo searchPojo = getCommditySearchPojo(commPubInfoGetPo);

        // 插入到索引库数据
        if (ConverterUtil.isNotEmpty(searchPojo)) {
            elasticsearchRestHighLevelClient.index(myProps.getIndexName(), SearchType.CommdityList.toString(), ConverterUtil.toString(searchPojo.getId()), searchPojo);
        }
        return poJo;
    }

    /**
     * 添加到索引库中另一个index 库 进行热词统计
     *
     * @param hotKeyWordsPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo addIndexSearchOtherThye(HotKeyWordsPo hotKeyWordsPo) {

        ResultPoJo<?> poJo = new ResultPoJo<>(ConstantError.NOMAL);
        // 组装搜索词
        HotKeyWordsSearchPojo hotKeyWordsSearchPojo = new HotKeyWordsSearchPojo();
        hotKeyWordsSearchPojo.setSearchInput(hotKeyWordsPo.getSearchInput());
        hotKeyWordsSearchPojo.setId(ConverterUtil.getUUID());
        hotKeyWordsSearchPojo.setCreateDate(OffsetDateTimeUtils.getDateNow().toEpochSecond());
        // 插入到索引库数据
        if (ConverterUtil.isNotEmpty(hotKeyWordsSearchPojo)) {
            elasticsearchRestHighLevelClient.index("search-hotkey", SearchType.HotKeyWords.toString(), ConverterUtil.toString(hotKeyWordsSearchPojo.getId()), hotKeyWordsSearchPojo);
        }
        return poJo;
    }

    /**
     * 热搜列表搜索
     *
     * @param pojo
     * @return
     * @throws JsonProcessingException
     */
    public ResultPoJo<Map<String, Object>> restSearchHotWords(CommditySearchPojo pojo) throws JsonProcessingException {

        ResultPoJo<Map<String, Object>> resultPoJo = new ResultPoJo(ConstantCodeMsg.NOMAL);
        int start = (pojo.getPageNo() - 1) * pojo.getPageSize();
        String s = "searchInput";
        String index = "search-hotkey";
        // 拼接QueryBuilder
        BoolQueryBuilder bqb = QueryBuilders.boolQuery();
        // 聚合查询库存量
        // SumAggregationBuilder aggregationBuilder = AggregationBuilders.sum("supply_sum").field("avaiSupplyCount");
        // 聚合查询销售分类出现的次数
        //ValueCountAggregationBuilder cardinaltyCount = AggregationBuilders.count("hotWords_count").field(s.concat(".").concat("keyword"));
        // 指定别名和分组的字段
        // TermsAggregationBuilder teamAgg = AggregationBuilders.terms("team_name").field("wholeSaleMarketId");
        // 根据指定字段进行分组,对应的docCount就是 文档中出现的次数
        TermsAggregationBuilder teamAgg = AggregationBuilders.terms("hotWords_count").field(s.concat(".").concat("keyword"));
        teamAgg.order(BucketOrder.count(true));
        SearchResponse searchResp;
        SearchResponse allResp;
        try {
            SearchRequest searchRequest = new SearchRequest(index);
            searchRequest.types(SearchType.HotKeyWords.toString());
            searchRequest.searchType(org.elasticsearch.action.search.SearchType.DFS_QUERY_THEN_FETCH);
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(bqb);
            searchRequest.source(sourceBuilder);
            allResp = elasticsearchRestHighLevelClient.client.search(searchRequest, COMMON_OPTIONS);

            SearchRequest searchRequests = new SearchRequest(index);
            searchRequests.types(SearchType.HotKeyWords.toString());
            searchRequests.searchType(org.elasticsearch.action.search.SearchType.DFS_QUERY_THEN_FETCH);
            SearchSourceBuilder sourceBuilders = new SearchSourceBuilder();

//            CollapseBuilder collapseBuilder = new CollapseBuilder(s.concat(".").concat("keyword"));
//            sourceBuilders.collapse(collapseBuilder);
            sourceBuilders.aggregation(teamAgg);
            sourceBuilders.from(start);
            sourceBuilders.size(pojo.getPageSize());
            sourceBuilders.explain(true);
            sourceBuilders.query(bqb);
            searchRequests.source(sourceBuilders);
            searchResp = elasticsearchRestHighLevelClient.client.search(searchRequests, COMMON_OPTIONS);
        } catch (Exception e) {
            System.out.println(e);
            Map<String, Object> stringObjectMap = elasticsearchRestHighLevelClient.responseToJson(pojo.getPageNo(), pojo.getPageSize());
            resultPoJo.setResult(stringObjectMap);
            return resultPoJo;
        }
        Map<String, Object> stringObjectMap = elasticsearchRestHighLevelClient.responseToJsonHotKey(searchResp, allResp, pojo.getPageNo(), pojo.getPageSize());
        resultPoJo.setResult(stringObjectMap);
        return resultPoJo;
    }

    /**
     * 商品信息
     *
     * @param commPubInfoGetPo
     * @return
     */
    private CommditySearchPojo getCommditySearchPojo(CommPubInfoGetPo commPubInfoGetPo) {
        // 拼装插入索引的数据
        CommditySearchPojo searchPojo = new CommditySearchPojo();
        User user = SystemUtils.getUser();
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
        // 查询商品详细信息
        CommPubInfoInfoVo infoVo = commPubInfoMapper.findById(commPubInfoGetPo);
        StallsMageInfoVo stallsMageInfoVo = infoVo.getStallsMageInfoVo();
        searchPojo.setId(infoVo.getId().toString());
        searchPojo.setCommTitle(infoVo.getCommTitle());
        searchPojo.setCommStateType(infoVo.getCommStateType());
        if (ConverterUtil.isNotEmpty(commPubInfoGetPo.getUpdateTime()) && commPubInfoGetPo.getUpdateTime().equals("1")) {
            // 增加成交时间
            searchPojo.setEndTradTime(OffsetDateTimeUtils.getDateNow().toEpochSecond());
        }

        searchPojo.setCommSaleSetId(infoVo.getCommSaleSetId().toString());
        CommSaleSet commSaleSet = commSaleSetMapper.selectByPrimaryKey(infoVo.getCommSaleSetId());
        searchPojo.setCommSaleCatgSetName(commSaleSet.getCommName());
        searchPojo.setSalesSetSort(commSaleSet.getSort());
        searchPojo.setCommSaleId(commSaleSet.getCommSaleCatgId().toString());
        CommSaleCatg commSaleCatg = commSaleCatgMapper.selectByPrimaryKey(commSaleSet.getCommSaleCatgId());
        searchPojo.setCommSaleCatgName(commSaleCatg.getCatgName());
        searchPojo.setSalesSort(commSaleCatg.getSort());

        CommMageGetPo attriSet = new CommMageGetPo();
        attriSet.setId(commSaleSet.getCommId());
        // 属性设置列表
        if (ConverterUtil.isNotEmpty(infoVo.getCommAttri())) {
            List<CommAttriInfoVo> commAttri = infoVo.getCommAttri();
            commAttri.forEach(e -> {
                if (e.getCommAttriColumn().equals("dengji") && e.getCommAttriType().equals(DictConstants.COMM_ATTRI_TYPE_1)) {
                    String[] split = e.getDictVal().split(";");
                    for (String string : split) {
                        if (string.indexOf(e.getCommAttriVal()) >= 0) {
                            String[] split1 = string.split(",");
                            String[] split2 = split1[0].split(":");
                            searchPojo.setGrade(split2[0]);
                        }
                    }
                }
            });
        }
        searchPojo.setCommVarietId(infoVo.getCommVarietId().toString());
        searchPojo.setCommVatrieName(infoVo.getCommVarietName());
        if (ConverterUtil.isNotEmpty(infoVo.getSerTypeExpres())) {
            String[] split = infoVo.getSerTypeExpres().split(",");
            String[] serSupportType = new String[split.length];
            for (int i = 0; i < split.length; i++) {
                serSupportType[i] = split[i];
            }
            searchPojo.setSerSupportIds(infoVo.getSerTypeExpres());
            searchPojo.setSupportTypeId(serSupportType);
        }
        // 价格信息
        String str = jedisDao.getStr(infoVo.getCommNum());
        if (ConverterUtil.isEmpty(str)) {
            List<LevelSqecQuatePriceVo> levelSpecQuoteMagePos = infoVo.getCommLevelPo();
            LevelSqecQuatePriceVo levelSqecQuatePriceVo = levelSpecQuoteMagePos.get(0);
            String orderStartCount = levelSqecQuatePriceVo.getStartOrdExpres();
            String[] split = orderStartCount.split("~");
            MeasUnitMage measUnitMage = measUnitMageMapper.selectByPrimaryKey(levelSqecQuatePriceVo.getMeasUnitId());
            searchPojo.setStartOrdCount(Double.valueOf(split[0]).doubleValue());
            searchPojo.setMeasUnit(measUnitMage.getMeasUnitName());
        } else {
            String[] sortOrderMeasUnit = str.split(",");
            searchPojo.setStartOrdCount(Double.valueOf(sortOrderMeasUnit[0]).doubleValue());
            searchPojo.setMeasUnit(sortOrderMeasUnit[1]);
        }
        AssembyPriceVo productPrice = AssemblyPriceUtil.getProductPrice(infoVo.getId());
        if (ConverterUtil.isNotEmpty(productPrice)) {
            // 销量
            if (ConverterUtil.isNotEmpty(productPrice.getSalesVolumeTotal())) {
                searchPojo.setSalesVolume(productPrice.getSalesVolumeTotal().intValue());
            }
            // 基地库存量
            if (ConverterUtil.isNotEmpty(productPrice.getAvaiSupplyCountTotal())) {
                searchPojo.setAvaiSupplyCount(productPrice.getAvaiSupplyCountTotal().intValue());
            }
            searchPojo.setAllPrice(productPrice.getPriceRang());
            // 最小的价格
            String priceRang = productPrice.getPriceRang();
            String[] split = priceRang.split("~");
            searchPojo.setMinPrice(Double.valueOf(split[0]));
        }
        // 基地
        if (ConverterUtil.isNotEmpty(infoVo.getBaseId())) {
            searchPojo.setBaseId(infoVo.getBaseId().toString());
            searchPojo.setBaseName(infoVo.getBaseName());
            searchPojo.setStorageType(infoVo.getStorageType());
            if (infoVo.getStorageType().equals(DictConstants.STORAGE_TYPE_0)) {
                searchPojo.setStorageId(infoVo.getStorageId().toString());
            } else {
                searchPojo.setPlantationId(infoVo.getPlantationId().toString());
            }
            if (ConverterUtil.isNotEmpty(infoVo.getPortId())) {
                searchPojo.setPortId(infoVo.getPortId().toString());
                searchPojo.setPortName(infoVo.getPortName());
            }
        }
        // 档口,店铺
        if (ConverterUtil.isNotEmpty(infoVo.getStallsMageId())) {

            searchPojo.setStallsMageId(infoVo.getStallsMageId().toString());
            searchPojo.setStallsMageName(stallsMageInfoVo.getStallsName());
            searchPojo.setBackGroundUrl(stallsMageInfoVo.getBackGroundUrl());
            searchPojo.setBusinessDate(stallsMageInfoVo.getBusinessDate());
            searchPojo.setBusinessTime(stallsMageInfoVo.getBusinessTime());
            searchPojo.setStallsHouseNum(stallsMageInfoVo.getStallsHouseNum());

            searchPojo.setWholeSaleMarketId(stallsMageInfoVo.getWholeSaleMarketId().toString());
            searchPojo.setShopId(stallsMageInfoVo.getShopId().toString());
            searchPojo.setShopName(stallsMageInfoVo.getShopName());
        }
        searchPojo.setSerSupportType(infoVo.getSerSupportType());

        searchPojo.setMembId(membInfo.getMembId().toString());
        searchPojo.setMembAuthName(membInfo.getAuthName());
        searchPojo.setEntpAuth(membInfo.getAuthName());
        // 将发布日期转化成Long 秒数 ,排序使用
        if (ConverterUtil.isNotEmpty(infoVo.getUpdateDate())) {
            searchPojo.setCreateDate(infoVo.getUpdateDate().toEpochSecond());
        } else {
            searchPojo.setCreateDate(infoVo.getCreateDate().toEpochSecond());
        }
        infoVo.getCommPicture().forEach(e -> {
            if (e.getCommPictureType().equals(DictConstants.COMM_PICTURE_TYPE_0)) {
                searchPojo.setImageUrl(e.getUrl());
            }
        });
        return searchPojo;
    }

    /**
     * 根据id删除索引库信息
     *
     * @param commPubInfoGetPo
     * @return
     */
    public ResultPoJo<String> delIndexSearch(CommPubInfoGetPo commPubInfoGetPo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantError.NOMAL);
        elasticsearchRestHighLevelClient.delete(myProps.getIndexName(), SearchType.CommdityList.toString(), ConverterUtil.toString(commPubInfoGetPo.getId()));
        return poJo;
    }

    /**
     * 根据id更新索引库信息即删除和新增
     *
     * @param commPubInfoGetPo
     * @return
     */
    public ResultPoJo<String> updateIndexSearch(CommPubInfoGetPo commPubInfoGetPo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantError.NOMAL);
        CommditySearchPojo searchPojo = getCommditySearchPojo(commPubInfoGetPo);

        if (searchPojo != null) {
            elasticsearchRestHighLevelClient.delete(myProps.getIndexName(), SearchType.CommdityList.toString(), ConverterUtil.toString(commPubInfoGetPo.getId()));
            elasticsearchRestHighLevelClient.index(myProps.getIndexName(), SearchType.CommdityList.toString(), ConverterUtil.toString(searchPojo.getId()), searchPojo);
        }
        return poJo;

    }

    /**
     * 批量更新索引
     *
     * @param batchUpdSearchPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo updateBatchCommditySearch(BatchUpdSearchPo batchUpdSearchPo) {

        ResultPoJo poJo = new ResultPoJo<>(ConstantError.NOMAL);
        logger.debug("test update index commPubInfo ----------------------------------------------");
        List<Long> listPo = batchUpdSearchPo.getListIdPo();
        listPo.forEach(e -> {
            // 商品的所有规格 可售数量为0, 商品下架操作;
            List<LevelSpecQuote> levelSpecQuoteList = levelSpecQuoteMapper.findListByCommPubId(e);
            levelSpecQuoteList.forEach(j -> {
                double avaiSupplyCountTotal = levelSpecQuoteList.stream().mapToDouble(LevelSpecQuote::getAvaiSupplyCount).sum();
                if (avaiSupplyCountTotal == 0.0) {
                    CommPubInfo commPubInfo = new CommPubInfo();
                    commPubInfo.setId(e);
                    commPubInfo.setCommStateType(DictConstants.COMM_STATE_TYPE_3);
                    commPubInfo.preUpdate();
                    commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
                    logger.debug("update commPubInfo commStatType ----------------------------------------------");
                }
            });

        });
        if (ConverterUtil.isNotEmpty(listPo)) {
            listPo.forEach(e -> {
                // 更新 对应的商品更新时间
                CommPubInfo commPub = new CommPubInfo();
                commPub.setId(e);
                commPub.preUpdate();
                commPubInfoMapper.updateByPrimaryKeySelective(commPub);
                CommPubInfoGetPo commPubInfoPo = new CommPubInfoGetPo();
                commPubInfoPo.setId(e);
                commPubInfoPo.setUpdateTime("1");
                CommPubInfo commPubInfo = commPubInfoMapper.selectByPrimaryKey(e);
                if (commPubInfo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_3)) {
                    delIndexSearch(commPubInfoPo);
                    logger.debug("delete index commPubInfo ----------------------------------------------");
                } else {
                    updateIndexSearch(commPubInfoPo);
                    logger.debug("update index commPubInfo ----------------------------------------------");
                }
            });

        }

        return poJo;
    }

    /**
     * 商品列表搜索
     *
     * @param pojo
     * @return
     * @throws JsonProcessingException
     */
    public ResultPoJo<Map<String, Object>> restSearchSupply(CommditySearchPojo pojo) throws JsonProcessingException {

        ResultPoJo<Map<String, Object>> resultPoJo = new ResultPoJo(ConstantCodeMsg.NOMAL);
        int start = (pojo.getPageNo() - 1) * pojo.getPageSize();
        // 排序模式 ASC或DESC,大小写均可
        SortOrder sortOrder = convertSort(pojo.getSortOrder());
        BoolQueryBuilder bqb = QueryBuilders.boolQuery();

        // 商品发布的变更新时间 update
        SortBuilder sort = SortBuilders.fieldSort(CommdityListFeild.CreateDate.toString()).order(sortOrder);
        if (ConverterUtil.isNotEmpty(pojo.getOrderBy()) && CommdityListFeild.SalesVolume.toString().equals(pojo.getOrderBy())) {
            sort = SortBuilders
                    .fieldSort(CommdityListFeild.SalesVolume.toString()).order(sortOrder);
        }
        // 判断排序模式，按成交时间
        if (ConverterUtil.isNotEmpty(pojo.getOrderBy()) && CommdityListFeild.EndTradTime.toString().equals(pojo.getOrderBy())) {
            sort = SortBuilders
                    .fieldSort(CommdityListFeild.EndTradTime.toString()).order(sortOrder);
        }
        if (ConverterUtil.isNotEmpty(pojo.getOrderBy()) && CommdityListFeild.WholePriceSection.toString().equals(pojo.getOrderBy())) {
            // 按照最低价排序
            if ((pojo.getMinPrice().toString().equals(DictConstants.MIN_PRICE))) {
                sort = SortBuilders
                        .fieldSort(CommdityListFeild.MinPrice.toString()).order(sortOrder);
            }
        }
        BoolQueryBuilder lcQuery = QueryBuilders.boolQuery();
        boolean isLc = false;
        // 分类设置
        if (ConverterUtil.isNotEmpty(pojo.getCommSaleSetId())) {
            bqb.must(QueryBuilders.matchQuery(CommdityListFeild.CommSaleSetId.toString(), pojo.getCommSaleSetId()));
        }
        // 第二级分类 如,时令瓜果.进口水果
        if (ConverterUtil.isNotEmpty(pojo.getCommSaleId())) {
            // 根据销售分类查询销售分类设置
            CommSalesReleasePagePo commSalesReleasePagePo = new CommSalesReleasePagePo();
            commSalesReleasePagePo.setCommSalesCatgId(Long.parseLong(pojo.getCommSaleId()));
            List<CammSalesReleaseMageListVo> salesClassReleaseList = commSaleSetMapper.findSalesClassReleaseList(commSalesReleasePagePo);
            List<Long> commSaleSetCollect = Lists.newArrayList();
            salesClassReleaseList.forEach(e -> {
                commSaleSetCollect.add(e.getId());
            });
            isLc = true;
            lcQuery.should(QueryBuilders.termsQuery(CommdityListFeild.CommSaleSetId.toString(), commSaleSetCollect));
        }
        // 品种,楼层的数组
        if (ConverterUtil.isNotEmpty(pojo.getCommSaleSetIds())) {
            isLc = true;
            lcQuery.should(QueryBuilders.termsQuery(CommdityListFeild.CommSaleSetId.toString(), pojo.getCommSaleSetIds()));
        }
        if (ConverterUtil.isNotEmpty(pojo.getSupportTypeId())) {
            isLc = true;
            lcQuery.should(QueryBuilders.termsQuery(CommdityListFeild.SupportTypeId.toString(), pojo.getSupportTypeId()));
        }
        if (isLc) {
            bqb.must(lcQuery);
        }
        // 排除等于 进口水果的信息
        if (ConverterUtil.isNotEmpty(pojo.getDomesticProducts())) {
            bqb.mustNot(QueryBuilders.termsQuery(CommdityListFeild.CommSaleId.toString(), pojo.getDomesticProducts()));
        }
        if (ConverterUtil.isNotEmpty(pojo.getWholeSaleMarketId())) {
            bqb.must(QueryBuilders.matchQuery(CommdityListFeild.WholeSaleMarketId.toString(), pojo.getWholeSaleMarketId()));
        }
        // 排除产地商品信息
        if (ConverterUtil.isNotEmpty(pojo.getCommditySourceType())) {
            if (pojo.getCommditySourceType().equals(DictConstants.COMMDITY_SOURCE_TYPE_0)) {
                bqb.mustNot(QueryBuilders.existsQuery(CommdityListFeild.BaseId.toString()));
            }
        }
        // 标准件的查询
        if (ConverterUtil.isNotEmpty(pojo.getYjdfFlag())) {
            bqb.must(QueryBuilders.matchQuery(CommdityListFeild.YjdfFlag.toString(), pojo.getYjdfFlag()));
        }
        // 基地设置
        if (ConverterUtil.isNotEmpty(pojo.getBaseId())) {
            bqb.must(QueryBuilders.matchQuery(CommdityListFeild.BaseId.toString(), pojo.getBaseId()));
        }
        // 仓库
        if (ConverterUtil.isNotEmpty(pojo.getStorageId())) {
            bqb.must(QueryBuilders.matchQuery(CommdityListFeild.StorageId.toString(), pojo.getStorageId()));
        }
        // 种植园
        if (ConverterUtil.isNotEmpty(pojo.getPlantationId())) {
            bqb.must(QueryBuilders.matchQuery(CommdityListFeild.PlantationId.toString(), pojo.getPlantationId()));
        }
        if (ConverterUtil.isNotEmpty(pojo.getPriceSectionStart())) {
            bqb.must(QueryBuilders.rangeQuery(CommdityListFeild.MinPrice.toString()).gte(pojo.getPriceSectionStart()));
        }
        if (ConverterUtil.isNotEmpty(pojo.getPriceSectionEnd())) {
            bqb.must(QueryBuilders.rangeQuery(CommdityListFeild.MinPrice.toString()).lte(pojo.getPriceSectionEnd()));
        }
        if (ConverterUtil.isNotEmpty(pojo.getPriceSectionStart()) && ConverterUtil.isNotEmpty(pojo.getPriceSectionEnd())) {
            bqb.must(QueryBuilders.rangeQuery(CommdityListFeild.MinPrice.toString()).gte(pojo.getPriceSectionStart()).lte(pojo.getPriceSectionEnd()));
        }
        if (ConverterUtil.isNotEmpty(pojo.getStartBullk())) {
            bqb.must(QueryBuilders.rangeQuery(CommdityListFeild.StartOrdCount.toString()).gte(pojo.getStartBullk()));
        }
        if (ConverterUtil.isNotEmpty(pojo.getEndBullk())) {
            bqb.must(QueryBuilders.rangeQuery(CommdityListFeild.StartOrdCount.toString()).lte(pojo.getEndBullk()));
        }
        if (ConverterUtil.isNotEmpty(pojo.getStartBullk()) && ConverterUtil.isNotEmpty(pojo.getEndBullk())) {
            bqb.must(QueryBuilders.rangeQuery(CommdityListFeild.StartOrdCount.toString()).gte(pojo.getStartBullk()).lte(pojo.getEndBullk()));
        }
        if (ConverterUtil.isNotEmpty(pojo.getEndTime())) {
            pojo.setEndTime(OffsetDateTimeUtils.getDayMaxTime(pojo.getEndTime()));
            long endTime = pojo.getEndTime().toEpochSecond();
            long startTime = pojo.getStartTime().toEpochSecond();
            bqb.must(QueryBuilders.rangeQuery(CommdityListFeild.CreateDate.toString()).gte(startTime).lte(endTime));
        }
        if (ConverterUtil.isNotEmpty(pojo.getSerSupportType())) {
            bqb.must(QueryBuilders.termsQuery(CommdityListFeild.SupportTypeId.toString(), pojo.getSerSupportType()));
        }
        if (ConverterUtil.isNotEmpty(pojo.getSearchInput())) {
            // 热门搜索 商品需要将搜索的内容插入到另一个索引库中
//            HotKeyWordsPo hotKeyWordsPo = new HotKeyWordsPo();
//            hotKeyWordsPo.setSearchInput(pojo.getSearchInput());
//            addIndexSearchOtherThye(hotKeyWordsPo);
            bqb.must(QueryBuilders.multiMatchQuery(pojo.getSearchInput(), CommdityListFeild.CommTitle.toString(), CommdityListFeild.CommSaleCatgSetName.toString(),
                    CommdityListFeild.CommVatrieName.toString()).analyzer("standard").field("first").minimumShouldMatch("100%"));
        }
        // 输入框信息商品编码
        if (ConverterUtil.isNotEmpty(pojo.getSearchInputNum())) {
            bqb.must(QueryBuilders.multiMatchQuery(pojo.getSearchInputNum(),
                    CommdityListFeild.CommNum.toString()).analyzer("standard").field("first").minimumShouldMatch("100%"));
        }
        SearchResponse searchResp;
        SearchResponse allResp;
        try {
            SearchRequest searchRequest = new SearchRequest(myProps.getIndexName());
            searchRequest.types(SearchType.CommdityList.toString());
            searchRequest.searchType(org.elasticsearch.action.search.SearchType.DFS_QUERY_THEN_FETCH);
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.sort(sort);
            sourceBuilder.query(bqb);
            searchRequest.source(sourceBuilder);
            allResp = elasticsearchRestHighLevelClient.client.search(searchRequest, COMMON_OPTIONS);

            SearchRequest searchRequests = new SearchRequest(myProps.getIndexName());
            searchRequest.types(SearchType.CommdityList.toString());
            searchRequest.searchType(org.elasticsearch.action.search.SearchType.DFS_QUERY_THEN_FETCH);
            SearchSourceBuilder sourceBuilders = new SearchSourceBuilder();
            if (ConverterUtil.isNotEmpty(pojo.getSearchType())) {
                if (pojo.getSearchType().equals(DictConstants.SEARCH_TYPE_0)) {
                    CollapseBuilder collapseBuilder = new CollapseBuilder(CommdityListFeild.ShopId.toString().concat(".").concat("keyword"));
                    sourceBuilders.collapse(collapseBuilder);
                } else if (pojo.getSearchType().equals(DictConstants.SEARCH_TYPE_1)) {
                    CollapseBuilder collapseBuilder = new CollapseBuilder(CommdityListFeild.StallsMageName.toString().concat(".").concat("keyword"));
                    sourceBuilders.collapse(collapseBuilder);
                }
            }

            sourceBuilders.sort(sort);
            sourceBuilders.query(bqb);
            sourceBuilders.from(start);
            sourceBuilders.size(pojo.getPageSize());
            sourceBuilders.explain(true);
            searchRequests.source(sourceBuilders);
            searchResp = elasticsearchRestHighLevelClient.client.search(searchRequests, COMMON_OPTIONS);
        } catch (Exception e) {
            System.out.println(e);
            Map<String, Object> stringObjectMap = elasticsearchRestHighLevelClient.responseToJson(pojo.getPageNo(), pojo.getPageSize());
            resultPoJo.setResult(stringObjectMap);
            return resultPoJo;
        }
        Map<String, Object> stringObjectMap = elasticsearchRestHighLevelClient.responseToJson(searchResp, allResp, pojo.getPageNo(), pojo.getPageSize(), pojo.getSearchType());
        resultPoJo.setResult(stringObjectMap);
        return resultPoJo;
    }

    /**
     * 因档口删除，档口为空，商品变为已下架状态
     *
     * @param commPubInfoPagePo
     * @return
     */
    public ResultPoJo updateCommPubSearch(CommPubInfoPagePo commPubInfoPagePo) {

        ResultPoJo resultPoJo = new ResultPoJo(ConstantCodeMsg.NOMAL);
        CommPubInfo commPubInfo = new CommPubInfo();
        commPubInfo.setCommStateType(DictConstants.COMM_STATE_TYPE_3);
        commPubInfo.preUpdate();
        Map<String, Object> maps = Maps.newHashMap();
        maps.put("commPubInfo", commPubInfo);

        List<CommPubInfoListVo> commPubList = commPubInfoMapper.findCommPubList(commPubInfoPagePo);
        if (ConverterUtil.isNotEmpty(commPubList) && commPubList.size() != 0) {
            // 更新索引
            commPubList.forEach(e -> {
                if (e.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_0)) {
                    CommPubInfoGetPo commPubInfoGetPo = new CommPubInfoGetPo();
                    commPubInfoGetPo.setId(e.getId());
                    delIndexSearch(commPubInfoGetPo);
                }
            });
            // 修改发布商品状态
            List<Long> ids = commPubList.stream().map(CommPubInfoListVo::getId).collect(Collectors.toList());
            maps.put("ids", ids);
            commPubInfoMapper.updateCommPubState(maps);
        }
        return resultPoJo;
    }

}
