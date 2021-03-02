package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.ItemConfigurePageListPo;
import com.wisea.transac.common.po.ItemConfigurePo;
import com.wisea.transac.common.vo.ItemConfigureInfoVo;
import com.wisea.transac.common.vo.ItemConfigurePageListVo;
import com.wisea.transac.tp.system.service.ItemConfigureService;
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
 * @className ItemConfigureController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@RestController
@RequestMapping("/w/ItemConfigure")
@Api(tags = "项目配置")
public class ItemConfigureController {
    @Autowired
    private ItemConfigureService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询ItemConfigure
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<ItemConfigurePageListVo>> findPageList(@RequestBody ItemConfigurePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除ItemConfigure
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
     * @Description 新增或修改ItemConfigure
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody ItemConfigurePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息ItemConfigure
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<ItemConfigureInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    @DataCheck
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询默认", value = "查询默认", notes = "查询默认", httpMethod = "POST")
    public ResultPoJo<ItemConfigureInfoVo> get() {
        return service.findInfo();
    }

    @DataCheck
    @RequestMapping(value = "/set", method = RequestMethod.POST)
    @ApiOperation(nickname = "设置默认", value = "设置默认", notes = "设置默认", httpMethod = "POST")
    public ResultPoJo set(@RequestBody ItemConfigurePo po) {
        return service.set(po);
    }

}
