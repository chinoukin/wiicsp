package com.wisea.equipment.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.equipment.po.EquModelListPo;
import com.wisea.equipment.po.EquModelPageListPo;
import com.wisea.equipment.po.EquModelPo;
import com.wisea.equipment.service.EquModelMageService;
import com.wisea.equipment.vo.EquModelListVo;
import com.wisea.equipment.vo.EquModelPageListVo;
import com.wisea.equipment.vo.EquModelVo;
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
 * @className EquModelMageController
 * @date 2020/7/6 16:14
 * @Description 设备型号管理
 */
@RestController
@RequestMapping("/w/equ/model")
@Api(tags = "【设备】设备型号管理")
public class EquModelMageController {
    @Autowired
    private EquModelMageService service;

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 分页查询设备型号列表
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询设备型号列表", value = "分页查询设备型号列表", notes = "分页查询设备型号列表", httpMethod = "POST")
    public ResultPoJo<Page<EquModelPageListVo>> findPageList(@RequestBody EquModelPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 根据厂商查询设备型号列表
     */
    @DataCheck
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @ApiOperation(nickname = "根据厂商查询设备型号列表", value = "根据厂商查询设备型号列表", notes = "根据厂商查询设备型号列表", httpMethod = "POST")
    public ResultPoJo<List<EquModelListVo>> findList(@RequestBody EquModelListPo po) {
        return service.findList(po);
    }

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 保存或修改设备型号
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "保存或修改设备型号", value = "保存或修改设备型号", notes = "保存或修改设备型号", httpMethod = "POST")
    public ResultPoJo<?> saveOrUpdate(@RequestBody EquModelPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 查询设备型号详细信息
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询设备型号详细信息", value = "查询设备型号详细信息", notes = "查询设备型号详细信息", httpMethod = "POST")
    public ResultPoJo<EquModelVo> findEquModelInfo(@RequestBody LongIdPo po) {
        return service.findEquModelInfo(po);
    }

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 删除设备型号
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "删除设备型号", value = "删除设备型号", notes = "删除设备型号", httpMethod = "POST")
    public ResultPoJo<?> delEquModel(@RequestBody LongIdPo po) {
        return service.delEquModel(po);
    }
}
