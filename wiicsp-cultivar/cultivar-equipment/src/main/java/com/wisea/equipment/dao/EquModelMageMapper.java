package com.wisea.equipment.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.equipment.entity.EquModelMage;
import com.wisea.equipment.po.EquModelListPo;
import com.wisea.equipment.po.EquModelPageListPo;
import com.wisea.equipment.po.EquModelPo;
import com.wisea.equipment.vo.EquModelListVo;
import com.wisea.equipment.vo.EquModelPageListVo;
import com.wisea.equipment.vo.EquModelVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EquModelMageMapper extends CrudDao<EquModelMage> {
    /**
     * @author jirg
     * @date 2020/7/6 16:47
     * @Description 分页查询设备型号列表
     */
    List<EquModelPageListVo> findPageList(EquModelPageListPo po);

    /**
     * @author jirg
     * @date 2020/7/6 16:48
     * @Description 根据厂商查询设备型号列表
     */
    List<EquModelListVo> findListByEntpId(EquModelListPo po);

    /**
     * @author jirg
     * @date 2020/7/6 16:48
     * @Description 根据型号名称查询设备型号
     */
    EquModelMage selectByEquModelName(EquModelPo po);

    /**
     * @author jirg
     * @date 2020/7/6 16:49
     * @Description 查询设备厂商详细信息
     */
    EquModelVo findEquModelInfo(@Param("id") Long id);
}