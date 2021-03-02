package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.bigdata.service.AnnualSalesTargetService;
import com.wisea.cultivar.common.entity.bigdata.AnnualSalesTarget;
import com.wisea.cultivar.common.po.bigdata.AnnualSalesTargetPo;
import com.wisea.cultivar.common.po.bigdata.TotalSalesPo;
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
 * @className AnnualSalesTargetController
 * @date 2020/02/07 18:53:13
 * @Description
 */
@RestController
@Api(tags = "年销售额目标管理")
@RequestMapping("/w/annualSalesTarget")
public class AnnualSalesTargetController {
    @Autowired
    private AnnualSalesTargetService service;

    /**
     * @author wbf-code-generator
     * @date 2020/02/07 18:53:13
     * @Description 分页查询AnnualSalesTarget
     */
    /*@DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<AnnualSalesTargetPageListVo>> findPageList(@RequestBody AnnualSalesTargetPageListPo po) {
        return service.findPageList(po);
    }*/

    /**
     * @author wbf-code-generator
     * @date 2020/02/07 18:53:13
     * @Description 逻辑删除AnnualSalesTarget
     */
    /*@DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }*/

    /**
     * @author wbf-code-generator
     * @date 2020/02/07 18:53:13
     * @Description 新增或修改AnnualSalesTarget
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改年销售额目标", value = "新增或修改年销售额目标", notes = "新增或修改年销售额目标", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody AnnualSalesTargetPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author jirg
     * @date 2020/02/07 18:53:13
     * @Description 根据年份查询年销售额目标
     */
    @DataCheck
    @RequestMapping(value = "/findByYear", method = RequestMethod.POST)
    @ApiOperation(nickname = "根据年份查询年销售额目标", value = "根据年份查询年销售额目标", notes = "根据年份查询年销售额目标", httpMethod = "POST")
    public ResultPoJo<AnnualSalesTarget> findByYear(@RequestBody TotalSalesPo po) {
        return service.findByYear(po);
    }
}
