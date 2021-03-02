package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.SettleBill;
import com.wisea.cultivar.common.po.tp.LongIdPo;
import com.wisea.cultivar.common.po.tp.trade.BuyerSettleBillListPo;
import com.wisea.cultivar.common.po.tp.trade.SettleBillListPo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerSettleBillInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerSettleBillListVo;
import com.wisea.cultivar.common.vo.tp.trade.SettleBillInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.SettleBillListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * settle_bill 表DAO
 * 结算单
 * 2018/10/12 11:07:31
 */
public interface SettleBillMapper extends CrudDao<SettleBill> {
    List<String> findSettleBillNum(@Param("settleBillNum") String settleBillNum);

    /**
     * @Author jirg
     * @Date 2019/4/23 10:01
     * @Description 根据买卖家ID查询指定状态下结算单数量
     **/
    Integer findStatueTypeCount(SettleBill settleBill);


    /**
     * @Author jirg
     * @Date 2019/4/23 10:19
     * @Description 查询未生成结算单的订单数量
     **/
    Integer notSettleBillOrdCount(SettleBill settleBill);

    /**
     * 买家查询账期结算单
     * @param po
     * @return
     */
    List<BuyerSettleBillListVo> buyerSettleList (BuyerSettleBillListPo po);

    /**
     * 买家查询账期结算单详情
     * @param po
     * @return
     */
    BuyerSettleBillInfoVo buyerSettleInfo (Long id);

    /**
     * @Author jirg
     * @Date 2019/4/23 15:44
     * @Description 查询上次生成的结算周期的结束时间列表
     **/
    List<SettleBill> findMaxSettleCycleEndDate(SettleBill settleBill);

    /**
     * @Author jirg
     * @Date 2019/4/24 10:15
     * @Description 分页查询结算单列表
     **/
    List<SettleBillListVo> findPageList(SettleBillListPo po);

    /**
     * @Author jirg
     * @Date 2019/5/15 10:10
     * @Description 查询结算单详细信息
     **/
    SettleBillInfoVo findInfo(LongIdPo po);

    /**
     * @Author jirg
     * @Date 2019/8/21 17:32
     * @Description 查询逾期的结算单列表
     **/
    List<SettleBill> findOverdueSettleBill(@Param("deadline") OffsetDateTime deadline);
}
