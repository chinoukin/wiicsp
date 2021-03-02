package com.wisea.cultivar.supply.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.OrdCancelReasonMageMapper;
import com.wisea.cultivar.common.vo.trade.OrdCancelReasonMageListVo;
import com.wisea.cultivar.supply.po.*;
import com.wisea.cultivar.supply.service.SerListService;
import com.wisea.cultivar.supply.util.CustomUtils;
import com.wisea.cultivar.supply.vo.SerCountVo;
import com.wisea.cultivar.supply.vo.SerDetailsVo;
import com.wisea.cultivar.supply.vo.SerListVo;
import com.wisea.cultivar.supply.vo.SerOpreateInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务单
 * @author chengq
 * @date 2020/8/16 8:56
 */
@RestController
@Api(tags = "APP管理-供应端-服务单")
@RequestMapping(value = "/w/ser")
public class SerListController {

    @Resource
    private SerListService serListService;

    @Resource(name = "NbOrdCancelReasonMageMapper")
    private OrdCancelReasonMageMapper ordCancelReasonMageMapper;

    /**
     * 商品状态数量
     */
    @GetMapping("count")
    @ApiOperation(value = "服务单状态数量")
    public ResultPoJo<SerCountVo> commCount() {
        return serListService.serCount();
    }

    /**
     * 服务单列表
     */
    @DataCheck
    @PostMapping("list")
    @ApiOperation(value = "服务单列表")
    public ResultPoJo<Page<SerListVo>> findSerList(@RequestBody SerListPo serListPo) {
        return serListService.findSerList(serListPo);
    }

    /**
     * 服务单详情
     */
    @DataCheck
    @PostMapping("details")
    @ApiOperation(value = "服务单详情")
    public ResultPoJo<SerDetailsVo> findSerDetails(@RequestBody SerGetPo serGetPo) {
        return serListService.findSerDetails(serGetPo);
    }

    /**
     * 服务单日志
     */
    @DataCheck
    @PostMapping("log")
    @ApiOperation(value = "服务单日志")
    public ResultPoJo<SerOpreateInfoVo> findSerLog(@RequestBody SerGetPo serGetPo) {
        return serListService.findSerLog(serGetPo);
    }

    /**
     * 修改价格
     */
    @DataCheck
    @PostMapping("save/price")
    @ApiOperation(value = "修改价格")
    public ResultPoJo<Object> savePrice(@RequestBody SerUpdatePricePo serUpdatePricePo) {
        return serListService.savePrice(serUpdatePricePo);
    }

    /**
     * 修改预约信息
     */
    @DataCheck
    @PostMapping("save/subscribe")
    @ApiOperation(value = "修改预约信息")
    public ResultPoJo<Object> saveSubscribe(@RequestBody SerUpdateSubscribePo subscribePo) {
        return serListService.saveSubscribe(subscribePo);
    }

    /**
     * 修改状态
     */
    @DataCheck
    @PostMapping("save/state")
    @ApiOperation(value = "修改状态")
    public ResultPoJo<Object> saveState(@RequestBody SerUpdateStatePo serUpdateStatePo) {
        return serListService.saveState(serUpdateStatePo);
    }

    /**
     * 修改状态
     */
    @DataCheck
    @GetMapping("reason/list")
    @ApiOperation(value = "取消原因列表")
    public ResultPoJo<List<OrdCancelReasonMageListVo>> findAllReason() {
        return CustomUtils.result(ordCancelReasonMageMapper.findAllReason());
    }

}
