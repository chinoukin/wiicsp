package com.wisea.transac.tp.product.search;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Lists;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cloud.search.properties.ElasticSearchClientProperties;
import com.wisea.transac.common.dao.AgentSerListMapper;
import com.wisea.transac.common.dao.EntpCommSerMapper;
import com.wisea.transac.common.dao.ShopInfoMapper;
import com.wisea.transac.common.utils.TimeShowUtil;
import com.wisea.transac.common.vo.AgentSerListInfoVo;
import com.wisea.transac.common.vo.seller.ShopInfoInfoVo;
import com.wisea.transac.common.vo.system.EntpCommSerInfoVo;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 新版es连接信息
 * @author: wangs
 * @date :2019/11/21
 */
@Component
@EnableConfigurationProperties(ElasticSearchClientProperties.class)
public class ElasticSearchRestHighLevelClient {

    @Autowired
    AgentSerListMapper agentSerListMapper;
    @Autowired
    EntpCommSerMapper entpCommSerMapper;
    @Autowired
    ShopInfoMapper shopInfoMapper;

    public static RequestOptions COMMON_OPTIONS;
    private static com.wisea.cloud.search.properties.ElasticSearchClientProperties ElasticSearchClientProperties = SpringBootContext.getBean(com.wisea.cloud.search.properties.ElasticSearchClientProperties.class);
    public RestHighLevelClient client;

    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        String DEFAULT_USER = ElasticSearchClientProperties.getUser();
        String DEFAULT_PASS = ElasticSearchClientProperties.getPassword();

        String auth = DEFAULT_USER + ":" + DEFAULT_PASS;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
        String authHeader = "Basic " + new String(encodedAuth);

