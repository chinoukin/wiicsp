package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.ShopCommMage;
import com.wisea.cultivar.common.po.tp.memb.ShopCommMageTreeListPo;
import com.wisea.cultivar.common.vo.tp.memb.ShopCommMageTreeVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * shop_comm_mage 表DAO
 * 店内商品管理
 * 2019/12/12 09:12:09
 */
public interface ShopCommMageMapper extends CrudDao<ShopCommMage> {

	/**
	 * 查询属性接口的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月13日
	 * @version 1.0
	 */
	public List<ShopCommMageTreeVo> findList(ShopCommMageTreeListPo po);
	/**
	 * 通过Id获取首页分类详细信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月13日
	 * @version 1.0
	 */
	public ShopCommMageTreeVo getShopCommMageById(Long id);
	/**
	 * 根据父ID查询下面的子类ID列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月24日
	 * @version 1.0
	 */
	public List<Long> findChildList(Long pid);
	/**
	 * 删除某个节点以及下面的子节点
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月10日
	 * @version 1.0
	 */
	public void deleteLogicForSelOrTree(ShopCommMage po);
}
