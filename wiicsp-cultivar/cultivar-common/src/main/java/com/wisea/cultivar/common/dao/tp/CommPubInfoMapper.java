package com.wisea.cultivar.common.dao.tp;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.wisea.cloud.common.interceptor.MapF2F;
import com.wisea.cultivar.common.po.tp.*;
import com.wisea.cultivar.common.entity.tp.CommPubInfo;
import com.wisea.cultivar.common.po.product.RecommendSellerPo;
import com.wisea.cultivar.common.po.tp.product.AvailableQuantityPo;
import com.wisea.cultivar.common.po.tp.product.AvailableSupplyPo;
import com.wisea.cultivar.common.po.tp.trade.BuyerPitchOnPo;
import com.wisea.cultivar.common.vo.product.CommPubInfoVo;
import com.wisea.cultivar.common.vo.tp.CommDataListVo;
import com.wisea.cultivar.common.vo.tp.CommPubInfoGetVo;
import com.wisea.cultivar.common.vo.tp.CommPubInfoListVo;
import com.wisea.cultivar.common.vo.tp.product.AvailableQuantityVo;
import com.wisea.cultivar.common.vo.tp.product.AvailableSupplyVo;
import com.wisea.cultivar.common.vo.tp.product.SupplyListMapVo;
import org.apache.ibatis.annotations.Param;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.statistics.AdminCommPubMembOverviewVo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerCommInfoListVo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerImportBillCommInfoListVo;
import org.springframework.stereotype.Repository;

/**
 * comm_pub_info 表DAO
 * 后台配置的参数表没有做关联关系（品牌、计量单位）
 * 2018/09/18 14:36:47
 */
@Repository
public interface CommPubInfoMapper extends CrudDao<CommPubInfo> {
    List<CommPubInfoListVo> findPage(CommPubInfoPagePo commPubInfoPagePo);

    List<CommPubInfoListVo> findList(CommPubInfoListPo commPubInfoListPo);

    void batchUpdateStock(Map<String, Object> parameterMap);

    List<CommDataListVo> commList(CommDataListPo po);

    /**
     * 商品代理价设置
     */
    CommDataListVo editAgentPrice(CommPubInfoGetPo po);

    /**
     * 设置商品代理价
     */
    Integer modifyAgentPrice(modifyCommAgentPricePo pos);

    /**
     * 查询状态信息
     *
     * @param commPubInfoPagePo
     * @return
     */
    @MapF2F()
    Map<String, Integer> getStateCountMap(CommPubInfoPagePo commPubInfoPagePo);

    /**
     * 分页list查询
     */
    List<CommPubInfoListVo> findListSubQuery(CommPubInfoPagePo commPubInfoPagePo);

    List<BuyerImportBillCommInfoListVo> commInfoListFromImportBillT(BuyerPitchOnPo po);

    /**
     * 批量修改商品发布状态
     * @param map
     */
    void updateCommPubInfoState(Map<String , Object> map);

    /**
     * 根据状态和发布商品id 查询发布商品列表
     * @param maps
     * @return
     */
    List<CommPubInfo> findListByCommPubInfoStateType(Map<String, Object> maps);

    /**
     * 根据已下架和未上架的状态和商品id 查询发布商品列表
     * @param maps
     * @return
     */
    List<CommPubInfo> findCommPubInfoListStateType(Map<String, Object> maps);
    /**
     * 查询详情预览
     *
     * @param info
     * @return
     */
    CommPubInfoGetVo findById(CommPubInfo info);

    /**
     * 在删除之前做查询判断是否有商品引用该计量单位
     */
    List<CommPubInfoGetVo> beforeDelSelectMeas(Long id);

    /**
     * 查询热销
     *
     * @param commPubInfo
     * @return
     */
    List<CommPubInfoListVo> findHotSelList(CommPubInfo commPubInfo);

    /**
     * 查询热销 代理价
     *
     * @param commPubInfo
     * @return
     */
    List<CommPubInfoListVo> findHotSelListAgent(CommPubInfo commPubInfo);

    /**
     * 查询新品
     *
     * @param commPubInfo
     * @return
     */
    List<CommPubInfoGetVo> newProductList(CommPubInfo commPubInfo);

    /**
     * 查询新品 代理价
     *
     * @param commPubInfo newProductListAgent
     * @return
     */
    List<CommPubInfoGetVo> newProductListAgent(CommPubInfo commPubInfo);

