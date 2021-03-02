package com.wisea.equipment.controller.mss;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.equipment.po.EquDataPointPo;
import com.wisea.equipment.po.EquInfoRemotPo;
import com.wisea.equipment.service.EquInfoService;
import com.wisea.equipment.service.SearchMeteorologyService;
import com.wisea.equipment.vo.MeteorologyInfluxVo;
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
 * @Description 物联网设备管理远程接口
 */
@RestController
@RequestMapping("/i/equ/equInfo")
@Api(tags = "【设备】物联网设备管理远程接口", hidden = true)
public class EquInfoMssController {
    @Autowired
    private EquInfoService service;
    @Autowired
    private SearchMeteorologyService searchMeteorologyService;

    /**
     * @author jirg
     * @date 2020/7/6 14:55
     * @Description 远程保存设备
     */
    @DataCheck
    @RequestMapping(value = "/remotSaveEquInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "远程保存物联网设备", value = "远程保存物联网设备", notes = "远程保存物联网设备", httpMethod = "POST")
    public ResultPoJo<?> remotSaveEquInfo(@RequestBody EquInfoRemotPo po) {
        return service.remotSaveEquInfo(po);
    }

    /**
     * @author jirg
     * @date 2020/8/11 17:02
     * @Description 远程查询设备最新数据节点
     */
    @DataCheck
    @RequestMapping(value = "/remotLastDataPoint", method = RequestMethod.POST)
    @ApiOperation(nickname = "远程查询设备最新气象数据", value = "远程查询设备最新气象数据", notes = "远程查询设备最新气象数据", httpMethod = "POST")
    public ResultPoJo<MeteorologyInfluxVo> remotLastDataPoint(@RequestBody EquDataPointPo po) {
        return searchMeteorologyService.getLastDataPoint(po);
    }
}
