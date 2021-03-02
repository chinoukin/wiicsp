package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.CgsNameMage;
import com.wisea.cultivar.common.po.bigdata.CgsNameMageListPo;
import com.wisea.cultivar.common.po.bigdata.CgsNameMagePagePo;
import com.wisea.cultivar.common.vo.bigdata.CgsNameMageListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * cgs_name_mage 表DAO
 * 采购商名录管理
 * 2019/12/02 11:02:14
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface CgsNameMageMapper extends CrudDao<CgsNameMage> {
    List<CgsNameMageListVo> findPage(CgsNameMagePagePo cgsNameMagePagePo);

    List<CgsNameMageListVo> findList(CgsNameMageListPo cgsNameMageListPo);

    /**
     * 根据IDS批量删除
     * @param ids
     */
    void delByIds (@Param("ids") String ids);

    /**
     * 校验名称是否重复
     * @param cgsNameMageListPo
     * @return
     */
    CgsNameMageListVo checkName(CgsNameMageListPo cgsNameMageListPo);
}
