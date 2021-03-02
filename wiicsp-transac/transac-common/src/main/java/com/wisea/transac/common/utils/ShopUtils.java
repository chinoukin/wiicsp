package com.wisea.transac.common.utils;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.dao.EntpAuthMapper;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.dao.ShopInfoMapper;
import com.wisea.transac.common.dao.StallsMageMapper;
import com.wisea.transac.common.entity.ShopInfo;
import com.wisea.transac.common.vo.EntpAuthInfoVo;
import com.wisea.transac.common.vo.MembInfoInfoVo;
import com.wisea.transac.common.vo.seller.ShopInfoInfoVo;
import com.wisea.transac.common.vo.seller.StallsMageListVo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wangjiahao
 * @since 2020/5/22 10:08 上午
 */
public class ShopUtils {
    private static ShopInfoMapper shopInfoMapper = SpringBootContext.getBean(ShopInfoMapper.class);
    private static MembInfoMapper membInfoMapper = SpringBootContext.getBean(MembInfoMapper.class);
    private static StallsMageMapper stallsMageMapper = SpringBootContext.getBean(StallsMageMapper.class);
    private static EntpAuthMapper entpAuthMapper = SpringBootContext.getBean(EntpAuthMapper.class);

    /**
     * 根据店铺id查询店铺的商户id（会员id）
     *
     * @param shopId 店铺id
     *
     * @return 商户id（会员id），如果没有返回null
     */
    public static Long getShopMerchantId(Long shopId) {
        ShopInfo shopInfo = shopInfoMapper.selectByPrimaryKey(shopId);
        if (shopInfo == null) {
            return null;
        }
        return shopInfo.getMerchantId();
    }

    /**
     * 根据店铺id查询店铺会员信息
     *
     * @param shopId 店铺id
     *
     * @return {@link MembInfoInfoVo} 会员信息，没有时返回空
     */
    public static MembInfoInfoVo getShopMembInfo(Long shopId) {
        Long merchantId = getShopMerchantId(shopId);
        if (merchantId == null) {
            return null;
        }
        LongIdPo idPo = new LongIdPo();
        idPo.setId(merchantId);
        return membInfoMapper.findInfo(idPo);
    }

    /**
     * 根据 会员id 查询店铺的基本信息
     *
     * @param membId 会员id，可以是店铺商户id和档口员工id
     *
     * @return {@link ShopInfoInfoVo} 店铺基本信息
     */
    public static ShopInfoInfoVo getShopInfo(Long membId) {
        ShopInfoInfoVo shopInfo;
        shopInfo = shopInfoMapper.findInfoByMerchantId(membId);
        //不是店铺商户id
        if (shopInfo == null) {
            List<StallsMageListVo> list = stallsMageMapper.findByMembId(membId);
            if (list.size() == 0) {
                return null;
            }
            LongIdPo idPo = new LongIdPo();
            idPo.setId(list.get(0).getShopId());
            shopInfo = shopInfoMapper.findInfo(idPo);
        }
        return shopInfo;
    }

    /**
     * 根据市场id查询所有店铺信息
     * @param marketId
     * @return
     */
    public static List<ShopInfoInfoVo> getShopByMarketId(Long marketId) {
        List<EntpAuthInfoVo> info = entpAuthMapper.findInfoByMarketId(marketId);
        return info.stream()
                .map(i -> shopInfoMapper.findInfoByMerchantId(i.getMembId()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
