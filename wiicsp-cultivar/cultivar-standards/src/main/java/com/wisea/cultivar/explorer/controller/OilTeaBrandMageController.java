package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.common.util.excel.ImportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.explorer.vo.OilTeaBrandMageExportVo;
import com.wisea.cultivar.explorer.vo.OilTeaBrandMageGetVo;
import com.wisea.cultivar.explorer.vo.OilTeaBrandMageListVo;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.explorer.service.OilTeaBrandMageService;
import com.wisea.cultivar.explorer.utils.CheckUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * OilTeaBrandMageController
 * 茶油品牌信息维护 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "茶油品牌信息维护相关接口")
@RequestMapping(value = "/w/OilTeaBrandMage")
@RestController
@PreAuthorize("hasAnyAuthority('ep:brd')")
public class OilTeaBrandMageController {
    private static final Logger logger = LoggerFactory.getLogger(OilTeaBrandMageController.class);
    @Autowired
    protected OilTeaBrandMageService oilTeaBrandMageService;

    @ApiOperation(value = "获取茶油品牌信息维护分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<OilTeaBrandMageListVo>> findPage(@RequestBody OilTeaBrandMagePagePo oilTeaBrandMagePagePo) {
        return oilTeaBrandMageService.findPage(oilTeaBrandMagePagePo);
    }

    @ApiOperation(value = "获取茶油品牌信息维护列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<OilTeaBrandMageListVo>> list(@RequestBody OilTeaBrandMageListPo oilTeaBrandMageListPo) {
        return oilTeaBrandMageService.findList(oilTeaBrandMageListPo);
    }

    @ApiOperation(value = "查询茶油品牌信息维护")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<OilTeaBrandMageGetVo> get(@RequestBody OilTeaBrandMageGetPo oilTeaBrandMageGetPo) {
        return oilTeaBrandMageService.get(oilTeaBrandMageGetPo);
    }

    @ApiOperation(value = "新增茶油品牌信息维护")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody OilTeaBrandMageInsertPo oilTeaBrandMageInsertPo) {
        return oilTeaBrandMageService.insert(oilTeaBrandMageInsertPo);
    }

    @ApiOperation(value = "修改茶油品牌信息维护")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody OilTeaBrandMageUpdatePo oilTeaBrandMageUpdatePo) {
        return oilTeaBrandMageService.update(oilTeaBrandMageUpdatePo);
    }

    @ApiOperation(value = "批量删除茶油品牌信息维护")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody OilTeaBrandMageBatDeletePo oilTeaBrandMageBatDeletePo) {
        return oilTeaBrandMageService.batDelete(oilTeaBrandMageBatDeletePo);
    }

    @ApiOperation(value = "导入茶油品牌信息",notes = "错误代码 70003:导入失败，请检查excel是否存在数据！" +
            "70002:导入失败，请检查必填项是否为空或导入数据格式是否正确！")
    @RequestMapping(value = "excelImport", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> excelImport(MultipartFile file) {
        if(CheckUtils.checkFileSize(file.getSize(), 10, "M")){
            return new ResultPoJo<>(ConstantError.ERR_201,ConstantError.MSG_201);
        }
        if (CheckUtils.checkFileName(file.getOriginalFilename(), "excel")) {
            return new ResultPoJo<>(ConstantError.ERR_202, ConstantError.MSG_202);
        }
        List<OilTeaBrandMageImportPo> dataList = null;
        try {
            ImportExcel ie = new ImportExcel(file, 1, 0);
            dataList = ie.getDataList(OilTeaBrandMageImportPo.class);
            if(CollectionUtils.isEmpty(dataList)){
                ResultPoJo<Object> resultPoJo = new ResultPoJo<>();
                resultPoJo.setCode(QdcyStandardsError.ERR_70003);
                resultPoJo.setMsg(QdcyStandardsError.MSG_70003);
                return resultPoJo;
            }
            boolean flag = dataList.stream().anyMatch(data -> (StringUtils.isEmpty(data.getBrandName()) || StringUtils.isEmpty(data.getApplDateStr())));
            if (flag){
                return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
            }
        } catch ( Exception e) {
            logger.error("导入茶油品牌目录信息失败！！！",e);
            return new ResultPoJo<>(ConstantError.ERR_999,ConstantError.MSG_999);
        }
        return oilTeaBrandMageService.excelImport(dataList);
    }

    @ApiOperation(value = "导出茶油品牌信息")
    @RequestMapping(value = "excelExport", method = RequestMethod.POST)
    @DataCheck
    public void excelExport(@RequestBody OilTeaBrandMageListPo oilTeaBrandMageListPo, HttpServletResponse response) {
        ResultPoJo<List<OilTeaBrandMageListVo>> excelExportList = null;
            excelExportList = oilTeaBrandMageService.findList(oilTeaBrandMageListPo);
        try {
            String  fileName = "茶油品牌目录信息"+ DateUtils.getDate("yyyyMMddHHmmss") +".xlsx";
            new ExportExcel("茶油品牌目录信息", OilTeaBrandMageExportVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
        } catch (Exception e) {
            logger.error("导出茶油品牌信息失败！！！",e);
            throw ConstantError.BUS_999;
        }
    }

    @ApiOperation(value = "下载导入模板")
    @RequestMapping(value = "download", method = RequestMethod.POST)
    public void download(HttpServletResponse response) {
        List<OilTeaBrandMageListVo> downloadList = new ArrayList<>();
        logger.info("下载导入模板的茶油品牌");
        try {
                //茶油品牌下载导入模板
                String fileName = "茶油品牌目录信息导入模板.xlsx";
                new ExportExcel("茶油品牌目录信息", OilTeaBrandMageExportVo.class).setDataList(downloadList).writeWithAjaxHeader(response, fileName).dispose();
        } catch (Exception e) {
            logger.error("下载茶油品牌目录信息模板失败！！！",e);
            throw ConstantError.BUS_999;
        }
    }

}
