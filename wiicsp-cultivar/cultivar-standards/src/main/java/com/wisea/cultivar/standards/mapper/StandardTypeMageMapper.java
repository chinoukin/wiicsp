package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.StandardTypeMage;
import com.wisea.cultivar.standards.po.StandardTypeMageListPo;
import com.wisea.cultivar.standards.po.StandardTypeMagePagePo;
import com.wisea.cultivar.standards.po.StandardTypeMageTreePo;
import com.wisea.cultivar.standards.vo.StandardTypeMageListVo;
import com.wisea.cultivar.standards.vo.StandardTypeMageTreeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * standard_type_mage 表DAO
 * 标准类型管理
 * 2020/07/24 11:21:45
 */
public interface StandardTypeMageMapper extends CrudDao<StandardTypeMage> {
    /**
     * 分页查询
     */
    List<StandardTypeMageListVo> findPage(StandardTypeMagePagePo standardTypeMagePagePo);

    /**
     * 列表查询
     */
    List<StandardTypeMageListVo> findList(StandardTypeMageListPo standardTypeMageListPo);

    /**
     * 树形数据查询
     * @param standardTypeMageTreePo
     * @return
     */
    List<StandardTypeMageTreeVo> standardTypeMageGetTree(StandardTypeMageTreePo standardTypeMageTreePo);

    /**
     * 获取ChinaStandardTypeMage对象
     * @param delId
     * @return
     */
    StandardTypeMage getOne(Long delId);

    /**
     * 根据PID获取List
     * @param delId
     * @return
     */
    List<StandardTypeMage> findstandardTypeMagePidByid(Long delId);

    int deleteByPid(Long id);

    StandardTypeMage getByName(@Param("name") String name);
}
