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
import com.wisea.cultivar.common.dao.bigdata.ZdInfoMageMapper;
import com.wisea.cultivar.common.entity.bigdata.CgsNameMage;
import com.wisea.cultivar.common.entity.bigdata.ZdInfoMage;
import com.wisea.cultivar.common.po.bigdata.UpdJyKtJy;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMageGetPo;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMageListPo;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMagePagePo;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMageUpdatePo;
import com.wisea.cultivar.bigdata.utils.RedPacketUtil;
import com.wisea.cultivar.common.vo.bigdata.ExportZdInfoListVo;
import com.wisea.cultivar.common.vo.bigdata.ZdInfoMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.ZdInfoMageListVo;
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
 * ZdInfoMageService
 * 站点信息管理 Service
 * 2019/12/02 11:02:15
 */
@Service
public class ZdInfoMageService extends BaseService {
    @Autowired
    protected ZdInfoMageMapper zdInfoMageMapper;
    @Autowired
    protected CgsNameMageMapper cgsNameMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZdInfoMageListVo>> findPage(ZdInfoMagePagePo zdInfoMagePagePo) {
        ResultPoJo<Page<ZdInfoMageListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        Page<ZdInfoMageListVo> page = zdInfoMagePagePo.getPage();
        List<ZdInfoMageListVo> list = zdInfoMageMapper.findPage(zdInfoMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 导出列表
     */
    public ResultPoJo<Object> exportZdList(ZdInfoMagePagePo po, HttpServletResponse response)  throws IOException {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        try {
            List<ZdInfoMageListVo> list = zdInfoMageMapper.findPage(po);
            list.forEach(e -> {
                if (DictConstants.ZD_TYPE_0.equals(e.getZdType())) {
                    e.setZdType("大仓点");
                }else {
                    e.setZdType("采购点");
                }
                e.setJdwd("(".concat(e.getJd().toString()).concat(",").concat(e.getWd().toString()).concat(")"));
            });
            String fileName = "站点信息列表.xlsx";
            ExportExcel exportExcel = new ExportExcel("站点信息列表", ExportZdInfoListVo.class);
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
     * 查询列表
     */
    public ResultPoJo<List<ZdInfoMageListVo>> findList(ZdInfoMageListPo po) {
        ResultPoJo<List<ZdInfoMageListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        po.setSfyxFlag(DictConstants.SFKQ_FLAG_0);
        List<ZdInfoMageListVo> findList = zdInfoMageMapper.findList(po);
        if (findList.size() > 0) {
            Map<Long, List<ZdInfoMageListVo>> voMap = findList.stream().collect(Collectors.groupingBy(ZdInfoMageListVo::getCgsId));
            voMap.forEach((cgsId, voList)->{
                //判断站点金额之和是否等于采购商金额
                Double amount = 0D;
                int count = 0;
                for (ZdInfoMageListVo e : voList) {

                    if (e.getZdAmount() != null) {
                        //计算站点总金额
                        amount = ConverterUtil.add(amount, e.getZdAmount());
                    }else {
                        count++;
                    }
                }
                //获取采购商总金额
                CgsNameMage cgsNameMage = cgsNameMageMapper.selectByPrimaryKey(cgsId);
                //判断站点信息是否改变过
                if (amount != cgsNameMage.getCjje() || count != 0) {
                    //计算所需金额
                    Double cjje = cgsNameMage.getCjje();
                    double div = ConverterUtil.div(cjje, voList.size(), 3);
                    //最大值(向上浮动20%)
                    double max = ConverterUtil.getRoundValue(ConverterUtil.mul(div, 1.2), 2);
                    //最小值(向下浮动20%)
                    double min = ConverterUtil.getRoundValue(ConverterUtil.mul(div, 0.8), 2);
                    //获取红包列表
                    List<Double> redList = RedPacketUtil.splitRedPacket(cjje, voList.size(), min, max, null);
                    //计算每个站点金额
                    int i = 0;
                    List<ZdInfoMage> zdList = Lists.newArrayList();
                    for (ZdInfoMageListVo e : voList) {

                        e.setZdAmount(redList.get(i));
                        //入库并且把其他的站点的金额设为null
                        ZdInfoMage zdInfoMage = new ZdInfoMage();
                        zdInfoMage.setId(e.getId());
                        zdInfoMage.setZdAmount(redList.get(i));
                        zdInfoMage.preUpdate();
                        zdList.add(zdInfoMage);
                        i++;
                    }
                    //把其他的站点的金额设为null
                    zdInfoMageMapper.setNullBySfyx();
                    zdInfoMageMapper.batchUpdate(zdList);
                }
            });
        }
        result.setResult(findList);
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZdInfoMageGetVo> get(ZdInfoMageGetPo zdInfoMageGetPo) {
        ResultPoJo<ZdInfoMageGetVo> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        ZdInfoMage entity = zdInfoMageMapper.selectByPrimaryKey(zdInfoMageGetPo.getId());
        ZdInfoMageGetVo vo = new ZdInfoMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ZdInfoMageInsertPo zdInfoMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //如果跟数据库的重复，则提示
        ZdInfoMageListPo info = new ZdInfoMageListPo();
        info.setCgsId(zdInfoMageInsertPo.getCgsId());
        info.setZdName(zdInfoMageInsertPo.getZdName());
        ZdInfoMageListVo checkName = zdInfoMageMapper.checkName(info);
        if (checkName != null) {

            result.setCode(ConstantCodeMsg.ERR_310);
            result.setMsg("该名称已经存在！");
            return result;
        }
        ZdInfoMage zdInfoMage = new ZdInfoMage();
        ConverterUtil.copyProperties(zdInfoMageInsertPo, zdInfoMage);
        zdInfoMage.preInsert();
        zdInfoMage.setSfyxFlag(DictConstants.SFKQ_FLAG_0);
        zdInfoMageMapper.insert(zdInfoMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ZdInfoMageUpdatePo zdInfoMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //如果跟数据库的重复，则提示
        ZdInfoMageListPo info = new ZdInfoMageListPo();
        info.setCgsId(zdInfoMageUpdatePo.getCgsId());
        info.setZdName(zdInfoMageUpdatePo.getZdName());
        info.setId(zdInfoMageUpdatePo.getId());
        ZdInfoMageListVo checkName = zdInfoMageMapper.checkName(info);
        if (checkName != null) {

            result.setCode(ConstantCodeMsg.ERR_310);
            result.setMsg("该名称已经存在！");
            return result;
        }
        ZdInfoMage zdInfoMage = new ZdInfoMage();
        ConverterUtil.copyProperties(zdInfoMageUpdatePo, zdInfoMage);
        zdInfoMage.preUpdate();
        zdInfoMageMapper.updateByPrimaryKeySelective(zdInfoMage);
        return result;
    }

    /**
     * 删除、开通、禁用采购商名录管理
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> updState(UpdJyKtJy po) {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取信息
        ZdInfoMage zdInfoMage = zdInfoMageMapper.selectByPrimaryKey(po.getId());
        //判断操作
        if ("2".equals(po.getKtflag())) {

            zdInfoMage.setDelFlag("1");
        }else if ("0".equals(po.getKtflag())) {
            if (DictConstants.SFKQ_FLAG_0.equals(zdInfoMage.getSfyxFlag())) {

                result.setCode(ConstantCodeMsg.ERR_410);
                result.setMsg(ConstantCodeMsg.MSG_410);
                return result;
            }
            zdInfoMage.setSfyxFlag(DictConstants.SFKQ_FLAG_0);
        }else if ("1".equals(po.getKtflag())) {
            if (DictConstants.SFKQ_FLAG_1.equals(zdInfoMage.getSfyxFlag())) {

                result.setCode(ConstantCodeMsg.ERR_410);
                result.setMsg(ConstantCodeMsg.MSG_410);
                return result;
            }
            zdInfoMage.setSfyxFlag(DictConstants.SFKQ_FLAG_1);
        }else {
        }
        zdInfoMage.preUpdate();
        zdInfoMageMapper.updateByPrimaryKeySelective(zdInfoMage);

        return result;
    }

    /**
     * 模版下载
     **/
    public ResultPoJo<Object> downloadTemplate(HttpServletResponse response) throws UnsupportedEncodingException {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        try {
            String fileName = "站点信息Excel模版.xlsx";
            ExportExcel exportExcel = new ExportExcel("站点信息", ZdInfoMage.class);
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
     * 导入站点信息
     **/
    public ResultPoJo<Object> importExcel(Long cgsId, MultipartFile upfile, MultipartHttpServletRequest request) {
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
                    List<ZdInfoMage> zdInfoList = importExcel.getDataList(ZdInfoMage.class);
                    //校验
                    check(zdInfoList);
                    //去重
                    zdInfoList = zdInfoList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
                        new TreeSet<>(Comparator.comparing(ZdInfoMage :: getZdName))), ArrayList::new));
                    //如果跟数据库的重复，则覆盖
                    ZdInfoMageListPo info = new ZdInfoMageListPo();
                    info.setCgsId(cgsId);
                    List<ZdInfoMageListVo> findList = zdInfoMageMapper.findList(info);
                    //转map便于校验
                    Map<String, Long> map = findList.stream().collect(Collectors.toMap(ZdInfoMageListVo::getZdName, ZdInfoMageListVo::getId));
                    //list用于批量删除
                    String ids = "";
                    for (ZdInfoMage e : zdInfoList) {
                        //如果跟数据库有重复，则删除数据库中的
                        String name = e.getZdName().trim();
                        if (map.containsKey(name)) {
                            ids = ids.concat(map.get(name).toString()).concat(",");
                        }
                        if ("大仓点".equals(e.getZdType())) {

                            e.setZdType(DictConstants.ZD_TYPE_0);
                        }else if ("采购点".equals(e.getZdType())) {

                            e.setZdType(DictConstants.ZD_TYPE_1);
                        }else {
                        }
                        //获取坐标点
                        List<String> str = numberCheck(e.getZbd());
                        e.setJd(ConverterUtil.toDouble(str.get(0)));
                        e.setWd(ConverterUtil.toDouble(str.get(1)));
                        e.setCgsId(cgsId);
                        e.setSfyxFlag(DictConstants.SFKQ_FLAG_0);
                        e.preInsert();
                    }
                    if (ids != "") {
                        String a = ids.substring(0, ids.length() - 1);
                        zdInfoMageMapper.delByIds(a);
                    }
                    zdInfoMageMapper.batchInsert(zdInfoList);
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
    private void check(List<ZdInfoMage> list) {
        Supplier<Stream<ZdInfoMage>> supplier = list::stream;
        //检查非空字段
        long count0 = supplier.get().filter(i -> StringUtils.isEmpty(i.getZdName())).count();
        if (count0 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count1 = supplier.get().filter(i -> StringUtils.isEmpty(i.getZdAddress())).count();
        if (count1 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count2 = supplier.get().filter(i -> StringUtils.isEmpty(i.getZdType())).count();
        if (count2 > 0) {
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
