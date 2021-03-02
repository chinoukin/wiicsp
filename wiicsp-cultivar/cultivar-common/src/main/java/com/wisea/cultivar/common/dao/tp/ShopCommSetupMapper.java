package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.ShopCommSetup;
import com.wisea.cultivar.common.po.tp.memb.ShopCommPageForIndexPo;
import com.wisea.cultivar.common.po.tp.memb.ShopCommSetupPagePo;
import com.wisea.cultivar.common.vo.tp.CommPubInfoGetVo;
import com.wisea.cultivar.common.vo.tp.memb.ShopCommSetupGetVo;
import com.wisea.cultivar.common.vo.tp.memb.ShopCommSetupListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * shop_comm_setup 表DAO
 * 店内商品设置
 * 2019/12/12 09:12:09
 */
public interface ShopCommSetupMapper extends CrudDao<ShopCommSetup> {

	/**
	 * 分页查询商品信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月13日
	 * @version 1.0
	 */
	public List<ShopCommSetupListVo> findPage(ShopCommSetupPagePo po);
	/**
	 * 查询详细信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月13日
	 * @version 1.0
	 */
	public ShopCommSetupGetVo getDetailById(Long id);
	/**
	 * 根据店铺商品分类分页查询店铺内商品信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月13日
	 * @version 1.0
	 */
	public List<CommPubInfoGetVo> findPageForIndex(ShopCommPageForIndexPo po);
	/**
	 * 查询店铺内所有的商品信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月13日
	 * @version 1.0
	 */
	public List<CommPubInfoGetVo> findAllPageForIndex(ShopCommPageForIndexPo po);
}
