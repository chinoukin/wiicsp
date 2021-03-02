package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoListPo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoUpdatePo;
import com.wisea.cultivar.bigdata.service.QtXsYjInfoService;
import com.wisea.cultivar.common.vo.bigdata.QtXsYjInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.QtXsYjInfoListVo;
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
 * QtXsYjInfoController 24小时预警信息 Controller 2019/12/02 11:02:15
 */
@Api(tags = "24小时预警信息相关接口")
@RequestMapping(value = "/w/qtXsYjInfo")
@RestController
public class QtXsYjInfoController {
	@Autowired
	protected QtXsYjInfoService qtXsYjInfoService;

	@ApiOperation(value = "获取24小时预警信息分页列表")
	@RequestMapping(value = "page", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Page<QtXsYjInfoListVo>> findPage(@RequestBody QtXsYjInfoPagePo qtXsYjInfoPagePo) {
		return qtXsYjInfoService.findPage(qtXsYjInfoPagePo);
	}

	@ApiOperation(value = "获取24小时预警信息列表")
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<List<QtXsYjInfoListVo>> list(@RequestBody QtXsYjInfoListPo qtXsYjInfoListPo) {
		return qtXsYjInfoService.findList(qtXsYjInfoListPo);
	}

	@ApiOperation(value = "查询24小时预警信息")
	@RequestMapping(value = "get", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<QtXsYjInfoGetVo> get(@RequestBody QtXsYjInfoGetPo qtXsYjInfoGetPo) {
		return qtXsYjInfoService.get(qtXsYjInfoGetPo);
	}

	@ApiOperation(value = "新增24小时预警信息")
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Object> insert(@RequestBody QtXsYjInfoInsertPo qtXsYjInfoInsertPo) {
		return qtXsYjInfoService.insert(qtXsYjInfoInsertPo);
	}

	@ApiOperation(value = "修改24小时预警信息")
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Object> update(@RequestBody QtXsYjInfoUpdatePo qtXsYjInfoUpdatePo) {
		return qtXsYjInfoService.update(qtXsYjInfoUpdatePo);
	}

	@ApiOperation(value = "批量删除24小时预警信息")
	@RequestMapping(value = "batDelete", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Object> batDelete(@RequestBody QtXsYjInfoBatDeletePo qtXsYjInfoBatDeletePo) {
		return qtXsYjInfoService.batDelete(qtXsYjInfoBatDeletePo);
	}

	/**
	 * 导出24小时预警信息
	 *
	 * @param
	 * @return
	 * @throws IOException
	 */
	@DataCheck
	@ApiOperation("导出24小时预警信息")
	@RequestMapping(value = "/export", method = RequestMethod.POST)
	public ResultPoJo<Object> export(@RequestHeader String data, HttpServletResponse response)
			throws IOException {
		return qtXsYjInfoService.export(data, response);
	}

	/**
	 * 下载导入数据模板
	 *
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@ApiOperation("下载导入24小时预警信息模版")
	@RequestMapping(value = "/template", method = RequestMethod.POST)
	public ResultPoJo<String> getTemplate(HttpServletResponse response, QtXsYjInfoListPo po) {
		return qtXsYjInfoService.getTemplate(po, response);
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
        return qtXsYjInfoService.excelImport(file,data);
    }

    @ApiOperation(value = "导入")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> importExcel(MultipartFile upfile, MultipartHttpServletRequest request,@RequestHeader String data) throws UnsupportedEncodingException {
        return qtXsYjInfoService.importExcel(upfile, request,data);
    }
}
