package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.LtaOrdInvo;
import com.wisea.cultivar.common.po.tp.trade.OrdInvoListPo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

import com.wisea.cultivar.common.vo.tp.trade.OrdInvoInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.OrdInvoListVo;
import org.apache.ibatis.annotations.Param;

public interface LtaOrdInvoMapper extends CrudDao<LtaOrdInvo> {
    /**
     * @Author jirg
     * @Date 2019/5/8 17:44
     * @Description 根据订单ID查询长期协议订单发票信息
     **/
    LtaOrdInvo findByOrdId(@Param("ltaOrdId") Long ltaOrdId);

    /**
     * @Author jirg
     * @Date 2019/5/9 11:17
     * @Description 根据订单ID删除订单发票信息
     **/
    void delByOrdId(@Param("ltaOrdId") Long ltaOrdId);

    /**
     * 获取申请开票的申请编号
     * @param applNum
     * @return
     */
    List<String> findApplNumMaxNum(String applNum);

    /**
     * @Author jirg
     * @Date 2019/5/15 15:11
     * @Description 查询长期协议订单发票列表
     **/
    List<OrdInvoListVo> findPageList(OrdInvoListPo po);

    /**
     * @Author jirg
     * @Date 2019/5/15 15:15
     * @Description 查询长期协议订单发票详细信息
     **/
    OrdInvoInfoVo findOrdInvoInfo(Long id);
}
