package com.wisea.transac.tp.trade.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.product.BatchUpdSearchPo;
import com.wisea.transac.common.po.product.CommPubInfoGetPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 调用远程更新索引
 *
 * @author yangtao
 */
@FeignClient(contextId = "ProductMss", name = "${wbfc.mss.tp-product:ProductMss}", url = "${wbfc.mssurl.tp-product:}")
@Repository
public interface ProductMss {

    /**
     * 根据商品列表更新索引
     *
     * @param po
     * @return
     */
    @RequestMapping("/w/commditySearch/updateCommdity")
    ResultPoJo<String> updateIndexSearch(@RequestBody CommPubInfoGetPo po);

    /**
     * 根据商品列表批量更新索引
     *
     * @param po
     * @return
     */
    @RequestMapping("/w/commditySearch/updateBatchCommdity")
    ResultPoJo updateBatchCommditySearch(@RequestBody BatchUpdSearchPo po);
}
