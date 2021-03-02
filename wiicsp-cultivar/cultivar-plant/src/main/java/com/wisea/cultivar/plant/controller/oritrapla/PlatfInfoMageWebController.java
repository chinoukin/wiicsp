package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfInfoMage;
import com.wisea.cultivar.plant.po.oritrapla.WebPlatfInfoMageAddPo;
import com.wisea.cultivar.plant.service.oritrapla.PlatfInfoMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 其它信息配置
 * @author wzx
 * TODO 保留
 */
@Api(tags = "【原产地通】web其它信息配置")
@RestController
@RequestMapping("/w/web/other")
public class PlatfInfoMageWebController {

	@Autowired
	PlatfInfoMageService service;

	/**
	 * 关于我们信息的保存
	 *
	 * @param
	 * @return
	 */
	@ApiOperation(nickname = "关于我们信息的保存", value = "oritrapla_114_【其他信息配置】关于我们信息的保存", notes = "关于我们信息的保存")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<?> addPlatfInfo(@RequestBody WebPlatfInfoMageAddPo po) {
		return service.addPlatfInfo(po);
	}

	/**
	 * 查询其它信息配置详情
	 *
	 * @param
	 * @return
	 */
	@ApiOperation(nickname = "查询其它信息配置详情", value = "查询其它信息配置详情", notes = "查询其它信息配置详情")
	@RequestMapping(value = "/findDetail", method = RequestMethod.POST)
	public ResultPoJo<PlatfInfoMage> findPlatfInfo() {
		return service.findPlatfInfo();
	}

}
