package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.bigdata.service.SampInfoService;
import com.wisea.cultivar.common.po.bigdata.SampInfoPo;
import com.wisea.cultivar.common.vo.bigdata.SampInfoDataVo;
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
 * @className GoodsRecallController
 * @date 2020/09/03 10:07:58
 * @Description
 */
@RestController
@RequestMapping("/w/sampInfo")
@Api(tags = "监测大数据->抽样监测数据")
public class SampInfoController {
    @Autowired
    private SampInfoService service;



    /**
     * @author wbf-code-generator
     * @date 2020/09/03 10:07:581
     * @Description 查询抽样监测数据
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询抽样监测数据", value = "查询抽样监测数据", notes = "查询抽样监测数据", httpMethod = "POST")
    public ResultPoJo<SampInfoDataVo> findInfo(@RequestBody  SampInfoPo po) {
        return service.findInfo(po);
    }

    /**
     * 查询抽样监测数据
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findQDInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询抽样监测数据", value = "查询抽样监测数据", notes = "查询抽样监测数据", httpMethod = "POST")
    public ResultPoJo<SampInfoDataVo> findQDInfo(@RequestBody  SampInfoPo po) {
        return service.findQDInfo(po);
    }
}
