package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.IndBusiBankInfo;
import com.wisea.transac.common.po.IndBusiBankInfoPageListPo;
import com.wisea.transac.common.vo.IndBusiBankInfoInfoVo;
import com.wisea.transac.common.vo.IndBusiBankInfoPageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IndBusiBankInfoMapper extends CrudDao<IndBusiBankInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询IndBusiBankInfo
     */
    List<IndBusiBankInfoPageListVo> findPageList(IndBusiBankInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息IndBusiBankInfo
     */
    IndBusiBankInfoInfoVo findInfo(LongIdPo po);
}
