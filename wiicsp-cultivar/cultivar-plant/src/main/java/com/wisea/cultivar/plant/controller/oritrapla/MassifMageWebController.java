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
import com.wisea.cultivar.plant.vo.oritrapla.MassifRelatedVo;
import com.wisea.cultivar.plant.vo.oritrapla.WebMassifMageVo;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.mapper.oritrapla.MassifMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.StringPo;
import com.wisea.cultivar.plant.po.oritrapla.WebMassifMageListPo;
import com.wisea.cultivar.plant.po.oritrapla.WebMassifMagePo;
import com.wisea.cultivar.plant.service.oritrapla.MassifMageService;
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
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 地块信息列表管理
 *
 * @author wzx
 * TODO 保留
 */
@Api(tags = "【原产地通】web地块信息列表管理")
@RestController
@RequestMapping("/w/web/massif")
public class MassifMageWebController {

	@Autowired
	MassifMageService service;
	private static JedisDao jedisDao;
	@Autowired
	private MassifMageMapper mapper;
	@Autowired
	private SystemCacheService cacheService;

	public final static String cacheKey = "SETTLE_MASSIF_LIST_CACHE_KEY_";

	/**
	 * 查询地块信息列表
	 *
	 * @param po
	 * @return
	 */
	@ApiOperation(nickname = "查询地块信息列表", value = "oritrapla_112_【地块管理】查询地块信息列表（code 为000时 msg 为导出Excel的参数，十分钟后过期）", notes = "查询地块信息列表")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<Page<WebMassifMageVo>> findListPage(@RequestBody WebMassifMageListPo po) {
		return service.findListPage(po);
	}

	/**
	 * 导出地块信息的操作
	 *
	 * @return
	 */
	@ApiOperation(nickname = "导出地块信息的操作", value = "oritrapla_113_【地块管理】导出地块信息的操作（cacheId 为查询列表时返回的 msg）", notes = "导出地块信息的操作")
	@RequestMapping(value = "/export/{cacheId}", method = RequestMethod.POST)
	@DataCheck
	public void exportMassifList(@PathVariable String cacheId, HttpServletResponse response) throws Exception {
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

		WebMassifMageListPo po = jedisDao.getSerialize(cacheKey.concat(cacheId), WebMassifMageListPo.class);
		if (ConverterUtil.isEmpty(po)) {
			response.addHeader("Access-Control-Expose-Headers", "error_code, error_msg");
			response.setHeader("error_code", ConstantCodeMsg.ERR_601);
			response.setHeader("error_msg", URLEncoder.encode(ConstantCodeMsg.MSG_601, "utf-8"));
			return;
		}

		// 查询导出数据
		WebMassifMagePo exportPo = new WebMassifMagePo();
		ConverterUtil.copyProperties(po,exportPo);
		List<WebMassifMageVo> data = mapper.findMassifMageListPage(exportPo);
		String fileName = "{0}{1}.{2}";
		fileName = MessageFormat.format(fileName, "地块信息",OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "xls");

		DecimalFormat df = new DecimalFormat("#.##");

		List<String> rowMerge = Lists.newArrayList();
		rowMerge.add("序号");
		rowMerge.add("地块名称");
		rowMerge.add("地块类型");
		rowMerge.add("面积（亩）");
		rowMerge.add("主体名称");
		rowMerge.add("创建人");
		rowMerge.add("创建时间");
		rowMerge.add("更新人");
		rowMerge.add("更新时间");
		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.getTableTitle(rowMerge);
		final Integer[] index = { 0 };
		data.forEach(e -> {
			Integer cellIndex = 0;
			Row dataRow = excelUtil.addRow();
			excelUtil.setCellValue(dataRow, cellIndex++, ++index[0], "data");
			excelUtil.setCellValue(dataRow, cellIndex++, e.getMassifName(), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, cacheService.getDictLabel(e.getMassifType(), "massif_type", ""), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, df.format(e.getMassifAcre()), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, e.getOrgName(), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, e.getCreateName(), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, OffsetDateTimeUtils.formatDateTimeToYmdhms(e.getCreateDate()),"data");
			excelUtil.setCellValue(dataRow, cellIndex++, e.getUpdateName(), "data");
			excelUtil.setCellValue(dataRow, cellIndex++, OffsetDateTimeUtils.formatDateTimeToYmdhms(e.getUpdateDate()),"data");
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
	 * @author jirg
	 * @date 2020/8/14 16:23
	 * @Description 所有地块关联列表 - 提供【资源管理系统】使用
	 */
	@ApiOperation(nickname = "地块关联列表【资源管理系统】使用", value = "地块关联列表", notes = "地块关联列表")
	@RequestMapping(value = "/massifRelatedList", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<List<MassifRelatedVo>> massifRelatedList(@RequestBody StringPo po) {
		return service.massifRelatedList(po);
	}



}
