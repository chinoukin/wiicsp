package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.common.util.excel.ImportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.constants.ConstantCodeMsg;
import com.wisea.cultivar.bigdata.constants.DictConstants;
import com.wisea.cultivar.common.dao.bigdata.OrdYjInfoMapper;
import com.wisea.cultivar.common.entity.bigdata.OrdYjInfo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoListPo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.OrdYjInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.OrdYjInfoListVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * OrdYjInfoService
 * 订单预警信息 Service
 * 2019/12/02 11:02:15
 */
@Service
public class OrdYjInfoService extends BaseService {
    @Autowired
    protected OrdYjInfoMapper ordYjInfoMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<OrdYjInfoListVo>> findPage(OrdYjInfoPagePo ordYjInfoPagePo) {
        ResultPoJo<Page<OrdYjInfoListVo>> result = new ResultPoJo<>();
        Page<OrdYjInfoListVo> page = ordYjInfoPagePo.getPage();
        List<OrdYjInfoListVo> list = ordYjInfoMapper.findPage(ordYjInfoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<OrdYjInfoListVo>> findList(OrdYjInfoListPo ordYjInfoListPo) {
        ResultPoJo<List<OrdYjInfoListVo>> result = new ResultPoJo<>();
        result.setResult(ordYjInfoMapper.findList(ordYjInfoListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<OrdYjInfoGetVo> get(OrdYjInfoGetPo ordYjInfoGetPo) {
        ResultPoJo<OrdYjInfoGetVo> result = new ResultPoJo<>();
        OrdYjInfo entity = ordYjInfoMapper.selectByPrimaryKey(ordYjInfoGetPo.getId());
        OrdYjInfoGetVo vo = new OrdYjInfoGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional
    public ResultPoJo insert(OrdYjInfoInsertPo ordYjInfoInsertPo) {
        ResultPoJo result = new ResultPoJo<>();
        OrdYjInfo ordYjInfo = new OrdYjInfo();
        ConverterUtil.copyProperties(ordYjInfoInsertPo, ordYjInfo);
        ordYjInfo.preInsert();
        ordYjInfoMapper.insert(ordYjInfo);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo update(OrdYjInfoUpdatePo ordYjInfoUpdatePo) {
        ResultPoJo result = new ResultPoJo<>();
        OrdYjInfo ordYjInfo = new OrdYjInfo();
        ConverterUtil.copyProperties(ordYjInfoUpdatePo, ordYjInfo);
        ordYjInfo.preUpdate();
        ordYjInfoMapper.updateByPrimaryKeySelective(ordYjInfo);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional
    public ResultPoJo batDelete(OrdYjInfoBatDeletePo ordYjInfoBatDeletePo) {
        ResultPoJo result = new ResultPoJo();
        for (Long delId : ordYjInfoBatDeletePo.getDelList()) {
            OrdYjInfo ordYjInfo = new OrdYjInfo();
            ordYjInfo.setId(delId);
            ordYjInfo.preUpdate();
            ordYjInfoMapper.deleteLogic(ordYjInfo);
        }
        return result;
    }

    //字典:预警类型中文
    private static List<String> YJ_TYPE_STR_LIST = Arrays.asList("可能延误", "运输故障");

    /**
     * excel导入数据
     * 数据字典:预警类型 0:可能延误
     * 预警类型 1:运输故障
     */
    @Transactional
    public ResultPoJo excelImport(MultipartFile file) throws Exception {
        ResultPoJo poJo = new ResultPoJo();

        ImportExcel excel = new ImportExcel(file, 1, 0);
        List<OrdYjInfo> list = excel.getDataList(OrdYjInfo.class);
        //校验
        check(list);

        list.forEach(i -> {
            if (i.getLogisticsDriverTel().toLowerCase().contains("e")) {
                BigDecimal bd1 = new BigDecimal(i.getLogisticsDriverTel());
                i.setLogisticsDriverTel(bd1.toPlainString());
            }
            i.setYjType(YJ_TYPE_STR_LIST.get(0).equals(i.getYjType()) ? DictConstants.YJ_TYPE_0 : DictConstants.YJ_TYPE_1);
            i.preInsert();
            ordYjInfoMapper.insertSelective(i);
        });
        return poJo;
    }

    public void excelExport(HttpServletResponse response) throws IOException {
        List<OrdYjInfo> list = ordYjInfoMapper.findAllEntity();
        list.forEach(i -> i.setYjType(YJ_TYPE_STR_LIST.get(Integer.parseInt(i.getYjType()))));
        new ExportExcel("订单预警信息", OrdYjInfo.class)
                .setDataList(list)
                .writeWithAjaxHeader(response, "订单预警信息表.xlsx")
                .dispose();
    }

    public void templateDownload(HttpServletResponse response) throws IOException {
        new ExportExcel("订单预警信息", OrdYjInfo.class)
                .setDataList(Collections.EMPTY_LIST)
                .writeWithAjaxHeader(response, "订单预警信息表.xlsx")
                .dispose();
    }

    /**
     * 校验数据
     *
     * @param list
     */
    private void check(List<OrdYjInfo> list) {
        Supplier<Stream<OrdYjInfo>> suppiler = list::stream;
        long count0 = suppiler.get().filter(i -> i.getZdddDate() == null).count();
        if (count0 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count1 = suppiler.get().filter(i -> StringUtils.isEmpty(i.getLogisticsDriverTel())).count();
        if (count1 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count2 = suppiler.get().filter(i -> StringUtils.isEmpty(i.getPlaceOriginAddress())).count();
        if (count2 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count3 = suppiler.get().filter(i -> StringUtils.isEmpty(i.getVaritName())).count();
        if (count3 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count4 = suppiler.get().filter(i -> !YJ_TYPE_STR_LIST.contains(i.getYjType())).count();
        if (count4 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_114, ConstantCodeMsg.MSG_114);
        }
    }


}
