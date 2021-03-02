package com.wisea.transac.tp.product.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.po.product.CommDataListPo;
import com.wisea.transac.common.po.product.CommPubExamPo;
import com.wisea.transac.common.po.product.CommPubInfoGetPo;
import com.wisea.transac.common.vo.CommPubInfoInfoVo;
import com.wisea.transac.common.vo.product.CommDataListVo;
import com.wisea.transac.common.vo.product.UpdateCommPubInfoStatesPo;
import com.wisea.transac.tp.product.service.MerchandiseService;
import com.wisea.transac.tp.product.service.SellerGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 运营后台 - 商品管理信息
 * @author: wangs
 * @date :2020/4/29
 */
@Api(tags = "运营后台 - 商品管理")
@RestController
@RequestMapping(value = "/w/merchandise")
public class MerchandiseController {

    @Autowired
    MerchandiseService merchandiseService;
    @Autowired
    SellerGoodsService sellerGoodsService;

    /**
     * 根据批发市场查看对应商品
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "查询批发市场对应商品信息", notes = "请求参数包括：(商品编号，商品名称，商家名称，商品分类,商品状态,档口名称)")
    @DataCheck
    public Page<CommDataListVo> commList(@RequestBody CommDataListPo po) {
        Page<CommDataListVo> resultPoJo = merchandiseService.commList(po);
        return resultPoJo;
    }

    /**
     * 运营后台审核 - 商家发布的商品信息
     *
     * @param commPubExamPo
     * @return
     */
    @ApiOperation(value = "运营后台审核 - 商家发布的商品信息", httpMethod = "POST")
    @RequestMapping(value = "/examCommPubInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo examCommPubInfo(@RequestBody CommPubExamPo commPubExamPo) {
        ResultPoJo<String> resultPoJo = merchandiseService.examCommPubInfo(commPubExamPo);
        return resultPoJo;
    }

    /**
     * 批量修改发布商品状态 - 批量驳回
     *
     * @param info
     * @return
     */
    @ApiOperation(value = "批量修改发布商品状态 - 批量驳回", httpMethod = "POST")
    @RequestMapping(value = "/updateCommPubInfoState", method = RequestMethod.POST)
    public ResultPoJo updateCommPubInfoState(@RequestBody UpdateCommPubInfoStatesPo info) {
        return sellerGoodsService.updateCommPubInfoState(info);
    }

    /**
     * 查询商品详情
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询商品详情", httpMethod = "POST")
    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public ResultPoJo<CommPubInfoInfoVo> details(@RequestBody CommPubInfoGetPo commPubInfoGetPo) {
        return sellerGoodsService.details(commPubInfoGetPo);

    }
}
