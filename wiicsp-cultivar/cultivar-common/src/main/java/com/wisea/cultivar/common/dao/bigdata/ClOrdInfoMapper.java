package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.ClOrdInfo;
import com.wisea.cultivar.common.po.bigdata.ClOrdInfoListPo;
import com.wisea.cultivar.common.po.bigdata.ClOrdInfoPagePo;
import com.wisea.cultivar.common.vo.bigdata.ClOrdInfoListVo;

import java.util.List;

/**
 * cl_ord_info 表DAO
 * 处理订单详情
 * 2019/12/02 11:02:14
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface ClOrdInfoMapper extends CrudDao<ClOrdInfo> {
    List<ClOrdInfoListVo> findPage(ClOrdInfoPagePo clOrdInfoPagePo);

    List<ClOrdInfoListVo> findList(ClOrdInfoListPo clOrdInfoListPo);
}