        builder.addHeader("Authorization", authHeader);
        builder.setHttpAsyncResponseConsumerFactory(
                new HttpAsyncResponseConsumerFactory
                        .HeapBufferedResponseConsumerFactory(30 * 1024 * 1024));
        COMMON_OPTIONS = builder.build();

    }

    @PostConstruct
    public void getClient() throws Exception {


        SSLContext context = SSLContext.getInstance("TLS");

        context.init(null, new X509TrustManager[]{new X509TrustManager() {

            @Override
            public void checkClientTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }}, new SecureRandom());

        SSLIOSessionStrategy strategy = new SSLIOSessionStrategy(context, (s, sslSession) -> true);

        RestClientBuilder builder = RestClient.builder(
                new HttpHost(ElasticSearchClientProperties.getElasticIpAddress(), ElasticSearchClientProperties.getElasticPort(), "https"))
                .setHttpClientConfigCallback(httpClientBuilder -> {
                    HttpAsyncClientBuilder httpAsyncClientBuilder = httpClientBuilder
                            .setSSLContext(context)
                            .setSSLStrategy(strategy);
                    return httpAsyncClientBuilder;
                });

        client = new RestHighLevelClient(
                builder);
    }


    /**
     * 新建文档索引
     *
     * @param indexName
     * @param id
     * @param type
     */
    public synchronized void index(String indexName, String id, Map jsonStr, String type) {

        try {
            boolean falg = indexExists(ElasticSearchClientProperties.getIndexName());
            if (!falg) {
                CreateIndexRequest request = new CreateIndexRequest(ElasticSearchClientProperties.getIndexName());
                client.indices().create(request, COMMON_OPTIONS);
                System.out.println("success create index");
            }
            IndexRequest indexRequest = new IndexRequest();
            indexRequest.index(indexName);
            indexRequest.type(type);
            indexRequest.id(id);
            indexRequest.source(jsonStr);
            client.index(indexRequest, COMMON_OPTIONS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 组装索引数据
     */
    public void index(String indexName, String type, String id, Object obj) {

        try {
            Map objectToMap = ConverterUtil.getAllFieldsMap(obj);

            index(indexName, id, objectToMap, type);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 删除
     */
    public void delete(String indexName, String type, String id) {

        boolean falg = indexExists(ElasticSearchClientProperties.getIndexName());
        try {
            if (!falg) {
                // 说明没有索引库
                System.out.println("没有创建对应索引库index");
                CreateIndexRequest request = new CreateIndexRequest(ElasticSearchClientProperties.getIndexName());
                client.indices().create(request, COMMON_OPTIONS);
                System.out.println("success create index");
                return;
            }
            DeleteRequest request = new DeleteRequest();
            request.id(id);
            request.type(type);
            request.index(indexName);
            client.delete(request, COMMON_OPTIONS);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * 判断是否存在索引库
     *
     * @param index
     * @return
     */
    public boolean indexExists(String index) {
        boolean response = Boolean.parseBoolean(null);
        try {
            GetIndexRequest request = new GetIndexRequest(index);
            response = client.indices().exists(request, COMMON_OPTIONS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 序列化查询结果，包含分页信息
     *
     * @param searchResponse 当前页的查询结果
     * @param allResponse    所有满足条件的查询结果
     * @param pageNo         当前页
     * @param pageSize       页面大小
     * @return
     * @throws JsonProcessingException
     */
    public Map<String, Object> responseToJsonHotKey(SearchResponse searchResponse, SearchResponse allResponse, int pageNo, int pageSize) throws JsonProcessingException {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        // 总数据条数
        long count = allResponse.getHits().getTotalHits();

        Map<String, Aggregation> asMap = searchResponse.getAggregations().getAsMap();
        ParsedStringTerms hotWordsCount = (ParsedStringTerms) asMap.get("hotWords_count");
        List<? extends Terms.Bucket> buckets = hotWordsCount.getBuckets();
        long totalCount = buckets.size();
        // 总页数
        int totalPageNum = ((int) count + pageSize - 1) / pageSize;
        Map<String, Object> pageMap = new HashMap<String, Object>();
        pageMap.put("pageNo", pageNo);
        pageMap.put("pageSize", pageSize);
        pageMap.put("count", count);
        pageMap.put("totalPageNum", totalPageNum);
        pageMap.put("totalCount", totalCount);
        jsonMap.put("page", pageMap);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (Terms.Bucket bucket : buckets) {
            Map<String, Object> listMap = new HashMap<String, Object>();
            listMap.put("count", bucket.getDocCount());
            listMap.put("hotWordsName", bucket.getKeyAsString());
            list.add(listMap);
        }
        jsonMap.put("list", list);
        return jsonMap;
    }


    /**
     * 序列化查询结果，包含分页信息
     *
     * @param searchResponse 当前页的查询结果
     * @param allResponse    所有满足条件的查询结果
     * @param pageNo         当前页
     * @param pageSize       页面大小
     * @return
     * @throws JsonProcessingException
     */
    public Map<String, Object> responseToJson(SearchResponse searchResponse, SearchResponse allResponse, int pageNo, int pageSize, String searchType) throws JsonProcessingException {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        // 总数据条数
        long count = allResponse.getHits().getTotalHits();
        long totalCount = searchResponse.getHits().getTotalHits();
        // 总页数
        int totalPageNum = ((int) count + pageSize - 1) / pageSize;
        Map<String, Object> pageMap = new HashMap<String, Object>();
        pageMap.put("pageNo", pageNo);
        pageMap.put("pageSize", pageSize);
        pageMap.put("count", count);
        pageMap.put("totalPageNum", totalPageNum);
        pageMap.put("totalCount", totalCount);
        pageMap.put("releDate", System.currentTimeMillis() / 1000);
        jsonMap.put("page", pageMap);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        // 将查询结果放入list元素
        for (SearchHit hit : searchResponse.getHits()) {
            Map<String, Object> listMap = new HashMap<String, Object>();

            listMap.put("data", hit.getSourceAsMap());
            if (ConverterUtil.isNotEmpty(hit.getSourceAsMap())) {
                if (ConverterUtil.isNotEmpty(searchType) && searchType.equals("0")) {
                    String shopIds = (hit.getSourceAsMap().get("shopId").toString());
                    long shopId = Long.parseLong(shopIds);

                    // 处理店铺的关注信息                                                                                                 \
                    LongIdPo idPo = new LongIdPo();
                    idPo.setId(shopId);
                    ShopInfoInfoVo info = shopInfoMapper.findInfo(idPo);
                    if (ConverterUtil.isNotEmpty(info)) {
                        // 店铺总关注数
                        Long followCount = shopInfoMapper.findFollowCountByMerchantId(info.getMerchantId());
                        listMap.put("followCount", followCount);
                    }
                }
                // 商品的更新时间
                String createDate = hit.getSourceAsMap().get("createDate").toString();
                // 当前时间 - 商品的更新时间
                long currentTimeMillis = System.currentTimeMillis();
                long commpubTime = Long.parseLong(createDate);
                long date = currentTimeMillis - commpubTime * 1000;
                String subTime = TimeShowUtil.timeShow(date);
                listMap.put("subTime", subTime);
                // 此处是从es 中找到对应的字段信息 商品服务详情查询并返回
                String serSupportId = (String) hit.getSourceAsMap().get("serSupportIds");
                if (ConverterUtil.isNotEmpty(serSupportId)) {
                    String[] split = serSupportId.split(",");
                    List<EntpCommSerInfoVo> agentSerListInfoVos = Lists.newArrayList();
                    for (int i = 0; i < split.length; i++) {
                        LongIdPo longIdPo = new LongIdPo();
                        longIdPo.setId(Long.valueOf(split[i]));
                        EntpCommSerInfoVo info = entpCommSerMapper.findInfo(longIdPo);
                        agentSerListInfoVos.add(info);
                    }
                    listMap.put("serSupportType", agentSerListInfoVos);
                }
                list.add(listMap);
            }
        }
        jsonMap.put("list", list);
        return jsonMap;
    }

    /**
     * 若查询结果为空，序列化查询结果，包含分页信息
     *
     * @param pageNo   当前页
     * @param pageSize 页面大小
     * @return
     * @throws JsonProcessingException
     */
    public Map<String, Object> responseToJson(int pageNo, int pageSize) throws JsonProcessingException {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        // 总数据条数
        long count = 0;
        long totalCount = 0;
        // 总页数
        int totalPageNum = 0;
        Map<String, Object> pageMap = new HashMap<String, Object>();
        pageMap.put("pageNo", pageNo);
        pageMap.put("pageSize", pageSize);
        pageMap.put("count", count);
        pageMap.put("totalPageNum", totalPageNum);
        pageMap.put("totalCount", totalCount);
        jsonMap.put("page", pageMap);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        jsonMap.put("list", list);
        return jsonMap;
    }

    /**
     * 转换排序字符串为SortOrder
     *
     * @param sortOrder
     * @return
     */
    public static SortOrder convertSort(String sortOrder) {
        if (ConverterUtil.isNotEmpty(sortOrder)) {
            if (sortOrder.equalsIgnoreCase(SortOrder.DESC.toString())) {
                return SortOrder.DESC;
            }
        }
        return SortOrder.ASC;
    }

}
