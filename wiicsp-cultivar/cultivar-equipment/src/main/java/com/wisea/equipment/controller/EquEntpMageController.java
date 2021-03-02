package com.wisea.equipment.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.equipment.entity.EquEntpMage;
import com.wisea.equipment.po.EquEntpListPo;
import com.wisea.equipment.po.EquEntpPo;
import com.wisea.equipment.service.EquEntpMageService;
import com.wisea.equipment.vo.EquEntpListVo;
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
 * @className EquEntpMageController
 * @date 2020/7/6 14:41
 * @Description 设备厂商管理
 */
@RestController
@RequestMapping("/w/equ/entp")
@Api(tags = "【设备】设备厂商管理")
public class EquEntpMageController {
    @Autowired
    private EquEntpMageService service;

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 分页查询设备厂商列表
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询设备厂商列表", value = "分页查询设备厂商列表", notes = "分页查询设备厂商列表", httpMethod = "POST")
    public ResultPoJo<Page<EquEntpListVo>> findPageList(@RequestBody EquEntpListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 查询所有设备厂商列表
     */
    @DataCheck
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询所有设备厂商列表", value = "查询所有设备厂商列表", notes = "查询所有设备厂商列表", httpMethod = "POST")
    public ResultPoJo<List<EquEntpListVo>> findList(@RequestBody EquEntpListPo po) {
        return service.findList(po);
    }

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 保存或修改设备厂商
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "保存或修改设备厂商", value = "保存或修改设备厂商", notes = "保存或修改设备厂商", httpMethod = "POST")
    public ResultPoJo<?> saveOrUpdate(@RequestBody EquEntpPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 查询设备厂商详细信息
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询设备厂商详细信息", value = "查询设备厂商详细信息", notes = "查询设备厂商详细信息", httpMethod = "POST")
    public ResultPoJo<EquEntpMage> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 删除设备厂商
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "删除设备厂商", value = "删除设备厂商", notes = "删除设备厂商", httpMethod = "POST")
    public ResultPoJo<?> delEquEntp(@RequestBody LongIdPo po) {
        return service.delEquEntp(po);
    }
}
