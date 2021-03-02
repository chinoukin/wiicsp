package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.SellerSpeSerCostMage;
import com.wisea.transac.common.po.system.SellerSpeSerCostMagePagePo;
import com.wisea.transac.common.vo.system.SellerSpeSerCostMageGetVo;
import com.wisea.transac.common.vo.system.SellerSpeSerCostMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SellerSpeSerCostMageMapper extends CrudDao<SellerSpeSerCostMage> {
    /**
     * 分页查询
     * @param po
     * @return
     */
    List<SellerSpeSerCostMageListVo> findForPage(SellerSpeSerCostMagePagePo po);

    /**
     * 按ID查询
     * @param id
     * @return
     */
    SellerSpeSerCostMageListVo findById(Long id);

    /**
     * 按卖家ID和买家ID查询
     * @param sellerId 卖家ID，以企业信息中的sellerId为准
     * @param buyerId 买家ID，会员个人ID
     * @return
     */
    SellerSpeSerCostMageGetVo findBySellerIdAndBuyerId(@Param("sellerId") Long sellerId,
                                                       @Param("buyerId") Long buyerId);
    /**
     * 按照卖家ID查询列表
     *
     * @author wangh(wisea)
     *
     * @date 2019年1月22日
     * @version 1.0
     */
    public List<SellerSpeSerCostMageListVo> findBySellerId(@Param("sellerId") Long sellerId);

    /**
     * 根据卖家ID逻辑删除该卖家相关的服务费信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年1月21日
     * @version 1.0
     */
    public void deleteLogicBySellerId(Long sellerId);
    /**
     * 批量插入特殊服务费
     *
     * @author wangh(wisea)
     *
     * @date 2019年1月21日
     * @version 1.0
     */
    public void batchInsSellerSpeSercostMage(List<SellerSpeSerCostMage> list);

    /**
     * @author jirg
     * @date 2020/7/22 16:48
     * @Description 根据ids删除特殊服务费 - 逻辑删除
     */
    void deleteByIds(List<Long> list);
}
