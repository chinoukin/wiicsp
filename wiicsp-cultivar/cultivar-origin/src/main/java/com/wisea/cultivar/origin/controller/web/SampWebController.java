package com.wisea.cultivar.origin.controller.web;

import com.wisea.cultivar.origin.po.LongIdPo;
import com.wisea.cultivar.origin.po.SampListWebPo;
import com.wisea.cultivar.origin.vo.SampInfoVo;
import com.wisea.cultivar.origin.vo.SampListWebVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.origin.service.SampInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *
 * @author wzx
 *
 */
@Api(tags = "后台检测信息管理")
@RestController
@RequestMapping("/w/web/samp")
public class SampWebController {

	@Autowired
	SampInfoService service;

	/**
	 * 分页查询检测信息列表
	 *
	 * @param po
	 * @return
	 */
	@ApiOperation(nickname = "分页查询检测信息列表", value = "分页查询检测信息列表", notes = "分页查询检测信息列表")
	@RequestMapping(value = "/findList", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Page<SampListWebVo>> findSampInfoListWeb(@RequestBody SampListWebPo po) {
		return service.findSampInfoListWeb(po);
	}
	 /**
     * 查询检测详情
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询检测详情", value = "查询检测详情", notes = "查询检测详情")
    @RequestMapping(value = "/findByid", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SampInfoVo> getFindSampInfoByid(@ApiParam(value = "样品ID") @RequestBody LongIdPo po){
        return service.getFindSampInfoByid(po);
    }
    /**
     * 刷新未检测的样品是否已经检测
     *
     * @author wangh(wisea)
     *
     * @date 2018年9月5日
     * @version 1.0
     */
    @ApiOperation(nickname = "刷新未检测的样品是否已经检测", value = "刷新未检测的样品是否已经检测", notes = "刷新未检测的样品是否已经检测")
    @RequestMapping(value = "/freshen", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<String> freshen(){
        return service.freshen();
    }

}
