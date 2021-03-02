package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.SettleBillOpreateInfo;
import com.wisea.cultivar.common.po.tp.SettleBillOpreateInfoListPo;
import com.wisea.cultivar.common.po.tp.SettleBillOpreateInfoPagePo;
import com.wisea.cultivar.common.vo.tp.SettleBillOpreateInfoListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * settle_bill_opreate_info 表DAO
 * 结算单操作信息
 * 2018/10/13 17:14:52
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface SettleBillOpreateInfoMapper extends CrudDao<SettleBillOpreateInfo> {
    List<SettleBillOpreateInfoListVo> findPage(SettleBillOpreateInfoPagePo settleBillOpreateInfoPagePo);

    List<SettleBillOpreateInfoListVo> findList(SettleBillOpreateInfoListPo settleBillOpreateInfoListPo);

    /**
     * 按结算单ID查询操作记录
     * @param settleId
     * @return
     */
    List<SettleBillOpreateInfoListVo> findListBySettleId(Long settleId);

    /**
     * 按结算单号查询合并支付的操作记录
     * @param settleNum
     * @return
     */
    List<SettleBillOpreateInfoListVo> findMergeBillByNum(String settleNum);
}
