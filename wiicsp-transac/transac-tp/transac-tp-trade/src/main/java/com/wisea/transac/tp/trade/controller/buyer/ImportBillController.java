package com.wisea.transac.tp.trade.controller.buyer;

import java.util.List;

import com.wisea.transac.common.po.trade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.vo.trade.BuyerGeneratingOrderVo;
import com.wisea.transac.common.vo.trade.BuyerPreOrderCommInfoVo;
import com.wisea.transac.common.vo.trade.BuyerUpdateCountVo;
import com.wisea.transac.common.vo.trade.ImportListVo;
import com.wisea.transac.tp.trade.service.ImportBillService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author yangtao
 * @version 1.0
 * @className ImportBillController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Api(tags = "【买家】进货单管理接口")
@RestController
@RequestMapping("/w/ImportBill")
public class ImportBillController {
    @Autowired
    private ImportBillService service;


    /**
     * 商品加入进货单
     * @param
     * @return
     */
    @ApiOperation(value="商品加入购货单", notes="商品加入购货单")
    @RequestMapping(value="/insertToImportBill",method=RequestMethod.POST)
    @DataCheck
    public ResultPoJo<String> insertToImportBill(@RequestBody BuyerInsertToImportBillPo po) {
        return service.insertToImportBill(po);
    }

    /**
     * 批量删除选中的商品
     * @param
     * @return
     */
    @ApiOperation(value="删除进货单商品", notes="删除进货单商品")
    @RequestMapping(value="/deleteManyImportBill",method=RequestMethod.POST)
    @DataCheck
    public ResultPoJo<String> deleteManyImportBill(@RequestBody BuyerDeleManyImportBillPo po) {
        return service.deleteManyImportBill(po);
    }

    /**
     * 修改进货单中的商品数量
     * @param po
     * @return
     */
    @ApiOperation(value="修改进货单中的商品数量", notes="修改进货单中的商品数量")
    @RequestMapping(value="/updateCommPubInfoCount",method=RequestMethod.POST)
    @DataCheck
    public ResultPoJo<BuyerUpdateCountVo> updateCommPubInfoCount(@RequestBody BuyerUpdateCommPubInfoCountPo po) {
        return service.updateCommPubInfoCount(po);
    }

    /**
     * 进货单 商品的列表
     * @param
     * @return
     */
    @ApiOperation(value="进货单 商品的列表(传transType数据字段)", notes="进货单 商品的列表(传transType数据字段)")
    @RequestMapping(value="/commInfoListFromImpBill",method=RequestMethod.POST)
    public ResultPoJo<List<ImportListVo>> commInfoListFromImpBill(@RequestBody ImportListPo po) {
        return service.commInfoListFromImpBill(po);
    }

    /**
     * 进货单商品数量角标
     * @param
     * @return
     */
    @ApiOperation(value="进货单商品数量角标", notes="进货单商品数量角标")
    @RequestMapping(value="/commInfoListNum",method=RequestMethod.POST)
    @DataCheck
    public ResultPoJo<String> commInfoListNum() {
        return service.commInfoListNum();
    }

    /**
     *立即购买校验
     * @param
     * @return
     */
    @ApiOperation(value="立即购买校验", notes="立即购买校验")
    @RequestMapping(value="/preOrderChack",method=RequestMethod.POST)
    public ResultPoJo<Object> preOrderChack(@RequestBody BuyerPitchOnPo po) {
        return service.preOrderChack(po);
    }

    /**
     *更新进货单价格
     * @param
     * @return
     */
    @ApiOperation(value="更新进货单价格", notes="更新进货单价格")
    @RequestMapping(value="/gxImportPrice",method=RequestMethod.POST)
    public ResultPoJo<Object> gxImportPrice() {
        return service.gxImportPrice();
    }

    /**
     *去结算初始化页面
     * @param
     * @return
     */
    @ApiOperation(value="去结算初始化页面", notes="去结算初始化页面")
    @RequestMapping(value="/commInfoListFromPreOrder",method=RequestMethod.POST)
    public ResultPoJo<BuyerPreOrderCommInfoVo> commInfoListFromPreOrder (@RequestBody BuyerPitchOnPo po) {
        return service.commInfoListFromPreOrder(po);
    }

    /**
     *提交订单
     * @param
     * @return
     */
    @ApiOperation(value="提交订单", notes="提交订单")
    @RequestMapping(value="/generatingOrder",method=RequestMethod.POST)
    public ResultPoJo<BuyerGeneratingOrderVo> generatingOrder (@RequestBody BuyerGeneratingOrderPo po) {
        return service.generatingOrder(po);
    }
}
