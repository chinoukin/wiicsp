package com.wisea.equipment.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.equipment.entity.EquEntpMage;
import com.wisea.equipment.po.EquEntpListPo;
import com.wisea.equipment.po.EquEntpPo;
import com.wisea.equipment.vo.EquEntpListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EquEntpMageMapper extends CrudDao<EquEntpMage> {
    /**
     * @author jirg
     * @date 2020/7/6 15:02
     * @Description 分页查询设备厂商列表
     */
    List<EquEntpListVo> findPageList(EquEntpListPo po);

    /**
     * @author jirg
     * @date 2020/7/6 15:49
     * @Description 根据厂商名称查询设备厂商
     */
    EquEntpMage selectByEquEntpName(EquEntpPo po);
}