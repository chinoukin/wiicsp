package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.common.util.excel.ImportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.explorer.service.EntpInfoMageService;
import com.wisea.cultivar.explorer.utils.CheckUtils;
import com.wisea.cultivar.explorer.vo.*;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.constants.QdcyStandardsError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * EntpInfoMageController
 * 企业信息维护 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "企业信息维护相关接口")
@RequestMapping(value = "/w/EntpInfoMage")
@RestController
@PreAuthorize("hasAnyAuthority('ep:pla','ep:see','ep:pro','ep:mac','ep:skl','ep:prc')")
public class EntpInfoMageController {
    private static final Logger logger = LoggerFactory.getLogger(EntpInfoMageController.class);
    @Autowired
    protected EntpInfoMageService entpInfoMageService;

    @ApiOperation(value = "获取企业信息维护分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<EntpInfoMageListVo>> findPage(@RequestBody EntpInfoMagePagePo entpInfoMagePagePo) {
        return entpInfoMageService.findPage(entpInfoMagePagePo);
    }

    @ApiOperation(value = "获取企业信息维护列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<EntpInfoMageListVo>> list(@RequestBody EntpInfoMageListPo entpInfoMageListPo) {
        return entpInfoMageService.findList(entpInfoMageListPo);
    }

    @ApiOperation(value = "获取大数据加工企业的右侧企业信息维护列表")
    @RequestMapping(value = "processing", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<EntpInfoMageListVo>> processing(@RequestBody EntpInfoMageListPo entpInfoMageListPo) {
        return entpInfoMageService.findList(entpInfoMageListPo);
    }

    @ApiOperation(value = "查询企业信息维护")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<EntpInfoMageGetVo> get(@RequestBody EntpInfoMageGetPo entpInfoMageGetPo) {
        return entpInfoMageService.get(entpInfoMageGetPo);
    }

    @ApiOperation(value = "新增种植企业信息维护")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody EntpInfoMageInsertPo entpInfoMageInsertPo) {
        return entpInfoMageService.insert(entpInfoMageInsertPo);
    }

    @ApiOperation(value = "新增种苗/新增农机/新增农资/新增农技/精深加工企业信息维护-必填字段不一致")
    @RequestMapping(value = "insertProceAgric", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insertProceAgric(@RequestBody EntpInfoMageInsertProceAgricPo entpInfoMageInsertPo) {
        return entpInfoMageService.insert(entpInfoMageInsertPo);
    }

    @ApiOperation(value = "修改种植企业信息维护")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody EntpInfoMageUpdatePo entpInfoMageUpdatePo) {
        return entpInfoMageService.update(entpInfoMageUpdatePo);
    }

    @ApiOperation(value = "修改种苗/修改农机/修改农资/修改农技/精深加工企业信息维护-必填字段不一致")
    @RequestMapping(value = "updateProceAgric", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> updateProceAgric(@RequestBody EntpInfoMageUpdateProceAgricPo entpInfoMageUpdatePo) {
        return entpInfoMageService.update(entpInfoMageUpdatePo);
    }

    @ApiOperation(value = "批量删除企业信息维护")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody EntpInfoMageBatDeletePo entpInfoMageBatDeletePo) {
        return entpInfoMageService.batDelete(entpInfoMageBatDeletePo);
    }

