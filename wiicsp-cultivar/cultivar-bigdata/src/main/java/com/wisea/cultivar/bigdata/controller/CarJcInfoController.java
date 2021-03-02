package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.service.CarJcInfoService;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoListPo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.CarJcInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.CarJcInfoListVo;
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
 * CarJcInfoController
 * 车辆监测信息 Controller
 * 2019/12/02 11:02:14
 */
@Api(tags = "[物流]-车辆监测信息相关接口")
@RequestMapping("/w/logistics/car/monitor")
@RestController
@PreAuthorize("hasAuthority('eb:vem')")
public class CarJcInfoController {
    @Autowired
    protected CarJcInfoService carJcInfoService;

    @ApiOperation("获取车辆监测信息分页列表")
    @PostMapping("page")
    @DataCheck
    public ResultPoJo<Page<CarJcInfoListVo>> findPage(@RequestBody CarJcInfoPagePo carJcInfoPagePo) {
        return carJcInfoService.findPage(carJcInfoPagePo);
    }

    @ApiOperation("获取车辆监测信息列表")
    @PostMapping("list")
    @DataCheck
    public ResultPoJo<List<CarJcInfoListVo>> list(@RequestBody CarJcInfoListPo carJcInfoListPo) {
        return carJcInfoService.findList(carJcInfoListPo);
    }

    @ApiOperation("查询车辆监测信息")
    @PostMapping("get")
    @DataCheck
    public ResultPoJo<CarJcInfoGetVo> get(@RequestBody CarJcInfoGetPo carJcInfoGetPo) {
        return carJcInfoService.get(carJcInfoGetPo);
    }

    @ApiOperation("新增车辆监测信息")
    @PostMapping("insert")
    @DataCheck

    public ResultPoJo<Object> insert(@RequestBody CarJcInfoInsertPo carJcInfoInsertPo) {
        return carJcInfoService.insert(carJcInfoInsertPo);
    }

    @ApiOperation("修改车辆监测信息")
    @PostMapping("update")
    @DataCheck

    public ResultPoJo<Object> update(@RequestBody CarJcInfoUpdatePo carJcInfoUpdatePo) {
        return carJcInfoService.update(carJcInfoUpdatePo);
    }

    @ApiOperation("批量删除车辆监测信息")
    @PostMapping("batDelete")
    @DataCheck

    public ResultPoJo<Object> batDelete(@RequestBody CarJcInfoBatDeletePo carJcInfoBatDeletePo) {
        return carJcInfoService.batDelete(carJcInfoBatDeletePo);
    }

    @ApiOperation("模板下载")
    @PostMapping("/template/download")
    @DataCheck

    public void templateDownload(HttpServletResponse response) throws IOException {
        carJcInfoService.templateDownload(response);
    }

    @ApiOperation("导入")
    @PostMapping("/excel/import")
    @DataCheck

    public ResultPoJo excelImport(MultipartFile file) throws Exception {
        return carJcInfoService.excelImport(file);
    }

    @ApiOperation("导出")
    @PostMapping("/excel/export")
    @DataCheck

    public void excelExport(HttpServletResponse response) throws IOException {
        carJcInfoService.excelExport(response);
    }
}
