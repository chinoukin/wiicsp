package com.wisea.transac.tp.product.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.Dict;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wangjiahao
 * @since 2020/7/17 11:56 上午
 */
@FeignClient(contextId = "tpSystem", name = "${wbfc.mss.tp-system:TpSystemMss}", url = "${wbfc.mssurl.tp-system:}")
public interface TpSystemMss {

    @PostMapping("/w/commCheckSetting/get")
    ResultPoJo<Dict> getSetting();

}
