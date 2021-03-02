package com.wisea.transac.seller.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.EntpAuth;
import com.wisea.transac.common.entity.ShopInfo;
import com.wisea.transac.common.mss.RemoteCustomerMss;
import com.wisea.transac.common.po.customer.CustomerConfigUserInsertPo;
import com.wisea.transac.common.po.customer.SysImCustomerConfigInsertPo;
import com.wisea.transac.common.po.memb.EntpAuthUpInfoPo;
import com.wisea.transac.common.po.seller.ShopInfoPageListPo;
import com.wisea.transac.common.po.seller.ShopInfoPo;
import com.wisea.transac.common.vo.EntpAuthInfoVo;
import com.wisea.transac.common.vo.MembInfoInfoVo;
import com.wisea.transac.common.vo.WholeSaleMarketMageInfoVo;
import com.wisea.transac.common.vo.memb.EntpAuthInfoInitVo;
import com.wisea.transac.common.vo.seller.SellerTotalAmountAndTotalCountVo;
import com.wisea.transac.common.vo.seller.ShopInfoInfoVo;
import com.wisea.transac.common.vo.seller.ShopInfoPageListVo;
import com.wisea.transac.common.dao.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ShopInfoService
 * @date 2020/04/27 17:01:28
 * @Description
 */
@Service
public class ShopInfoService extends BaseService {

