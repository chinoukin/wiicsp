package com.wisea.transac.tp.product.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.po.CommPubInfoPo;
import com.wisea.transac.common.po.product.CommPubInfoGetPo;
import com.wisea.transac.common.po.product.CommPubInfoPagePo;
import com.wisea.transac.common.po.product.CommPubInfoStatePo;
import com.wisea.transac.common.po.product.CommPubNetPrice;
import com.wisea.transac.common.vo.CommPubInfoInfoVo;
import com.wisea.transac.common.vo.product.CommPubInfoListVo;
import com.wisea.transac.common.vo.product.CommPubInfoResultVo;
import com.wisea.transac.common.vo.product.DistincCommSaleVo;
import com.wisea.transac.common.vo.product.UpdateCommPubInfoStatesPo;
import com.wisea.transac.tp.product.service.SellerGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 商家商品管理信息
 * @author: wangs
 * @date :2020/5/11
 */
@Api(value = "sellerGoods", description = "商家商品信息", tags = "商家商品信息,调用接口")
@RestController
@RequestMapping("/w/sellerGoods")
public class SellerGoodController {

    @Autowired
    SellerGoodsService sellerGoodsService;

    /**
     * 保存或修改商品信息
     *
     * @param commPubInfoPo
     * @return
     */
    @ApiOperation(value = "保存或修改商品信息", httpMethod = "POST")
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    @PreAuthorize("hasAnyAuthority('saler_prd_add')")
    public ResultPoJo saveOrUpdate(@RequestBody CommPubInfoPo commPubInfoPo) {
        ResultPoJo<String> resultPoJo = sellerGoodsService.saveOrUpdate(commPubInfoPo);
        return resultPoJo;
    }

    /**
     * 计算 多少钱/每斤
     *
     * @param commPubNetPrice
     * @return
     */
    @ApiOperation(value = "商品的净价", httpMethod = "POST")
    @RequestMapping(value = "/netPrice", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('saler_prd_add')")
    @DataCheck
    public ResultPoJo netPrice(@RequestBody CommPubNetPrice commPubNetPrice) {

        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        double div = ConverterUtil.div(commPubNetPrice.getPrice(), commPubNetPrice.getNetWeight(), 2);
        commPubNetPrice.setNetPrice(div);

        resultPoJo.setResult(commPubNetPrice);
        return resultPoJo;
    }

    /**
     * 查询商家端商品列表
     *
     * @param commPubInfoPagePo
     * @return
     */
    @ApiOperation(value = "查询商家端商品列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('saler_prd_add')")
    public ResultPoJo<CommPubInfoResultVo<CommPubInfoListVo>> list(@RequestBody CommPubInfoPagePo commPubInfoPagePo) {
        return sellerGoodsService.list(commPubInfoPagePo);

    }

    /**
     * 查询商家端产地商品列表
     *
     * @param commPubInfoPagePo
     * @return
     */
    @ApiOperation(value = "查询商家端产地商品列表", httpMethod = "POST")
    @RequestMapping(value = "/listOrigin", method = RequestMethod.POST)
    public ResultPoJo<CommPubInfoResultVo<CommPubInfoListVo>> listOrigin(@RequestBody CommPubInfoPagePo commPubInfoPagePo) {
        return sellerGoodsService.originlist(commPubInfoPagePo);

    }

    /**
     * 查询商品详情
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询商品详情", httpMethod = "POST")
    @RequestMapping(value = "/details", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('saler_prd_add')")
    public ResultPoJo<CommPubInfoInfoVo> details(@RequestBody CommPubInfoGetPo commPubInfoGetPo) {
        return sellerGoodsService.details(commPubInfoGetPo);

    }

    /**
     * 改变商品状态
     *
     * @param
     * @return
     */
    @ApiOperation(value = "商家端改变商品状态和后台审核,驳回信息", httpMethod = "POST")
    @RequestMapping(value = "/changeState", method = RequestMethod.POST)
    @DataCheck
    @PreAuthorize("hasAnyAuthority('saler_prd_add')")
    public ResultPoJo changeState(@RequestBody CommPubInfoStatePo commPubInfoStatePo) {
        return sellerGoodsService.changeState(commPubInfoStatePo);

    }

    /**
     * 批量修改发布商品状态 - 批量驳回
     *
     * @param info
     * @return
     */
    @ApiOperation(value = "批量修改发布商品状态 - 批量驳回", httpMethod = "POST")
    @RequestMapping(value = "/updateCommPubInfoState", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('saler_prd_add')")
    public ResultPoJo updateCommPubInfoState(@RequestBody UpdateCommPubInfoStatesPo info) {
        return sellerGoodsService.updateCommPubInfoState(info);
    }

    /**
     * 根据档口id 查询有关联的销售分类信息 - 去重
     *
     * @param commPubInfoPagePo
     * @return
     */
    @ApiOperation(value = "根据档口id 查询有关联的销售分类信息和配置信息", httpMethod = "POST")
    @RequestMapping(value = "/findCommMageListDisStaffId", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('saler_prd_add')")
    public ResultPoJo<List<DistincCommSaleVo>> findCommMageListDisStaffId(@RequestBody CommPubInfoPagePo commPubInfoPagePo) {
        return sellerGoodsService.findCommMageListDisStaffId(commPubInfoPagePo);

    }
}
