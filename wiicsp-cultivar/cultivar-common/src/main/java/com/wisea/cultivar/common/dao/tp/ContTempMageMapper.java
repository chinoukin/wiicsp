package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.ContTempMage;
import com.wisea.cultivar.common.vo.tp.lta.ContTempMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * cont_temp_mage 表DAO
 * 合同模板管理
 * 2019/05/23 15:28:19
 */
public interface ContTempMageMapper extends CrudDao<ContTempMage> {

	/**
	 *  查询合同模版列表
	 */
	public List<ContTempMageListVo> findList();

	/**
	 * 获取最新的合同模版信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月24日
	 * @version 1.0
	 */
	public ContTempMage getzxInfo();
}
