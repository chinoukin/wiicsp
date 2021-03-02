package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.CommAttriSet;
import com.wisea.transac.common.po.CommAttriSetPageListPo;
import com.wisea.transac.common.po.product.CommAttriSetGetPo;
import com.wisea.transac.common.po.product.CommAttriSetPagePo;
import com.wisea.transac.common.vo.CommAttriSetInfoVo;
import com.wisea.transac.common.vo.CommAttriSetPageListVo;
import java.util.List;
import java.util.Map;

import com.wisea.transac.common.vo.product.CommAttriMageListVo;
import com.wisea.transac.common.vo.product.CommAttriSetGetVo;
import com.wisea.transac.common.vo.product.CommAttriSetListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommAttriSetMapper extends CrudDao<CommAttriSet> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询CommAttriSet
     */
    List<CommAttriSetPageListVo> findPageList(CommAttriSetPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息CommAttriSet
     */
    CommAttriSetInfoVo findInfo(LongIdPo po);

    /**
     * 校验是否和属性设置关联
     * @param id
     * @return
     */
    List<CommAttriSet> selectCommAttriById(Long id);

    /**
     * 属性设置列表
     * */
    List<CommAttriSetListVo> commAttriSetList(CommAttriSetPagePo po);

    /**
     * 根据商品信息查询属性设置列表
     * @param paramMap
     * @return
     */
    List<CommAttriMageListVo> findAttSetListByCommId(Map<String, Object> paramMap);

    /**
     * 编辑商品分类属性设置
     * */
    CommAttriSetGetVo editCommAttriSet(CommAttriSetGetPo po);

    /**
     * 如果不等于NULL的话直接用当前商品分类ID去查询
     */
    List<CommAttriSet> findAttriByCommId(List<Long> parentIdList);

    /**
     * 如果等于NULL的话直接用当前商品分类ID去查询
     */
    List<CommAttriSet> findDecideByCommId(Long commId);
}
