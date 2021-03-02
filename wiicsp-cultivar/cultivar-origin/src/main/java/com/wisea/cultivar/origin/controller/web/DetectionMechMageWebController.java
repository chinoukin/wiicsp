package com.wisea.cultivar.origin.controller.web;

import com.wisea.cultivar.origin.po.CheckOrgNumPo;
import com.wisea.cultivar.origin.po.DetectionMechMageListWebPo;
import com.wisea.cultivar.origin.po.LongIdPo;
import com.wisea.cultivar.origin.po.SaveOrUpdDetectionMechMagePo;
import com.wisea.cultivar.origin.vo.DetectionMechMageListWebVo;
import com.wisea.cultivar.origin.entity.DetectionMechMage;
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
import io.swagger.annotations.ApiParam;

/**
 *
 * @author wzx
 *
 */
@Api(tags = "后台检测机构管理")
@RestController
@RequestMapping("/w/web/detectionMech")
public class DetectionMechMageWebController {

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
    public ResultPoJo<Page<DetectionMechMageListWebVo>> findDetectionMechList(@RequestBody DetectionMechMageListWebPo po){
        return service.findDetectionMechListWeb(po);
    }
    /**
     * 查询机构信息详情
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询机构信息详情", value = "查询机构信息详情", notes = "查询机构信息详情")
    @RequestMapping(value = "/findByid", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<DetectionMechMage> getFindDetectionMechByid(@ApiParam(value = "检测机构ID") @RequestBody LongIdPo po){
        return service.getFindDetectionMechByid(po);
    }

    /**
     * 删除检测机构
     * @param
     * @return
     */
    @ApiOperation(nickname="删除检测机构", value = "删除检测机构",notes = "删除检测机构")
    @RequestMapping(value = "/delDetectionMech",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> delDetectionMech(@ApiParam(value = "检测机构ID") @RequestBody LongIdPo po){
    	return service.delDetectionMech(po);
    }
    /**
     * 检测机构保存/修改操作
     * @param
     * @return
     */
    @ApiOperation(nickname="检测机构保存/修改操作", value = "检测机构保存/修改操作",notes = "检测机构保存/修改操作")
    @RequestMapping(value = "/saveOrUpdDetectionMech",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> saveOrUpdDetectionMech(@RequestBody SaveOrUpdDetectionMechMagePo po){
    	return service.saveOrUpdDetectionMech(po);
    }
    /**
     * 校验机构编号
     * @param
     * @return
     */
    @ApiOperation(nickname="校验机构编号", value = "校验机构编号",notes = "校验机构编号")
    @RequestMapping(value = "/checkOrgNum",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> checkOrgNum(@RequestBody CheckOrgNumPo po){
    	return service.checkOrgNum(po);
    }

}
