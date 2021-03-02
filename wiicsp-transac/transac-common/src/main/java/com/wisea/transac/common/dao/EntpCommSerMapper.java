package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.EntpCommSer;
import com.wisea.transac.common.po.system.EntpCommSerPageListPo;
import com.wisea.transac.common.vo.system.EntpCommSerInfoVo;
import com.wisea.transac.common.vo.system.EntpCommSerPageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EntpCommSerMapper extends CrudDao<EntpCommSer> {
    /**
     * @author wbf-code-generator
     * @date 2020/12/11 14:20:00
     * @Description 分页查询EntpCommSer
     */
    List<EntpCommSerPageListVo> findPageList(EntpCommSerPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/12/11 14:20:00
     * @Description 查询详细信息EntpCommSer
     */
    EntpCommSerInfoVo findInfo(LongIdPo po);
}
