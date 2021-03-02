package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.BuySproutInfo;
import com.wisea.cultivar.plant.po.BuySproutInfoPageListPo;
import com.wisea.cultivar.plant.vo.BuySproutInfoInfoVo;
import com.wisea.cultivar.plant.vo.BuySproutInfoPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BuySproutInfoMapper extends CrudDao<BuySproutInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/11 16:55:39
     * @Description 分页查询BuySproutInfo
     */
    List<BuySproutInfoPageListVo> findPageList(BuySproutInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/11 16:55:39
     * @Description 查询详细信息BuySproutInfo
     */
    BuySproutInfoInfoVo findInfo(LongIdPo po);

    void deleteByMageId(Long id);
}
