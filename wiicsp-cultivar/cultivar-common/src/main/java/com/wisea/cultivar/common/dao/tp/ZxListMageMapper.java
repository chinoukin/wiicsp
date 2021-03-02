package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.ZxListMage;
import com.wisea.cultivar.common.po.tp.NotNeedIdsPo;
import com.wisea.cultivar.common.po.tp.portal.ZxListMagePagePo;
import com.wisea.cultivar.common.po.tp.portal.ZxlListGetDetailPo;
import com.wisea.cultivar.common.vo.tp.portal.ZxListDetailForIndexVo;
import com.wisea.cultivar.common.vo.tp.portal.ZxListMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * zx_list_mage 表DAO
 * 资讯列表管理
 * 2019/08/29 17:45:19
 */
public interface ZxListMageMapper extends CrudDao<ZxListMage> {
    /**
     * 分页查询资讯列表信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年8月31日
     * @version 1.0
     */
	public List<ZxListMageListVo> findPage(ZxListMagePagePo po);
	/**
	 * 批量删除
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月31日
	 * @version 1.0
	 */
	public void batchDeleteLogic(List<Long> list);
	/**
	 * 五彩布衣-资讯推荐列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月2日
	 * @version 1.0
	 */
	public List<ZxListMageListVo> wcbyTjList(NotNeedIdsPo po);
	/**
     * 查询分页列表(去除已经存在的推荐信息)
     *
     * @author wangh(wisea)
     *
     * @date 2019年8月31日
     * @version 1.0
     */
	public List<ZxListMageListVo> findPageForTj(ZxListMagePagePo po);
	/**
	 * 五彩布衣-资讯详细信息查询
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月6日
	 * @version 1.0
	 */
	public ZxListDetailForIndexVo getDetail(ZxlListGetDetailPo po);
	/**
	 * 五彩布衣-资讯详细信息查询(上一篇下一篇)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月6日
	 * @version 1.0
	 */
	public List<ZxListDetailForIndexVo> getDetailPreAndNext(ZxlListGetDetailPo po);
}
