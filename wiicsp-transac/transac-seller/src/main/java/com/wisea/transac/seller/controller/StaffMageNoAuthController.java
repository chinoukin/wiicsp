package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.transac.common.po.seller.FindInfoByStallsMageIdPo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMageInfoVo;
import com.wisea.transac.seller.service.StaffMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags = "员工管理(无权限)")
@RestController
@RequestMapping("/n/StaffMage")
public class StaffMageNoAuthController {
    @Autowired
    private StaffMageService staffMageService;
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
