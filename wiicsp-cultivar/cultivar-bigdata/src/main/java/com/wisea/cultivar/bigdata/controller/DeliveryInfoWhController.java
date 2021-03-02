package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhGetPo;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhListPo;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhPagePo;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhUpdatePo;
import com.wisea.cultivar.bigdata.service.DeliveryInfoWhService;
import com.wisea.cultivar.common.vo.bigdata.DeliveryInfoWhGetVo;
import com.wisea.cultivar.common.vo.bigdata.DeliveryInfoWhListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * DeliveryInfoWhController
 * 配送信息维护 Controller
 * 2019/12/02 11:02:14
 */
@Api(tags = "配送信息维护相关接口")
@RequestMapping(value = "/w/deliveryInfoWh")
@RestController
public class DeliveryInfoWhController {
    @Autowired
    protected DeliveryInfoWhService deliveryInfoWhService;

    @ApiOperation(value = "获取配送信息维护分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<DeliveryInfoWhListVo>> findPage(@RequestBody DeliveryInfoWhPagePo deliveryInfoWhPagePo) {
        return deliveryInfoWhService.findPage(deliveryInfoWhPagePo);
    }

    @ApiOperation(value = "获取配送信息维护列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<DeliveryInfoWhListVo>> list(@RequestBody DeliveryInfoWhListPo deliveryInfoWhListPo) {
        return deliveryInfoWhService.findList(deliveryInfoWhListPo);
    }

    @ApiOperation(value = "查询配送信息维护")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<DeliveryInfoWhGetVo> get(@RequestBody DeliveryInfoWhGetPo deliveryInfoWhGetPo) {
        return deliveryInfoWhService.get(deliveryInfoWhGetPo);
    }

    @ApiOperation(value = "查询配送信息维护根据分公司id")
    @RequestMapping(value = "getByid", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<DeliveryInfoWhGetVo> getByid(@RequestBody DeliveryInfoWhGetPo deliveryInfoWhGetPo) {
    	return deliveryInfoWhService.getByid(deliveryInfoWhGetPo);
    }

/*    @ApiOperation(value = "新增配送信息维护")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody DeliveryInfoWhInsertPo deliveryInfoWhInsertPo) {
        return deliveryInfoWhService.insert(deliveryInfoWhInsertPo);
    }
*/
    @ApiOperation(value = "修改配送信息维护")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody DeliveryInfoWhUpdatePo deliveryInfoWhUpdatePo) {
        return deliveryInfoWhService.update(deliveryInfoWhUpdatePo);
    }


    @ApiOperation(value = "批量删除配送信息维护")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody DeliveryInfoWhBatDeletePo deliveryInfoWhBatDeletePo) {
        return deliveryInfoWhService.batDelete(deliveryInfoWhBatDeletePo);
    }

}
