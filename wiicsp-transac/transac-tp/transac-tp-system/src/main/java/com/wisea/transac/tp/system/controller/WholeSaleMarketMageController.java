package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.WholeSaleMarketMagePageListPo;
import com.wisea.transac.common.po.WholeSaleMarketMagePo;
import com.wisea.transac.common.po.system.MarketRankPo;
import com.wisea.transac.common.vo.WholeSaleMarketMageInfoVo;
import com.wisea.transac.common.vo.WholeSaleMarketMagePageListVo;
import com.wisea.transac.common.vo.system.MarketRankVo;
import com.wisea.transac.tp.system.service.WholeSaleMarketMageService;
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
 * @author wbf-code-generator
 * @version 1.0
 * @className WholeSaleMarketMageController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@RestController
@RequestMapping("/w/WholeSaleMarketMage")
@Api(tags = "批发市场管理")
public class WholeSaleMarketMageController {
    @Autowired
    private WholeSaleMarketMageService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询WholeSaleMarketMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<WholeSaleMarketMagePageListVo>> findPageList(@RequestBody WholeSaleMarketMagePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除WholeSaleMarketMage
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改WholeSaleMarketMage
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改,返回主键", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody WholeSaleMarketMagePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息WholeSaleMarketMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<WholeSaleMarketMageInfoVo> findInfo(@RequestBody WholeSaleMarketMagePo po) {
        ResultPoJo<WholeSaleMarketMageInfoVo> info = service.findInfo(po, "0");
        //没有查到结果，而且微信地址不为空
        if (info.getResult() == null && ConverterUtil.isNotEmpty(po.getWxCoordinate())) {
           return service.findClosestInfo(po);
        }
        return info;
    }

    @DataCheck
    @RequestMapping(value = "/findClosestInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询最近市场的详细信息", value = "查询最近市场的详细信息", notes = "查询最近市场的详细信息", httpMethod = "POST")
    public ResultPoJo<WholeSaleMarketMageInfoVo> findClosestInfo(@RequestBody WholeSaleMarketMagePo po) {
        return service.findClosestInfo(po);
    }

    @DataCheck
    @PostMapping("/rank")
    @ApiOperation("批发市场排名")
    public ResultPoJo<List<MarketRankVo>> findMarketTop10(@RequestBody MarketRankPo po) {
        return service.findMarketRank(po);
    }
}
