package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.MarketAcctNumMage;
import com.wisea.cultivar.common.po.memb.MarketAdminInfoPagePo;
import com.wisea.cultivar.common.po.memb.PlatFormUserPagePo;
import com.wisea.cultivar.common.vo.MarketAcctNumMageInfoVo;
import com.wisea.cultivar.common.vo.memb.MarketAdminInfoVo;
import com.wisea.cultivar.common.vo.memb.PlatFormUserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MarketAcctNumMageMapper extends CrudDao<MarketAcctNumMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询MarketAcctNumMage
     */
    List<PlatFormUserInfoVo> findPageList(PlatFormUserPagePo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息MarketAcctNumMage
     */
    MarketAcctNumMageInfoVo findInfo(LongIdPo po);
    /**
     * 根据Id查询市场管理员基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月7日
     * @version 1.0
     */
    public MarketAdminInfoVo getMarketAdminInfo(Long id);
    /**
     * 分页查询市场管理员相关的信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月7日
     * @version 1.0
     */
    public List<MarketAdminInfoVo> findMarketAdminList(MarketAdminInfoPagePo marketAdminInfoPagePo);
    /**
     * 通过批发市场ID查询市场管理员信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月8日
     * @version 1.0
     */
    public MarketAcctNumMage getMarketAcctByMarketId(Long marketId);
    /**
     * 根据用户名称获取市场人员或者运营平台人员信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月11日
     * @version 1.0
     */
    public MarketAcctNumMage getMarketAcctInfo(String loginName);
}
