package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.memb.*;
import com.wisea.cultivar.common.vo.memb.MembForManagerListVo;
import com.wisea.cultivar.common.vo.memb.MembForServiceExcelVo;
import com.wisea.cultivar.common.vo.memb.MembForServiceListVo;
import com.wisea.cultivar.common.vo.memb.MembInfoExportListExcelVo;
import com.wisea.cultivar.infomanage.service.MembSupplierManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 会员/服务商管理相关接口
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@Api(tags = "会员/服务商管理相关接口")
@RestController
@RequestMapping("/w/admin/supplier")
@PreAuthorize("hasAnyAuthority('im:mmg','im:sup')")
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
	@ApiOperation(value = "分页查询会员管理列表",notes = "分页查询会员管理列表")
	@PostMapping(value = "/findMembPage")
	@DataCheck
	public ResultPoJo<Page<MembForManagerListVo>> findMembManagerList(@RequestBody MembForSellerPageListPo po){
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
	@ApiOperation(nickname="导出会员管理列表", value = "导出会员管理列表")
	@PostMapping(value = "/memb/export")
	@DataCheck
	public void membSellerInfoListExport(@RequestBody MembSellerExportPo po, HttpServletResponse response){
		//  返回参数
		try {
            String fileName = "会员管理"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
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
	@ApiOperation(value = "分页查询服务商认证管理列表",notes = "分页查询服务商认证管理列表")
	@PostMapping(value = "/findAuthPage")
	@DataCheck
	public ResultPoJo<Page<MembForServiceListVo>> findSupplierAuthList(@RequestBody MembForMangerPageListPo po){
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
	@ApiOperation(nickname="导出服务商认证管理列表", value = "导出服务商认证管理列表")
	@PostMapping(value = "/membAuth/export")
	@DataCheck
	public void membSellerAuthInfoListExport(@RequestBody MembSellerAuthExportPo po, HttpServletResponse response){
		//  返回参数
		try {
            String fileName = "服务商认证管理列表数据"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
    		new ExportExcel("服务商认证管理列表数据", MembForServiceExcelVo.class).setDataList(membSupplierManagerService.membSellerAuthInfoListExport(po)).writeWithAjaxHeader(response, fileName).dispose();
		} catch (Exception e) {
			throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
		}
	}

	/*
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
}
