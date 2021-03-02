package com.wisea.equipment.netty.jxiotcity;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.equipment.constants.DictConstants;
import com.wisea.equipment.service.jxiotcity.JxiotcityService;
import io.netty.channel.*;

import java.net.InetSocketAddress;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * I/O数据读写处理类
 * @author chengq
 * @date 2020/11/24 10:49
 */
public class BootNettyChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter{

    /**
     * 当前保持通讯的设备
     */
    public final static ConcurrentHashMap<ChannelHandlerContext, String> channelMap = new ConcurrentHashMap<>();

    private final JxiotcityService jxiotcityService = SpringBootContext.getBean(JxiotcityService.class);

    /**
     * 从客户端收到新的数据时，这个方法会在收到消息时被调用
     *
     * @param ctx 上下文
     * @param msg 接收到的消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        System.out.println("【精讯畅通tcp】接受到的数据为：" + msg);
        String data = msg.toString();
        //心跳检测
        if (Objects.equals(data, DictConstants.JX_PING)) {
            return;
        }
        jxiotcityService.parsingSaveInfo(data, ctx);
    }

    /**
     * 从客户端收到新的数据、读取完成时调用
     *
     * @param ctx 上下文
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
    	ctx.flush();
    }

    /**
     * 当出现 Throwable 对象才会被调用，即当 Netty 由于 IO 错误或者处理器在处理事件时抛出的异常时
     *
     * @param ctx 上下文
     * @param cause 异常信息
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("exception caught");
        //从设备列表中移除
        channelMap.remove(ctx);
        cause.printStackTrace();
        ctx.close();//抛出异常，断开与客户端的连接
    }

    /**
     * 客户端与服务端第一次建立连接时 执行
     *
     * @param ctx 上下文
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ctx.channel().read();
        //添加链接设备
        BootNettyChannelInboundHandlerAdapter.channelMap.put(ctx, "");
        //心跳检测
        jxiotcityService.ping(ctx);
        //此处不能使用ctx.close()，否则客户端始终无法与服务端建立连接
        System.out.println("channel active:" + getIp(ctx) + ctx.name());
    }

    /**
     * 客户端与服务端 断连时 执行
     *
     * @param ctx 上下文
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        //从设备列表中移除
        channelMap.remove(ctx);
        sendCloseLog();
        //断开连接时，必须关闭，否则造成资源浪费，并发量很大情况下可能造成宕机
        ctx.close();
        System.out.println("channel inactive ip:" + getIp(ctx));
    }

    /**
     * 服务端当read超时, 会调用这个方法
     *
     * @param ctx 上下文
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        //从设备列表中移除
        channelMap.remove(ctx);
        sendCloseLog();
        ctx.close();//超时时断开连接
    	System.out.println("user event triggered ip:" + getIp(ctx));
    }

    /**
     * 获取IP地址
     */
    private String getIp(ChannelHandlerContext ctx) {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        return insocket.getAddress().getHostAddress();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx){
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx){
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx){
    }

    public static void sendCloseLog() {
        LoggerUtil.debug("【精讯畅通】通道关闭，当前在线设备：" + channelMap.size());
    }

}
