package com.wisea.transac.operation.controller;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.Dict;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cloud.system.po.DictUpdatePo;
import com.wisea.cloud.system.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjiahao
 * @since 2020/7/17 10:20 上午
 */
@Api(tags = "字典管理Mss接口")
@RestController
public class DictMssCotroller {

    @Autowired
    private DictService dictService;

    @PostMapping("/w/dict/get")
    @ApiOperation("根据字典ID查询详情")
    public ResultPoJo<Dict> get(@RequestBody LongIdPo po) {
        return dictService.get(po.getId().toString());
    }

    @PostMapping("/w/dict/set")
    @ApiOperation("设置字典新值")
    public ResultPoJo set(@RequestBody DictUpdatePo po) {
        return dictService.update(po);
    }
}
