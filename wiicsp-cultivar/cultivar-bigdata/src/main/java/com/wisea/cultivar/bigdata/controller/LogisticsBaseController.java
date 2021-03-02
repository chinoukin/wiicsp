package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.bigdata.service.LogisticsBaseService;
import com.wisea.cultivar.common.vo.bigdata.LogisticsBasePo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/12/2 4:43 下午
 */
@Api(tags = "[物流]-基础配置页接口")
@RestController
@RequestMapping("/w/logistics/base")
public class LogisticsBaseController {

    @Autowired
    private LogisticsBaseService logisticsBaseService;

    @DataCheck
    @PostMapping("/details")
    @ApiOperation(value = "查询详情")
    public ResultPoJo<LogisticsBasePo> findDetails() {
        return logisticsBaseService.findDetails();
    }

    @DataCheck
    @PostMapping("/update")
    @ApiOperation(value = "编辑详情")
    @PreAuthorize("hasAuthority('eb:bsc')")
    public ResultPoJo updateDetails(@RequestBody LogisticsBasePo po) {
        return logisticsBaseService.updateDetails(po);
    }

}
