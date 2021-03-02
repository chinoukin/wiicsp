package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.OrdCommRela;
import com.wisea.transac.common.po.product.CommStatisPo;
import com.wisea.transac.common.vo.product.CommStaticsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrdCommRelaMapper extends CrudDao<OrdCommRela> {
    /**
     * @Author jirg
     * @Date 2020/5/6 16:12
     * @Description 根据订单ID查询订单商品列表
     **/
    List<OrdCommRela> findByOrdId(@Param("ordId") Long id);

    /**
     * 运营后台 查询商品销售情况
     * @param commStatisPo
     * @return
     */
    List<CommStaticsVo> commSaleStatics(CommStatisPo commStatisPo);

    /**
     * 运营后台 热卖商品统计情况
     * @param commStatisPo
     * @return
     */
    List<CommStaticsVo> statisCommHot(CommStatisPo commStatisPo);
}
