package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.ZhfwCommAttriSet;
import com.wisea.cultivar.common.po.CommAttriSetPageListPo;
import com.wisea.cultivar.common.po.product.CommAttriSetGetPo;
import com.wisea.cultivar.common.po.product.CommAttriSetPagePo;
import com.wisea.cultivar.common.vo.CommAttriSetInfoVo;
import com.wisea.cultivar.common.vo.CommAttriSetPageListVo;
import com.wisea.cultivar.common.vo.product.CommAttriMageListVo;
import com.wisea.cultivar.common.vo.product.CommAttriSetGetVo;
import com.wisea.cultivar.common.vo.product.CommAttriSetListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("NbCommAttriSetMapper")
public interface CommAttriSetMapper extends CrudDao<ZhfwCommAttriSet> {
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
    List<ZhfwCommAttriSet> selectCommAttriById(Long id);

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
    List<ZhfwCommAttriSet> findAttriByCommId(List<Long> parentIdList);

    /**
     * 如果等于NULL的话直接用当前商品分类ID去查询
     */
    List<ZhfwCommAttriSet> findDecideByCommId(Long commId);

    List<CommAttriSetListVo> findTwoLevelList(CommAttriSetPagePo po);
}
