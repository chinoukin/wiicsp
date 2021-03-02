package com.wisea.cultivar.bigdata.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.AjaxDownLoadUtil;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.constants.ConstantCodeMsg;
import com.wisea.cultivar.bigdata.constants.DictConstants;
import com.wisea.cultivar.bigdata.mss.ServiceOritraplaMss;
import com.wisea.cultivar.common.dao.bigdata.BigdataPlaceOriginMageMapper;
import com.wisea.cultivar.common.dao.bigdata.PlaceOriginXqMageMapper;
import com.wisea.cultivar.common.dao.bigdata.YxEntpMapper;
import com.wisea.cultivar.common.entity.bigdata.PlaceOriginMage;
import com.wisea.cultivar.common.po.bigdata.BaseInfoPo;
import com.wisea.cultivar.common.po.bigdata.EquInfoPo;
import com.wisea.cultivar.common.po.bigdata.LongIdPo;
import com.wisea.cultivar.common.po.bigdata.MassifAndMonitrPagePo;
import com.wisea.cultivar.common.po.bigdata.MonitrLiveStatisticsPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginMageGetPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginMagePagePo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginMageUpdatePo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageListPo;
import com.wisea.cultivar.common.po.bigdata.UpdJyKtJy;
import com.wisea.cultivar.common.po.bigdata.YxEntpListPo;
import com.wisea.cultivar.common.vo.bigdata.BaseInfoVo;
import com.wisea.cultivar.common.vo.bigdata.DetailedRecordVo;
import com.wisea.cultivar.common.vo.bigdata.EquInfoVo;
import com.wisea.cultivar.common.vo.bigdata.ExportPlaceOriginListVo;
import com.wisea.cultivar.common.vo.bigdata.MassifAndMonitrListVo;
import com.wisea.cultivar.common.vo.bigdata.MonitrLive;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginMageListVo;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginMageMembVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * PlaceOriginMageService
 * 产地管理 Service
 * 2019/12/02 11:02:15
 * @author yangtao
 */
