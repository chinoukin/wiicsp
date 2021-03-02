package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.FarmWorkRecd;
import com.wisea.cultivar.plant.po.oritrapla.FarmWorkSelPo;
import com.wisea.cultivar.plant.vo.oritrapla.FarmWorkRecdVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Mapper
@Repository
public interface FarmWorkRecdMapper extends CrudDao<FarmWorkRecd> {

	/**
	 * 根据档案查询农事记录
	 * @param archId
	 * @return
	 */
	public List<FarmWorkRecdVo> findListByArchId(FarmWorkSelPo po);

	/**
	 * 查询记录详情
	 * @param archId
	 * @return
	 */
	public FarmWorkRecdVo findRecdInfo(Long id);

	/**
	 * 逻辑删除记录详情
	 * @param archId
	 * @return
	 */
	public void delById(Long id);

	/**
	 * 定时任务刷新今日代办为未完成
	 * @param archId
	 * @return
	 */
	public void updRecordToNot(@Param("minDate") OffsetDateTime minDate);

	/**
	 * 定时任务刷新待执行为今日代办
	 * @param archId
	 * @return
	 */
	public void updRecordToNext(@Param("minDate") OffsetDateTime minDate, @Param("maxDate") OffsetDateTime maxDate);
}
