package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.MrSerChargeMage;
import com.wisea.transac.common.po.system.MrSerChargeMageGetPo;
import com.wisea.transac.common.po.system.MrSerChargeMagePagePo;
import com.wisea.transac.common.vo.system.MrSerChargeMageGetVo;
import com.wisea.transac.common.vo.system.MrSerChargeMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MrSerChargeMageMapper extends CrudDao<MrSerChargeMage> {
    /**
     * 查询默认手续费的详情
     * @param mrSerChargeMageGetPo
     * @return
     */
    MrSerChargeMageGetVo findById(MrSerChargeMageGetPo mrSerChargeMageGetPo);

    /**
     * 重复性校验默认手续费
     * @param entity
     * @return
     */
    MrSerChargeMage checkSaveOrUpdateMrSerChargeMage(MrSerChargeMage entity);

    /**
     * 查询默认服务费列表
     * @param mrSerChargeMagePagePo
     * @return
     */
    List<MrSerChargeMageListVo> findSerChargeList(MrSerChargeMagePagePo mrSerChargeMagePagePo);
}
