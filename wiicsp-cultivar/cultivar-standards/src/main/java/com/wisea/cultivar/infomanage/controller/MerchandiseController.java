package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.product.CommDataListPo;
import com.wisea.cultivar.common.po.product.CommPubExamPo;
import com.wisea.cultivar.common.po.product.CommPubInfoGetPo;
import com.wisea.cultivar.common.po.product.UpdateCommPubInfoStatesPo;
import com.wisea.cultivar.common.vo.product.CommDataExportListVo;
import com.wisea.cultivar.common.vo.product.CommDataListVo;
import com.wisea.cultivar.common.vo.product.CommPubInfoInfoVo;
import com.wisea.cultivar.infomanage.service.MerchandiseService;
import com.wisea.cultivar.infomanage.service.SellerGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 运营后台 - 商品管理信息
 * @author: wangs
 * @date :2020/4/29
 */
@Api(tags = "运营后台 - 商品管理")
@RestController
@RequestMapping(value = "/w/merchandise")
@PreAuthorize("hasAnyAuthority('im:god')")
public class MerchandiseController {

    @Autowired
    MerchandiseService merchandiseService;
    @Autowired
    SellerGoodsService sellerGoodsService;

    /**
     * 商品信息列表
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "商品信息列表", notes = "请求参数包括：(商品名称，商家名称，商品分类,商品状态)")
    @DataCheck
    public  ResultPoJo<Page<CommDataListVo>> commList(@RequestBody CommDataListPo po) {
        ResultPoJo<Page<CommDataListVo>> resultPoJo = merchandiseService.commList(po);
        return resultPoJo;
    }

    /**
     * 导出商品信息列表
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    @ApiOperation(value = "导出商品信息列表", notes = "请求参数包括：(商品编号，商品名称，商家名称，商品分类,商品状态)")
    @DataCheck
    public void exportList(@RequestBody CommDataListPo po, HttpServletResponse response) {
        //  返回参数
        try {
            String fileName = "商品列表"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            new ExportExcel("商品信息列表数据", CommDataExportListVo.class).setDataList(merchandiseService.exportList(po)).writeWithAjaxHeader(response, fileName).dispose();
        } catch (Exception e) {
            throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
        }
    }

    /**
     * 运营后台审核 - 商家发布的商品信息
     *
     * @param commPubExamPo
     * @return
     */
    @ApiOperation(value = "(弃用)运营后台审核 - 商家发布的商品信息", httpMethod = "POST")
    @RequestMapping(value = "/examCommPubInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo examCommPubInfo(@RequestBody CommPubExamPo commPubExamPo) {
        ResultPoJo<String> resultPoJo = merchandiseService.examCommPubInfo(commPubExamPo);
        return resultPoJo;
    }

    /**
     * 批量修改发布商品状态 - 批量审核/驳回
     *
     * @param info
     * @return
     */
    @ApiOperation(value = "批量修改发布商品状态 - 批量审核/批量驳回", httpMethod = "POST",notes = "错误代码 60002:只允许状态为销售中和待审核的商品进行驳回")
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
