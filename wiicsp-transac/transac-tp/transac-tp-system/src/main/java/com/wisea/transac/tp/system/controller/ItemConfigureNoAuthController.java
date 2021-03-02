package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.vo.ItemConfigureInfoVo;
import com.wisea.transac.tp.system.service.ItemConfigureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ItemConfigureController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@RestController
@RequestMapping("/n/ItemConfigure")
@Api(tags = "项目配置【无权限】")
public class ItemConfigureNoAuthController {
    @Autowired
    private ItemConfigureService service;

    @DataCheck
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询默认", value = "查询默认", notes = "查询默认", httpMethod = "POST")
    public ResultPoJo<ItemConfigureInfoVo> get() {
        return service.findInfo();
    }


}
