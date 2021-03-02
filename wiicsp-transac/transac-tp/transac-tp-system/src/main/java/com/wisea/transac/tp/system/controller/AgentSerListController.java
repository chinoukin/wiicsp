package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.AgentSerListPageListPo;
import com.wisea.transac.common.po.AgentSerListPo;
import com.wisea.transac.common.vo.AgentSerListInfoVo;
import com.wisea.transac.common.vo.AgentSerListPageListVo;
import com.wisea.transac.tp.system.service.AgentSerListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className AgentSerListController
 * @date 2020/04/27 17:01:29
 * @Description
 */
/*@RestController
@RequestMapping("/w/AgentSerList")
@Api(tags = "商家服务管理")
public class AgentSerListController {
    @Autowired
    private AgentSerListService service;

    *//**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询AgentSerList
     *//*
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<AgentSerListPageListVo>> findPageList(@RequestBody AgentSerListPageListPo po) {
        return service.findPageList(po);
    }

    *//**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除AgentSerList
     *//*
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    *//**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改AgentSerList
     *//*
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody AgentSerListPo po) {
        return service.saveOrUpdate(po);
    }

    *//**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息AgentSerList
     *//*
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<AgentSerListInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }
}*/
