package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.AdverMage;
import com.wisea.cultivar.common.po.tp.portal.AdverMageListPo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.portal.AdverMageGetVo;
import com.wisea.cultivar.common.vo.tp.portal.AdverMageListVo;

/**
 * adver_mage 表DAO
 * 广告管理
 * 2019/05/28 16:20:20
 */

public interface AdverMageMapper extends CrudDao<AdverMage> {

	/**
	 * 查询广告列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年6月1日
	 * @version 1.0
	 */
	public List<AdverMageListVo> findList(AdverMageListPo po );

	/**
	 * 查询详细信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年6月1日
	 * @version 1.0
	 */
	public AdverMageGetVo getDetail(Long id);
}
