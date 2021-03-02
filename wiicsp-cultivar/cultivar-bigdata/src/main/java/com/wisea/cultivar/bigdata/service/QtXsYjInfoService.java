package com.wisea.cultivar.bigdata.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.service.SystemCacheService;
import com.wisea.cloud.common.sys.entity.Dict;
import com.wisea.cloud.common.util.AjaxDownLoadUtil;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.common.util.excel.ImportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.bigdata.QtXsYjInfoMapper;
import com.wisea.cultivar.common.entity.bigdata.QtXsYjInfo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoListPo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.QtXsYjInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.QtXsYjInfoListVo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * QtXsYjInfoService 24小时预警信息 Service 2019/12/02 11:02:15
 */
@Service
public class QtXsYjInfoService extends BaseService {
	@Autowired
	protected QtXsYjInfoMapper qtXsYjInfoMapper;
	@Autowired
	protected SystemCacheService systemCacheService;

	/**
	 * 查询分页列表
	 */
	public ResultPoJo<Page<QtXsYjInfoListVo>> findPage(QtXsYjInfoPagePo qtXsYjInfoPagePo) {
		ResultPoJo<Page<QtXsYjInfoListVo>> result = new ResultPoJo<>();
		Page<QtXsYjInfoListVo> page = qtXsYjInfoPagePo.getPage();
		List<QtXsYjInfoListVo> list = qtXsYjInfoMapper.findPage(qtXsYjInfoPagePo);
		page.setList(list);
		result.setResult(page);
		return result;
	}

	/**
	 * 查询列表
	 */
	public ResultPoJo<List<QtXsYjInfoListVo>> findList(QtXsYjInfoListPo qtXsYjInfoListPo) {
		ResultPoJo<List<QtXsYjInfoListVo>> result = new ResultPoJo<>();
		result.setResult(qtXsYjInfoMapper.findList(qtXsYjInfoListPo));
		return result;
	}

	/**
	 * 查询
	 */
	public ResultPoJo<QtXsYjInfoGetVo> get(QtXsYjInfoGetPo qtXsYjInfoGetPo) {
		ResultPoJo<QtXsYjInfoGetVo> result = new ResultPoJo<>();
		QtXsYjInfo entity = qtXsYjInfoMapper.selectByPrimaryKey(qtXsYjInfoGetPo.getId());
		QtXsYjInfoGetVo vo = new QtXsYjInfoGetVo();
		ConverterUtil.copyProperties(entity, vo);
		result.setResult(vo);
		return result;
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> insert(QtXsYjInfoInsertPo qtXsYjInfoInsertPo) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		QtXsYjInfo qtXsYjInfo = new QtXsYjInfo();
		ConverterUtil.copyProperties(qtXsYjInfoInsertPo, qtXsYjInfo);
		qtXsYjInfo.preInsert();
		qtXsYjInfoMapper.insertSelective(qtXsYjInfo);
		return result;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> update(QtXsYjInfoUpdatePo qtXsYjInfoUpdatePo) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		QtXsYjInfo qtXsYjInfo = new QtXsYjInfo();
		ConverterUtil.copyProperties(qtXsYjInfoUpdatePo, qtXsYjInfo);
		qtXsYjInfo.preUpdate();
		qtXsYjInfoMapper.updateByPrimaryKeySelective(qtXsYjInfo);
		return result;
	}

	/**
	 * 批量删除
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> batDelete(QtXsYjInfoBatDeletePo qtXsYjInfoBatDeletePo) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		for (Long delId : qtXsYjInfoBatDeletePo.getDelList()) {
			QtXsYjInfo qtXsYjInfo = new QtXsYjInfo();
			qtXsYjInfo.setId(delId);
			qtXsYjInfo.preUpdate();
			qtXsYjInfoMapper.deleteLogic(qtXsYjInfo);
		}
		return result;
	}

	/**
	 * 导出24小时预警信息
	 *
	 * @param po
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ResultPoJo<Object> export(String data, HttpServletResponse response) throws IOException {
		ResultPoJo<Object> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

		QtXsYjInfoListPo po = new QtXsYjInfoListPo();
		if (ConverterUtil.isNotEmpty(data)) {
			po.setSubEntpId(Long.parseLong(data));
		}

		List<QtXsYjInfoListVo> list = qtXsYjInfoMapper.findList(po);

		Map<String, List<Dict>> val = systemCacheService.getDictMap();
		// 转换字典值
		for (QtXsYjInfoListVo qtXsYjInfoListVo : list) {

			for (Dict i : val.get("yj_type")) {
				if (qtXsYjInfoListVo.getYjType().equals(i.getValue())) {
					qtXsYjInfoListVo.setYjType(i.getLabel());
				}
			}
		}

		String fileName = "24小时预警信息数据.xlsx";
		ExportExcel exportExcel = new ExportExcel("24小时预警信息数据", QtXsYjInfoListVo.class);
		exportExcel.setDataList(list).writeWithAjaxHeader(response, fileName).dispose();
		return pojo;
	}

	/**
	 * 下载导入数据模板
	 *
	 * @param po
	 * @param response
	 * @return
	 */
	public ResultPoJo<String> getTemplate(QtXsYjInfoListPo po, HttpServletResponse response) {
		ResultPoJo<String> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		try {
			String fileName = "24小时预警信息导入模板.xlsx";
			List<QtXsYjInfo> list = Lists.newArrayList();
			// 第三个参数设置为“2”表示输出为导入模板（1:导出数据；2：导入模板）
			new ExportExcel("24小时预警信息", QtXsYjInfo.class).setDataList(list).writeWithAjaxHeader(response, fileName)
					.dispose();
		} catch (Exception e) {
			pojo.setCode(ConstantCodeMsg.ERR_999);
			pojo.setMsg("下载导入数据模板失败！");
			LoggerUtil.error("【downloadTemplate】模版下载出现异常：", e);
			AjaxDownLoadUtil.setResponseResult(response, pojo);
		}
		return pojo;
	}

