package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.CommCurrencyInfoPageListPo;
import com.wisea.transac.common.po.CommCurrencyInfoPo;
import com.wisea.transac.common.vo.CommCurrencyInfoInfoVo;
import com.wisea.transac.common.vo.CommCurrencyInfoPageListVo;
import com.wisea.transac.tp.system.service.CommCurrencyInfoService;
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
 * @className CommCurrencyInfoController
 * @date 2020/05/11 14:30:27
 * @Description
 */
@RestController
@RequestMapping("/w/CommCurrencyInfo")
@Api(tags = "商品通用信息管理")
public class CommCurrencyInfoController {
    @Autowired
    private CommCurrencyInfoService service;

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 14:30:27
     * @Description 分页查询CommCurrencyInfo
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<CommCurrencyInfoPageListVo>> findPageList(@RequestBody CommCurrencyInfoPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 14:30:27
     * @Description 逻辑删除CommCurrencyInfo
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 14:30:27
     * @Description 新增或修改CommCurrencyInfo
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody CommCurrencyInfoPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 14:30:27
     * @Description 查询详细信息CommCurrencyInfo
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<CommCurrencyInfoInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }


    @DataCheck
    @RequestMapping(value = "/set", method = RequestMethod.POST)
    @ApiOperation(nickname = "修改默认", value = "修改默认", notes = "修改默认", httpMethod = "POST")
    public ResultPoJo set(@RequestBody CommCurrencyInfoPo po) {
        return service.set(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 14:30:27
     * @Description 查询详细信息CommCurrencyInfo
     */
    @DataCheck
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询默认", value = "查询默认", notes = "查询默认", httpMethod = "POST")
    public ResultPoJo<CommCurrencyInfoInfoVo> get() {
        return service.findDetail();
    }
}
