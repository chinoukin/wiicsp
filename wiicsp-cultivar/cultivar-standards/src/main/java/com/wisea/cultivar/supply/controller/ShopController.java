package com.wisea.cultivar.supply.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.supply.po.CommodityListPo;
import com.wisea.cultivar.supply.po.ShopInfoSavePo;
import com.wisea.cultivar.supply.service.CommodityService;
import com.wisea.cultivar.supply.service.ShopService;
import com.wisea.cultivar.supply.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * APP管理-供应端 店铺
 * @author chengq
 * @date 2020/8/12 9:51
 */
@RestController
@Api(tags = "APP管理-供应端-店铺")
@RequestMapping(value = "/w/stop")
public class ShopController {

    @Resource
    private ShopService shopService;

    @Resource
    private CommodityService commodityService;

    /**
     * 登录初始化认证信息
     */
    @GetMapping("login/init")
    @ApiOperation(value = "初始化认证信息")
    public ResultPoJo<MembAuthVo> loginInit() {
        return shopService.loginInit();
    }

    /**
     * 店铺信息
     */
    @GetMapping("info")
    @ApiOperation(value = "店铺信息")
    public ResultPoJo<ShopHomeVo> findShopInfo() {
        return shopService.findShopInfo();
    }

    /**
     * 店铺信息统计
     */
    @GetMapping("performance")
    @ApiOperation(value = "店铺信息统计")
    public ResultPoJo<ShopPerformanceVo> performance() {
        return shopService.performance();
    }

    /**
     * 店铺证书
     */
    @GetMapping("cert")
    @ApiOperation(value = "店铺证书")
    public ResultPoJo<List<CertPictureVo>> shopCert() {
        return shopService.shopCert();
    }


    /**
     * 商品列表
     */
    @GetMapping("commodity")
    @ApiOperation(value = "商品列表")
    public ResultPoJo<Page<ShopCommodityVo>> findCommodityList() {
        return commodityService.findCommodityList(new CommodityListPo(QdcyStandardsDict.COMM_STATE_TYPE_0));
    }

    /**
     * 保存店铺信息
     */
    @DataCheck
    @PostMapping("save")
    @ApiOperation(value = "保存店铺信息")
    public ResultPoJo<Object> saveShopInfo(@RequestBody ShopInfoSavePo shopInfoSavePo) {
        return shopService.saveShopInfo(shopInfoSavePo);
    }

}
