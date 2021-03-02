package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.RefundCommOperatorInfo;
import com.wisea.cultivar.common.po.tp.RefundCommOperatorInfoListPo;
import com.wisea.cultivar.common.po.tp.RefundCommOperatorInfoPagePo;
import com.wisea.cultivar.common.vo.tp.RefundCommOperatorInfoListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * refund_comm_operator_info 表DAO
 * 退货操作信息
 * 2018/09/30 09:46:17
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface RefundCommOperatorInfoMapper extends CrudDao<RefundCommOperatorInfo> {
    List<RefundCommOperatorInfoListVo> findPage(RefundCommOperatorInfoPagePo refundCommOperatorInfoPagePo);

    List<RefundCommOperatorInfoListVo> findList(RefundCommOperatorInfoListPo refundCommOperatorInfoListPo);
}
