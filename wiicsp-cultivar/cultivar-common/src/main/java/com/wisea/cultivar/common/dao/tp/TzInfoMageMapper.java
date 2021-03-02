package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.TzInfoMage;
import com.wisea.cultivar.common.po.tp.portal.JszlTzListPo;
import com.wisea.cultivar.common.po.tp.portal.TzInfoMagePagePo;
import com.wisea.cultivar.common.vo.tp.portal.TzInfoMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * tz_info_mage 表DAO
 * 通知信息管理
 * 2019/08/29 17:45:19
 */
public interface TzInfoMageMapper extends CrudDao<TzInfoMage> {

	/**
	 * 分页查询通知信息管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月30日
	 * @version 1.0
	 */
	public List<TzInfoMageListVo> findPage(TzInfoMagePagePo po);
	/**
	 * 批量删除资料信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月30日
	 * @version 1.0
	 */
	public void batchDeleteLogic(List<Long> list);
	/**
	 * 通知列表 - 技术学堂
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月2日
	 * @version 1.0
	 */
	public List<TzInfoMageListVo> jsxtTzList(JszlTzListPo po);
}
