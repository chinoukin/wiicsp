package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.JszlCatgMage;
import com.wisea.cultivar.common.po.tp.portal.JszlCatgMageChcekNamePo;
import com.wisea.cultivar.common.po.tp.portal.JszlCatgMageListPo;
import com.wisea.cultivar.common.vo.tp.portal.JszlCatgMageInfoVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * jszl_catg_mage 表DAO
 * 技术资料分类管理
 * 2019/08/29 17:45:19
 */
public interface JszlCatgMageMapper extends CrudDao<JszlCatgMage> {

	/**
	 * 查询技术资料分类列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月29日
	 * @version 1.0
	 */
	public List<JszlCatgMageInfoVo> findList(JszlCatgMageListPo po);
	/**
	 * 验证分类名称不能重复的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月29日
	 * @version 1.0
	 */
	public int checkCatgNameExist(JszlCatgMageChcekNamePo po);
}
