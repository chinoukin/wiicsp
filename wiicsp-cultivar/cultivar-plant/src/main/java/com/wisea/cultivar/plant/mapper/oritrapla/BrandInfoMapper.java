package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.BrandInfo;
import com.wisea.cultivar.plant.vo.oritrapla.BrandInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BrandInfoMapper extends CrudDao<BrandInfo> {

	/**
	 * 根据会员id查询品牌信息
	 *
	 * @param membId
	 * @return
	 */
	public List<BrandInfoVo> findBrandList(Long membId);
}
