package com.wisea.equipment.service.jxiotcity;

import com.wisea.equipment.service.jxiotcity.RegisterOrderService;
import com.wisea.equipment.vo.SubStringVo;
import org.springframework.stereotype.Service;

/**
 * 1004设备执行回复
 * @author chengq
 * @date 2020/11/24 10:51
 */
@Service
public class PerformRespServiceImpl extends RegisterOrderService {

    /**
     * 设备执行回复解析
     */
    @Override
    public void perform(String data) {
        //解析设备id
        SubStringVo subStringVo = SubStringVo.buildSubStringVo(data, getLength(6));
        String equId = subStringVo.getUse();
        //截取数据长度
        subStringVo.delString(getLength(2));
        //获取服务器的下发命令
        subStringVo.subString(getLength(2));
        String code = subStringVo.getUse();
        //获取执行结果 00成功 EE失败
        subStringVo.subString(getLength(1));
        String result = subStringVo.getUse();
        //获取错误码 00无错误 01数值超限 02设备不支持 03待定
        subStringVo.subString(getLength(1));
        String errCode = subStringVo.getUse();

    }
}
