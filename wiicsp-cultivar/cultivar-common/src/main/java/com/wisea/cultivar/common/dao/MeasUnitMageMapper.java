package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.MeasUnitMage;
import com.wisea.cultivar.common.po.MeasUnitMagePageListPo;
import com.wisea.cultivar.common.po.product.MeasUnitMageListPo;
import com.wisea.cultivar.common.vo.MeasUnitMageInfoVo;
import com.wisea.cultivar.common.vo.MeasUnitMagePageListVo;
import com.wisea.cultivar.common.vo.product.MeasUnitMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("NbMeasUnitMageMapper")
public interface MeasUnitMageMapper extends CrudDao<MeasUnitMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询MeasUnitMage
     */
    List<MeasUnitMagePageListVo> findPageList(MeasUnitMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息MeasUnitMage
     */
    MeasUnitMageInfoVo findInfo(LongIdPo po);

    /**
     * 查询计量单位的列表
     * @param po
     * @return
     */
    List<MeasUnitMageListVo> measList(MeasUnitMageListPo po);

    /**
     * 计量单位接口
     * @return
     */
    List<MeasUnitMageListVo> measUnitInterface();

    /**
     * 计量单位校验
     * @param po
     * @return
     */
    List<MeasUnitMage> selectRepeatByNumAndName(MeasUnitMage po);

    /**
     * 判断是否重复
     * @param po
     * @return
     */
    List<MeasUnitMage> selectOnlyOne(MeasUnitMage po);

    /**
     * 根据量纲类型查询计量单位列表
     * @param dimensionsType
     * @return
     */
    List<MeasUnitMageListVo>  measUnitList(String  dimensionsType);
}
