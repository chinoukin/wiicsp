package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.vo.oritrapla.MineArchInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.RtspCodeMageInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.ScanQRCodeVo;
import com.wisea.cultivar.plant.service.oritrapla.RtspCodeMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Auth： jirg
 * CreateDate:  2018/6/4
 * projectName:  oritrapla
 * remark:  追溯码管理App端Controller
 */
@RestController
@RequestMapping("/w/app/rtspCode")
@Api(value = "【原产地通】追溯码管理控制类", description = "追溯码管理", tags = "追溯码管理调用接口")
public class RtspCodeMageController {

    @Autowired
    private RtspCodeMageService service;

    /**
     * 查询追溯码申请列表
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findRtspCodeList", method = RequestMethod.POST)
    @ApiOperation(nickname="App端【追溯】", value = "oritrapla-027_【追溯】查询追溯码申请列表", notes = "查询追溯码申请列表")
    public ResultPoJo<Page<RtspCodeMageInfoVo>> findRtspCodeList(@RequestBody RtspCodeMageListPo po){
        return service.findRtspCodeList(po);
    }

    /**
     * 保存追溯码申请
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/saveRtspCode", method = RequestMethod.POST)
    @ApiOperation(nickname="App端【追溯】", value = "oritrapla-025_【追溯】保存追溯申请", notes = "保存追溯申请")
    public ResultPoJo<String> saveRtspCode(@RequestBody RtspCodeMageSavePo po){
        return service.saveRtspCode(po);
    }

    /**
     * 查询追溯码申请详细信息
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findRtspCodeInfo", method = RequestMethod.POST)
    @ApiOperation(nickname="App端【追溯】", value = "oritrapla-029_【追溯】查询追溯码申请详细信息", notes = "查询追溯码申请详细信息")
    public ResultPoJo<RtspCodeMageInfoVo> findRtspCodeInfo(@ApiParam(name="追溯码申请ID(必填)") @RequestBody LongIdPo po){
        return service.findRtspCodeInfo(po);
    }

    /**
     * 根据批次号/追溯码 查询档案详细信息
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findArchInfo", method = RequestMethod.POST)
    @ApiOperation(nickname="App端【追溯】", value = "oritrapla-026_【追溯】根据批次号/追溯码 查询档案详细信息", notes = "根据批次号/追溯码 查询档案详细信息")
    public ResultPoJo<MineArchInfoVo> findArchInfo(@ApiParam(name="批次号/追溯码(必填)") @RequestBody CheckStringPo po){
        return service.findArchInfo(po);
    }

    /**
     * 导出追溯码
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/exportRtspCode", method = RequestMethod.POST)
    @ApiOperation(nickname="App端【追溯】", value = "oritrapla-028_【追溯】导出追溯码", notes = "导出追溯码")
    public ResultPoJo<?> exportRtspCode(@ApiParam(name="追溯码申请ID(必填)") @RequestBody ExportRtspCodePo po){
        return service.exportRtspCode(po);
    }

    /**
     * 档案预览
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findArchByBatchNum", method = RequestMethod.POST)
    @ApiOperation(nickname="App端【追溯】", value = "oritrapla-060_【追溯】档案预览", notes = "档案预览")
    public ResultPoJo<ScanQRCodeVo> findArchByBatchNum(@ApiParam(name="批次编号(必填)") @RequestBody CheckStringPo po) throws IOException {
        return service.findArchByBatchNum(po);
    }
}
