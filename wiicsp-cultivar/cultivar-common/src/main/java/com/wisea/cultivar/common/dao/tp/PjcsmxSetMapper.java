package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.PjcsmxSet;
import com.wisea.cultivar.common.po.tp.CommAttriSetGetPo;
import com.wisea.cultivar.common.po.tp.product.PjcsmxSetPagePo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.product.PjcsmxMageListVo;
import com.wisea.cultivar.common.vo.tp.product.PjcsmxSetGetVo;
import com.wisea.cultivar.common.vo.tp.product.PjcsmxSetListVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * pjcsmx_set 表DAO
 * 评价参数模型设置
 * 2019/06/05 10:28:32
 */
@Repository
public interface PjcsmxSetMapper extends CrudDao<PjcsmxSet> {

    /**
     * 检验是否关联了设置
     * @param id
     * @return
     */
    List<PjcsmxSet> selectCommAttriById(Long id);

    /**
     * 属性设置列表
     *
     */
    List<PjcsmxSetListVo> commAttriSetList(PjcsmxSetPagePo po);

    /**
     * 如果等于NULL的话直接用当前商品分类ID去查询
     * @param commId
     * @return
     */
    List<PjcsmxSet> findDecideByCommId(Long commId);

    /**
     * 如果不等于NULL的查询父类id
     * @return
     */
    List<PjcsmxSet> findAttriByCommId(List<Long> parentIdList);

    /**
     * 编辑商品分类属性设置
     */
    PjcsmxSetGetVo editCommAttriSet(CommAttriSetGetPo po);

    /**
     * 通过商品分类ID去查询属性ID
     */
    List<PjcsmxMageListVo> getAttriIdByCommId(Map<String, Object> paramMap);

    /**
     * 通过属性ID去查询属性值
     */
    List<PjcsmxMageListVo> findCommAttSetListByAttriId(List<PjcsmxSetGetVo> attriIdList);

}
