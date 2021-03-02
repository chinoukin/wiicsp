package com.wisea.transac.common.dao;


import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.PortMage;
import com.wisea.transac.common.po.PortMagePagePo;
import com.wisea.transac.common.vo.PortMageVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PortMageMapper extends CrudDao<PortMage> {

    List<PortMageVo> findForPages(PortMagePagePo po);

    List<PortMageVo> findAll();

    PortMageVo findById(Long id);

}
