package com.wisea.transac.tp.trade.controller.seller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.SettleBillPageListPo;
import com.wisea.transac.common.po.trade.HandleSissentPo;
import com.wisea.transac.common.po.trade.ReconcListPo;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.SettleBillPageListVo;
import com.wisea.transac.common.vo.trade.SettleBillInfoVo;
import com.wisea.transac.common.vo.trade.SettleOrdRelaInfoVo;
import com.wisea.transac.tp.trade.service.SettleBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SettleBillController
 * @date 2020/04/27 17:01:29
 * @Description 结算单管理
 */
@Api(tags = "【卖家/市场】结算单管理接口")
@RestController
@RequestMapping("/w/seller/settleBill")
public class SettleBillController {
    @Autowired
    private SettleBillService service;

    /**
     *
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询结算单列表", value = "分页查询结算单列表", notes = "分页查询结算单列表", httpMethod = "POST")
    public ResultPoJo<PageStateCountResultVo<SettleBillPageListVo>> findPageList(@RequestBody SettleBillPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/14 16:03
     * @Description 查询结算单详细信息
     **/
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询结算单详细信息", value = "查询结算单详细信息", notes = "查询结算单详细信息", httpMethod = "POST")
    public ResultPoJo<SettleBillInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/15 14:48
     * @Description 取消结算单
     **/
    @DataCheck
    @RequestMapping(value = "/cancelSettleBill", method = RequestMethod.POST)
    @ApiOperation(nickname = "取消结算单", value = "取消结算单", notes = "取消结算单", httpMethod = "POST")
    public ResultPoJo<?> cancelSettleBill(@RequestBody LongIdPo po) {
        return service.cancelSettleBill(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/15 14:48
     * @Description 卖家确认对账
     **/
    @DataCheck
    @RequestMapping(value = "/sellerRecon", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家确认对账", value = "卖家确认对账", notes = "卖家确认对账", httpMethod = "POST")
    public ResultPoJo<?> sellerReco(@RequestBody LongIdPo po) {
        return service.sellerReco(po);
    }

    /**
     * 对账异议
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/reconDissent", method = RequestMethod.POST)
    @ApiOperation(nickname = "对账异议", value = "【结算单】对账异议", notes = "对账异议", httpMethod = "POST")
    public ResultPoJo<Object> reconDissent(@RequestBody LongIdPo po) {
        return service.reconDissent(po);
    }


    /**
     * @author jirg
     * @date 2020/8/25 15:19
     * @Description 提醒买家支付
     */
    @DataCheck
    @RequestMapping(value = "/remindPay", method = RequestMethod.POST)
    @ApiOperation(nickname = "提醒买家支付", value = "提醒买家支付", notes = "提醒买家支付", httpMethod = "POST")
    public ResultPoJo<?> remindPay(@RequestBody LongIdPo po) {
        return service.remindPay(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/18 14:35
     * @Description 【后台】查询对账异议列表
     **/
    @DataCheck
    @RequestMapping(value = "/findReconcList", method = RequestMethod.POST)
    @ApiOperation(nickname = "【后台】查询对账异议列表", value = "【后台】查询对账异议列表", notes = "【后台】查询对账异议列表", httpMethod = "POST")
    public ResultPoJo<Page<SettleBillPageListVo>> findReconcList(@RequestBody ReconcListPo po) {
        return service.findReconcList(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/18 14:35
     * @Description 【后台】查询未出账订单列表
     **/
    @DataCheck
    @RequestMapping(value = "/findUnsettlementList", method = RequestMethod.POST)
    @ApiOperation(nickname = "【后台】查询未出账订单列表", value = "【后台】查询未出账订单列表", notes = "【后台】查询未出账订单列表", httpMethod = "POST")
    public ResultPoJo<List<SettleOrdRelaInfoVo>> findUnsettlementList(@RequestBody LongIdPo po) {
        return service.findUnsettlementList(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/18 14:35
     * @Description 【后台】处理对账异议
     **/
    @DataCheck
    @RequestMapping(value = "/handleSissent", method = RequestMethod.POST)
    @ApiOperation(nickname = "【后台】处理对账异议", value = "【后台】处理对账异议", notes = "【后台】处理对账异议", httpMethod = "POST")
    public ResultPoJo<?> handleSissent(@RequestBody HandleSissentPo po) {
        return service.handleSissent(po);
    }

    /**
     * @Author jirg
     * @Date 2019/4/29 17:32
     * @Description 手动调用结算单定时任务
     **/
    @RequestMapping(value = "/startSettleBillTask", method = RequestMethod.POST)
    public ResultPoJo<?> startSettleBillTask(){
        return service.settleBillTask();
    }
}
