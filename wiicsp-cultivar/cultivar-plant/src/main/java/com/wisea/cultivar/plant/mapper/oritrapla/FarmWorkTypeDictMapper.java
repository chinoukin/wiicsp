package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.FarmWorkTypeDict;
import com.wisea.cultivar.plant.entity.oritrapla.FarmWorkTypeDictVo;
import com.wisea.cultivar.plant.po.oritrapla.FarmWorkTypeDictPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FarmWorkTypeDictMapper extends CrudDao<FarmWorkTypeDict> {

	/**
	 * 查询父类
	 * @return
	 */
	public List<FarmWorkTypeDict> selParentDic();

	/**
	 * 查询常用
	 * @return
	 */
	public List<FarmWorkTypeDict> selComUsedDic();

	/**
	 * 根据父类查询子类
	 * @return
	 */
	public List<FarmWorkTypeDict> selDicByParentId(Long parentId);

	/**
	 * 查询农事类型列表
	 * @param farmWorkTypeDictPo
	 * @return
	 */
	List<FarmWorkTypeDictVo> findListPage(FarmWorkTypeDictPo farmWorkTypeDictPo);

	int selectParentIdCount(Long id);

	/**
	 * 查询一级农事记录供下拉框使用
	 * @return
	 */
	List<FarmWorkTypeDict> findOnDegreeList();

	List<FarmWorkTypeDict> getTypeList();
}
