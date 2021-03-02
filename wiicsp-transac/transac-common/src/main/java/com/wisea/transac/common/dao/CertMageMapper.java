package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.CertMage;
import com.wisea.transac.common.po.seller.CertMagePageListPo;
import com.wisea.transac.common.vo.seller.CertMageInfoVo;
import com.wisea.transac.common.vo.seller.CertMagePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CertMageMapper extends CrudDao<CertMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询CertMage
     */
    List<CertMagePageListVo> findPageList(CertMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息CertMage
     */
    CertMageInfoVo findInfo(LongIdPo po);

    /**
     * 根据查询重名的数据
     * @param po
     * @return
     */
    Integer findByCertName(CertMage po);
}
