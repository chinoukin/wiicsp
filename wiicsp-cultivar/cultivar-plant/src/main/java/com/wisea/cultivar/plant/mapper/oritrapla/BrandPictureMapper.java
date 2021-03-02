package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.BrandPicture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BrandPictureMapper extends CrudDao<BrandPicture> {
	/**
	 *
	 * 根据品牌id删除图片信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	public int delBrandPicByBrandId(Long brandId);
	/**
	 * 批量插入图片信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 * @return
	 */
	public int batchInsert(List<BrandPicture> list);
}
