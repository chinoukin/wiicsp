package com.wisea.equipment.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.equipment.po.EquDataPointPo;
import com.wisea.equipment.service.SearchMeteorologyService;
import com.wisea.equipment.vo.MeteorologyInfluxVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className SearchController
 * @date 2020/7/9 14:01
 * @Description
 */
@Api(tags = "【设备】气象数据展示接口")
@RestController
@RequestMapping(value = "/w/equ/search")
public class SearchMeteorologyController {
    @Autowired
    private SearchMeteorologyService searchMeteorologyService;

    /**
     * @author jirg
     * @date 2020/7/9 14:16
     * @Description 获取设备最近一条数气象数据
     */
    @DataCheck
    @RequestMapping(value = "/getLastDataPoint", method = RequestMethod.POST)
    @ApiOperation(nickname = "获取设备最近一条气象数据", value = "获取设备最近一条气象数据", notes = "获取设备最近一条气象数据", httpMethod = "POST")
    public ResultPoJo<MeteorologyInfluxVo> getLastDataPoint(@RequestBody EquDataPointPo po) {
        return searchMeteorologyService.getLastDataPoint(po);
    }

    /**
     * @author jirg
     * @date 2020/12/17 11:08
     * @Description 调用糯米蕉设备数据 - 产品定的规则（李国然）
     */
    @DataCheck
    @RequestMapping(value = "/getLastDataPointTmp", method = RequestMethod.POST)
    @ApiOperation(nickname = "获取设备最近一条气象数据", value = "获取设备最近一条气象数据", notes = "获取设备最近一条气象数据", httpMethod = "POST")
    public ResultPoJo<MeteorologyInfluxVo> getLastDataPointTmp(@RequestBody LongIdPo po) {
        return searchMeteorologyService.getLastDataPointTmp(po);
    }

    /**
     * @author jirg
     * @date 2020/8/12 17:59
     * @Description 获取设备图片列表
     */
    @DataCheck
    @RequestMapping(value = "/getGrowAlbum", method = RequestMethod.POST)
    @ApiOperation(nickname = "获取设备图片列表", value = "获取设备图片列表", notes = "获取设备图片列表", httpMethod = "POST")
    public ResultPoJo<List<MeteorologyInfluxVo>> getGrowAlbum(@RequestBody EquDataPointPo po) {
        return searchMeteorologyService.getGrowAlbum(po);
    }

    /**
     * @author jirg
     * @date 2020/7/9 16:57
     * @Description 设备按 当天、近7天、近30统计
     */
    @RequestMapping(value="/datePointStatistics",method= RequestMethod.POST)
    @ApiOperation(nickname = "设备按 当天、近7天、近30统计", value = "设备按 当天、近7天、近30统计", notes = "设备按 当天、近7天、近30统计", httpMethod = "POST")
    @DataCheck
    public ResultPoJo<List<MeteorologyInfluxVo>> datePointStatistics(@RequestBody EquDataPointPo po){
        return searchMeteorologyService.datePointStatistics(po);
    }
}
