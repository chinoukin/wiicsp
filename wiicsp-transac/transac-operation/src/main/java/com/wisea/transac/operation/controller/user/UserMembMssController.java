package com.wisea.transac.operation.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.po.LoginBatUpdatePo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.po.memb.AddRoleByUserIdPo;
import com.wisea.transac.common.po.memb.MembStaffInfoAddPo;
import com.wisea.transac.common.po.memb.MembStaffInfoUpdPo;
import com.wisea.transac.common.po.memb.RegisterUserMembPo;
import com.wisea.transac.common.po.memb.UpdUserMembInfoPo;
import com.wisea.transac.operation.service.user.UserMembMssService;

@RestController
public class UserMembMssController {


	@Autowired
	private UserMembMssService userMembMssService;

	/**
	 * 通过用户ID和角色Code添加用户角色权限
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月5日
	 * @version 1.0
	 */
	@PostMapping(value = { "/i/addRoleById" })
	@DataCheck
	public ResultPoJo<String> addRoleById(@RequestBody AddRoleByUserIdPo po){
        // 处理并且返回
        return userMembMssService.addRoleById(po);
    }
	/**
	 * 同时修改用户多个信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月11日
	 * @version 1.0
	 */
	@PostMapping(value = { "/i/updUserMembInfo" })
	@DataCheck
	public ResultPoJo<String> updUserMembInfo(@RequestBody UpdUserMembInfoPo po){
		// 处理并且返回
		return userMembMssService.updUserMembInfo(po);
	}
	/**
	 * 注册会员的接口
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月11日
	 * @version 1.0
	 */
	@PostMapping(value = { "/registerMemb" })
	@DataCheck
	public ResultPoJo<User> registerMemb(@RequestBody RegisterUserMembPo po){
		// 处理并且返回
		return userMembMssService.registerMemb(po);
	}
	/**
	 * 修改用户名和密码信息（无登录权限）
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月11日
	 * @version 1.0
	 */
	@PostMapping(value = { "/updUserInfo" })
	@DataCheck
	public ResultPoJo<String> updUserInfo(@RequestBody UpdUserMembInfoPo po){
		// 处理并且返回
		return userMembMssService.updUserInfo(po);
	}
	/**
	 * 添加会员的接口
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月11日
	 * @version 1.0
	 */
	@PostMapping(value = { "/i/addUserMemb" })
	@DataCheck
	public ResultPoJo<User> addUserMemb(@RequestBody RegisterUserMembPo po){
		// 处理并且返回
		return userMembMssService.addUserMemb(po);
	}
	/**
	 * 批量修改用户标识的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月12日
	 * @version 1.0
	 */
	@PostMapping(value = { "/i/membLoginBatUpdate" })
	@DataCheck
	public ResultPoJo<Object> membLoginBatUpdate(@RequestBody LoginBatUpdatePo po){
		// 处理并且返回
		return userMembMssService.membLoginBatUpdate(po);
	}
	/**
	 * 添加员工的处理(销售员工和采购员工)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月13日
	 * @version 1.0
	 */
	@PostMapping(value = { "/i/addUserMembStaff" })
	@DataCheck
	public ResultPoJo<MembInfo> addUserMembStaff(@RequestBody MembStaffInfoAddPo po){
		// 处理并且返回
		return userMembMssService.addUserMembStaff(po);
	}
	/**
	 * 修改员工的处理(销售员工和采购员工)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月13日
	 * @version 1.0
	 */
	@PostMapping(value = { "/i/updUserMembStaff" })
	@DataCheck
	public ResultPoJo<Object> updUserMembStaff(@RequestBody MembStaffInfoUpdPo po){
		// 处理并且返回
		return userMembMssService.updUserMembStaff(po);
	}
}
