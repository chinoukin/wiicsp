package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.CommAttri;
import com.wisea.cultivar.common.po.tp.CommAttriListPo;
import com.wisea.cultivar.common.po.tp.CommAttriPagePo;
import com.wisea.cultivar.common.vo.tp.CommAttriListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * comm_attri 表DAO
 * 商品属性值
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface CommAttriMapper extends CrudDao<CommAttri> {
    List<CommAttriListVo> findPage(CommAttriPagePo commAttriPagePo);

    List<CommAttriListVo> findList(CommAttriListPo commAttriListPo);

    void delByCommPubInfoId(Long id);
}
