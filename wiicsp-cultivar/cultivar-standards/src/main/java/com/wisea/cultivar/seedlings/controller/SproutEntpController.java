package com.wisea.cultivar.seedlings.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.tp.LongIdPo;
import com.wisea.cultivar.seedlings.po.SproutEntpBatDeletePo;
import com.wisea.cultivar.seedlings.po.SproutEntpGetPo;
import com.wisea.cultivar.seedlings.po.SproutEntpInsertPo;
import com.wisea.cultivar.seedlings.po.SproutEntpListPo;
import com.wisea.cultivar.seedlings.po.SproutEntpPagePo;
import com.wisea.cultivar.seedlings.po.SproutEntpUpdatePo;
import com.wisea.cultivar.seedlings.service.SproutEntpService;
import com.wisea.cultivar.seedlings.vo.SeedlingsProVo;
import com.wisea.cultivar.seedlings.vo.SproutEntpGetVo;
import com.wisea.cultivar.seedlings.vo.SproutEntpListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * SproutEntpController
 * 定点种苗企业 Controller
 * 2020/08/06 14:19:24
 */
@Api(tags = "定点种苗企业相关接口")
@RequestMapping(value = "/w/SproutEntp")
@RestController
public class SproutEntpController {
    @Autowired
    protected SproutEntpService sproutEntpService;

    @ApiOperation(value = "获取定点种苗企业分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<SproutEntpListVo>> findPage(@RequestBody SproutEntpPagePo sproutEntpPagePo) {
        return sproutEntpService.findPage(sproutEntpPagePo);
    }

    @ApiOperation(value = "获取定点种苗企业列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SproutEntpListVo>> list(@RequestBody SproutEntpListPo sproutEntpListPo) {
        return sproutEntpService.findList(sproutEntpListPo);
    }

    @ApiOperation(value = "查询定点种苗企业")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SproutEntpGetVo> get(@RequestBody SproutEntpGetPo sproutEntpGetPo) {
        return sproutEntpService.get(sproutEntpGetPo);
    }

    @ApiOperation(value = "定点采购企业种苗占比")
    @RequestMapping(value = "provSeedling", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SeedlingsProVo>> provSeedling(@RequestBody LongIdPo longIdPo) {
        return sproutEntpService.provSeedling(longIdPo.getId());
    }

    @ApiOperation(value = "新增定点种苗企业")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody SproutEntpInsertPo sproutEntpInsertPo) {
        return sproutEntpService.insert(sproutEntpInsertPo);
    }

    @ApiOperation(value = "修改定点种苗企业")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody SproutEntpUpdatePo sproutEntpUpdatePo) {
        return sproutEntpService.update(sproutEntpUpdatePo);
    }

    @ApiOperation(value = "批量删除定点种苗企业")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody SproutEntpBatDeletePo sproutEntpBatDeletePo) {
        return sproutEntpService.batDelete(sproutEntpBatDeletePo);
    }
}
