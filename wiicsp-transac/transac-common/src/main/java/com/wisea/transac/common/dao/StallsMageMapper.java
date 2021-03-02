package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.StallsMage;
import com.wisea.transac.common.po.seller.StallsMagePageListPo;
import com.wisea.transac.common.po.seller.StallsMagePo;
import com.wisea.transac.common.vo.seller.StallsMageInfoVo;
import com.wisea.transac.common.vo.seller.StallsMageListVo;
import com.wisea.transac.common.vo.seller.StallsMagePageListVo;
import java.util.List;

import com.wisea.transac.common.vo.seller.StallsMageSelesVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StallsMageMapper extends CrudDao<StallsMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询StallsMage
     */
    List<StallsMagePageListVo> findPageList(StallsMagePageListPo po);

    /**
     * 根据店铺id查询所有档口
     * @param po
     * @return
     */
    List<StallsMagePageListVo> findAll(StallsMagePo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息StallsMage
     */
    StallsMageInfoVo findInfo(LongIdPo po);

    /**
     * @Author jirg
     * @Date 2020/5/7 16:49
     * @Description 根据商户ID查询商户档口列表
     **/
    List<StallsMageListVo> findByMembId(@Param("membId") Long membId);

    /**
     * @Author jirg
     * @Date 2020/5/7 17:11
     * @Description 根据id列表查询档口列表
     **/
    List<StallsMageListVo> findByIds(List<Long> ids);

    StallsMageSelesVo salesVolumSumByStallsId (Long id);

    /**
     * 根据交易区查询所有档口id
     * @return
     */
    List<StallsMagePageListVo> findByTradAreaId(Long id);

}
