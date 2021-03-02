package com.wisea.cultivar.bigdata.mss;


import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.vo.tp.statistics.ChartVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 设备服务远程调用
 */
@FeignClient(contextId = "MemberMss", name = "${wbfc.mss.seller:MemberMss}", url = "${wbfc.mssurl.seller:}")
@Repository
public interface MemberMss {

    @RequestMapping(value = "/w/MembInfo/findUser", method = RequestMethod.POST)
    ResultPoJo<List<ChartVo>> findUser();

}
