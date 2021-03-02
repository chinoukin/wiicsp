package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.RealPersonAuth;
import com.wisea.transac.common.po.RealPersonAuthPageListPo;
import com.wisea.transac.common.vo.RealPersonAuthInfoVo;
import com.wisea.transac.common.vo.RealPersonAuthPageListVo;
import com.wisea.transac.common.vo.memb.MembPersonDetailBackVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RealPersonAuthMapper extends CrudDao<RealPersonAuth> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询RealPersonAuth
     */
    List<RealPersonAuthPageListVo> findPageList(RealPersonAuthPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息RealPersonAuth
     */
    RealPersonAuthInfoVo findInfo(LongIdPo po);

    /**
     * 查询个人认证信息根据用户ID
     * @param id
     * @return
     */
    RealPersonAuthInfoVo findInfoByUserId(Long id);
    /**
     * 后台获取个人认证详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月29日
     * @version 1.0
     */
    public MembPersonDetailBackVo getPersonMembDetail(Long id);

    /**
     * 根据用户ID和身份证查询
     * @param entity
     * @return
     */
    RealPersonAuthInfoVo queryInfo(RealPersonAuth entity);
}
