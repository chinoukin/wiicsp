package com.wisea.cultivar.supply.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.supply.entity.SerListOpreateInfo;
import com.wisea.cultivar.supply.po.SerGetPo;
import com.wisea.cultivar.supply.vo.SerOpreateInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SerListOpreateInfoMapper extends CrudDao<SerListOpreateInfo> {

    /**
     * 服务单日志
     */
    SerOpreateInfoVo findSerLog(SerGetPo serGetPo);
}
