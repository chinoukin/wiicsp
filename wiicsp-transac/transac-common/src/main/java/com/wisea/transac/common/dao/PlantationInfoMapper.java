package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.PlantationInfo;
import com.wisea.transac.common.po.seller.PlantationInfoPagePo;
import com.wisea.transac.common.vo.BaseStatVo;
import com.wisea.transac.common.vo.seller.PlantationInfoListVo;
import com.wisea.transac.common.vo.seller.PlantationInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlantationInfoMapper extends CrudDao<PlantationInfo> {

    /**
     * @author jirg
     * @date 2020/7/2 16:49
     * @Description 根据种植园ID 查询种植园列表
     */
    List<PlantationInfoListVo> findListByBaseId(LongIdPo po);

    List<PlantationInfoVo> findListByBaseIdForPage(PlantationInfoPagePo po);

    /**
     * @author jirg
     * @date 2020/7/2 17:11
     * @Description 查询种植园详细信息
     */
    PlantationInfoVo findPlantationInfo(LongIdPo po);

    List<PlantationInfo> findAllByBaseId(Long baseId);

    BaseStatVo countAndAreaSum(Long baseId);

}
