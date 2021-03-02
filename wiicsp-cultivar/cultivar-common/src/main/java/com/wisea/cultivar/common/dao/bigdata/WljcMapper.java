package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.Wljc;
import com.wisea.cultivar.common.po.bigdata.WljcListPo;
import com.wisea.cultivar.common.po.bigdata.WljcPagePo;
import com.wisea.cultivar.common.vo.bigdata.WljcListVo;

import java.util.List;

/**
 * wljc 表DAO
 * 物流监测
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface WljcMapper extends CrudDao<Wljc> {
    List<WljcListVo> findPage(WljcPagePo wljcPagePo);

    List<WljcListVo> findList(WljcListPo wljcListPo);
}
