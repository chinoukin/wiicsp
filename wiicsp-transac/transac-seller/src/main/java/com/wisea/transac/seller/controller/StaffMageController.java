package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.po.SaleStaffInfoMagePageListPo;
import com.wisea.transac.common.po.seller.FindInfoByStallsMageIdPo;
import com.wisea.transac.common.po.seller.StaffMagePo;
import com.wisea.transac.common.po.seller.UpdEffeInvalStatePo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMageInfoVo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMagePageListVo;
import com.wisea.transac.common.vo.seller.StaffMageVo;
import com.wisea.transac.seller.service.StaffMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "员工管理")
@RestController
@RequestMapping("/w/StaffMage")
public class StaffMageController {

    @Autowired
    private StaffMageService staffMageService;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询SaleStaffInfoMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<SaleStaffInfoMagePageListVo>> findPageList(@RequestBody SaleStaffInfoMagePageListPo po) {
        return staffMageService.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询SaleStaffInfoMage
     */
    @DataCheck
    @RequestMapping(value = "/findSelectPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "选择员工分页查询列表", value = "选择员工分页查询列表", notes = "选择员工分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<SaleStaffInfoMagePageListVo>> findSelectPageList(@RequestBody SaleStaffInfoMagePageListPo po) {
        po.setSfAdminFlag(DictConstants.SF_ADMIN_FLAG_1);
        po.setEffeInvalState(DictConstants.EFFE_INVAL_STATE_0);
        return staffMageService.findPageList(po);
    }


    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 新增或修改StallsMage
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo<StaffMageVo> saveOrUpdate(@RequestBody StaffMagePo po) {
        return staffMageService.saveOrUpdate(po);
    }


    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除MembInfo
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return staffMageService.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 冻结启用
     */
    @DataCheck
    @RequestMapping(value = "/updEffeInvalState", method = RequestMethod.POST)
    @ApiOperation(nickname = "冻结启用", value = "冻结启用", notes = "冻结启用", httpMethod = "POST")
    public ResultPoJo updEffeInvalState(@RequestBody UpdEffeInvalStatePo po) {
        return staffMageService.updEffeInvalState(po);
    }
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息SaleStaffInfoMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<SaleStaffInfoMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return staffMageService.findInfo(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息SaleStaffInfoMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfoByStallsMageId", method = RequestMethod.POST)
    @ApiOperation(nickname = "根据档口ID查询销售员工", value = "根据档口ID查询销售员工", notes = "根据档口ID查询销售员工", httpMethod = "POST")
    public List<SaleStaffInfoMageInfoVo> findInfoByStallsMageId(@RequestBody FindInfoByStallsMageIdPo po) {
        return staffMageService.findInfoByStallsMageId(po);
    }
}
