package com.wisea.transac.tp.system.controller.memb;

import com.wisea.transac.tp.system.service.memb.MarketMembStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.memb.MarketMembAddTjPo;
import com.wisea.transac.common.vo.memb.MarketMembAddTjVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 市场会员统计处理相关接口
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月29日
 * @version 1.0
 */
@Api(tags = "市场会员统计处理相关接口")
@RestController
@RequestMapping("/w/market/tj")
public class MarketMembStatisticsController {


	@Autowired
	private MarketMembStatisticsService marketMembStatisticsService;
	/**
	 * 会员增长情况的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月29日
	 * @version 1.0
	 */
	@ApiOperation(value = "会员增长情况的处理",notes = "会员增长情况的处理")
	@PostMapping(value = "/marketMembAddTj")
	@DataCheck
	public ResultPoJo<MarketMembAddTjVo> marketMembAddTj(@RequestBody MarketMembAddTjPo po){
		// 查询并且返回
		return marketMembStatisticsService.marketMembAddTj(po);
	}
	/**
	 * 市场运营中会员消费统计的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月29日
	 * @version 1.0
	 */
	@ApiOperation(value = "市场运营中会员消费统计的处理",notes = "市场运营中会员消费统计的处理")
	@PostMapping(value = "/marketMembConsumeTj")
	@DataCheck
	public ResultPoJo<MarketMembAddTjVo> marketMembConsumeTj(@RequestBody MarketMembAddTjPo po){
		// 查询并且返回
		return marketMembStatisticsService.marketMembConsumeTj(po);
	}
}
