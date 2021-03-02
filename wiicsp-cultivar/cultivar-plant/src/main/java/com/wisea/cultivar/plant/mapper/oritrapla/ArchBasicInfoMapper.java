package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.ArchBasicInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArchBasicInfoMapper extends CrudDao<ArchBasicInfo> {
    /**
     * 根据地块id查询档案信息
     * @param archBasic
     * @return
     */
    List<ArchBasicInfo> findArchBasicInfoByMassifId(ArchBasicInfo archBasic);

    List<ArchBasicInfo> findMineArchByMassifId(ArchBasicInfo archBasic);

    List<ArchBasicInfo> findArchListByEquId(Long equId);
}