    @Autowired
    private ShopInfoMapper mapper;
    @Autowired
    private StallsVideoMageMapper stallsVideoMageMapper;
    @Autowired
    private MembInfoMapper membInfoMapper;
    @Autowired
    private EntpAuthMapper entpAuthMapper;
    @Autowired
    private WholeSaleMarketMageMapper wholeSaleMarketMageMapper;
    @Autowired
    private RemoteCustomerMss remoteCustomerMss;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询ShopInfo
     */
    public ResultPoJo<Page<ShopInfoPageListVo>> findPageList(ShopInfoPageListPo po) {
        ResultPoJo<Page<ShopInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<ShopInfoPageListVo> page = po.getPage();
        List<ShopInfoPageListVo> list = mapper.findPageList(po);

        list.forEach(i -> i.setVideoUrl(stallsVideoMageMapper.findShopVideoByShopId(i.getId())));

        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 逻辑删除ShopInfo
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        ShopInfo entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(ShopInfo.DEL_FLAG_DELETE);
            entity.preUpdate();
            mapper.updateByPrimaryKey(entity);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 新增或修改ShopInfo
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(ShopInfoPo po) {
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            ShopInfo entity = mapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(entity)) {
                //新增不算第一次设置店铺名称
                if ("1".equals(entity.getRemarks()) && !entity.getShopName().equals(po.getShopName())) {
                    resultPoJo.setCode(ConstantError.ERR_005);
                    resultPoJo.setMsg("店铺名称再次修改请联系相关人员");
                    return resultPoJo;
                } else if (("0".equals(entity.getRemarks()) || entity.getRemarks() == null)
                        && !entity.getShopName().equals(po.getShopName())) {

                    ShopInfo info = new ShopInfo();
                    info.setShopName(po.getShopName());
                    Integer shopNameCount = mapper.countByMerchantIdAndShopName(info);

                    if (shopNameCount > 0) {
                        resultPoJo.setCode("999");
                        resultPoJo.setMsg("店铺名称已被占用");
                        return resultPoJo;
                    }

                    entity.setRemarks("1");
                }
                BeanUtils.copyProperties(po, entity);
                entity.preUpdate();
                mapper.updateByPrimaryKeySelective(entity);
            } else {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        } else {

            //检查是否已在任何市场增加过店铺
            //检查当前市场情况
            ShopInfoInfoVo info = mapper.findInfoByMerchantId(po.getMerchantId());
            if (info != null) {
                resultPoJo.setCode("999");
                resultPoJo.setMsg("不能在该市场创建多个店铺");
                return resultPoJo;
            }

            ShopInfo shopInfo = new ShopInfo();
            shopInfo.setShopName(po.getShopName());
            Integer shopNameCount = mapper.countByMerchantIdAndShopName(shopInfo);

            if (shopNameCount > 0) {
                resultPoJo.setCode("999");
                resultPoJo.setMsg("店铺名称已被占用");
                return resultPoJo;
            }

            //新增
            ShopInfo entity = new ShopInfo();
            BeanUtils.copyProperties(po, entity);
            entity.setRemarks("0");
            entity.preInsert();
            mapper.insert(entity);

            SysImCustomerConfigInsertPo configInsertPo = new SysImCustomerConfigInsertPo();

            configInsertPo.setGroupId(entity.getId().toString());
            configInsertPo.setType("0");

            CustomerConfigUserInsertPo userInsertPo = new CustomerConfigUserInsertPo();
            userInsertPo.setAdmin("1");
            userInsertPo.setUserId(entity.getMerchantId());
            configInsertPo.getUserList().add(userInsertPo);

            ResultPoJo<Object> poJo = remoteCustomerMss.customerConfigInsert(configInsertPo);
            if (!poJo.getCode().equals(ConstantError.NOMAL)) {
                throw new BusinessException(poJo.getCode(), poJo.getMsg());
            }
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息ShopInfo
     */
    public ResultPoJo<ShopInfoInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<ShopInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        ShopInfoInfoVo vo = mapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            LongIdPo id = new LongIdPo();
            id.setId(vo.getMerchantId());
            MembInfoInfoVo info = membInfoMapper.findInfo(id);
            if (info != null) {
                vo.setAgentFlag(info.getAgentFlag());
            }
            EntpAuth auth = new EntpAuth();
            auth.setMembId(vo.getMerchantId());
            EntpAuthInfoVo authInfo = entpAuthMapper.findInfo(auth);
            if (authInfo != null) {
                LongIdPo idPo = new LongIdPo();
                idPo.setId(authInfo.getWholeSaleMarketId());
                WholeSaleMarketMageInfoVo wholeSaleMarketMageInfoVo = wholeSaleMarketMageMapper.findInfo(idPo);
                if (wholeSaleMarketMageInfoVo != null) {

                    vo.setWholeSaleMarketId(wholeSaleMarketMageInfoVo.getId());
                    vo.setWholeSaleMarketName(wholeSaleMarketMageInfoVo.getWholeSaleMarketName());
                    if (ConverterUtil.isNotEmpty(wholeSaleMarketMageInfoVo.getMarketLabelOne())) {
                        vo.setMarketLabelOne(wholeSaleMarketMageInfoVo.getMarketLabelOne());
                        vo.setMarketLabelTwo(wholeSaleMarketMageInfoVo.getMarketLabelTwo());
                        vo.setMarketLabelTree(wholeSaleMarketMageInfoVo.getMarketLabelTree());
                    }
                }
            }
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 根据用户id查询对应商户统计信息
     *
     * @param memberId 会员id（商户id）
     * @return
     */
    public ResultPoJo<Map<String, Object>> findShopsStat(Long memberId) {
        //总销售额
        //总订单数
        SellerTotalAmountAndTotalCountVo vo = mapper.findTotalAmountAndTotalCountBySellerId(memberId);
        //总客户数
        Long customerCount = mapper.findCustomerCountByMerchantId(memberId);
        //总关注数
        Long followCount = mapper.findFollowCountByMerchantId(memberId);

        HashMap<String, Object> result = Maps.newHashMap();
        result.put("totalAmount", vo.getTotalAmount());
        result.put("totalOrderCount", vo.getTotalCount());
        result.put("customerCount", customerCount);
        result.put("followCount", followCount);

        ResultPoJo<Map<String, Object>> poJo = new ResultPoJo<>();
        poJo.setResult(result);
        return poJo;
    }

    /**
     * 补充店铺地址信息
     *
     * @param vo
     * @return
     */
    public ResultPoJo<ShopInfoInfoVo> findShopAddress(ShopInfoInfoVo vo) {

        ResultPoJo<ShopInfoInfoVo> result = new ResultPoJo<>();

        EntpAuthUpInfoPo infoPo = new EntpAuthUpInfoPo();
        infoPo.setMembId(vo.getMerchantId());
        infoPo.setFlag("2");
        EntpAuthInfoInitVo info = entpAuthMapper.getUpEntpInfoByMembId(infoPo);

        LongIdPo idPo = new LongIdPo();
        idPo.setId(info.getWholeSaleMarketId());
        WholeSaleMarketMageInfoVo marketMageInfoVo = wholeSaleMarketMageMapper.findInfo(idPo);

        if (marketMageInfoVo != null) {
            vo.setAreaProv(marketMageInfoVo.getAreaProvCode());
            vo.setAreaProvName(marketMageInfoVo.getAreaProv());
            vo.setAreaCity(marketMageInfoVo.getAreaCityCode());
            vo.setAreaCityName(marketMageInfoVo.getAreaCity());
            vo.setAreaCou(marketMageInfoVo.getAreaCouCode());
            vo.setAreaCouName(marketMageInfoVo.getAreaCou());
            vo.setAddress(marketMageInfoVo.getAddress());
        }

        result.setResult(vo);

        return result;
    }

}
