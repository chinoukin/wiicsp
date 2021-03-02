package com.wisea.transac.tp.trade.controller.seller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.EnableDisablePo;
import com.wisea.transac.common.po.trade.ApPayMagePageListPo;
import com.wisea.transac.common.po.trade.ApPayMagePo;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.trade.ApPayMageInfoVo;
import com.wisea.transac.common.vo.trade.ApPayMagePageListVo;
import com.wisea.transac.tp.trade.service.ApPayMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jirg
 * @Date 2020/5/12 15:55
 * @Description 账期支付设置
 **/
@Api(tags = "【卖家】账期支付设置接口")
@RestController
@RequestMapping("/w/seller/apPay")
public class ApPayMageController {
    @Autowired
    private ApPayMageService service;

    /**
     * @Author jirg
     * @Date 2020/5/12 9:40
     * @Description 开通账期支付
     **/
    @DataCheck
    @RequestMapping(value = "/openApPay", method = RequestMethod.POST)
    @ApiOperation(nickname = "开通账期支付", value = "开通账期支付", notes = "开通账期支付", httpMethod = "POST")
    public ResultPoJo<?> openApPay() {
        return service.openApPay();
    }


    /**
     * @Author jirg
     * @Date 2020/5/12 14:39
     * @Description 分页查询账期设置列表
     **/
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询账期设置列表", value = "分页查询账期设置列表", notes = "分页查询账期设置列表", httpMethod = "POST")
    public ResultPoJo<PageStateCountResultVo<ApPayMagePageListVo>> findPageList(@RequestBody ApPayMagePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/12 15:14
     * @Description 查询账期设置信息信息
     **/
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询账期设置信息信息", value = "查询账期设置信息信息", notes = "查询账期设置信息信息", httpMethod = "POST")
    public ResultPoJo<ApPayMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/12 15:21
     * @Description 新增或修改账期设置
     **/
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改账期设置", value = "新增或修改账期设置", notes = "新增或修改账期设置", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody ApPayMagePo po) {
        return service.saveOrUpdate(po);
    }


    /**
     * @Author jirg
     * @Date 2020/5/12 15:52
     * @Description 冻结/停用账期设置
     **/
    @DataCheck
    @RequestMapping(value = "/enableDisable", method = RequestMethod.POST)
    @ApiOperation(nickname = "冻结/停用账期设置", value = "冻结/停用账期设置", notes = "冻结/停用账期设置", httpMethod = "POST")
    public ResultPoJo enableDisable(@RequestBody EnableDisablePo po) {
        return service.enableDisable(po);
    }

}
