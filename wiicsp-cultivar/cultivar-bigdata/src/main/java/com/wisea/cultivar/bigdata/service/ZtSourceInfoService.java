package com.wisea.cultivar.bigdata.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.AjaxDownLoadUtil;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.common.util.excel.ImportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.constants.ConstantCodeMsg;
import com.wisea.cultivar.bigdata.constants.DictConstants;
import com.wisea.cultivar.common.po.bigdata.ZtSourceInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.ZtSourceInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.ZtSourceInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.ZtSourceInfoUpdatePo;
import com.wisea.cultivar.common.dao.bigdata.ZtSourceInfoMapper;
import com.wisea.cultivar.common.entity.bigdata.ZtSourceInfo;
import com.wisea.cultivar.common.vo.bigdata.ZtSourceInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.ZtSourceInfoListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ZtSourceInfoService
 * 在途货源信息 Service
 * 2019/12/02 11:02:15
 */
@Service
public class ZtSourceInfoService extends BaseService {
    @Autowired
    protected ZtSourceInfoMapper ztSourceInfoMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZtSourceInfoListVo>> findPage(ZtSourceInfoPagePo ztSourceInfoPagePo) {
        ResultPoJo<Page<ZtSourceInfoListVo>> result = new ResultPoJo<>();
        Page<ZtSourceInfoListVo> page = ztSourceInfoPagePo.getPage();
        List<ZtSourceInfoListVo> list = ztSourceInfoMapper.findPage(ztSourceInfoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZtSourceInfoGetVo> get(ZtSourceInfoGetPo ztSourceInfoGetPo) {
        ResultPoJo<ZtSourceInfoGetVo> result = new ResultPoJo<>();
        ZtSourceInfo entity = ztSourceInfoMapper.selectByPrimaryKey(ztSourceInfoGetPo.getId());
        if(ConverterUtil.isNotEmpty(entity)){
            ZtSourceInfoGetVo vo = new ZtSourceInfoGetVo();
            ConverterUtil.copyProperties(entity, vo);
            result.setResult(vo);
        }else{
            result.setCode(ConstantCodeMsg.ERR_004);
            result.setMsg(ConstantCodeMsg.MSG_004);
        }
        return result;
    }

    /**
     * 新增/修改入库货源信息
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> saveOrUpdate(ZtSourceInfoUpdatePo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZtSourceInfo ztSourceInfo;
        if(ConverterUtil.isEmpty(po.getId())){
            //新增
            ztSourceInfo = new ZtSourceInfo();
            BeanUtils.copyProperties(po, ztSourceInfo);
            ztSourceInfo.preInsert();
            ztSourceInfoMapper.insert(ztSourceInfo);
        }else{
            //修改
            ztSourceInfo = ztSourceInfoMapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(ztSourceInfo)){
                BeanUtils.copyProperties(po, ztSourceInfo);
                ztSourceInfo.preUpdate();
                ztSourceInfoMapper.updateByPrimaryKeySelective(ztSourceInfo);
            }else{
                result.setCode(ConstantCodeMsg.ERR_004);
                result.setMsg(ConstantCodeMsg.MSG_004);
            }
        }
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ZtSourceInfoBatDeletePo ztSourceInfoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : ztSourceInfoBatDeletePo.getDelList()) {
            ZtSourceInfo ztSourceInfo = new ZtSourceInfo();
            ztSourceInfo.setId(delId);
            ztSourceInfo.preUpdate();
            ztSourceInfoMapper.deleteLogic(ztSourceInfo);
        }
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/12/5 12:30
     * @Description 模版下载
     **/
    public ResultPoJo<Object> downloadTemplate(HttpServletResponse response) throws UnsupportedEncodingException {
        ResultPoJo<Object> result = new ResultPoJo<>();
        try {
            String fileName = "在途货源信息Excel模版.xlsx";
            ExportExcel exportExcel = new ExportExcel("在途货源信息", ZtSourceInfo.class);
            exportExcel.setDataList(Lists.newArrayList()).writeWithAjaxHeader(response, fileName).dispose();
        } catch (IOException e) {
            result.setCode(ConstantCodeMsg.ERR_110);
            result.setMsg(URLEncoder.encode(ConstantCodeMsg.MSG_110, "utf-8"));
            LoggerUtil.error("【downloadTemplate】模版下载出现异常：", e);
            AjaxDownLoadUtil.setResponseResult(response, result);
        }
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/12/5 14:04
     * @Description 导出锁定货源信息列表
     **/
    public ResultPoJo<Object> exportExcel(ZtSourceInfoPagePo po, HttpServletResponse response) throws UnsupportedEncodingException {
        ResultPoJo<Object> result = new ResultPoJo<>();
        try {
            po.setPage(null);
            List<ZtSourceInfoListVo> list = ztSourceInfoMapper.findPage(po);
            list.forEach(e->{
                if(DictConstants.SOURCE_TYPE_0.equals(e.getSourceType())){
                    e.setSourceType("国外货源");
                }else{
                    e.setSourceType("国内货源");
                }
            });
            String fileName = "在途货源信息.xlsx";
            ExportExcel exportExcel = new ExportExcel("在途货源信息", ZtSourceInfo.class);
            exportExcel.setDataList(list).writeWithAjaxHeader(response, fileName).dispose();
        } catch (IOException e) {
            result.setCode(ConstantCodeMsg.ERR_110);
            result.setMsg(URLEncoder.encode(ConstantCodeMsg.MSG_110, "utf-8"));
            LoggerUtil.error("【exportExcel】导出列表出现异常：", e);
            AjaxDownLoadUtil.setResponseResult(response, result);
        }
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/12/5 14:11
     * @Description 导入锁定货源信息
     **/
    public ResultPoJo<Object> importExcel(MultipartFile upfile, MultipartHttpServletRequest request) {
        //初期化处理
        ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantError.NOMAL);
        Iterator<String> itr = request.getFileNames();
        // 只传递一个文件
        while (itr.hasNext()) {
            try {
                String paramName = itr.next();
                // 获取需要上传的文件
                List<MultipartFile> mfList = request.getFiles(paramName);
                for (MultipartFile mf : mfList) {
                    ImportExcel importExcel = new ImportExcel(mf, 1, 0);
                    List<ZtSourceInfo> ztSourceInfos = importExcel.getDataList(ZtSourceInfo.class);
                    AtomicReference<Boolean> checkFlag = new AtomicReference<>(true);
                    ztSourceInfos.forEach(ztSourceInfo -> {
                        if("国外货源".equals(ztSourceInfo.getSourceType())){
                            ztSourceInfo.setSourceType(DictConstants.SOURCE_TYPE_0);
                        }else if("国内货源".equals(ztSourceInfo.getSourceType())){
                            ztSourceInfo.setSourceType(DictConstants.SOURCE_TYPE_1);
                        }else{
                            checkFlag.set(false);
                        }
                        ztSourceInfo.preInsert();
                    });
                    if(checkFlag.get()){
                        ztSourceInfoMapper.batchInsert(ztSourceInfos);
                    }else{
                        result.setCode(ConstantCodeMsg.ERR_112);
                        result.setMsg("数据校验未通过，货源类型只能为：国内货源/国外货源");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                result.setCode(ConstantCodeMsg.ERR_001);
                result.setMsg(ConstantCodeMsg.MSG_001);
            }
        }
        return result;
    }
}
