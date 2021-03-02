package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.common.util.excel.ImportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.explorer.service.OrgInfoMageService;
import com.wisea.cultivar.explorer.utils.CheckUtils;
import com.wisea.cultivar.explorer.vo.OrgInfoMageExportDepartmentVo;
import com.wisea.cultivar.explorer.vo.OrgInfoMageExportOrgVo;
import com.wisea.cultivar.explorer.vo.OrgInfoMageGetVo;
import com.wisea.cultivar.explorer.vo.OrgInfoMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * OrgInfoMageController
 * 机构信息维护 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "机构信息维护相关接口")
@RequestMapping(value = "/w/OrgInfoMage")
@RestController
@PreAuthorize("hasAnyAuthority('ep:org','ep:sup')")
public class OrgInfoMageController {
    private static final Logger logger = LoggerFactory.getLogger(OrgInfoMageController.class);
    @Autowired
    protected OrgInfoMageService orgInfoMageService;

    @ApiOperation(value = "获取机构信息维护分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<OrgInfoMageListVo>> findPage(@RequestBody OrgInfoMagePagePo orgInfoMagePagePo) {
        return orgInfoMageService.findPage(orgInfoMagePagePo);
    }

    @ApiOperation(value = "获取机构信息维护列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<OrgInfoMageListVo>> list(@RequestBody OrgInfoMageListPo orgInfoMageListPo) {
        return orgInfoMageService.findList(orgInfoMageListPo);
    }

    @ApiOperation(value = "查询机构信息维护")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<OrgInfoMageGetVo> get(@RequestBody OrgInfoMageGetPo orgInfoMageGetPo) {
        return orgInfoMageService.get(orgInfoMageGetPo);
    }