    @ApiOperation(value = "导入企业信息",notes = "错误代码 70003:导入失败，请检查excel是否存在数据！" +
            "70002:导入失败，请检查必填项是否为空或导入数据格式是否正确！")
    @RequestMapping(value = "excelImport", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> excelImport(MultipartFile file, String entpMainBusinessType) {
        if (CheckUtils.checkFileSize(file.getSize(), 10, "M")) {
            return new ResultPoJo<>(ConstantError.ERR_201, ConstantError.MSG_201);
        }
        if (CheckUtils.checkFileName(file.getOriginalFilename(), "excel")) {
            return new ResultPoJo<>(ConstantError.ERR_202, ConstantError.MSG_202);
        }
        logger.info("导入的主体企业类型是：{}", entpMainBusinessType);
        try {
            if (Arrays.asList(QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_2, QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_3, QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_4, QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_5).contains(entpMainBusinessType)) {
                ImportExcel ie = new ImportExcel(file, 1, 0);
                //验证excel表格标题
                if(!CheckUtils.checkExcelFields(EntpInfoMageImportProceAgricPo.class ,ie)){
                    return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
                }
                List<EntpInfoMageImportProceAgricPo> dataList = ie.getDataList(EntpInfoMageImportProceAgricPo.class);
                if(CollectionUtils.isEmpty(dataList)){
                    return new ResultPoJo<>(QdcyStandardsError.ERR_70003, QdcyStandardsError.MSG_70003);
                }
                if(validateMand(dataList)){
                    return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
                }
                //过滤数据库中已有数据。但本期20200814，本期先不做覆盖，这个模板表是为了方便第一次录入数据--导入的全部为新增，为防止在系统更改后导入数据覆盖丢失问题
                // dataList = handleDataList(dataList,entpMainBusinessType);
                return entpInfoMageService.excelImportProceAgric(dataList, entpMainBusinessType);
            }

            if (Objects.equals(QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_1, entpMainBusinessType)) {
                //种苗企业信息维护
                ImportExcel ie = new ImportExcel(file, 1, 0);
                //验证excel表格标题
                if(!CheckUtils.checkExcelFields(EntpInfoSeedCompaniesImportPo.class ,ie)){
                    return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
                }
                List<EntpInfoSeedCompaniesImportPo> dataList = ie.getDataList(EntpInfoSeedCompaniesImportPo.class);
                if(CollectionUtils.isEmpty(dataList)){
                    ResultPoJo<Object> resultPoJo = new ResultPoJo<>();
                    resultPoJo.setCode(QdcyStandardsError.ERR_70003);
                    resultPoJo.setMsg(QdcyStandardsError.MSG_70003);
                    return resultPoJo;
                }
                if(!validateMandCompanies(dataList)){
                    return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
                }
                return entpInfoMageService.excelImportSeedCompanies(dataList, entpMainBusinessType);
            }

            if (Objects.equals(QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_0, entpMainBusinessType)) {
                //种植主体信息维护
                ImportExcel ie = new ImportExcel(file, 1, 0);
                //验证excel表格标题
                if(!CheckUtils.checkExcelFields(EntpInfoPlantEnterpriseImportPo.class ,ie)){
                    return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
                }
                List<EntpInfoPlantEnterpriseImportPo> dataList = ie.getDataList(EntpInfoPlantEnterpriseImportPo.class);
                if(CollectionUtils.isEmpty(dataList)){
                    ResultPoJo<Object> resultPoJo = new ResultPoJo<>();
                    resultPoJo.setCode(QdcyStandardsError.ERR_70003);
                    resultPoJo.setMsg(QdcyStandardsError.MSG_70003);
                    return resultPoJo;
                }
                if(!validateMandPlant(dataList)){
                    return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
                }
                return entpInfoMageService.excelImportPlantEnterprise(dataList, entpMainBusinessType);
            }

            return new ResultPoJo<>(QdcyStandardsError.ERR_70002, QdcyStandardsError.MSG_70002);
        } catch (Exception e) {
            logger.error("导入企业信息失败！！！", e);
            return new ResultPoJo<>(ConstantError.ERR_999, ConstantError.MSG_999);
        }
    }

    /**
     * 过滤掉数据库中已存在的数据
     * @param dataList 导入的数据
     * @param entpMainBusinessType 数据库查询条件
     * @return List
     */
    private List<EntpInfoMageImportProceAgricPo> handleDataList(List<EntpInfoMageImportProceAgricPo> dataList, String entpMainBusinessType) {
        final ResultPoJo<List<EntpInfoMageListVo>> entpInfoMageServiceRes = entpInfoMageService.findList(new EntpInfoMageListPo(entpMainBusinessType));
        if(null == entpInfoMageServiceRes.getResult() || entpInfoMageServiceRes.getResult().size()==0){
            return dataList;
        }
        final List<EntpInfoMageListVo> result = entpInfoMageServiceRes.getResult();
        final List<EntpInfoMageImportProceAgricPo> entpInfoMageListVoes = result.parallelStream().map(entpInfoMageListVo -> {
            EntpInfoMageImportProceAgricPo importProceAgricPo = new EntpInfoMageImportProceAgricPo();
            BeanUtils.copyProperties(entpInfoMageListVo,importProceAgricPo);
            return importProceAgricPo;
        }).collect(Collectors.toList());
        dataList = dataList.parallelStream().filter(importPo -> !entpInfoMageListVoes.contains(importPo)).collect(Collectors.toList());
        return dataList;
    }

    private boolean validateMand(List<EntpInfoMageImportProceAgricPo> dataDepartmentList) {
        String areaCodeRegx = "^[0-9]{12}$", enterNameRegx = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]{2,100}$";
        return dataDepartmentList.stream().anyMatch(importPo -> StringUtils.isBlank(importPo.getEntpName()) || !Pattern.compile(enterNameRegx).matcher(importPo.getEntpName()).matches()
        );
    }

