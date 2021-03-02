package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.system.MrSerChargeMagePo;
import com.wisea.transac.common.po.system.MrSerChargeMageGetPo;
import com.wisea.transac.common.po.system.MrSerChargeMagePagePo;
import com.wisea.transac.common.po.system.MrSerChargeStatePo;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.system.MrSerChargeMageGetVo;
import com.wisea.transac.common.vo.system.MrSerChargeMageListVo;
import com.wisea.transac.tp.system.service.MrSerChargeMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 默认服务费控制类
 * @author: wangs
 * @date :2019/5/15
 */
@Api(tags = "【后台设置】默认服务费,调用接口")
@RestController
@RequestMapping("/w/serviceCharge")
public class MrSerChargeMageController {


    @Autowired
    MrSerChargeMageService mrServiceChargeService;


    /**
     * 查询默认服务费列表
     *
     * @param mrSerChargeMagePagePo
     * @return
     */
    @ApiOperation(value = "查询默认服务费列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultPoJo<PageStateCountResultVo<MrSerChargeMageListVo>> list(@RequestBody MrSerChargeMagePagePo mrSerChargeMagePagePo) {
        return mrServiceChargeService.list(mrSerChargeMagePagePo);

    }

    /**
     * 保存修改默认服务费信息
     *
     * @param mrSerChargeMagePo
     * @return
     */
    @ApiOperation(value = "保存修改默认服务费信息", httpMethod = "POST")
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo saveOrUpdate(@RequestBody MrSerChargeMagePo mrSerChargeMagePo) {
        ResultPoJo<String> resultPoJo = mrServiceChargeService.saveOrUpdate(mrSerChargeMagePo);
        return resultPoJo;
    }

    /**
     * 默认服务费编辑
     *
     * @param
     * @return
     */
    @ApiOperation(value = "默认服务费编辑", httpMethod = "POST")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResultPoJo<MrSerChargeMageGetVo> get(@RequestBody MrSerChargeMageGetPo mrSerChargeMageGetPo) {
        return mrServiceChargeService.get(mrSerChargeMageGetPo);

    }

    /**
     * 改变默认手续费状态
     *
     * @param
     * @return
     */
    @ApiOperation(value = "改变默认手续费状态", httpMethod = "POST")
    @RequestMapping(value = "/changeState", method = RequestMethod.POST)
    public ResultPoJo changeState(@RequestBody MrSerChargeStatePo mrSerChargeStatePo) {
        return mrServiceChargeService.changeState(mrSerChargeStatePo);

    }
}
