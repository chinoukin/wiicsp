package com.wisea.cultivar.common.dao.tp;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.tp.CurrencyRetrospInfo;
import com.wisea.cultivar.common.vo.tp.retro.RetroTemplateVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRetrospInfoMapper extends CrudDao<CurrencyRetrospInfo> {

    /**
     * 按用户ID查询
     * @param membId
     * @return
     */
    List<RetroTemplateVo> findByMembId(Long membId);

}
