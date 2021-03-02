package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.RealPersonAuth;
import com.wisea.cultivar.plant.po.RealPersonAuthPageListPo;
import com.wisea.cultivar.plant.vo.RealPersonAuthInfoVo;
import com.wisea.cultivar.plant.vo.RealPersonAuthPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RealPersonAuthMapper extends CrudDao<RealPersonAuth> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询RealPersonAuth
     */
    List<RealPersonAuthPageListVo> findPageList(RealPersonAuthPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息RealPersonAuth
     */
    RealPersonAuthInfoVo findInfo(LongIdPo po);

    // 条件查询
    List<RealPersonAuth> findInfoByConditions(RealPersonAuth realPersonAuth);

    /**
     * 通过用户删除个人认证信息
     */
    void deleteLogicByMembId(Long membId);
}
