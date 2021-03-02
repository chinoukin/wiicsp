package com.wisea.cultivar.common.service;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.mss.RemoteSecurityMssConditional;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.annotation.Check;

import com.wisea.cultivar.common.constants.TIMNoticeConstants;
import com.wisea.cultivar.common.entity.TIMNoticeTpl;
import com.wisea.cultivar.common.utils.TIMNoticeUtil;
import com.wisea.cultivar.common.mss.RemoteTIMNoticeMss;
import com.wisea.cultivar.common.po.TIMNoticeSendPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TIM通知相关Service
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月6日 上午11:18:02
 */
@Conditional(RemoteSecurityMssConditional.class)
@Service
public class TIMNoticeService {

    @Autowired
    private RemoteTIMNoticeMss remoteOperationMss;

    /**
     * 发送模板通知
     * <p/>
     * 默认使用dataModel作为payload下发属性
     *
     * @param tplKey
     *            模板KEY
     * @param dataModel
     *            模板数据模型
     * @param recList
     *            接收者列表
     * @return
     */
    public ResultPoJo<Object> sendTpl(String tplKey, Object dataModel, List<String> recList) {
        return sendTpl(tplKey, dataModel, recList, dataModel);
    }

    /**
     * 发送模板通知
     * <p/>
     * 下发属性会作为穿透的属性 完整的设置到ext中
     *
     * @param tplKey
     *            模板KEY
     * @param dataModel
     *            模板数据模型
     * @param recList
     *            接收者列表
     * @param payload
     *            下发属性
     * @return
     */
    @DataCheck
    public ResultPoJo<Object> sendTpl(@Check(test = "required") String tplKey, Object dataModel, @Check(test = "required") List<String> recList, Object payload) {
        TIMNoticeTpl tpl = TIMNoticeConstants.getTpl(tplKey);
        if (null == tpl) {
            throw new VerifyError("通知模板=" + tplKey + ",不存在");
        }
        // 获取模板对应的内容数据
        String content = TIMNoticeUtil.getContent(tpl, dataModel);
        TIMNoticeSendPo po = new TIMNoticeSendPo();
        // 把模板的属性拷贝
        ConverterUtil.copyProperties(tpl, po, "content");
        // 设置模板Key
        po.setTplKey(tplKey);
        // 填充内容
        po.setContent(content);
        // 设置接收者
        po.setRecList(recList);
        // 设置下发属性
        po.setPayload(payload);
        // 调用远程接口 发送TIM消息
        return remoteOperationMss.sendTIMNotice(po);
    }

    /**
     * 发送自定义通知
     *
     * @param tpl
     * @param recList
     * @return
     */
    @DataCheck
    public ResultPoJo<Object> sendNotice(@Check(test = "required", cascade = true) TIMNoticeTpl tpl, @Check(test = "required") List<String> recList) {
        TIMNoticeSendPo po = new TIMNoticeSendPo();
        // 把模板的属性拷贝
        ConverterUtil.copyProperties(tpl, po);
        // 设置接收者
        po.setRecList(recList);
        // 调用远程接口 发送TIM消息
        return remoteOperationMss.sendTIMNotice(po);
    }
}
