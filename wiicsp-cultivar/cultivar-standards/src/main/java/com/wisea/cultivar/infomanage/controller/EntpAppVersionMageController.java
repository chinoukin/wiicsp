package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cloud.model.po.LongIdsPo;
import com.wisea.cultivar.common.po.AppVersionPo;
import com.wisea.cultivar.common.po.EntpAppVersionMagePageListPo;
import com.wisea.cultivar.common.po.EntpAppVersionMagePo;
import com.wisea.cultivar.common.vo.EntpAppVersionMageInfoVo;
import com.wisea.cultivar.common.vo.EntpAppVersionMagePageListVo;
import com.wisea.cultivar.infomanage.service.EntpAppVersionMageService;
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
 * @className EntpAppVersionMageController
 * @date 2020/05/11 13:38:11
 * @Description
 */
@RestController
@RequestMapping("/w/EntpAppVersionMage")
@Api(tags = "服务商app版本管理")
public class EntpAppVersionMageController {
    @Autowired
    private EntpAppVersionMageService service;

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 分页查询EntpAppVersionMage
     */
    @DataCheck
    @PreAuthorize("hasAuthority('im:apv')")
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<EntpAppVersionMagePageListVo>> findPageList(@RequestBody EntpAppVersionMagePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 逻辑删除EntpAppVersionMage
     */
    @DataCheck
    @PreAuthorize("hasAuthority('im:apv')")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 新增或修改EntpAppVersionMage
     */
    @DataCheck
    @PreAuthorize("hasAuthority('im:apv')")
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody EntpAppVersionMagePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 查询详细信息EntpAppVersionMage
     */
    @DataCheck
    @PreAuthorize("hasAuthority('im:apv')")
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<EntpAppVersionMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    @DataCheck
    @RequestMapping(value = "/findLatest", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询最新版本", value = "查询最新版本", notes = "查询最新版本", httpMethod = "POST")
    public ResultPoJo<EntpAppVersionMageInfoVo> findLatest(@RequestBody AppVersionPo po) {
        return service.findLatest(po);
    }

    @ApiOperation(value = "批量删除")
    @PreAuthorize("hasAuthority('im:apv')")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo batDelete(@RequestBody LongIdsPo po) {
        return service.batDelete(po);
    }
}
