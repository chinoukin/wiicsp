package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.bigdata.service.GoodsRecallService;
import com.wisea.cultivar.common.vo.bigdata.GoodsRecallVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className GoodsRecallController
 * @date 2020/09/03 10:07:58
 * @Description
 */
@RestController
@RequestMapping("/w/goodsRecall")
@Api(tags = "监测大数据->质量问题召回")
public class GoodsRecallController {
    @Autowired
    private GoodsRecallService service;



    /**
     * @author wbf-code-generator
     * @date 2020/09/03 10:07:58
     * @Description 查询商品召回详细信息GoodsRecall
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询商品召回信息", value = "查询商品召回信息", notes = "查询商品召回信息", httpMethod = "POST")
    public ResultPoJo<GoodsRecallVo> findInfo() {
        return service.findInfo();
    }

    /**
     * 查询册亨县
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findCeHengInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询册亨县", value = "查询册亨县", notes = "查询册亨县", httpMethod = "POST")
    public ResultPoJo<GoodsRecallVo> findCeHengInfo() {
        return service.findCeHengInfo();
    }
}
