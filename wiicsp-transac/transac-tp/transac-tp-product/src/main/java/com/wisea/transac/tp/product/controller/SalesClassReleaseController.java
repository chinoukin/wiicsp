package com.wisea.transac.tp.product.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.product.CommMageTreePo;
import com.wisea.transac.common.po.product.CommSalesReleasUpdPo;
import com.wisea.transac.common.po.product.CommSalesReleaseInsertPo;
import com.wisea.transac.common.po.product.CommSalesReleasePagePo;
import com.wisea.transac.tp.product.service.SalesClassReleaseService;
import com.wisea.transac.common.vo.product.CammSalesReleaseMageListVo;
import com.wisea.transac.common.vo.product.CommSalesSetVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 销售分类 配置
 * @author: wangs
 * @date :2020/4/30
 */
@ApiModel("运营后台-app 分类配置信息 ")
@RestController
@RequestMapping(value = "/w/salesClassRelease")
public class SalesClassReleaseController {


    @Autowired
    SalesClassReleaseService salesClassReleaseService;

    /**
     * 查询销售分类配置列表
     *
     * @param commSalesReleasePagePo
     * @return
     */
    @ApiOperation(nickname = "查询销售分类 配置列表", value = "查询销售分类配置", notes = "查询销售分类配置")
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<CammSalesReleaseMageListVo>> findSalesClassReleaseList(@RequestBody CommSalesReleasePagePo commSalesReleasePagePo) {
        return salesClassReleaseService.findSalesClassReleaseList(commSalesReleasePagePo);
    }

    /**
     * 关联基础分类- 添加操作
     *
     * @param commSalesReleaseInsertPo
     * @return
     */
    @ApiOperation(nickname = "关联基础分类- 添加操作", value = "关联基础分类- 添加操作", notes = "关联基础分类- 添加操作")
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> saveOrUpdate(@RequestBody CommSalesReleaseInsertPo commSalesReleaseInsertPo) {
        return salesClassReleaseService.saveOrUpdate(commSalesReleaseInsertPo);
    }

    /**
     * 修改销售分类配置顺序
     *
     * @param commSalesReleasUpdPo
     * @return
     */
    @ApiOperation(nickname = "修改销售分类配置顺序", value = "修改销售分类配置顺序", notes = "修改销售分类配置顺序")
    @RequestMapping(value = "/updateSort", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> updateSort(@RequestBody CommSalesReleasUpdPo commSalesReleasUpdPo) {
        return salesClassReleaseService.updateSort(commSalesReleasUpdPo);
    }

    /**
     * 删除销售分类配置
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "删除销售分类配置", value = "删除销售分类配置", notes = "删除销售分类配置")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> del(@RequestBody LongIdPo po) {
        return salesClassReleaseService.del(po);
    }


    /**
     * 模糊查询销售品类,销售品类配置,品种
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "模糊查询销售品类,销售品类配置,品种", value = "模糊查询销售品类,销售品类配置,品种", notes = "模糊查询销售品类,销售品类配置,品种")
    @RequestMapping(value = "/findClassRelease", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<CommSalesSetVo>> findClassReleaseMage(@RequestBody CommMageTreePo po) {
        return salesClassReleaseService.findClassReleaseMage(po);
    }
}
