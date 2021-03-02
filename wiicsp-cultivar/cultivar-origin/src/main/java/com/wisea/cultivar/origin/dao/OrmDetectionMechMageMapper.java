package com.wisea.cultivar.origin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.origin.entity.DetectionMechMage;
import com.wisea.cultivar.origin.po.CheckOrgNumPo;
import com.wisea.cultivar.origin.po.DetectionMechMageListPo;
import com.wisea.cultivar.origin.po.DetectionMechMageListWebPo;
import com.wisea.cultivar.origin.vo.DetectionMechMageListVo;
import com.wisea.cultivar.origin.vo.DetectionMechMageListWebVo;
/**
 * 检测机构Mapper
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月30日
 * @version 1.0
 */
@Mapper
@Repository
public interface OrmDetectionMechMageMapper extends CrudDao<DetectionMechMage> {

	/** 分页查询检测机构列表*/
	List<DetectionMechMageListVo> findDetectionMechList(DetectionMechMageListPo po);
	/** 分页查询检测机构列表web*/
	List<DetectionMechMageListWebVo> findDetectionMechListWeb(DetectionMechMageListWebPo po);
	/** 校验机构编号*/
	List<DetectionMechMage> checkOrgNum(CheckOrgNumPo po);


}
