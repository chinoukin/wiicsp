package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.PolicyTechnologyInfoPo;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.vo.oritrapla.PadMageGetVo;
import com.wisea.cultivar.plant.vo.oritrapla.PadMageListVo;
import com.wisea.cultivar.plant.service.oritrapla.PadMageService;
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
 * @version 1.0
 * @since 2019-08-21 08:48
 * TODO 保留
 */
@Api(tags = "【原产地通】病虫害管理")
@RestController
@RequestMapping("/w/pad")
public class PadMageController {

    @Autowired
    private PadMageService padMageService;

    @DataCheck
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public ResultPoJo<Page<PadMageListVo>> findForPages(@RequestBody PadMagePagePo po) {
        return padMageService.findForPages(po);
    }

    @DataCheck
    @PostMapping("/findList")
    @ApiOperation("查询病虫害列表")
    public ResultPoJo<List<PadMageListVo>> findList(@RequestBody PadMageListPo po) {
        return padMageService.findList(po);
    }

    @DataCheck
    @PostMapping("/query")
    @ApiOperation("按ID查询")
    public ResultPoJo<PadMageGetVo> findById(@RequestBody PolicyTechnologyInfoPo po) {
        return padMageService.findById(po);
    }

    @DataCheck
    @PostMapping("/add")
    @ApiOperation("新增一条")
    public ResultPoJo addOne(@RequestBody PadMageInsertPo po) {
        return padMageService.addOne(po);
    }

    @DataCheck
    @PostMapping("/update")
    @ApiOperation("修改一条")
    public ResultPoJo updateOne(@RequestBody PadMageUpdatePo po) {
        return padMageService.updateOne(po);
    }

    @DataCheck
    @PostMapping("/delete")
    @ApiOperation("删除记录")
    public ResultPoJo delete(@RequestBody PadMageBatDeletePo po) {
        return padMageService.delete(po.getDelList());
    }

}
