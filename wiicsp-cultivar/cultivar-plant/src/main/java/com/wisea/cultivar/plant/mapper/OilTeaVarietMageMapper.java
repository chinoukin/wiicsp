package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.OilTeaVarietMage;
import com.wisea.cultivar.plant.po.OilTeaVarietMagePageListPo;
import com.wisea.cultivar.plant.vo.OilTeaVarietMageInfoVo;
import com.wisea.cultivar.plant.vo.OilTeaVarietMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OilTeaVarietMageMapper extends CrudDao<OilTeaVarietMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/07 17:00:48
     * @Description 分页查询OilTeaVarietMage
     */
    List<OilTeaVarietMagePageListVo> findPageList(OilTeaVarietMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/07 17:00:48
     * @Description 查询详细信息OilTeaVarietMage
     */
    OilTeaVarietMageInfoVo findInfo(LongIdPo po);
}
