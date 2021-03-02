package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.ShopInfo;
import com.wisea.cultivar.plant.po.ShopInfoPageListPo;
import com.wisea.cultivar.plant.vo.ShopInfoInfoVo;
import com.wisea.cultivar.plant.vo.ShopInfoPageListVo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShopInfoMapper extends CrudDao<ShopInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询ShopInfo
     */
    List<ShopInfoPageListVo> findPageList(ShopInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息ShopInfo
     */
    ShopInfoInfoVo findInfo(@Param(value = "id") Long id, @Param(value = "seeMembId") Long seeMembId);




}
