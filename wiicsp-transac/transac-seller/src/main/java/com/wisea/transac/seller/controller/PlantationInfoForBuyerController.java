package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.seller.PlantationInfoPagePo;
import com.wisea.transac.common.vo.seller.PlantationInfoVo;
import com.wisea.transac.seller.service.PlantationInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jirg
 * @version 1.0
 * @className PlantationInfoController
 * @date 2020/7/2 16:41
 * @Description 种植园管理
 */
@RestController
@RequestMapping("/w/buyer/plantation")
@Api(tags = "【数字基地】种植园-买家")
public class PlantationInfoForBuyerController {

    @Autowired
    private PlantationInfoService service;

    /**
     * @author jirg
     * @date 2020/7/2 17:02
     * @Description 种植园列表
     */
    @DataCheck
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @ApiOperation(nickname = "种植园列表【入参：基地ID】", value = "种植园列表【入参：基地baseID】", notes = "种植园列表【入参：基地baseID】", httpMethod = "POST")
    public ResultPoJo<Page<PlantationInfoVo>> findList(@RequestBody PlantationInfoPagePo po) {
        return service.findListForBuyer(po);
    }

    /**
     * @author jirg
     * @date 2020/7/2 17:03
     * @Description 种植园详细信息
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "种植园详细信息", value = "种植园详细信息", notes = "种植园详细信息", httpMethod = "POST")
    public ResultPoJo<PlantationInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfoForBuyer(po);
    }

}
