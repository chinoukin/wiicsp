package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.DemonsBaseInfo;
import com.wisea.cultivar.explorer.po.DemonsBaseInfoListPo;
import com.wisea.cultivar.explorer.po.DemonsBaseInfoPagePo;
import com.wisea.cultivar.explorer.po.PalntBigDataMapPointsPo;
import com.wisea.cultivar.explorer.vo.BigDataMapPointListVo;
import com.wisea.cultivar.explorer.vo.DemonsBaseInfoListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * demons_base_info 表DAO
 * 示范基地信息
 * 2020/08/11 13:21:46
 */
public interface DemonsBaseInfoMapper extends CrudDao<DemonsBaseInfo> {
    /**
     * 分页查询
     */
    List<DemonsBaseInfoListVo> findPage(DemonsBaseInfoPagePo demonsBaseInfoPagePo);

    /**
     * 列表查询
     */
    List<DemonsBaseInfoListVo> findList(DemonsBaseInfoListPo demonsBaseInfoListPo);

    /**
     * @author jirg
     * @date 2020/9/2 14:48
     * @Description 查询地图坐标点列表（大数据使用）
     */
    List<BigDataMapPointListVo> findMapPoints(PalntBigDataMapPointsPo po);

    int delInfoByEnterId(@Param("enterpriseId") Long enterpriseId);

    int delMassifByDemonsBaseId(@Param("delId")Long delId);

}
