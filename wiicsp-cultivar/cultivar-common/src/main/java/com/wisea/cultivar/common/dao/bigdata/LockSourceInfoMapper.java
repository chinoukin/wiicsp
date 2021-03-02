package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.LockSourceInfo;
import com.wisea.cultivar.common.po.bigdata.LockSourceInfoListPo;
import com.wisea.cultivar.common.po.bigdata.LockSourceInfoPagePo;
import com.wisea.cultivar.common.vo.bigdata.LockSourceInfoListVo;

import java.util.List;

/**
 * lock_source_info 表DAO
 * 锁定货源信息
 * 2019/12/02 11:02:14
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface LockSourceInfoMapper extends CrudDao<LockSourceInfo> {
    List<LockSourceInfoListVo> findPage(LockSourceInfoPagePo lockSourceInfoPagePo);

    List<LockSourceInfoListVo> findList(LockSourceInfoListPo lockSourceInfoListPo);
}
