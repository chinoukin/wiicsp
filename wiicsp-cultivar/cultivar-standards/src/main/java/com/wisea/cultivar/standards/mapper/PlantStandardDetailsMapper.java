package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.PlantStandardDetails;
import com.wisea.cultivar.standards.po.PlantStandardDetailsListPo;
import com.wisea.cultivar.standards.po.PlantStandardDetailsPagePo;
import com.wisea.cultivar.standards.vo.PlantStandardDetailsListVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * plant_standard_details 表DAO
 * 标准详情
 * 2020/07/24 11:21:45
 */
@Component
public interface PlantStandardDetailsMapper extends CrudDao<PlantStandardDetails> {
    /**
     * 分页查询
     */
    List<PlantStandardDetailsListVo> findPage(PlantStandardDetailsPagePo plantStandardDetailsPagePo);

    /**
     * 列表查询
     */
    List<PlantStandardDetailsListVo> findList(PlantStandardDetailsListPo plantStandardDetailsListPo);

    /**
     * 根据standard_specification_id删除所有记录
     * @return
     */
    int deleteByPSDId(PlantStandardDetails plantStandardDetails);
}
