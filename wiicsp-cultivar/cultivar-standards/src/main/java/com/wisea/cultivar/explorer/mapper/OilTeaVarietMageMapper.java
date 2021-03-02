package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.OilTeaVarietMage;
import com.wisea.cultivar.explorer.po.OilTeaVarietMageListPo;
import com.wisea.cultivar.explorer.po.OilTeaVarietMagePagePo;
import com.wisea.cultivar.explorer.vo.OilTeaVarietMageListVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * oil_tea_variet_mage 表DAO
 * 油茶品种信息维护
 * 2020/07/24 11:21:45
 */
public interface OilTeaVarietMageMapper extends CrudDao<OilTeaVarietMage> {
    /**
     * 分页查询
     */
    List<OilTeaVarietMageListVo> findPage(OilTeaVarietMagePagePo oilTeaVarietMagePagePo);

    /**
     * 列表查询
     */
    List<OilTeaVarietMageListVo> findList(OilTeaVarietMageListPo oilTeaVarietMageListPo);


    @Select("select * from oil_tea_variet_mage where oil_tea_variet_no = #{oilTeaVarietNo}")
    OilTeaVarietMage selectByOilNo(@Param("oilTeaVarietNo") String oilTeaVarietNo);

    void updateByNo(OilTeaVarietMage oilTeaVarietMage);
}
