package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.ApPayMage;
import com.wisea.cultivar.common.po.tp.trade.ApPayMageListPo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.ApPayMageListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApPayMageMapper extends CrudDao<ApPayMage> {
    /**
     * @Author jirg
     * @Date 2019/4/17 11:07
     * @Description 根据卖方ID、买方ID查询账期支付设置管理
     **/
    ApPayMage findBySellerIdAndBuyerId(@Param("sellerId") Long sellerId, @Param("buyerId") Long buyerId);

    /**
     * @Author jirg
     * @Date 2019/4/22 10:43
     * @Description 分页查询账期支付管理列表
     **/
    List<ApPayMageListVo> findPageList(ApPayMageListPo po);

    /**
     * 买家查询列表
     * @param po
     * @return
     */
    List<ApPayMageListVo> buyerApList(ApPayMageListPo po);
}
