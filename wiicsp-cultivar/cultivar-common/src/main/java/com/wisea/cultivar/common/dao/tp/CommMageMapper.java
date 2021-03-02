package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.CommMage;
import com.wisea.cultivar.common.po.tp.CommMagePagePo;
import com.wisea.cultivar.common.po.tp.CommMageTreePo;
import com.wisea.cultivar.common.vo.tp.CommMageListVo;
import com.wisea.cultivar.common.vo.tp.CommMageTreeVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * comm_mage 表DAO
 * 商品管理
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
@Repository
public interface CommMageMapper extends CrudDao<CommMage> {
    List<CommMageListVo> findPage(CommMagePagePo commMagePagePo);

    List<CommMageTreeVo> findList(CommMageTreePo commMageListPo);

    CommMage findParentId(Long commId);

    Integer selectCommPubCount(Long id);

    List<CommMage> listCommMage(CommMage po);

    List<CommMage> findListMage(CommMage po);

    Integer selectCommVaritPubCount(Long id);

    /**
     * 根据pid查询下面的所有品类信息
     * @param commId
     * @return
     */
    List<CommMage> findMageByParentId(Long commId);
}
