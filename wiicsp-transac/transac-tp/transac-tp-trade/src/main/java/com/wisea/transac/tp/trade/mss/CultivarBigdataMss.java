package com.wisea.transac.tp.trade.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.mss.FeignJobRemotConfiguration;
import com.wisea.transac.common.po.product.CommPubInfoGetPo;
import com.wisea.transac.common.vo.trade.OrderInfoMiddleVo;
import com.wisea.transac.common.vo.trade.OrderInfoTbVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author jirg
 * @Date 2019/8/21 17:12
 * @Description TODO 订单同步远程调用，此功能为产品项目特有，如代码同步到洪九果品记得删除
 **/
@FeignClient(contextId = "OrderSyncMss", name = "${wbfc.mss.cultivar-bigdata:CultivarBigdataMss}", url = "${wbfc.mssurl.cultivar-bigdata:}", configuration = FeignJobRemotConfiguration.class)
@Repository
public interface CultivarBigdataMss {
    /**
     * 同步订单数据至种植服务大数据使用
     * @param po
     * @return
     */
    @RequestMapping(value = "/dashboard/w/orderInfoTb/orderSync", method = RequestMethod.POST, consumes = "application/json")
    ResultPoJo<String> orderSync(@RequestBody List<OrderInfoTbVo> po);
}
