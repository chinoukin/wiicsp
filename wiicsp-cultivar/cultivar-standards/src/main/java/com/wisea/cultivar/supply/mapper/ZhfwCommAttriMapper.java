package com.wisea.cultivar.supply.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.ZhfwCommAttri;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZhfwCommAttriMapper extends CrudDao<ZhfwCommAttri> {

    /**
     * 通过商品id删除商品属性
     * @param commPubId 商品id
     */
    void deleteByCommPubId(Long commPubId);

    ZhfwCommAttri selectByAttriId(@Param("attri") Long attri, @Param("commId") Long commId);

    /**
     * 通过商品id查询属性
     * @param commPubId 商品id
     */
    List<ZhfwCommAttri> findByCommPubId(Long commPubId);

    /**
     * 通过商品和用户商品查询
     */
    ZhfwCommAttri findByCommPubIdAndAttriId(@Param("pubId") Long pubId, @Param("attriId") Long attriId);
}
