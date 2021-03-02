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
import com.wisea.cultivar.common.dao.bigdata.CategoryMageMapper;
import com.wisea.cultivar.common.dao.bigdata.JyOrdMageMapper;
import com.wisea.cultivar.common.dao.bigdata.SubEntpMageMapper;
import com.wisea.cultivar.common.entity.bigdata.JyOrdMage;
import com.wisea.cultivar.bigdata.utils.CacheUtil;
import com.wisea.cultivar.common.vo.bigdata.CategoryAndVarietiesListVo;
import com.wisea.cultivar.common.vo.bigdata.JyOrdMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.JyOrdMageListVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * JyOrdMageService
 * 交易订单管理 Service
 * 2019/12/02 11:02:14
 */
@Service
public class JyOrdMageService extends BaseService {
    @Autowired
    protected JyOrdMageMapper jyOrdMageMapper;
    @Autowired
    protected SubEntpMageMapper subEntpMageMapper;
    @Autowired
    protected CategoryMageMapper categoryMageMapper;


    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<JyOrdMageListVo>> findPage(JyOrdMagePagePo po) {
        ResultPoJo<Page<JyOrdMageListVo>> result = new ResultPoJo<>();
        Page<JyOrdMageListVo> page = po.getPage();
        List<JyOrdMageListVo> list = jyOrdMageMapper.findPage(po);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<JyOrdMageListVo>> findList(JyOrdMageListPo jyOrdMageListPo) {
        ResultPoJo<List<JyOrdMageListVo>> result = new ResultPoJo<>();
        result.setResult(jyOrdMageMapper.findList(jyOrdMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<JyOrdMageGetVo> get(JyOrdMageGetPo jyOrdMageGetPo) {
        ResultPoJo<JyOrdMageGetVo> result = new ResultPoJo<>();
        JyOrdMage entity = jyOrdMageMapper.selectByPrimaryKey(jyOrdMageGetPo.getId());
        if(ConverterUtil.isNotEmpty(entity)){
            JyOrdMageGetVo vo = new JyOrdMageGetVo();
            ConverterUtil.copyProperties(entity, vo);
            result.setResult(vo);
        }else{
            result.setCode(ConstantCodeMsg.ERR_004);
            result.setMsg(ConstantCodeMsg.MSG_004);
        }
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(JyOrdMageInsertPo jyOrdMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        JyOrdMage jyOrdMage = new JyOrdMage();
        ConverterUtil.copyProperties(jyOrdMageInsertPo, jyOrdMage);
        jyOrdMage.preInsert();
        jyOrdMageMapper.insert(jyOrdMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(JyOrdMageUpdatePo jyOrdMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        JyOrdMage jyOrdMage = new JyOrdMage();
        ConverterUtil.copyProperties(jyOrdMageUpdatePo, jyOrdMage);
        jyOrdMage.preUpdate();
        jyOrdMageMapper.updateByPrimaryKeySelective(jyOrdMage);
        //清除缓存
        CacheUtil.clearTotalOrderSalesCache();
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(JyOrdMageBatDeletePo jyOrdMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : jyOrdMageBatDeletePo.getDelList()) {
            JyOrdMage jyOrdMage = new JyOrdMage();
            jyOrdMage.setId(delId);
            jyOrdMage.preUpdate();
            jyOrdMageMapper.deleteLogic(jyOrdMage);
        }
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/12/3 15:22
     * @Description 导出交易订单列表
     **/
    public ResultPoJo<Object> exportExcel(JyOrdMagePagePo po, HttpServletResponse response) throws UnsupportedEncodingException {
        ResultPoJo<Object> result = new ResultPoJo<>();
        try {
            po.setPage(null);
            List<JyOrdMageListVo> list = jyOrdMageMapper.findPage(po);
            String fileName = "交易订单列表.xlsx";
            ExportExcel exportExcel = new ExportExcel("交易订单列表", JyOrdMageListVo.class);
            exportExcel.setDataList(list).writeWithAjaxHeader(response, fileName).dispose();
        } catch (IOException e) {
            result.setCode(ConstantCodeMsg.ERR_110);
            result.setMsg(URLEncoder.encode(ConstantCodeMsg.MSG_110, "utf-8"));
            LoggerUtil.error("【exportExcel】导出出现异常：", e);
            AjaxDownLoadUtil.setResponseResult(response, result);
        }
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/12/3 16:06
     * @Description 导入交易订单列表
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
                    ImportExcel importExcel = new ImportExcel(mf, 4, 0);
                    List<JyOrdMage> jyOrdMages = importExcel.getDataList(JyOrdMage.class);
                    jyOrdMages = jyOrdMages.stream().filter(e->{return ConverterUtil.isNotEmpty(e.getOrdNum());}).collect(Collectors.toList());
                    List<String> importOrdNums = jyOrdMages.stream().map(JyOrdMage::getOrdNum).collect(Collectors.toList())
                                                        .stream().distinct().collect(Collectors.toList());
                    //防止重复导入校验
                    List<String> ordNums = jyOrdMageMapper.findOrdNums();
                    if(Collections.disjoint(ordNums, importOrdNums)){
                        //查询所有子公司列表
                        List<SubEntpMageListVo> list = subEntpMageMapper.findList(new SubEntpMageListPo());
                        Map<String, Long> subEntpMap = list.stream().collect(Collectors.toMap(SubEntpMageListVo::getSubEntpName, SubEntpMageListVo::getId));

                        //查询所有物料编码、物料分类
                        List<CategoryAndVarietiesListVo> categoryAndVarietiesListVos = categoryMageMapper.findCategoryAndVarietiesList();
                        Map<String, CategoryAndVarietiesListVo> categoryAndVarietiesMap = categoryAndVarietiesListVos.stream().collect(Collectors.toMap(CategoryAndVarietiesListVo::getVarietiesNum, Function.identity()));

                        //导入批次号
                        String ordPcNum = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

                        AtomicReference<Boolean> entpCheckFlag = new AtomicReference<>(true); //企业校验
                        List<String> entpCheckFailOrdNums = Lists.newArrayList(); //企业校验未通过的订单编号列表
                        AtomicReference<Boolean> varietiesCheckFlag = new AtomicReference<>(true); //物料校验
                        List<String> varietiesCheckFailOrdNums = Lists.newArrayList(); //物料校验未通过的订单编号列表

                        jyOrdMages.forEach(jyOrdMage -> {
                            //判断是否是总公司订单
                            if(DictConstants.COMPANY_NAME.equals(jyOrdMage.getSaleOrg())){
                                jyOrdMage.setMainSubEntpFlag(DictConstants.MAIN_SUB_ENTP_FLAG_0);
                            }else if(subEntpMap.containsKey(jyOrdMage.getSaleOrg())){
                                jyOrdMage.setMainSubEntpFlag(DictConstants.MAIN_SUB_ENTP_FLAG_1);
                                jyOrdMage.setEntpId(subEntpMap.get(jyOrdMage.getSaleOrg()));
                            }else{
                                entpCheckFlag.set(false);
                                entpCheckFailOrdNums.add(jyOrdMage.getOrdNum());
                            }

                            //判断物料编号及物料分类
                            if(categoryAndVarietiesMap.containsKey(jyOrdMage.getWlCode())){
                                CategoryAndVarietiesListVo categoryAndVarietiesListVo = categoryAndVarietiesMap.get(jyOrdMage.getWlCode());
                                jyOrdMage.setCategoryId(categoryAndVarietiesListVo.getId()); //设置物料分类ID
                                jyOrdMage.setCategoryName(categoryAndVarietiesListVo.getCategoryName()); //设置物料分类名称
                            }else{
                                varietiesCheckFlag.set(false);
                                varietiesCheckFailOrdNums.add(jyOrdMage.getOrdNum());
                            }

                            jyOrdMage.setDrDate(OffsetDateTime.now());
                            jyOrdMage.setOrdPcNum(ordPcNum);
                            jyOrdMage.preInsert();
                        });

                        if(entpCheckFlag.get() && varietiesCheckFlag.get()){
                            //批量插入数据
                            jyOrdMageMapper.batchInsert(jyOrdMages);
                            //清除缓存
                            CacheUtil.clearTotalOrderSalesCache();
                        }else{
                            result.setCode(ConstantCodeMsg.ERR_112);
                            StringBuffer sb = new StringBuffer();
                            if(entpCheckFailOrdNums.size() > 0){
                                sb.append(MessageFormat.format("订单编号为：{0}，未关联到供应商", entpCheckFailOrdNums.stream().distinct().collect(Collectors.toList()).toString()));
                                sb.append("，");
                            }
                            if(varietiesCheckFailOrdNums.size() > 0){
                                sb.append(MessageFormat.format("订单编号为：{0}，未关联到物料编号", varietiesCheckFailOrdNums.stream().distinct().collect(Collectors.toList()).toString()));
                                sb.append("，");
                            }
                            result.setMsg(sb.substring(0, sb.length() - 1));
                        }
                    }else{
                        importOrdNums.retainAll(ordNums);
                        result.setCode(ConstantCodeMsg.ERR_111);
                        result.setMsg(MessageFormat.format(ConstantCodeMsg.MSG_111, importOrdNums.toString()));
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
