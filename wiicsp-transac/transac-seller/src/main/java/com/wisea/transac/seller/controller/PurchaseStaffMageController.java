package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.PurchaseStaffMagePageListPo;
import com.wisea.transac.common.po.PurchaseStaffMagePo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.PurchaseStaffMageInfoVo;
import com.wisea.transac.seller.service.PurchaseStaffMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className PurchaseStaffMageController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@RestController
@RequestMapping("/w/PurchaseStaffMage")
@Api(tags = "采购团队管理接口")
public class PurchaseStaffMageController {
    @Autowired
    private PurchaseStaffMageService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询PurchaseStaffMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Map<String,Object>> findPageList(@RequestBody PurchaseStaffMagePageListPo po) {
        po.setMembId(MembUtils.getMembInfoByUserId(SystemUtils.getUser().getId()).getMembId());
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除PurchaseStaffMage
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改PurchaseStaffMage
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody PurchaseStaffMagePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息PurchaseStaffMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<PurchaseStaffMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    @DataCheck
    @PostMapping("/send")
    @ApiOperation("发送邀请")
    public ResultPoJo send(@RequestBody LongIdPo po) {
        return service.send(po);
    }

    @DataCheck
    @PostMapping("/accept")
    @ApiOperation("接受邀请")
    public ResultPoJo accept(@RequestBody LongIdPo po) {
        return service.accept(SystemUtils.getUser().getId(),po.getId());
    }

    @DataCheck
    @PostMapping("/notAccept")
    @ApiOperation("拒绝邀请")
    public ResultPoJo notAccept(@RequestBody LongIdPo po) {
        return service.notAccept(SystemUtils.getUser().getId(),po.getId());
    }
}
