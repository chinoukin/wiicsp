package com.wisea.transac.seller.controller;


import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.MembInfoPo;
import com.wisea.transac.common.vo.seller.SellerMembInfoVo;
import com.wisea.transac.seller.service.MembInfoService;
import com.wisea.transac.seller.service.MyCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "我的名片")
@RestController
@RequestMapping("/w/MyCard")
public class MyCardController {

    @Autowired
    private MyCardService service;

    @Autowired
    private MembInfoService membInfoService;
    /**
     * 我的名片
     * @param
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "我的名片/会员信息", value = "我的名片/会员信息", notes = "我的名片/会员信息", httpMethod = "POST")
    public ResultPoJo<SellerMembInfoVo> findInfo() {
        return service.findInfo();
    }


    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改MembInfo
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改会员信息", value = "新增或修改会员信息", notes = "新增或修改会员信息", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody MembInfoPo po) {
        return membInfoService.saveOrUpdate(po);
    }


}
