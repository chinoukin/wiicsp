package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.LtaContFile;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

public interface LtaContFileMapper extends CrudDao<LtaContFile> {

	/**
	 * 根据合同ID删除合同附件信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月8日
	 * @version 1.0
	 */
	public void delLtaContFileByContId(Long contId);
}
