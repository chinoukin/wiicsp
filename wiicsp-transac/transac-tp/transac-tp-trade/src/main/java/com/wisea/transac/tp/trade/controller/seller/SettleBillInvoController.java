package com.wisea.transac.tp.trade.controller.seller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.SettleBillInvoPageListPo;
import com.wisea.transac.common.po.trade.InvoicingPo;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.SettleBillInvoInfoVo;
import com.wisea.transac.common.vo.SettleBillInvoPageListVo;
import com.wisea.transac.tp.trade.service.SettleBillInvoService;
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
 * @className SettleBillInvoController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Api(tags = "【卖家】结算发票单管理接口")
@RestController
@RequestMapping("/w/seller/settleInvo")
public class SettleBillInvoController {
    @Autowired
    private SettleBillInvoService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SettleBillInvo
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<PageStateCountResultVo<SettleBillInvoPageListVo>> findPageList(@RequestBody SettleBillInvoPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/15 17:08
     * @Description 查询结算单发票详细信息
     **/
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<SettleBillInvoInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/18 9:34
     * @Description 结算单开票
     **/
    @DataCheck
    @RequestMapping(value = "/invoicing", method = RequestMethod.POST)
    @ApiOperation(nickname = "结算单开票", value = "结算单开票", notes = "结算单开票", httpMethod = "POST")
    public ResultPoJo<?> invoicing(@RequestBody InvoicingPo po) {
        return service.invoicing(po);
    }
}
