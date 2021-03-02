package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoListPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoUpdatePo;
import com.wisea.cultivar.bigdata.service.LogisticsMapInfoService;
import com.wisea.cultivar.common.vo.bigdata.EchartsMapDataVo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsMapInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsMapInfoListVo;
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
 * LogisticsMapInfoController
 * 物流地图信息 Controller
 * 2019/12/02 11:02:14
 */
@Api(tags = "[物流]-物流地图信息相关接口")
@RequestMapping("/w/logistics/map")
@RestController
@PreAuthorize("hasAuthority('eb:lgm')")
public class LogisticsMapInfoController {

    @Autowired
    protected LogisticsMapInfoService logisticsMapInfoService;

    @DataCheck
    @PostMapping("/data")
    @ApiOperation("地图数据")
    public ResultPoJo<EchartsMapDataVo> findMapData() {
        return logisticsMapInfoService.findMapData();
    }

    @ApiOperation("获取物流地图信息分页列表")
    @PostMapping("page")
    @DataCheck
    public ResultPoJo<Page<LogisticsMapInfoListVo>> findPage(@RequestBody LogisticsMapInfoPagePo logisticsMapInfoPagePo) {
        return logisticsMapInfoService.findPage(logisticsMapInfoPagePo);
    }

    @ApiOperation("获取物流地图信息列表")
    @PostMapping("list")
    @DataCheck
    public ResultPoJo<List<LogisticsMapInfoListVo>> list(@RequestBody LogisticsMapInfoListPo logisticsMapInfoListPo) {
        return logisticsMapInfoService.findList(logisticsMapInfoListPo);
    }

    @ApiOperation("查询物流地图信息")
    @PostMapping("get")
    @DataCheck
    public ResultPoJo<LogisticsMapInfoGetVo> get(@RequestBody LogisticsMapInfoGetPo logisticsMapInfoGetPo) {
        return logisticsMapInfoService.get(logisticsMapInfoGetPo);
    }

    @ApiOperation("新增物流地图信息")
    @PostMapping("insert")
    @DataCheck

    public ResultPoJo<Object> insert(@RequestBody LogisticsMapInfoInsertPo logisticsMapInfoInsertPo) {
        return logisticsMapInfoService.insert(logisticsMapInfoInsertPo);
    }

    @ApiOperation("修改物流地图信息")
    @PostMapping("update")
    @DataCheck

    public ResultPoJo<Object> update(@RequestBody LogisticsMapInfoUpdatePo logisticsMapInfoUpdatePo) {
        return logisticsMapInfoService.update(logisticsMapInfoUpdatePo);
    }

    @ApiOperation("批量删除物流地图信息")
    @PostMapping("batDelete")
    @DataCheck

    public ResultPoJo<Object> batDelete(@RequestBody LogisticsMapInfoBatDeletePo logisticsMapInfoBatDeletePo) {
        return logisticsMapInfoService.batDelete(logisticsMapInfoBatDeletePo);
    }

    @ApiOperation("模板下载")
    @PostMapping("/template/download")
    @DataCheck

    public void templateDownload(HttpServletResponse response) throws IOException {
        logisticsMapInfoService.templateDownload(response);
    }

    @ApiOperation("导入")
    @PostMapping("/excel/import")
    @DataCheck

    public ResultPoJo excelImport(MultipartFile file) throws Exception {
        return logisticsMapInfoService.excelImport(file);
    }

    @ApiOperation("导出")
    @PostMapping("/excel/export")
    @DataCheck

    public void excelExport(HttpServletResponse response) throws IOException {
        logisticsMapInfoService.excelExport(response);
    }

}
