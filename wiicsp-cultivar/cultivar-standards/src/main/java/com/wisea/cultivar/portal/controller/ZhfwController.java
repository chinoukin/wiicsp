package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.entity.ZhfwAdverSpaceMage;
import com.wisea.cultivar.portal.po.*;
import com.wisea.cultivar.portal.service.*;
import com.wisea.cultivar.portal.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * 此控制层中的接口不需要登录，可直接进行访问
 *
 * 2020/08/24 20:28:13
 */
@Api(tags = "此控制层中的接口不需要登录，可直接进行访问")
@RequestMapping(value = "/u/Zhfw")
@RestController
public class ZhfwController {
    @Autowired
    protected ZhfwBrandEntpRecoService zhfwBrandEntpRecoService;
    @Autowired
    protected ZhfwZczxListMageService zhfwZczxListMageService;
    @Autowired
    protected ZhfwFinSerApplRecordService zhfwFinSerApplRecordService;
    @Autowired
    protected ZhfwZczxCatgMageService zhfwZczxCatgMageService;
    @Autowired
    protected ZhfwIndustryVideoListService zhfwIndustryVideoListService;
    @Autowired
    protected ZhfwAdverSpaceMageService zhfwAdverSpaceMageService;
    @Autowired
    protected ZhfwAdverMageService zhfwAdverMageService;

    @ApiOperation(value = "服务中心-金融服务申请记录")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZhfwFinSerApplRecordInsertPo zhfwFinSerApplRecordInsertPo) {
        return zhfwFinSerApplRecordService.insert(zhfwFinSerApplRecordInsertPo);
    }

    @Autowired
    protected ZhfwCultureVideoListService zhfwCultureVideoListService;

    @ApiOperation(value = "油茶文化-宣传视频分页列表")
    @RequestMapping(value = "promotionalVideoFindPage", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwCultureVideoListListVo>> promotionalVideoFindPage(@RequestBody ZhfwCultureVideoListPagePo zhfwCultureVideoListPagePo) {
        return zhfwCultureVideoListService.findPage(zhfwCultureVideoListPagePo);
    }

    @ApiOperation(value = "查询种植服文化视频详情")
    @RequestMapping(value = "videoInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwCultureVideoListGetVo> videoInfo(@RequestBody ZhfwCultureVideoListGetPo zhfwCultureVideoListGetPo) {
        return zhfwCultureVideoListService.get(zhfwCultureVideoListGetPo);
    }

    @Autowired
    protected ZhfwCultureZxListService zhfwCultureZxListService;

    @ApiOperation(value = "油茶文化-文化资讯分页列表")
    @RequestMapping(value = "culturalInformationFindPage", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwCultureZxListListVo>> culturalInformationFindPage(@RequestBody ZhfwCultureZxListPagePo zhfwCultureZxListPagePo) {
        return zhfwCultureZxListService.findPage(zhfwCultureZxListPagePo);
    }

    @ApiOperation(value = "查询种植服文化资讯详情")
    @RequestMapping(value = "informationInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwCultureZxListGetVo> informationInfo(@RequestBody ZhfwCultureZxListGetPo zhfwCultureZxListGetPo) {
        return zhfwCultureZxListService.get(zhfwCultureZxListGetPo);
    }

    @Autowired
    protected ZhfwCultureZxRecoService zhfwCultureZxRecoService;

    @ApiOperation(value = "油茶文化-文化资讯推荐分页列表")
    @RequestMapping(value = "recommendedFindPage", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwCultureZxRecoListVo>> recommendedFindPage(@RequestBody ZhfwCultureZxRecoPagePo zhfwCultureZxRecoPagePo) {
        zhfwCultureZxRecoPagePo.setShowFlag("0");
        return zhfwCultureZxRecoService.findPage(zhfwCultureZxRecoPagePo);
    }

    @ApiOperation(value = "种植服务资料分类管理树形结构数据")
    @RequestMapping(value = "tree", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwZczxCatgMageTreeVo>> getTree(@RequestBody ZhfwZczxCatgMageTreePo zhfwZczxCatgMageTreePo) {
        return zhfwZczxCatgMageService.getTree(zhfwZczxCatgMageTreePo);
    }

//    @ApiOperation(value = "获取种植服务政策咨询管理分页列表")
//    @RequestMapping(value = "ZhfwZczxListMagePage", method = RequestMethod.POST)
//    @DataCheck
//    public ResultPoJo<Page<ZhfwZczxListMageListVo>> findZhfwZczxListMagePage(@RequestBody ZhfwZczxListMagePagePo zhfwZczxListMagePagePo) {
//        return zhfwZczxListMageService.findZhfwZczxListMagePage(zhfwZczxListMagePagePo);
//    }


    @ApiOperation(value = "获取种植服务政策咨询管理分页列表")
    @RequestMapping(value = "ZhfwZczxListMagePage", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwZczxListMageListVo>> findZhfwZczxListMagePage(@RequestBody ZhfwZczxListMagePagePo zhfwZczxListMagePagePo) {
        return zhfwZczxListMageService.getlevelList(zhfwZczxListMagePagePo);
    }

    @ApiOperation(value = "获取种植服务品牌企业推荐分页列表")
    @RequestMapping(value = "findZhfwBrandEntpRecoPage", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwBrandEntpRecoListVo>> findZhfwBrandEntpRecoPage(@RequestBody ZhfwBrandEntpRecoPagePo zhfwBrandEntpRecoPagePo) {
        return zhfwBrandEntpRecoService.findPage(zhfwBrandEntpRecoPagePo);
    }

    @ApiOperation(value = "获取种植服务产业视频列表分页列表")
    @RequestMapping(value = "findZhfwIndustryVideoListPage", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwIndustryVideoListListVo>> findZhfwIndustryVideoListPage(@RequestBody ZhfwIndustryVideoListPagePo zhfwIndustryVideoListPagePo) {
        return zhfwIndustryVideoListService.findPage(zhfwIndustryVideoListPagePo);
    }

    @ApiOperation(value = "查询种植服务政策咨询管理")
    @RequestMapping(value = "getZhfwZczxListMage", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwZczxListMageGetVo> getZhfwZczxListMage(@RequestBody ZhfwZczxListMageGetPo zhfwZczxListMageGetPo) {
        return zhfwZczxListMageService.get(zhfwZczxListMageGetPo);
    }

    @ApiOperation(value = "获取种植服务广告位管理分页列表")
    @RequestMapping(value = "pageZhfwAdverSpaceMagePage", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwAdverSpaceMageListVo>> findPage(@RequestBody ZhfwAdverSpaceMagePagePo zhfwAdverSpaceMagePagePo) {
        return zhfwAdverSpaceMageService.findPage(zhfwAdverSpaceMagePagePo);
    }


    @ApiOperation(value = "获取种植服务广告管理分页列表")
    @RequestMapping(value = "pageZhfwAdverMagePagePo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwAdverMageListVo>> pageZhfwAdverMagePagePo(@RequestBody ZhfwAdverMagePagePo zhfwAdverMagePagePo) {
        /**
         * 获取id
         */
        ZhfwAdverSpaceMage zhfwAdverSpaceMage = zhfwAdverSpaceMageService.selectByAdverSpaceName(zhfwAdverMagePagePo.getAdverName());
        ZhfwAdverMagePagePo zhfwAdverMagePage = new ZhfwAdverMagePagePo();
        zhfwAdverMagePage.setAdverSpaceId(zhfwAdverSpaceMage.getId());
        return zhfwAdverMageService.findByAdverSpaceId(zhfwAdverMagePage);
    }
}
