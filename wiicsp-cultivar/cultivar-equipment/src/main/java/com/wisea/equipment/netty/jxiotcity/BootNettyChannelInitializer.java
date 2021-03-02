package com.wisea.equipment.netty.jxiotcity;


import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 通道初始化
 * @author chengq
 * @date 2020/11/24 10:49
 */
public class BootNettyChannelInitializer<SocketChannel> extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) {


        // ChannelOutboundHandler，依照逆序执行
        ch.pipeline().addLast("encoder", new StringEncoder());

        // 属于ChannelInboundHandler，依照顺序执行
        ch.pipeline().addLast("decoder", new HexadecimalEncoder());

        /*
         *    自定义ChannelInboundHandlerAdapter
         *    该项在源码中放在了上面两项上面，实际上需要调整到后面
         */
        ch.pipeline().addLast(new BootNettyChannelInboundHandlerAdapter());

    }

}
