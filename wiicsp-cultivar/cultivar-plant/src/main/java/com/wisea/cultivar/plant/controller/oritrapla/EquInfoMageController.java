package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.EquInfoMageMonitorPo;
import com.wisea.cultivar.plant.po.oritrapla.EquInfoMagePo;
import com.wisea.cultivar.plant.po.oritrapla.EquInfoMageSavePo;
import com.wisea.cultivar.plant.po.oritrapla.LongIdPo;
import com.wisea.cultivar.plant.vo.oritrapla.ArchBasicInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.EquInfoMageMonitorVo;
import com.wisea.cultivar.plant.vo.oritrapla.EquInfoMageVo;
import com.wisea.cultivar.plant.service.oritrapla.EquInfoMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoMageController
 * @date 2019/2/25 9:45
 * @Description
 * TODO 保留
 */
@RestController
@RequestMapping("/w/equInfoMage")
@Api(tags = "【原产地通】设备信息管理")
public class EquInfoMageController {
    @Autowired
    private EquInfoMageService service;

    /**
     * @Author jirg
     * @Date 2019/2/25 9:50
     * @Description 分页查询设备信息列表
     **/
    @ApiOperation(value="oritrapla_130_【设备】分页查询设备信息列表", notes="【设备】分页查询设备信息列表")
    @RequestMapping(value="/findPageList",method= RequestMethod.POST)
    public ResultPoJo<Page<EquInfoMageVo>> findPageList(@RequestBody EquInfoMagePo EquInfoMage){
        return service.findPageList(EquInfoMage);
    }


    /**
     * @Author jirg
     * @Date 2019/2/25 9:50
     * @Description 分页查询设备监控列表
     **/
    @ApiOperation(value="oritrapla_133_【设备】分页查询设备监控列表", notes="【设备】分页查询设备监控列表")
    @RequestMapping(value="/findPageEquInfoMageMonitor",method= RequestMethod.POST)
    public ResultPoJo<Page<EquInfoMageMonitorVo>> findPageEquInfoMageMonitor(@RequestBody EquInfoMageMonitorPo EquInfoMageMonitorPo){
        return service.findPageEquInfoMageMonitor(EquInfoMageMonitorPo);
    }

    /**
     * @Author jirg
     * @Date 2019/2/25 9:50
     * @Description 删除设备信息
     **/
    @ApiOperation(value="oritrapla_131_【设备】删除设备信息", notes="【设备】删除设备信息")
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> del(@RequestBody LongIdPo idPo){
        return service.del(idPo);
    }

    /**
     * @Author jirg
     * @Date 2019/2/25 9:50
     * @Description 保存或修改设备信息
     **/
    @ApiOperation(value="oritrapla_132_【设备】保存或修改设备信息", notes="【设备】保存或修改设备信息")
    @RequestMapping(value="/saveOrUpdate",method= RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> saveOrUpdate(@RequestBody EquInfoMageSavePo EquInfoMage){
        return service.saveOrUpdate(EquInfoMage);
    }

    @DataCheck
    @PostMapping("/listArch")
    @ApiOperation("按设备ID查询未过期的档案信息")
    public ResultPoJo<List<ArchBasicInfoVo>> findAllArchInfoByEquId(@RequestBody LongIdPo po) {
        return service.findAllArchBasicInfoByEquId(po.getId());
    }
}
