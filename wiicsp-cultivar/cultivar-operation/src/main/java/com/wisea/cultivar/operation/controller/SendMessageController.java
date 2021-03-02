package com.wisea.cultivar.operation.controller;

import java.util.List;

import com.wisea.cultivar.operation.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cloud.model.po.LongIdsPo;
import com.wisea.cultivar.common.po.SendMessagePageListPo;
import com.wisea.cultivar.common.po.SendMessagePo;
import com.wisea.cultivar.common.po.SendMessageReciverPageListPo;
import com.wisea.cultivar.common.po.memb.MembListForMsgPo;
import com.wisea.cultivar.common.vo.SendMessageInfoVo;
import com.wisea.cultivar.common.vo.SendMessagePageListVo;
import com.wisea.cultivar.common.vo.memb.MembInfoListForMsgVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author XuDL(Wisea)
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

    @ApiOperation(value = "批量删除")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo batDelete(@RequestBody LongIdsPo po) {
        return service.batDelete(po);
    }
    /**
	 * 发送消息 -指定的时候查询所有的会员接口
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年10月20日
	 * @version 1.0
	 */
	@ApiOperation( value = "发送消息 -指定的时候查询所有的会员接口")
	@PostMapping("/findMembList")
	@DataCheck
	public ResultPoJo<List<MembInfoListForMsgVo>> membListForMsg(@RequestBody MembListForMsgPo po){
		// 返回参数
		return service.membListForMsg(po);
	}
}
