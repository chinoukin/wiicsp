package com.wisea.cultivar.origin.controller.web;

import com.wisea.cultivar.origin.po.LongIdPo;
import com.wisea.cultivar.origin.vo.SampInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cultivar.common.po.tp.StringPo;
import com.wisea.cultivar.origin.service.SampInfoService;
import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *
 * @author wzx
 *
 */
@Api(tags = "无权限接口控制类")
@RestController
@RequestMapping("/web/samp")
public class NotAuthSampController {
	@Autowired
	SampInfoService sampInfoService;

	/**
	 * 查询样品详情
	 *
	 * @param po
	 * @return
	 */
	@ApiOperation(nickname = "查询样品详情", value = "查询样品详情", notes = "查询样品详情")
	@RequestMapping(value = "/findByid", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<SampInfoVo> getNotAuthSampInfoByid(@ApiParam(value = "样品ID") @RequestBody LongIdPo po) {
		return sampInfoService.getNotAuthSampInfoByid(po);
	}
	/**
	 * 查询企业检测数据--农资同步使用
	 *
	 * @param po
	 * @return
	 */
	@RequestMapping(value = "/getSampInfo", method = RequestMethod.POST)
	@ApiOperation(value = "查询企业检测数据")
	public ResultPoJo<String> getSampInfo(@RequestBody StringPo po) {
		return sampInfoService.getSampInfo(po);
	}
}
