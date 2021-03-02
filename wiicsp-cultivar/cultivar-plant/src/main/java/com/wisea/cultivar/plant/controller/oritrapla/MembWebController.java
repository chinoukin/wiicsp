package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.po.UpdatePasswordUserPo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.vo.oritrapla.ManUserVo;
import com.wisea.cultivar.plant.vo.oritrapla.MembBaseInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.MembDetailInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.MembListInfoVo;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.service.oritrapla.MembWebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 后台管理会员相关的接口
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月19日
 * @version 1.0
 */
@Api(value="【原产地通】后台管理会员相关的接口",tags="后台管理会员相关的接口",description="web端调用")

@RestController
@RequestMapping("/w/web/")
public class MembWebController {

	@Autowired
	private MembWebService membWebService;

	/**
	 * oritrapla_068_【后台会员】查询会员管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="查询会员管理列表", value = "oritrapla_068_【后台会员】查询会员管理列表",notes = "查询会员管理列表")
	@RequestMapping(value = "memb/list",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Page<MembListInfoVo>> list(@RequestBody WebMembListPo po){
		// 设置查询主用户
		po.setAcctType(DictConstants.ACCT_TYPE_0);
		// 返回参数
		return membWebService.list(po);
	}
	/**
	 * oritrapla_069_【后台会员】冻结会员的操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="冻结会员的操作", value = "oritrapla_069_【后台会员】冻结会员的操作",notes = "冻结会员的操作")
	@RequestMapping(value = "memb/freeze",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> freeze(@RequestBody LongIdPo po){
		// 设置传入的参数
		BatchMembLoginFlagPo batchPo = new BatchMembLoginFlagPo();
		batchPo.setAcctStatus(Constants.NO);//冻结状态
		List<String> list = new ArrayList<String>();
		list.add(ConverterUtil.toString(po.getId()));
		batchPo.setIdList(list);
		// 返回参数
		return membWebService.batchMembLoginFlag(batchPo);
	}
	/**
	 * oritrapla_070_【后台会员】解冻会员的操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="解冻会员的操作", value = "oritrapla_070_【后台会员】解冻会员的操作",notes = "解冻会员的操作")
	@RequestMapping(value = "memb/unfreeze",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> unfreeze(@RequestBody LongIdPo po){
		// 设置传入的参数
		BatchMembLoginFlagPo batchPo = new BatchMembLoginFlagPo();
		batchPo.setAcctStatus(Constants.YES);//解冻状态
		List<String> list = new ArrayList<String>();
		list.add(ConverterUtil.toString(po.getId()));
		batchPo.setIdList(list);
		// 返回参数
		return membWebService.batchMembLoginFlag(batchPo);
	}
	/**
	 * oritrapla_071_【后台会员】批量冻结会员的操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="批量冻结会员的操作", value = "oritrapla_071_【后台会员】批量冻结会员的操作",notes = "批量冻结会员的操作")
	@RequestMapping(value = "memb/batchFreeze",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> batchFreeze(@RequestBody StringIdsPo po){
		// 设置传入的参数
		BatchMembLoginFlagPo batchPo = new BatchMembLoginFlagPo();
		batchPo.setAcctStatus(Constants.NO);//冻结状态
		batchPo.setIdList(po.getIds());// 需要更新的id列表
		// 返回参数
		return membWebService.batchMembLoginFlag(batchPo);
	}
	/**
	 * oritrapla_072_【后台会员】批量解冻会员的操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="批量解冻会员的操作", value = "oritrapla_072_【后台会员】批量解冻会员的操作",notes = "批量解冻会员的操作")
	@RequestMapping(value = "memb/batchUnfreeze",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> batchUnfreeze(@RequestBody StringIdsPo po){
		// 设置传入的参数
		BatchMembLoginFlagPo batchPo = new BatchMembLoginFlagPo();
		batchPo.setAcctStatus(Constants.YES);//冻结状态
		batchPo.setIdList(po.getIds());// 需要更新的id列表
		// 返回参数
		return membWebService.batchMembLoginFlag(batchPo);
	}
	/**
	 * oritrapla_073_【后台会员】查询会员详细信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="查询会员详细信息", value = "oritrapla_073_【后台会员】查询会员详细信息",notes = "查询会员详细信息")
	@RequestMapping(value = "memb/getDetaiInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<MembDetailInfoVo> getDetaiInfo(@RequestBody LongIdPo po){
		// 返回参数
		return membWebService.getDetaiInfo(po);
	}
	/**
	 * oritrapla_074_【后台会员】查询会员基础信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="查询会员基础信息", value = "oritrapla_074_【后台会员】查询会员基础信息",notes = "查询会员基础信息")
	@RequestMapping(value = "memb/getBaseInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<MembBaseInfoVo> getBaseInfo(@RequestBody LongIdPo po){
		// 返回参数
		return membWebService.getBaseInfo(po);
	}
	/**
	 * oritrapla_075_【后台会员】保存会员基础信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="保存会员基础信息", value = "oritrapla_075_【后台会员】保存会员基础信息",notes = "保存会员基础信息")
	@RequestMapping(value = "memb/saveBaseInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveBaseInfo(@RequestBody UpdMembBaseInfoPo po){
		// 返回参数
		return membWebService.saveBaseInfo(po);
	}
	/**
	 * oritrapla_076_【后台会员】查询子账户列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月19日
	 * @version 1.0
	 */
	@ApiOperation(nickname="查询子账户列表", value = "oritrapla_076_【后台会员】查询子账户列表",notes = "查询子账户列表")
	@RequestMapping(value = "memb/subList",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Page<MembListInfoVo>> subList(@RequestBody SubWebMembListPo po){
		// 设置参数
		WebMembListPo webMembListPo = new WebMembListPo();
		ConverterUtil.copyProperties(po, webMembListPo);
		webMembListPo.setSubjectType(null);
		webMembListPo.setAcctType(DictConstants.ACCT_TYPE_1);//查询子账户信息
		// 返回参数
		return membWebService.list(webMembListPo);
	}

	/**
	 * oritrapla_078_【后台会员】查询后台管理账号列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月20日
	 * @version 1.0
	 */
	@ApiOperation(nickname="查询后台管理账号列表", value = "oritrapla_078_【后台会员】查询后台管理账号列表",notes = "查询后台管理账号列表")
	@RequestMapping(value = "memb/backManList",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Page<MembListInfoVo>> backManList(@RequestBody BackManMembListPo po){
		// 设置参数
		WebMembListPo webMembListPo = new WebMembListPo();
		ConverterUtil.copyProperties(po, webMembListPo);
		webMembListPo.setSubjectType(null);
		// 查询管理员信息
		webMembListPo.setAcctType(DictConstants.ACCT_TYPE_2);
        // 返回参数
		return membWebService.listBackMan(webMembListPo);
	}
	/**
	 * oritrapla_079_【后台会员】保存后台管理账号
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月20日
	 * @version 1.0
	 */
	@ApiOperation(nickname="保存后台管理账号", value = "oritrapla_079_【后台会员】保存后台管理账号",notes = "保存后台管理账号")
	@RequestMapping(value = "memb/saveManInfo",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveManInfo(@RequestBody ManUserPo po){
		// 返回参数
		return membWebService.saveManInfo(po);
	}
	/**
	 * oritrapla_080_【后台会员】查询后台管理员的基础信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月20日
	 * @version 1.0
	 */
	@ApiOperation(nickname="查询后台管理员的基础信息", value = "oritrapla_080_【后台会员】查询后台管理员的基础信息",notes = "查询后台管理员的基础信息")
	@RequestMapping(value = "memb/getManInfoById",method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<ManUserVo> getManInfoById(@RequestBody LongIdPo po){
		// 返回参数
		return membWebService.getManInfoById(po);
	}

    /**
     * oritrapla_081_【后台会员】_【用户】修改后台用户密码
     *
     * @param updatePasswordUserPo
     * @return
     */
    @ApiOperation(value = "oritrapla_081_【后台会员】_【用户】修改后台用户密码", notes = "修改后台用户密码")
    @RequestMapping(value = "manager/pwdUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> managerPwdUpdate(@RequestBody UpdatePasswordUserPo updatePasswordUserPo) {
        // 返回参数
        return membWebService.managerPwdUpdate(updatePasswordUserPo);
    }
}
