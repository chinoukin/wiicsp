package com.wisea.cultivar.supply.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.vo.MembInfoInfoVo;
import com.wisea.cultivar.common.vo.SzdkConfigureInfoVo;
import com.wisea.cultivar.infomanage.service.SzdkConfigureService;
import com.wisea.cultivar.supply.po.AccountUpdatePo;
import com.wisea.cultivar.supply.po.FeedBackVo;
import com.wisea.cultivar.supply.po.MobileUpdatePo;
import com.wisea.cultivar.supply.service.MyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * APP管理-供应端-我的
 * @author chengq
 * @date 2020/8/20 17:03
 */
@RestController
@Api(tags = "APP管理-供应端-我的")
@RequestMapping(value = "/w/my")
public class MyController {

    @Resource
    private SzdkConfigureService szdkConfigureService;

    @Resource
    private MyService myService;


    /**
     * 查询账号信息
     */
    @GetMapping("account/info")
    @ApiOperation(value = "查询账号信息")
    public ResultPoJo<MembInfoInfoVo> findAccount() {
        return myService.findAccount();
    }

    /**
     * 修改账号信息
     */
    @PostMapping("account/update")
    @ApiOperation(value = "修改账号信息")
    public ResultPoJo<Object> updateAccount(@RequestBody AccountUpdatePo accountUpdatePo) {
        return myService.updateAccount(accountUpdatePo);
    }

    /**
     * 修改手机号
     */
    @DataCheck
    @PostMapping("mobile/update")
    @ApiOperation(value = "修改手机号")
    public ResultPoJo<Object> updateMobile(@RequestBody MobileUpdatePo mobileUpdatePo) {
        return myService.updateMobile(mobileUpdatePo);
    }

    /**
     * 意见反馈
     */
    @DataCheck
    @PostMapping("feed/back")
    @ApiOperation(value = "意见反馈")
    public ResultPoJo<Object> feedBack(@RequestBody FeedBackVo feedBackVo) {
        return myService.feedBack(feedBackVo);
    }

    @PostMapping(value = "/about")
    @ApiOperation( value = "关于我们")
    public ResultPoJo<SzdkConfigureInfoVo> get() {
        return szdkConfigureService.findInfo();
    }
}
