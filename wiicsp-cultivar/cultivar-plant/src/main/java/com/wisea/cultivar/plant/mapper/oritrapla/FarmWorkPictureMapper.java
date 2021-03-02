package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.FarmWorkPicture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FarmWorkPictureMapper extends CrudDao<FarmWorkPicture> {

	/**
	 * 根据农事记录id删除图片
	 *
	 * @param farmWorkRecdId
	 */
	public void delByFormId(Long id);

	/**
	 * 逻辑删除记录照片
	 * @param archId
	 * @return
	 */
	public void delByFarmIdUpd(Long id);
}
