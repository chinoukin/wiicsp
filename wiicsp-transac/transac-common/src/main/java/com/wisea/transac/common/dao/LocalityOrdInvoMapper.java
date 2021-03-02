package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.LocalityOrdInvo;
import com.wisea.transac.common.vo.OrdInvoInfoVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LocalityOrdInvoMapper extends CrudDao<LocalityOrdInvo> {

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息OrdInvo
     */
    OrdInvoInfoVo findInfo(LongIdPo po);
}
