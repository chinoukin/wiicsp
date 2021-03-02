package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.RelationIotInfo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifGetPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * explain:
 * </p>
 *
 * @author wangjunming
 * @since 2020/8/14 17:09
 */
@Repository
public interface RelationIotInfoMapper extends CrudDao<RelationIotInfo> {


    /**
     * 查询物联网设备ID列表
     * @param demonsBaseMassifGetPo 地块ID
     * @return
     */
    List<Long> equipmentIds(DemonsBaseMassifGetPo demonsBaseMassifGetPo);

    /**
     * @author jirg
     * @date 2020/9/3 10:10
     * @Description 根据地块ID列表查询关联产地地块列表
     */
    List<Long> findByBaseMassifIds(@Param("ids") List<Long> baseMassifIds);
}
