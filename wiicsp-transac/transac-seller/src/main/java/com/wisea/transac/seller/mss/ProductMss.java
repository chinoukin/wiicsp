package com.wisea.transac.seller.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.product.CommPubInfoPagePo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangjiahao
 * @since 2020/7/23 2:30 下午
 */
@FeignClient(contextId = "ProductMss", name = "${wbfc.mss.tp-product:ProductMss}", url = "${wbfc.mssurl.tp-product:}")
@Component
public interface ProductMss {

    @RequestMapping(value = "/w/commditySearch/updateCommPubSearch", method = RequestMethod.POST)
    ResultPoJo updateCommPubSearch(@RequestBody CommPubInfoPagePo commPubInfoPagePo);

}
