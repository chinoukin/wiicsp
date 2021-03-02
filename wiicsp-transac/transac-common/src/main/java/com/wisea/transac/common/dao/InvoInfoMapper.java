package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.InvoInfo;
import com.wisea.transac.common.po.InvoInfoPageListPo;
import com.wisea.transac.common.vo.InvoInfoInfoVo;
import com.wisea.transac.common.vo.InvoInfoPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InvoInfoMapper extends CrudDao<InvoInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询InvoInfo
     */
    List<InvoInfoPageListVo> findPageList(InvoInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息InvoInfo
     */
    InvoInfoInfoVo findInfo(LongIdPo po);

    /**
     * 根据会员ID查询默认发票
     * @param membId
     * @return
     */
    InvoInfoInfoVo selDefaultInvoByMembId(Long membId);

}
