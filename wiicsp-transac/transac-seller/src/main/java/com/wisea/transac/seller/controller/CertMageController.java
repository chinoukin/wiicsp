package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.seller.CertMagePageListPo;
import com.wisea.transac.common.po.seller.CertMagePo;
import com.wisea.transac.seller.service.CertMageService;
import com.wisea.transac.common.vo.seller.CertMageInfoVo;
import com.wisea.transac.common.vo.seller.CertMagePageListVo;
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
 * @className CertMageController
 * @date 2020/04/27 17:01:28
 * @Description
 */
@RestController
@RequestMapping("/w/CertMage")
@Api(tags = "证书管理")
public class CertMageController {
    @Autowired
    private CertMageService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询CertMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<CertMagePageListVo>> findPageList(@RequestBody CertMagePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 新增或修改CertMage
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo save(@RequestBody CertMagePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息CertMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<CertMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    @DataCheck
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(nickname = "删除", value = "删除", notes = "删除", httpMethod = "POST")
    public ResultPoJo delete(@RequestBody LongIdPo po) {
        return service.logicDel(po);

    }
}
