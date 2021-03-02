package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.entity.bigdata.PsCarJcInfo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoListPo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoUpdatePo;
import com.wisea.cultivar.bigdata.service.PsCarJcInfoService;
import com.wisea.cultivar.common.vo.bigdata.PsCarJcInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.PsCarJcInfoListVo;
import com.wisea.cultivar.common.vo.bigdata.PsCarJcReport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * PsCarJcInfoController
 * 配送车辆监测信息 Controller
 * 2019/12/02 11:02:15
 */
@Api(tags = "配送车辆监测信息相关接口")
@RequestMapping(value = "/w/psCarJcInfo")
@RestController
public class PsCarJcInfoController {
    @Autowired
    protected PsCarJcInfoService psCarJcInfoService;

    @ApiOperation(value = "获取配送车辆监测信息分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<PsCarJcInfoListVo>> findPage(@RequestBody PsCarJcInfoPagePo psCarJcInfoPagePo) {
        return psCarJcInfoService.findPage(psCarJcInfoPagePo);
    }

    @ApiOperation(value = "获取配送车辆监测信息列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<PsCarJcInfoListVo>> list(@RequestBody PsCarJcInfoListPo psCarJcInfoListPo) {
        return psCarJcInfoService.findList(psCarJcInfoListPo);
    }

    @ApiOperation(value = "查询配送车辆监测信息")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<PsCarJcInfoGetVo> get(@RequestBody PsCarJcInfoGetPo psCarJcInfoGetPo) {
        return psCarJcInfoService.get(psCarJcInfoGetPo);
    }

    @ApiOperation(value = "新增配送车辆监测信息")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody PsCarJcInfoInsertPo psCarJcInfoInsertPo) {
        return psCarJcInfoService.insert(psCarJcInfoInsertPo);
    }

    @ApiOperation(value = "修改配送车辆监测信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody PsCarJcInfoUpdatePo psCarJcInfoUpdatePo) {
        return psCarJcInfoService.update(psCarJcInfoUpdatePo);
    }

    @ApiOperation(value = "批量删除配送车辆监测信息")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody PsCarJcInfoBatDeletePo psCarJcInfoBatDeletePo) {
        return psCarJcInfoService.batDelete(psCarJcInfoBatDeletePo);
    }
    /**
     * 导出配送车辆监测信息
     *
     * @param
     * @return
     * @throws IOException
     */
	@DataCheck
    @ApiOperation("导出配送车辆监测信息")
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public ResultPoJo<Object> export(@RequestHeader String data, HttpServletResponse response) throws IOException {
		return psCarJcInfoService.export(data, response);
    }

	/**
	 * 下载导入数据模板
	 *
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@ApiOperation("下载配送车辆监测信息模版")
	@RequestMapping(value = "/template", method = RequestMethod.POST)
	public ResultPoJo<String> getTemplate(HttpServletResponse response, PsCarJcInfo po) {
		return psCarJcInfoService.getTemplate(po, response);
	}

	/**
	 * 导入
	 * @param file
	 * @return
	 * @throws Exception
	 */
    @ApiOperation("导入")
    @PostMapping("/import")
    @DataCheck
    public ResultPoJo excelImport(MultipartFile file,@RequestHeader String data) throws Exception {
        return psCarJcInfoService.excelImport(file,data);
    }

    @ApiOperation(value = "查询地图报表")
    @RequestMapping(value = "/getMapReport", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<PsCarJcReport> getMapReport(@RequestBody PsCarJcInfoGetPo po) {
        return psCarJcInfoService.getMapReport(po);
    }

    @ApiOperation(value = "导入")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public ResultPoJo<Object> importExcel(MultipartFile upfile,MultipartHttpServletRequest request,@RequestHeader String data) throws UnsupportedEncodingException {
        return psCarJcInfoService.importExcel(upfile,request,data);
    }
}
