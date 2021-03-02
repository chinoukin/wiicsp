package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.OrdCommRela;
import com.wisea.cultivar.common.po.tp.OrdCommRelaListPo;
import com.wisea.cultivar.common.po.tp.OrdCommRelaPagePo;
import com.wisea.cultivar.common.po.tp.OrderInfoListPo;
import com.wisea.cultivar.common.po.tp.statistics.CommStatisTimePo;
import com.wisea.cultivar.common.vo.tp.OrdCommRelaListVo;
import com.wisea.cultivar.common.vo.tp.OrderCommDataVo;
import org.apache.ibatis.annotations.Param;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.statistics.CommStaticsVo;
import com.wisea.cultivar.common.vo.tp.statistics.MountainStatisVo;
import com.wisea.cultivar.common.vo.tp.trade.RefundCommApplCitVo;

/**
 * ord_comm_rela 表DAO
 * 商品发布价格=结算价+运费+平台服务费
 * 2018/09/18 17:40:35
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface OrdCommRelaMapper extends CrudDao<OrdCommRela> {
    List<OrdCommRelaListVo> findPage(OrdCommRelaPagePo ordCommRelaPagePo);

    List<OrdCommRelaListVo> findList(OrdCommRelaListPo ordCommRelaListPo);


    /**
     * 根据订单ID查询订单商品列表
     * @param orderIds
     * @return
     */
    List<OrdCommRela> findByOrderIds(List<Long> orderIds);

    /**
     * 根据订单ID查询订单商品列表
     * @param orderIds
     * @return
     */
    List<OrdCommRela> findByIds(@Param("ordIds") String ordIds);

    /**
     * 得到订单商品的详细列表
     * */
    List<OrderCommDataVo> getCommDetails(OrderInfoListPo po);

    /**
     * 提交退货申请详情页
     * @param id
     * @return
     */
    RefundCommApplCitVo commitRefundCommInvo (Long id);

    /**
     * 根据订单的ID查询订单商品信息
     * @param id
     * @return
     */
    List<OrdCommRela> findOrdCommPubInfoList (Long ordId);

    /**
     * 查询热销商品统计
     * @param commStatisTimePo
     * @return
     */
    List<CommStaticsVo> statisCommHot (CommStatisTimePo commStatisTimePo);

    /**
     * 查询商品销售统计
     * @param commStatisTimePo
     * @return
     */
    List<CommStaticsVo> statisComm (CommStatisTimePo commStatisTimePo);

    /**
     * 查询商品山系、树龄销售统计
     * @param commStatisTimePo
     * @return
     */
    List<MountainStatisVo> staticsMoutOrShuling (CommStatisTimePo commStatisTimePo);
}
