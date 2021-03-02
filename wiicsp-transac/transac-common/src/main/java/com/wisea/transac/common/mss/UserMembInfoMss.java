package com.wisea.transac.common.mss;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wisea.cloud.common.mss.RemoteSecurityMssConditional;
import com.wisea.cloud.common.po.LoginBatUpdatePo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.po.memb.AddRoleByUserIdPo;
import com.wisea.transac.common.po.memb.MembStaffInfoAddPo;
import com.wisea.transac.common.po.memb.MembStaffInfoUpdPo;
import com.wisea.transac.common.po.memb.RegisterUserMembPo;
import com.wisea.transac.common.po.memb.UpdUserMembInfoPo;

/**
 * 用户会员服务间调用的处理
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月11日
 * @version 1.0
 */
@Conditional(RemoteSecurityMssConditional.class)
@FeignClient(contextId = "WeChatLoginMss", name = "${wbfc.mss.security:WeChatLoginMss}", url = "${wbfc.mssurl.security:}")
public interface UserMembInfoMss {

    /**
     * 根据用户获取角色列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月5日
     * @version 1.0
     */
    @PostMapping(value = "/i/addRoleById")
    public ResultPoJo<String> addRoleById(@RequestBody AddRoleByUserIdPo po);

    /**
     * 同時修改用户的多个信息处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月11日
     * @version 1.0
     */
    @PostMapping(value = "/i/updUserMembInfo")
    public ResultPoJo<String> updUserMembInfo(@RequestBody UpdUserMembInfoPo po);

    /**
     * 注册会员的处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月11日
     * @version 1.0
     */
    @PostMapping(value = "/registerMemb")
    public ResultPoJo<User> registerMemb(@RequestBody RegisterUserMembPo po);

    /**
     * UpdUserMembInfoPo
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月11日
     * @version 1.0
     */
    @PostMapping(value = "/updUserInfo")
    public ResultPoJo<String> updUserInfo(@RequestBody UpdUserMembInfoPo po);

    /**
     * 添加会员的处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月11日
     * @version 1.0
     */
    @PostMapping(value = "/i/addUserMemb")
    public ResultPoJo<User> addUserMemb(@RequestBody RegisterUserMembPo po);

    /**
     * 批量修改用户登录标识
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月12日
     * @version 1.0
     */
    @PostMapping(value = "/i/membLoginBatUpdate")
    public ResultPoJo<Object> membLoginBatUpdate(@RequestBody LoginBatUpdatePo po);
    /**
     * 添加或者邀请员工的处理(销售员工和采购员工)
     *
     * @author wangh(wisea)
     *
     * @date 2020年8月13日
     * @version 1.0
     */
    @PostMapping(value = { "/i/addUserMembStaff" })
	public ResultPoJo<MembInfo> addUserMembStaff(@RequestBody MembStaffInfoAddPo po);
    /**
     * 修改员工的处理(销售员工和采购员工)
     *
     * @author wangh(wisea)
     *
     * @date 2020年8月13日
     * @version 1.0
     */
    @PostMapping(value = { "/i/updUserMembStaff" })
	public ResultPoJo<Object> updUserMembStaff(@RequestBody MembStaffInfoUpdPo po);
}
