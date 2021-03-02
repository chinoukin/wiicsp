package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.AgentSerList;
import com.wisea.transac.common.po.AgentSerListPageListPo;
import com.wisea.transac.common.vo.AgentSerListInfoVo;
import com.wisea.transac.common.vo.AgentSerListPageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AgentSerListMapper extends CrudDao<AgentSerList> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询AgentSerList
     */
    List<AgentSerListPageListVo> findPageList(AgentSerListPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息AgentSerList
     */
    AgentSerListInfoVo findInfo(LongIdPo po);
}
