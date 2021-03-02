package com.wisea.cultivar.plant.service.oritrapla;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.RequestContextUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.oritrapla.OpinRetroaMage;
import com.wisea.cultivar.plant.mapper.oritrapla.OpinRetroaMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.LongIdPo;
import com.wisea.cultivar.plant.utils.ExcelUtil;
import com.wisea.cultivar.plant.utils.OffsetDateTimeUtils;
import com.wisea.cultivar.plant.vo.oritrapla.WebOpinRetroaMageVo;
import com.wisea.cultivar.plant.po.oritrapla.WebOpinRetroaMageAddPo;
import com.wisea.cultivar.plant.po.oritrapla.WebOpinRetroaMageListPo;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * web意见反馈管理Service
 *
 * @author wzx
 *
 */
@Service
public class OpinRetroaMageService {

	@Autowired
	private OpinRetroaMageMapper mapper;
	private static JedisDao jedisDao;
    public final static String cacheKey = "SETTLE_OPINRETROA_LIST_CACHE_KEY_";

	/**
	 * 查询意见反馈列表信息
	 *
	 * @param po
	 * @return
	 */
	public ResultPoJo<Page<WebOpinRetroaMageVo>> findListPage(WebOpinRetroaMageListPo po) {
		ResultPoJo<Page<WebOpinRetroaMageVo>> result = new ResultPoJo<Page<WebOpinRetroaMageVo>>(ConstantCodeMsg.NOMAL);

		Page<WebOpinRetroaMageVo> page = po.getPage();
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		//将查询参数缓存，导出Excel时取出（过期时间 10分钟）
        String cacheId = UUID.randomUUID().toString().replaceAll("-", "");
        if(ConverterUtil.isEmpty(jedisDao)){
            jedisDao = SpringBootContext.getBean(JedisDao.class);
        }
        po.setCreateStaDate(OffsetDateTimeUtils.getDayMinTime(po.getCreateStaDate()));
        po.setCreateEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getCreateEndDate()));

        jedisDao.setSerializeExpire(cacheKey.concat(cacheId), po, 10*60);
        result.setMsg(cacheId);
		page.setList(mapper.findOpinRetroaMageListPage(po));
		result.setResult(page);
	    if(ConverterUtil.isEmpty(jedisDao)){
            jedisDao = SpringBootContext.getBean(JedisDao.class);
        }
		return result;
	}

	/**
	 * 处理意见的保存
	 *
	 * @param po
	 * @return
	 */
	public ResultPoJo<?> addOpinRetroa(WebOpinRetroaMageAddPo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 意见反馈信息数据
		OpinRetroaMage opinRetroaData = mapper.selectByPrimaryKey(po.getId());
		// 排他校验
		if (!po.getUpdateDate().equals(opinRetroaData.getUpdateDate())) {
			result.setCode(ConstantError.ERR_009);
			result.setMsg(ConstantError.MSG_009);
			return result;
		}
		OpinRetroaMage data = new OpinRetroaMage();
		data.preUpdate();
		data.setId(po.getId());
		data.setHandleResult(po.getHandleResult());// 处理结果
		data.setHandleStatus(DictConstants.HANDLE_STATUS_0);// 已处理
		mapper.updateByPrimaryKeySelective(data);
		return result;
	}

	/**
	 * 导出意见反馈信息（未用）
	 *
	 * @param po
	 * @param response
	 * @throws Exception
	 */
	public void exportOpinRetroaList(WebOpinRetroaMageListPo po, HttpServletResponse response) throws Exception {
		try {

			User user = SystemUtils.getUser();
			if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
				response.addHeader("Access-Control-Expose-Headers", "error_code, error_msg");
				response.setHeader("error_code", ConstantCodeMsg.ERR_702);
				response.setHeader("error_msg", URLEncoder.encode(ConstantCodeMsg.MSG_702, "utf-8"));
				return;
			}

			List<WebOpinRetroaMageVo> data = mapper.findOpinRetroaMageListPage(po);
			String fileName = "{0}{1}.{2}";
			fileName = MessageFormat.format(fileName, "意见反馈",
					OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "xls");
			response.reset();
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
				excelUtil.setCellValue(dataRow, cellIndex++, e.getHandleStatus(), "data");
				excelUtil.setCellValue(dataRow, cellIndex++, e.getUpdateName(), "data");
				excelUtil.setCellValue(dataRow, cellIndex++, e.getHandleResult(), "data");
				excelUtil.setCellValue(dataRow, cellIndex++, OffsetDateTimeUtils.formatDateTimeToYmdhms(e.getUpdateDate()), "data");

			});
			excelUtil.getWb().write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
			response.addHeader("Access-Control-Expose-Headers", "error_code, error_msg");
			response.setHeader("error_code", ConstantCodeMsg.ERR_110);
			response.setHeader("error_msg", URLEncoder.encode(ConstantCodeMsg.MSG_110, "utf-8"));
		}

	}

	/**
	 * 查询反馈信息的详细
	 *
	 * @param po
	 * @return
	 */
	public ResultPoJo<WebOpinRetroaMageVo> fingOpinRetroaInfo(LongIdPo po) {
		ResultPoJo<WebOpinRetroaMageVo> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 根据id查询意见反馈信息数据
		WebOpinRetroaMageVo vo = mapper.fingOpinRetroaInfoById(po.getId());
		result.setResult(vo);
		return result;
	}

}
