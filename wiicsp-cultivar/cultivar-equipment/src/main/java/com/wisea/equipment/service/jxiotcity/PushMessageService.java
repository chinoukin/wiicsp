package com.wisea.equipment.service.jxiotcity;

import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.equipment.netty.jxiotcity.BootNettyChannelInboundHandlerAdapter;
import com.wisea.equipment.constants.DictConstants;
import com.wisea.equipment.po.JxiotcityPushMessagePo;
import com.wisea.equipment.utils.JxiotcityUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;

/**
 * 消息推送
 * @author chengq
 * @date 2020/11/26 10:51
 */
public abstract class PushMessageService {

    /**
     * 构建有效数据
     */
    abstract String buildEffectiveData(JxiotcityPushMessagePo pushMessagePo);

    /**
     * 推送消息
     */
    public void pushMessage(JxiotcityPushMessagePo pushMessagePo) {
        String effectiveData = buildEffectiveData(pushMessagePo);
        BootNettyChannelInboundHandlerAdapter.channelMap.forEach((k,v) -> {
            //帧头
            StringBuilder sb = new StringBuilder(DictConstants.ISSUED_DEAL_HEND);
            //下发指令
            sb.append(pushMessagePo.getCode());
            //设备id
            sb.append(v);
            //有效数据字节数
            sb.append(prefix(Integer.toHexString(effectiveData.length() / 2), 4));
            //有效数据
            sb.append(effectiveData);
            //校验数据
            byte[] checkBytes = JxiotcityUtil.hexStringToByte(sb.toString());
            //计算校验和
            String checkCode = JxiotcityUtil.crc16Checkout(checkBytes);
            //拼接校验和
            sb.append(checkCode);
            //获取通道
            Channel channel = k.channel();
            //连接有效
            if (channel.isActive()) {
                //向客户端发送16进制数据
                ByteBuf byteValue = Unpooled.buffer();
                byteValue.writeBytes(JxiotcityUtil.hexStringToByte(sb.toString()));
                channel.writeAndFlush(byteValue).addListener((ChannelFutureListener) future -> {
                    if (future.isSuccess()) {
                        //发送成功后记录到成功队列中，接受返回结果
                        LoggerUtil.debug("【精讯畅通】消息发送成功，设备id：" +  BootNettyChannelInboundHandlerAdapter.channelMap.get(k) + "data：" + sb.toString());
                    }else {
                        //发送失败记录到发送失败队列，并重试
                        LoggerUtil.error("【精讯畅通】消息发送失败，设备id：" +  BootNettyChannelInboundHandlerAdapter.channelMap.get(k));
                    }
                });
            }
        });
    }

    /**
     * 拼接前缀
     * @param data 数据
     * @param length 数据总长度
     */
    public String prefix(String data, int length) {
        String prefix = "00000000";
        return prefix.substring(0, length - data.length()) + data;
    }
}
