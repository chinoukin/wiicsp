package com.wisea.cultivar.plant.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.plant.config.FeignJobRemotConfiguration;
import com.wisea.cultivar.plant.mss.po.EquDataPointPo;
import com.wisea.cultivar.plant.mss.vo.XaircraftInfluxVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jirg
 * @version 1.0
 * @className EquipmentMss
 * @date 2020/7/7 14:00
 * @Description 设备服务远程调用（定时任务使用）
 */
@FeignClient(contextId = "RemoteEquipmentMss", name = "${wbfc.mss.equipment:RemoteEquipmentMss}", url = "${wbfc.mssurl.equipment:}", configuration = FeignJobRemotConfiguration.class)
@Repository
public interface EquipmentJobMss {
    /**
     * @author jirg
     * @date 2020/8/11 17:12
     * @Description 查询设备最新数据点
     */
    @RequestMapping(value = "/i/equ/equInfo/remotLastDataPoint", method = RequestMethod.POST, consumes = "application/json")
    ResultPoJo<XaircraftInfluxVo> remotLastDataPoint(@RequestBody EquDataPointPo po);
}
