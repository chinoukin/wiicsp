package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdsPo;
import com.wisea.transac.common.po.SaleStaffInfoMagePageListPo;
import com.wisea.transac.common.po.seller.StallsStaffRelaMagePo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMagePageListVo;
import com.wisea.transac.seller.service.StallsStaffRelaMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className StallsStaffRelaMageController
 * @date 2020/04/27 17:01:28
 * @Description
 */
@RestController
@RequestMapping("/w/StallsStaffRelaMage")
@Api(tags = "档口员工管理")
public class StallsStaffRelaMageController {
    @Autowired
    private StallsStaffRelaMageService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询StallsStaffRelaMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<SaleStaffInfoMagePageListVo>> findPageList(@RequestBody SaleStaffInfoMagePageListPo po) {
        return service.findPageList(po);
    }

    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody StallsStaffRelaMagePo po) {
        return service.saveOrUpdate(po);
    }

    @DataCheck
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    @ApiOperation(nickname = "按档口id查询所有关联员工", value = "按档口id查询所有关联员工", notes = "按档口id查询所有关联员工", httpMethod = "POST")
    public ResultPoJo<List<SaleStaffInfoMagePageListVo>> findAll(@RequestBody LongIdsPo po) {
        return service.findAll(po.getIds());
    }
}
