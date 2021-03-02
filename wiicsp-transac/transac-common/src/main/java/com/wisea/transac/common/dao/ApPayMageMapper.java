package com.wisea.transac.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.ApPayMage;
import com.wisea.transac.common.po.trade.ApPayMagePageListPo;
import com.wisea.transac.common.po.trade.BuyerApPayListPo;
import com.wisea.transac.common.vo.trade.ApPayMageCountVo;
import com.wisea.transac.common.vo.trade.ApPayMageInfoVo;
import com.wisea.transac.common.vo.trade.ApPayMagePageListVo;
import com.wisea.transac.common.vo.trade.BuyerApPayMageListVo;

@Mapper
@Repository
public interface ApPayMageMapper extends CrudDao<ApPayMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询ApPayMage
     */
    List<ApPayMagePageListVo> findPageList(ApPayMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息ApPayMage
     */
    ApPayMageInfoVo findInfo(LongIdPo po);

    /**
     * @Author jirg
     * @Date 2020/5/12 14:50
     * @Description 查询角标数量
     **/
    ApPayMageCountVo findApPayMageCount(ApPayMagePageListPo po);

    /**
     * @Author jirg
     * @Date 2020/5/12 15:35
     * @Description 根据买卖家查询账期支付设置
     **/
    ApPayMage findByIds(@Param("sellerId") Long sellerId, @Param("buyerId") Long buyerId);

    List<ApPayMagePageListVo> findminiPageList(ApPayMagePageListPo po);

    /**
     * 买家查询账期设置列表
     * @param po
     * @return
     */
    List<BuyerApPayMageListVo> buyerSelApPayList(BuyerApPayListPo po);
}
