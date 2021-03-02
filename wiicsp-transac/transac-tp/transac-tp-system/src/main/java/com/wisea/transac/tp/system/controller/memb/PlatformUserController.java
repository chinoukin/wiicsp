package com.wisea.transac.tp.system.controller.memb;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.wisea.transac.tp.system.service.memb.MarketAcctService;
import com.wisea.transac.tp.system.service.memb.PlatformUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.StringKeyPo;
import com.wisea.transac.common.po.memb.MarketAdminExportPo;
import com.wisea.transac.common.po.memb.MarketAdminInfoPagePo;
import com.wisea.transac.common.po.memb.MarketAdminUpdPo;
import com.wisea.transac.common.po.memb.PlatFormUserExportPo;
import com.wisea.transac.common.po.memb.PlatFormUserInfoPo;
import com.wisea.transac.common.po.memb.PlatFormUserPagePo;
import com.wisea.transac.common.vo.memb.MaketInfoListVo;
import com.wisea.transac.common.vo.memb.MarketAdminInfoExportVo;
import com.wisea.transac.common.vo.memb.MarketAdminInfoVo;
import com.wisea.transac.common.vo.memb.PlatFormUserInfoExportVo;
import com.wisea.transac.common.vo.memb.PlatFormUserInfoVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 总运营平台用户管理相关接口Controller
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月30日
 * @version 1.0
 */
@Api(tags = "总运营平台用户管理相关接口")
@RestController
@RequestMapping("/w/platForm/")
public class PlatformUserController {

	@Autowired
	private PlatformUserService platformUserService;
	@Autowired
	private MarketAcctService marketAcctService;

	/**
	 * 分页查询市场管理员信息列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	@ApiOperation(value = "分页查询市场管理员信息列表",notes = "分页查询市场管理员信息列表")
	@PostMapping(value = "user/findMarketAdminList")
	@DataCheck
	public ResultPoJo<List<MarketAdminInfoVo>> findMarketAdminList(@RequestBody MarketAdminInfoPagePo po){
		// 操作并且返回
		return platformUserService.findMarketAdminList(po);
	}
	/**
	 * 导出市场管理员信息列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年10月14日
	 * @version 1.0
	 */
	@ApiOperation(nickname="导出市场管理员信息列表", value = "导出市场管理员信息列表")
	@PostMapping(value = "/user/marketAdmin/export")
	@DataCheck
	public void marketAdminListExport(@RequestBody MarketAdminExportPo po,HttpServletResponse response){
		//  返回参数
		try {
            String fileName = "市场管理员列表数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
    		new ExportExcel("市场管理员列表数据", MarketAdminInfoExportVo.class).setDataList(platformUserService.marketAdminListExport(po)).writeWithAjaxHeader(response, fileName).dispose();
		} catch (Exception e) {
			throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
		}
	}
	/**
	 * 根据ID查询市场管理员的基本信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	@ApiOperation(value = "根据ID查询市场管理员的基本信息",notes = "根据ID查询市场管理员的基本信息")
	@PostMapping(value = "user/getMarketAdminInfo")
	@DataCheck
	public ResultPoJo<MarketAdminInfoVo> getMarketAdminInfo(@RequestBody LongIdPo po){
		// 操作并且返回
		return platformUserService.getMarketAdminInfo(po);
	}

	/**
	 * 修改市场管理员信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	@ApiOperation(value = "修改市场管理员信息",notes = "修改市场管理员信息")
	@PostMapping(value = "user/updMarketAdmin")
	@DataCheck
	public ResultPoJo<String> updMarketAdmin(@RequestBody MarketAdminUpdPo po){
		// 操作并且返回
		return platformUserService.updMarketAdmin(po);
	}
	/**
	 * 分页查询运营平台、市场人员用户列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	@ApiOperation(value = "分页查询运营平台、市场人员用户列表",notes = "分页查询运营平台、市场人员用户列表")
	@PostMapping(value = "user/findPage")
	@DataCheck
	public ResultPoJo<List<PlatFormUserInfoVo>> findPage(@RequestBody PlatFormUserPagePo po){
		// 操作并且返回
		return platformUserService.findPageForPlat(po);
	}

	/**
	 * 导出运营平台、市场人员用户列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年10月14日
	 * @version 1.0
	 */
	@ApiOperation(nickname="导出运营平台、市场人员用户列表", value = "导出运营平台、市场人员用户列表")
	@PostMapping(value = "/user/export")
	@DataCheck
	public void userListExport(@RequestBody PlatFormUserExportPo po,HttpServletResponse response){
		//  返回参数
		try {
            String fileName = "用户列表数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
    		new ExportExcel("用户列表数据", PlatFormUserInfoExportVo.class).setDataList(platformUserService.userListExport(po)).writeWithAjaxHeader(response, fileName).dispose();
		} catch (Exception e) {
			throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
		}
	}
	/**
	 * 根据ID查询用户详细信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	@ApiOperation(value = "根据ID查询用户详细信息",notes = "根据ID查询用户详细信息")
	@PostMapping(value = "user/getById")
	@DataCheck
	public ResultPoJo<PlatFormUserInfoVo> getPlatFormUserInfo(@RequestBody LongIdPo po){
		// 操作并且返回
		return platformUserService.getPlatFormUserInfo(po);
	}
	/**
	 * 新增或者修改修改总运营平台、市场管理的用户信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	@ApiOperation(value = "新增或者修改修改总运营平台、市场管理的用户信息",notes = "新增或者修改修改总运营平台、市场管理的用户信息")
	@PostMapping(value = "/user/save")
	@DataCheck
	public ResultPoJo<String> saveMarketOrPlatFormUser(@RequestBody PlatFormUserInfoPo po){
		// 操作并且返回
		return platformUserService.saveMarketOrPlatFormUser(po);
	}
	/**
	 * 删除总运营、市场的用户信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	@ApiOperation(value = "删除总运营、市场的用户信息",notes = "删除总运营、市场的用户信息")
	@PostMapping(value = "/user/del")
	@DataCheck
	public ResultPoJo<String> del(@RequestBody LongIdPo po){
		// 操作并且返回
		return platformUserService.del(po);
	}
	/**
	 * 查询全部批发市场信息（可以根据市场名称模糊查询）
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月27日
	 * @version 1.0
	 */
	@ApiOperation(value = "查询全部批发市场信息（可以根据市场名称模糊查询）",notes = "查询全部批发市场信息（可以根据市场名称模糊查询）")
	@PostMapping(value = "/findMarketAllList")
	@DataCheck
	public ResultPoJo<List<MaketInfoListVo>> findMarketAllList(@RequestBody StringKeyPo po){
		// fanhui
		return marketAcctService.findMarketAllList(po.getKey());
	}
}
