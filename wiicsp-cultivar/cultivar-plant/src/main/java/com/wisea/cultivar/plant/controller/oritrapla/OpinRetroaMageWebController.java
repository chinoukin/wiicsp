package com.wisea.cultivar.plant.controller.oritrapla;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.SystemCacheService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.common.util.RequestContextUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.LongIdPo;
import com.wisea.cultivar.plant.vo.oritrapla.WebOpinRetroaMageVo;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.mapper.oritrapla.OpinRetroaMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.WebOpinRetroaMageAddPo;
import com.wisea.cultivar.plant.po.oritrapla.WebOpinRetroaMageListPo;
import com.wisea.cultivar.plant.po.oritrapla.WebOpinRetroaMagePo;
import com.wisea.cultivar.plant.service.oritrapla.OpinRetroaMageService;
import com.wisea.cultivar.plant.utils.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 意见反馈管理
 *
 * @author wzx
 * TODO 保留
 */
@Api(tags = "【原产地通】web意见反馈管理")
@RestController
@RequestMapping("/w/web/opinRetroa")
public class OpinRetroaMageWebController {

	@Autowired
	OpinRetroaMageService service;
	private static JedisDao jedisDao;
	public final static String cacheKey = "SETTLE_OPINRETROA_LIST_CACHE_KEY_";
	@Autowired
	private OpinRetroaMageMapper mapper;
	@Autowired
	private SystemCacheService cacheService;

	/**
	 * 查询意见反馈列表信息
	 *
	 * @param po
	 * @return
	 */
	@ApiOperation(nickname = "查询意见反馈列表信息", value = "oritrapla_115_【意见反馈管理】查询意见反馈列表信息（code 为000时 msg 为导出Excel的参数，十分钟后过期）", notes = "查询意见反馈列表信息")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Page<WebOpinRetroaMageVo>> findListPage(@RequestBody WebOpinRetroaMageListPo po) {
		return service.findListPage(po);
	}

	/**
	 * 处理意见的保存
	 *
	 * @param
	 * @return
	 */
	@ApiOperation(nickname = "处理意见的保存", value = "oritrapla_119_【意见反馈管理】处理意见的保存", notes = "处理意见的保存")
	@RequestMapping(value = "/handle", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<?> addOpinRetroa(@RequestBody WebOpinRetroaMageAddPo po) {
		return service.addOpinRetroa(po);
	}


	/**
	 * 导出意见反馈信息
	 *
	 * @return
	 */
	@ApiOperation(nickname = "导出意见反馈信息", value = "oritrapla_116_【意见反馈管理】导出意见反馈信息（cacheId 为查询列表时返回的 msg）", notes = "导出意见反馈信息")
	@RequestMapping(value = "/export/{cacheId}", method = RequestMethod.POST)
	@DataCheck
	public void exportOpinRetroaList(@PathVariable String cacheId, HttpServletResponse response)throws Exception {
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			response.addHeader("Access-Control-Expose-Headers", "error_code, error_msg");
			response.setHeader("error_code", ConstantCodeMsg.ERR_702);
			response.setHeader("error_msg", URLEncoder.encode(ConstantCodeMsg.MSG_702,"utf-8"));
			return;
		}

		if (ConverterUtil.isEmpty()) {
			jedisDao = SpringBootContext.getBean(JedisDao.class);
		}

		WebOpinRetroaMageListPo po = jedisDao.getSerialize(cacheKey.concat(cacheId), WebOpinRetroaMageListPo.class);
		if (ConverterUtil.isEmpty(po)) {
			response.addHeader("Access-Control-Expose-Headers", "error_code, error_msg");
			response.setHeader("error_code", ConstantCodeMsg.ERR_601);
			response.setHeader("error_msg", URLEncoder.encode(ConstantCodeMsg.MSG_601, "utf-8"));
			return;
		}

		// 查询导出数据
		WebOpinRetroaMagePo exportPo = new WebOpinRetroaMagePo();
		ConverterUtil.copyProperties(po,exportPo);
		List<WebOpinRetroaMageVo> data = mapper.findOpinRetroaMageListPage(exportPo);
		String fileName = "{0}{1}.{2}";
		fileName = MessageFormat.format(fileName, "意见反馈",OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "xls");

		List<String> rowMerge = Lists.newArrayList();
		rowMerge.add("序号");
		rowMerge.add("用户名");
		rowMerge.add("姓名");
		rowMerge.add("手机号");
		rowMerge.add("主体名称");
		rowMerge.add("反馈内容");
		rowMerge.add("创建时间");
		rowMerge.add("状态");
		rowMerge.add("处理人");
		rowMerge.add("处理结果");
		rowMerge.add("处理时间");
		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.getTableTitle(rowMerge);
		final Integer[] index = { 0 };
		data.forEach(e -> {
			Integer cellIndex = 0;
			Row dataRow = excelUtil.addRow();

			excelUtil.setCellValue(dataRow, cellIndex++, ++index[0], "data");
			excelUtil.setCellValue(dataRow, cellIndex++, e.getLoginName(), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, e.getContName(), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, e.getContTel(), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, e.getOrgName(), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, e.getRetroaCont(), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, OffsetDateTimeUtils.formatDateTimeToYmdhms(e.getCreateDate()), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, cacheService.getDictLabels(e.getHandleStatus(), "handle_status", ""), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, e.getUpdateName(), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, e.getHandleResult(), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, OffsetDateTimeUtils.formatDateTimeToYmdhms(e.getUpdateDate()), "data");

		});
		try {
			//response.reset();
			response.setContentType("application/octet-stream; charset=utf-8");
			response.addHeader("Access-Control-Expose-Headers", "ajax-mimeType, ajax-filename");
			OutputStream outputStream = response.getOutputStream();
			ServletContext context = RequestContextUtils.getCurrentRequest().getServletContext();
			String mimeType = context.getMimeType(fileName);
			String fName = ConverterUtil.toDownloadName(URLEncoder.encode(fileName, "utf-8"));
			response.setHeader("Content-Disposition", "attachment; filename=" + fName);
			response.setHeader("ajax-mimeType", mimeType);
			response.setHeader("ajax-filename", fName);
			response.setContentType(mimeType);
			excelUtil.getWb().write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
			response.setHeader("content-disposition", null);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			out.print("<script language='javascript'>alert('操作失败，请重新处理！');window.close();</script>");
		}
	}

	/**
	 * 查询反馈信息的详细
	 *
	 * @param
	 * @return
	 */
	@ApiOperation(nickname = "查询反馈信息的详细", value = "oritrapla_118_【意见反馈管理】查询反馈信息的详细", notes = "查询反馈信息的详细")
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<WebOpinRetroaMageVo> fingOpinRetroaInfo(@RequestBody LongIdPo po) {
		return service.fingOpinRetroaInfo(po);
	}
}
