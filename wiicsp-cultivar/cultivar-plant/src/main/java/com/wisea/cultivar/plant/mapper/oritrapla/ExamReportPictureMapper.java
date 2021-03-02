package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.ExamReportPicture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExamReportPictureMapper extends CrudDao<ExamReportPicture> {

	/**
	 * 根据检测记录id删除图片
	 * @param examRecdId
	 */
	public void delByExamId(Long examRecdId);

	/**
	 * 根据检测记录id删除图片(逻辑删除)
	 * @param examRecdId
	 */
	public void delByExamIdFlag(Long examRecdId);

	/**
	 * 根据检测记录查询图片
	 * @param examRecdId
	 */
	public List<ExamReportPicture> selByExamId(Long examRecdId);
}
