package com.wisea.cultivar.common.dao.tp;

import java.util.List;
import java.util.Map;

import com.wisea.cultivar.common.entity.tp.SettleOrdRela;
import com.wisea.cultivar.common.po.tp.SettleOrdRelaListPo;
import com.wisea.cultivar.common.po.tp.SettleOrdRelaPagePo;
import com.wisea.cultivar.common.vo.tp.SettleOrdRelaListVo;
import com.wisea.cultivar.common.vo.tp.SettleOrdStatVo;
import org.apache.ibatis.annotations.Param;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.SettleBillOrdInfoVo;

/**
 * settle_ord_rela 表DAO
 * 结算订单关系表
 * 2018/10/13 11:47:55
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface SettleOrdRelaMapper extends CrudDao<SettleOrdRela> {
    List<SettleOrdRelaListVo> findPage(SettleOrdRelaPagePo settleOrdRelaPagePo);

    List<SettleOrdRelaListVo> findList(SettleOrdRelaListPo settleOrdRelaListPo);

    /**
     * 根据结算单ID和订单类型统计订单个数和总金额
     * @param map 需要参数settleId和ordType
     * @return SettleOrdStatVo
     */
    SettleOrdStatVo statOrdBySettleIdAndOrdType(Map<String,Object> map);


    /***
     * 查询是否存在订单号
     * @param ordId
     * @return
     */
    Integer existOrd(@Param("ordId") Long ordId);

    /**
     * 根据结算单id查询订单信息
     * @param settleId
     * @return
     */
    List<SettleBillOrdInfoVo> findOrdBySettle (@Param("settleId") Long settleId);

    /**
     * 根据订单id查询账期
     * @param ordId
     * @return
     */
    SettleOrdRela findSettleByOrd(Long ordId);
}
