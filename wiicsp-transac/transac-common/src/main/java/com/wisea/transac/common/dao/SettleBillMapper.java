package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.SettleBill;
import com.wisea.transac.common.po.SettleBillPageListPo;
import com.wisea.transac.common.po.trade.BuyerSettleBillListPo;
import com.wisea.transac.common.po.trade.ReconcListPo;
import com.wisea.transac.common.vo.SettleBillPageListVo;
import com.wisea.transac.common.vo.trade.BuyerSettleBillListVo;
import com.wisea.transac.common.vo.trade.SettleBillCountVo;
import com.wisea.transac.common.vo.trade.SettleBillInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Mapper
@Repository
public interface SettleBillMapper extends CrudDao<SettleBill> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SettleBill
     */
    List<SettleBillPageListVo> findPageList(SettleBillPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息SettleBill
     */
    SettleBillInfoVo findInfo(LongIdPo po);

    /**
     * @Author jirg
     * @Date 2020/5/14 9:59
     * @Description 查询最大编号列表
     **/
    List<String> findMaxNum(@Param("settleBillNumFix") String settleBillNumFix);

    /**
     * @Author jirg
     * @Date 2020/5/14 13:37
     * @Description 查询角标
     **/
    SettleBillCountVo findCountByState(SettleBillPageListPo po);

    /**
     * @Author jirg
     * @Date 2020/5/18 14:43
     * @Description 查询对账异议列表
     **/
    List<SettleBillPageListVo> findReconcList(ReconcListPo po);

    /**
     * 买家查询账期列表
     * @param po
     * @return
     */
    List<BuyerSettleBillListVo> buyerSettleList (BuyerSettleBillListPo po);

    /**
     * 买家查询结算单角标
     * @param po
     * @return
     */
    SettleBillCountVo buyerSettleListNum (BuyerSettleBillListPo po);

    /**
     * @Author jirg
     * @Date 2020/5/20 15:10
     * @Description 查询逾期的结算单
     */
    List<SettleBill> findOverdueSettleBill(OffsetDateTime deadline);

    /**
     * @Author jirg
     * @Date 2020/5/20 15:10
     * @Description 查询需取消结算单列表
     */
    List<SettleBill> findTimeOutInvoicingSettleBill(OffsetDateTime deadline);

    /**
     * 查询超时未对账的结算单
     * @return
     */
    List<SettleBill> findOutReconSettle();

    /**
     * 查询超时未验票
     * @return
     */
    List<SettleBill> findExamInvoSettle();
}
