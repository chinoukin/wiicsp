package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.SerListMage;
import com.wisea.cultivar.plant.po.SerListMagePageListPo;
import com.wisea.cultivar.plant.vo.SerListMageInfoVo;
import com.wisea.cultivar.plant.vo.SerListMagePageListVo;
import com.wisea.cultivar.plant.vo.SerListStateTypeCountVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SerListMageMapper extends CrudDao<SerListMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询SerListMage
     */
    List<SerListMagePageListVo> findPageList(SerListMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息SerListMage
     */
    SerListMageInfoVo findInfo(Long id);

    /**
     * 查询不同服务单状态数量
     * @param membId
     * @return
     */
    List<SerListStateTypeCountVo> getSerListStateType(Long membId);

    /**
     * 根据状态查询服务单
     * @param serListStateType
     * @return
     */
    List<SerListMageInfoVo> findBySerListStateType(String serListStateType);

    /**
     * 根据服务单状态 待确认或者待服务
     * @return
     */
    List<SerListMageInfoVo>  findCancelBySerListStateType();

    /**
     * 查询采购记录
     * @param po
     * @return
     */
    List<SerListMagePageListVo> findRecordPageList(SerListMagePageListPo po);

    Long findSerListNo();

}
