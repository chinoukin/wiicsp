package com.wisea.cultivar.origin.controller.web;

import com.wisea.cultivar.origin.vo.JudgeMeetInfoVo;
import com.wisea.cultivar.origin.vo.JudgeMeetListWebVo;
import com.wisea.cultivar.origin.vo.ReportImgListVo;
import com.wisea.cultivar.origin.po.CheckJudgeMeetNamePo;
import com.wisea.cultivar.origin.po.ImgListPo;
import com.wisea.cultivar.origin.po.JudgeMeetListWebPo;
import com.wisea.cultivar.origin.po.LongIdPo;
import com.wisea.cultivar.origin.po.SaveOrUpdJudgeMeetPo;
import com.wisea.cultivar.origin.service.JudgeMeetInfoService;
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
@Api(tags = "后台品鉴会管理")
@RestController
@RequestMapping("/w/web/judgeMeet")
public class JudgeMeetWebController {

	@Autowired
    JudgeMeetInfoService service;

	/**
	 * 分页查询品鉴会管理列表
	 *
	 * @param po
	 * @return
	 */
	@ApiOperation(nickname = "分页查询品鉴会管理列表", value = "分页查询品鉴会管理列表", notes = "分页查询品鉴会管理列表")
	@RequestMapping(value = "/findList", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Page<JudgeMeetListWebVo>> findJudgeMeetListWeb(@RequestBody JudgeMeetListWebPo po) {
		return service.findJudgeMeetListWeb(po);
	}

	/**
	 * 删除品鉴会
	 * @param po
	 * @return
	 */
	@ApiOperation(nickname = "删除品鉴会", value = "删除品鉴会", notes = "删除品鉴会")
	@RequestMapping(value = "/delJudgeMeet", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<?> delJudgeMeet(@ApiParam(value = "品鉴会ID") @RequestBody LongIdPo po) {
		return service.delJudgeMeet(po);
	}
	/**
	 * 查询品鉴会信息详情
	 *
	 * @param po
	 * @return
	 */
	@ApiOperation(nickname = "查询品鉴会信息详情", value = "查询品鉴会信息详情", notes = "查询品鉴会信息详情")
	@RequestMapping(value = "/findByid", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<JudgeMeetInfoVo> getFindJudgeMeetByid(@ApiParam(value = "品鉴会ID") @RequestBody LongIdPo po) {
		return service.getFindJudgeMeetByid(po);
	}

	/**
	 * 品鉴会保存/修改操作
	 *
	 * @param
	 * @return
	 */
	@ApiOperation(nickname = "品鉴会保存/修改操作", value = "品鉴会保存/修改操作", notes = "品鉴会保存/修改操作")
	@RequestMapping(value = "/saveOrUpdJudgeMeet", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<?> saveOrUpdJudgeMeet(@RequestBody SaveOrUpdJudgeMeetPo po) {
		return service.saveOrUpdJudgeMeet(po);
	}

	/**
	 * 录入报告保存操作
	 *
	 * @param
	 * @return
	 */
	@ApiOperation(nickname = "录入报告保存操作", value = "录入报告保存操作", notes = "录入报告保存操作")
	@RequestMapping(value = "/uploadReport", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<?> uploadReport(@RequestBody ImgListPo po) {
		return service.uploadReport(po);
	}

	/**
	 * 录入报告查询操作
	 *
	 * @param po
	 * @return
	 */
	@ApiOperation(nickname = "录入报告查询操作", value = "录入报告查询操作", notes = "录入报告查询操作")
	@RequestMapping(value = "/getReportByid", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<ReportImgListVo> getReportByid(@ApiParam(value = "样品ID") @RequestBody LongIdPo po) {
		return service.getReportByid(po);
	}

	/**
     * 校验品鉴会名称
     * @param
     * @return
     */
    @ApiOperation(nickname="校验品鉴会名称", value = "校验品鉴会名称",notes = "校验品鉴会名称")
    @RequestMapping(value = "/checkName",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> checkName(@RequestBody CheckJudgeMeetNamePo po){
    	return service.checkName(po);
    }


}
