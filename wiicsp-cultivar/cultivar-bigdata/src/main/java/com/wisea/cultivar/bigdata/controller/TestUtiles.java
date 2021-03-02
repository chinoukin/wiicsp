package com.wisea.cultivar.bigdata.controller;

import com.wisea.cultivar.bigdata.utils.RedPacketUtil;

import java.util.List;

public class TestUtiles {

    public static void main(String[] args) {

        List<Double> splitRedPacket = RedPacketUtil.splitRedPacket(223, 7, 10, 100, 5D);

        System.out.println(splitRedPacket);
        double sum = 0;
        for (Double red : splitRedPacket) {
            sum += red;
        }
        System.out.println(splitRedPacket.get(3));
        System.out.println(sum);

        String aaa = "13,23,454,656,";
        System.out.println(aaa.substring(0, aaa.length() - 1));
    }
}
