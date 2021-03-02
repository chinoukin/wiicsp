package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.ZtSourceInfo;
import com.wisea.cultivar.common.po.bigdata.ZtSourceInfoListPo;
import com.wisea.cultivar.common.po.bigdata.ZtSourceInfoPagePo;
import com.wisea.cultivar.common.vo.bigdata.ZtSourceInfoListVo;

import java.util.List;

/**
 * zt_source_info 表DAO
 * 在途货源信息
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface ZtSourceInfoMapper extends CrudDao<ZtSourceInfo> {
    List<ZtSourceInfoListVo> findPage(ZtSourceInfoPagePo ztSourceInfoPagePo);

    List<ZtSourceInfoListVo> findList(ZtSourceInfoListPo ztSourceInfoListPo);
}
