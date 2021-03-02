package com.wisea.cultivar.origin.controller.bigdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.SampJcCountPagePo;
import com.wisea.cultivar.common.po.bigdata.SampJcCountPo;
import com.wisea.cultivar.common.vo.bigdata.BigDataSampCountVo;
import com.wisea.cultivar.common.vo.bigdata.SampBaseInfoForBigDataVo;
import com.wisea.cultivar.origin.service.bigdata.NotAuthIndexService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 大数据样品统计相关的接口
 *
 * @author wangh(wisea)
 *
 * @date 2019年11月7日
 * @version 1.0
 */
@Api(tags = "大数据样品统计相关的接口(无权限接口控制类)")
@RestController
@RequestMapping("/n/sampInfo/bigData/")
public class NotAuthIndexController {

	@Autowired
	private NotAuthIndexService notAuthIndexService;
	/**
	 * 大数据统计样品信息查询
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年11月7日
	 * @version 1.0
	 */
	@ApiOperation(value = "大数据统计样品信息查询")
    @PostMapping(value = "count")
    @DataCheck
	public ResultPoJo<BigDataSampCountVo> sampJcCount(@RequestBody SampJcCountPo po){
		// 设置要查询的节点的父节点编码
		po.setParentCode("420000000000");
		// 返回值的处理
		return notAuthIndexService.sampJcCount(po);
	}
	/**
	 * 大数据分页查询样品基本信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年11月7日
	 * @version 1.0
	 */
	@ApiOperation(value = "大数据分页查询样品基本信息")
    @PostMapping(value = "findPage")
    @DataCheck
	public ResultPoJo<Page<SampBaseInfoForBigDataVo>> findSampPage(@RequestBody SampJcCountPagePo po){
		// 设置要查询的节点的父节点编码
		po.setParentCode("420000000000");
		// 返回值的处理
		return notAuthIndexService.findSampPage(po);
	}
}
