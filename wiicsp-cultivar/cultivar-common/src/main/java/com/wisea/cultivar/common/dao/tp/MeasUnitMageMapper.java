package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.MeasUnitMage;
import com.wisea.cultivar.common.po.tp.MeasUnitMageListPo;
import com.wisea.cultivar.common.po.tp.MeasUnitMagePagePo;
import com.wisea.cultivar.common.vo.tp.MeasUnitMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * meas_unit_mage 表DAO
 * 计量单位管理
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface MeasUnitMageMapper extends CrudDao<MeasUnitMage> {
    List<MeasUnitMageListVo> findPage(MeasUnitMagePagePo measUnitMagePagePo);

    List<MeasUnitMageListVo> findList(MeasUnitMageListPo measUnitMageListPo);

    /*
    * 查询计量单位的列表
    * */
    List<MeasUnitMageListVo> measList(MeasUnitMageListPo po);

    /*
     * 计量单位接口
     * */
    List<MeasUnitMageListVo> measUnitInterface();

    /**
     * 判断是否重复
     * */
    List<MeasUnitMage> selectRepeatByNumAndName(MeasUnitMage po);

    List<MeasUnitMage> selectOnlyOne(MeasUnitMage po);
}
