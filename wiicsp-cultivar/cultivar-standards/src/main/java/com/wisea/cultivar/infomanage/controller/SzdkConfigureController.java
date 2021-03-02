package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.po.SzdkConfigurePageListPo;
import com.wisea.cultivar.common.po.SzdkConfigurePo;
import com.wisea.cultivar.common.vo.SzdkConfigureInfoVo;
import com.wisea.cultivar.common.vo.SzdkConfigurePageListVo;
import com.wisea.cultivar.infomanage.service.SzdkConfigureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SzdkConfigureController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@RestController
@RequestMapping("/w/SzdkConfigure")
@PreAuthorize("hasAuthority('im:stc')")
@Api(tags = "关于我们信息配置")
public class SzdkConfigureController {
    @Autowired
    private SzdkConfigureService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SzdkConfigure
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<SzdkConfigurePageListVo>> findPageList(@RequestBody SzdkConfigurePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除SzdkConfigure
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改SzdkConfigure
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody SzdkConfigurePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息SzdkConfigure
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<SzdkConfigureInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    @DataCheck
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询默认", value = "查询默认", notes = "查询默认", httpMethod = "POST")
    public ResultPoJo<SzdkConfigureInfoVo> get() {
        return service.findInfo();
    }

    @DataCheck
    @RequestMapping(value = "/set", method = RequestMethod.POST)
    @ApiOperation(nickname = "设置默认", value = "设置默认", notes = "设置默认", httpMethod = "POST")
    public ResultPoJo set(@RequestBody SzdkConfigurePo po) {
        return service.set(po);
    }

}
