package com.wisea.cultivar.seedlings.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.tp.LongIdPo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoBatDeletePo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoGetPo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoInsertPo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoListPo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoPagePo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoUpdatePo;
import com.wisea.cultivar.seedlings.service.BuySproutInfoService;
import com.wisea.cultivar.seedlings.vo.BuySproutInfoGetVo;
import com.wisea.cultivar.seedlings.vo.BuySproutInfoListVo;
import com.wisea.cultivar.seedlings.vo.SeedlingsProVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * BuySproutInfoController
 * 购苗信息 Controller
 * 2020/08/06 14:19:24
 */
@Api(tags = "购苗信息相关接口")
@RequestMapping(value = "/w/BuySproutInfo")
@RestController
public class BuySproutInfoController {
    @Autowired
    protected BuySproutInfoService buySproutInfoService;

    @ApiOperation(value = "获取购苗信息分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<BuySproutInfoListVo>> findPage(@RequestBody BuySproutInfoPagePo buySproutInfoPagePo) {
        return buySproutInfoService.findPage(buySproutInfoPagePo);
    }

    @ApiOperation(value = "获取购苗信息列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<BuySproutInfoListVo>> list(@RequestBody BuySproutInfoListPo buySproutInfoListPo) {
        return buySproutInfoService.findList(buySproutInfoListPo);
    }

    @ApiOperation(value = "查询购苗信息")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<BuySproutInfoGetVo> get(@RequestBody BuySproutInfoGetPo buySproutInfoGetPo) {
        return buySproutInfoService.get(buySproutInfoGetPo);
    }

    @ApiOperation(value = "新增购苗信息")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody BuySproutInfoInsertPo buySproutInfoInsertPo) {
        return buySproutInfoService.insert(buySproutInfoInsertPo);
    }

    @ApiOperation(value = "修改购苗信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody BuySproutInfoUpdatePo buySproutInfoUpdatePo) {
        return buySproutInfoService.update(buySproutInfoUpdatePo);
    }

    @ApiOperation(value = "批量删除购苗信息")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody BuySproutInfoBatDeletePo buySproutInfoBatDeletePo) {
        return buySproutInfoService.batDelete(buySproutInfoBatDeletePo);
    }

    @ApiOperation(value = "种植户购苗占比")
    @RequestMapping(value = "porSeedling", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SeedlingsProVo>> porSeedling(@RequestBody LongIdPo longIdPo) {
        return buySproutInfoService.porSeedling(longIdPo.getId());
    }


}
