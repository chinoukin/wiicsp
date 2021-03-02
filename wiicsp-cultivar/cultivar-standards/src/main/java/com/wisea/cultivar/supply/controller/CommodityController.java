package com.wisea.cultivar.supply.controller;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.CommVarietMageMapper;
import com.wisea.cultivar.common.dao.MeasUnitMageMapper;
import com.wisea.cultivar.common.entity.CommMage;
import com.wisea.cultivar.common.po.CommMageSearchPo;
import com.wisea.cultivar.common.po.product.CommVarietMagePagePo;
import com.wisea.cultivar.common.po.product.MeasUnitMageListPo;
import com.wisea.cultivar.common.vo.CommCurrencyInfoInfoVo;
import com.wisea.cultivar.common.vo.product.CommAttriMageListVo;
import com.wisea.cultivar.common.vo.product.CommVarietMageListVo;
import com.wisea.cultivar.common.vo.product.MeasUnitMageListVo;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.supply.po.*;
import com.wisea.cultivar.supply.service.CommodityService;
import com.wisea.cultivar.supply.util.CustomUtils;
import com.wisea.cultivar.supply.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 商品controller
 * @author chengq
 * @date 2020/8/13 13:56
 */
@RestController
@Api(tags = "APP管理-供应端-商品")
@RequestMapping(value = "/w/comm")
public class CommodityController {

    @Resource
    private CommodityService commodityService;

    @Resource(name = "NbCommVarietMageMapper")
    private CommVarietMageMapper commVarietMageMapper;

    @Resource(name = "NbMeasUnitMageMapper")
    private MeasUnitMageMapper measUnitMageMapper;

    /**
     * 保存商品信息
     */
    @DataCheck
    @PostMapping("save")
    @ApiOperation(value = "保存商品信息")
    public ResultPoJo<CommSaveVo> saveComm(@Valid @RequestBody CommoditySavePo commoditySavePo, BindingResult result) {
        return commodityService.saveComm(commoditySavePo);
    }

    /**
     * 商品列表
     */
    @DataCheck
    @PostMapping("list")
    @ApiOperation(value = "商品列表")
    public ResultPoJo<Page<ShopCommodityVo>> findCommodityList(@RequestBody CommodityListPo commodityListPo) {
        return commodityService.findCommodityList(commodityListPo);
    }

    /**
     * 删除商品
     */
    @DataCheck
    @PostMapping("delete")
    @ApiOperation(value = "删除商品")
    public ResultPoJo<Object> deleteCommodity(@RequestBody CommodityDeletePo commodityDeletePo) {
        return commodityService.deleteCommodity(commodityDeletePo);
    }

    /**
     * 商品详情
     */
    @DataCheck
    @PostMapping("details")
    @ApiOperation(value = "商品详情")
    public ResultPoJo<CommodityDetailsVo> getCommodityDetails(@RequestBody CommodityGetPo commodityGetPo) {
        return commodityService.getCommodityDetails(commodityGetPo);
    }

    /**
     * 商品信息
     */
    @DataCheck
    @PostMapping("echo")
    @ApiOperation(value = "商品修改回显信息")
    public ResultPoJo<CommodityEchoVo> getCommodityEcho(@RequestBody CommodityGetPo commodityGetPo) {
        return commodityService.getCommodityEcho(commodityGetPo);
    }

    /**
     * 商品上/下架
     */
    @DataCheck
    @PostMapping("update/status")
    @ApiOperation(value = "商品上/下架")
    public ResultPoJo<Object> updateStatus(@RequestBody CommodityStatusUpdatePo statusUpdate) {
        return commodityService.updateStatus(statusUpdate);
    }

    /**
     * 查询价格
     */
    @DataCheck
    @PostMapping("price")
    @ApiOperation(value = "查询价格")
    public ResultPoJo<List<PriceUpdateVo>> findPrice(@RequestBody CommodityGetPo commodityGetPo) {
        return commodityService.findPrice(commodityGetPo);
    }

    /**
     * 保存价格
     */
    @PostMapping("save/price")
    @ApiOperation(value = "保存价格")
    public ResultPoJo<Object> savePrice(@Validated @RequestBody CommodityPriceSavePo priceSavePo, BindingResult result) {
        return commodityService.savePrice(priceSavePo);
    }

    /**
     * 商品父分类
     */
    @GetMapping("mage/parent")
    @ApiOperation(value = "商品父分类")
    public ResultPoJo<List<CommMage>> attriParent() {
        return commodityService.attriParent();
    }

    /**
     * 商品子分类
     */
    @GetMapping("mage/children")
    @ApiOperation(value = "商品子分类")
    public ResultPoJo<List<CommMage>> attriChildren(Long pid) {
        return commodityService.attriChildren(pid);
    }

    /**
     * 查询商品分类树
     */
    @PostMapping("mage/search")
    @ApiOperation(value = "商品搜索分类")
    public ResultPoJo<List<CommMageSearchVo>> searchMage(@RequestBody CommMageSearchPo commMageSearchPo) {
        return commodityService.searchMage(commMageSearchPo);
    }

    /**
     * 商品品种
     */
    @PostMapping("variet/list")
    @ApiOperation(value = "商品品种")
    public ResultPoJo<List<CommVarietMageListVo>> varietList(@RequestBody CommVarietMagePagePo commVarietMagePagePo) {
        List<CommVarietMageListVo> vo = commVarietMageMapper.findCommVarierMageList(commVarietMagePagePo);
        CommVarietMageListVo varietMageListVo = new CommVarietMageListVo();
        varietMageListVo.setCommVarietName("不限品种");
        Optional.ofNullable(vo).orElse(Lists.newArrayList()).add(0, varietMageListVo);
        return CustomUtils.result(vo);
    }

    /**
     * 商品属性
     */
    @DataCheck
    @PostMapping("att/list")
    @ApiOperation(value = "商品属性")
    public ResultPoJo<List<CommAttriMageListVo>> attSetList(@RequestBody AttSetGetPo attSetGetPo) {
        return commodityService.attSetList(attSetGetPo);
    }

    /**
     * 商品状态数量
     */
    @GetMapping("comm/count")
    @ApiOperation(value = "商品状态数量")
    public ResultPoJo<CommCountVo> commCount() {
        return commodityService.commCount();
    }

    /**
     * 查询单位字典
     */
    @GetMapping("unit/dict")
    @ApiOperation(value = "查询单位字典")
    public ResultPoJo<List<CommUnitVo>> commUnit() {
        List<MeasUnitMageListVo> units = measUnitMageMapper.measList(new MeasUnitMageListPo());
        List<CommUnitVo> vo = units.stream()
                .filter(unit -> Objects.equals(unit.getEffeInvalState(), QdcyStandardsDict.EFFE_INVAL_STATE_0))
                .map(unit -> new CommUnitVo(unit.getId(), unit.getMeasUnitName()))
                .collect(Collectors.toList());
        return CustomUtils.result(vo);
    }

    /**
     * 查询通用商品须知
     */
    @GetMapping("curr/info")
    @ApiOperation(value = "查询通用商品须知")
    public ResultPoJo<CommCurrencyInfoInfoVo> currInfo() {
        return commodityService.currInfo();
    }

    /**
     * 查询发布状态
     */
    @GetMapping("release/state")
    @ApiOperation(value = "查询发布状态")
    public ResultPoJo<String> releaseState() {
        return commodityService.releaseState();
    }
}
