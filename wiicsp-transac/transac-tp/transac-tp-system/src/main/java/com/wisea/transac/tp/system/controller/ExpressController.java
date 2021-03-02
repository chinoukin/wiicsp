package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.vo.LogisticsCompMagePageListVo;
import com.wisea.transac.tp.system.service.LogisticsCompMageService;
import com.wisea.transac.tp.system.utils.kdniao.KdniaoApi;
import com.wisea.transac.tp.system.utils.kdniao.KdniaoQueryCompCodePo;
import com.wisea.transac.tp.system.utils.kdniao.KdniaoQueryPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjiahao
 * @version 1.0
 * @className ExpressController
 * @since 2019-03-08 16:08
 */
@Api(tags = "快递信息查询")
@RestController
@RequestMapping("/w/express/query")
public class ExpressController {

    @Autowired
    private KdniaoApi api;
    @Autowired
    private LogisticsCompMageService service;

    @DataCheck
    @PostMapping("/instant")
    @ApiOperation(value = "快递物流即时查询",notes = "快递物流即时查询,订单编号可选，其他必填")
    public ResultPoJo<String> query(@RequestBody KdniaoQueryPo po) throws Exception {
        return api.getOrderTracesByJson(po);
    }

    @DataCheck
    @PostMapping("/code")
    @ApiOperation(value = "快递公司编码查询",notes = "快递公司编码查询")
    public ResultPoJo<LogisticsCompMagePageListVo> queryFroCompCode(@RequestBody KdniaoQueryCompCodePo po) {
        return service.findByCompName(po.getCompName());
    }

}
