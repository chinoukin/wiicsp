package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.common.util.excel.ImportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.explorer.service.OilTeaVarietMageService;
import com.wisea.cultivar.explorer.utils.CheckExcelField;
import com.wisea.cultivar.explorer.utils.CheckUtils;
import com.wisea.cultivar.explorer.vo.OilTeaVarietMageExportVo;
import com.wisea.cultivar.explorer.vo.OilTeaVarietMageGetVo;
import com.wisea.cultivar.explorer.vo.OilTeaVarietMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * OilTeaVarietMageController
 * 油茶品种信息维护 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "油茶品种信息维护相关接口")
@RequestMapping(value = "/w/OilTeaVarietMage")
@RestController
@PreAuthorize("hasAnyAuthority('ep:pl:var')")
public class OilTeaVarietMageController {
    private static final Logger logger = LoggerFactory.getLogger(OilTeaVarietMageController.class);
    @Autowired
    protected OilTeaVarietMageService oilTeaVarietMageService;

    @ApiOperation(value = "获取油茶品种信息维护分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<OilTeaVarietMageListVo>> findPage(@RequestBody OilTeaVarietMagePagePo oilTeaVarietMagePagePo) {
        return oilTeaVarietMageService.findPage(oilTeaVarietMagePagePo);
    }

    @ApiOperation(value = "获取油茶品种信息维护列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<OilTeaVarietMageListVo>> list(@RequestBody OilTeaVarietMageListPo oilTeaVarietMageListPo) {
        return oilTeaVarietMageService.findList(oilTeaVarietMageListPo);
    }

    @ApiOperation(value = "查询油茶品种信息维护")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<OilTeaVarietMageGetVo> get(@RequestBody OilTeaVarietMageGetPo oilTeaVarietMageGetPo) {
        return oilTeaVarietMageService.get(oilTeaVarietMageGetPo);
    }

    @ApiOperation(value = "新增油茶品种信息维护")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody OilTeaVarietMageInsertPo oilTeaVarietMageInsertPo) {
        return oilTeaVarietMageService.insert(oilTeaVarietMageInsertPo);
    }

    @ApiOperation(value = "修改油茶品种信息维护")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody OilTeaVarietMageUpdatePo oilTeaVarietMageUpdatePo) {
        return oilTeaVarietMageService.update(oilTeaVarietMageUpdatePo);
    }

    @ApiOperation(value = "批量删除油茶品种信息维护")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody OilTeaVarietMageBatDeletePo oilTeaVarietMageBatDeletePo) {
        return oilTeaVarietMageService.batDelete(oilTeaVarietMageBatDeletePo);
    }

    @ApiOperation(value = "导入油茶品种信息",notes = "错误代码 70003:导入失败，请检查excel是否存在数据！" +
            "70002:导入失败，请检查必填项是否为空或导入数据格式是否正确！" +
            "70004:导入失败，请检查excel数据格式是否对应！")
    @RequestMapping(value = "excelImport", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> excelImport(MultipartFile file) {
        if(CheckUtils.checkFileSize(file.getSize(), 10, "M")){
            return new ResultPoJo<>(ConstantError.ERR_201,ConstantError.MSG_201);
        }
        if (CheckUtils.checkFileName(file.getOriginalFilename(), "excel")) {
            return new ResultPoJo<>(ConstantError.ERR_202, ConstantError.MSG_202);
        }
        List<OilTeaVarietMageImportPo> dataList = null;
        try {
            ImportExcel ie = new ImportExcel(file, 1, 0);
            if(!(CheckExcelField.checkExcelFields(new OilTeaVarietMageImportPo(),ie))){
                ResultPoJo<Object> resultPoJo = new ResultPoJo<>();
                resultPoJo.setCode(QdcyStandardsError.ERR_70004);
                resultPoJo.setMsg(QdcyStandardsError.MSG_70004);
                return resultPoJo;
            }
            dataList = ie.getDataList(OilTeaVarietMageImportPo.class);
            if(CollectionUtils.isEmpty(dataList)){
                ResultPoJo<Object> resultPoJo = new ResultPoJo<>();
                resultPoJo.setCode(QdcyStandardsError.ERR_70003);
                resultPoJo.setMsg(QdcyStandardsError.MSG_70003);
                return resultPoJo;
            }
            boolean flag = dataList.stream().anyMatch(data ->
                    (StringUtils.isBlank(data.getOilTeaVarietName()) || StringUtils.isBlank(data.getOilTeaVarietNo()))
               );
            if(flag){
                return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
            }
            return oilTeaVarietMageService.excelImport(dataList);
        } catch ( Exception e) {
            logger.error("导入油茶品种信息失败！！！",e);
            return new ResultPoJo<>(ConstantError.ERR_999,ConstantError.MSG_999);
        }
    }

    @ApiOperation(value = "导出油茶品种信息")
    @RequestMapping(value = "excelExport", method = RequestMethod.POST)
    @DataCheck
    public void excelExport(@RequestBody OilTeaVarietMageListPo oilTeaVarietMageListPo, HttpServletResponse response) {
        ResultPoJo<List<OilTeaVarietMageListVo>> excelExportList = null;
            excelExportList = oilTeaVarietMageService.findList(oilTeaVarietMageListPo);
        try {
            String fileName = "油茶品种目录信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            new ExportExcel("油茶品种目录信息", OilTeaVarietMageExportVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
        } catch (Exception e) {
            logger.error("导出油茶品种目录信息失败！！！",e);
            throw ConstantError.BUS_999;
        }
    }

    @ApiOperation(value = "下载导入模板")
    @RequestMapping(value = "download", method = RequestMethod.POST)
    public void download(HttpServletResponse response) {
        List<OilTeaVarietMageListVo> downloadList = new ArrayList<>();
        logger.info("下载导入模板的油茶品种");
        try {
            //油茶品种下载导入模板
            String fileName = "油茶品种目录信息导入模板.xlsx";
            new ExportExcel("油茶品种目录信息", OilTeaVarietMageExportVo.class).setDataList(downloadList).writeWithAjaxHeader(response, fileName).dispose();
        } catch (Exception e) {
            logger.error("下载油茶品种目录信息模板失败！！！",e);
            throw ConstantError.BUS_999;
        }
    }
}
