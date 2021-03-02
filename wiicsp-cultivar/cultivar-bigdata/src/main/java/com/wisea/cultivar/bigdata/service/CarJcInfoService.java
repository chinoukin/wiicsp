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
import com.wisea.cultivar.common.dao.bigdata.CarJcInfoMapper;
import com.wisea.cultivar.common.entity.bigdata.CarJcInfo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoListPo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.CarJcInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.CarJcInfoListVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * CarJcInfoService
 * 车辆监测信息 Service
 * 2019/12/02 11:02:14
 */
@Service
public class CarJcInfoService extends BaseService {
    @Autowired
    protected CarJcInfoMapper carJcInfoMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<CarJcInfoListVo>> findPage(CarJcInfoPagePo carJcInfoPagePo) {
        ResultPoJo<Page<CarJcInfoListVo>> result = new ResultPoJo<>();
        Page<CarJcInfoListVo> page = carJcInfoPagePo.getPage();
        List<CarJcInfoListVo> list = carJcInfoMapper.findPage(carJcInfoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<CarJcInfoListVo>> findList(CarJcInfoListPo carJcInfoListPo) {
        ResultPoJo<List<CarJcInfoListVo>> result = new ResultPoJo<>();
        result.setResult(carJcInfoMapper.findList(carJcInfoListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<CarJcInfoGetVo> get(CarJcInfoGetPo carJcInfoGetPo) {
        ResultPoJo<CarJcInfoGetVo> result = new ResultPoJo<>();
        CarJcInfo entity = carJcInfoMapper.selectByPrimaryKey(carJcInfoGetPo.getId());
        CarJcInfoGetVo vo = new CarJcInfoGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(CarJcInfoInsertPo carJcInfoInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        CarJcInfo carJcInfo = new CarJcInfo();
        ConverterUtil.copyProperties(carJcInfoInsertPo, carJcInfo);
        carJcInfo.preInsert();
        carJcInfoMapper.insert(carJcInfo);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(CarJcInfoUpdatePo carJcInfoUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        CarJcInfo carJcInfo = new CarJcInfo();
        ConverterUtil.copyProperties(carJcInfoUpdatePo, carJcInfo);
        carJcInfo.preUpdate();
        carJcInfoMapper.updateByPrimaryKeySelective(carJcInfo);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(CarJcInfoBatDeletePo carJcInfoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (Long delId : carJcInfoBatDeletePo.getDelList()) {
            CarJcInfo carJcInfo = new CarJcInfo();
            carJcInfo.setId(delId);
            carJcInfo.preUpdate();
            carJcInfoMapper.deleteLogic(carJcInfo);
        }
        return result;
    }

    //    0冷藏    1冷冻车
    private static List<String> CAR_TYPE = Arrays.asList("冷藏车", "冷冻车");
    //    0正常    1异常
    private static List<String> CAR_JC_STATE = Arrays.asList("正常", "异常");

    @Transactional
    public ResultPoJo excelImport(MultipartFile file) throws Exception {
        ImportExcel excel = new ImportExcel(file, 1, 0);
        List<CarJcInfo> list = excel.getDataList(CarJcInfo.class);
        //校验
        check(list);

        list.forEach(i -> {
            i.setCarType(CAR_TYPE.get(0).equals(i.getCarType()) ? DictConstants.CAR_TYPE_0 : DictConstants.CAR_TYPE_1);
            i.setCarJcState(CAR_JC_STATE.get(0).equals(i.getCarJcState()) ? DictConstants.CAR_JC_STATE_0 : DictConstants.CAR_JC_STATE_1);
            i.preInsert();
            carJcInfoMapper.insertSelective(i);
        });

        return new ResultPoJo();
    }

    public void excelExport(HttpServletResponse response) throws IOException {
        List<CarJcInfo> list = carJcInfoMapper.findAllEntity();
        list.forEach(i->{
            i.setCarJcState(CAR_JC_STATE.get(Integer.parseInt(i.getCarJcState())));
            i.setCarType(CAR_TYPE.get(Integer.parseInt(i.getCarType())));
        });
        new ExportExcel("车辆监测信息", CarJcInfo.class)
                .setDataList(list)
                .writeWithAjaxHeader(response, "车辆监测信息.xlsx")
                .dispose();
    }

    //模板下载
    public void templateDownload(HttpServletResponse response) throws IOException {
        new ExportExcel("车辆监测信息", CarJcInfo.class)
                .setDataList(Collections.EMPTY_LIST)
                .writeWithAjaxHeader(response, "车辆监测信息.xlsx")
                .dispose();
    }
    /**
     * 校验数据
     *
     * @param list
     */
    private void check(List<CarJcInfo> list) {
        Supplier<Stream<CarJcInfo>> suppiler = list::stream;
        List<String> importCarNums = suppiler.get().map(CarJcInfo::getCarNum).distinct().collect(Collectors.toList());
        if (importCarNums.size()<list.size()){
            throw new BusinessException(ConstantCodeMsg.ERR_115, ConstantCodeMsg.MSG_115);
        }
        List<CarJcInfo> entity = carJcInfoMapper.findAllEntity();
        List<String> carNums = entity.stream().map(CarJcInfo::getCarNum).collect(Collectors.toList());
        carNums.removeAll(importCarNums);
        if (carNums.size() < entity.size()) {
            throw new BusinessException(ConstantCodeMsg.ERR_115, ConstantCodeMsg.MSG_115);
        }
        long count0 = suppiler.get().filter(i -> !CAR_TYPE.contains(i.getCarType())).count();
        if (count0 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_114, ConstantCodeMsg.MSG_114);
        }
        long count1 = suppiler.get().filter(i -> StringUtils.isEmpty(i.getCarNum())).count();
        if (count1 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count2 = suppiler.get().filter(i -> i.getCxwd() == null).count();
        if (count2 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count3 = suppiler.get().filter(i -> StringUtils.isEmpty(i.getSsDate())).count();
        if (count3 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count4 = suppiler.get().filter(i -> !CAR_JC_STATE.contains(i.getCarJcState())).count();
        if (count4 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_114, ConstantCodeMsg.MSG_114);
        }
    }
}
