package com.wisea.cultivar.infomanage.controller;

import com.wisea.cultivar.common.po.TIMNoticeSendPo;
import com.wisea.cultivar.infomanage.service.TIMNoticeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * TIM通知管理Controller
 *
 * @author XuDL(Wisea)
 * <p>
 * 2020年5月6日 下午4:18:16
 */
@Api(tags = "TIM通知发送接口")
@RequestMapping(value = "/w/tim/noticeManager")
@RestController
public class TIMNoticeManagerController {
    @Autowired
    private TIMNoticeManagerService timNoticeManagerService;
//    @Autowired
//    private TIMNoticeService timNoticeService;
//    @Autowired
//    private SendMessageService service;

    /**
     * 发送TIM通知(远程调用)
     *
     * @param po
     * @return
     */
    @ApiOperation(value = "发送TIM通知(远程调用,为模板通知)", notes = "发送TIM通知(远程调用,为模板通知)")
    @RequestMapping(value = "/sendTIMNotice", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> sendTIMNotice(@RequestBody TIMNoticeSendPo po) {
        return timNoticeManagerService.sendTIMNotice(po);
    }
    //
    // @ApiOperation(value = "发送测试用订单助手IM通知", notes = "发送测试用订单助手IM通知")
    // @RequestMapping(value = "/testSendOrdTIMNotice", method = RequestMethod.POST)
    // @DataCheck
    // public ResultPoJo<Object> testSendOrdTIMNotice() {
    // Map<String, Object> dataModel = Maps.newHashMap();
    // dataModel.put("orderId", "45351232347458976987272");
    // dataModel.put("status", "0");
    // return timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_ORD_UN_COFM, dataModel, Lists.newArrayList("123456"));
    // }
    //
    // @ApiOperation(value = "发送测试用通知消息IM通知", notes = "发送测试用通知消息IM通知")
    // @RequestMapping(value = "/testSendNtcTIMNotice", method = RequestMethod.POST)
    // @DataCheck
    // public ResultPoJo<Object> testSendNtcTIMNotice() {
    // Map<String, Object> dataModel = Maps.newHashMap();
    // dataModel.put("commName", "测试通知消息商品名称");
    // dataModel.put("cmmonStats", "0");
    // return timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_PRD_PUB_SUC, dataModel, Lists.newArrayList("123456"));
    // }
    //
    // @ApiOperation(value = "发送测试用三种消息", notes = "发送测试用三种消息")
    // @RequestMapping(value = "/testSendAllTypeTIMNotice", method = RequestMethod.POST)
    // @DataCheck
    // public ResultPoJo<Object> testSendAllTypeTIMNotice() {
    // // 发送测试用订单助手IM通知
    // Map<String, Object> dataModel = Maps.newHashMap();
    // dataModel.put("orderId", "45351232347458976987272");
    // dataModel.put("status", "0");
    // timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_ORD_UN_COFM, dataModel, Lists.newArrayList("824980471795526927"));
    //
    // // 发送测试用通知消息IM通知
    // Map<String, Object> dataModel2 = Maps.newHashMap();
    // dataModel2.put("commName", "测试通知消息商品名称");
    // dataModel2.put("cmmonStats", "0");
    // timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_PRD_PUB_SUC, dataModel2, Lists.newArrayList("824980471795526927"));
    //
    // // 发送测试系统消息
    // SendMessagePo po = new SendMessagePo();
    // po.setTitle("测试系统消息");
    // po.setSummary("测试系统摘要");
    // po.setRecList(Lists.newArrayList("824980471795526927"));
    // po.setContent("<html><body><p/>测试系统消息的富文本内容<p/></body></html>");
    // return service.insert(po);
    // }
}
