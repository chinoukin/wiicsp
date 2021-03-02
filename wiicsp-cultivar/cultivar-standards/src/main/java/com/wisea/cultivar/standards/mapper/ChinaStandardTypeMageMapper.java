package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.ChinaStandardTypeMage;
import com.wisea.cultivar.standards.po.ChinaStandardTypeMageListPo;
import com.wisea.cultivar.standards.po.ChinaStandardTypeMagePagePo;
import com.wisea.cultivar.standards.po.ChinaStandardTypeMageTreePo;
import com.wisea.cultivar.standards.vo.ChinaStandardTypeMageListVo;
import com.wisea.cultivar.standards.vo.ChinaStandardTypeMageTreeVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * china_standard_type_mage 表DAO
 * 中标分类管理
 * 2020/07/24 11:21:45
 */
public interface ChinaStandardTypeMageMapper extends CrudDao<ChinaStandardTypeMage> {
    /**
     * 分页查询
     */
    List<ChinaStandardTypeMageListVo> findPage(ChinaStandardTypeMagePagePo chinaStandardTypeMagePagePo);

    /**
     * 列表查询
     */
    List<ChinaStandardTypeMageListVo> findList(ChinaStandardTypeMageListPo chinaStandardTypeMageListPo);
    /**
     * 树形列表查询
     * @param chinaStandardTypeMageTreePo
     * @return
     */
    List<ChinaStandardTypeMageTreeVo> ChinaStandardTypeMageGetTree(ChinaStandardTypeMageTreePo chinaStandardTypeMageTreePo);

    /**
     * 获取ChinaStandardTypeMage对象
     * @param delId
     * @return
     */
    ChinaStandardTypeMage getOne(Long delId);

    /**
     * 根据PID获取List
     * @param delId
     * @return
     */
    List<ChinaStandardTypeMage> findChinaStandardTypeMagePidByid(Long delId);
   @Select("select * from china_standard_type_mage where pid=#{id} and del_flag=0 ORDER BY sort")
    List<ChinaStandardTypeMageTreeVo> asyTreeVue(Long id);
    @Select("select * from china_standard_type_mage where id=#{id} and del_flag=0 ORDER BY sort")
    ChinaStandardTypeMageTreeVo asyTreeVuePS(Long id);

    int deleteByPid(Long id);
}
