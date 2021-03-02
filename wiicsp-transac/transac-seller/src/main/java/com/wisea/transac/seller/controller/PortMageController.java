package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.PortMagePagePo;
import com.wisea.transac.common.po.PortMagePo;
import com.wisea.transac.common.vo.PortMageListVo;
import com.wisea.transac.common.vo.PortMageVo;
import com.wisea.transac.seller.service.PortMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangjiahao
 * @since 2020/7/1 2:16 下午
 */
@Api(tags = "口岸管理")
@RestController
@RequestMapping("/w/portMage")
public class PortMageController {

    @Autowired
    private PortMageService portMageService;

    @DataCheck
    @PostMapping("/findById")
    @ApiOperation("查询详情")
    public ResultPoJo<PortMageVo> findById(@RequestBody LongIdPo po) {
        return portMageService.findById(po);
    }
    @DataCheck
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public ResultPoJo<Page<PortMageVo>> findForPage(@RequestBody PortMagePagePo po) {
        return portMageService.findForPage(po);
    }

    @DataCheck
    @PostMapping("/selection")
    @ApiOperation("港口下拉选项")
    public ResultPoJo<List<PortMageListVo>> findAllList() {
        return portMageService.findAllList();
    }

    @DataCheck
    @PostMapping("/saveOrUpdate")
    @ApiOperation("新增或修改")
    public ResultPoJo saveOrUpdate(@RequestBody PortMagePo po) {
        return portMageService.saveOrUpdate(po);
    }
    @DataCheck
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResultPoJo delete(@RequestBody LongIdPo po) {
        return portMageService.delete(po);
    }
}
