package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.ByzIntrod;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * byz_introd 表DAO
 * 布依族介绍
 * 2019/08/29 17:45:19
 */
public interface ByzIntrodMapper extends CrudDao<ByzIntrod> {

	/**
	 * 获取最新的布依族介绍
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月5日
	 * @version 1.0
	 */
	public ByzIntrod getNewDetail();
}
