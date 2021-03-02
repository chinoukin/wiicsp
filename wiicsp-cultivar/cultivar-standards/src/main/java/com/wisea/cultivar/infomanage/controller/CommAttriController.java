package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.entity.ZhfwCommAttriMage;
import com.wisea.cultivar.common.po.DelAllPo;
import com.wisea.cultivar.common.po.product.CommAttriMageGetPo;
import com.wisea.cultivar.common.po.product.CommAttriMagePagePo;
import com.wisea.cultivar.common.vo.product.CommAttriMageListVo;
import com.wisea.cultivar.infomanage.service.CommAttriService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/19 下午4:00
 * @Description:基础品类属性相关接口
 */
@Api(tags = "商品管理：商品属性管理")
@RestController
@PreAuthorize("hasAuthority('im:gat')")
@RequestMapping(value = "/w/commAttri")
public class CommAttriController {


    @Autowired
    private CommAttriService commAttriService;

    /**
     * 查询商品属性列表
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "查询商品属性列表", notes = "请求参数是：属性名称，以及状态")
    @DataCheck
    public Page<CommAttriMageListVo> selectList(@RequestBody CommAttriMagePagePo po) {
        Page<CommAttriMageListVo> commAttriMageListVoPage = commAttriService.selectList(po);
        return commAttriMageListVoPage;
    }

    /**
     * 新增属性信息
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加属性")
    @DataCheck
    public ResultPoJo addCommAttri(@RequestBody ZhfwCommAttriMage po) {
        ResultPoJo resultPoJo = commAttriService.addCommAttri(po);
        return resultPoJo;
    }

    /**
     * 属性字段的唯一性验证
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/unique/attriColumn", method = RequestMethod.POST)
    @ApiOperation(value = "属性字段的唯一验证", notes = "请求参数是：属性字段的字符串；返回是否存在的状态")
    @DataCheck
    public ResultPoJo getAttriColumnOnlyState(@RequestBody ZhfwCommAttriMage po) {
        ResultPoJo attriColumnOnlyState = commAttriService.getAttriColumnOnlyState(po);
        return attriColumnOnlyState;
    }

    /**
     * 属性详情
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "属性详情")
    @DataCheck
    public ResultPoJo editCommAttri(@RequestBody CommAttriMageGetPo po) {
        ResultPoJo<ZhfwCommAttriMage> commAttriMageResultPoJo = commAttriService.editCommAttri(po);
        return commAttriMageResultPoJo;
    }

    /**
     * 修改商品商品属性
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ApiOperation(value = "修改商品属性")
    @DataCheck
    public ResultPoJo modifyCommAttri(@RequestBody ZhfwCommAttriMage po) {
        ResultPoJo resultPoJo = commAttriService.modifyCommAttri(po);
        return resultPoJo;
    }

    /**
     * 删除属性
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(value = "删除属性")
    @DataCheck
    public ResultPoJo delCommAttri(@RequestBody ZhfwCommAttriMage po) {
        ResultPoJo resultPoJo = commAttriService.delCommAttri(po);
        return resultPoJo;
    }
    @ApiOperation(value = "批量删除")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody DelAllPo po) {
        return commAttriService.batDelete(po);
    }


}
