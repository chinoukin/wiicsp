package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.LevelSpecQuote;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;


/**
 * level_spec_quote 表DAO
 * 等级规格报价
 * 2019/08/20 10:18:34
 * <p>
 * 分页查询
 */
public interface LevelSpecQuoteMapper extends CrudDao<LevelSpecQuote> {

    /**
     * 根据商品id，等级规格查询
     *
     * @param po
     * @return
     */
    LevelSpecQuote selBySpecAndLevel(LevelSpecQuote po);

    /**
     * 删除按等级报价信息
     *
     * @param id
     */
    void delByCommPubInfoId(Long id);

    /**
     * 根据商品发布id查询报等级价信息
     *
     * @param po
     * @return
     */
    List<LevelSpecQuote> commPubLevelPrice(LevelSpecQuote po);
}
