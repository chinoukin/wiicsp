package com.wisea.transac.tp.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.product.CommMageTreePo;
import com.wisea.transac.common.po.product.CommSalesReleasePagePo;
import com.wisea.transac.common.vo.product.CammSalesReleaseMageListVo;
import com.wisea.transac.common.vo.product.CommPubInfoListVo;
import com.wisea.transac.common.vo.product.SalesClassificationListVo;
import com.wisea.transac.tp.product.search.CommditySearchPojo;
import com.wisea.transac.tp.product.search.GeoGetPo;
import com.wisea.transac.tp.product.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description: 商品搜索
 * @author: wangs
 * @date :2020/5/14
 */
@Api(tags = "搜索列表展示相关接口,供小程序无登入权限访问资源")
@RestController
@RequestMapping(value = "/n")
public class ProductSearchController {


    @Autowired
    CommditySearchService commditySearchSercie;
    @Autowired
    GeoDistenceQueryService geoDistenceQueryService;
    @Autowired
    SalesClassificationService salesClassificationServices;
    @Autowired
    SalesClassReleaseService salesClassReleaseService;
    @Autowired
    CommPubHotSearchService commPubHotSearchService;

    /**
     * 搜索  所有商品 列表
     *
     * @param pojo
     * @return
     */
    @ApiOperation(value = "搜索商品", httpMethod = "POST")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResultPoJo<Map<String, Object>> search(@RequestBody CommditySearchPojo pojo) throws JsonProcessingException {
        // 返回参数
        return commditySearchSercie.restSearchSupply(pojo);
    }

    /**
     * 搜索  热搜商品 列表
     *
     * @param pojo
     * @return
     */
    @RequestMapping(value = "/searchNot", method = RequestMethod.POST)
    public ResultPoJo<Map<String, Object>> searchNot(@RequestBody CommditySearchPojo pojo) throws JsonProcessingException {
        // 返回参数
        return commditySearchSercie.restSearchHotWords(pojo);
    }

    /**
     * 新增地理位置的数据信息
     *
     * @param geoGetPo
     * @return
     */
    @ApiOperation(value = "新增地理位置的数据信息", httpMethod = "POST")
    @RequestMapping(value = "/addGeoLocation", method = RequestMethod.POST)
    public ResultPoJo addGeoLocation(@RequestBody GeoGetPo geoGetPo) {
        // 返回参数
        return geoDistenceQueryService.addIndexGeo(geoGetPo);
    }

    /**
     * 查询销售分类树
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询销售品类树", value = "查询销售品类树", notes = "查询销售品类树")
    @RequestMapping(value = "/findCommMageTree", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SalesClassificationListVo>> findCommMageTree(@RequestBody CommMageTreePo po) {
        return salesClassificationServices.findCommMageTree(po);
    }

    /**
     * 查询热销
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询火爆销售", value = "查询火爆销售", notes = "查询火爆销售")
    @RequestMapping(value = "/hotSellList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<CommPubInfoListVo>> hotSellList(@RequestBody LongIdPo po) {
        return commPubHotSearchService.hotSellList(po);
    }

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
}
