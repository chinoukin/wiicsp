package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.JszlListMage;
import com.wisea.cultivar.common.po.tp.portal.JszlHotListPo;
import com.wisea.cultivar.common.po.tp.portal.JszlListGetDetailPo;
import com.wisea.cultivar.common.po.tp.portal.JszlListMagePageListPo;
import com.wisea.cultivar.common.po.tp.portal.JszlListPo;
import com.wisea.cultivar.common.po.tp.portal.JszlTjListPo;
import com.wisea.cultivar.common.vo.tp.portal.JszlListMageDetailVo;
import com.wisea.cultivar.common.vo.tp.portal.JszlListMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * jszl_list_mage 表DAO
 * 技术资料列表管理
 * 2019/08/29 17:45:19
 */
public interface JszlListMageMapper extends CrudDao<JszlListMage> {

	/**
	 * 分页查询技术资料列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月30日
	 * @version 1.0
	 */
	public List<JszlListMageListVo> findPage(JszlListMagePageListPo po);

	/**
	 * 根据Id批量删除技术资料信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月30日
	 * @version 1.0
	 */
	public void batchDeleteLogic(List<Long> list);
	/**
	 * 热门资料列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月2日
	 * @version 1.0
	 */
	public List<JszlListMageListVo> hotList(JszlHotListPo po);
	/**
	 * 技术学堂-资料推荐补全信息列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月2日
	 * @version 1.0
	 */
	public List<JszlListMageListVo> findListForZltj(JszlTjListPo po);
	/**
	 * 资料列表-更新点击量
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月2日
	 * @version 1.0
	 */
	public void updJszlDjl(Long id);
	/**
	 * 技术学堂-资料列表详细信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月2日
	 * @version 1.0
	 */
	public JszlListMageDetailVo getDetail(JszlListGetDetailPo po);
	/**
	 * 技术学堂-资料列表详细信息上一页下一页
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月2日
	 * @version 1.0
	 */
	public List<JszlListMageDetailVo> getDetailPreAndNext(JszlListGetDetailPo po);
	/**
	 * 查询技术资料列表（技术资料详情中列表）
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月4日
	 * @version 1.0
	 */
	public List<JszlListMageListVo> findListForDetail(JszlListPo po);
}
