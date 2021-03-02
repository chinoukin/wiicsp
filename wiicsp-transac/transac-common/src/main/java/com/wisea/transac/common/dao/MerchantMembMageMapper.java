package com.wisea.transac.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.MerchantMembMage;
import com.wisea.transac.common.po.memb.MarketMembAddTjPo;
import com.wisea.transac.common.po.seller.SellerMembMageAddPo;
import com.wisea.transac.common.po.seller.SellerMembManagerPagePo;
import com.wisea.transac.common.po.trade.StaticOrderPo;
import com.wisea.transac.common.vo.MerchantMembMageInfoVo;
import com.wisea.transac.common.vo.memb.EchartStaticVo;
import com.wisea.transac.common.vo.seller.SellerMembMageAddVo;
import com.wisea.transac.common.vo.seller.SellerMembMagePageListVo;
import com.wisea.transac.common.vo.trade.CgsOrderVo;
import com.wisea.transac.common.vo.trade.StatisMembOrdVo;

@Mapper
@Repository
public interface MerchantMembMageMapper extends CrudDao<MerchantMembMage> {

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息MerchantMembMage
     */
    MerchantMembMageInfoVo findInfo(LongIdPo po);

    /**
     * 商家APP查询会员管理列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月2日
     * @version 1.0
     */
    public List<SellerMembMagePageListVo> findMerchantMembMageList(SellerMembManagerPagePo po);

    /**
     * @Description 根据买卖家查询会员设置
     **/
    MerchantMembMage findByIds(@Param("merchantId") Long merchantId, @Param("membId") Long membId);

    /**
     * @Description 根据买卖家查询会员设置
     **/
    List<MerchantMembMage> findListByIds(@Param("merchantId") Long merchantId, @Param("membId") Long membId);

    /**
     * 查询商家会员数量
     * @param merchantId
     * @return
     */
    Integer selMembCount (@Param("merchantId") Long merchantId);

    /**
     * 查询商家有订单会员数量
     * @param merchantId
     * @return
     */
    Integer selOrdMembCount (@Param("merchantId") Long merchantId);

    /**
     * 查询商家有订单会员统计
     * @param merchantId
     * @return
     */
    StatisMembOrdVo selOrdStatic (@Param("merchantId") Long merchantId);

    /**
     * 采购商排名统计
     * @param merchantId
     * @return
     */
    List<CgsOrderVo> cgsOrdStatic (StaticOrderPo po);

    /**
     * 供应商排名统计
     * @param merchantId
     * @return
     */
    List<CgsOrderVo> gysOrdStatic (StaticOrderPo po);

    /**
     * 获取会员信息并且验证是否可以添加
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月3日
     * @version 1.0
     */
    public SellerMembMageAddVo getSellerMembCheck(SellerMembMageAddPo po);
    /**
     * 运营市场人员会员统计的查询处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月3日
     * @version 1.0
     */
    public List<EchartStaticVo> sellerMembMageStatic(MarketMembAddTjPo po);

    /**
     * 市场运营中会员消费统计的处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月3日
     * @version 1.0
     */
    public List<Double> sellerMembConsumeTj(MarketMembAddTjPo po);
}
