package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.vo.trade.OrdCancelReasonMageListVo;
import com.wisea.cultivar.plant.po.MembPo;
import com.wisea.cultivar.plant.po.SerListMagePageListPo;
import com.wisea.cultivar.plant.po.SerListMagePo;
import com.wisea.cultivar.plant.po.SerListMageSavePo;
import com.wisea.cultivar.plant.vo.SerListMageInfoVo;
import com.wisea.cultivar.plant.vo.SerListMagePageListVo;
import com.wisea.cultivar.plant.vo.SerListStateTypeCountVo;
import com.wisea.cultivar.plant.entity.SerListMage;
import com.wisea.cultivar.plant.service.SerListMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SerListMageController
 * @date 2020/08/06 18:28:39
 * @Description  服务单
 */
@Api(tags = "种植-服务单相关")
@RestController
@RequestMapping("/w/serListMage")
public class SerListMageController {
    @Autowired
    private SerListMageService service;


    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description addSerListMage addSerListMagePo
     */
    @DataCheck
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增服务单", value = "新增服务单", notes = "新增服务单", httpMethod = "POST")
    public ResultPoJo<SerListMage> addSerListMagePo(@RequestBody SerListMageSavePo po) {
        return service.addSerListMagePo(po);
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询SerListMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询服务单列表包含搜索 ser_list_state_type 0：待确认 1：待服务 2：服务中 3：已取消 该字段不传值则查询全部", value = "分页查询服务单列表ser_list_state_type 0：待确认 1：待服务 2：服务中 3：已取消 该字段不传值则查询全部", notes = "分页查询服务单列表ser_list_state_type 0：待确认 1：待服务 2：服务中 3：已取消 该字段不传值则查询全部", httpMethod = "POST")
    public ResultPoJo<Page<SerListMagePageListVo>> findPageList(@RequestBody SerListMagePageListPo po) {
        return service.findPageList(po);
    }
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息SerListMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细服务单信息", value = "查询详细服务单信息", notes = "查询详细服务单信息", httpMethod = "POST")
    public ResultPoJo<SerListMageInfoVo> findInfo(@RequestBody LongIdPo po) {

        return service.findInfo(po);
    }

    /**
     * 修改服务时间 取消服务单 确定完成服务单
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/updSerListMage", method = RequestMethod.POST)
    @ApiOperation(nickname = "0修改服务时间 1取消服务单 2确定完成服务单", value = "0修改服务时间 1取消服务单 2确定完成服务单", notes = "0修改服务时间 1取消服务单 2确定完成服务单", httpMethod = "POST")
    public ResultPoJo updSerListMage(@RequestBody SerListMagePo po) {

        return service.updSerListMage(po);
    }

    /**
     * 查询服务单不同状态数量
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/getSerListStateType", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询服务单不同状态数量", value = "查询服务单不同状态数量", notes = "查询服务单不同状态数量", httpMethod = "POST")
    public ResultPoJo<List<SerListStateTypeCountVo>> getSerListStateType(@RequestBody MembPo po) {

        return service.getSerListStateType(po);
    }

    /**
     * 获取服务单取消原因列表
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/getOrdCancelReason", method = RequestMethod.POST)
    @ApiOperation(nickname = "获取服务单取消原因列表", value = "获取服务单取消原因列表", notes = "获取服务单取消原因列表", httpMethod = "POST")
    public ResultPoJo<List<OrdCancelReasonMageListVo>> getOrdCancelReason() {

        return service.getOrdCancelReason();
    }
}
