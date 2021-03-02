package com.wisea.transac.tp.product.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.entity.BrandMage;
import com.wisea.transac.common.po.product.BrandMageGetPo;
import com.wisea.transac.common.po.product.BrandMagePagePo;
import com.wisea.transac.common.vo.product.BrandMageGetVo;
import com.wisea.transac.common.vo.product.BrandMageListVo;
import com.wisea.transac.tp.product.service.CommBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/18 下午4:22
 * @Description:商品品牌相关接口
 */
@Api(tags = "商品管理：品牌管理")
@RestController
@RequestMapping(value = "/w/commBrand")
public class CommBrandController {


    @Autowired
    private CommBrandService commBrandService;

    /**
     * 查询品牌列表
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "查询品牌列表", notes = "请求参数是：品牌名称,返回一个品牌的集合")
    @DataCheck
    public ResultPoJo<Page<BrandMageListVo>> selectBrandList(@RequestBody BrandMagePagePo po) {
        ResultPoJo<Page<BrandMageListVo>> resultPoJo = commBrandService.selectBrandList(po);
        return resultPoJo;
    }

    /**
     * 添加品牌
     *
     * @param insert
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加品牌", notes = "请求参数是：品牌的整个Entity,返回一个添加之后的状态码")
    @DataCheck
    public ResultPoJo addBrand(@RequestBody BrandMage insert) {
        ResultPoJo resultPoJo = commBrandService.addBrand(insert);
        return resultPoJo;
    }

    /**
     * 品牌祥情
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "编辑品牌", notes = "请求参数是：品牌的ID,返回一个查询出来的对象")
    @DataCheck
    public ResultPoJo editBrand(@RequestBody BrandMageGetPo po) {
        ResultPoJo<BrandMageGetVo> brandMage = commBrandService.editBrand(po);
        return brandMage;
    }

    /**
     * 修改
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ApiOperation(value = "修改品牌",
            notes = "请求参数是：品牌的Entity,返回一个修改之后的状态码")
    @DataCheck
    public ResultPoJo modifyBrand(@RequestBody BrandMage po) {
        ResultPoJo resultPoJo = commBrandService.modifyBrand(po);
        return resultPoJo;
    }

    /**
     * 删除品牌
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(value = "删除品牌", notes = "请求参数是：品牌的ID,返回一个删除之后的状态码")
    @DataCheck
    public ResultPoJo deleteBrand(@RequestBody BrandMage po) {
        ResultPoJo resultPoJo = commBrandService.deleteBrand(po);
        return resultPoJo;
    }

    /**
     * 品牌业务接口
     *
     * @return
     */
    @RequestMapping(value = "/brandInterface", method = RequestMethod.POST)
    @ApiOperation(value = "品牌接口", notes = "请求参数是：；返回所有的品牌")
    @DataCheck
    public ResultPoJo brandInterface() {
        ResultPoJo resultPoJo = commBrandService.brandInterface();
        return resultPoJo;
    }
}
