package com.wisea.cultivar.bigdata.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.BusinessException;
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
import com.wisea.cultivar.common.dao.bigdata.CgsNameMageMapper;
import com.wisea.cultivar.common.entity.bigdata.CgsNameMage;
import com.wisea.cultivar.common.po.bigdata.CgsNameMageGetPo;
import com.wisea.cultivar.common.po.bigdata.CgsNameMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.CgsNameMageListPo;
import com.wisea.cultivar.common.po.bigdata.CgsNameMagePagePo;
import com.wisea.cultivar.common.po.bigdata.CgsNameMageUpdatePo;
import com.wisea.cultivar.common.po.bigdata.UpdJyKtJy;
import com.wisea.cultivar.common.vo.bigdata.CgsNameMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.CgsNameMageListVo;
import com.wisea.cultivar.common.vo.bigdata.ExportCgsNameListVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * CgsNameMageService
 * 采购商名录管理 Service
 * 2019/12/02 11:02:14
 */
@Service
public class CgsNameMageService extends BaseService {
    @Autowired
    protected CgsNameMageMapper cgsNameMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<CgsNameMageListVo>> findPage(CgsNameMagePagePo cgsNameMagePagePo) {
        ResultPoJo<Page<CgsNameMageListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        Page<CgsNameMageListVo> page = cgsNameMagePagePo.getPage();
        List<CgsNameMageListVo> list = cgsNameMageMapper.findPage(cgsNameMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<CgsNameMageListVo>> findList(CgsNameMagePagePo cgsNameMagePagePo) {
        ResultPoJo<List<CgsNameMageListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<CgsNameMageListVo> list = cgsNameMageMapper.findPage(cgsNameMagePagePo);
        result.setResult(list);
        return result;
    }

    /**
     * 导出列表
     */
    public ResultPoJo<Object> exportCgsList(CgsNameMagePagePo po, HttpServletResponse response)  throws IOException {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        try {
            List<CgsNameMageListVo> list = cgsNameMageMapper.findPage(po);
            list.forEach(e -> {

                e.setJdwd("(".concat(e.getJd().toString()).concat(",").concat(e.getWd().toString()).concat(")"));
            });
            String fileName = "产地列表.xlsx";
            ExportExcel exportExcel = new ExportExcel("产地列表", ExportCgsNameListVo.class);
            exportExcel.setDataList(list).writeWithAjaxHeader(response, fileName).dispose();
        } catch (Exception e) {
            result.setCode(ConstantCodeMsg.ERR_110);
            result.setMsg(URLEncoder.encode(ConstantCodeMsg.MSG_110, "utf-8"));
            LoggerUtil.error("【exportExcel】导出列表出现异常：", e);
            AjaxDownLoadUtil.setResponseResult(response, result);
        }
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<CgsNameMageGetVo> get(CgsNameMageGetPo cgsNameMageGetPo) {
        ResultPoJo<CgsNameMageGetVo> result = new ResultPoJo<>();
        CgsNameMage entity = cgsNameMageMapper.selectByPrimaryKey(cgsNameMageGetPo.getId());
        CgsNameMageGetVo vo = new CgsNameMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(CgsNameMageInsertPo cgsNameMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        //校验名称是否存在
        CgsNameMageListPo info = new CgsNameMageListPo();
        info.setCgsName(cgsNameMageInsertPo.getCgsName());
        CgsNameMageListVo chake = cgsNameMageMapper.checkName(info);
        if (chake != null) {

            result.setCode(ConstantCodeMsg.ERR_310);
            result.setMsg("该名称已经存在！");
            return result;
        }
        CgsNameMage cgsNameMage = new CgsNameMage();
        ConverterUtil.copyProperties(cgsNameMageInsertPo, cgsNameMage);
        cgsNameMage.setSfyxFlag(DictConstants.SFKQ_FLAG_0);
        cgsNameMage.preInsert();
        cgsNameMageMapper.insert(cgsNameMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(CgsNameMageUpdatePo cgsNameMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        //校验名称是否存在
        CgsNameMageListPo info = new CgsNameMageListPo();
        info.setCgsName(cgsNameMageUpdatePo.getCgsName());
        info.setId(cgsNameMageUpdatePo.getId());
        CgsNameMageListVo chake = cgsNameMageMapper.checkName(info);
        if (chake != null) {

            result.setCode(ConstantCodeMsg.ERR_310);
            result.setMsg("该名称已经存在！");
            return result;
        }
        CgsNameMage cgsNameMage = new CgsNameMage();
        ConverterUtil.copyProperties(cgsNameMageUpdatePo, cgsNameMage);
        cgsNameMage.preUpdate();
        cgsNameMageMapper.updateByPrimaryKeySelective(cgsNameMage);
        return result;
    }

    /**
     * 删除、开通、禁用采购商名录管理
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> updState(UpdJyKtJy po) {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取信息
        CgsNameMage cgsNameMage = cgsNameMageMapper.selectByPrimaryKey(po.getId());
        //判断操作
        if ("2".equals(po.getKtflag())) {

            cgsNameMage.setDelFlag("1");
        }else if ("0".equals(po.getKtflag())) {
            if (DictConstants.SFKQ_FLAG_0.equals(cgsNameMage.getSfyxFlag())) {

                result.setCode(ConstantCodeMsg.ERR_410);
                result.setMsg(ConstantCodeMsg.MSG_410);
                return result;
            }
            cgsNameMage.setSfyxFlag(DictConstants.SFKQ_FLAG_0);
        }else if ("1".equals(po.getKtflag())) {
            if (DictConstants.SFKQ_FLAG_1.equals(cgsNameMage.getSfyxFlag())) {

                result.setCode(ConstantCodeMsg.ERR_410);
                result.setMsg(ConstantCodeMsg.MSG_410);
                return result;
            }
            cgsNameMage.setSfyxFlag(DictConstants.SFKQ_FLAG_1);
        }else {
        }
        cgsNameMage.preUpdate();
        cgsNameMageMapper.updateByPrimaryKeySelective(cgsNameMage);

        return result;
    }

    /**
     * 模版下载
     **/
    public ResultPoJo<Object> downloadTemplate(HttpServletResponse response) throws UnsupportedEncodingException {
        ResultPoJo<Object> result = new ResultPoJo<>();
        try {
            String fileName = "采购商名录Excel模版.xlsx";
            ExportExcel exportExcel = new ExportExcel("采购商名录", CgsNameMage.class);
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
     * 导入采购商名录
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
                    List<CgsNameMage> cgsNameList = importExcel.getDataList(CgsNameMage.class);
                    //校验
                    check(cgsNameList);
                    //去重
                    cgsNameList = cgsNameList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
                        new TreeSet<>(Comparator.comparing(CgsNameMage :: getCgsName))), ArrayList::new));
                    //如果跟数据库的重复，则覆盖
                    CgsNameMageListPo info = new CgsNameMageListPo();
                    List<CgsNameMageListVo> findList = cgsNameMageMapper.findList(info);
                    //转map便于校验
                    Map<String, Long> map = findList.stream().collect(Collectors.toMap(CgsNameMageListVo::getCgsName, CgsNameMageListVo::getId));
                    //list用于批量删除
                    String ids = "";
                    for (CgsNameMage e : cgsNameList) {
                        //如果跟数据库有重复，则删除数据库中的
                        String name = e.getCgsName().trim();
                        if (map.containsKey(name)) {
                            ids = ids.concat(map.get(name).toString()).concat(",");
                        }
                        //获取坐标点
                        List<String> str = numberCheck(e.getZbd());
                        e.setJd(ConverterUtil.toDouble(str.get(0)));
                        e.setWd(ConverterUtil.toDouble(str.get(1)));
                        e.setSfyxFlag(DictConstants.SFKQ_FLAG_0);
                        e.preInsert();
                    }
                    if (ids != "") {
                        String a = ids.substring(0, ids.length() - 1);
                        cgsNameMageMapper.delByIds(a);
                    }
                    cgsNameMageMapper.batchInsert(cgsNameList);
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

    /**
     * 校验数据
     *
     * @param list
     */
    private void check(List<CgsNameMage> list) {
        Supplier<Stream<CgsNameMage>> supplier = list::stream;
//        检查非空字段
        long count0 = supplier.get().filter(i -> StringUtils.isEmpty(i.getCgsName())).count();
        if (count0 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count1 = supplier.get().filter(i -> StringUtils.isEmpty(i.getCgsJc())).count();
        if (count1 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count2 = supplier.get().filter(i -> StringUtils.isEmpty(i.getCgsAddress())).count();
        if (count2 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count3 = supplier.get().filter(i -> i.getCjje() == null).count();
        if (count3 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        //检查坐标点是否规范
        long count5 = supplier.get().filter(i -> numberCheck(i.getZbd()).size() != 2).count();
        if (count5 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_113, ConstantCodeMsg.MSG_113);
        }
    }

    /**
     * 正则，直接取出数字
     *
     * @param coord
     * @return
     */
    public List<String> numberCheck(String coord) {

        String pattern = "-?([1-9]\\d*\\.\\d+|0\\.\\d*[1-9]\\d*|0?\\.0+|0|[1-9]\\d*|-[1-9]\\d*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(coord);
        List<String> result = new ArrayList<>();
        while (m.find()) {
            result.add(m.group());
        }
        return result;
    }
}
