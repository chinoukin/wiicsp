package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.OpinRetroaMage;
import com.wisea.cultivar.plant.po.oritrapla.ExportPo;
import com.wisea.cultivar.plant.vo.oritrapla.WebOpinRetroaMageVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OpinRetroaMageMapper extends CrudDao<OpinRetroaMage> {

	/**
	 * 查询意见反馈列表信息
	 *
	 * @param po
	 * @return
	 */
	List<WebOpinRetroaMageVo> findOpinRetroaMageListPage(ExportPo po);

	/**
	 * 根据id查询意见反馈信息数据
	 *
	 * @param id
	 * @return
	 */
	WebOpinRetroaMageVo fingOpinRetroaInfoById(Long id);

}
