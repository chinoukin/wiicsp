package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.IndBusiAuth;
import com.wisea.transac.common.po.IndBusiAuthPageListPo;
import com.wisea.transac.common.vo.IndBusiAuthInfoVo;
import com.wisea.transac.common.vo.IndBusiAuthPageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IndBusiAuthMapper extends CrudDao<IndBusiAuth> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询IndBusiAuth
     */
    List<IndBusiAuthPageListVo> findPageList(IndBusiAuthPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息IndBusiAuth
     */
    IndBusiAuthInfoVo findInfo(LongIdPo po);

    /**
     * 根据用户ID查询个体工商户认证信息
     * @param id
     * @return
     */
    IndBusiAuthInfoVo findInfoByUserId(Long id);
}
