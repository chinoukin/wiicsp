package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.vo.oritrapla.LoginBaseInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.MembLatLngInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.MembMainInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.SubMembInfoVo;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.service.oritrapla.MembAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * APP端会员相关的接口
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@Api(value = "【原产地通】APP端会员相关的接口(需要权限)", description = "供App端调用", tags = "APP端会员相关的接口(需要权限)")
@RestController
@RequestMapping("/w/app")
public class MembAppController {

	@Autowired
	private MembAppService membAppService;


	/**
	 * oritrapla_008_【会员】基本信息的查询(登录成功后调用)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="基本信息的查询(登录成功后调用)", value = "oritrapla_008_【会员】基本信息的查询(登录成功后调用)",notes = "基本信息的查询(登录成功后调用)")
	@RequestMapping(value = "/memb/getBaseInfoById",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<LoginBaseInfoVo> getBaseInfoById(){
		// 返回参数
		return membAppService.getBaseInfoById();
	}
	/**
	 * oritrapla_005_【会员】注册时保存主体信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="注册时保存主体信息", value = "oritrapla_005_【会员】注册时保存主体信息",notes = "注册时保存主体信息")
	@RequestMapping(value = "/memb/saveMainMembInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveMainMembInfo(@RequestBody SaveMainMembInfoPo po){
		// 返回参数
		return membAppService.saveMainMembInfo(po);
	}
	/**
	 * oritrapla_010_【会员】会员头像的保存
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="会员头像的保存", value = "oritrapla_010_【会员】会员头像的保存",notes = "会员头像的保存")
	@RequestMapping(value = "/memb/saveLogoUrl",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveLogoUrl(@RequestBody CheckStringPo po){
		// 返回参数
		ZhfwMembInfo membInfo = new ZhfwMembInfo();
		membInfo.setLogoUrl(po.getStr());
		return membAppService.onlySaveMembInfo(membInfo);
	}
	/**
	 * oritrapla_011_【会员】会员姓名的保存
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="会员姓名的保存", value = "oritrapla_011_【会员】会员姓名的保存",notes = "会员姓名的保存")
	@RequestMapping(value = "/memb/saveContName",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveContName(@RequestBody CheckStringPo po){
		// 返回参数
		ZhfwMembInfo membInfo = new ZhfwMembInfo();
		membInfo.setContName(po.getStr());
		return membAppService.onlySaveMembInfo(membInfo);
	}
	/**
	 * oritrapla_012_【会员】会员性别的保存
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="会员性别的保存", value = "oritrapla_012_【会员】会员性别的保存",notes = "会员性别的保存")
	@RequestMapping(value = "/memb/saveSexType",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveSexType(@RequestBody EnumStrPo po){
		// 返回参数
		ZhfwMembInfo membInfo = new ZhfwMembInfo();
		membInfo.setSexType(po.getFlag());
		return membAppService.onlySaveMembInfo(membInfo);
	}
	/**
	 * oritrapla_013_【会员】会员个性签名的保存
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="会员个性签名的保存", value = "oritrapla_013_【会员】会员个性签名的保存",notes = "会员个性签名的保存")
	@RequestMapping(value = "/memb/saveSignature",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveSignature(@RequestBody CheckStringPo po){
		// 返回参数
		ZhfwMembInfo membInfo = new ZhfwMembInfo();
		membInfo.setSignature(po.getStr());
		return membAppService.onlySaveMembInfo(membInfo);
	}
	/**
	 * oritrapla_060_【会员】会员职称的保存
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="会员职称的保存", value = "oritrapla_060_【会员】会员职称的保存",notes = "会员职称的保存")
	@RequestMapping(value = "/memb/savePosition",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> savePosition(@RequestBody CheckStringPo po){
		// 返回参数
		ZhfwMembInfo membInfo = new ZhfwMembInfo();
		membInfo.setPosition(po.getStr());
		return membAppService.onlySaveMembInfo(membInfo);
	}
	/**
	 * oritrapla_014_【会员】主体信息的查询
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	@ApiOperation(nickname="主体信息的查询", value = "oritrapla_014_【会员】主体信息的查询",notes = "主体信息的查询")
	@RequestMapping(value = "/memb/getMainMembInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<MembMainInfoVo> getMainMembInfo(){
		// 返回参数
		return membAppService.getMainMembInfo();
	}
	/**
	 * oritrapla_016_【会员】保存主体基本信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	@ApiOperation(nickname="保存主体基本信息", value = "oritrapla_016_【会员】保存主体基本信息",notes = "保存主体基本信息")
	@RequestMapping(value = "/memb/saveMainInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveMainInfo(@RequestBody MembMainInfoPo po){
		// 返回参数
		return membAppService.saveMainInfo(po);
	}
	/**
	 * oritrapla_017_【会员】主体信息中品牌信息的保存
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	@ApiOperation(nickname="主体信息中品牌信息的保存", value = "oritrapla_017_【会员】主体信息中品牌信息的保存",notes = "主体信息中品牌信息的保存")
	@RequestMapping(value = "/memb/saveBrandInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveBrandInfo(@RequestBody BrandInfoPo po){
		// 返回参数
		return membAppService.saveBrandInfo(po);
	}
	/**
	 * oritrapla_024_【会员】主体信息中品牌信息的删除
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	@ApiOperation(nickname="主体信息中品牌信息的删除", value = "oritrapla_024_【会员】主体信息中品牌信息的删除",notes = "主体信息中品牌信息的删除")
	@RequestMapping(value = "/memb/delBrandInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> delBrandInfo(@RequestBody LongIdPo po){
		// 返回参数
		return membAppService.delBrandInfo(po);
	}
	/**
	 * oritrapla_018_【会员】人员管理列表的查询
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	@ApiOperation(nickname="人员管理列表的查询", value = " oritrapla_018_【会员】人员管理列表的查询",notes = "人员管理列表的查询")
	@RequestMapping(value = "/memb/findMembInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Page<SubMembInfoVo>> findMembInfo(@RequestBody SelSubMembPo po){
		// 返回参数
		return membAppService.findMembInfo(po);
	}
	/**
	 * oritrapla_019_【会员】人员管理中保存人员信息的 操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月7日
	 * @version 1.0
	 */
	@ApiOperation(nickname="人员管理中保存人员信息的 操作", value = "oritrapla_019_【会员】人员管理中保存人员信息的 操作",notes = "人员管理中保存人员信息的 操作")
	@RequestMapping(value = "/memb/saveMembInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveMembInfo(@RequestBody SaveSubMembInfoPo po){
		// 返回参数
		return membAppService.saveMembInfo(po);
	}
	/**
	 * oritrapla_020_【会员】人员管理中删除人员信息的 操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月7日
	 * @version 1.0
	 */
	@ApiOperation(nickname="人员管理中删除人员信息的 操作", value = "oritrapla_020_【会员】人员管理中删除人员信息的 操作",notes = "人员管理中删除人员信息的 操作")
	@RequestMapping(value = "/memb/delMembInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> delMembInfo(@RequestBody LongIdPo po){
		// 返回参数
		return membAppService.delMembInfo(po);
	}
	/**
	 * oritrapla_022_【会员】设置中意见反馈的保存
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月11日
	 * @version 1.0
	 */
	@ApiOperation(nickname="设置中意见反馈的保存", value = "oritrapla_022_【会员】设置中意见反馈的保存",notes = "设置中意见反馈的保存")
	@RequestMapping(value = "/memb/saveFeedback",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveFeedback(@RequestBody OpinRetroaPo po){
		// 返回参数
		return membAppService.saveFeedback(po);
	}
	/**
	 * 保存农场的经度和纬度的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月11日
	 * @version 1.0
	 */
	@ApiOperation(nickname="保存农场的经度和纬度的处理", value = "保存农场的经度和纬度的处理",notes = "保存农场的经度和纬度的处理")
	@RequestMapping(value = "/memb/setLatLng",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> setLatLng(@RequestBody MembLatLngSetPo po){
		// 返回参数
		return membAppService.setLatLng(po);
	}
	/**
	 * 获取农场的经纬度信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月11日
	 * @version 1.0
	 */
	@ApiOperation(nickname="获取农场的经纬度信息", value = "获取农场的经纬度信息",notes = "获取农场的经纬度信息")
	@RequestMapping(value = "/memb/getMembLatLng",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<MembLatLngInfoVo> getMembLatLng(@RequestBody LongIdPo po){
		// 返回参数
		return membAppService.getMembLatLng(po);
	}
}
