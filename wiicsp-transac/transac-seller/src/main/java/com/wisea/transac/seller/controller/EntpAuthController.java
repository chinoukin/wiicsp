package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.po.EntpAuthPageListPo;
import com.wisea.transac.common.po.EntpAuthPo;
import com.wisea.transac.common.po.seller.EntpAuthParPo;
import com.wisea.transac.common.po.seller.IndBusiAuthPo;
import com.wisea.transac.common.vo.EntpAuthInfoVo;
import com.wisea.transac.common.vo.EntpAuthPageListVo;
import com.wisea.transac.seller.service.EntpAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className EntpAuthController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Api(tags = "企业认证/个体工商户")
@RestController
@RequestMapping("/w/EntpAuth")
public class EntpAuthController {
    @Autowired
    private EntpAuthService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询EntpAuth
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<EntpAuthPageListVo>> findPageList(@RequestBody EntpAuthPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除EntpAuth
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
     * @Description 新增或修改EntpAuth
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdEntp", method = RequestMethod.POST)
    @ApiOperation(nickname = "企业认证新增或修改", value = "企业认证新增或修改", notes = "企业认证新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdEntp(@RequestBody EntpAuthParPo po) {
        EntpAuthPo entity = new EntpAuthPo();
        BeanUtils.copyProperties(po, entity);
        entity.setCustType(DictConstants.CUST_TYPE_0);
        return service.saveOrUpdate(entity);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改EntpAuth
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdBusi", method = RequestMethod.POST)
    @ApiOperation(nickname = "个体工商户新增或修改", value = "个体工商户新增或修改", notes = "个体工商户新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdEntp(@RequestBody IndBusiAuthPo po) {
        EntpAuthPo entity = new EntpAuthPo();
        BeanUtils.copyProperties(po, entity);
        entity.setCustType(DictConstants.CUST_TYPE_1);
        return service.saveOrUpdate(entity);
    }


    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息EntpAuth
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<EntpAuthInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

//    @DataCheck
//    @RequestMapping(value = "/findEntpInfo", method = RequestMethod.POST)
//    @ApiOperation(nickname = "根据当前登陆的人查询企业详情", value = "根据当前登陆的人查询企业详情", notes = "根据当前登陆的人查询企业详情", httpMethod = "POST")
//    public ResultPoJo<EntpAuthInfoVo> findEntpInfo() {
//        MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUser().getId());
//
//        LongIdPo idPo = new LongIdPo();
//        idPo.setId(membBaseInfo.getMembId());
//
//        return service.findInfoByMembId(idPo);
////        return service.findInfo(po);
//    }


}
