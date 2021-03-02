package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.JszlTjMage;
import com.wisea.cultivar.common.po.tp.portal.JszlTjListPo;
import com.wisea.cultivar.common.vo.tp.portal.JszlListMageListVo;
import com.wisea.cultivar.common.vo.tp.portal.JszlTjMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * jszl_tj_mage 表DAO
 * 资料推荐
 * 2019/08/29 17:45:19
 */
public interface JszlTjMageMapper extends CrudDao<JszlTjMage> {

	/**
	 * 查询资料推荐列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月30日
	 * @version 1.0
	 */
	public List<JszlTjMageListVo> findList();
	/**
	 * 通过资料列表ID查询推荐资料ID
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月30日
	 * @version 1.0
	 */
	public JszlTjMage selectTjByJszlListId(Long jszlListId);
	/**
	 * 查询顺序编码是否存在
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月30日
	 * @version 1.0
	 */
	public JszlTjMage selectTjBySort(int sort);
	/**
	 * 技术学堂-资料推荐列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月2日
	 * @version 1.0
	 */
	public List<JszlListMageListVo> jsxtZltjList(JszlTjListPo po);
}
