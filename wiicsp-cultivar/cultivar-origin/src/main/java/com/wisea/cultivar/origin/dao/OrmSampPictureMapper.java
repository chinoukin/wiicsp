package com.wisea.cultivar.origin.dao;

import java.util.List;

import com.wisea.cultivar.origin.entity.SampPicture;
import com.wisea.cultivar.origin.vo.ImgListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * 样品信息图片Mapper
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月30日
 * @version 1.0
 */
@Mapper
@Repository
public interface OrmSampPictureMapper  extends CrudDao<SampPicture> {

	/** 批量添加图片*/
	void insertBatchSampPicture(List<SampPicture> sampPictureList);
	/** 批量删除现场图片根据样品id*/
	void delBatchSampPicture(SampPicture sampPict);
	/** 查询样品报告*/
	List<ImgListVo> getfingImgList(SampPicture sampPict);
	/**
	 * 批量删除样品检测结果的信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月20日
	 * @version 1.0
	 */
	public void batchDelPicByList(List<SampPicture> sampPictureList);

}
