package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.CheckStringPo;
import com.wisea.cultivar.plant.po.oritrapla.ExportRtspCodePo;
import com.wisea.cultivar.plant.po.oritrapla.LongIdPo;
import com.wisea.cultivar.plant.po.oritrapla.RtspCodeMageListPo;
import com.wisea.cultivar.plant.vo.oritrapla.ArchInfoCirculationVo;
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
 * CreateDate:  2018/6/22
 * projectName:  oritrapla
 * remark:  后台追溯管理Controller
 */
@RestController
@RequestMapping("/w/web/rtspCode")
@Api(value = "【原产地通】后台追溯管理控制类", description = "追溯管理", tags = "追溯管理调用接口")
public class RtspCodeMageWebController {
    @Autowired
    private RtspCodeMageService service;

    /**
     * 查询追溯码申请列表
     * @param po
     * @return
     */
    @RequestMapping(value = "/findRtspCodeList", method = RequestMethod.POST)
    @ApiOperation(nickname="Web端【追溯】", value = "oritrapla-124_【追溯】查询追溯码申请列表", notes = "查询追溯码申请列表")
    public ResultPoJo<Page<RtspCodeMageInfoVo>> findRtspCodeList(@RequestBody RtspCodeMageListPo po){
        return service.findRtspCodeList(po);
    }

    /**
     * 档案预览
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findArchByBatchNum", method = RequestMethod.POST)
    @ApiOperation(nickname="Web端【追溯】", value = "oritrapla-121_【追溯】档案预览", notes = "档案预览")
    public ResultPoJo<ScanQRCodeVo> findArchByBatchNum(@ApiParam(name="批次编号(必填)") @RequestBody CheckStringPo po) throws IOException {
        return service.findArchByBatchNum(po);
    }

    /**
     * 平台追溯监管
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findArchInfoCirculation", method = RequestMethod.POST)
    @ApiOperation(nickname="Web端【追溯】", value = "oritrapla-122_【追溯】平台追溯监管", notes = "平台追溯监管")
    public ResultPoJo<ArchInfoCirculationVo> findArchInfoCirculation(@ApiParam(name="追溯码(必填)") @RequestBody CheckStringPo po) throws IOException {
        return service.findArchInfoCirculation(po);
    }

    /**
     * 平台追溯监管 - 档案预览
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findArchByMineArchId", method = RequestMethod.POST)
    @ApiOperation(nickname="Web端【追溯】", value = "oritrapla-123_【追溯】档案预览", notes = "档案预览")
    public ResultPoJo<ScanQRCodeVo> findArchByMineArchId(@ApiParam(name="我的档案ID(必填)") @RequestBody LongIdPo po) throws IOException {
        return service.findArchByMineArchId(po);
    }

    /**
     * 导出追溯码
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/exportRtspCode", method = RequestMethod.POST)
    @ApiOperation(nickname="Web端【追溯】", value = "oritrapla-120_【追溯】导出追溯码", notes = "导出追溯码")
    public ResultPoJo<?> exportRtspCode(@ApiParam(name="追溯码申请ID(必填)") @RequestBody ExportRtspCodePo po){
        return service.exportRtspCode(po);
    }
}
