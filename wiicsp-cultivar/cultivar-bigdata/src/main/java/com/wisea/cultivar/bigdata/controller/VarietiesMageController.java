package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.service.VarietiesMageService;
import com.wisea.cultivar.common.entity.bigdata.VarietiesMage;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageGetPo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageListPo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMagePagePo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.VarietiesMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.VarietiesMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * VarietiesMageController
 * 物料管理 Controller
 * 2019/12/03 14:35:19
 */
@Api(tags = "物料管理相关接口")
@RequestMapping(value = "/w/varietiesMage")
@RestController
public class VarietiesMageController {
    @Autowired
    protected VarietiesMageService varietiesMageService;

    @ApiOperation(value = "获取物料管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<VarietiesMageListVo>> findPage(@RequestBody VarietiesMagePagePo varietiesMagePagePo) {
        return varietiesMageService.findPage(varietiesMagePagePo);
    }

    @ApiOperation(value = "获取物料管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<VarietiesMageListVo>> list(@RequestBody VarietiesMageListPo varietiesMageListPo) {
        return varietiesMageService.findList(varietiesMageListPo);
    }

    @ApiOperation(value = "查询物料管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<VarietiesMageGetVo> get(@RequestBody VarietiesMageGetPo varietiesMageGetPo) {
        return varietiesMageService.get(varietiesMageGetPo);
    }

    @ApiOperation(value = "新增物料管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody VarietiesMageInsertPo varietiesMageInsertPo) {
        return varietiesMageService.insert(varietiesMageInsertPo);
    }

    @ApiOperation(value = "修改物料管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody VarietiesMageUpdatePo varietiesMageUpdatePo) {
        return varietiesMageService.update(varietiesMageUpdatePo);
    }

    @ApiOperation(value = "批量删除物料管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody VarietiesMageBatDeletePo varietiesMageBatDeletePo) {
        return varietiesMageService.batDelete(varietiesMageBatDeletePo);
    }
    /**
     * 导出物料管理
     *
     * @param
     * @return
     * @throws IOException
     */
	@DataCheck
    @ApiOperation("导出物料管理")
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public ResultPoJo<Object> export(@RequestBody VarietiesMageListPo po, HttpServletResponse response) throws IOException {
		return varietiesMageService.export(po, response);
    }

    @ApiOperation(value = "校验物料编码是否存在")
    @RequestMapping(value = "check", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<VarietiesMage> check(@RequestBody VarietiesMageInsertPo varietiesMageInsertPo) {
        return varietiesMageService.check(varietiesMageInsertPo);
    }

}
