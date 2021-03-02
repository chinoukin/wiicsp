package com.wisea.equipment.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.equipment.po.EquInfoListPo;
import com.wisea.equipment.po.EquInfoPo;
import com.wisea.equipment.service.EquInfoService;
import com.wisea.equipment.vo.EquInfoListVo;
import com.wisea.equipment.vo.EquInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoController
 * @date 2020/7/7 9:50
 * @Description 设备管理
 */
@RestController
@RequestMapping("/w/equ/equInfo")
@Api(tags = "【设备】设备管理")
public class EquInfoController {
    @Autowired
    private EquInfoService service;

    /**
     * @author jirg
     * @date 2020/7/7 10:12
     * @Description 分页查询设备列表
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询设备列表", value = "分页查询设备列表", notes = "分页查询设备列表", httpMethod = "POST")
    public ResultPoJo<Page<EquInfoListVo>> findPageList(@RequestBody EquInfoListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 保存或修改设备
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "保存或修改设备", value = "保存或修改设备", notes = "保存或修改设备", httpMethod = "POST")
    public ResultPoJo<?> saveOrUpdate(@RequestBody EquInfoPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 查询设备详细信息
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询设备详细信息", value = "查询设备详细信息", notes = "查询设备详细信息", httpMethod = "POST")
    public ResultPoJo<EquInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 删除设备
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "删除设备", value = "删除设备", notes = "删除设备", httpMethod = "POST")
    public ResultPoJo<?> delEquInfo(@RequestBody LongIdPo po) {
        return service.delEquInfo(po);
    }

}
