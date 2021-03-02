package com.wisea.transac.tp.system.controller.memb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.memb.EntpAuthInfoSavePo;
import com.wisea.transac.common.po.seller.MerchantMembMagePo;
import com.wisea.transac.common.po.seller.SellerMembMageAddPo;
import com.wisea.transac.common.po.seller.SellerMembManagerPagePo;
import com.wisea.transac.common.vo.memb.EntpAuthUpdInitVo;
import com.wisea.transac.common.vo.memb.SellerAppEntpAuthInfoVo;
import com.wisea.transac.common.vo.seller.SellerMembMageAddVo;
import com.wisea.transac.common.vo.seller.SellerMembMagePageListVo;
import com.wisea.transac.tp.system.service.memb.SellerAppService;
import com.wisea.yspay.entity.YspayBanks;
import com.wisea.yspay.service.EnterpriseApiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 商户APP端专用的Controller
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月12日
 * @version 1.0
 */
@Api(tags = " 商户APP端专用的接口")
@RestController
@RequestMapping("/w/seller/")
public class SellerAppController {

	@Autowired
	private SellerAppService sellerAppService;
	@Autowired
	private EnterpriseApiService enterpriseApiService;
	/**
	 * 获取当前登录用户的企业认证状态
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月12日
	 * @version 1.0
	 */
	@ApiOperation(value = "获取当前登录用户的企业认证状态(仅支持商家端使用)",notes = "获取当前登录用户的企业认证状态(仅支持商家端使用)")
	@PostMapping(value = "entp/loginInit")
	@DataCheck
	public ResultPoJo<SellerAppEntpAuthInfoVo> entpAuthType(){
		// 操作并且返回处理
		return sellerAppService.entpAuthType();
	}
	/**
	 * 企业信息的暂存处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月12日
	 * @version 1.0
	 */
	@ApiOperation(value = "企业信息的暂存处理",notes = "企业信息的暂存处理")
	@PostMapping(value = "entp/temp/save")
	public ResultPoJo<String> temporarySaveEntpInfo(@RequestBody EntpAuthInfoSavePo po){
		// 保存并且返回处理
		return sellerAppService.temporarySaveEntpInfo(po);
	}
	/**
	 * 获取当前登录用户的最新企业信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月12日
	 * @version 1.0
	 */
	@ApiOperation(value = "获取当前登录用户的最新企业信息",notes = "获取当前登录用户的最新企业信息")
	@PostMapping(value = "entp/init")
	@DataCheck
	public ResultPoJo<EntpAuthUpdInitVo> entpAuthInit(){
		// 查询并且返回
		return sellerAppService.entpAuthInit();
	}
	/**
	 * 企业信息和银行卡信息的保存处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月12日
	 * @version 1.0
	 */
	@ApiOperation(value = "企业信息和银行卡信息的保存处理",notes = "企业信息和银行卡信息的保存处理")
	@PostMapping(value = "entp/save")
	@DataCheck
	public ResultPoJo<String> entpSave(@RequestBody EntpAuthInfoSavePo po){
		// 保存返回处理
		return sellerAppService.entpSave(po);
	}


	/**
	 * @Author jirg
	 * @Date 2020/6/1 10:13
	 * @Description 查询银行列表
	 */
	@ApiOperation(value = "查询银行列表",notes = "查询银行列表")
	@PostMapping(value = "entp/findBanks")
	@DataCheck
	public ResultPoJo<List<YspayBanks>> findBanks(@RequestBody YspayBanks po){
		return enterpriseApiService.findBanks(po);
	}
	/**
	 * 会员管理列表(商户APP)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月3日
	 * @version 1.0
	 */
	@ApiOperation(value = "会员管理列表(商户APP)",notes = "会员管理列表(商户APP)")
	@PostMapping(value = "memb/findPage")
	@DataCheck
	public ResultPoJo<Page<SellerMembMagePageListVo>> findMembManagerList(@RequestBody SellerMembManagerPagePo po){
		// 查询并且返回
		return sellerAppService.findMembManagerList(po);
	}
	/**
	 * 添加会员管理初期化查询处理(商户APP)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月3日
	 * @version 1.0
	 */
	@ApiOperation(value = "添加会员管理初期化查询处理(商户APP)",notes = "添加会员管理初期化查询处理(商户APP)")
	@PostMapping(value = "memb/getInfoForAdd")
	@DataCheck
	public ResultPoJo<SellerMembMageAddVo> getSellerMembCheck(@RequestBody SellerMembMageAddPo po){
		// 查询并且返回
		return sellerAppService.getSellerMembCheck(po);
	}
	/**
	 * 添加会员管理(商户APP)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月3日
	 * @version 1.0
	 */
	@ApiOperation(value = "添加会员管理(商户APP)",notes = "添加会员管理(商户APP)")
	@PostMapping(value = "memb/mageAdd")
	@DataCheck
	public ResultPoJo<String> addMerchantMembMage(@RequestBody MerchantMembMagePo po){
		// 添加处理
		return sellerAppService.addMerchantMembMage(po);
	}
	/**
	 * 删除会员管理信息(商户APP)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月3日
	 * @version 1.0
	 */
	@ApiOperation(value = " 删除会员管理信息(商户APP)",notes = " 删除会员管理信息(商户APP)")
	@PostMapping(value = "memb/mageDel")
	@DataCheck
	public ResultPoJo<String> del(@RequestBody LongIdPo po){
		// 删除处理
		return sellerAppService.del(po);
	}
}
