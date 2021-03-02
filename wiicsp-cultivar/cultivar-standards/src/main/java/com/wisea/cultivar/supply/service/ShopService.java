package com.wisea.cultivar.supply.service;

import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.supply.entity.ShopInfo;
import com.wisea.cultivar.supply.enums.AuthTableEnum;
import com.wisea.cultivar.supply.mapper.ShopInfoMapper;
import com.wisea.cultivar.supply.po.ShopInfoSavePo;
import com.wisea.cultivar.supply.util.CustomUtils;
import com.wisea.cultivar.supply.vo.CertPictureVo;
import com.wisea.cultivar.supply.vo.MembAuthVo;
import com.wisea.cultivar.supply.vo.ShopHomeVo;
import com.wisea.cultivar.supply.vo.ShopPerformanceVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 店铺（供应端）
 * @author chengq
 * @date 2020/8/12 9:55
 */
@Service
public class ShopService {

    @Resource
    private ShopInfoMapper shopInfoMapper;

    /**
     * 查询店铺信息
     * @return 首页店铺信息
     */
    public ResultPoJo<ShopHomeVo> findShopInfo() {
        //获取登录的用户
        User user = SystemUtils.getUserOnlyId();
        //查询店铺信息
        ShopHomeVo vo = shopInfoMapper.selectShopHomeByMembId(user.getId());
        //封装返回
        return CustomUtils.result(vo);
    }

    /**
     * 统计业绩
     * @return 业绩信息
     */
    public ResultPoJo<ShopPerformanceVo> performance() {
        //获取登录的用户
        User user = SystemUtils.getUserOnlyId();
        //统计业绩信息
        ShopPerformanceVo vo = new ShopPerformanceVo();
        vo.setSerListPrice(shopInfoMapper.selectSerListPrice(user.getId()));
        vo.setClientCount(shopInfoMapper.selectClientCount(user.getId()));
        vo.setFocusCount(shopInfoMapper.selectFocusCount(user.getId()));
        vo.setSerListCount(shopInfoMapper.selectSerListCount(user.getId()));
        //封装返回
        return CustomUtils.result(vo);
    }

    /**
     * 店铺证书
     * @return 证书信息
     */
    public ResultPoJo<List<CertPictureVo>> shopCert() {
        //获取登录的用户
        User user = SystemUtils.getUserOnlyId();
        //店铺证书
        List<CertPictureVo> vo = shopInfoMapper.findShopCert(user.getId());
        //封装返回
        return CustomUtils.result(vo);
    }

    /**
     * 保存店铺信息
     * @param shopInfoSavePo 店铺信息
     * @return 保存结果
     */
    @Transactional
    public ResultPoJo<Object> saveShopInfo(ShopInfoSavePo shopInfoSavePo) {
        //获取用户并设置
        User user = SystemUtils.getUserOnlyId();
        shopInfoSavePo.setMembId(user.getId());
        //检查店铺名称是否重复设置
        checkRepeatSave(shopInfoSavePo);
        //检查店铺名称是否重复
        checkRepeatName(shopInfoSavePo);
        //查询当前服务商是否有店铺
        ShopInfo shopInfo = shopInfoMapper.selectByMembId(shopInfoSavePo.getMembId());
        if (Objects.isNull(shopInfo)) {
            //没有店铺新增
            return insert(shopInfoSavePo);
        }
        //修改
        ConverterUtil.copyProperties(shopInfoSavePo, shopInfo);
        shopInfo.preUpdate();
        shopInfoMapper.updateByPrimaryKey(shopInfo);
        return  CustomUtils.result();
    }

    /**
     * 新增
     * @param shopInfoSavePo 要保存的店铺信息
     * @return 保存结果
     */
    @Transactional
    public ResultPoJo<Object> insert(ShopInfoSavePo shopInfoSavePo) {
        ShopInfo shopInfo = new ShopInfo();
        ConverterUtil.copyProperties(shopInfoSavePo, shopInfo);
        shopInfo.preInsert();
        shopInfoMapper.insert(shopInfo);
        return  CustomUtils.result();
    }

    /**
     * 检查店铺名称是否重复
     * @param shopInfo 要验证的店铺信息
     */
    private void checkRepeatName(ShopInfoSavePo shopInfo) {
        //检查店铺名称是否重复
        ShopInfo oldShop = shopInfoMapper.selectByShopName(shopInfo.getShopName());
        User userOnlyId = SystemUtils.getUserOnlyId();
        if (Objects.nonNull(oldShop) && (!userOnlyId.getId().equals(oldShop.getMembId()))) {
            throw new VerifyException(QdcyStandardsError.ERR_10003, QdcyStandardsError.MSG_10003);
        }
    }

    /**
     * 检查店铺名称是否重复设置
     * @param shopInfo 要验证的店铺信息
     */
    private void checkRepeatSave(ShopInfoSavePo shopInfo) {
        //查询当前服务商是否设置过店铺名称（店铺名称只能设置一次）
        ShopInfo oldShop = shopInfoMapper.selectByMembId(shopInfo.getMembId());
        if (Objects.nonNull(oldShop)) {
            if (ConverterUtil.isEmpty(oldShop.getShopName())) {
                return;
            }
            if (!Objects.equals(shopInfo.getShopName(), oldShop.getShopName())) {
                throw new VerifyException(QdcyStandardsError.ERR_10002, QdcyStandardsError.MSG_10002);
            }
        }
    }

    /**
     * 登录初始化认证信息
     */
    public ResultPoJo<MembAuthVo> loginInit() {
        User user = SystemUtils.getUserOnlyId();
        MembAuthVo membBaseInfo = shopInfoMapper.getMembBaseInfo(user.getId());
        if (Objects.isNull(membBaseInfo) || ConverterUtil.isEmpty(membBaseInfo.getAuthType())) {
            return CustomUtils.result(new MembAuthVo(user.getId().toString(), "3"));
        }
        if (!Objects.equals(membBaseInfo.getAuthStateType(), "0")) {
            return CustomUtils.result(shopInfoMapper.getAuthState(user.getId(), AuthTableEnum.findByType(membBaseInfo.getAuthType()).getTable()));
        }
        return CustomUtils.result(membBaseInfo);
    }
}
