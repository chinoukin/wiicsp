package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.RealPersonAuthPageListPo;
import com.wisea.transac.common.po.RealPersonAuthPo;
import com.wisea.transac.common.vo.RealPersonAuthInfoVo;
import com.wisea.transac.common.vo.RealPersonAuthPageListVo;
import com.wisea.transac.common.vo.seller.AuthInfoVo;
import com.wisea.transac.seller.service.RealPersonAuthService;
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
 * @className RealPersonAuthController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Api(tags = "实人认证")
@RestController
@RequestMapping("/w/RealPersonAuth")
public class RealPersonAuthController {
    @Autowired
    private RealPersonAuthService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询RealPersonAuth
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<RealPersonAuthPageListVo>> findPageList(@RequestBody RealPersonAuthPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除RealPersonAuth
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
     * @Description 新增或修改RealPersonAuth
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody RealPersonAuthPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息RealPersonAuth
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<RealPersonAuthInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * 我要认证列表
     * @param
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/authList", method = RequestMethod.POST)
    @ApiOperation(nickname = "我要认证列表", value = "我要认证列表", notes = "我要认证列表", httpMethod = "POST")
    public ResultPoJo<AuthInfoVo> findAuthList() {
        return service.findAuthList();
    }


}
