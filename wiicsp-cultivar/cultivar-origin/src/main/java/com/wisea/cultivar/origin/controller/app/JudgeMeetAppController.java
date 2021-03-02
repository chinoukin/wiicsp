package com.wisea.cultivar.origin.controller.app;

import com.wisea.cultivar.origin.po.JudgeMeetChoiceListPo;
import com.wisea.cultivar.origin.po.JudgeMeetListPo;
import com.wisea.cultivar.origin.vo.JudgeMeetListVo;
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

/**
 *
 * @author wzx
 *
 */
@Api(tags = "品鉴会管理")
@RestController
@RequestMapping("/w/app/judgeMeet")
public class JudgeMeetAppController {

	 @Autowired
     JudgeMeetInfoService service;

	/**
	 * 分页查询品鉴会列表
	 * @param po
	 * @return
	 */
    @ApiOperation(nickname="分页查询品鉴会列表", value = "分页查询品鉴会列表",notes = "分页查询品鉴会列表")
    @RequestMapping(value = "/findList",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<JudgeMeetListVo>> findJudgeMeetList(@RequestBody JudgeMeetListPo po){
        return service.findJudgeMeetList(po);
    }

    /**
     * 分页选择品鉴会列表
     * @param po
     * @return
     */
    @ApiOperation(nickname="分页选择品鉴会列表", value = "分页选择品鉴会列表",notes = "分页选择品鉴会列表")
    @RequestMapping(value = "/findChoiceList",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<JudgeMeetListVo>> findChoiceList(@RequestBody JudgeMeetChoiceListPo po){
    	return service.findChoiceList(po);
    }


}
