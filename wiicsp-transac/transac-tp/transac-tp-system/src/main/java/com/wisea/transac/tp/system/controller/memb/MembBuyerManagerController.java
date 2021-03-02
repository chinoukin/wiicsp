package com.wisea.transac.tp.system.controller.memb;

import javax.servlet.http.HttpServletResponse;

import com.wisea.transac.tp.system.service.memb.MembBuyerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.transac.common.po.memb.EntpDataInfoExamPo;
import com.wisea.transac.common.po.memb.MembBuyerAuthExportPo;
import com.wisea.transac.common.po.memb.MembBuyerExportPo;
import com.wisea.transac.common.po.memb.MembForBuyerAuthPageListPo;
import com.wisea.transac.common.po.memb.MembForBuyerPageListPo;
import com.wisea.transac.common.vo.memb.MembForBuyerAuthInfoVo;
import com.wisea.transac.common.vo.memb.MembForManagerInfoVo;
import com.wisea.transac.common.vo.memb.MembInfoExportListExcelVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 采购商管理相关接口
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月26日
 * @version 1.0
 */
@Api(tags = "采购商管理相关接口")
@RestController
@RequestMapping("/w/admin/buyer/")
public class MembBuyerManagerController {

	@Autowired
	private MembBuyerManagerService membBuyerManagerService;


	/**
	 * 采购商管理- 采购商会员管理查询处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月29日
	 * @version 1.0
	 */
	@ApiOperation(value = "分页查询采购商管理列表",notes = "分页查询采购商管理列表")
	@PostMapping(value = "/findMembPage")
	@DataCheck
	public ResultPoJo<MembForManagerInfoVo> findBuyerMembList(@RequestBody MembForBuyerPageListPo po){
		// 处理并且返回
		return membBuyerManagerService.findBuyerMembList(po);
	}
	/**
	 * 导出采购商会员管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="导出采购商会员管理列表", value = "导出采购商会员管理列表")
	@PostMapping(value = "/memb/export")
	@DataCheck
	public void membBuyerInfoListExport(@RequestBody MembBuyerExportPo po,HttpServletResponse response){
		//  返回参数
		try {
            String fileName = "采购商会员管理列表数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
    		new ExportExcel("采购商会员管理列表数据", MembInfoExportListExcelVo.class).setDataList(membBuyerManagerService.membBuyerInfoListExport(po)).writeWithAjaxHeader(response, fileName).dispose();
		} catch (Exception e) {
			throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
		}
	}
	/**
	 * 分页查询采购商认证管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@ApiOperation(value = "分页查询采购商认证管理列表",notes = "分页查询采购商认证管理列表")
	@PostMapping(value = "/findAuthPage")
	@DataCheck
	public ResultPoJo<MembForBuyerAuthInfoVo> findSupplierAuthList(@RequestBody MembForBuyerAuthPageListPo po){
		// 返回处理
		return membBuyerManagerService.findBuyerAuthList(po);
	}
	/**
	 * 导出采购商认证管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="导出采购商认证管理列表", value = "导出采购商会员管理列表")
	@PostMapping(value = "/membAuth/export")
	@DataCheck
	public void membBuyerAuthInfoListExport(@RequestBody MembBuyerAuthExportPo po,HttpServletResponse response){
		//  返回参数
		try {
            String fileName = "采购商认证管理列表数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
    		new ExportExcel("采购商认证管理列表数据", MembInfoExportListExcelVo.class).setDataList(membBuyerManagerService.membBuyerAuthInfoListExport(po)).writeWithAjaxHeader(response, fileName).dispose();
		} catch (Exception e) {
			throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
		}
	}
	/**
	 * 采购商认证审核操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月26日
	 * @version 1.0
	 */
	@ApiOperation(value = "采购商认证审核操作",notes = "采购商认证审核操作")
	@PostMapping(value = "/sellerMembAuth")
	@DataCheck
	public ResultPoJo<String> sellerMembAuth(@RequestBody EntpDataInfoExamPo po){
		// 操作处理
		return membBuyerManagerService.sellerMembAuth(po);
	}
}
