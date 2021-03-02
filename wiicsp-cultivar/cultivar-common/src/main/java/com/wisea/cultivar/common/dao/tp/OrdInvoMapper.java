package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.OrdInvo;
import com.wisea.cultivar.common.po.tp.trade.OrdInvoListPo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.OrdInvoInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.OrdInvoListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ord_invo 表DAO
 * 订单发票
 * 2018/10/09 16:04:06
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface OrdInvoMapper extends CrudDao<OrdInvo> {

    /**
     * 获取申请开票的申请编号
     * @param applNum
     * @return
     */
    List<String> findApplNumMaxNum(String applNum);

    /**
     * @Author jirg
     * @Date 2019/4/18 11:22
     * @Description 根据订单ID查询订单发票
     **/
    OrdInvo findByOrdId(@Param("ordId") Long ordId);

    /**
     * @Author jirg
     * @Date 2019/4/18 11:28
     * @Description 根据订单id删除订单发票信息
     **/
    void delByOrdId(Long ordId);

    /**
     * @Author jirg
     * @Date 2019/4/24 16:45
     * @Description 分页查询卖家发票信息列表
     **/
    List<OrdInvoListVo> findPageList(OrdInvoListPo po);

    /**
     * @Author jirg
     * @Date 2019/4/24 18:58
     * @Description 查询发票详细信息
     **/
    OrdInvoInfoVo findOrdInvoInfo(@Param("id") Long id);


    /*

    List<OrdInvoListVo> findPage(OrdInvoPagePo ordInvoPagePo);

    List<OrdInvoListVo> findList(OrdInvoListPo ordInvoListPo);

    *//*
    * 查询待开具发票的列表
    * *//*
    List<OrdInvoListVo> getIssueInvoice(OrdInvoPagePo po);

    *//*
    * 得到开票信息
    * *//*
    OrdInvo getIssueData(OrderInfoListPo po);

    *//**
     * 更改发票状态
     * *//*
    Integer modifyInvoiceState(OrdInvoListPo po);

    *//**
     * 查询已开具发票的列表
     * *//*
    List<OrdInvoListVo> getIssuedInvoiceList(OrdInvoPagePo po);

    *//**
     * 查看订单发票的作废备注
     * *//*
    String getCancelRemarks(OrderInfoListPo po);

    *//**
     * 得到要作废发票的信息
     * *//*
    OrdInvoListVo getInvoDetails(OrdInvoListPo po);

    *//**
     * 如果是纸质发票就要通过订单发票的ID去查询物流信息
     * *//*
    OrdInvoListVo getLogisticsDataById(OrderInfoListPo po);


*/

}
