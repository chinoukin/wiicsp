package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.po.system.*;
import com.wisea.transac.common.vo.system.SellerSpeSerCostMageListVo;
import com.wisea.transac.tp.system.service.SellerSpeSerCostMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商家特殊服务费管理
 * @author wangjiahao
 * @version 1.0
 * @className SellerSpeSerCostMageController
 * @since 2019-01-14 13:37
 */
@Api(tags = "【后台设置】商家特殊服务费管理")
@RestController
@RequestMapping("/w/spe/serCost")
public class SellerSpeSerCostMageController {
    @Autowired
    private SellerSpeSerCostMageService speSerCostMageService;

    /**
     * 分页查询
     * @param po
     * @return
     */
    @DataCheck
    @PostMapping("/list")
    @ApiOperation(value = "【特殊服务费】分页查询",nickname = "【特殊服务费】按ID查询",notes = "【特殊服务费】可以根据compName查询")
    public ResultPoJo<Page<SellerSpeSerCostMageListVo>> findForPage(@RequestBody SellerSpeSerCostMagePagePo po) {
        return speSerCostMageService.findForPage(po);
    }

    /**
     * 按ID查询
     * @param po
     * @return
     */
    @DataCheck
    @PostMapping("/query")
    @ApiOperation(value = "【特殊服务费】按ID查询",nickname = "【特殊服务费】按ID查询",notes = "【特殊服务费】按ID查询")
    public ResultPoJo<SellerSpeSerCostMageListVo> findById(@RequestBody SellerSpeSerCostMageGetPo po) {
        return speSerCostMageService.findById(po);
    }

    /**
     * 新增数据
     * @param po
     * @return
     */
    @DataCheck
    @PostMapping("/add")
    @ApiOperation(value = "【特殊服务费】新增",nickname = "【特殊服务费】新增",notes = "【特殊服务费】新增，不可以对同一卖家和买家设置两次及以上")
    public ResultPoJo addOne(@RequestBody SellerSpeSerCostMageInsertPo po) {
        return speSerCostMageService.addOne(po);
    }

    /**
     * 按ID修改一条记录
     * @param po
     * @return
     */
    @DataCheck
    @PostMapping("/update")
    @ApiOperation(value = "【特殊服务费】修改",nickname = "【特殊服务费】修改",notes = "【特殊服务费】修改")
    public ResultPoJo updateOne(@RequestBody SellerSpeSerCostMageUpdatePo po) {
        return speSerCostMageService.updateOne(po);
    }

    /**
     * 按ID修改一条记录
     * @param po
     * @return
     */
    @DataCheck
    @PostMapping("/delete")
    @ApiOperation(value = "【特殊服务费】删除",nickname = "【特殊服务费】删除",notes = "【特殊服务费】可以批量删除")
    public ResultPoJo delete(@RequestBody SellerSpeSerCostMageBatDeletePo po) {
        return speSerCostMageService.delete(po);
    }
}
