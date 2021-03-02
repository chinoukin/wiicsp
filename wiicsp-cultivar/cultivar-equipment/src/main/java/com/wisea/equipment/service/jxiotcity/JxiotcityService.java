package com.wisea.equipment.service.jxiotcity;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.equipment.netty.jxiotcity.BootNettyChannelInboundHandlerAdapter;
import com.wisea.equipment.config.JxiotcityConfig;
import com.wisea.equipment.constants.DictConstants;
import com.wisea.equipment.constants.JxiotcityPushMessageEnum;
import com.wisea.equipment.constants.JxiotcityRegisterOrderEnum;
import com.wisea.equipment.dao.EquInfoMapper;
import com.wisea.equipment.po.JxiotcityPushMessagePo;
import com.wisea.equipment.utils.JxiotcityUtil;
import com.wisea.equipment.vo.EquInfoVo;
import com.wisea.equipment.vo.SubStringVo;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 精讯畅通业务
 * @author chengq
 * @date 2020/11/12 14:33
 */
@Service
public class JxiotcityService extends BaseService {
    @Autowired
    private JxiotcityConfig config;
    @Resource
    private EquInfoMapper equInfoMapper;

    /**
     *
     */
    @Value("${equipment.jxiotcity.pingInterval}")
    public Integer pingInterval;

    /**
     * 根据《LoRa集中器通信协议-精讯云 V2.实例解析11.14》文档解析
     * 解析数据并保存
     * 报文格式：<br/>
     * FEDC 03 000000AB 3230002C005B  0026
     * 其中FEDC为固定帧头，03为指令，传输session为000000AB（不需要可忽略），设备唯一ID为1E0BA2E0AAA4，鉴权码为 0x0026（不需要可忽略）
     */
    @Transactional
    public void parsingSaveInfo(String datas, ChannelHandlerContext ctx) {
        LoggerUtil.debug("【精讯畅通】接受到的数据为：" + datas);
        if (ConverterUtil.isEmpty(datas)) {
            return;
        }
        //去掉空格
        datas = datas.replace(" ", "");
        for (String data : datas.split(DictConstants.REQ_DEAL_HEND)) {
            try {
                if (ConverterUtil.isEmpty(data)) {
                    continue;
                }
                //获取注册命令
                SubStringVo subStringVo = SubStringVo.buildSubStringVo(data, 4);
                Class<? extends RegisterOrderService> service = JxiotcityRegisterOrderEnum.getService(subStringVo.getUse());
                if (Objects.isNull(service)) {
                    LoggerUtil.debug("【精讯畅通】命令不存在：" + subStringVo.getUse() + " data:" +data);
                    continue;
                }
                //设备id
                String equId = subStringVo.getLast().substring(0, 12);
                //根据设备id查询设备类型
                EquInfoVo info = equInfoMapper.findInfoByEntpIdAndNum("精讯畅通", equId);
                if (Objects.isNull(info)) {
                    //设备不存在移除在线设备
                    if (Objects.nonNull(ctx)) {
                        BootNettyChannelInboundHandlerAdapter.channelMap.remove(ctx);
                    }
                    LoggerUtil.debug("【精讯畅通】设备不存在：" + equId + " data:" + data);
                    continue;
                }
                //完善设备的id
                BootNettyChannelInboundHandlerAdapter.channelMap.put(ctx, equId);
                //按照协议解析
                RegisterOrderService orderService = SpringBootContext.getBean(service);
                orderService.perform(subStringVo.getLast());

            }catch (Exception e) {
                LoggerUtil.error("【精讯畅通】数据处理失败：" + data, e);
            }
        }
    }

    /**
     * 心跳检测
     */
    public void ping(ChannelHandlerContext ctx) {
        //获取channel
        Channel channel = ctx.channel();
        //与设备通讯需要16进制的数据
        ByteBuf byteValue = Unpooled.buffer();
        byteValue.writeBytes(JxiotcityUtil.hexStringToByte(DictConstants.JX_PING));
        channel.eventLoop().schedule(() -> {
            //判断设备是否存活
            if (channel.isActive()) {
                //发送数据
                channel.writeAndFlush(byteValue).addListener((ChannelFutureListener) future -> {
                    //发送成功后递归调用
                    if (future.isSuccess()) {
                        ping(ctx);
                    }else {
                        LoggerUtil.error("【精讯畅通】心跳发送失败，设备id：" +  BootNettyChannelInboundHandlerAdapter.channelMap.get(ctx));
                    }
                });
            } else {
                //设备离线将设备从在线设备中移除
                BootNettyChannelInboundHandlerAdapter.channelMap.remove(ctx);
                BootNettyChannelInboundHandlerAdapter.sendCloseLog();
                ctx.close();
            }
        }, config.getPingInterval(), TimeUnit.SECONDS);
    }

    /**
     * 推送推送消息
     */
    public void pushMessage(JxiotcityPushMessagePo pushMessagePo) {
        //获取代理类
        Class<? extends PushMessageService> service = JxiotcityPushMessageEnum.getService(pushMessagePo.getCode());
        if (Objects.isNull(service)) {
            return;
        }
        //发送消息
        PushMessageService messageService = SpringBootContext.getBean(service);
        messageService.pushMessage(pushMessagePo);
    }

}
