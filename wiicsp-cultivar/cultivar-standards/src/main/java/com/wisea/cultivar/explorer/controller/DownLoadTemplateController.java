package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.explorer.po.DownLoadTemplatePo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * <p>
 * explain: 下载模板相关接口
 * </p>
 *
 * @author wangjunming
 * @since 2020/8/4 17:28
 */
@Api(tags = "下载模板相关接口")
@RequestMapping(value = "/w/template")
@RestController
@PreAuthorize("hasAnyAuthority('ep:pla','ep:see','ep:pro','ep:mac','ep:skl','ep:prc','ep:org','ep:sup','ep:pl:var','ep:brd')")
public class DownLoadTemplateController {

    private static final Logger log = LoggerFactory.getLogger(DownLoadTemplateController.class);
    private static final int BUFFER = 1024 * 8;

    private void downloadFileByPath(String fileName, HttpServletResponse response) {
        String fName = null;
        try {
            fName = ConverterUtil.toDownloadName(URLEncoder.encode(fileName, "utf8"));
        } catch (UnsupportedEncodingException e) {
            log.error("转换文件名失败！",e);
            throw ConstantError.BUS_999;
        }
        response.addHeader("Access-Control-Expose-Headers", "ajax-mimeType, ajax-filename");
        response.setHeader("Content-Disposition", "attachment; filename=" + fName);
        response.setHeader("ajax-mimeType", "application/vnd.ms-excel");
        response.setHeader("ajax-filename", fName);
        response.setContentType("application/octet-stream; charset=utf-8");
        InputStream inputStream = this.getClass().getResourceAsStream("/excel/"+fileName);
        OutputStream os = null;
        try{
            os = response.getOutputStream();
            byte[] b = new byte[BUFFER];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (Exception e){
            log.error("下载失败！",e);
            throw ConstantError.BUS_999;
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("关闭流失败！",e);
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    log.error("关闭流失败！",e);
                }
            }
        }
    }

    @ApiOperation(value = "下载模板")
    @RequestMapping(value = "download", method = RequestMethod.POST)
    @DataCheck
    public void download(@RequestBody DownLoadTemplatePo downLoadTemplatePo, HttpServletResponse response) {
        final String templateType = downLoadTemplatePo.getTemplateType();
        final String types = downLoadTemplatePo.getTypes();
        log.info("下载模板-templateType：{}，-types：{}", templateType, types);
        if (QdcyStandardsDict.ORG_TYPE.equals(templateType)) {
            if (QdcyStandardsDict.ORG_TYPE_0.equals(types)) {
                String fileName = "检测机构目录信息导入模板.xlsx";
                downloadFileByPath(fileName, response);
            } else if (QdcyStandardsDict.ORG_TYPE_1.equals(types)) {
                String fileName = "监管部门目录信息导入模板.xlsx";
                downloadFileByPath(fileName, response);
            }
        } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE.equals(templateType)) {
            if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_0.equals(types)) {
                String fileName = "种植主体目录信息导入模板.xlsx";
                downloadFileByPath(fileName, response);
            } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_1.equals(types)) {
                String fileName = "种苗企业目录信息导入模板.xlsx";
                downloadFileByPath(fileName, response);
            } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_2.equals(types)) {
                String fileName = "农资企业目录信息导入模板.xlsx";
                downloadFileByPath(fileName, response);
            } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_3.equals(types)) {
                String fileName = "农机企业目录信息导入模板.xlsx";
                downloadFileByPath(fileName, response);
            } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_4.equals(types)) {
                String fileName = "农技企业目录信息导入模板.xlsx";
                downloadFileByPath(fileName, response);
            } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_5.equals(types)) {
                String fileName = "加工企业目录信息导入模板.xlsx";
                downloadFileByPath(fileName, response);
            }
        }else if("tea_oil".equals(templateType)){
            if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_0.equals(types)) {
                String fileName = "油茶品种目录信息导入模板.xlsx";
                downloadFileByPath(fileName, response);
            } else if (QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_1.equals(types)) {
                String fileName = "茶油品牌目录信息导入模板.xlsx";
                downloadFileByPath(fileName, response);
            }
        }

    }

}
