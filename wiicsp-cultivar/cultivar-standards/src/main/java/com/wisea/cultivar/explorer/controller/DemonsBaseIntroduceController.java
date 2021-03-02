package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroduceBatDeletePo;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroduceGetPo;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroduceInsertPo;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroduceListPo;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroducePagePo;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroduceUpdatePo;
import com.wisea.cultivar.explorer.service.DemonsBaseIntroduceService;
import com.wisea.cultivar.explorer.vo.DemonsBaseIntroduceGetVo;
import com.wisea.cultivar.explorer.vo.DemonsBaseIntroduceListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemonsBaseIntroduceController
 * 示范基地详细介绍 Controller
 * 2020/08/11 13:21:46
 */
@Api(tags = "示范基地详细介绍相关接口")
@RequestMapping(value = "/w/DemonsBaseIntroduce")
@RestController
@PreAuthorize("hasAuthority('ep:bse')")
public class DemonsBaseIntroduceController {
    @Autowired
    protected DemonsBaseIntroduceService demonsBaseIntroduceService;

    @ApiOperation(value = "获取示范基地详细介绍分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<DemonsBaseIntroduceListVo>> findPage(@RequestBody DemonsBaseIntroducePagePo demonsBaseIntroducePagePo) {
        return demonsBaseIntroduceService.findPage(demonsBaseIntroducePagePo);
    }

    @ApiOperation(value = "获取示范基地详细介绍列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<DemonsBaseIntroduceListVo>> list(@RequestBody DemonsBaseIntroduceListPo demonsBaseIntroduceListPo) {
        return demonsBaseIntroduceService.findList(demonsBaseIntroduceListPo);
    }

    @ApiOperation(value = "查询示范基地详细介绍")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<DemonsBaseIntroduceGetVo> get(@RequestBody DemonsBaseIntroduceGetPo demonsBaseIntroduceGetPo) {
        return demonsBaseIntroduceService.get(demonsBaseIntroduceGetPo);
    }

    @ApiOperation(value = "新增示范基地详细介绍")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody DemonsBaseIntroduceInsertPo demonsBaseIntroduceInsertPo) {
        return demonsBaseIntroduceService.insert(demonsBaseIntroduceInsertPo);
    }

    @ApiOperation(value = "修改示范基地详细介绍")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody DemonsBaseIntroduceUpdatePo demonsBaseIntroduceUpdatePo) {
        return demonsBaseIntroduceService.update(demonsBaseIntroduceUpdatePo);
    }

    @ApiOperation(value = "批量删除示范基地详细介绍")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody DemonsBaseIntroduceBatDeletePo demonsBaseIntroduceBatDeletePo) {
        return demonsBaseIntroduceService.batDelete(demonsBaseIntroduceBatDeletePo);
    }
}
