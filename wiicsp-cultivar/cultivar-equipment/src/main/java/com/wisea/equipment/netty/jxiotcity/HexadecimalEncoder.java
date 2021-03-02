package com.wisea.equipment.netty.jxiotcity;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.string.StringDecoder;

import java.util.List;

/**
 * 16进制转码
 * @author chengq
 * @date 2020/11/23 14:51
 */
public class HexadecimalEncoder extends StringDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out){
        String HEXES = "0123456789ABCDEF";
        byte[] req = new byte[msg.readableBytes()];
        msg.readBytes(req);
        final StringBuilder hex = new StringBuilder(2 * req.length);

        for (byte b : req) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4))
                    .append(HEXES.charAt((b & 0x0F)));
        }
        out.add(hex.toString());
    }
}
