package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.FarmDictPo;
import com.wisea.cultivar.plant.entity.oritrapla.VersionInfoMage;
import com.wisea.cultivar.plant.po.oritrapla.VersionInfoMagePo;
import com.wisea.cultivar.plant.po.oritrapla.VersionInfoPo;
import com.wisea.cultivar.plant.service.oritrapla.SystemVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 系统版本控制类
 * @author: wangs
 * @date :2018/6/21
 */
@Api(value = "【原产地通】web管理系统(配置管理系统版本控制类)", description = "供web端调用", tags = "web管理系统(配置管理系统版本控制类)系统版本功能调用接口")
@RestController
@RequestMapping(value = "/w/web/systemVersion")
public class SystemVersionController {

    @Autowired
    SystemVersionService systemVersionService;

    /**
     * 查询系统版本列表分页
     *
     * @param versionInfoMagePo
     * @return
     */
    @ApiOperation(value = "查询系统版本列表分页", httpMethod = "POST")
    @RequestMapping(value = "/findListPage", method = RequestMethod.POST)
    public ResultPoJo<Page<VersionInfoMage>> systemVersionFindListPage(@RequestBody VersionInfoMagePo versionInfoMagePo) {

        return systemVersionService.systemVersionFindListPage(versionInfoMagePo);
    }

    /**
     * 新增系统版本信息
     * @param versionInfoPo
     * @return
     */
    @ApiOperation(value = "新增系统版本信息", httpMethod = "POST")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo systemVersionAdd(@RequestBody VersionInfoPo versionInfoPo) {

        return systemVersionService. systemVersionAdd(versionInfoPo);
    }

    /**
     * 修改系统版本信息
     *
     * @param
     * @return
     */
    @ApiOperation(value = "修改系统版本信息", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo systemVersionUpdate(@RequestBody VersionInfoPo versionInfoPo) {

        return systemVersionService.systemVersionUpdate(versionInfoPo);
    }

    /**
     * 查询版本详情
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询版本详情", httpMethod = "POST")
    @RequestMapping(value = "/deatail", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<VersionInfoMage> systemVersionDeatail(@RequestBody FarmDictPo farmDictPo) {

        return systemVersionService.systemVersionDeatail(farmDictPo);
    }

    /**
     * 删除系统版本
     *
     * @param
     * @return
     */
    @ApiOperation(value = "删除系统版本", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo systemVersionDelete(@RequestBody FarmDictPo farmDictPo) {

        return systemVersionService.systemVersionDelete(farmDictPo);
    }

}
