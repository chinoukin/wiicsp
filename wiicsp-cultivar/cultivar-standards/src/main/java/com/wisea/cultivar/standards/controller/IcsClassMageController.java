package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.service.IcsClassMageService;
import com.wisea.cultivar.standards.vo.IcsClassMageGetVo;
import com.wisea.cultivar.standards.vo.IcsClassMageListVo;
import com.wisea.cultivar.standards.vo.IcsClassMageTreeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * IcsClassMageController
 * ICS分类管理 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "ICS分类管理相关接口")
@RequestMapping(value = "/w/IcsClassMage")
@PreAuthorize("hasAuthority('st:ics')")
@RestController
public class IcsClassMageController {
    @Autowired
    protected IcsClassMageService icsClassMageService;

    @ApiOperation(value = "获取ICS分类管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<IcsClassMageListVo>> findPage(@RequestBody IcsClassMagePagePo icsClassMagePagePo) {
        return icsClassMageService.findPage(icsClassMagePagePo);
    }

    @ApiOperation(value = "获取ICS分类管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<IcsClassMageListVo>> list(@RequestBody IcsClassMageListPo icsClassMageListPo) {
        return icsClassMageService.findList(icsClassMageListPo);
    }

    @ApiOperation(value = "查询ICS分类管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<IcsClassMageGetVo> get(@RequestBody IcsClassMageGetPo icsClassMageGetPo) {
        return icsClassMageService.get(icsClassMageGetPo);
    }

    @ApiOperation(value = "新增ICS分类管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody IcsClassMageInsertPo icsClassMageInsertPo) {
        return icsClassMageService.insert(icsClassMageInsertPo);
    }

    @ApiOperation(value = "修改ICS分类管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody IcsClassMageUpdatePo icsClassMageUpdatePo) {
        return icsClassMageService.update(icsClassMageUpdatePo);
    }

    @ApiOperation(value = "删除ICS分类管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody IcsClassMageBatDeletePo icsClassMageBatDeletePo) {
        return icsClassMageService.batDelete(icsClassMageBatDeletePo);
    }
    @ApiOperation(value = "树形结构数据")
    @RequestMapping(value = "getTreeVue",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<IcsClassMageTreeVo>> icsClassMageGetTree(@RequestBody IcsClassMageTreePo icsClassMageTreePo){
        return icsClassMageService.icsClassMageGetTree(icsClassMageTreePo);
    }
    @ApiOperation(value = "异步加载ICS分类")
    @RequestMapping(value = "asyTreeVue",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<IcsClassMageTreeVo>> asyTreeVue(@RequestBody IcsClassMageTreeVo chinaStandardTypeMageTreeVo){
        ResultPoJo<List<IcsClassMageTreeVo>> resultPoJo = new ResultPoJo<List<IcsClassMageTreeVo>>();
        List<IcsClassMageTreeVo> icsClassMageTreeVo = icsClassMageService.asyTreeVue(chinaStandardTypeMageTreeVo);
        resultPoJo.setResult(icsClassMageTreeVo);
        return resultPoJo;
    }
    @ApiOperation(value = "异步加载ICS分类返回上一级")
    @RequestMapping(value = "asyTreeVuePS",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<IcsClassMageTreeVo>> asyTreeVuePS(@RequestBody IcsClassMageTreeVo chinaStandardTypeMageTreeVo){
        ResultPoJo<List<IcsClassMageTreeVo>> resultPoJo = new ResultPoJo<List<IcsClassMageTreeVo>>();
        List<IcsClassMageTreeVo> icsClassMageTreeVo = icsClassMageService.asyTreeVuePS(chinaStandardTypeMageTreeVo);
        resultPoJo.setResult(icsClassMageTreeVo);
        return resultPoJo;
    }
}
