package com.wisea.cultivar.supply.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.supply.entity.SerListInformation;

public interface SerListInformationMapper extends CrudDao<SerListInformation> {

    //统计未读总数
    Integer countInformation(Long id);

    //未读转为已读
    void toRead(Long id);

    void updateState(LongIdPo po);

}
