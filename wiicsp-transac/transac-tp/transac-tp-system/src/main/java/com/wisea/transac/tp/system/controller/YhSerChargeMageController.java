package com.wisea.transac.tp.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.po.system.YhSerChargeMageGetPo;
import com.wisea.transac.common.po.system.YhSerChargeMagePagePo;
import com.wisea.transac.common.po.system.YhSerChargeMagePo;
import com.wisea.transac.common.po.system.YhSerChargeStatePo;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.memb.MembEntpInfoListVo;
import com.wisea.transac.common.vo.system.YhSerChargeMageGetVo;
import com.wisea.transac.common.vo.system.YhSerChargeMageListVo;
import com.wisea.transac.tp.system.service.YhSerChargeMageService;
import com.wisea.transac.tp.system.service.memb.MembBackService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Description: 优惠服务费控制类
 * @author: wangs
 * @date :2019/5/16
 */
@Api(tags = "【后台设置】优惠服务费,调用接口")
@RestController
@RequestMapping("/w/yhserchargemage")
public class YhSerChargeMageController {

    @Autowired
    YhSerChargeMageService yhSerChargeMageService;
    @Autowired
    private MembBackService membBackService;

    /**
     * 查询优惠服务费列表
     *
     * @param yhSerChargeMagePagePo
     * @return
     */
    @ApiOperation(value = "查询优惠服务费列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultPoJo<PageStateCountResultVo<YhSerChargeMageListVo>> list(@RequestBody YhSerChargeMagePagePo yhSerChargeMagePagePo) {
        return yhSerChargeMageService.list(yhSerChargeMagePagePo);

    }

    /**
     * 查询会员列表,已认证的卖家信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年7月1日
     * @version 1.0
     */
    @ApiOperation(value = "查询会员列表,已认证的卖家信息", httpMethod = "POST")
    @PostMapping(value = "/findEntpListForSerList")
    public ResultPoJo<List<MembEntpInfoListVo>> findEntpListForSerList(@RequestBody YhSerChargeMagePagePo yhSerChargeMagePagePo) {
    	// 返回初期化处理
        ResultPoJo<List<MembEntpInfoListVo>> poJo = new ResultPoJo<List<MembEntpInfoListVo>>(ConstantCodeMsg.NOMAL);
        List<MembEntpInfoListVo> entpListForSer = membBackService.findEntpListForSer();
        poJo.setResult(entpListForSer);
        return poJo;

    }

    /**
     * 保存修改优惠服务费信息
     *
     * @param yhSerChargeMagePo
     * @return
     */
    @ApiOperation(value = "保存修改优惠服务费信息", httpMethod = "POST")
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo saveOrUpdate(@RequestBody YhSerChargeMagePo yhSerChargeMagePo) {
        ResultPoJo<String> resultPoJo = yhSerChargeMageService.saveOrUpdate(yhSerChargeMagePo);
        return resultPoJo;
    }


    /**
     * 优惠服务费编辑详情
     *
     * @param
     * @return
     */
    @ApiOperation(value = "优惠服务费编辑详情", httpMethod = "POST")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResultPoJo<YhSerChargeMageGetVo> get(@RequestBody YhSerChargeMageGetPo yhSerChargeMageGetPo) {
        return yhSerChargeMageService.get(yhSerChargeMageGetPo);
    }

    /**
     * 改变优惠手续费状态
     *
     * @param
     * @return
     */
    @ApiOperation(value = "改变优惠手续费状态", httpMethod = "POST")
    @RequestMapping(value = "/changeState", method = RequestMethod.POST)
    public ResultPoJo changeState(@RequestBody YhSerChargeStatePo yhSerChargeStatePo) {
        return yhSerChargeMageService.changeState(yhSerChargeStatePo);
    }
}
