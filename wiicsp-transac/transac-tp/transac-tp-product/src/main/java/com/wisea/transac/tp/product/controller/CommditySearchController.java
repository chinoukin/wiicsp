package com.wisea.transac.tp.product.controller;

/**
 * @Description:
 * @author: wangs
 * @date :2020/5/13
 */

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.tp.product.service.CommditySearchService;
import com.wisea.transac.tp.product.service.MerchandiseService;
import com.wisea.transac.tp.product.service.NoticeService;
import com.wisea.transac.common.po.product.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 商家商品管理信息
 * @author: wangs
 * @date :2020/5/11
 */
@Api(value = "commditySearch", description = "索引信息", tags = "索引信息,调用接口")
@RestController
@RequestMapping("/w/commditySearch")
public class CommditySearchController {

    @Autowired
    CommditySearchService commditySearchService;
    @Autowired
    MerchandiseService merchandiseService;
    @Autowired
    NoticeService noticeService;

    /**
     * 批量更新 商品信息 index中信息
     *
     * @param batchUpdSearchPo
     * @return
     */
    @ApiOperation(value = "根据商品id修改索引库中商品信息", httpMethod = "POST")
    @RequestMapping(value = "/updateBatchCommdity", method = RequestMethod.POST)
    public ResultPoJo updateBatchCommditySearch(@RequestBody BatchUpdSearchPo batchUpdSearchPo) {
        return commditySearchService.updateBatchCommditySearch(batchUpdSearchPo);
    }

    /**
     * 因档口删除，档口为空，商品下架
     *
     * @param commPubInfoPagePo
     * @return
     */
    @ApiOperation(value = "因档口删除，档口为空，商品变成下架状态", httpMethod = "POST")
    @RequestMapping(value = "/updateCommPubSearch", method = RequestMethod.POST)
    public ResultPoJo updateCommPubSearch(@RequestBody CommPubInfoPagePo commPubInfoPagePo) {
        return commditySearchService.updateCommPubSearch(commPubInfoPagePo);
    }

    /**
     * 删除 商品信息 index 中索引信息
     *
     * @param commPubInfoGetPo
     * @return
     */
    @ApiOperation(value = "根据商品id删除索引中的信息", httpMethod = "POST")
    @RequestMapping(value = "/delCommdityById", method = RequestMethod.POST)
    public ResultPoJo<String> delIndexSearch(@RequestBody CommPubInfoGetPo commPubInfoGetPo) {
        return commditySearchService.delIndexSearch(commPubInfoGetPo);
    }

    /**
     * 更新 商品信息 index中信息
     *
     * @param commPubInfoGetPo
     * @return
     */
    @ApiOperation(value = "根据商品id修改索引库中商品信息", httpMethod = "POST")
    @RequestMapping(value = "/updateCommdity", method = RequestMethod.POST)
    public ResultPoJo<String> updateIndexSearch(@RequestBody CommPubInfoGetPo commPubInfoGetPo) {
        return commditySearchService.updateIndexSearch(commPubInfoGetPo);
    }


    /**
     * 市场 - 变更商品审核设置,
     * <p>
     * 如果需要审核 ,需要将之前所有待审核的商品状态变成销售中
     * 同时 更新到索引库中
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/updateCommPubState", method = RequestMethod.POST)
    public ResultPoJo updateCommPubState(@RequestBody CommDataListPo po) {
        return merchandiseService.updateCommPubState(po);
    }

    /**
     * 发送通知消息
     *
     * @param noticeProcutPo
     * @return
     */
    @ApiOperation(value = "发送通知消息", httpMethod = "POST")
    @RequestMapping(value = "/sendNotict", method = RequestMethod.POST)
    public ResultPoJo<String> sendNotict(@RequestBody NoticeProcutPo noticeProcutPo) {
        return noticeService.sendNoticeSer(noticeProcutPo);
    }
}
