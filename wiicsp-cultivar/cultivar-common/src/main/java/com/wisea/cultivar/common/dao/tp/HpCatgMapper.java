package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.HpCatg;
import com.wisea.cultivar.common.po.tp.portal.HpCatgTreeListPo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.portal.HpCatgTreeVo;

/**
 * hp_catg 表DAO
 * 首页分类
 * 2019/05/28 16:20:20
 */
public interface HpCatgMapper extends CrudDao<HpCatg> {

	/**
	 * 查询首页分类列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月31日
	 * @version 1.0
	 */
	public List<HpCatgTreeVo> findList(HpCatgTreeListPo po);
	/**
	 * 通过Id获取首页分类详细信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月31日
	 * @version 1.0
	 */
	public HpCatgTreeVo getHpCatgInfoById(Long id);
}
