package com.wisea.transac.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.sys.entity.Role;
import com.wisea.transac.common.po.memb.RoleExtendsCheckPo;
import com.wisea.transac.common.po.memb.RoleExtendsPagePo;
import com.wisea.transac.common.po.memb.RoleNameCheckPo;
import com.wisea.transac.common.vo.memb.RoleExtendsListVo;

/**
 * 角色扩展Dao
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月30日
 * @version 1.0
 */
@Mapper
@Repository
public interface RoleExtendsMapper {

	/**
	 * 根据名称和创建人ID查询是否名称已经存在
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	public int checkRoleName(RoleNameCheckPo roleNameCheckPo);
	/**
	 * 根据角色ID查询用户信息列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	public List<String> findByRoleId(Long roleId);
	/**
	 * 分页查询角色列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	public List<RoleExtendsListVo> findRolePage(RoleExtendsPagePo po);
	/**
	 * 查询某个市场或者平台的全部列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月18日
	 * @version 1.0
	 */
	public List<RoleExtendsListVo> findAllRoleList(Long marketId);
	/**
     * 根据角色ID查询角色信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月6日
     * @version 1.0
     */
    public Role getRoleById(RoleExtendsCheckPo po);
    /**
     * 根据角色CODE查询角色信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月6日
     * @version 1.0
     */
    public Role getRoleByCode(String code);
}
