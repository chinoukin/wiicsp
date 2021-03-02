package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.PlatfFreightFormworkMage;
import com.wisea.cultivar.common.po.tp.PlatfFreightFormworkMageListPo;
import com.wisea.cultivar.common.po.tp.PlatfFreightFormworkMagePagePo;
import com.wisea.cultivar.common.vo.tp.PlatfFreightFormworkMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * platf_freight_formwork_mage 表DAO
 * 平台运费模板管理
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
@Repository
public interface PlatfFreightFormworkMageMapper extends CrudDao<PlatfFreightFormworkMage> {
    List<PlatfFreightFormworkMageListVo> findPage(PlatfFreightFormworkMagePagePo platfFreightFormworkMagePagePo);

    List<PlatfFreightFormworkMageListVo> findList(PlatfFreightFormworkMageListPo platfFreightFormworkMageListPo);

    /**
     * 分页查询
     * @param platfFreightFormworkMagePagePo
     * @return
     */
    List<PlatfFreightFormworkMageListVo> findForPage(PlatfFreightFormworkMagePagePo platfFreightFormworkMagePagePo);

    /**
     * 按模板名称查询--模糊查询
     * @param formworkName
     * @return
     */
    List<PlatfFreightFormworkMageListVo> findByFormworkName(@Param("formworkName") String formworkName);

    /**
     * 按ID查询
     * @param id
     * @return
     */
    PlatfFreightFormworkMageListVo findById(@Param("id") Long id);

    /**
     * 按ID集合查询是否存在记录，返回ID
     * @param ids
     * @return
     */
    List<Long> findIdByIds(List<Long> ids);

    /**
     * 查询所有
     * @return
     */
    List<PlatfFreightFormworkMageListVo> findAll();

}
