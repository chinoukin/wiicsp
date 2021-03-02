package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.YjMage;
import com.wisea.cultivar.plant.po.oritrapla.YjMagePadinfoPo;

/**
 * yj_mage 表DAO
 * 预警设置
 * 2019/08/23 10:49:05
 */
public interface YjMageMapper extends CrudDao<YjMage> {
	/**
	 * 通过档案id查询预警设置信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月23日
	 * @version 1.0
	 */
	public YjMage getInfoByArchId(Long archId);
	/**
	 * 通过病虫害预警信息查询发送系统信息需要的内容
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月23日
	 * @version 1.0
	 */
	public YjMagePadinfoPo getSendMsgInfoForYjmage(Long padYjId);
}
