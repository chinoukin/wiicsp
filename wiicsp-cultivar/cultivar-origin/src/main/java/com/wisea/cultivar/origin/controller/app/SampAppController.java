package com.wisea.cultivar.origin.controller.app;

import com.wisea.cultivar.origin.po.LongIdPo;
import com.wisea.cultivar.origin.po.SampListPo;
import com.wisea.cultivar.origin.po.SaveOrUpdSampPo;
import com.wisea.cultivar.origin.po.UpdSampStateTypePo;
import com.wisea.cultivar.origin.vo.SampInfoVo;
import com.wisea.cultivar.origin.vo.SampListVo;
import com.wisea.cultivar.origin.service.SampInfoService;
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
@Api(tags = "检测样品")
@RestController
@RequestMapping("/w/app/samp")
public class SampAppController {

	 @Autowired
     SampInfoService service;

	/**
	 * 分页查询检测样品列表
	 * @param po
	 * @return
	 */
    @ApiOperation(nickname="分页查询检测样品列表", value = "分页查询检测样品列表",notes = "分页查询检测样品列表")
    @RequestMapping(value = "/findList",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<SampListVo>> findSampInfoList(@RequestBody SampListPo po){
        return service.findSampInfoList(po);
    }

    /**
     * 确认上传
     * @param
     * @return
     */
    @ApiOperation(nickname="确认上传", value = "确认上传",notes = "确认上传")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> updSampStateType(@RequestBody UpdSampStateTypePo po){
        return service.updSampStateType(po);
    }

    /**
     * 样品信息保存/修改操作
     * @param
     * @return
     */
    @ApiOperation(nickname="样品信息保存/修改操作", value = "样品信息保存/修改操作",notes = "样品信息保存/修改操作")
    @RequestMapping(value = "/saveOrUpdSamp",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> saveOrUpdSamp(@RequestBody SaveOrUpdSampPo po){
    	return service.saveOrUpdSamp(po);
    }

    /**
     * 查询样品信息详情
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询样品信息详情", value = "查询样品信息详情", notes = "查询样品信息详情")
    @RequestMapping(value = "/findByid", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SampInfoVo> getFindSampInfoByid(@ApiParam(value = "样品ID") @RequestBody LongIdPo po){
        return service.getFindSampInfoByid(po);
    }

    /**
     * 删除样品信息
     * @param
     * @return
     */
    @ApiOperation(nickname="删除样品信息", value = "删除样品信息",notes = "删除样品信息")
    @RequestMapping(value = "/delSampInfo",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> delSampInfo(@ApiParam(value = "样品ID") @RequestBody LongIdPo po){
    	return service.delSampInfo(po);
    }



}
