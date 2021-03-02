package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.CommAttriMage;
import com.wisea.cultivar.common.entity.tp.CommTree;
import com.wisea.cultivar.common.po.tp.CommAttriMageListPo;
import com.wisea.cultivar.common.po.tp.CommAttriMagePagePo;
import com.wisea.cultivar.common.vo.tp.CommAttriMageGetVo;
import com.wisea.cultivar.common.vo.tp.CommAttriMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * comm_attri_mage 表DAO
 * 商品属性
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
@Repository
public interface CommAttriMageMapper extends CrudDao<CommAttriMage> {
    List<CommAttriMageListVo> findPage(CommAttriMagePagePo commAttriMagePagePo);

    List<CommAttriMageListVo> findList(CommAttriMageListPo commAttriMageListPo);

    List<CommAttriMageListVo> selectList(CommAttriMagePagePo po);

    List<CommTree> beforeInsertGetCatgList();

    List<CommAttriMageGetVo> beforeInsertAttriList();

    List<CommAttriMageGetVo> getAttriColumnOnlyState(CommAttriMage po);

    List<CommAttriMageListVo> findCommTree();

    /**
     * 根据品类id查询商品属性设置
     * @param id
     * @return
     */
    List<CommAttriMageListVo> findCommTreeSetList(Long id);

    CommAttriMageListVo selectDictVal(Long id);

}
