package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.InvoInfo;
import com.wisea.cultivar.common.po.tp.InvoInfoListPo;
import com.wisea.cultivar.common.po.tp.InvoInfoPagePo;
import com.wisea.cultivar.common.po.tp.OrderInfoListPo;
import com.wisea.cultivar.common.po.tp.trade.BuyerInvoListPo;
import com.wisea.cultivar.common.vo.tp.InvoInfoListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.DefaultInvoInfoVo;

/**
 * invo_info 表DAO
 * 发票信息
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface InvoInfoMapper extends CrudDao<InvoInfo> {
    List<InvoInfoListVo> findPage(InvoInfoPagePo invoInfoPagePo);

    List<InvoInfoListVo> findList(InvoInfoListPo invoInfoListPo);

    /*
    * 发票列表
    * */
    List<InvoInfoListVo> invoiceList(BuyerInvoListPo po);

    /*
    * 查询是否存在已经是默认抬头的发票了
    * */
    InvoInfoListVo selectDefaultInvoInfoBoolean(InvoInfoListPo po);

    /*
    * 如果已经存在就将状态修改成为1
    * */
    Integer updateDefaultInvoInfo(InvoInfoListVo invoInfoListVo);

    /**
     * 修改其他的为非默认
     */
    void updateDefaultToNo(Long membId);

    /*
    * 修改为默认的发票
    * */
    Integer saveDefaultInvoInfo(InvoInfoListPo po);

    /*
    * 得到订单的发票信息
    * */
    InvoInfo getInvoiceData(OrderInfoListPo po);

    /**
     * 分页查询
     * @param invoInfoPagePo
     * @return
     */
    List<InvoInfoListVo> findForPage(InvoInfoPagePo invoInfoPagePo);

    /**
     * 按ID查询
     * @param id
     * @return
     */
    InvoInfoListVo findById(Long id);

    /**
     * 按会员ID统计可用记录总数
     * @param membId
     * @return
     */
    Long countByMembId(Long membId);

    /**
     * 按会员ID更新所有defaultflag
     * @param po
     * @return
     */
    int updateAllDefaultFlagByMembId(InvoInfo po);

    /*
     *  通过会员ID 查询默认的发票地址
     * */
    DefaultInvoInfoVo selectDefaultInvoInfoByMembId(Long membId);
}
