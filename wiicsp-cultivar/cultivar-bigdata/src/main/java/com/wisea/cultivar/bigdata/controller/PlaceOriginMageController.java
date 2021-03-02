package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.BaseInfoPo;
import com.wisea.cultivar.common.po.bigdata.EquInfoPo;
import com.wisea.cultivar.common.po.bigdata.LongIdPo;
import com.wisea.cultivar.common.po.bigdata.MassifAndMonitrPagePo;
import com.wisea.cultivar.common.po.bigdata.MonitrLiveStatisticsPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginMageGetPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginMagePagePo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginMageUpdatePo;
import com.wisea.cultivar.common.po.bigdata.UpdJyKtJy;
import com.wisea.cultivar.bigdata.service.PlaceOriginMageService;
import com.wisea.cultivar.common.vo.bigdata.BaseInfoVo;
import com.wisea.cultivar.common.vo.bigdata.DetailedRecordVo;
import com.wisea.cultivar.common.vo.bigdata.EquInfoVo;
import com.wisea.cultivar.common.vo.bigdata.MassifAndMonitrListVo;
import com.wisea.cultivar.common.vo.bigdata.MonitrLive;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginMageListVo;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginMageMembVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * PlaceOriginMageController
 * 产地管理 Controller
 * 2019/12/02 11:02:15
 *
 * @author yangtao
 */
@Api(tags = "产地管理相关接口")
@RequestMapping(value = "/w/place/")
@RestController
public class PlaceOriginMageController {
    @Autowired
    protected PlaceOriginMageService placeOriginMageService;

    @ApiOperation(value = "获取产地管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<PlaceOriginMageListVo>> findPage(@RequestBody PlaceOriginMagePagePo placeOriginMagePagePo) {
        return placeOriginMageService.findPage(placeOriginMagePagePo);
    }

    @ApiOperation(value = "获取产地管理列表")
    @RequestMapping(value = "findList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<PlaceOriginMageListVo>> findList(@RequestBody PlaceOriginMagePagePo placeOriginMagePagePo) {
        return placeOriginMageService.findList(placeOriginMagePagePo);
    }

    @ApiOperation(value = "获取产地管理列表角标")
    @RequestMapping(value = "findJbMemb", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<PlaceOriginMageMembVo>> findJbMemb(@RequestBody PlaceOriginMagePagePo placeOriginMagePagePo) {
        return placeOriginMageService.findJbMemb(placeOriginMagePagePo);
    }

    @ApiOperation(value = "导出列表")
    @RequestMapping(value = "exportPlantList", method = RequestMethod.POST)
    public ResultPoJo<Object> exportPlantList(@RequestBody PlaceOriginMagePagePo placeOriginMagePagePo, HttpServletResponse response) throws IOException {
        return placeOriginMageService.exportPlantList(placeOriginMagePagePo, response);
    }

    @ApiOperation(value = "查询产地管理详情（编辑页面）")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<PlaceOriginMageGetVo> get(@RequestBody PlaceOriginMageGetPo placeOriginMageGetPo) {
        return placeOriginMageService.get(placeOriginMageGetPo);
    }

    @ApiOperation(value = "新增产地管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody PlaceOriginMageInsertPo placeOriginMageInsertPo) {
        return placeOriginMageService.insert(placeOriginMageInsertPo);
    }

    @ApiOperation(value = "修改产地管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody PlaceOriginMageUpdatePo placeOriginMageUpdatePo) {
        return placeOriginMageService.update(placeOriginMageUpdatePo);
    }

    @ApiOperation(value = "删除、开通、禁用产地管理")
    @RequestMapping(value = "updState", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> updState(@RequestBody UpdJyKtJy po) {
        return placeOriginMageService.updState(po);
    }

    @ApiOperation(value = "设备列表")
    @RequestMapping(value = "findMonitor", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<MassifAndMonitrListVo>> findMonitor(@RequestBody MassifAndMonitrPagePo po) {
        return placeOriginMageService.findMonitor(po);
    }

    @ApiOperation(value = "视频列表")
    @RequestMapping(value = "findVideo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<EquInfoVo>> findVideo(@RequestBody EquInfoPo po) {
        return placeOriginMageService.findVideo(po);
    }

    @ApiOperation(value = "档案列表")
    @RequestMapping(value = "findBaseInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<BaseInfoVo>> findBaseInfo(@RequestBody BaseInfoPo po) {
        return placeOriginMageService.findBaseInfo(po);
    }

    @ApiOperation(value = "档案详情")
    @RequestMapping(value = "detailedRecord", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<DetailedRecordVo> detailedRecord(@RequestBody LongIdPo po) {
        return placeOriginMageService.detailedRecord(po);
    }

    @ApiOperation(value = "周、月、年统计")
    @RequestMapping(value = "/monitrLiveStatistics", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<MonitrLive>> monitrLiveStatistics(@RequestBody MonitrLiveStatisticsPo po) {
        return placeOriginMageService.monitrLiveStatistics(po);
    }
}
