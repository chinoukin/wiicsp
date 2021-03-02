package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.po.bigdata.LongIdPo;
import com.wisea.cultivar.common.vo.bigdata.DetailedRecordVo;
import com.wisea.cultivar.explorer.po.PalntBigDataInfoPo;
import com.wisea.cultivar.explorer.po.PalntBigDataMapPointsPo;
import com.wisea.cultivar.explorer.service.PlantBigDataService;
import com.wisea.cultivar.explorer.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className BigDataController
 * @date 2020/9/2 14:10
 * @Description
 */
@Api(tags = "种植大数据相关接口")
@RequestMapping(value = "/w/palntBigData")
@RestController
public class PlantBigDataController {
    @Autowired
    private PlantBigDataService service;

    @DataCheck
    @ApiOperation(value = "查询种植主体/示范基地列表")
    @RequestMapping(value = "/findMapPoints", method = RequestMethod.POST)
    public ResultPoJo<BigDataListVo> findMapPoints(@RequestBody PalntBigDataMapPointsPo po) {
        return service.findMapPoints(po);
    }

    @DataCheck
    @ApiOperation(value = "查询种植主体/示范基地地块列表 - 点击左侧列表时调用")
    @RequestMapping(value = "/findMassifs", method = RequestMethod.POST)
    public ResultPoJo<List<BigDataMapPointListVo>> findMassifs(@RequestBody PalntBigDataInfoPo po) {
        return service.findMassifs(po);
    }

    @DataCheck
    @ApiOperation(value = "查询基地/地块详细信息")
    @RequestMapping(value = "/findPalntBigDataInfo", method = RequestMethod.POST)
    public ResultPoJo<PalntBigDataInfoVo> findPalntBigDataInfo(@RequestBody PalntBigDataInfoPo po) {
        return service.findPalntBigDataInfo(po);
    }

    @DataCheck
    @ApiOperation(value = "查询示范基地设备/档案列表 - 当dataType为1时，调用该接口")
    @RequestMapping(value = "/findDemonsBaseEquArch", method = RequestMethod.POST)
    public ResultPoJo<DemonsBaseEquArchVo> findDemonsBaseEquArch(@RequestBody PalntBigDataInfoPo po) {
        return service.findDemonsBaseEquArch(po);
    }
    @DataCheck
    @ApiOperation(value = "查询病虫害预警列表（前20条）")
    @RequestMapping(value = "/findPestWarning", method = RequestMethod.POST)
    public ResultPoJo<List<PadYjInfoListVo>> findPestWarning() {
        return service.findPestWarning();
    }

    @DataCheck
    @ApiOperation(value = "油茶种植面积分析")
    @RequestMapping(value = "/plantAreaAnalysis", method = RequestMethod.POST)
    public ResultPoJo<PlantAreaAnalysisVo> plantAreaAnalysis() {
        return service.plantAreaAnalysis();
    }

    @ApiOperation(value = "档案详情")
    @RequestMapping(value = "/detailedRecord", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<DetailedRecordVo> detailedRecord(@RequestBody LongIdPo po) {
        return service.detailedRecord(po);
    }

}
