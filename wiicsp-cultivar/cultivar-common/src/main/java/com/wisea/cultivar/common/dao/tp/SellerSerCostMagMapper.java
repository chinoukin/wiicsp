package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.SellerSerCostMag;
import com.wisea.cultivar.common.po.tp.system.SellerSerCostMageListPo;
import com.wisea.cultivar.common.po.tp.system.SellerSerCostMagePagePo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.system.SellerSerCostMageGetVo;
import com.wisea.cultivar.common.vo.tp.system.SellerSerCostMageListVo;

import java.util.List;

public interface SellerSerCostMagMapper extends CrudDao<SellerSerCostMag> {
    List<SellerSerCostMageListVo> findPage(SellerSerCostMagePagePo sellerSerCostMagePagePo);

    List<SellerSerCostMageListVo> findList(SellerSerCostMageListPo sellerSerCostMageListPo);

    /**
     * 分页查询
     * @param po
     * @return
     */
    List<SellerSerCostMageListVo> findForPage(SellerSerCostMagePagePo po);

    /**
     * 按ID查询
     * @param id
     * @return
     */
    SellerSerCostMageListVo findById(Long id);

    /**
     * 按卖家ID查询统一服务费
     * @param sellerId 卖家ID，以企业信息中的sellerId为准
     * @return
     */
    SellerSerCostMageGetVo findBySellerId(Long sellerId);
    /**
     * 根据卖家ID删除统一服务费信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年1月21日
     * @version 1.0
     */
    public void deleteLogicBySellerId(Long sellerId);
}
