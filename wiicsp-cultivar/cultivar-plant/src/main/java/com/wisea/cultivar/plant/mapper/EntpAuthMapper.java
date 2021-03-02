package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.EntpAuth;
import com.wisea.cultivar.plant.po.EntpAuthPageListPo;
import com.wisea.cultivar.plant.vo.EntpAuthInfoVo;
import com.wisea.cultivar.plant.vo.EntpAuthPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("zhfwEntpAuthMapper")
public interface EntpAuthMapper extends CrudDao<EntpAuth> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询EntpAuth
     */
    List<EntpAuthPageListVo> findPageList(EntpAuthPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息EntpAuth
     */
    EntpAuthInfoVo findInfo(LongIdPo po);

    // 条件查询
    List<EntpAuth> findInfoByConditions(EntpAuth entpAuth);

    /**
     * 删除用户企业认证
     */
    void deleteLogicByMembId(Long membId);
}
