package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.MeasUnitMage;
import com.wisea.transac.common.po.MeasUnitMagePageListPo;
import com.wisea.transac.common.po.product.MeasUnitMageListPo;
import com.wisea.transac.common.vo.MeasUnitMageInfoVo;
import com.wisea.transac.common.vo.MeasUnitMagePageListVo;
import java.util.List;

import com.wisea.transac.common.vo.product.MeasUnitMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
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
}
