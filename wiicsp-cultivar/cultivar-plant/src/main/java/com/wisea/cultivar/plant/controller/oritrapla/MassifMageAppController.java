package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.MassifMageInfoAddPo;
import com.wisea.cultivar.plant.po.oritrapla.MassifMageInfoListPo;
import com.wisea.cultivar.plant.po.oritrapla.MassifMageInfoPo;
import com.wisea.cultivar.plant.vo.oritrapla.MassifMageInfoVo;
import com.wisea.cultivar.plant.service.oritrapla.MassifMageAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wzx
 * TODO 保留
 */
@Api(tags = "【原产地通】地块管理")
@RestController
@RequestMapping("/w/app/massif/")
public class MassifMageAppController {

	 @Autowired
     MassifMageAppService service;

	/**
	 * 分页查询地块列表
	 * @param po
	 * @return
	 */
    @ApiOperation(nickname="分页查询地块列表", value = "分页查询地块列表",notes = "分页查询地块列表")
    @RequestMapping(value = "/findMassifList",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<MassifMageInfoVo>> findMassifList(@RequestBody MassifMageInfoListPo po){
        return service.findMassifPageList(po);
    }

    /**
     * 保存地块
     * @param
     * @return
     */
    @ApiOperation(nickname="保存地块", value = "保存地块",notes = "保存地块")
    @RequestMapping(value = "/addOrUpdMassif",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> addOrUpdMassif(@RequestBody MassifMageInfoAddPo po){
        return service.addOrUpdMassif(po);
    }

    /**
     * 查询地块详细信息
     * @param
     * @return
     *//*
    @ApiOperation(nickname="查询地块详细信息", value = "查询地块详细信息",notes = "查询地块详细信息")
    @RequestMapping(value = "/findMassifInfo",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> findMassifInfo(@RequestBody MassifMageInfoPo po){
    	return service.findMassifInfo(po);
    }*/

    /**
     * 删除地块信息
     * @param
     * @return
     */
    @ApiOperation(nickname="删除地块信息", value = "删除地块信息",notes = "删除地块信息")
    @RequestMapping(value = "/delMassifInfo",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> delMassifInfo(@RequestBody MassifMageInfoPo po){
    	return service.delMassifInfo(po);
    }


}
