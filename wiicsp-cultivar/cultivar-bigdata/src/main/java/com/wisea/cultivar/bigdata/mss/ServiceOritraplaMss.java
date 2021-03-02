package com.wisea.cultivar.bigdata.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.BaseInfoPo;
import com.wisea.cultivar.common.po.bigdata.EquInfoPo;
import com.wisea.cultivar.common.po.bigdata.LongIdPo;
import com.wisea.cultivar.common.po.bigdata.MassifAndMonitrPagePo;
import com.wisea.cultivar.common.po.bigdata.MonitrLiveStatisticsPo;
import com.wisea.cultivar.common.po.bigdata.QiyeAllInfoPo;
import com.wisea.cultivar.common.vo.bigdata.BaseInfoVo;
import com.wisea.cultivar.common.vo.bigdata.DetailedRecordVo;
import com.wisea.cultivar.common.vo.bigdata.EquInfoVo;
import com.wisea.cultivar.common.vo.bigdata.MassifAndMonitrListVo;
import com.wisea.cultivar.common.vo.bigdata.MonitrLive;
import com.wisea.cultivar.common.vo.bigdata.QiyeInfoListVo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@ConditionalOnProperty(name = "wbfc.conf.enable", havingValue = "true", matchIfMissing = false)
@FeignClient(name = "HjgpOritraplaBusiness", url = "${wbfc.conf.url1}")
public interface ServiceOritraplaMss {

    @RequestMapping(value = "/n/dashboard/selAllQiyeInfo", method = RequestMethod.POST)
    ResultPoJo<List<QiyeInfoListVo>> selAllInfo(@RequestBody QiyeAllInfoPo po);

    /**
     * 设备
     *
     * @param po
     * @return
     */
    @PostMapping("/n/dashboard/listMonitorByZt")
    ResultPoJo<Page<MassifAndMonitrListVo>> findMonitor(@RequestBody MassifAndMonitrPagePo po);

    /**
     * 视频
     *
     * @param po
     * @return
     */
    @PostMapping("/n/dashboard/listVideoByZt")
    ResultPoJo<Page<EquInfoVo>> findVideo(@RequestBody EquInfoPo po);

    /**
     * 档案列表
     *
     * @param po
     * @return
     */
    @PostMapping(value = "/n/dashboard/findBaseInfoByZt")
    ResultPoJo<Page<BaseInfoVo>> findBaseInfo(@RequestBody BaseInfoPo po);

    /**
     * 档案详情
     *
     * @param po
     * @return
     */
    @PostMapping("/n/dashboard/detailedRecord")
    ResultPoJo<DetailedRecordVo> detailedRecord(@RequestBody LongIdPo po);

    /**
     * @Date 2019/2/25 9:50
     * @Description 周、月、年统计
     **/
    @RequestMapping(value = "/n/dashboard/monitrLiveStatistics", method = RequestMethod.POST)
    ResultPoJo<List<MonitrLive>> monitrLiveStatistics(@RequestBody MonitrLiveStatisticsPo po);
}
