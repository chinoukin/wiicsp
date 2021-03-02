package com.wisea.cultivar.origin.controller.app;

import com.wisea.cultivar.origin.po.LongIdPo;
import com.wisea.cultivar.origin.po.MapDetailInfoPo;
import com.wisea.cultivar.origin.po.MembListPo;
import com.wisea.cultivar.origin.vo.MapDetailInfoVo;
import com.wisea.cultivar.origin.vo.MembListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cultivar.origin.entity.MembInfo;
import com.wisea.cultivar.origin.service.MapUtilsService;
import com.wisea.cultivar.origin.service.MembInfoService;
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
@Api(tags = "采样企业")
@RestController
@RequestMapping("/w/app/memb")
public class MembAppController {

	 @Autowired
     MembInfoService service;
	 @Autowired
	 private MapUtilsService mapUtilsService;

	/**
	 * 分页查询采样企业列表
	 * @param po
	 * @return
	 */
    @ApiOperation(nickname="分页查询采样企业列表", value = "分页查询采样企业列表",notes = "分页查询采样企业列表")
    @RequestMapping(value = "/findList",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<MembListVo>> findMembInfoList(@RequestBody MembListPo po){
        return service.findMembInfoList(po);
    }

    /**
     * 会员信息
     * @param po
     * @return
     */
    @ApiOperation(nickname="会员信息", value = "会员信息",notes = "会员信息")
    @RequestMapping(value = "/findMembInfo",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<MembInfo> findMembInfo(@RequestBody LongIdPo po){
    	return service.findMembInfo(po);
    }
    /**
     * 根据经纬度查询地图详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年10月11日
     * @version 1.0
     */
    @ApiOperation(value = "根据经纬度查询地图详细信息")
    @PostMapping(value = "/map/getMapDetailByLatLng")
    @DataCheck
    public ResultPoJo<MapDetailInfoVo> getMapDetailByLatLng(@RequestBody MapDetailInfoPo po){
    	// 返回结果
    	return mapUtilsService.getMapDetailByLatLng(po);
    }

}
