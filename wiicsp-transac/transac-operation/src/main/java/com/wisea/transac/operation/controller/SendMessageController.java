package com.wisea.transac.operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.SendMessagePageListPo;
import com.wisea.transac.common.po.SendMessagePo;
import com.wisea.transac.common.po.SendMessageReciverPageListPo;
import com.wisea.transac.common.vo.SendMessageInfoVo;
import com.wisea.transac.common.vo.SendMessagePageListVo;
import com.wisea.transac.common.vo.memb.MembInfoListForMsgVo;
import com.wisea.transac.operation.service.SendMessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SendMessageController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Api(tags = "发送消息接口")
@RestController
@RequestMapping("/w/SendMessage")
public class SendMessageController {
    @Autowired
    private SendMessageService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SendMessage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<SendMessagePageListVo>> findPageList(@RequestBody SendMessagePageListPo po) {
        return service.findPageList(po);
    }

    @DataCheck
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(nickname = "发送消息", value = "发送消息", notes = "发送消息", httpMethod = "POST")
    public ResultPoJo<Object> insert(@RequestBody SendMessagePo po) {
        return service.insert(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息SendMessage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<SendMessageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SendMessageReciver
     */
    @DataCheck
    @RequestMapping(value = "/reciver/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询接收者列表", value = "分页查询接收者列表", notes = "分页查询接收者列表", httpMethod = "POST")
    public ResultPoJo<Page<MembInfoListForMsgVo>> findReciverPageList(@RequestBody SendMessageReciverPageListPo po) {
        return service.findReciverPageList(po);
    }
}
