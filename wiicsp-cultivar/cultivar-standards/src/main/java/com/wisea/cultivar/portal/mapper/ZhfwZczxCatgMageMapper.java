package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.portal.entity.ZhfwZczxCatgMage;
import com.wisea.cultivar.portal.po.ZhfwZczxCatgMageListPo;
import com.wisea.cultivar.portal.po.ZhfwZczxCatgMagePagePo;
import com.wisea.cultivar.portal.vo.ZhfwZczxCatgMageListVo;
import com.wisea.cultivar.portal.vo.ZhfwZczxCatgMageTreeVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * zhfw_zczx_catg_mage 表DAO
 * 种植服务资料分类管理
 * 2020/08/24 20:28:13
 */
@Component
public interface ZhfwZczxCatgMageMapper extends CrudDao<ZhfwZczxCatgMage> {
    /**
     * 分页查询
     */
    List<ZhfwZczxCatgMageListVo> findPage(ZhfwZczxCatgMagePagePo zhfwZczxCatgMagePagePo);

    /**
     * 列表查询
     */
    List<ZhfwZczxCatgMageListVo> findList(ZhfwZczxCatgMageListPo zhfwZczxCatgMageListPo);

    /**
    * 根据id查询pid
    * Author: xiehy
    * Date: 2020/8/27 10:54
    */
    List<ZhfwZczxCatgMage> findZhfwZczxCatgMagePidByid(Long id);

    ZhfwZczxCatgMage getOne(Long delId);

    int deleteByPid(Long id);

    List<ZhfwZczxCatgMageTreeVo> findTree(ZhfwZczxCatgMageListPo zhfwZczxCatgMageListPo);
}
