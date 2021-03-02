package com.wisea.cultivar.origin.controller.app;

import com.wisea.cultivar.origin.po.DetectionMechMageListPo;
import com.wisea.cultivar.origin.vo.DetectionMechMageListVo;
import com.wisea.cultivar.origin.service.DetectionMechMageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author wzx
 *
 */
@Api(tags = "检测机构")
@RestController
@RequestMapping("/w/app/detectionMech")
public class DetectionMechMageAppController {

	 @Autowired
     DetectionMechMageService service;

	/**
	 * 分页查询检测机构列表
	 * @param po
	 * @return
	 */
    @ApiOperation(nickname="分页查询检测机构列表", value = "分页查询检测机构列表",notes = "分页查询检测机构列表")
    @RequestMapping(value = "/findList",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<DetectionMechMageListVo>> findDetectionMechList(@RequestBody DetectionMechMageListPo po){
        return service.findDetectionMechList(po);
    }


}
