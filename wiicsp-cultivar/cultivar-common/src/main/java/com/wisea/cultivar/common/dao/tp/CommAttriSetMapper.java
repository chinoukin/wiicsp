package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.CommAttriSet;
import com.wisea.cultivar.common.po.tp.CommAttriSetGetPo;
import com.wisea.cultivar.common.po.tp.CommAttriSetListPo;
import com.wisea.cultivar.common.po.tp.CommAttriSetPagePo;
import com.wisea.cultivar.common.po.tp.CommMageGetPo;
import com.wisea.cultivar.common.vo.tp.CommAttriMageListVo;
import com.wisea.cultivar.common.vo.tp.CommAttriSetGetVo;
import com.wisea.cultivar.common.vo.tp.CommAttriSetListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;
import java.util.Map;

/**
 * comm_attri_set 表DAO
 * 商品属性设置
 * 2018/09/18 14:36:47
 * <p>
 * 分页查询
 * <p>
 * 分页查询
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface CommAttriSetMapper extends CrudDao<CommAttriSet> {
    List<CommAttriSetListVo> findPage(CommAttriSetPagePo commAttriSetPagePo);

    List<CommAttriSetListVo> findList(CommAttriSetListPo commAttriSetListPo);

    /*
     * 属性设置列表
     * */
    List<CommAttriSetListVo> commAttriSetList(CommAttriSetPagePo po);

    /*
     * 编辑商品分类属性设置
     * */
    CommAttriSetGetVo editCommAttriSet(CommAttriSetGetPo po);

    /*
     * 通过商品分类ID去查询属性ID
     * */
    List<CommAttriSetGetVo> getAttriIdByCommId(CommMageGetPo po);

    /**
     * 根据商品信息查询属性设置列表
     * @param paramMap
     * @return
     */
    List<CommAttriMageListVo> findAttSetListByCommId(Map<String, Object> paramMap);

    /*
     * 通过属性ID去查询属性值
     * */
    List<CommAttriMageListVo> findCommAttSetListByAttriId(List<CommAttriSetGetVo> attriIdList);

    //如果等于NULL的话直接用当前商品分类ID去查询
    List<CommAttriSet> findDecideByCommId(Long commId);

    //如果不等于NULL的话直接用当前商品分类ID去查询
    List<CommAttriSet> findAttriByCommId(List<Long> parentIdList);

    List<CommAttriSet> selectCommAttriById(Long id);
}
