package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.system.ListTradAreaPo;
import com.wisea.transac.common.po.system.TradAreaMageListPo;
import com.wisea.transac.tp.system.service.TradAreaMageService;
import com.wisea.transac.common.vo.TradAreaMageInfoVo;
import com.wisea.transac.common.vo.system.TradAreaMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className TradAreaMageController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@RestController
@RequestMapping("/w/TradAreaMage")
@Api(tags = "交易区管理")
public class TradAreaMageController {
    @Autowired
    private TradAreaMageService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询TradAreaMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<List<TradAreaMageListVo>> findPageList(@RequestBody TradAreaMageListPo po) {
        return service.findPageList(po,"0");
    }

    @DataCheck
    @RequestMapping(value = "/findPageListTree", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表树", value = "分页查询列表树", notes = "分页查询列表树", httpMethod = "POST")
    public ResultPoJo<Map<String,Object>> findPageListTree(@RequestBody TradAreaMageListPo po) {
        return service.findPageListForTree(po,"0");
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改TradAreaMage
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody ListTradAreaPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息TradAreaMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<TradAreaMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }
}
