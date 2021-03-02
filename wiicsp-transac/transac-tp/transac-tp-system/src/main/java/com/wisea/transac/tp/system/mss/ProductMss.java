package com.wisea.transac.tp.system.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.product.CommDataListPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangjiahao
 * @since 2020/8/6 11:20 上午
 */
@Service
@FeignClient(contextId = "ProductMss", name = "${wbfc.mss.tp-product:ProductMss}", url = "${wbfc.mssurl.tp-product:}")
public interface ProductMss {

    @RequestMapping(value = "/w/commditySearch/updateCommPubState", method = RequestMethod.POST)
    ResultPoJo updateCommPubState(@RequestBody CommDataListPo po);

}
