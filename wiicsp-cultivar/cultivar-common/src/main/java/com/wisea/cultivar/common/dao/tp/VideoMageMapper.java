package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.VideoMage;
import com.wisea.cultivar.common.po.tp.NotNeedIdsPo;
import com.wisea.cultivar.common.po.tp.portal.VideoMagePagePo;
import com.wisea.cultivar.common.vo.tp.portal.VideoMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * video_mage 表DAO
 * 视频中心列表管理
 * 2019/08/29 17:45:19
 */
public interface VideoMageMapper extends CrudDao<VideoMage> {

	/**
	 * 分页查询视频中心列表信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月30日
	 * @version 1.0
	 */
	public List<VideoMageListVo> findPage(VideoMagePagePo po);
	/**
	 * 批量删除视频中心信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月30日
	 * @version 1.0
	 */
	public void batDelete(List<Long> list);
	/**
	 * 五彩布衣-推荐视频
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月2日
	 * @version 1.0
	 */
	public List<VideoMageListVo> wcbyXcList(NotNeedIdsPo po);
}