@Service
public class PlaceOriginMageService extends BaseService {
    @Autowired
    protected BigdataPlaceOriginMageMapper bigdataPlaceOriginMageMapper;
    @Autowired
    protected PlaceOriginXqMageMapper placeOriginXqMageMapper;
    @Autowired
    protected YxEntpMapper yxEntpMapper;
    @Autowired(required = false)
    protected ServiceOritraplaMss mss;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<PlaceOriginMageListVo>> findPage(PlaceOriginMagePagePo po) {
        ResultPoJo<Page<PlaceOriginMageListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        Page<PlaceOriginMageListVo> page = po.getPage();
        List<PlaceOriginMageListVo> list = bigdataPlaceOriginMageMapper.findPage(po);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<PlaceOriginMageListVo>> findList(PlaceOriginMagePagePo po) {
        ResultPoJo<List<PlaceOriginMageListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<String> strList = Lists.newArrayList();
        String jdType = po.getJdType();
        if (jdType != null && jdType != "") {
            String[] split = jdType.split(",");
            for (String e : split) {
                strList.add(e);
            }
            po.setJdTypeList(strList);
            po.setJdType(null);
        }
        List<PlaceOriginMageListVo> list = bigdataPlaceOriginMageMapper.findPage(po);
        result.setResult(list);
        return result;
    }

    /**
     * 查询列表角标
     */
    public ResultPoJo<List<PlaceOriginMageMembVo>> findJbMemb(PlaceOriginMagePagePo po) {
        ResultPoJo<List<PlaceOriginMageMembVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        po.setPlaceOriginState(DictConstants.PLACE_ORIGIN_STATE_0);
        List<PlaceOriginMageMembVo> list = bigdataPlaceOriginMageMapper.findJbMemb(po);
        List<PlaceOriginMageMembVo> reList = Lists.newArrayList();

        PlaceOriginMageMembVo placeVo1 = new PlaceOriginMageMembVo();
        placeVo1.setStatKey(DictConstants.JD_TYPE_0);
        placeVo1.setStatCount(0);
        PlaceOriginMageMembVo placeVo2 = new PlaceOriginMageMembVo();
        placeVo2.setStatKey(DictConstants.JD_TYPE_1);
        placeVo2.setStatCount(0);
        PlaceOriginMageMembVo placeVo3 = new PlaceOriginMageMembVo();
        placeVo3.setStatKey(DictConstants.JD_TYPE_2);
        placeVo3.setStatCount(0);
        PlaceOriginMageMembVo placeVo4 = new PlaceOriginMageMembVo();
        placeVo4.setStatKey("4");

        for (PlaceOriginMageMembVo e : list) {

            if (DictConstants.JD_TYPE_0.equals(e.getStatKey())) {
                placeVo1.setStatCount(e.getStatCount());
            }else if (DictConstants.JD_TYPE_1.equals(e.getStatKey())) {
                placeVo2.setStatCount(e.getStatCount());
            }else if (DictConstants.JD_TYPE_2.equals(e.getStatKey())) {
                placeVo3.setStatCount(e.getStatCount());
            }
        }
        reList.add(placeVo1);
        reList.add(placeVo2);
        reList.add(placeVo3);
        //计算总数量
        PlaceOriginMagePagePo poo = new PlaceOriginMagePagePo();
        poo.setPlaceOriginState(DictConstants.PLACE_ORIGIN_STATE_0);
        List<PlaceOriginMageMembVo> allList = bigdataPlaceOriginMageMapper.findJbMemb(poo);
        int i = 0;
        for (PlaceOriginMageMembVo placeOriginMageMembVo : allList) {

            i = i + placeOriginMageMembVo.getStatCount();
        }
        placeVo4.setStatCount(i);
        reList.add(placeVo4);
        result.setResult(reList);
        return result;
    }

    /**
     * 导出列表
     */
    public ResultPoJo<Object> exportPlantList(PlaceOriginMagePagePo po, HttpServletResponse response)  throws IOException {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        try {
            List<PlaceOriginMageListVo> list = bigdataPlaceOriginMageMapper.findPage(po);
            list.forEach(e -> {

                e.setJdwd("(".concat(e.getJd().toString()).concat(",").concat(e.getWd().toString()).concat(")"));
            });
            String fileName = "产地列表.xlsx";
            ExportExcel exportExcel = new ExportExcel("产地列表", ExportPlaceOriginListVo.class);
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
     * 查询详情
     */
    public ResultPoJo<PlaceOriginMageGetVo> get(PlaceOriginMageGetPo placeOriginMageGetPo) {
        ResultPoJo<PlaceOriginMageGetVo> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        PlaceOriginMage entity = bigdataPlaceOriginMageMapper.selectByPrimaryKey(placeOriginMageGetPo.getId());
        PlaceOriginMageGetVo vo = new PlaceOriginMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        //查询产地详情
        PlaceOriginXqMageListPo placeOriginXqMageListPo = new PlaceOriginXqMageListPo();
        placeOriginXqMageListPo.setPlaceOriginId(placeOriginMageGetPo.getId());
        vo.setPlaceOriginXqMageListVo(placeOriginXqMageMapper.findList(placeOriginXqMageListPo));
        //查询已选企业
        YxEntpListPo yxEntpListPo = new YxEntpListPo();
        yxEntpListPo.setPlaceOriginId(placeOriginMageGetPo.getId());
        vo.setYxEntpListVo(yxEntpMapper.findList(yxEntpListPo));
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(PlaceOriginMageInsertPo po) {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        PlaceOriginMage placeOriginMage = new PlaceOriginMage();
        ConverterUtil.copyProperties(po, placeOriginMage);
        placeOriginMage.preInsert();
        placeOriginMage.setPlaceOriginState(DictConstants.PLACE_ORIGIN_STATE_0);
        bigdataPlaceOriginMageMapper.insert(placeOriginMage);
        //产地详情
//        List<PlaceOriginXqMage> placeList = po.getPlaceOriginXqMage();
//        if (ConverterUtil.isNotEmpty(placeList)) {
//
//            int i = 0;
//            for (PlaceOriginXqMage e : placeList) {
//
//                e.setPlaceOriginId(placeOriginMage.getId());
//                e.preInsert();
//                e.setCreateDate(OffsetDateTime.now().plusSeconds(i));
//                i++;
//            }
//            placeOriginXqMageMapper.batchInsert(placeList);
//        }
        //已选企业
//        List<YxEntp> yxEntpList = po.getYxEntp();
//        if (ConverterUtil.isNotEmpty(yxEntpList)) {
//
//            yxEntpList.forEach(e -> {
//                e.setPlaceOriginId(placeOriginMage.getId());
//                e.preInsert();
//            });
//            yxEntpMapper.batchInsert(yxEntpList);
//        }
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(PlaceOriginMageUpdatePo po) {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        PlaceOriginMage placeOriginMage = new PlaceOriginMage();
        ConverterUtil.copyProperties(po, placeOriginMage);
        placeOriginMage.preUpdate();
        bigdataPlaceOriginMageMapper.updateByPrimaryKeySelective(placeOriginMage);
        //删除之前的产地详情
        placeOriginXqMageMapper.delByPlantId(po.getId());
        //删除之前的已选企业
        yxEntpMapper.delByPlantId(po.getId());
        //产地详情
//        List<PlaceOriginXqMage> placeList = po.getPlaceOriginXqMage();
//        if (ConverterUtil.isNotEmpty(placeList)) {
//            int i = 0;
//            for (PlaceOriginXqMage e : placeList) {
//
//                e.setPlaceOriginId(placeOriginMage.getId());
//                e.preInsert();
//                e.setCreateDate(OffsetDateTime.now().plusSeconds(i));
//                i++;
//            }
//            placeOriginXqMageMapper.batchInsert(placeList);
//        }
//        //已选企业
//        List<YxEntp> yxEntpList = po.getYxEntp();
//        if (ConverterUtil.isNotEmpty(yxEntpList)) {
//
//            yxEntpList.forEach(e -> {
//                e.setPlaceOriginId(placeOriginMage.getId());
//                e.preInsert();
//            });
//            yxEntpMapper.batchInsert(yxEntpList);
//        }
        return result;
    }

    /**
     * 修改产地状态
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> updState(UpdJyKtJy po) {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取信息
        PlaceOriginMage placeOriginMage = bigdataPlaceOriginMageMapper.selectByPrimaryKey(po.getId());
        //判断操作
        if ("2".equals(po.getKtflag())) {

            placeOriginMage.setDelFlag("1");
        }else if ("0".equals(po.getKtflag())) {
            if (DictConstants.PLACE_ORIGIN_STATE_0.equals(placeOriginMage.getPlaceOriginState())) {

                result.setCode(ConstantCodeMsg.ERR_410);
                result.setMsg(ConstantCodeMsg.MSG_410);
                return result;
            }
            placeOriginMage.setPlaceOriginState(DictConstants.PLACE_ORIGIN_STATE_0);
        }else if ("1".equals(po.getKtflag())) {
            if (DictConstants.PLACE_ORIGIN_STATE_1.equals(placeOriginMage.getPlaceOriginState())) {

                result.setCode(ConstantCodeMsg.ERR_410);
                result.setMsg(ConstantCodeMsg.MSG_410);
                return result;
            }
            placeOriginMage.setPlaceOriginState(DictConstants.PLACE_ORIGIN_STATE_1);
        }else {
        }
        placeOriginMage.preUpdate();
        bigdataPlaceOriginMageMapper.updateByPrimaryKeySelective(placeOriginMage);

        return result;
    }

    /**
     * 设备
     * @param po
     * @return
     */
    public ResultPoJo<Page<MassifAndMonitrListVo>> findMonitor(MassifAndMonitrPagePo po) {

        return mss.findMonitor(po);
    }

    /**
     * 视频
     * @param po
     * @return
     */
    public ResultPoJo<Page<EquInfoVo>> findVideo(EquInfoPo po) {

        return mss.findVideo(po);
    }

    /**
     * 档案列表
     * @param po
     * @return
     */
    public ResultPoJo<Page<BaseInfoVo>> findBaseInfo(BaseInfoPo po) {

        return mss.findBaseInfo(po);
    }

    /**
     * 档案详情
     * @param po
     * @return
     */
    public ResultPoJo<DetailedRecordVo> detailedRecord(LongIdPo po) {

        return mss.detailedRecord(po);
    }

    /**
     * 年月日统计
     * @param po
     * @return
     */
    public ResultPoJo<List<MonitrLive>> monitrLiveStatistics(MonitrLiveStatisticsPo po) {
        return mss.monitrLiveStatistics(po);
    }

}
