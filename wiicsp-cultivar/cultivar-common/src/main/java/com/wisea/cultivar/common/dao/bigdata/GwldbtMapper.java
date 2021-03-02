package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.Gwldbt;
import com.wisea.cultivar.common.po.bigdata.GwldbtListPo;
import com.wisea.cultivar.common.po.bigdata.GwldbtPagePo;
import com.wisea.cultivar.common.vo.bigdata.GwldbtListVo;

import java.util.List;

/**
 * gwldbt 表DAO
 * 各物流对比图
 * 2019/12/02 11:02:14
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface GwldbtMapper extends CrudDao<Gwldbt> {
    List<GwldbtListVo> findPage(GwldbtPagePo gwldbtPagePo);

    List<GwldbtListVo> findList(GwldbtListPo gwldbtListPo);
}
