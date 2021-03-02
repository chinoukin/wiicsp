package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.po.*;
import com.wisea.cultivar.plant.vo.*;
import com.wisea.cultivar.plant.service.ItemMageService;
import com.wisea.cultivar.plant.service.SerListMageService;
import com.wisea.cultivar.plant.service.SproutCatalogMageService;
import com.wisea.cultivar.plant.service.SubsidyApplMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className 种苗目录/定点采购/补助项目
 * @date 2020/08/07 10:13:35
 * @Description
 */
@Api(tags = "种苗目录/定点采购/补助项目")
@RestController
@RequestMapping("/w/HomePageAbove")
public class HomePageAboveController {
    @Autowired
    private SproutCatalogMageService service;
    @Autowired
    private ItemMageService itemMageService;
    @Autowired
    private SerListMageService serListMageService;
    @Autowired
    private SubsidyApplMageService subsidyApplMageService;


    /**
     * @author wbf-code-generator
     * @date 2020/08/07 10:13:35
     * @Description 种苗目录分页查询列表
     */
    @DataCheck
    @RequestMapping(value = "/findSproutCatalogPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "种苗目录分页查询列表", value = "种苗目录分页查询列表", notes = "种苗目录分页查询列表", httpMethod = "POST")
    public ResultPoJo<SproutCatalogMageAndEntpVo> findPageList(@RequestBody OilTeaVarietMagePageListPo po) {
        return service.findPageList(po);
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/07 10:13:35
     * @Description 种苗目录查询详细信息
     */
    @DataCheck
    @RequestMapping(value = "/findSproutCatalogInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "种苗目录查询详细信息", value = "种苗目录查询详细信息", notes = "种苗目录查询详细信息", httpMethod = "POST")
    public ResultPoJo<OilTeaVarietMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/07 10:13:35
     * @Description 补助项目管理分页查询列表
     */
    @DataCheck
    @RequestMapping(value = "/findItemMagePageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "补助项目管理分页查询列表", value = "补助项目管理分页查询列表", notes = "补助项目管理分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<ItemMagePageListVo>> findItemMagePageList(@RequestBody ItemMagePageListPo po) {
        return itemMageService.findItemMagePageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/08 09:47:10
     * @Description 查询申请指南
     */
    @DataCheck
    @RequestMapping(value = "/findGuideInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询申请指南", value = "查询申请指南", notes = "查询申请指南", httpMethod = "POST")
    public ResultPoJo<ItemMageInfoVo> findGuideInfo(@RequestBody LongIdPo po) {
        return itemMageService.findGuideInfo(po);
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/07 10:13:35
     * @Description 采购记录显示分页查询列表
     */
    @DataCheck
    @RequestMapping(value = "/findRecordPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "采购记录显示分页查询列表", value = "采购记录显示分页查询列表", notes = "采购记录显示分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<SerListMagePageListVo>> findRecordPageList(@RequestBody SerListMagePageListPo po) {
        return serListMageService.findRecordPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/08 09:47:10
     * @Description 新增或修改补贴申请
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdateSubsidy", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改补贴申请", value = "新增或修改补贴申请", notes = "新增或修改补贴申请", httpMethod = "POST")
    public ResultPoJo saveOrUpdateSubsidy(@RequestBody SubsidyDeclarePo po) {

        return subsidyApplMageService.saveOrUpdateSubsidy(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/08 09:47:10
     * @Description 显示补贴申请详情
     */
    @DataCheck
    @RequestMapping(value = "/showSubsidyinfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "显示补贴申请详情", value = "显示补贴申请详情", notes = "显示补贴申请详情", httpMethod = "POST")
    public ResultPoJo<SubsidyApplMageInfoVo> showSubsidyinfo(@RequestBody CommVo po) {

        return subsidyApplMageService.showSubsidyinfo(po);
    }



    /**
     * @author wbf-code-generator
     * @date 2020/08/07 10:13:35
     * @Description 定点采购
     */
    @DataCheck
    @RequestMapping(value = "/findPurchasePageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "定点采购分页查询列表", value = "定点采购分页查询列表", notes = "定点采购分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<ZhfwCommPubInfoPageListVo>> findPurchasePageList(@RequestBody ZhfwCommPubInfoPageListPo po) {
        return itemMageService.findPurchasePageList(po);
    }

}
