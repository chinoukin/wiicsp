package com.wisea.cultivar.explorer.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cultivar.common.po.bigdata.LongIdPo;
import com.wisea.cultivar.common.vo.bigdata.DetailedRecordVo;
import com.wisea.cultivar.explorer.entity.DemonsBaseInfo;
import com.wisea.cultivar.explorer.entity.DemonsBaseMassif;
import com.wisea.cultivar.explorer.entity.EntpInfoMage;
import com.wisea.cultivar.explorer.entity.MainBusinessMassif;
import com.wisea.cultivar.explorer.mapper.*;
import com.wisea.cultivar.explorer.mss.RemotePlantMss;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.explorer.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author jirg
 * @version 1.0
 * @className BigDataService
 * @date 2020/9/2 14:19
 * @Description 种植大数据Service
 */
@Service
public class PlantBigDataService extends BaseService {
    @Autowired
    private DemonsBaseInfoMapper demonsBaseInfoMapper;
    @Autowired
    protected EntpInfoMageMapper entpInfoMageMapper;
    @Autowired
    protected DemonsBaseInfoService demonsBaseInfoService;
    @Autowired
    protected DemonsBaseIntroduceMapper demonsBaseIntroduceMapper;
    @Autowired
    protected MainBusinessMassifMapper mainBusinessMassifMapper;
    @Autowired
    protected DemonsBaseMassifMapper demonsBaseMassifMapper;
    @Autowired
    private RelationIotInfoMapper relationIotInfoMapper;
    @Autowired
    private RemotePlantMss plantMss;
    /**
     * @author jirg
     * @date 2020/9/2 14:46
     * @Description 查询种植主体/示范基地列表
     */
    public ResultPoJo<BigDataListVo> findMapPoints(PalntBigDataMapPointsPo po) {
        LoggerUtil.infoWithContext("【findPageListfindPalntBigDataInfo】查询种植主体/示范基地列表：", "");
        ResultPoJo<BigDataListVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        BigDataListVo vo = new BigDataListVo();
        List<BigDataMapPointListVo> list = demonsBaseInfoMapper.findMapPoints(po);
        Map<String, Long> dataTypeCountMap = list.stream().collect(Collectors.groupingBy(BigDataMapPointListVo::getDataType, Collectors.counting()));
        vo.setDataTypeCountMap(dataTypeCountMap);
        if("0".equals(po.getDataType())){
            list = list.stream().filter(e->e.getDataType().equals("0")).collect(Collectors.toList());
        }else if("1".equals(po.getDataType())){
            list = list.stream().filter(e->e.getDataType().equals("1")).collect(Collectors.toList());
        }
        vo.setMapPoints(list);
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

     /**
     * @author jirg
     * @date 2020/11/3 16:17
     * @Description 查询种植主体/示范基地地块列表
     */
    public ResultPoJo<List<BigDataMapPointListVo>> findMassifs(PalntBigDataInfoPo po) {
        LoggerUtil.infoWithContext("【findMassifs】查询种植主体/示范基地列表：", "");
        ResultPoJo<List<BigDataMapPointListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        List<BigDataMapPointListVo> list = Lists.newArrayList();
        if(po.getDataType().equals("0")){
            //种植主体
            MainBusinessMassifListPo mainPo = new MainBusinessMassifListPo();
            mainPo.setEntpInfoMageId(po.getId());
            List<MainBusinessMassifListVo> massifList = mainBusinessMassifMapper.findList(mainPo);
            massifList.forEach(e -> {
                BigDataMapPointListVo vo = new BigDataMapPointListVo();
                vo.setId(e.getId());
                vo.setDataType("2");
                vo.setName(e.getMassifName());
                vo.setLocation(e.getLocation());
                vo.setPlantArea(e.getMassifAcre());
                vo.setCoordPointExpres(e.getCoordPointExpres());
                list.add(vo);
            });
        }else if(po.getDataType().equals("1")){
            //示范基地
            DemonsBaseMassifListPo demonsPo = new DemonsBaseMassifListPo();
            demonsPo.setDemonsBaseId(po.getId());
            List<DemonsBaseMassifListVo> massifList = demonsBaseMassifMapper.findList(demonsPo);
            massifList.forEach(e -> {
                BigDataMapPointListVo vo = new BigDataMapPointListVo();
                vo.setId(e.getId());
                vo.setDataType("3");
                vo.setName(e.getMassifName());
                vo.setLocation(e.getLocation());
                vo.setPlantArea(e.getMassifAcre());
                vo.setCoordPointExpres(e.getCoordPointExpres());
                list.add(vo);
            });
        }
        resultPoJo.setResult(list);
        return resultPoJo;
    }


    /**
     * @author jirg
     * @date 2020/9/2 16:11
     * @Description 查询基地/地块详细信息
     */
    public ResultPoJo<PalntBigDataInfoVo> findPalntBigDataInfo(PalntBigDataInfoPo po) {
        LoggerUtil.infoWithContext("【findPalntBigDataInfo】查询基地/地块详细信息：", po);
        ResultPoJo<PalntBigDataInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        PalntBigDataInfoVo vo = new PalntBigDataInfoVo();
        if(po.getDataType().equals("0")){
            //种植主体
            EntpInfoMage entpInfoMage = entpInfoMageMapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(entpInfoMage)){
                vo.setId(entpInfoMage.getId());
                vo.setDataType("0");
                vo.setName(entpInfoMage.getEntpName());
                vo.setLocation(entpInfoMage.getAreaCode());
                vo.setAreaProv(entpInfoMage.getAreaProv());
                vo.setAreaCity(entpInfoMage.getAreaCity());
                vo.setAreaCou(entpInfoMage.getAreaCou());
                vo.setEntpName(entpInfoMage.getEntpName());
                vo.setPlantArea(entpInfoMage.getPlantMeasure());
                vo.setEntpAddress(entpInfoMage.getEntpAddress());
                vo.setEntpIntroduce(entpInfoMage.getEntpIntroduce());
                vo.setCtscc(entpInfoMage.getCtscc());
                vo.setEntpType(entpInfoMage.getEntpType());
                vo.setConter(entpInfoMage.getConter());
                vo.setContTel(entpInfoMage.getContTel());
            }else{
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        }else if(po.getDataType().equals("1")){
            //示范基地
            DemonsBaseInfo demonsBaseInfo = demonsBaseInfoMapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(demonsBaseInfo)){
                EntpInfoMage entpInfoMage = entpInfoMageMapper.selectByPrimaryKey(demonsBaseInfo.getEntpInfoMageId());
                vo.setId(demonsBaseInfo.getId());
                vo.setDataType("1");
                vo.setName(demonsBaseInfo.getDemonsBaseName());
                vo.setLocation(demonsBaseInfo.getAreaCode());
                vo.setAreaProv(demonsBaseInfo.getAreaProv());
                vo.setAreaCity(demonsBaseInfo.getAreaCity());
                vo.setAreaCou(demonsBaseInfo.getAreaCou());
                vo.setEntpName(entpInfoMage.getEntpName());
                vo.setPlantArea(demonsBaseInfo.getDemonsBaseAcre());
                vo.setFieldAddress(demonsBaseInfo.getFieldAddress());
                List<DemonsBaseIntroduceListVo> list = demonsBaseIntroduceMapper.findList(new DemonsBaseIntroduceListPo(demonsBaseInfo.getId()));
                if( list.size() == 0 ){
                    DemonsBaseIntroduceListVo introduceListVo = new DemonsBaseIntroduceListVo();
                    introduceListVo.setTitle("基地信息介绍");
                    introduceListVo.setContent("");
                    introduceListVo.setSort(0);
                    list.add(introduceListVo);
                }
                vo.setDemonsBaseIntroduces(list);
            }else{
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        }else if(po.getDataType().equals("2")){
            //种植主体地块
            MainBusinessMassif mainBusinessMassif = mainBusinessMassifMapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(mainBusinessMassif)){
                EntpInfoMage entpInfoMage = entpInfoMageMapper.selectByPrimaryKey(mainBusinessMassif.getEntpInfoMageId());
                vo.setId(mainBusinessMassif.getId());
                vo.setDataType("2");
                vo.setName(mainBusinessMassif.getMassifName());
                vo.setLocation(mainBusinessMassif.getLocation());
                vo.setEntpName(entpInfoMage.getEntpName());
                vo.setPlantArea(mainBusinessMassif.getMassifAcre());
                vo.setBzDate(mainBusinessMassif.getBzDate());
                vo.setCommName(mainBusinessMassif.getCommName());
            }else{
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        }else if(po.getDataType().equals("3")){
            //示范基地地块
            DemonsBaseMassif demonsBaseMassif = demonsBaseMassifMapper.selectByPrimaryKey(po.getId());
            DemonsBaseInfo demonsBaseInfo = demonsBaseInfoMapper.selectByPrimaryKey(demonsBaseMassif.getDemonsBaseId());
            EntpInfoMage entpInfoMage = entpInfoMageMapper.selectByPrimaryKey(demonsBaseInfo.getEntpInfoMageId());
            if (ConverterUtil.isNotEmpty(demonsBaseMassif)){
                vo.setId(demonsBaseMassif.getId());
                vo.setDataType("3");
                vo.setName(demonsBaseMassif.getMassifName());
                vo.setLocation(demonsBaseMassif.getLocation());
                vo.setEntpName(entpInfoMage.getEntpName());
                vo.setPlantArea(demonsBaseMassif.getMassifAcre());
                vo.setBzDate(demonsBaseMassif.getBzDate());
                vo.setCommName(demonsBaseMassif.getCommName());
                vo.setFieldAddress(demonsBaseInfo.getFieldAddress());
            }else{
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        }
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/9/3 9:40
     * @Description 查询示范基地设备/档案列表
     */
    public ResultPoJo<DemonsBaseEquArchVo> findDemonsBaseEquArch(PalntBigDataInfoPo po) {
        LoggerUtil.infoWithContext("【findDemonsBaseEquArch】查询示范基地设备/档案列表：", po);
        ResultPoJo<DemonsBaseEquArchVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //地块列表
        List<Long> baseMassifIds = Lists.newArrayList();
        if(po.getDataType().equals("1")){
            //示范基地
            DemonsBaseInfo demonsBaseInfo = demonsBaseInfoMapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(demonsBaseInfo)){
                //查询示范基地所有地块列表
                DemonsBaseMassifListPo massifListPo = new DemonsBaseMassifListPo();
                massifListPo.setDemonsBaseId(demonsBaseInfo.getId());
                List<DemonsBaseMassifListVo> baseMassifList = demonsBaseMassifMapper.findList(massifListPo);
                if(ConverterUtil.isNotEmpty(baseMassifList)){
                    baseMassifIds = baseMassifList.stream().map(DemonsBaseMassifListVo::getId).collect(Collectors.toList());
                }
            }else{
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
                return resultPoJo;
            }
        }else if(po.getDataType().equals("3")){
            //示范基地地块
            DemonsBaseMassif demonsBaseMassif = demonsBaseMassifMapper.selectByPrimaryKey(po.getId());
            if(ConverterUtil.isNotEmpty(demonsBaseMassif)){
                baseMassifIds.add(demonsBaseMassif.getId());
            }else{
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
                return resultPoJo;
            }
        }else{
            resultPoJo.setCode(ConstantError.ERR_005);
            resultPoJo.setMsg("数据类型错误");
            return resultPoJo;
        }
        //关联地块Ids
        if(ConverterUtil.isNotEmpty(baseMassifIds)){
            List<Long> massifIds = relationIotInfoMapper.findByBaseMassifIds(baseMassifIds);
            if(ConverterUtil.isNotEmpty(massifIds)){
                //远程查询设备/档案列表
                return plantMss.findEquArchByMassifIds(massifIds);
            }
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/9/3 13:55
     * @Description 查询病虫害预警列表
     */
    public ResultPoJo<List<PadYjInfoListVo>> findPestWarning() {
        LoggerUtil.infoWithContext("【findPestWarning】查询病虫害预警列表：", "");
        return plantMss.findPestWarning();
    }

    /**
     * @author jirg
     * @date 2020/9/3 17:19
     * @Description 油茶种植面积分析
     */
    public ResultPoJo<PlantAreaAnalysisVo> plantAreaAnalysis() {
        LoggerUtil.infoWithContext("【plantAreaAnalysis】油茶种植面积分析：", "");
        ResultPoJo<PlantAreaAnalysisVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        PlantAreaAnalysisVo vo = entpInfoMageMapper.plantAreaAnalysis();
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * @Author jirg
     * @Date 2019/7/19 16:31
     * @Description 查询详细记录
     **/
    public ResultPoJo<DetailedRecordVo> detailedRecord(LongIdPo po) {
        return plantMss.detailedRecord(po);
    }
}