	/**
	 * 导入
	 *
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	@Transactional
	public ResultPoJo excelImport(MultipartFile file,String subEntpId) throws Exception {
		ImportExcel excel = new ImportExcel(file, 1, 0);
		List<QtXsYjInfo> list = excel.getDataList(QtXsYjInfo.class);
		// 校验
		check(list);
		Map<String, List<Dict>> val = systemCacheService.getDictMap();
		list.forEach(i -> {
			i.preInsert();
			i.setSubEntpId(Long.parseLong(subEntpId));
			// 转换字典值
			for (Dict ic : val.get("yj_type")) {
				if (i.getYjType().equals(ic.getLabel())) {
					i.setYjType(ic.getValue());
				}
			}
			//处理科学计数法的情况
			if(i.getLogisticsDriverTel().toLowerCase().contains("e")){
				BigDecimal bd1 = new BigDecimal(i.getLogisticsDriverTel());
				i.setLogisticsDriverTel(bd1.toPlainString());
		    }

			qtXsYjInfoMapper.insertSelective(i);
		});
		return new ResultPoJo();
	}

	/**
	 * 校验数据
	 *
	 * @param list
	 */
	private void check(List<QtXsYjInfo> list) {
		Supplier<Stream<QtXsYjInfo>> supplier = list::stream;

		Map<String, List<Dict>> val = systemCacheService.getDictMap();
		// 检查非空字段
		long count0 = supplier.get().filter(i -> ConverterUtil.isEmpty(i.getZdddDate())).count();
		if (count0 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
		}
		long count1 = supplier.get().filter(i -> ConverterUtil.isEmpty(i.getPlaceOriginAddress())).count();
		if (count1 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
		}
		long count2 = supplier.get().filter(i -> ConverterUtil.isEmpty(i.getVaritName())).count();
		if (count2 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
		}
		long count3 = supplier.get().filter(i -> ConverterUtil.isEmpty(i.getYjType())).count();
		if (count3 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
		}
		long count4 = supplier.get().filter(i -> ConverterUtil.isEmpty(i.getLogisticsDriverTel())).count();
		if (count4 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
		}
	}

	/**
	 * 导入
	 */
	public ResultPoJo<Object> importExcel(MultipartFile upfile, MultipartHttpServletRequest request,
			String subEntpId) {
		 //初期化处理
        ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantError.NOMAL);
        Iterator<String> itr = request.getFileNames();
        // 只传递一个文件
        while (itr.hasNext()) {
            try {
            	   String paramName = itr.next();
                   // 获取需要上传的文件
                   List<MultipartFile> mfList = request.getFiles(paramName);
                   for (MultipartFile mf : mfList) {
                       ImportExcel importExcel = new ImportExcel(mf, 1, 0);
                       List<QtXsYjInfo> qtXsYjInfoList = importExcel.getDataList(QtXsYjInfo.class);
                       //校验
                       check(qtXsYjInfoList);
                       Map<String, List<Dict>> val = systemCacheService.getDictMap();
                       qtXsYjInfoList.forEach(e -> {
                   			e.preInsert();
                   			e.setSubEntpId(Long.parseLong(subEntpId));
                   			// 转换字典值
                   			for (Dict ic : val.get("yj_type")) {

                   				if (e.getYjType().equals(ic.getLabel())) {
                   					e.setYjType(ic.getValue());
                   				}
                   			}
                   		    //处理科学计数法的情况
	                   		 BigDecimal bd1 = new BigDecimal(e.getLogisticsDriverTel());
	            			 if( e.getLogisticsDriverTel().toLowerCase().contains("e")){
	            				 e.setLogisticsDriverTel(bd1.toPlainString());
	            		     }
                   			qtXsYjInfoMapper.insertSelective(e);
                      });
                   }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                result.setCode(ConstantCodeMsg.ERR_001);
                result.setMsg(ConstantCodeMsg.MSG_001);
            }
        }
        return result;

	}

}
