package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.EntpDataInfo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * 企业历史信息
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月28日
 * @version 1.0
 */
public interface EntpDataInfoCopyMapper extends CrudDao<EntpDataInfo> {

	/**
     * 根据会员id查询商家资料信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月8日
     * @version 1.0
     */
    public EntpDataInfo getEnptInfoByMembId(Long membId);
    /**
     * 更新不审核部分的数据
     *
     * @author wangh(wisea)
     *
     * @date 2018年12月7日
     * @version 1.0
     */
    public void updatePartDateById(EntpDataInfo po);
    /**
     * 验证企业名称是否重复
     *
     * @author wangh(wisea)
     *
     * @date 2019年7月3日
     * @version 1.0
     */
    public int checkCompNameExist(EntpDataInfo po);
    /**
     * 逻辑删除历史表中的数据 后台审核删除的时候调用
     *
     * @author wangh(wisea)
     *
     * @date 2019年7月12日
     * @version 1.0
     */
    public int deleteLogicForAdmin(EntpDataInfo po);

}
