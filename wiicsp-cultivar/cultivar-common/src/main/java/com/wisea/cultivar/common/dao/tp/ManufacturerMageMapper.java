package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.CommPubInfo;
import com.wisea.cultivar.common.entity.tp.ManufacturerMage;
import com.wisea.cultivar.common.po.tp.ManufacturerMageListPo;
import com.wisea.cultivar.common.po.tp.ManufacturerMagePagePo;
import com.wisea.cultivar.common.vo.tp.ManufacturerMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * manufacturer_mage 表DAO
 * 生产厂家管理
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface ManufacturerMageMapper extends CrudDao<ManufacturerMage> {
    List<ManufacturerMageListVo> findPage(ManufacturerMagePagePo manufacturerMagePagePo);

    List<ManufacturerMageListVo> findList(ManufacturerMageListPo manufacturerMageListPo);

    /*
    * 查询生产厂家列表
    * */
    List<ManufacturerMageListVo> manufacturerList(ManufacturerMagePagePo po);

    List<ManufacturerMageListVo> manuInterface();

    String selectAddressName(String area);

    /**
     * 判断是否和商品有关联关系
     * */
    List<CommPubInfo> selectCommByManufactureId(Long id);

    List<ManufacturerMage> selectNotOnly(ManufacturerMage po);
}
