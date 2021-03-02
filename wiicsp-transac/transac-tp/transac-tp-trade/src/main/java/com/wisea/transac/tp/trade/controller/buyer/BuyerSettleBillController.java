package com.wisea.transac.tp.trade.controller.buyer;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.trade.*;
import com.wisea.transac.common.vo.SettleBillInvoInfoVo;
import com.wisea.transac.tp.trade.service.SettleBillService;
import com.wisea.transac.common.vo.trade.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *结算单管理Controller
 * @author yangtao
 *
 */
@Api(tags = "【买家】结算单管理接口")
@RestController
@RequestMapping("/w/buyer/settleBill")
public class BuyerSettleBillController {

    @Autowired
    private SettleBillService service;

    /**
     * 买家授权账期列表
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value="/apPayMageSupplyList",method=RequestMethod.POST)
    @ApiOperation(nickname = "买家授权账期列表", value="【结算单】授权账期列表", notes="授权账期列表", httpMethod = "POST")
    public ResultPoJo<Page<BuyerApPayMageListVo>> apPayMageSupplyList (@RequestBody BuyerApPayListPo po) {

        return service.apPayMageSupplyList(po);
    }

    /**
     * 买家查询结算单列表
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家查询结算单列表", value = "【结算单】买家查询结算单列表", notes = "买家查询结算单列表", httpMethod = "POST")
    public ResultPoJo<Page<BuyerSettleBillListVo>> buyerSettlList (@RequestBody BuyerSettleBillListPo po) {

        return service.buyerSettlList(po);
    }

    /**
     * 买家查询结算单列表角标
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/list/num", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家查询结算单列表角标", value = "【结算单】买家查询结算单列表角标", notes = "买家查询结算单列表角标", httpMethod = "POST")
    public ResultPoJo<List<OrderListNumVo>> buyerSettleListNum (@RequestBody BuyerSettleBillListPo po) {

        return service.buyerSettleListNum(po);
    }

    /**
     * 买家查询结算单详情
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家查询结算单详情", value = "【结算单】买家查询结算单详情", notes = "买家查询结算单详情", httpMethod = "POST")
    public ResultPoJo<SettleBillInfoVo> findInfo (@RequestBody LongIdPo po) {

        return service.findInfo(po);
    }

    /**
     * 买家查询未出账单列表
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/notSettleList", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家查询未出账单列表", value = "【结算单】买家查询未出账单列表", notes = "买家查询未出账单列表", httpMethod = "POST")
    public ResultPoJo<List<BuyerNotSettleListVo>> buyerNotSettleList (@RequestBody BuyerNotSettleListPo po) {

        return service.buyerNotSettleList(po);
    }

    /**
     * 买家对账
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/recoSettleBill", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家对账", value = "【结算单】买家对账", notes = "买家对账", httpMethod = "POST")
    public ResultPoJo<Object> recoSettleBill (@RequestBody InvoApplPo po) {

        return service.recoSettleBill(po);
    }

    /**
     * 买家对账校验
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/recoSettleBillCheck", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家对账校验", value = "【结算单】买家对账校验", notes = "买家对账校验", httpMethod = "POST")
    public ResultPoJo<Object> recoSettleBillCheck (@RequestBody InvoApplPo po) {

        return service.recoSettleBillCheck(po);
    }

    /**
     * 取消结算单
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/buyerCancelSettle", method = RequestMethod.POST)
    @ApiOperation(nickname = "取消结算单", value = "【结算单】取消结算单", notes = "取消结算单", httpMethod = "POST")
    public ResultPoJo<?> cancelSettleBill(@RequestBody LongIdPo po) {
        return service.cancelSettleBill(po);
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
     * 查询发票详情
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/settleInvoInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询发票详情(传发票ID)", value = "【结算单】查询发票详情(传发票ID)", notes = "查询发票详情(传发票ID)", httpMethod = "POST")
    public ResultPoJo<SettleBillInvoInfoVo> settleInvoInfo(@RequestBody LongIdPo po) {
        return service.settleInvoInfo(po);
    }

    /**
     * 买家提前生成结算单
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/preSettle", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家提前生成结算单", value = "【结算单】买家提前生成结算单", notes = "买家提前生成结算单", httpMethod = "POST")
    public ResultPoJo<Object> preSettle (@RequestBody PreSettleApplPo po) {
        return service.preSettle(po);
    }

    /**
     * 买家提前生成结算单校验
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/preSettleCheck", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家提前生成结算单校验", value = "【结算单】买家提前生成结算单校验", notes = "买家提前生成结算单校验", httpMethod = "POST")
    public ResultPoJo<Object> preSettleCheck (@RequestBody PreSettleApplPo po) {
        return service.preSettleCheck(po);
    }

    /**
     * 账期去支付详情页
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/settlePayInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "账期去支付详情页", value = "【结算单】账期去支付详情页", notes = "账期去支付详情页", httpMethod = "POST")
    public ResultPoJo<ToPaySettleInfoVo> settlePayInfo (@RequestBody LongIdPo po) {
        return service.settlePayInfo(po);
    }

    /**
     * 验票
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/examSettleInvo", method = RequestMethod.POST)
    @ApiOperation(nickname = "验票(传账期ID)", value = "【结算单】验票(传账期ID)", notes = "验票(传账期ID)", httpMethod = "POST")
    public ResultPoJo<Object> examSettleInvo (@RequestBody LongIdPo po) {
        return service.examSettleInvo(po);
    }

    /**
     * 验票异议
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/settleDissent", method = RequestMethod.POST)
    @ApiOperation(nickname = "验票异议", value = "【结算单】验票异议", notes = "验票异议", httpMethod = "POST")
    public ResultPoJo<Object> settleDissent (@RequestBody ExamInvoDissPo po) {
        return service.settleDissent(po);
    }
}
