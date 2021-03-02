package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.HelpListMage;
import com.wisea.cultivar.common.po.tp.HelpListMageListPo;
import com.wisea.cultivar.common.po.tp.HelpListMagePagePo;
import com.wisea.cultivar.common.vo.tp.HelpListMageListVo;
import com.wisea.cultivar.common.vo.tp.HelpMenuListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * help_list_mage 表DAO
 * 帮助列表管理
 * 2018/10/29 10:29:10
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface HelpListMageMapper extends CrudDao<HelpListMage> {
    List<HelpListMageListVo> findPage(HelpListMagePagePo helpListMagePagePo);

    List<HelpListMageListVo> findList(HelpListMageListPo helpListMageListPo);

    /**
     * 分页查询
     * @param helpListMagePagePo
     * @return
     */
    List<HelpListMageListVo> findForPage(HelpListMagePagePo helpListMagePagePo);

    /**
     * 查询所有标题，和分类信息
     * @return
     */
    List<HelpMenuListVo> findForList();

    /**
     * 按名称查询帮助信息
     * @param title
     * @return
     */
    HelpListMageListVo findByTitle(@Param("title") String title);

    /**
     * 判断是否存在标题
     * @param title
     * @return
     */
    int existTitle(String title);
    /**
     * 判断是否存在标题
     * @return
     */
    int existTitleById(Map<String,Object> map);
}
