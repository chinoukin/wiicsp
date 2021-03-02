package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.plant.po.oritrapla.InsctWarningPo;
import com.wisea.cultivar.plant.po.oritrapla.LongIdPo;
import com.wisea.cultivar.plant.vo.oritrapla.YjMageGetVo;
import com.wisea.cultivar.plant.po.oritrapla.YjMageUpdatePo;
import com.wisea.cultivar.plant.service.oritrapla.InsectPestsWarningSendService;
import com.wisea.cultivar.plant.service.oritrapla.YjMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 预警设置APPController
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月23日
 * @version 1.0
 */
@Api(tags = "【原产地通】预警设置相关接口")
@RestController
@RequestMapping("/w/app")
public class YjMageAppController {

	@Autowired
	private YjMageService yjMageService;
	@Autowired
	private InsectPestsWarningSendService insectPestsWarningSendService;

	/**
	 * 通过档案ID获取预警设置信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月23日
	 * @version 1.0
	 */
	@ApiOperation(value="通过档案ID获取预警设置信息")
	@RequestMapping(value = "/yjmage/getInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<YjMageGetVo> getInfo(@RequestBody LongIdPo po){
		//  返回信息
		return yjMageService.getInfo(po);
	}
	/**
	 * 修改预警设置信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月23日
	 * @version 1.0
	 */
	@ApiOperation(value="修改预警设置信息")
	@RequestMapping(value = "/yjmage/updYjMage",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> updYjMage(@RequestBody YjMageUpdatePo po){
		//  返回信息
		return yjMageService.updYjMage(po);
	}
	@ApiOperation(value="测试预警发送信息(内部调用)")
	@RequestMapping(value = "/yjmage/send",method = RequestMethod.POST)
	@DataCheck
	public void send(@RequestBody InsctWarningPo po){
		//  返回信息
		insectPestsWarningSendService.sendWarningMsg(po);
	}
}
