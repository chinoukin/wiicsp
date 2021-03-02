package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.StagePictureBatDeletePo;
import com.wisea.cultivar.standards.po.StagePictureGetPo;
import com.wisea.cultivar.standards.po.StagePictureInsertPo;
import com.wisea.cultivar.standards.po.StagePictureListPo;
import com.wisea.cultivar.standards.po.StagePicturePagePo;
import com.wisea.cultivar.standards.po.StagePictureUpdatePo;
import com.wisea.cultivar.standards.service.StagePictureService;
import com.wisea.cultivar.standards.vo.StagePictureGetVo;
import com.wisea.cultivar.standards.vo.StagePictureListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * StagePictureController
 * 阶段参考图片 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "阶段参考图片相关接口")
@RequestMapping(value = "/w/StagePicture")
@RestController
public class StagePictureController {
    @Autowired
    protected StagePictureService stagePictureService;

    @ApiOperation(value = "获取阶段参考图片分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<StagePictureListVo>> findPage(@RequestBody StagePicturePagePo stagePicturePagePo) {
        return stagePictureService.findPage(stagePicturePagePo);
    }

    @ApiOperation(value = "获取阶段参考图片列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<StagePictureListVo>> list(@RequestBody StagePictureListPo stagePictureListPo) {
        return stagePictureService.findList(stagePictureListPo);
    }

    @ApiOperation(value = "查询阶段参考图片")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<StagePictureGetVo> get(@RequestBody StagePictureGetPo stagePictureGetPo) {
        return stagePictureService.get(stagePictureGetPo);
    }

    @ApiOperation(value = "新增阶段参考图片")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody StagePictureInsertPo stagePictureInsertPo) {
        return stagePictureService.insert(stagePictureInsertPo);
    }

    @ApiOperation(value = "修改阶段参考图片")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody StagePictureUpdatePo stagePictureUpdatePo) {
        return stagePictureService.update(stagePictureUpdatePo);
    }

    @ApiOperation(value = "批量删除阶段参考图片")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody StagePictureBatDeletePo stagePictureBatDeletePo) {
        return stagePictureService.batDelete(stagePictureBatDeletePo);
    }
}
