package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.CategoryMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.CategoryMageGetPo;
import com.wisea.cultivar.common.po.bigdata.CategoryMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.CategoryMageListPo;
import com.wisea.cultivar.common.po.bigdata.CategoryMagePagePo;
import com.wisea.cultivar.common.po.bigdata.CategoryMageUpdatePo;
import com.wisea.cultivar.bigdata.service.CategoryMageService;
import com.wisea.cultivar.common.vo.bigdata.CategoryMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.CategoryMageListVo;
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
 * CategoryMageController
 * 品类管理 Controller
 * 2019/12/03 14:35:19
 */
@Api(tags = "品类管理相关接口")
@RequestMapping(value = "/w/category")
@RestController
public class CategoryMageController {
    @Autowired
    protected CategoryMageService categoryMageService;

    @ApiOperation(value = "获取品类管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<CategoryMageListVo>> findPage(@RequestBody CategoryMagePagePo categoryMagePagePo) {
        return categoryMageService.findPage(categoryMagePagePo);
    }

    @ApiOperation(value = "获取品类管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<CategoryMageListVo>> list(@RequestBody CategoryMageListPo categoryMageListPo) {
        return categoryMageService.findList(categoryMageListPo);
    }

    @ApiOperation(value = "查询品类管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<CategoryMageGetVo> get(@RequestBody CategoryMageGetPo categoryMageGetPo) {
        return categoryMageService.get(categoryMageGetPo);
    }

    @ApiOperation(value = "新增品类管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody CategoryMageInsertPo categoryMageInsertPo) {
        return categoryMageService.insert(categoryMageInsertPo);
    }

    @ApiOperation(value = "修改品类管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody CategoryMageUpdatePo categoryMageUpdatePo) {
        return categoryMageService.update(categoryMageUpdatePo);
    }

    @ApiOperation(value = "批量删除品类管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody CategoryMageBatDeletePo categoryMageBatDeletePo) {
        return categoryMageService.batDelete(categoryMageBatDeletePo);
    }

    /**
     * 导出品类管理
     *
     * @param
     * @return
     * @throws IOException
     */
	@DataCheck
    @ApiOperation("导出品类管理")
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public ResultPoJo<Object> export(@RequestBody CategoryMageListPo po, HttpServletResponse response) throws IOException {
		return categoryMageService.export(po, response);
    }
}
