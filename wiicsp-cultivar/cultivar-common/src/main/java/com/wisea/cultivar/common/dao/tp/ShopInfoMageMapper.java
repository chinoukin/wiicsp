package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.ShopInfoMage;
import com.wisea.cultivar.common.po.tp.memb.ShopInfoListPo;
import com.wisea.cultivar.common.vo.tp.memb.ShopInfoMageForFloorListVo;
import com.wisea.cultivar.common.vo.tp.memb.ShopInfoMageGetVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * shop_info_mage 表DAO
 * 店铺基本设置
 * 2019/12/12 09:12:09
 */
public interface ShopInfoMageMapper extends CrudDao<ShopInfoMage> {

	/**
	 * 通过会员ID查询商铺信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月12日
	 * @version 1.0
	 */
	public ShopInfoMage getShopInfoMageByMembId(Long membId);
	/**
	 * 通过会员ID获取店铺信息无权限
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月12日
	 * @version 1.0
	 */
	public ShopInfoMageGetVo getInfoByMembIdForIndex(Long membId);
	/**
	 * 查询店铺信息列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年7月3日
	 * @version 1.0
	 */
	public List<ShopInfoMageForFloorListVo> findShopInfoList(ShopInfoListPo po);
}
