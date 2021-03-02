package com.wisea.equipment.service.jxiotcity;

import com.wisea.equipment.service.jxiotcity.RegisterOrderService;
import com.wisea.equipment.utils.JxiotcityUtil;
import com.wisea.equipment.vo.SubStringVo;
import org.springframework.stereotype.Service;

/**
 * 1002状态协议
 * @author chengq
 * @date 2020/11/24 10:51
 */
@Service
public class UploadStateServiceImpl extends RegisterOrderService {

    /**
     * 设备状态
     * FEDC 1002 4230002C0051 E1EE 0007 00000000 0000 00 1B00
     */
    @Override
    public void perform(String data) {
        //解析设备id
        SubStringVo subStringVo = SubStringVo.buildSubStringVo(data, getLength(6));
        String equId = subStringVo.getUse();
        //删除鉴权码din
        subStringVo.delString(getLength(2));
        //删除数据长度
        subStringVo.delString(getLength(2));
        //信号强度
        subStringVo.subString(getLength(4));
        Integer signalStrength = subStringVo.getDecimalUse();
        //电压
        subStringVo.subString(getLength(2));
        Double voltage = JxiotcityUtil.multiply(subStringVo.getDecimalUse(), 0.001);
        //错误码
        subStringVo.subString(getLength(1));
        Integer errorCode = subStringVo.getDecimalUse();
    }
}
