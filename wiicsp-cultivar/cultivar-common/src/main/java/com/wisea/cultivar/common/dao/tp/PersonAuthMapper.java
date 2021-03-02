package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.PersonAuth;
import com.wisea.cultivar.common.vo.tp.memb.MembPersonDetailVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

public interface PersonAuthMapper extends CrudDao<PersonAuth>{
	/**
	 * 获取审核通过的个人认证信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年4月17日
	 * @version 1.0
	 */
	public PersonAuth getAuthPassPersonInfoByMembId(Long membId);
	/**
	 * 通过会员ID查询最新的个人认证信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年4月17日
	 * @version 1.0
	 */
	public PersonAuth getZxPersonInfoByMembId(Long membId);
	/**
	 * 根据id获取个人认证信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年4月19日
	 * @version 1.0
	 */
	public MembPersonDetailVo getPersonInfoDetailById(Long id);
}
