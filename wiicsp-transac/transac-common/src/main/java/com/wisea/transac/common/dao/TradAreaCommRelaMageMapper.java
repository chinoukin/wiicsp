package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.TradAreaCommRelaMage;
import com.wisea.transac.common.po.system.TradAreaCommRelaMageListPo;
import com.wisea.transac.common.po.system.TradAreaCommRelaMagePagePo;
import com.wisea.transac.common.vo.system.TradAreaCommRelaMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * trad_area_comm_rela_mage 表DAO
 * 交易区商品管理
 * 2020/05/07 10:34:47
 */
@Mapper
@Repository
public interface TradAreaCommRelaMageMapper extends CrudDao<TradAreaCommRelaMage> {

    /**
     * 分页查询
     */
    List<TradAreaCommRelaMageListVo> findPage(TradAreaCommRelaMagePagePo tradAreaCommRelaMagePagePo);
    /**
     * 列表查询
     */
    List<TradAreaCommRelaMageListVo> findList(TradAreaCommRelaMageListPo tradAreaCommRelaMageListPo);

    /**
     * 查询所有商品数量
     * @param tradAreaId
     * @return
     */
    Long countAllComm(Long tradAreaId);

    /**
     * 按交易区Id删除分类
     * @param areaId
     */
    void deleteByAreaId(Long areaId);

    /**
     * 交易区中是否关联了销售分类设置
     * @param id
     * @return
     */
    Integer selectAreaCommRelaCount(Long id);

    int delBySalesClassRelaId(Long id);
}
