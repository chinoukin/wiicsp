package com.wisea.transac.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.entity.WholeSaleMarketMage;
import com.wisea.transac.common.po.WholeSaleMarketMagePageListPo;
import com.wisea.transac.common.po.WholeSaleMarketMagePo;
import com.wisea.transac.common.po.system.MarketRankPo;
import com.wisea.transac.common.vo.WholeSaleMarketMageInfoVo;
import com.wisea.transac.common.vo.WholeSaleMarketMagePageListVo;
import com.wisea.transac.common.vo.memb.MaketInfoListVo;
import com.wisea.transac.common.vo.system.MarketRankVo;

@Mapper
@Repository
public interface WholeSaleMarketMageMapper extends CrudDao<WholeSaleMarketMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询WholeSaleMarketMage
     */
    List<WholeSaleMarketMagePageListVo> findPageList(WholeSaleMarketMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息WholeSaleMarketMage
     */
    WholeSaleMarketMageInfoVo findInfo(LongIdPo po);

    /**
     * 按ID查询具体信息，并根据wx坐标点查询距离
     * @param po
     * @return
     */
    WholeSaleMarketMageInfoVo findInfoWithDistance(WholeSaleMarketMagePo po);

    /**
     * 根据微信坐标查询距离最近的一个市场
     * @param po
     * @return
     */
    WholeSaleMarketMageInfoVo findClosestInfoWithDistance(WholeSaleMarketMagePo po);

    /**
     * 查询批发市场排名
     * @param po
     * @return
     */
    List<MarketRankVo> findMarketRank(MarketRankPo po);

    /**
     * 根据市场id查询会员列表
     * @param marketId
     * @return
     */
    List<MembInfo> findMembIdByMarketId(Long marketId);
    /**
     * 查询全部市场信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月27日
     * @version 1.0
     */
    public List<MaketInfoListVo> findMarketAllList(String marketName);
}
