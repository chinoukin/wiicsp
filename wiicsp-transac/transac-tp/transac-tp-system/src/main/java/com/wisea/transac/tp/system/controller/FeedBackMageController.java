package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.FeedBackMagePageListPo;
import com.wisea.transac.common.po.FeedBackMagePo;
import com.wisea.transac.common.vo.FeedBackMageExportVo;
import com.wisea.transac.common.vo.FeedBackMageInfoVo;
import com.wisea.transac.common.vo.FeedBackMagePageListVo;
import com.wisea.transac.tp.system.service.FeedBackMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className FeedBackMageController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@RestController
@RequestMapping("/w/FeedBackMage")
@Api(tags = "反馈信息管理")
public class FeedBackMageController {
    @Autowired
    private FeedBackMageService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FeedBackMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<FeedBackMagePageListVo>> findPageList(@RequestBody FeedBackMagePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改FeedBackMage
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody FeedBackMagePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息FeedBackMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<FeedBackMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * 导出信息
     */
    @DataCheck
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public void export(HttpServletResponse response){
        List<FeedBackMageExportVo> export = service.export();
        String fileName = "意见反馈管理信息" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
        try {
            new ExportExcel("意见反馈管理信息", FeedBackMageExportVo.class).setDataList(export)
                    .writeWithAjaxHeader(response, fileName).dispose();
        } catch (Exception e) {
            throw new RuntimeException("Excel导出失败" + e.getMessage(), e);
        }
    }

    @DataCheck
    @RequestMapping(value = "/deal", method = RequestMethod.POST)
    @ApiOperation(nickname = "处理反馈", value = "处理反馈", notes = "处理反馈", httpMethod = "POST")
    public ResultPoJo deal(@RequestBody FeedBackMagePo po) {
        return service.deal(po);
    }

}
