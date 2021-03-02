package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.po.MembMomentsPageListPo;
import com.wisea.cultivar.plant.po.MembMomentsPo;
import com.wisea.cultivar.plant.vo.MembMomentsInfoVo;
import com.wisea.cultivar.plant.service.MembMomentsService;
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
 * @className MembMomentsController
 * @date 2020/08/06 18:28:39
 * @Description
 */
@RestController
@RequestMapping("/w/membMoments")
@Api(tags = "圈子controller")
public class MembMomentsController {
    @Autowired
    private MembMomentsService service;

    @DataCheck
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(nickname = "油茶圈列表", value = "油茶圈列表", notes = "油茶圈列表", httpMethod = "POST")
    public ResultPoJo<List<MembMomentsInfoVo>> list(@RequestBody MembMomentsPageListPo po) {
        return service.findAllMembMoments(po);
    }

    @DataCheck
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增我的圈子信息", value = "新增我的圈子信息", notes = "新增我的圈子信息", httpMethod = "POST")
    public ResultPoJo add(@RequestBody MembMomentsPo po) {
        return service.addMembMoment(po);
    }

    @DataCheck
    @RequestMapping(value = "/ownPage", method = RequestMethod.POST)
    @ApiOperation(nickname = "圈子个人/客户主页(不分页)", value = "圈子个人/客户主页(不分页)", notes = "圈子个人/客户主页(不分页)", httpMethod = "POST")
    public ResultPoJo<List<MembMomentsInfoVo>> ownPage(@RequestBody MembMomentsPageListPo po) {
        return service.findOwnPage(po);
    }

    @DataCheck
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(nickname = "圈子搜索", value = "圈子搜索", notes = "圈子搜索,需要参数{membId, content}", httpMethod = "POST")
    public ResultPoJo<List<MembMomentsInfoVo>> search(@RequestBody MembMomentsPageListPo po) {
        return service.search(po);
    }

    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "圈子删除", value = "圈子删除", notes = "圈子删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }
}
