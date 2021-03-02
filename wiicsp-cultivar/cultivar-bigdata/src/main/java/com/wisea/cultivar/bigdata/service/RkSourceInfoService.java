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
import com.wisea.cultivar.common.po.bigdata.*;
import com.wisea.cultivar.common.dao.bigdata.RkSourceInfoMapper;
import com.wisea.cultivar.common.entity.bigdata.RkSourceInfo;
import com.wisea.cultivar.common.vo.bigdata.RkSourceInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.RkSourceInfoListVo;
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
 * RkSourceInfoService
 * 入库货源信息 Service
 * 2019/12/02 11:02:15
 */
@Service
public class RkSourceInfoService extends BaseService {
    @Autowired
    protected RkSourceInfoMapper rkSourceInfoMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<RkSourceInfoListVo>> findPage(RkSourceInfoPagePo rkSourceInfoPagePo) {
        ResultPoJo<Page<RkSourceInfoListVo>> result = new ResultPoJo<>();
        Page<RkSourceInfoListVo> page = rkSourceInfoPagePo.getPage();
        List<RkSourceInfoListVo> list = rkSourceInfoMapper.findPage(rkSourceInfoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<RkSourceInfoListVo>> findList(RkSourceInfoListPo rkSourceInfoListPo) {
        ResultPoJo<List<RkSourceInfoListVo>> result = new ResultPoJo<>();
        result.setResult(rkSourceInfoMapper.findList(rkSourceInfoListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<RkSourceInfoGetVo> get(RkSourceInfoGetPo rkSourceInfoGetPo) {
        ResultPoJo<RkSourceInfoGetVo> result = new ResultPoJo<>();
        RkSourceInfo entity = rkSourceInfoMapper.selectByPrimaryKey(rkSourceInfoGetPo.getId());
        if(ConverterUtil.isNotEmpty(entity)){
            RkSourceInfoGetVo vo = new RkSourceInfoGetVo();
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
    public ResultPoJo<Object> saveOrUpdate(RkSourceInfoUpdatePo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();

        if(Double.parseDouble(po.getDqkc()) > Double.parseDouble(po.getZrk())){
            result.setCode(ConstantCodeMsg.ERR_005);
            result.setMsg("当前库存不能大于总入库");
            return result;
        }

        RkSourceInfo rkSourceInfo;
        if(ConverterUtil.isEmpty(po.getId())){
            //新增
            rkSourceInfo = new RkSourceInfo();
            BeanUtils.copyProperties(po, rkSourceInfo);
            rkSourceInfo.preInsert();
            rkSourceInfoMapper.insert(rkSourceInfo);
        }else{
            //修改
            rkSourceInfo = rkSourceInfoMapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(rkSourceInfo)){
                BeanUtils.copyProperties(po, rkSourceInfo);
                rkSourceInfo.preUpdate();
                rkSourceInfoMapper.updateByPrimaryKeySelective(rkSourceInfo);
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
    public ResultPoJo<Object> batDelete(RkSourceInfoBatDeletePo rkSourceInfoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : rkSourceInfoBatDeletePo.getDelList()) {
            RkSourceInfo rkSourceInfo = new RkSourceInfo();
            rkSourceInfo.setId(delId);
            rkSourceInfo.preUpdate();
            rkSourceInfoMapper.deleteLogic(rkSourceInfo);
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
            String fileName = "入库货源信息Excel模版.xlsx";
            ExportExcel exportExcel = new ExportExcel("入库货源信息", RkSourceInfo.class);
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
     * @Description 导出入库货源信息列表
     **/
    public ResultPoJo<Object> exportExcel(RkSourceInfoPagePo po, HttpServletResponse response) throws UnsupportedEncodingException {
        ResultPoJo<Object> result = new ResultPoJo<>();
        try {
            po.setPage(null);
            List<RkSourceInfoListVo> list = rkSourceInfoMapper.findPage(po);
            list.forEach(e->{
                if(DictConstants.SOURCE_TYPE_0.equals(e.getSourceType())){
                    e.setSourceType("国外货源");
                }else{
                    e.setSourceType("国内货源");
                }
            });
            String fileName = "入库货源信息.xlsx";
            ExportExcel exportExcel = new ExportExcel("入库货源信息", RkSourceInfo.class);
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
     * @Description 导入入库货源信息
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
                    List<RkSourceInfo> rkSourceInfos = importExcel.getDataList(RkSourceInfo.class);
                    AtomicReference<Boolean> checkFlag = new AtomicReference<>(true);
                    rkSourceInfos.forEach(rkSourceInfo -> {
                        if("国外货源".equals(rkSourceInfo.getSourceType())){
                            rkSourceInfo.setSourceType(DictConstants.SOURCE_TYPE_0);
                        }else if("国内货源".equals(rkSourceInfo.getSourceType())){
                            rkSourceInfo.setSourceType(DictConstants.SOURCE_TYPE_1);
                        }else{
                            checkFlag.set(false);
                        }
                        rkSourceInfo.preInsert();
                    });
                    if(checkFlag.get()){
                        rkSourceInfoMapper.batchInsert(rkSourceInfos);
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
