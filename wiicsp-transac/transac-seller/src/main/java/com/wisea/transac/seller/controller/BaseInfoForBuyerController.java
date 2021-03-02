package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.seller.BaseInfoPagePo;
import com.wisea.transac.common.vo.BaseStatVo;
import com.wisea.transac.common.vo.PlaceOriginMagePageListVo;
import com.wisea.transac.common.vo.seller.BaseCataTreeVo;
import com.wisea.transac.common.vo.seller.BaseInfoVo;
import com.wisea.transac.common.vo.seller.BaseListVo;
import com.wisea.transac.seller.service.BaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangjiahao
 * @since 2020/7/1 3:19 下午
 */
@RestController
@RequestMapping("/w/buyer/base")
@Api(tags = "【数字基地】基地管理-买家")
public class BaseInfoForBuyerController {

    @Autowired
    private BaseInfoService service;

    @DataCheck
    @PostMapping("/abroad/list")
    @ApiOperation("国外产地列表")
    public ResultPoJo<List<PlaceOriginMagePageListVo>> findAbroadList() {
        return service.findAbroadList();
    }

    @DataCheck
    @PostMapping("/inland/list")
    @ApiOperation("国内产地列表")
    public ResultPoJo<List<BaseListVo>> findInlandList() {
        return service.finInlandAndBaseCountList();
    }


    @DataCheck
    @PostMapping("/abroad/cata/list")
    @ApiOperation("国外品类列表")
    public ResultPoJo<List<BaseCataTreeVo>> findAbroadCataList() {
        return service.findCataList(true);
    }

    @DataCheck
    @PostMapping("/inland/cata/list")
    @ApiOperation("国内品类列表")
    public ResultPoJo<List<BaseCataTreeVo>> findCataList() {
        return service.findCataList(false);
    }


    @DataCheck
    @PostMapping(value = "/list")
    @ApiOperation(nickname = "基地信息列表", value = "基地信息列表", notes = "基地信息列表", httpMethod = "POST")
    public ResultPoJo<Page<BaseInfoVo>> list(@RequestBody BaseInfoPagePo po) {
        if ("1".equals(po.getIsAbraod())) {
            po.setAbroadId(null);
        }else {
            po.setAreaProv(null);
        }
        return service.findForPage(po);
    }

    @DataCheck
    @PostMapping(value = "/stat")
    @ApiOperation(nickname = "基地详情页统计", value = "基地详情页统计", notes = "基地详情页统计", httpMethod = "POST")
    public ResultPoJo<BaseStatVo> stat(@RequestBody LongIdPo po) {
        return service.stat(po);
    }

    @DataCheck
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询基地详情", value = "查询基地详情", notes = "查询基地详情", httpMethod = "POST")
    public ResultPoJo<BaseInfoVo> findById(@RequestBody LongIdPo po) {
        return service.findById(po);
    }

}
