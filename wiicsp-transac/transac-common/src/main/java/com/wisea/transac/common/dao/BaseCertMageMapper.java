package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.BaseCertMage;
import com.wisea.transac.common.po.seller.BaseCertMagePo;
import com.wisea.transac.common.vo.seller.BaseCertMageVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BaseCertMageMapper extends CrudDao<BaseCertMage> {
    /**
     * @author jirg
     * @date 2020/7/1 9:47
     * @Description 根据基地ID查询基地证书列表
     */
    List<BaseCertMageVo> findListByBaseId(LongIdPo po);

    /**
     * @author jirg
     * @date 2020/7/1 10:02
     * @Description 基地证书详细信息
     */
    BaseCertMageVo findBaseCertInfo(LongIdPo po);

    /**
     * @author jirg
     * @date 2020/7/1 10:10
     * @Description 查询基地证书信息
     */
    BaseCertMage findInfo(BaseCertMagePo po);
}
