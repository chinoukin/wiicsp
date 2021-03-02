package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.SortingFactory;
import com.wisea.transac.common.po.seller.SortingFactoryListVo;
import com.wisea.transac.common.vo.BaseStatVo;
import com.wisea.transac.common.vo.seller.SortingFactoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SortingFactoryMapper extends CrudDao<SortingFactory> {
    /**
     * @author jirg
     * @date 2020/7/1 14:54
     * @Description 根据基地ID查询分选工厂列表
     */
    List<SortingFactoryListVo> findListByBaseId(LongIdPo baseId);
    List<SortingFactoryVo> findListByBaseIdForBuyer(LongIdPo baseId);

    /**
     * @author jirg
     * @date 2020/7/2 9:52
     * @Description 查询分选工厂详细信息
     */
    SortingFactoryVo findSortingFactoryInfo(LongIdPo po);

    List<SortingFactory> findAllByBaseId(Long baseId);

    BaseStatVo countAndAreaSum(Long baseId);

}
