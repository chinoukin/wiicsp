package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.BulkTransactionActivity;
import com.wisea.cultivar.common.po.tp.portal.BulkTransactionActivityPageListPo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.portal.BulkTransactionActivityListVo;

/**
 * bulk_transaction_activity 表DAO
 * 大宗交易动态
 * 2019/05/28 16:20:20
 */

public interface BulkTransactionActivityMapper extends CrudDao<BulkTransactionActivity> {

	/**
	 * 分頁查询大宗列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月29日
	 * @version 1.0
	 */
	public List<BulkTransactionActivityListVo> findPage(BulkTransactionActivityPageListPo po);
	/**
	 * 批量删除大宗信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月29日
	 * @version 1.0
	 */
	public void batchDelLogic(List<Long> list);
	/**
	 *  首页的大宗交易信息列表的查询
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月29日
	 * @version 1.0
	 */
	public List<BulkTransactionActivityListVo> findListNotAuth();
}
