package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.StorageInfo;
import com.wisea.transac.common.vo.BaseStatVo;
import com.wisea.transac.common.vo.seller.StorageInfoListVo;
import com.wisea.transac.common.vo.seller.StorageInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StorageInfoMapper extends CrudDao<StorageInfo> {
    /**
     * @author jirg
     * @date 2020/7/2 13:57
     * @Description 根据基地ID查询基地仓储列表
     */
    List<StorageInfoListVo> findListByBaseId(LongIdPo po);

    /**
     * @author jirg
     * @date 2020/7/2 14:18
     * @Description 查询仓储详细信息
     */
    StorageInfoVo findStorageInfo(LongIdPo po);

    List<StorageInfo> findAllByBaseId(Long baseId);

    BaseStatVo countAndAreaSum(Long baseId);

}
