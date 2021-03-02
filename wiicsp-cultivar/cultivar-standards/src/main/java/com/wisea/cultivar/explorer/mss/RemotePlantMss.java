package com.wisea.cultivar.explorer.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.po.bigdata.LongIdPo;
import com.wisea.cultivar.common.vo.bigdata.DetailedRecordVo;
import com.wisea.cultivar.explorer.vo.DemonsBaseEquArchVo;
import com.wisea.cultivar.explorer.vo.PadYjInfoListVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className PlantMss
 * @date 2020/9/3 10:16
 * @Description 种植服务远程调用
 */
@FeignClient(contextId = "RemotePlantMss", name = "${wbfc.mss.plant:RemotePlantMss}", url = "${wbfc.mssurl.plant:}")
@Repository
public interface RemotePlantMss {
    /**
     * 远程根据地块ID查询地块关联的设备/档案列表
     * @param po
     * @return
     */
    @RequestMapping(value = "/i/remotPlant/findEquArchByMassifIds", method = RequestMethod.POST, consumes = "application/json")
    ResultPoJo<DemonsBaseEquArchVo> findEquArchByMassifIds(@RequestBody List<Long> po);

    /**
     * 远程查询病虫害列表（前20条）
     * @return
     */
    @RequestMapping(value = "/i/remotPlant/findPestWarning", method = RequestMethod.POST, consumes = "application/json")
    ResultPoJo<List<PadYjInfoListVo>> findPestWarning();

    /**
     * 档案详情
     *
     * @param po
     * @return
     */
    @PostMapping("/i/remotPlant/detailedRecord")
    ResultPoJo<DetailedRecordVo> detailedRecord(@RequestBody LongIdPo po);
}
