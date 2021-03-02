package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.service.YxEntpService;
import com.wisea.cultivar.common.po.bigdata.YxEntpBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.YxEntpGetPo;
import com.wisea.cultivar.common.po.bigdata.YxEntpInsertPo;
import com.wisea.cultivar.common.po.bigdata.YxEntpListPo;
import com.wisea.cultivar.common.po.bigdata.YxEntpPagePo;
import com.wisea.cultivar.common.po.bigdata.YxEntpUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.YxEntpGetVo;
import com.wisea.cultivar.common.vo.bigdata.YxEntpListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * YxEntpController
 * 已选企业 Controller
 * 2019/12/02 11:02:15
 */
@Api(tags = "已选企业相关接口")
@RequestMapping(value = "/w/yxEntp")
@RestController
public class YxEntpController {
    @Autowired
    protected YxEntpService yxEntpService;

    @ApiOperation(value = "获取已选企业分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<YxEntpListVo>> findPage(@RequestBody YxEntpPagePo yxEntpPagePo) {
        return yxEntpService.findPage(yxEntpPagePo);
    }

    @ApiOperation(value = "获取已选企业列表 已选的标识是有产地ID（传产地ID则取所有企业，已选的标记；不传产地ID则默认查询全部企业）")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<YxEntpListVo>> list(@RequestBody YxEntpListPo yxEntpListPo) {
        return yxEntpService.findList(yxEntpListPo);
    }

    @ApiOperation(value = "查询已选企业")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<YxEntpGetVo> get(@RequestBody YxEntpGetPo yxEntpGetPo) {
        return yxEntpService.get(yxEntpGetPo);
    }

    @ApiOperation(value = "新增已选企业")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody YxEntpInsertPo yxEntpInsertPo) {
        return yxEntpService.insert(yxEntpInsertPo);
    }

    @ApiOperation(value = "修改已选企业")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody YxEntpUpdatePo yxEntpUpdatePo) {
        return yxEntpService.update(yxEntpUpdatePo);
    }

    @ApiOperation(value = "批量删除已选企业")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody YxEntpBatDeletePo yxEntpBatDeletePo) {
        return yxEntpService.batDelete(yxEntpBatDeletePo);
    }
}
