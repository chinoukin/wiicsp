package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.RkSourceInfo;
import com.wisea.cultivar.common.po.bigdata.RkSourceInfoListPo;
import com.wisea.cultivar.common.po.bigdata.RkSourceInfoPagePo;
import com.wisea.cultivar.common.vo.bigdata.RkSourceInfoListVo;

import java.util.List;

/**
 * rk_source_info 表DAO
 * 入库货源信息
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface RkSourceInfoMapper extends CrudDao<RkSourceInfo> {
    List<RkSourceInfoListVo> findPage(RkSourceInfoPagePo rkSourceInfoPagePo);

    List<RkSourceInfoListVo> findList(RkSourceInfoListPo rkSourceInfoListPo);
}
