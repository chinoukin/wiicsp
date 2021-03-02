package com.wisea.transac.tp.system.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.Dict;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.system.DictUpdatePo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangjiahao
 * @since 2020/7/17 10:30 上午
 */
@FeignClient(name = "${wbfc.mss.system:DictServiceMss}", url = "${wbfc.mssurl.system:}")
public interface DictServiceMss {

    @PostMapping("/w/dict/get")
    public ResultPoJo<Dict> get(@RequestBody LongIdPo po);

    @PostMapping("/w/dict/set")
    public ResultPoJo set(@RequestBody DictUpdatePo po);

}
