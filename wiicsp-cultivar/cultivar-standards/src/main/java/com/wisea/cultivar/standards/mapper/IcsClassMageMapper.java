package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.IcsClassMage;
import com.wisea.cultivar.standards.po.IcsClassMageListPo;
import com.wisea.cultivar.standards.po.IcsClassMagePagePo;
import com.wisea.cultivar.standards.po.IcsClassMageTreePo;
import com.wisea.cultivar.standards.vo.IcsClassMageListVo;
import com.wisea.cultivar.standards.vo.IcsClassMageTreeVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ics_class_mage 表DAO
 * ICS分类管理
 * 2020/07/24 11:21:45
 */
public interface IcsClassMageMapper extends CrudDao<IcsClassMage> {
    /**
     * 分页查询
     */
    List<IcsClassMageListVo> findPage(IcsClassMagePagePo icsClassMagePagePo);

    /**
     * 列表查询
     */
    List<IcsClassMageListVo> findList(IcsClassMageListPo icsClassMageListPo);

    /**
     * 获取树形数据
     * @param icsClassMageTreePo
     * @return
     */
    List<IcsClassMageTreeVo> icsClassMageGetTree(IcsClassMageTreePo icsClassMageTreePo);

    /**
     * 获取ChinaStandardTypeMage对象
     * @param delId
     * @return
     */
    IcsClassMage getOne(Long delId);

    /**
     * 根据PID获取List
     * @param delId
     * @return
     */
    List<IcsClassMage> findicsClassMagePidByid(Long delId);
    @Select("select * from ics_class_mage where pid=#{id} and del_flag=0 ORDER BY sort")
    List<IcsClassMageTreeVo> asyTreeVue(Long id);
    @Select("select * from ics_class_mage where id=#{id} and del_flag=0")
    IcsClassMageTreeVo asyTreeVuePS(Long id);

    int deleteByPid(Long id);
}
