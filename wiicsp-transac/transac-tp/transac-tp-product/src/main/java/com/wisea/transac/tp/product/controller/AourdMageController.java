package com.wisea.transac.tp.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.PlaceOriginMage;
import com.wisea.transac.common.po.product.AbroadMageInsertPo;
import com.wisea.transac.tp.product.service.AourdMageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Description:
 * @author: wangs
 * @date :2019/4/25
 */
@Api(tags = "【后台设置】国外产地管理")
@RestController
@RequestMapping("/w/aourd")
public class AourdMageController {

    @Autowired
    private AourdMageService aourdMageService;

    /**
     * 查询国外产地列表信息
     *
     * @param abroadMage
     * @return
     */
    @ApiOperation(nickname = "查询国外产地信息", value = "查询国外产地信息", notes = "查询国外产地列表信息")
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<PlaceOriginMage>> findList(@RequestBody PlaceOriginMage abroadMage) {
        return aourdMageService.findList(abroadMage);
    }

    /**
     * 添加和修改国外产地
     *
     * @param abroadMageInsertPo
     * @return
     */
    @ApiOperation(nickname = "添加和修改国外产地", value = "添加和修改国外产地", notes = "添加和修改国外产地")
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> saveOrUpdate(@RequestBody AbroadMageInsertPo abroadMageInsertPo) {
        return aourdMageService.saveOrUpdate(abroadMageInsertPo);
    }

    /**
     * 查询国外产地详细信息
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询国外产地详细信息", value = "查询国外产地详细信息", notes = "查询国外产地详细信息")
    @RequestMapping(value = "/findCommVarierMageInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<PlaceOriginMage> findAourdMageInfo(@RequestBody LongIdPo po) {
        return aourdMageService.findAourdMageInfo(po);
    }

    /**
     * 删除国外产地信息
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "删除国外产地信息", value = "删除国外产地信息", notes = "删除国外产地信息")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> del(@RequestBody LongIdPo po) {
        return aourdMageService.del(po);
    }
}
