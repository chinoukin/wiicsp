package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.YhSerChargeMage;
import com.wisea.transac.common.po.system.YhSerChargeMageGetPo;
import com.wisea.transac.common.po.system.YhSerChargeMagePagePo;
import com.wisea.transac.common.vo.system.YhSerChargeMageGetVo;
import com.wisea.transac.common.vo.system.YhSerChargeMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface YhSerChargeMageMapper extends CrudDao<YhSerChargeMage> {
    /**
     * 优惠服务费重复性
     * @param yhSerChargeMage
     * @return
     */
    YhSerChargeMage checkSaveOrUpdateYhSerChargeMage(YhSerChargeMage yhSerChargeMage);

    /**
     * 优惠服务费详情
     * @param yhSerChargeMageGetPo
     * @return
     */
    YhSerChargeMageGetVo findById(YhSerChargeMageGetPo yhSerChargeMageGetPo);

    /**
     * 优惠服务费列表
     * @param yhSerChargeMagePagePo
     * @return
     */
    List<YhSerChargeMageListVo> findYhSerChargeList(YhSerChargeMagePagePo yhSerChargeMagePagePo);
}
