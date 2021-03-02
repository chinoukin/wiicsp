package com.wisea.cultivar.infomanage.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.wisea.cultivar.common.po.TIMNoticeSendPo;
import com.wisea.cultivar.infomanage.entity.TIMNoticeUser;
import com.wisea.cultivar.infomanage.properties.TIMNoticeProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.ErrorStatusCode;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.JsonMapper;
import com.wisea.cloud.tencentim.constants.TencentIMConstant;
import com.wisea.cloud.tencentim.entity.TIMMsgBody;
import com.wisea.cloud.tencentim.po.APIBatchSendMsgPo;
import com.wisea.cloud.tencentim.service.TencentIMService;
import com.wisea.cloud.tencentim.vo.BatchTencentIMVo;

/**
 * TIM通知管理Service
 *
 *
 */
@Service
@EnableConfigurationProperties(TIMNoticeProperties.class)
public class TIMNoticeManagerService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TIMNoticeProperties prop;

    @Autowired(required = false)
    protected TencentIMService tencentIMService;

    @Transactional
    public ResultPoJo<Object> sendTIMNotice(TIMNoticeSendPo po) {
        // 通过类型来确定具体的发送者是
        String type = po.getType();
        TIMNoticeUser user = prop.getUsers().get(type);
        if (null == user) {
            throw new VerifyError("没有找到类型为【" + type + "】的TIM通知帐户,请检查配置文件");
        }
        ResultPoJo<Object> result = new ResultPoJo<>();
        String senderId = user.getId();
        APIBatchSendMsgPo sendPo = new APIBatchSendMsgPo();
        sendPo.setFrom_Account(senderId);
        sendPo.setMsgRandom(ConverterUtil.toInteger(ConverterUtil.getCheckCode(8)));

        List<TIMMsgBody> msgBody = Lists.newArrayList();
        TIMMsgBody msg = new TIMMsgBody();
        msg.setMsgType(TencentIMConstant.MSG_TYPE_TIMCUSTOMELEM);
        OffsetDateTime now = OffsetDateTime.now();
        Map<String, Object> dataMap = Maps.newHashMap(msg.getMsgContent());
        // 消息类型
        dataMap.put("type", type);
        // 标题
        dataMap.put("title", po.getTitle());
        // 模板类型
        if (ConverterUtil.isNotEmpty(po.getTplKey())) {
            dataMap.put("tplKey", po.getTplKey());
        }
        // 内容
        dataMap.put("content", po.getContent());
        // 描述或摘要
        dataMap.put("desc", po.getDesc());
        // 需要下发的属性
        if (ConverterUtil.isNotEmpty(po.getPayload())) {
            dataMap.put("payload", po.getPayload());
        }
        // 创建时间
        dataMap.put("createDate", ConverterUtil.toString(ConverterUtil.offsetDateTimeToLong(now)));
        msg.addMsgContent("Data", po.getTitle());
        msg.addMsgContent("Desc", ConverterUtil.toString(po.getDesc(), po.getTitle()));
        // 将所有属性都放到ext中
        msg.addMsgContent("Ext", ConverterUtil.gson.toJson(dataMap));
        msgBody.add(msg);
        sendPo.setMsgBody(msgBody);

        logger.debug("sendTIMNotice: {}", JsonMapper.toJsonString(msgBody));

        List<BatchTencentIMVo> sendResList = Lists.newArrayList();
        // TIM规定批量一次的最大值是500个用户
        List<String> recList = po.getRecList().stream().collect(Collectors.toList());
        int recSize = recList.size();
        List<String> batchList = Lists.newArrayList();
        boolean sendSuccess = true;
        // 小于500就直接放
        if (recSize <= 500) {
            batchList.addAll(recList);
        } else {
            // 大于500的分批调用
            for (int i = 0; i < recList.size(); i++) {
                batchList.add(recList.get(i));
                int subSize = batchList.size();
                // 每100个提交查询一次
                if (0 == subSize % 500) {
                    sendPo.setTo_Account(batchList);
                    ResultPoJo<Object> sendRes = tencentIMService.sendCustomNotice(sendPo);
                    sendResList.add((BatchTencentIMVo) sendRes.getResult());
                    // 每次查询后就清空
                    batchList.clear();
                    // 返回值为失败
                    if (!(ConstantError.NOMAL.equals(sendRes.getCode()) || ErrorStatusCode.OK.code().equals(sendRes.getCode()))) {
                        sendSuccess = false;
                    }
                }
            }
        }
        // 如果校验列表有数据 说明需要校验查询 可能是直接放的 也可能是分批查询剩的
        if (batchList.size() > 0) {
            sendPo.setTo_Account(batchList);
            ResultPoJo<Object> sendRes = tencentIMService.sendCustomNotice(sendPo);
            sendResList.add((BatchTencentIMVo) sendRes.getResult());
            // 每次查询后就清空
            batchList.clear();
            // 返回值为失败
            if (!(ConstantError.NOMAL.equals(sendRes.getCode()) || ErrorStatusCode.OK.code().equals(sendRes.getCode()))) {
                sendSuccess = false;
            }
        }

        // 设置返回值
        result.setResult(sendResList);

        // 如果有失败的 就需要返回失败状态
        if (!sendSuccess) {
            // 对应TIM错误码
            result.setCode("930");
            result.setMsg("TIM消息发送失败");
        }

        return result;
    }
}