    //校验种苗导入数据
    private boolean validateMandCompanies(List<EntpInfoSeedCompaniesImportPo> dataDepartmentList) {
        String areaCodeRegx = "^[0-9]{12}$", enterNameRegx = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]{2,100}$";
        return dataDepartmentList.stream().anyMatch(importPo ->
                        StringUtils.isNotBlank(importPo.getEntpName()) && Pattern.compile(enterNameRegx).matcher(importPo.getEntpName()).matches()
        );
    }
    //校验种植导入数据
    private boolean validateMandPlant(List<EntpInfoPlantEnterpriseImportPo> dataDepartmentList) {
        String areaCodeRegx = "^[0-9]{12}$", enterNameRegx = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]{2,100}$";
        boolean flag = dataDepartmentList.stream().anyMatch(importPo ->
                            StringUtils.isNotBlank(importPo.getEntpName()) && Pattern.compile(enterNameRegx).matcher(importPo.getEntpName()).matches()
        );

        return flag;
    }

    @ApiOperation(value = "导出企业信息")
    @RequestMapping(value = "excelExport", method = RequestMethod.POST)
    @DataCheck
    public void excelExport(@RequestBody EntpInfoMageListPo entpInfoMageList, HttpServletResponse response) {
        logger.info("导出的主体企业类型是：{}", entpInfoMageList.getEntpMainBusinessType());
            ResultPoJo<List<EntpInfoMageListVo>> excelExportList = null;
            entpInfoMageList.setEntpMainBusinessType(entpInfoMageList.getEntpMainBusinessType());
            excelExportList = entpInfoMageService.findList(entpInfoMageList);
            String fileName = null;
        try {
            if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_0.equals(entpInfoMageList.getEntpMainBusinessType())) {
                //种植主体信息导出
                fileName = "种植主体信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
                new ExportExcel("种植主体信息", EntpInfoPlantEnterpriseExportVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
            } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_1.equals(entpInfoMageList.getEntpMainBusinessType())) {
                //种苗企业导出
                fileName = "种苗企业信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
                new ExportExcel("种苗企业信息", EntpInfoSeedCompaniesExportVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
            } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_2.equals(entpInfoMageList.getEntpMainBusinessType())) {
                //农资企业导出
                fileName = "农资企业信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
                new ExportExcel("农资企业信息", EntpInfoMageExportVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
            } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_3.equals(entpInfoMageList.getEntpMainBusinessType())) {
                //农机企业导出
                fileName = "农机企业信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
                new ExportExcel("农机企业信息", EntpInfoMageExportVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
            } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_4.equals(entpInfoMageList.getEntpMainBusinessType())) {
                //农技企业导出
                fileName = "农技企业信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
                new ExportExcel("农技企业信息", EntpInfoMageExportVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
            } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_5.equals(entpInfoMageList.getEntpMainBusinessType())) {
                //精深加工导出
                fileName = "精深加工企业信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
                new ExportExcel("精深加工企业信息", EntpInfoMageExportVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
            }
        } catch (Exception e) {
            logger.error("导出企业信息失败！！！", e);
            throw ConstantError.BUS_999;
        }
    }

}
