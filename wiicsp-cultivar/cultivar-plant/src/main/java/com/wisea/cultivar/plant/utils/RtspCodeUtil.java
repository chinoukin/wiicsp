package com.wisea.cultivar.plant.utils;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.ZxingHandler;
import com.wisea.cultivar.plant.vo.oritrapla.RtspCodeMageInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.RtspCodePdfVo;
import org.springframework.beans.BeanUtils;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class RtspCodeUtil {
    public static String rtspCodeTemplate = "{0}{1}{2}";
    public static String suffix0 = "0";
    public static String suffix1 = "1";


    public static  List<RtspCodePdfVo> generateRtspCodes(RtspCodeMageInfoVo info, String qrcodeFix) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Set<Callable<RtspCodePdfVo>> callables = new HashSet<Callable<RtspCodePdfVo>>();
        for (int i = 0; i < info.getRtspCodeCount(); i++){
            int finalI = i;
            callables.add(new Callable<RtspCodePdfVo>() {
                public RtspCodePdfVo call() throws Exception {
                    RtspCodePdfVo vo = new RtspCodePdfVo();
                    BeanUtils.copyProperties(info, vo);
                    //追溯码规则：8位批次编号 + 7位自增数 + 4位随机数 + 1位奇校验码（前面19位数字的二进制数中1的个数为奇数时为0否则为1）
                    String format = MessageFormat.format(rtspCodeTemplate, vo.getBatchNum(), String.format("%07d", finalI), RandomUtil.getFixLenthString(4));
                    //奇校验
                    String binaryStr = Long.toBinaryString(Long.valueOf(format));
                    String rtspCode = format.concat(RandomUtil.parityCheck(binaryStr) ? suffix0 : suffix1); //前面19位数字的二进制数中1的个数为奇数时补0否则补1
                    vo.setRtspCode(rtspCode);
                    String QRCodecCount = qrcodeFix.concat(rtspCode);
                    String codecBase64 = ZxingHandler.generateQRCodecBase64(QRCodecCount, 40, 40);
                    vo.setQrCodeImgBase64(codecBase64);
                    vo.setQrCodeStr(QRCodecCount);
                    vo.setProductName(vo.getCommName().concat(ConverterUtil.isEmpty(vo.getCommVarietName()) ? "" : "-".concat(vo.getCommVarietName())));
                    return vo;
                }
            });
        }

        List<Future<RtspCodePdfVo>> futures = executorService.invokeAll(callables);
        List<RtspCodePdfVo> rtspCodes = Lists.newArrayList();
        for(Future<RtspCodePdfVo> future : futures){
            rtspCodes.add(future.get());
        }
        executorService.shutdown();
        return rtspCodes;
    }
}
