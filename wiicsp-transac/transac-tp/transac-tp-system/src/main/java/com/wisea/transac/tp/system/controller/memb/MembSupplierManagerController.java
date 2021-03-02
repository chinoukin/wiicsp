package com.wisea.transac.tp.system.controller.memb;

import javax.servlet.http.HttpServletResponse;

import com.wisea.transac.tp.system.service.memb.MembSupplierManagerService;
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
import com.wisea.transac.common.po.memb.MembForMangerPageListPo;
import com.wisea.transac.common.po.memb.MembForSellerPageListPo;
import com.wisea.transac.common.po.memb.MembSellerAuthExportPo;
import com.wisea.transac.common.po.memb.MembSellerExportPo;
import com.wisea.transac.common.po.memb.RpStateUpdPo;
import com.wisea.transac.common.vo.memb.MembEntpRpExportVo;
import com.wisea.transac.common.vo.memb.MembForManagerAuthInfoVo;
import com.wisea.transac.common.vo.memb.MembForSellerInfoVo;
import com.wisea.transac.common.vo.memb.MembInfoExportListExcelVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 同城交易供应商/产地交易供应商管理相关接口
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@Api(tags = "同城交易供应商/产地交易供应商管理相关接口")
@RestController
@RequestMapping("/w/admin/supplier")
public class MembSupplierManagerController {

	@Autowired
	private MembSupplierManagerService membSupplierManagerService;

	/**
	 * 分页查询供应商会员管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@ApiOperation(value = "分页查询供应商会员管理列表",notes = "分页查询供应商会员管理列表")
	@PostMapping(value = "/findMembPage")
	@DataCheck
	public ResultPoJo<MembForSellerInfoVo> findMembManagerList(@RequestBody MembForSellerPageListPo po){
		// 返回处理
		return membSupplierManagerService.findSupplierMmebList(po);
	}
	/**
	 * 导出供应商会员管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="导出供应商会员管理列表", value = "导出供应商会员管理列表")
	@PostMapping(value = "/memb/export")
	@DataCheck
	public void membSellerInfoListExport(@RequestBody MembSellerExportPo po,HttpServletResponse response){
		//  返回参数
		try {
            String fileName = "供应商会员管理列表数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
    		new ExportExcel("供应商会员管理列表数据", MembInfoExportListExcelVo.class).setDataList(membSupplierManagerService.membSellerInfoListExport(po)).writeWithAjaxHeader(response, fileName).dispose();
		} catch (Exception e) {
			throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
		}
	}
	/**
	 * 分页查询供应商认证管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@ApiOperation(value = "分页查询供应商认证管理列表",notes = "分页查询供应商认证管理列表")
	@PostMapping(value = "/findAuthPage")
	@DataCheck
	public ResultPoJo<MembForManagerAuthInfoVo> findSupplierAuthList(@RequestBody MembForMangerPageListPo po){
		// 返回处理
		return membSupplierManagerService.findSupplierAuthList(po);
	}
	/**
	 * 导出供应商认证管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="导出供应商认证管理列表", value = "导出供应商认证管理列表")
	@PostMapping(value = "/membAuth/export")
	@DataCheck
	public void membSellerAuthInfoListExport(@RequestBody MembSellerAuthExportPo po,HttpServletResponse response){
		//  返回参数
		try {
            String fileName = "供应商认证管理列表数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
    		new ExportExcel("供应商认证管理列表数据", MembInfoExportListExcelVo.class).setDataList(membSupplierManagerService.membSellerAuthInfoListExport(po)).writeWithAjaxHeader(response, fileName).dispose();
		} catch (Exception e) {
			throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
		}
	}
	/**
	 * 导出供应商报备信息列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="导出供应商报备信息列表", value = "导出供应商报备信息列表")
	@PostMapping(value = "/membRp/export")
	@DataCheck
	public void membAuthRpListExport(@RequestBody MembSellerAuthExportPo po,HttpServletResponse response){
		//  返回参数
		try {
            String fileName = "供应商报备列表数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
    		new ExportExcel("供应商报备列表数据", MembEntpRpExportVo.class).setDataList(membSupplierManagerService.membAuthRpListExport(po)).writeWithAjaxHeader(response, fileName).dispose();
		} catch (Exception e) {
			throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
		}
	}
	/**
	 * 认证审核操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月26日
	 * @version 1.0
	 */
	@ApiOperation(value = "认证审核操作",notes = "认证审核操作")
	@PostMapping(value = "/authEntp")
	@DataCheck
	public ResultPoJo<String> authEntpDataInfo(@RequestBody EntpDataInfoExamPo po){
		// 审核并且返回
		return membSupplierManagerService.authEntpDataInfo(po);
	}
	/**
	 * 企业报备的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	@ApiOperation(value = "企业报备的处理",notes = "企业报备的处理")
	@PostMapping(value = "/rpStateUpd")
	@DataCheck
	public ResultPoJo<String> rpStateUpd(@RequestBody RpStateUpdPo po){
		// 处理返回
		return membSupplierManagerService.rpStateUpd(po);
	}
}
