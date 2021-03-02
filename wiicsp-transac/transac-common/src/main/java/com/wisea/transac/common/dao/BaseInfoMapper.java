package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.BaseInfo;
import com.wisea.transac.common.po.seller.BaseInfoPagePo;
import com.wisea.transac.common.po.seller.FindBaseInfoPo;
import com.wisea.transac.common.po.seller.RecBaseInfoPo;
import com.wisea.transac.common.vo.seller.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BaseInfoMapper extends CrudDao<BaseInfo> {
    /**
     * @author jirg
     * @date 2020/7/3 14:34
     * @Description 查询基地首页信息
     */
    BaseInfoHomeVo findBaseHome(@Param("membId") Long membId);

    /**
     * @author jirg
     * @date 2020/6/30 14:00
     * @Description 根据用户查询基地信息
     */
    BaseInfoVo findByMembId(@Param("membId") Long membId);

    /**
     * 根据基地id查询基地详情
     * @param baseId
     * @return
     */
    BaseInfoVo findBaseInfoById(@Param("id") Long baseId);

    /**
     * 分页查询
     * @param po
     * @return
     */
    List<BaseInfoVo> findForPage(BaseInfoPagePo po);

    BaseInfoVo baseInfoAndCont(Long id);

    /**
     * 国内基地省份及基地数量查询
     * @return
     */
    List<BaseListVo> findAllAndCount();

    /**
     * 查询详情
     * @param po
     * @return
     */
    FindBaseInfoVo findByid(FindBaseInfoPo po);

    /**
     * 查询推荐基地根据基地ID和经纬度
     * @param po
     * @return
     */
    List<RecBaseInfoVo> findRecBaseByid(RecBaseInfoPo po);
}
