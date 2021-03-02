package com.wisea.transac.seller.controller;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.FollowMerchant;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.po.FollowMerchantPo;
import com.wisea.transac.common.po.seller.CertMagePageListPo;
import com.wisea.transac.common.po.seller.ShopInfoPageListPo;
import com.wisea.transac.common.po.seller.ShopInfoPo;
import com.wisea.transac.common.po.seller.StallsMagePageListPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.utils.ShopUtils;
import com.wisea.transac.common.vo.EntpAuthInfoVo;
import com.wisea.transac.common.vo.seller.CertMagePageListVo;
import com.wisea.transac.common.vo.seller.ShopInfoInfoVo;
import com.wisea.transac.common.vo.seller.ShopInfoPageListVo;
import com.wisea.transac.common.vo.seller.StallsMageInfoVo;
import com.wisea.transac.common.vo.seller.StallsMagePageListVo;
import com.wisea.transac.seller.service.CertMageService;
import com.wisea.transac.seller.service.EntpAuthService;
import com.wisea.transac.seller.service.FollowMerchantService;
import com.wisea.transac.seller.service.ShopInfoService;
import com.wisea.transac.seller.service.StallsMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ShopInfoController
 * @date 2020/04/27 17:01:28
 * @Description
 */
@RestController
@RequestMapping("/w/ShopInfo")
@Api(tags = "店铺信息管理")
public class ShopInfoController {
    @Autowired
    private ShopInfoService service;
    @Autowired
    private StallsMageService stallsMageService;
    @Autowired
    private EntpAuthService entpAuthService;
    @Autowired
    private CertMageService certMageService;
    @Autowired
    private FollowMerchantService followMerchantService;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询ShopInfo
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<ShopInfoPageListVo>> findPageList(@RequestBody ShopInfoPageListPo po) {
        return service.findPageList(po);
    }

    @DataCheck
    @PostMapping("/findAllByMarketId")
    @ApiOperation("根据市场id查询所有店铺")
    public ResultPoJo<List<ShopInfoInfoVo>> findAllByMarketId(@RequestBody LongIdPo po) {
        ResultPoJo<List<ShopInfoInfoVo>> resultPoJo = new ResultPoJo<>();
        List<ShopInfoInfoVo> list = ShopUtils.getShopByMarketId(po.getId());
        if (!list.isEmpty()) {
            resultPoJo.setResult(list);
        }
//        else {
//            resultPoJo.setCode(ConstantError.ERR_004);
//            resultPoJo.setMsg(ConstantError.MSG_004);
//        }
        return resultPoJo;
    }

    @DataCheck
    @PostMapping("/stat")
    @ApiOperation("所有店铺统计")
    public ResultPoJo<Map<String, Object>> findShopsStat() {
        User user = SystemUtils.getUser();
        MembBaseInfo info = MembUtils.getMembInfoByUserId(user.getId());
        ShopInfoInfoVo shopInfo = ShopUtils.getShopInfo(info.getMembId());
        return service.findShopsStat(shopInfo.getMerchantId());
    }


    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 逻辑删除ShopInfo
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 新增或修改ShopInfo
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody ShopInfoPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息ShopInfo
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<ShopInfoInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    @DataCheck
    @PostMapping("/businessCard")
    @ApiOperation("店铺名片")
    public ResultPoJo<Map<String, Object>> showBusinessCard(@RequestBody LongIdPo po) {
//        基本信息
        ResultPoJo<ShopInfoInfoVo> info = service.findInfo(po);
        //经营天数
        long days = calcDays(info.getResult().getCreateDate());
        //统计数据
        ResultPoJo<Map<String, Object>> stat = service.findShopsStat(info.getResult().getMerchantId());

        ResultPoJo<Map<String, Object>> result = new ResultPoJo<>();

        HashMap<String, Object> map = Maps.newHashMap();
        map.put("info", info.getResult());
        map.put("stat", stat.getResult());
        map.put("days", days);

        result.setResult(map);

        return result;
    }

    @DataCheck
    @PostMapping("/preview")
    @ApiOperation(value = "店铺预览", notes = "当前档口水果见接口<b>档口商品查询-分页查询</b>")
    public ResultPoJo shopPreview(@RequestBody LongIdPo po) {
        //商店基本信息
        ResultPoJo<ShopInfoInfoVo> info = service.findInfo(po);
        if (info.getResult() == null) {
            ResultPoJo resultPoJo = new ResultPoJo();
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
            return resultPoJo;
        }

        ResultPoJo<ShopInfoInfoVo> shopWithAdd = service.findShopAddress(info.getResult());

        //统计
        ResultPoJo<Map<String, Object>> stat = service.findShopsStat(shopWithAdd.getResult().getMerchantId());
        //所有档口以及相关视频监控
        StallsMagePageListPo pagePo = new StallsMagePageListPo();
        pagePo.setShopId(po.getId());
        pagePo.setPageInfo(null);
//        Long currentId = SystemUtils.getUser().getId();
//        MembBaseInfo parentInfo = MembUtils.getMembInfoByUserId(currentId);
//        if (!currentId.equals(parentInfo.getMembId())) {
//            pagePo.setSaleId(currentId);
//        }
        ResultPoJo<Page<StallsMagePageListVo>> list = stallsMageService.findPageList(pagePo);

        ResultPoJo<Map<String, Object>> result = new ResultPoJo<>();

        HashMap<String, Object> map = Maps.newHashMap();
        map.put("info", shopWithAdd.getResult());
        map.put("stat", stat.getResult());
        map.put("stalls", list.getResult());

        result.setResult(map);

        return result;
    }

