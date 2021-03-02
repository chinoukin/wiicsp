package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.LtaOrdCommRela;
import com.wisea.cultivar.common.vo.tp.lta.LtaRefundCommApplCitVo;
import org.apache.ibatis.annotations.Param;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;

public interface LtaOrdCommRelaMapper extends CrudDao<LtaOrdCommRela> {
    /**
     * @Author jirg
     * @Date 2019/5/8 17:23
     * @Description 根据订单ID查询长期协议订单商品列表
     **/
    List<LtaOrdCommRela> findListByOrdId(@Param("ltaOrdId") Long ltaOrdId);

    /**
     * 提交退货申请详情页
     * @param id
     * @return
     */
    LtaRefundCommApplCitVo commitLtaRefundCommInvo (Long id);

    /**
     * 根据订单ID查询订单商品列表
     * @param orderIds
     * @return
     */
    List<LtaOrdCommRela> findByIds(@Param("ordIds") String ordIds);
}
