package com.wisea.cultivar.plant.utils;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/19 上午10:27
 * @Description:用于业务类中返回的参数
 */
public class ErrCodeMsgUtil {

    /**
    * 用于添加、修改、删除操作的返回参数
    * */
    public static ResultPoJo<ConstantCodeMsg> resultCodeMsg(Integer flag){
        ResultPoJo<ConstantCodeMsg> poJo = new ResultPoJo<>();
        if(flag>0){
            poJo.setCode(ConstantCodeMsg.ERR_000);
            poJo.setMsg(ConstantCodeMsg.MSG_000);
        }else{
            poJo.setCode(ConstantCodeMsg.ERR_999);
            poJo.setMsg(ConstantCodeMsg.MSG_999);
        }
        return poJo;
    }
}
