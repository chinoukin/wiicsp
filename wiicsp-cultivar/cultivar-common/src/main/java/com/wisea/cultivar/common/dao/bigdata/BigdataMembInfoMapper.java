package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.MembInfo;
import com.wisea.cultivar.common.po.bigdata.MembInfoListPo;
import com.wisea.cultivar.common.po.bigdata.MembInfoPagePo;
import com.wisea.cultivar.common.vo.bigdata.MembInfoListVo;

import java.util.List;

/**
 * memb_info 表DAO
 * 用户管理
 * 2019/12/02 11:02:14
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface BigdataMembInfoMapper extends CrudDao<MembInfo> {
    List<MembInfoListVo> findPage(MembInfoPagePo membInfoPagePo);

    List<MembInfoListVo> findList(MembInfoListPo membInfoListPo);

    List<MembInfoListVo> findAllByUsername(MembInfoListPo membInfoListPo);

    List<MembInfo> findAllEntity();
}
