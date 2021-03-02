package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoListPo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoUpdatePo;
import com.wisea.cultivar.bigdata.service.OrdYjInfoService;
import com.wisea.cultivar.common.vo.bigdata.OrdYjInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.OrdYjInfoListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * OrdYjInfoController
 * 订单预警信息 Controller
 * 2019/12/02 11:02:15
 */
@Api(tags = "[物流]-订单预警信息相关接口")
@RequestMapping("/w/logistics/order/warning")
@RestController
@PreAuthorize("hasAuthority('eb:ord')")
public class OrdYjInfoController {
    @Autowired
    protected OrdYjInfoService ordYjInfoService;

    @ApiOperation("获取订单预警信息分页列表")
    @PostMapping("page")
    @DataCheck
    public ResultPoJo<Page<OrdYjInfoListVo>> findPage(@RequestBody OrdYjInfoPagePo ordYjInfoPagePo) {
        return ordYjInfoService.findPage(ordYjInfoPagePo);
    }

    @ApiOperation("获取订单预警信息列表")
    @PostMapping("list")
    @DataCheck
    public ResultPoJo<List<OrdYjInfoListVo>> list(@RequestBody OrdYjInfoListPo ordYjInfoListPo) {
        return ordYjInfoService.findList(ordYjInfoListPo);
    }

    @ApiOperation("查询订单预警信息")
    @PostMapping("get")
    @DataCheck
    public ResultPoJo<OrdYjInfoGetVo> get(@RequestBody OrdYjInfoGetPo ordYjInfoGetPo) {
        return ordYjInfoService.get(ordYjInfoGetPo);
    }

    @ApiOperation(value = "新增订单预警信息", notes = "预警类型:0可能延误,1运输故障")
    @PostMapping("insert")
    @DataCheck
    public ResultPoJo insert(@RequestBody OrdYjInfoInsertPo ordYjInfoInsertPo) {
        return ordYjInfoService.insert(ordYjInfoInsertPo);
    }

    @ApiOperation("修改订单预警信息")
    @PostMapping("update")
    @DataCheck
    public ResultPoJo update(@RequestBody OrdYjInfoUpdatePo ordYjInfoUpdatePo) {
        return ordYjInfoService.update(ordYjInfoUpdatePo);
    }

    @ApiOperation("批量删除订单预警信息")
    @PostMapping("batDelete")
    @DataCheck
    public ResultPoJo batDelete(@RequestBody OrdYjInfoBatDeletePo ordYjInfoBatDeletePo) {
        return ordYjInfoService.batDelete(ordYjInfoBatDeletePo);
    }

    @ApiOperation("模板下载")
    @PostMapping("/template/download")
    @DataCheck
    public void templateDownload(HttpServletResponse response) throws IOException {
        ordYjInfoService.templateDownload(response);
    }

    @ApiOperation("导入")
    @PostMapping("/excel/import")
    @DataCheck
    public ResultPoJo excelImport(MultipartFile file) throws Exception {
        return ordYjInfoService.excelImport(file);
    }

    @ApiOperation("导出")
    @PostMapping("/excel/export")
    @DataCheck
    public void excelExport(HttpServletResponse response) throws IOException {
        ordYjInfoService.excelExport(response);
    }
}
