package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.AdverSpaceMage;
import com.wisea.cultivar.common.po.tp.portal.AdverSpaceMageCheckNamePo;
import com.wisea.cultivar.common.po.tp.portal.AdverSpaceMagePagePo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.portal.AdverSpaceMageListVo;

/**
 * adver_space_mage 表DAO
 * 广告位管理
 * 2019/05/28 16:20:20
 */
public interface AdverSpaceMageMapper extends CrudDao<AdverSpaceMage> {

	/**
	 * 分页查询
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月31日
	 * @version 1.0
	 */
	public List<AdverSpaceMageListVo> findPage(AdverSpaceMagePagePo po);
	/**
	 * 验证广告位名称不能重复
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月31日
	 * @version 1.0
	 */
	public int checkAdverName(AdverSpaceMageCheckNamePo po);
	/**
	 * 通過广告位置名称查询广告位置信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年6月1日
	 * @version 1.0
	 */
	public AdverSpaceMage getInfoByAdverSpaceName(String adverSpaceMage);
}
