package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.entity.MeasUnitMage;
import com.wisea.cultivar.common.po.DelAllPo;
import com.wisea.cultivar.common.po.product.MeasUnitMageGetPo;
import com.wisea.cultivar.common.po.product.MeasUnitMageListPo;
import com.wisea.cultivar.common.vo.product.MeasUnitMageListVo;
import com.wisea.cultivar.infomanage.service.MeasUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/19 上午9:39
 * @Description:计量单位相关接口
 */
@Api(tags = "商品管理：计量单位管理")
@RestController
@PreAuthorize("hasAuthority('im:uma')")
@RequestMapping(value = "/w/measUnit")
public class MeasUnitController {


    @Autowired
    MeasUnitService measUnitService;

    /**
     * 查询计量单位列表
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "查询计量单位列表", notes = "请求参数是：计量单位名称,状态；返回一个集合")
    @DataCheck
    public ResultPoJo<List<MeasUnitMageListVo>> measList(@RequestBody MeasUnitMageListPo po) {
        ResultPoJo<List<MeasUnitMageListVo>> listResultPoJo = measUnitService.measList(po);
        return listResultPoJo;
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiOperation(value = "查询计量单位列表", notes = "请求参数是：计量单位名称,状态；返回一个集合")
    @DataCheck
    public ResultPoJo<Page<MeasUnitMageListVo>> measPage(@RequestBody MeasUnitMageListPo po) {
        ResultPoJo<Page<MeasUnitMageListVo>> pageResultPoJo = measUnitService.measPage(po);
        return pageResultPoJo;
    }

    /**
     * 添加计量单位
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加计量单位")
    @DataCheck
    public ResultPoJo addMeas(@RequestBody MeasUnitMage po) {
        ResultPoJo resultPoJo = measUnitService.addMeas(po);
        return resultPoJo;
    }

    /**
     * 获取计量单位详情
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "获取计量单位详情")
    @DataCheck
    public ResultPoJo editMeas(@RequestBody MeasUnitMageGetPo po) {
        ResultPoJo<MeasUnitMage> measUnitMageResultPoJo = measUnitService.editMeas(po);
        return measUnitMageResultPoJo;
    }

    /**
     * 修改计量单位
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ApiOperation(value = "修改计量单位")
    @DataCheck
    public ResultPoJo modifyMeas(@RequestBody MeasUnitMage po) {
        ResultPoJo resultPoJo = measUnitService.modifyMeas(po);
        return resultPoJo;
    }

    /**
     * 删除计量单位
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(value = "删除计量单位")
    @DataCheck
    public ResultPoJo delMeas(@RequestBody MeasUnitMage po) {
        ResultPoJo resultPoJo = measUnitService.delMeas(po);
        return resultPoJo;
    }
    /**
     * 批量删除计量单位
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/delAll", method = RequestMethod.POST)
    @ApiOperation(value = "删除计量单位")
    @DataCheck
    public ResultPoJo delAllMeas(@RequestBody DelAllPo po) {
        return measUnitService.delAll(po);
    }
}
