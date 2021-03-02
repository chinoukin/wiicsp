package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.CommTree;
import com.wisea.cultivar.common.entity.tp.PjcsmxMage;
import com.wisea.cultivar.common.po.tp.product.PjcsmxMagePo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.product.PjcsmxMageGetVo;
import com.wisea.cultivar.common.vo.tp.product.PjcsmxMageListVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * pjcsmx_mage 表DAO
 * 评价参数模型管理
 * 2019/06/05 10:28:32
 */
@Repository
public interface PjcsmxMageMapper extends CrudDao<PjcsmxMage> {

    /**
     * 后台评价列表信息查询
     * @param po
     * @return
     */
    List<PjcsmxMageListVo> selectList(PjcsmxMagePo po);

    /**
     * 插入前查询
     * @return
     */
    List<CommTree> beforeInsertGetCatgList();

    /**
     * 属性字段的唯一验证
     * @param po
     * @return
     */
    List<PjcsmxMageGetVo> getAttriColumnOnlyState(PjcsmxMage po);

    /**
     * 属性类表
     * @return
     */
    List<PjcsmxMageGetVo> beforeInsertAttriList();

}
