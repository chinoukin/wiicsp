package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.ZxTjMage;
import com.wisea.cultivar.common.vo.tp.portal.ZxTjMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * zx_tj_mage 表DAO
 * 资讯推荐
 * 2019/08/29 17:45:19
 */
public interface ZxTjMageMapper extends CrudDao<ZxTjMage> {

	/**
	 * 查询资讯推荐列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月31日
	 * @version 1.0
	 */
	public List<ZxTjMageListVo> findList();
	/**
	 * 查询显示顺序是否已经存在
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月31日
	 * @version 1.0
	 */
	public ZxTjMage checkSortExist(Integer sort);
	/**
	 * 查询资讯列表是否已经存在推荐
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月31日
	 * @version 1.0
	 */
	public ZxTjMage selectTjByZxListId(Long zxListId);
}
