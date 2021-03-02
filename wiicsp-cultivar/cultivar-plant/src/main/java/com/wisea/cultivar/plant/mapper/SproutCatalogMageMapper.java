package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.SproutCatalogMage;
import com.wisea.cultivar.plant.vo.OilTeaVarietMageInfoVo;
import com.wisea.cultivar.plant.vo.OilTeaVarietMagePageListVo;
import com.wisea.cultivar.plant.vo.SproutCatalogMageInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SproutCatalogMageMapper extends CrudDao<SproutCatalogMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/07 10:13:35
     * @Description 分页查询SproutCatalogMage
     * @param year
     */
    List<OilTeaVarietMagePageListVo> findOilPageList(Integer year);

    /**
     * @author wbf-code-generator
     * @date 2020/08/07 10:13:35
     * @Description 查询详细信息SproutCatalogMage
     */
    OilTeaVarietMageInfoVo findInfo(LongIdPo po);

    SproutCatalogMageInfoVo findByYear();
}
