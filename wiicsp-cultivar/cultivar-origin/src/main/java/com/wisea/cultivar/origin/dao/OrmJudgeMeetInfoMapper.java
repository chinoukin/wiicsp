package com.wisea.cultivar.origin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.origin.entity.JudgeMeetInfo;
import com.wisea.cultivar.origin.po.CheckJudgeMeetNamePo;
import com.wisea.cultivar.origin.po.JudgeMeetChoiceListPo;
import com.wisea.cultivar.origin.po.JudgeMeetListPo;
import com.wisea.cultivar.origin.po.JudgeMeetListWebPo;
import com.wisea.cultivar.origin.vo.JudgeMeetInfoVo;
import com.wisea.cultivar.origin.vo.JudgeMeetListVo;
import com.wisea.cultivar.origin.vo.JudgeMeetListWebVo;

/**
 * 品鉴会Mapper
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月30日
 * @version 1.0
 */
@Mapper
@Repository
public interface OrmJudgeMeetInfoMapper  extends CrudDao<JudgeMeetInfo> {
	/** 分页查询品鉴会列表*/
	List<JudgeMeetListVo> findJudgeMeetList(JudgeMeetListPo po);
	/** 分页选择品鉴会列表*/
	List<JudgeMeetListVo> findChoiceList(JudgeMeetChoiceListPo po);
	/** 分页查询品鉴会管理列表web*/
	List<JudgeMeetListWebVo> findJudgeMeetListWeb(JudgeMeetListWebPo po);
	/** 校验品鉴会名称*/
	JudgeMeetInfo checkName(CheckJudgeMeetNamePo po);
	/** 查询品鉴会详情*/
	JudgeMeetInfoVo getFindJudgeMeetByid(Long id);

}
