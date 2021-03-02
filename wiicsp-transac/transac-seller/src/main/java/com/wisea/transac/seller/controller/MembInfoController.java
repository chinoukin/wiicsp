package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.MembInfoPageListPo;
import com.wisea.transac.common.po.MembInfoPo;
import com.wisea.transac.common.vo.MembInfoInfoVo;
import com.wisea.transac.common.vo.MembInfoPageListVo;
import com.wisea.transac.common.vo.seller.MembInfoVo;
import com.wisea.transac.common.vo.trade.ChartVo;
import com.wisea.transac.seller.service.MembInfoService;
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
 * @className MembInfoController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@RestController
@Api(tags = "账号信息")
@RequestMapping("/w/MembInfo")
public class MembInfoController {
    @Autowired
    private MembInfoService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询MembInfo
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<MembInfoPageListVo>> findPageList(@RequestBody MembInfoPageListPo po) {
        return service.findPageList(po);
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
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改MembInfo
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改会员信息", value = "新增或修改会员信息", notes = "新增或修改会员信息", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody MembInfoPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息MembInfo
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<MembInfoInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询账号信息MembInfo
     */
    @DataCheck
    @RequestMapping(value = "/findAccount", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询账号信息", value = "查询账号信息", notes = "查询账号信息", httpMethod = "POST")
    public ResultPoJo<MembInfoVo> findMembInfo() {
        return service.findMembInfo();
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 修改账号信息
     */
    @DataCheck
    @RequestMapping(value = "/updAccount", method = RequestMethod.POST)
    @ApiOperation(nickname = "修改账号信息", value = "修改账号信息", notes = "修改账号信息", httpMethod = "POST")
    public ResultPoJo updAccount(@RequestBody MembInfoPo po) {
        return service.updAccount(po);
    }

    /**
     * 查询用户数量
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询用户数量", value = "查询用户数量", notes = "查询用户数量", httpMethod = "POST")
    public ResultPoJo<List<ChartVo>> findUser() {
        return service.findUser();
    }

}
