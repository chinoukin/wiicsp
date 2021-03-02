package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.LogisticsCompMage;
import com.wisea.transac.common.po.LogisticsCompMagePageListPo;
import com.wisea.transac.common.vo.LogisticsCompMageInfoVo;
import com.wisea.transac.common.vo.LogisticsCompMagePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LogisticsCompMageMapper extends CrudDao<LogisticsCompMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询LogisticsCompMage
     */
    List<LogisticsCompMagePageListVo> findPageList(LogisticsCompMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息LogisticsCompMage
     */
    LogisticsCompMageInfoVo findInfo(LongIdPo po);

    List<LogisticsCompMagePageListVo> findList(LogisticsCompMagePageListPo po);

    List<LogisticsCompMagePageListVo> findByName(@Param("name") String name);
}
