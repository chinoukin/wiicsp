package com.wisea.cultivar.origin.dao;

import java.util.List;

import com.wisea.cultivar.origin.entity.MembEntpInfo;
import com.wisea.cultivar.origin.entity.MembInfo;
import com.wisea.cultivar.origin.po.MembListPo;
import com.wisea.cultivar.origin.vo.MembListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * 会员Mapper
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月30日
 * @version 1.0
 */
@Mapper
@Repository
public interface OrmMembInfoMapper  extends CrudDao<MembInfo> {

	/** 分页查询采样企业列表*/
	List<MembListVo> findMembInfoList(MembListPo po);
	/**
	 * 通过会员Id获取用户以及商户的信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年10月10日
	 * @version 1.0
	 */
	public MembEntpInfo getMembAndEntpByMembId(Long id);

}
