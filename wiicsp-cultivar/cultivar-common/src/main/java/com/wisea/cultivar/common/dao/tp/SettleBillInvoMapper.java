package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.SettleBillInvo;
import com.wisea.cultivar.common.po.tp.PublishSellerSettleInvoPo;
import com.wisea.cultivar.common.po.tp.SettleBillInvoListPo;
import com.wisea.cultivar.common.po.tp.SettleBillInvoPagePo;
import com.wisea.cultivar.common.po.tp.trade.SellerSetBillInvoListPo;
import com.wisea.cultivar.common.vo.tp.SettleBillInvoListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.SellerSetBillInvoInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.SellerSetBillInvoListVo;

/**
 * settle_bill_invo 表DAO
 * 结算单发票
 * 2018/10/12 11:10:09
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface SettleBillInvoMapper extends CrudDao<SettleBillInvo> {
    List<SettleBillInvoListVo> findPage(SettleBillInvoPagePo settleBillInvoPagePo);

    List<SettleBillInvoListVo> findList(SettleBillInvoListPo settleBillInvoListPo);

    /**
     * 得到卖家的已开具的发票列表
     * */
    List<SettleBillInvo> getSellerIssuedInvoice(SettleBillInvo po);

    /**
     * 修改结算单发票
     * */
    Integer updateSellerSettleInvo(PublishSellerSettleInvoPo po);

    /**
     * 获取申请开票的申请编号
     * @param applNum
     * @return
     */
    List<String> findApplNumMaxNum(String applNum);

    /**
     * 按结算单ID查询发票信息
     * @param settleId
     * @return
     */
    SettleBillInvoListVo findBySettleId(Long settleId);

    SettleBillInvo getLogisticsData(Long invoLogistics);

    List<SettleBillInvoListVo> selectInvoAndAddressMss(List<Long> aLong);

    /**
     * 查询账期发票列表
     * @param po
     * @return
     */
    List<SellerSetBillInvoListVo> serSettleList (SellerSetBillInvoListPo po);

    /**
     * 查询详情，带地址
     * @param id
     * @return
     */
    SellerSetBillInvoInfoVo selInfoById (Long id);
}
