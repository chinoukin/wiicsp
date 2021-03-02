package com.wisea.cultivar.plant.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.plant.po.oritrapla.EquInfoRemotPo;
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
 * @Description 设备服务远程调用
 */
@FeignClient(contextId = "RemoteEquipmentMss", name = "${wbfc.mss.equipment:RemoteEquipmentMss}", url = "${wbfc.mssurl.equipment:}")
@Repository
public interface EquipmentMss {
    /**
     * 远程添加设备，同一个厂商，同一个设备编号视为同一个设备，在设备服务中只存在一条设备记录。
     * @param po
     * @return
     */
    @RequestMapping(value = "/i/equ/equInfo/remotSaveEquInfo", method = RequestMethod.POST, consumes = "application/json")
    ResultPoJo<?> remotSaveEquInfo(@RequestBody EquInfoRemotPo po);
}
