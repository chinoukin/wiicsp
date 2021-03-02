package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.service.NationalDistrStatisticsService;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsGetPo;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsInsertPo;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsListPo;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsPagePo;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.NationalDistrStatisticsGetVo;
import com.wisea.cultivar.common.vo.bigdata.NationalDistrStatisticsListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * NationalDistrStatisticsController
 * 全国配送统计 Controller
 * 2020/09/02 15:16:31
 */
@Api(tags = "全国配送统计相关接口")
@RequestMapping(value = "/w/NationalDistrStatistics")
@RestController
@PreAuthorize("hasAuthority('eb:dis')")
public class NationalDistrStatisticsController {
    @Autowired
    protected NationalDistrStatisticsService nationalDistrStatisticsService;

    @ApiOperation(value = "echarts展示的数据")
    @RequestMapping(value = "data", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<NationalDistrStatisticsService.EchartsShowDataVo>> showData() {
        return nationalDistrStatisticsService.showData();
    }

    @ApiOperation(value = "获取全国配送统计分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<NationalDistrStatisticsListVo>> findPage(@RequestBody NationalDistrStatisticsPagePo nationalDistrStatisticsPagePo) {
        return nationalDistrStatisticsService.findPage(nationalDistrStatisticsPagePo);
    }

    @ApiOperation(value = "获取全国配送统计列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<NationalDistrStatisticsListVo>> list(@RequestBody NationalDistrStatisticsListPo nationalDistrStatisticsListPo) {
        return nationalDistrStatisticsService.findList(nationalDistrStatisticsListPo);
    }

    @ApiOperation(value = "查询全国配送统计")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<NationalDistrStatisticsGetVo> get(@RequestBody NationalDistrStatisticsGetPo nationalDistrStatisticsGetPo) {
        return nationalDistrStatisticsService.get(nationalDistrStatisticsGetPo);
    }

    @ApiOperation(value = "新增全国配送统计")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody NationalDistrStatisticsInsertPo nationalDistrStatisticsInsertPo) {
        return nationalDistrStatisticsService.insert(nationalDistrStatisticsInsertPo);
    }

    @ApiOperation(value = "修改全国配送统计")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody NationalDistrStatisticsUpdatePo nationalDistrStatisticsUpdatePo) {
        return nationalDistrStatisticsService.update(nationalDistrStatisticsUpdatePo);
    }

    @ApiOperation(value = "批量删除全国配送统计")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody NationalDistrStatisticsBatDeletePo nationalDistrStatisticsBatDeletePo) {
        return nationalDistrStatisticsService.batDelete(nationalDistrStatisticsBatDeletePo);
    }
}
