package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.trade.SerListMageInfoPo;
import com.wisea.cultivar.common.po.trade.SerListMageListPo;
import com.wisea.cultivar.common.vo.trade.SerExportListExcelVo;
import com.wisea.cultivar.common.vo.trade.SerListMageInfoVo;
import com.wisea.cultivar.common.vo.trade.SerListMageListVo;
import com.wisea.cultivar.infomanage.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 卖家订单Controller
 */
@Api(tags = "服务单管理接口")
@RestController
@RequestMapping("/w/seller/order")
@PreAuthorize("hasAnyAuthority('im:ser')")
public class OrderInfoController {
    @Autowired
    private OrderInfoService service;

    /**
     * 卖家查询订单列表
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @ApiOperation(nickname = "服务单管理列表", value = "服务单管理列表", notes = "服务单管理列表", httpMethod = "POST")
    public ResultPoJo<Page<SerListMageListVo>> findList(@RequestBody SerListMageListPo po){
        return service.findMerchantOrderList(po);
    }

    /**
     * 查询订单详细信息
     * @param po
     * @return
     */
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询服务单管理详细信息", value = "【订单】查询服务单管理详细信息", notes = "查询服务单管理详细信息", httpMethod = "POST")
    public ResultPoJo<SerListMageInfoVo> findInfo(@RequestBody SerListMageInfoPo po){
        return service.findOrderInfo(po);
    }

    /**
     * 导出服务单列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月19日
     * @version 1.0
     */
    @ApiOperation(nickname="导出服务单列表", value = "导出服务单列表")
    @PostMapping(value = "/export")
    @DataCheck
    public void membSellerInfoListExport(@RequestBody SerListMageListPo po, HttpServletResponse response){
        //  返回参数
        try {
            String fileName = "服务单"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            new ExportExcel("服务单列表数据", SerExportListExcelVo.class).setDataList(service.exportMerchantOrderList(po)).writeWithAjaxHeader(response, fileName).dispose();
        } catch (Exception e) {
            throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
        }
    }
}
