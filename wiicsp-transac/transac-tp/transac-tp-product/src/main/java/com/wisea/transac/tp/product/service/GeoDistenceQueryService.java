package com.wisea.transac.tp.product.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.po.product.PubInfoGetPo;
import com.wisea.transac.tp.product.search.ElasticSearchRestHighLevelClient;
import com.wisea.transac.tp.product.search.GeoGetPo;
import com.wisea.transac.tp.product.search.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: wangs
 * @date :2020/5/14
 */
@Service
public class GeoDistenceQueryService {

    @Autowired
    ElasticSearchRestHighLevelClient elasticsearchRestHighLevelClient;


    /**
     * 添加批发市场
     *
     * @param geoGetPo
     * @return
     */
    public ResultPoJo addIndexGeo(GeoGetPo geoGetPo) {

        ResultPoJo<?> poJo = new ResultPoJo<>(ConstantError.NOMAL);
        geoGetPo.setId(ConverterUtil.getUUID());
        // 插入到索引库数据
        if (ConverterUtil.isNotEmpty(geoGetPo)) {
            elasticsearchRestHighLevelClient.index("search-hotkey", SearchType.HotKeyWords.toString(), geoGetPo.getId(), geoGetPo);
        }
        return poJo;
    }

    /**
     * 根据String 类型 id删除索引库信息
     *
     * @param pubInfoGetPo
     * @return
     */
    public ResultPoJo<String> delElasticById(PubInfoGetPo pubInfoGetPo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantError.NOMAL);
        elasticsearchRestHighLevelClient.delete("search-hotkey", SearchType.HotKeyWords.toString(), pubInfoGetPo.getId());
        return poJo;
    }

    /**
     * 根据id更新索引库信息即删除和新增
     *
     * @param geoGetPo
     * @return
     */
    public ResultPoJo<String> updateIndex(GeoGetPo geoGetPo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantError.NOMAL);

        if (geoGetPo != null) {
            elasticsearchRestHighLevelClient.delete("search-hotkey", SearchType.HotKeyWords.toString(), geoGetPo.getId());
            elasticsearchRestHighLevelClient.index("search-hotkey", SearchType.HotKeyWords.toString(), geoGetPo.getId(), geoGetPo);
        }
        return poJo;

    }

}