    /**
     * 查询山系和茶龄
     *
     * @param commPubInfo
     * @return
     */
    List<CommPubInfoGetVo> selectCommPubInfoList(CommPubInfo commPubInfo);


    List<CommPubInfoGetVo> selectCommPubByArea(CommPubInfo commPubInfo);

    int editByPrimaryKey(CommPubInfo commPubInfo);

    /**
     * 查询山系和茶龄 agent
     *
     * @param commPubInfo
     * @return
     */
    List<CommPubInfoGetVo> selectCommPubInfoListAgent(CommPubInfo commPubInfo);

    Integer getVolume(CommPubInfo info);

    /**
     * 进货单商品的列表信息
     *
     * @param
     * @return
     */
    List<BuyerImportBillCommInfoListVo> commInfoListFromImportBill(BuyerPitchOnPo po);

    /**
     * 通过商品ids 查询 运费模板ids
     *
     * @param
     * @return
     */
    String selectFreightFormworkIds(String freightFormworkIds);

    /**
     * 通过商品ids 查询 运费模板idList
     *
     * @param
     * @return
     */
    List<CommPubInfo> selectFreightFormworkIdList(String freightFormworkIds);


    /**
     *  通过商品ids 以及  运费模板查询 商品信息List
     *
     * @param commPubInfo
     * @return
     */
    List<CommPubInfo> selectCommPubMsgList(CommPubInfo commPubInfo);

    /**
     *  页面右上角 悬浮 显示  先加入的 进货单 商品的列表 显示前三个
     *
     * @param membId
     * @return
     */
    List<BuyerCommInfoListVo> commInfoList(Long membId);

    /**
     * 取到商品的代理结算价指定方式表达式和代理结算价比例/固定表达式值
     * */
    CommPubInfo selectAgentWhole(Long id);

    /**
     * 获取发布商品的商品编号
     * @param commNum
     * @return
     */
    List<String> findCommPubInfoMaxNum(String commNum);

    /**
     * 根据商品编号获取商品信息
     * @param commNum
     * @return
     */
    CommPubInfo findByCommNum(String commNum);

    void updateSalesCount(@Param("ordCommCountMap") Map<Long, Integer> ordCommCountMap);

    Integer updateBeforeCommOriginalPrice(CommPubInfo commPubInfo);

    /**
     * 【统计】后台商品/用户总览
     * @return
     * @param paramMap
     */
    AdminCommPubMembOverviewVo commPubMembOverview(Map<String, OffsetDateTime> paramMap);

    /**
     * 查询超过有效期的发布商品
     * @param info
     * @return
     */
    List<CommPubInfo> findListOverTime(CommPubInfo info);

    /**
     * 查询成交量不规定时间范围
     * @param info
     * @return
     */
    Integer getVolumeCount(CommPubInfo info);

    /**
     * @Author jirg
     * @Date 2019/5/16 11:16
     * @Description 根据发布商品ID查询对应品类ID
     **/
    @MapF2F()
    Map<Long, Long> getCommIdMap(List<Long> commPubIds);

    /**
     * 查询品类数
     * @param availableQuantityPo
     * @return
     */
    AvailableQuantityVo availableQuantity(AvailableQuantityPo availableQuantityPo);


    /**
     * 查询商家可供货数和有几个商家供货
     * @param availableSupplyPo
     * @return
     */
    AvailableSupplyVo availableSupplySum(AvailableSupplyPo availableSupplyPo);

    /**
     * 地图显示数据
     * @param availableQuantityPo
     * @return
     */
    List<SupplyListMapVo> availableSupplyListMap(AvailableQuantityPo availableQuantityPo);

    /**
     * 查询 大宗商品 根据品类id 如果不存在,默认显示前5条根据发布时间
     * @param po
     * @return
     */
    List<CommDataListVo> commPubList(CommDataListPo po);

    /**
     * 查询发布商品表中的所有上架状态的商品
     * @param commPubIdEditEsSearch
     * @return
     */
    List<CommPubInfo> findCommPubIdEditEsSearch(CommPubIdEditEsSearchPo commPubIdEditEsSearch);

    /**
     * 推荐企业查询
     * @param recommendSellerPo
     * @return
     */
    List<CommPubInfoVo> recommendSeller(RecommendSellerPo recommendSellerPo);
}
