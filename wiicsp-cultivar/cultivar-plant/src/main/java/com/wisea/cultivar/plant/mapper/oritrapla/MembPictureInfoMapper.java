package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.MembPictureInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MembPictureInfoMapper extends CrudDao<MembPictureInfo> {

	/**
	 * 根据会员id删除会员图片信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	public int delPicInfoByMembId(Long membId);
	/**
	 * 批量插入图片信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 * @return
	 */
	public int batchInsert(List<MembPictureInfo> list);

	/**
	 * 根据会员id查询会员图片
	 * @param membId
	 * @return
	 */
	public List<MembPictureInfo> findByMembId(Long membId);
}