    @ApiOperation(value = "新增机构信息维护")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody OrgInfoMageInsertPo orgInfoMageInsertPo) {
        return orgInfoMageService.insert(orgInfoMageInsertPo);
    }

    @ApiOperation(value = "修改机构信息维护")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody OrgInfoMageUpdatePo orgInfoMageUpdatePo) {
        return orgInfoMageService.update(orgInfoMageUpdatePo);
    }

    @ApiOperation(value = "批量删除机构信息维护")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody OrgInfoMageBatDeletePo orgInfoMageBatDeletePo) {
        return orgInfoMageService.batDelete(orgInfoMageBatDeletePo);
    }

    @ApiOperation(value = "导入机构/部门信息")
    @ApiImplicitParam(name = "orgType", value = "机构类型-orgType-0：机构；1：部门", dataType = "String", required = true, paramType = "form-data")
    @RequestMapping(value = "excelImport", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> excelImport(MultipartFile file, String orgType) {
        if (CheckUtils.checkFileSize(file.getSize(), 5, "M")) {
            return new ResultPoJo<>(ConstantError.ERR_201, ConstantError.MSG_201);
        }
        if (CheckUtils.checkFileName(file.getOriginalFilename(), "excel")) {
            return new ResultPoJo<>(ConstantError.ERR_202, ConstantError.MSG_202);
        }
        List<OrgInfoMageImportPo> dataDepartmentList = null;
        try {
            ImportExcel ie = new ImportExcel(file, 1, 0);
            //验证excel表格标题
            if(!CheckUtils.checkExcelFields(QdcyStandardsDict.ORG_TYPE_0.equals(orgType) ? OrgInfoMageImportPo.class : OrgInfoDeptImportPo.class,ie)){
                return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
            }
            dataDepartmentList = ie.getDataList(OrgInfoMageImportPo.class);
            if(dataDepartmentList.size() == 0 ){
                return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
            }
            //验证必填项是否为空，数据格式是否正确
            if(validateMand(dataDepartmentList)){
                return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
            }
            logger.info("导入的机构/部门类型是：{}", orgType);
            //过滤数据库中已有数据。但本期20200814，本期先不做覆盖，这个模板表是为了方便第一次录入数据--导入的全部为新增，为防止在系统更改后导入数据覆盖丢失问题
//          dataDepartmentList = handleList(dataDepartmentList,orgType);
            return orgInfoMageService.excelImport(dataDepartmentList, orgType);
        } catch (Exception e) {
            logger.error("导入机构/部门信息失败！！！", e);
            return new ResultPoJo<>(ConstantError.ERR_999, ConstantError.MSG_999);
        }
    }

    /**
     * 过滤掉数据库中已存在的数据
     * @param dataDepartmentList 导入的数据
     * @param orgType 数据库查询条件
     * @return  List
     */
    private List<OrgInfoMageImportPo> handleList(List<OrgInfoMageImportPo> dataDepartmentList, String orgType) {
        final ResultPoJo<List<OrgInfoMageListVo>> orgInfoMages = orgInfoMageService.findList(new OrgInfoMageListPo(orgType));
        if(null == orgInfoMages.getResult() || orgInfoMages.getResult().size()==0){
            return dataDepartmentList;
        }
        final List<OrgInfoMageListVo> resultOrgInfoMages = orgInfoMages.getResult();
        final List<OrgInfoMageImportPo> importPos = resultOrgInfoMages.parallelStream().map(orgInfoMagesVo -> {
            OrgInfoMageImportPo importPo = new OrgInfoMageImportPo();
            BeanUtils.copyProperties(orgInfoMagesVo, importPo);
            return importPo;
        }).collect(Collectors.toList());
        dataDepartmentList = dataDepartmentList.parallelStream().filter(importPo -> !importPos.contains(importPo)).collect(Collectors.toList());
        return dataDepartmentList;
    }


    private boolean validateMand(List<OrgInfoMageImportPo> dataDepartmentList) {
        String jdWdRegx = "^\\d+(\\.\\d+)?,\\d+(\\.\\d+)?$", conTelRegx = "^[0-9]{11}$", areaCodeRegx = "^[0-9]{12}$", orgNameRegx = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]{2,100}$";
        return dataDepartmentList.parallelStream().anyMatch(importPo ->
                 StringUtils.isBlank(importPo.getAreaProv()) || !Pattern.compile(areaCodeRegx).matcher(importPo.getAreaProv()).matches()
                || StringUtils.isBlank(importPo.getAreaCity()) || !Pattern.compile(areaCodeRegx).matcher(importPo.getAreaCity()).matches()
                || StringUtils.isBlank(importPo.getAreaCou()) || !Pattern.compile(areaCodeRegx).matcher(importPo.getAreaCou()).matches()
                || StringUtils.isBlank(importPo.getOrgName()) || !Pattern.compile(orgNameRegx).matcher(importPo.getOrgName()).matches()
                || (StringUtils.isNotBlank(importPo.getJdWd()) && !Pattern.compile(jdWdRegx).matcher(importPo.getJdWd()).matches())
                || (StringUtils.isNotBlank(importPo.getContTel()) && !Pattern.compile(conTelRegx).matcher(importPo.getContTel()).matches())
        );
    }

    @ApiOperation(value = "导出机构/部门信息")
    @RequestMapping(value = "excelExport", method = RequestMethod.POST)
    @DataCheck
    public void excelExport(@RequestBody OrgInfoMageListPo orgInfoMageListPo, HttpServletResponse response) {
        final ResultPoJo<List<OrgInfoMageListVo>> excelExportList = orgInfoMageService.findList(orgInfoMageListPo);
        String fileName = null;
        if (QdcyStandardsDict.ORG_TYPE_0.equals(orgInfoMageListPo.getOrgType())) {
            try {
                fileName = "检测机构信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
                new ExportExcel("检测机构信息", OrgInfoMageExportOrgVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
            } catch (Exception e) {
                logger.error("导出检测机构信息失败！！！", e);
                throw ConstantError.BUS_999;
            }
        } else {
            try {
                fileName = "监管部门信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
                new ExportExcel("监管部门信息", OrgInfoMageExportDepartmentVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
            } catch (Exception e) {
                logger.error("导出监管部门信息失败！！！", e);
                throw ConstantError.BUS_999;
            }
        }
    }

}
