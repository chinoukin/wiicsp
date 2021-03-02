package com.wisea.cultivar.origin.dao;

import java.util.List;

import com.wisea.cultivar.origin.entity.SampInfo;
import com.wisea.cultivar.origin.po.BatchDetecResultPo;
import com.wisea.cultivar.origin.po.LongIdPo;
import com.wisea.cultivar.origin.po.SampListPo;
import com.wisea.cultivar.origin.po.SampListWebPo;
import com.wisea.cultivar.origin.vo.SampInfoVo;
import com.wisea.cultivar.origin.vo.SampListVo;
import com.wisea.cultivar.origin.vo.SampListWebVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * 样品信息Mapper
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月30日
 * @version 1.0
 */
@Mapper
@Repository
public interface OrmSampInfoMapper  extends CrudDao<SampInfo> {

	/**分页查询检测样品列表*/
	List<SampListVo> findSampInfoList(SampListPo po);
	/** 查询样品信息详情*/
	SampInfoVo getFindSampInfoByid(LongIdPo po);
    /** 分页查询检测信息列表 web*/
	List<SampListWebVo> findSampInfoListWeb(SampListWebPo po);
	/**
	 * 查询未检测的数据
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月6日
	 * @version 1.0
	 */
	public List<String> getNotDetectedList();
	/**
	 * 批量修改样品状态为已检测
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月7日
	 * @version 1.0
	 */
	public void batchUpdSampStatus(List<BatchDetecResultPo> list);
	/** 根据样品编号查询数据*/
	SampInfo selectBySampNum(Long sampNum);

}
