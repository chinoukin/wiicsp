package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.ReceAddressPageListPo;
import com.wisea.transac.common.po.ReceAddressPo;
import com.wisea.transac.common.vo.ReceAddressInfoVo;
import com.wisea.transac.common.vo.ReceAddressPageListVo;
import com.wisea.transac.seller.service.ReceAddressService;
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
 * @className ReceAddressController
 * @date 2020/12/02 13:57:00
 * @Description
 */
@Api(tags = "发货地址管理")
@RestController
@RequestMapping("/w/ReceAddress")
public class ReceAddressController {
    @Autowired
    private ReceAddressService service;

    /**
     * @author wbf-code-generator
     * @date 2020/12/02 13:57:00
     * @Description 分页查询ReceAddress
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<List<ReceAddressPageListVo>> findPageList(@RequestBody ReceAddressPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/12/02 13:57:00
     * @Description 逻辑删除ReceAddress
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/12/02 13:57:00
     * @Description 新增或修改ReceAddress
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody ReceAddressPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/12/02 13:57:00
     * @Description 查询详细信息ReceAddress
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<ReceAddressInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }
}
