package com.wisea.transac.tp.product.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.entity.CommAttriSet;
import com.wisea.transac.common.po.product.CommAttriSetGetPo;
import com.wisea.transac.common.po.product.CommAttriSetPagePo;
import com.wisea.transac.common.po.product.CommMageGetPo;
import com.wisea.transac.common.vo.product.CommAttriMageListVo;
import com.wisea.transac.common.vo.product.CommAttriSetGetVo;
import com.wisea.transac.common.vo.product.CommAttriSetListVo;
import com.wisea.transac.common.vo.product.InsertCommAttriSetVo;
import com.wisea.transac.tp.product.service.CommAttriSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 商品基础设置 - 属性设置
 * @author: wangs
 * @date :2020/4/28
 */
@Api(tags = "商品基础设置 - 属性设置")
@RestController
@RequestMapping(value = "/w/commAttriSet")
public class CommAttriSetController {

    @Autowired
    CommAttriSetService commAttriSetService;

    /**
     * 查询商品属性设置列表
     * @param po
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "查询商品属性设置列表", notes = "请求参数是：属性名称，以及是否必填")
    @DataCheck
    public Page<CommAttriSetListVo> commAttriSetList(@RequestBody CommAttriSetPagePo po) {
        Page<CommAttriSetListVo> pageResultPoJo = commAttriSetService.commAttriSetList(po);
        return pageResultPoJo;
    }

    /**
     * 新增属性 设置
     * @param po
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增属性 设置")
    @DataCheck
    public ResultPoJo commAttriSetAdd(@RequestBody CommAttriSet po) {
        ResultPoJo resultPoJo = commAttriSetService.commAttriSetAdd(po);
        return resultPoJo;
    }

    /**
     * 获取属性设置详情
     * @param po
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "获取属性设置详情")
    @DataCheck
    public ResultPoJo editCommAttriSet(@RequestBody CommAttriSetGetPo po) {
        ResultPoJo<CommAttriSetGetVo> commAttriSetGetVoResultPoJo =
                commAttriSetService.editCommAttriSet(po);
        return commAttriSetGetVoResultPoJo;
    }

    /**
     * 修改属性设置信息
     * @param po
     * @return
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ApiOperation(value = "修改属性设置信息",notes = "请求参数是：商品属性设置的ID; 返回一个修改之后的状态")
    @DataCheck
    public ResultPoJo modifyCommAttriSet(@RequestBody CommAttriSet po) {
        ResultPoJo resultPoJo = commAttriSetService.modifyCommAttriSet(po);
        return resultPoJo;
    }

    /**
     * 删除商品分类
     * @param po
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(value = "删除商品分类（商品分类下边有对应的商品）已经建立的属性",
            notes = "请求参数是：商品属性设置的ID; 返回一个删除之后的状态")
    @DataCheck
    public ResultPoJo delCommAttriSet(@RequestBody CommAttriSet po) {
        ResultPoJo resultPoJo = commAttriSetService.delCommAttriSet(po);
        return resultPoJo;
    }

    /**
     * 添加/编辑之前需要查询商品分类和属性列表
     * @return
     */
    @RequestMapping(value = "/beforeAdd", method = RequestMethod.POST)
    @ApiOperation(value = "添加/编辑之前需要查询商品分类和属性列表",
            notes = "请求参数是：;返回两个集合")
    @DataCheck
    public ResultPoJo<InsertCommAttriSetVo> beforeInsert() {
        ResultPoJo<InsertCommAttriSetVo> insertCommAttriSetVoResultPoJo =
                commAttriSetService.beforeInsert();
        return insertCommAttriSetVoResultPoJo;
    }

    /**
     * 有权限的根据商品分类id查询商品属性设置列表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/commAttriList", method = RequestMethod.POST)
    @ApiOperation(value = "有权限的根据商品分类id查询商品属性设置列表",notes = "请求参数是：商品销售分类设置中的 commId")
    public ResultPoJo<List<CommAttriMageListVo>> autoFindCommAttrSetListByMageId(@RequestBody CommMageGetPo po) {
        ResultPoJo<List<CommAttriMageListVo>> commAttriList =
                commAttriSetService.findCommAttSetListByMageId(po);
        return commAttriList;
    }
}
