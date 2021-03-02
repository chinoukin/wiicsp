package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.FruitsPrice;
import com.wisea.cultivar.common.po.tp.portal.FruitsPriceCompPo;
import com.wisea.cultivar.common.po.tp.portal.FruitsPriceInsPo;
import com.wisea.cultivar.common.po.tp.portal.FruitsPriceNotAuthPo;
import com.wisea.cultivar.common.po.tp.portal.FruitsPricePageListPo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.portal.FruitsPriceCompPageVo;
import com.wisea.cultivar.common.vo.tp.portal.FruitsPriceInfoVo;
import com.wisea.cultivar.common.vo.tp.portal.FruitsPricePortalVo;

/**
 * fruits_price 表DAO
 * 水果价格
 * 2019/05/28 16:20:20
 */
public interface FruitsPriceMapper extends CrudDao<FruitsPrice> {

	/**
	 * 后台查询水果列表信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月30日
	 * @version 1.0
	 */
	public List<FruitsPriceInfoVo> findPage(FruitsPricePageListPo po);
	/**
	 * 批量插入水果价格信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月30日
	 * @version 1.0
	 */
	public void batchFruitsPriceInsert(List<FruitsPrice> list);
	/**
	 * 批量删除水果价格信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月30日
	 * @version 1.0
	 */
	public void batchDelLogic(List<Long> list);
	/**
	 * 首页查询水果价格列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月30日
	 * @version 1.0
	 */
	public List<FruitsPricePortalVo> findNotAuthList(FruitsPriceNotAuthPo po);
	/**
	 * 查看分组信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月31日
	 * @version 1.0
	 */
	public List<Long> getCommPidList();
	/**
	 * 首页分页查询价格比较信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年6月12日
	 * @version 1.0
	 */
	public List<FruitsPriceCompPageVo> findPageForIndex(FruitsPriceCompPo po);
	/**
	 * 查询后一天的记录信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年6月12日
	 * @version 1.0
	 */
	public FruitsPrice getBackFruitsPrice(FruitsPriceInsPo po);
	/**
	 * 查询前一天的记录信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年6月12日
	 * @version 1.0
	 */
	public FruitsPrice getFrontFruitsPrice(FruitsPriceInsPo po);
	/**
	 * 验证每天每个地区只能有一种商品
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年7月1日
	 * @version 1.0
	 */
	public List<FruitsPrice> checkFruitsPrice(List<FruitsPriceInsPo> list);
}
