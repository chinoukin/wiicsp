package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.SubAcctInfo;
import com.wisea.cultivar.common.po.tp.SubAcctInfoListPo;
import com.wisea.cultivar.common.po.tp.memb.SubAcctInfoPagePo;
import com.wisea.cultivar.common.vo.tp.SubAcctInfoListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * sub_acct_info 表DAO
 * 子账号信息
 * 2018/10/11 10:36:38
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface SubAcctInfoMapper extends CrudDao<SubAcctInfo> {
	/**
	 * 分页查询子账户列表信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年4月17日
	 * @version 1.0
	 */
    List<SubAcctInfoListVo> findPage(SubAcctInfoPagePo subAcctInfoPagePo);

    List<SubAcctInfoListVo> findList(SubAcctInfoListPo subAcctInfoListPo);
    /**
     * 根据会员id查询启动状态的子用户Id列表
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月15日
     * @version 1.0
     */
    public List<String> selEnableFlagList(Long MembId);

    /**
     * 验证子账户最多位20个
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月30日
     * @version 1.0
     */
    public int checkSubAccCount(Long membId);
}
