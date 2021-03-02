package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.RtspCodeMage;
import com.wisea.cultivar.plant.po.oritrapla.RtspCodeMageListPo;
import com.wisea.cultivar.plant.vo.oritrapla.ArchInfoCirculationVo;
import com.wisea.cultivar.plant.vo.oritrapla.RtspCodeMageInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.RtspMineArchInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RtspCodeMageMapper  extends CrudDao<RtspCodeMage> {
    /**
     * 查询追溯码申请详细信息
     * @param po
     * @return
     */
    RtspCodeMageInfoVo findRtspCodeInfo(RtspCodeMage po);

    /**
     * 分页查询追溯码列表
     * @param po
     * @return
     */
    List<RtspCodeMageInfoVo> findRtspCodeList(RtspCodeMageListPo po);

    /**
     * 查询档案信息
     * @param parameterMap
     * @return
     */
    RtspMineArchInfoVo findMineArchInfo(Map<String, Long> parameterMap);

    /**
     * 平台追溯监管
     * @param archId
     * @return
     */
    ArchInfoCirculationVo findArchInfoCirculation(Long archId);
}
