package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.PersonAuth;
import com.wisea.cultivar.common.entity.tp.PersonAuthCopy;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

public interface PersonAuthCopyMapper extends CrudDao<PersonAuthCopy> {

	/**
	 * 更新历史表中的信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年4月19日
	 * @version 1.0
	 */
	public void updateByPersonAuth(PersonAuth personAuth);
	/**
	 * 逻辑删除历史信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年4月19日
	 * @version 1.0
	 */
	public void deleteLogicByPersonAuth(PersonAuth personAuth);

	/**
	 * 逻辑删除历史表中的数据 后台审核删除
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年7月12日
	 * @version 1.0
	 */
	public void deleteLogicByPersonAuthForAdmin(PersonAuth personAuth);
}
