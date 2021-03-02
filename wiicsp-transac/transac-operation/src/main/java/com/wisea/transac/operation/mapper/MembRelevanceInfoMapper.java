package com.wisea.transac.operation.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.operation.entity.MembReleBaseInfo;
import com.wisea.transac.operation.entity.MembRelevanceInfo;

/**
 * memb_relevance_info 表DAO
 * 2019/12/31 16:37:23
 */
public interface MembRelevanceInfoMapper extends CrudDao<MembRelevanceInfo> {

	/**
	 * 查询绑定信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月31日
	 * @version 1.0
	 */
	public MembRelevanceInfo getMembReleInfo(MembRelevanceInfo po);
	/**
     * 根据openid查询会员基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年11月12日
     * @version 1.0
     */
    public MembReleBaseInfo getMembReleInfoByOpenid(MembRelevanceInfo po);
    /**
     * 根据用户名称查询没有绑定的会员基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年11月13日
     * @version 1.0
     */
    public MembRelevanceInfo getMembByUserNameForWeChat(MembRelevanceInfo membRelevanceInfo);
    /**
     * 根据unionid查询关联ID
     *
     * @author wangh(wisea)
     *
     * @date 2020年8月20日
     * @version 1.0
     */
    public Long getMembInfoByUnionId(MembRelevanceInfo membRelevanceInfo);
    /**
     * 验证该手机号的用户已经绑定了其他的微信
     *
     * @author wangh(wisea)
     *
     * @date 2020年8月21日
     * @version 1.0
     */
    public MembRelevanceInfo checkMobileIfBd(MembRelevanceInfo po);
}
