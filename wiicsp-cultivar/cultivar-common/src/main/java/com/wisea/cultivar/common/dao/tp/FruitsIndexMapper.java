package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.tp.FruitsIndex;
import com.wisea.cultivar.common.po.tp.portal.FruitsIndexCheckPo;
import com.wisea.cultivar.common.po.tp.portal.FruitsIndexEchartsPo;
import com.wisea.cultivar.common.po.tp.portal.FruitsIndexForIndexPo;
import com.wisea.cultivar.common.po.tp.portal.FruitsIndexPageListPo;
import com.wisea.cultivar.common.vo.tp.portal.FruitsIndexDetailVo;
import com.wisea.cultivar.common.vo.tp.portal.FruitsIndexForIndexVo;
import com.wisea.cultivar.common.vo.tp.portal.FruitsIndexPageListVo;

/**
 * fruits_index 表DAO
 * 水果指数
 * 2019/05/28 16:20:20
 */
public interface FruitsIndexMapper extends CrudDao<FruitsIndex> {

	/**
	 * 后台分页查询水果指数列表信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月29日
	 * @version 1.0
	 */
	public List<FruitsIndexPageListVo> findPage(FruitsIndexPageListPo po);

	/**
	 * 验证同一天只能有一种水果出现
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月29日
	 * @version 1.0
	 */
	public List<FruitsIndex> checkFruits(List<FruitsIndexCheckPo> list);
	/**
	 *  批量插入水果指数信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月29日
	 * @version 1.0
	 */
	public void batchIns(List<FruitsIndex> list);
	/**
	 * 水果指数的批量处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月29日
	 * @version 1.0
	 */
	public void batchDelLogic(List<Long> list);
	/**
	 * 获取商品的数量
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月29日
	 * @version 1.0
	 */
	public List<String> getCommNames(FruitsIndexEchartsPo po);
	/**
	 * 图标需要查询的列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月29日
	 * @version 1.0
	 */
	public List<FruitsIndexDetailVo> findEchatsList(FruitsIndexEchartsPo po);
	/**
	 * 商品指数-价格指数分页列表(无权限)
	 * @param po
	 * @return
	 */
	public  List<FruitsIndexForIndexVo> forIndexFruitsIndex(FruitsIndexForIndexPo po);
}