    @DataCheck
    @PostMapping("/detail")
    @ApiOperation(value = "店铺详情")
    public ResultPoJo shopDetail() {
        User user = SystemUtils.getUser();
        if (user.getId() == null) {
            ResultPoJo resultPoJo = new ResultPoJo();
            resultPoJo.setCode("999");
            resultPoJo.setMsg("未登录");
            return resultPoJo;
        }
        MembBaseInfo info = MembUtils.getMembInfoByUserId(user.getId());
        ShopInfoInfoVo shopInfo = ShopUtils.getShopInfo(info.getMembId());
        if (shopInfo == null) {
            ResultPoJo resultPoJo = new ResultPoJo();
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
            return resultPoJo;
        }
        LongIdPo idPo = new LongIdPo();
        idPo.setId(shopInfo.getId());
        return shopPreview(idPo);
    }

    @DataCheck
    @PostMapping("/detailByStallsId")
    @ApiOperation(value = "根据档口查询店铺详情")
    public ResultPoJo shopDetailByStallsId(@RequestBody LongIdPo po) {

        ResultPoJo<StallsMageInfoVo> stalls = stallsMageService.findInfo(po);
        if (stalls.getResult() == null) {
            return stalls;
        }
        LongIdPo idPo = new LongIdPo();
        idPo.setId(stalls.getResult().getShopId());
        ResultPoJo resultPoJo = shopPreview(idPo);

        Map<String, Object> map = (Map) resultPoJo.getResult();
        ShopInfoInfoVo info = (ShopInfoInfoVo) map.get("info");

        FollowMerchantPo merchantPo = new FollowMerchantPo();
        merchantPo.setMembId(SystemUtils.getUser().getId());
        merchantPo.setShopId(info.getId());
        ResultPoJo<FollowMerchant> followMerchant = followMerchantService.findByMembIdAndShopId(merchantPo);

        if (followMerchant.getResult() == null) {
            info.setFollow("0");
        } else {
            info.setFollow("1");
        }

        return resultPoJo;
    }

    @DataCheck
    @PostMapping("/detailByShopId")
    @ApiOperation(value = "根据档口查询店铺详情")
    public ResultPoJo shopDetailByShopId(@RequestBody LongIdPo po) {

        ResultPoJo resultPoJo = shopPreview(po);

        Map<String, Object> map = (Map) resultPoJo.getResult();
        ShopInfoInfoVo info = (ShopInfoInfoVo) map.get("info");

        FollowMerchantPo merchantPo = new FollowMerchantPo();
        merchantPo.setMembId(SystemUtils.getUser().getId());
        merchantPo.setShopId(info.getId());
        ResultPoJo<FollowMerchant> followMerchant = followMerchantService.findByMembIdAndShopId(merchantPo);

        if (followMerchant.getResult() == null) {
            info.setFollow("0");
        } else {
            info.setFollow("1");
        }

        return resultPoJo;
    }


    @DataCheck
    @PostMapping("/creditiles")
    @ApiOperation(value = "诚信档案", notes = "传店铺ID")
    public ResultPoJo creditiles(@RequestBody LongIdPo po) {

        //企业信息
        ResultPoJo<ShopInfoInfoVo> shopInfo = service.findInfo(po);
        if (shopInfo.getResult() == null) {
            return shopInfo;
        }
        LongIdPo entpId = new LongIdPo();
        entpId.setId(shopInfo.getResult().getMerchantId());

        ResultPoJo<EntpAuthInfoVo> entpInfo = entpAuthService.findInfoByMembId(entpId);
        if (entpInfo.getResult() == null) {
            return entpInfo;
        }
        //所有证书
        CertMagePageListPo pagePo = new CertMagePageListPo();
        pagePo.setShopId(po.getId());
        pagePo.setPageInfo(null);
        ResultPoJo<Page<CertMagePageListVo>> list = certMageService.findPageList(pagePo);

        ResultPoJo<Map<String, Object>> result = new ResultPoJo<>();
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("cert", list.getResult());
        map.put("info", entpInfo.getResult());

        result.setResult(map);

        return result;
    }

    @DataCheck
    @PostMapping("/isMerchant")
    @ApiOperation("是否是店铺商户,1是，0不是")
    public ResultPoJo<String> isMerchant() {
        ResultPoJo<String> resultPoJo = new ResultPoJo<>();
        Long membId = SystemUtils.getUser().getId();
        MembBaseInfo info = MembUtils.getMembInfoByUserId(membId);
        ShopInfoInfoVo shopInfo = ShopUtils.getShopInfo(info.getMembId());
        if (shopInfo == null) {
            resultPoJo.setResult("0");
        } else if (membId.equals(shopInfo.getMerchantId())) {
            resultPoJo.setResult("0");
        } else {
            resultPoJo.setResult("1");
        }
        return resultPoJo;
    }

    /**
     * 计算日期和现在相差天数,只保留整数
     *
     * @param date 日期
     *
     * @return
     */
    private long calcDays(OffsetDateTime date) {
        OffsetDateTime now = OffsetDateTime.now();
        long l;
        if (now.isAfter(date)) {
            l = Date.from(now.toInstant()).getTime() - Date.from(date.toInstant()).getTime();
        } else {
            l = Date.from(date.toInstant()).getTime() - Date.from(now.toInstant()).getTime();
        }
        return l / (1000 * 60 * 60 * 24);
    }

}
