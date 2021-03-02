package com.wisea.cultivar.common.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.po.product.CommMageTreePo;
import com.wisea.cultivar.common.vo.product.ZhfwCommMageTreeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Conditional(RemoteCommMageMssConditional.class)
@FeignClient(contextId = "CommMageMss", name = "${wbfc.mss.standards:CommMageMss}",url = "${wbfc.mssurl.standards:}")
@Component
public interface RemoteCommMageMss {


    @RequestMapping(value = "/w/commMage/findCommMageTree", method = RequestMethod.POST)
    public ResultPoJo<List<ZhfwCommMageTreeVo>> findCommMageTree(@RequestBody CommMageTreePo po);

}
