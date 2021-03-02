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
import com.wisea.cultivar.common.dao.bigdata.PsCarJcInfoMapper;
import com.wisea.cultivar.common.dao.bigdata.SubEntpMageMapper;
import com.wisea.cultivar.common.entity.bigdata.PsCarJcInfo;
import com.wisea.cultivar.common.entity.bigdata.SubEntpMage;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoListPo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.CoordinateVo;
import com.wisea.cultivar.common.vo.bigdata.PsCarJcInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.PsCarJcInfoListVo;
import com.wisea.cultivar.common.vo.bigdata.PsCarJcReport;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * PsCarJcInfoService 配送车辆监测信息 Service 2019/12/02 11:02:15
 */
@Service
public class PsCarJcInfoService extends BaseService {
	@Autowired
	protected PsCarJcInfoMapper psCarJcInfoMapper;

	@Autowired
	protected SystemCacheService systemCacheService;

	@Autowired
	protected SubEntpMageMapper subEntpMageMapper;

	/**
	 * 查询分页列表
	 */
	public ResultPoJo<Page<PsCarJcInfoListVo>> findPage(PsCarJcInfoPagePo psCarJcInfoPagePo) {
		ResultPoJo<Page<PsCarJcInfoListVo>> result = new ResultPoJo<>();
		Page<PsCarJcInfoListVo> page = psCarJcInfoPagePo.getPage();
		List<PsCarJcInfoListVo> list = psCarJcInfoMapper.findPage(psCarJcInfoPagePo);
		page.setList(list);
		result.setResult(page);
		return result;
	}

	/**
	 * 查询列表
	 */
	public ResultPoJo<List<PsCarJcInfoListVo>> findList(PsCarJcInfoListPo psCarJcInfoListPo) {
		ResultPoJo<List<PsCarJcInfoListVo>> result = new ResultPoJo<>();
		result.setResult(psCarJcInfoMapper.findList(psCarJcInfoListPo));
		return result;
	}

	/**
	 * 查询地图报表
	 * @param po
	 * @return
	 */
	public ResultPoJo<PsCarJcReport> getMapReport(PsCarJcInfoGetPo po) {
		ResultPoJo<PsCarJcReport> result = new ResultPoJo<>();
		PsCarJcReport psCarJcReport = new PsCarJcReport();
		SubEntpMage subEntpMage = subEntpMageMapper.selectByPrimaryKey(po.getId());
		if (ConverterUtil.isNotEmpty(subEntpMage)) {
			CoordinateVo enptZb = new CoordinateVo();
			enptZb.setLat(subEntpMage.getWd());
			enptZb.setLng(subEntpMage.getJd());
			psCarJcReport.setEnptZb(enptZb);

			PsCarJcInfoListPo psCarJcInfoListPo = new PsCarJcInfoListPo();
			psCarJcInfoListPo.setSubEntpId(po.getId());
			List<PsCarJcInfoListVo> list  = psCarJcInfoMapper.findList(psCarJcInfoListPo);
			List<CoordinateVo> carZb = Lists.newArrayList();
			for (PsCarJcInfoListVo vo : list) {
				CoordinateVo coo = new CoordinateVo();
				coo.setLat(vo.getWd());
				coo.setLng(vo.getJd());
			//	psCarJcReport.setCarZb(Arrays.asList(Arrays.asList(vo.getJd().toString(),vo.getWd().toString())));
				carZb.add(coo);
			}
			psCarJcReport.setCarZb(carZb);
		}
        result.setResult(psCarJcReport);
		return result;
	}

	/**
	 * 查询
	 */
	public ResultPoJo<PsCarJcInfoGetVo> get(PsCarJcInfoGetPo psCarJcInfoGetPo) {
		ResultPoJo<PsCarJcInfoGetVo> result = new ResultPoJo<>();
		PsCarJcInfo entity = psCarJcInfoMapper.selectByPrimaryKey(psCarJcInfoGetPo.getId());
		PsCarJcInfoGetVo vo = new PsCarJcInfoGetVo();
		ConverterUtil.copyProperties(entity, vo);
		result.setResult(vo);
		return result;
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> insert(PsCarJcInfoInsertPo psCarJcInfoInsertPo) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		PsCarJcInfo psCarJcInfo = new PsCarJcInfo();
		ConverterUtil.copyProperties(psCarJcInfoInsertPo, psCarJcInfo);
		psCarJcInfo.preInsert();
		psCarJcInfoMapper.insertSelective(psCarJcInfo);
		return result;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> update(PsCarJcInfoUpdatePo psCarJcInfoUpdatePo) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		PsCarJcInfo psCarJcInfo = new PsCarJcInfo();
		ConverterUtil.copyProperties(psCarJcInfoUpdatePo, psCarJcInfo);
		psCarJcInfo.preUpdate();
		psCarJcInfoMapper.updateByPrimaryKeySelective(psCarJcInfo);
		return result;
	}

	/**
	 * 批量删除
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> batDelete(PsCarJcInfoBatDeletePo psCarJcInfoBatDeletePo) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		for (Long delId : psCarJcInfoBatDeletePo.getDelList()) {
			PsCarJcInfo psCarJcInfo = new PsCarJcInfo();
			psCarJcInfo.setId(delId);
			psCarJcInfo.preUpdate();
			psCarJcInfoMapper.deleteLogic(psCarJcInfo);
		}
		return result;
	}

	/**
	 * 导出配送车辆监测信息
	 *
	 * @param po
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ResultPoJo<Object> export(String data, HttpServletResponse response) throws IOException {
		ResultPoJo<Object> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		PsCarJcInfoListPo po = new PsCarJcInfoListPo();
		if (ConverterUtil.isNotEmpty(data)) {
			po.setSubEntpId(Long.parseLong(data));
		}
		List<PsCarJcInfoListVo> list = psCarJcInfoMapper.findList(po);
		Map<String, List<Dict>> val = systemCacheService.getDictMap();
		// 处理数据
		for (PsCarJcInfoListVo psCarJcInfoListVo : list) {
			// 拼接经纬度
			psCarJcInfoListVo.setCoordinate(psCarJcInfoListVo.getJd() + "," + psCarJcInfoListVo.getWd());
			// 车辆类型
			// 转换字典值
			for (Dict i : val.get("car_type")) {
				if (psCarJcInfoListVo.getCarType().equals(i.getValue())) {
					psCarJcInfoListVo.setCarType(i.getLabel());
				}
			}
			// 当前状态
			for (Dict i : val.get("car_jc_state")) {
				if (psCarJcInfoListVo.getCarJcState().equals(i.getValue())) {
					psCarJcInfoListVo.setCarJcState(i.getLabel());
				}
			}
		}

		String fileName = "配送车辆监测信息.xlsx";
		ExportExcel exportExcel = new ExportExcel("配送车辆监测信息", PsCarJcInfoListVo.class);
		exportExcel.setDataList(list).writeWithAjaxHeader(response, fileName).dispose();
		return pojo;
	}

	/**
	 * 导入
	 *
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public ResultPoJo excelImport(MultipartFile file,  String subEntpId) throws Exception {
		ImportExcel excel = new ImportExcel(file, 1, 0);
		List<PsCarJcInfo> list = excel.getDataList(PsCarJcInfo.class);
		PsCarJcInfoListPo po= new PsCarJcInfoListPo();
		po.setSubEntpId(Long.parseLong(subEntpId));
		// 校验
		check(list, po);
		Map<String, List<Dict>> val = systemCacheService.getDictMap();
		list.forEach(i -> {
			i.preInsert();

			i.setSubEntpId(po.getSubEntpId());

			// 车辆类型
			// 转换字典值
			for (Dict ic : val.get("car_type")) {
				if (i.getCarType().equals(ic.getLabel())) {
					i.setCarType(ic.getValue());
				}
			}
			// 当前状态
			for (Dict ic : val.get("car_jc_state")) {
				if (i.getCarJcState().equals(ic.getLabel())) {
					i.setCarJcState(ic.getValue());
				}
			}
			List<String> zb = numberCheck(i.getCoordinate());
			i.setJd(Double.parseDouble(zb.get(0)));
			i.setWd(Double.parseDouble(zb.get(1)));

			psCarJcInfoMapper.insertSelective(i);
		});
		return new ResultPoJo();
	}

	/**
	 * 下载导入数据模板
	 *
	 * @param po
	 * @param response
	 * @return
	 */
	public ResultPoJo<String> getTemplate(PsCarJcInfo po, HttpServletResponse response) {
		ResultPoJo<String> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		try {
			String fileName = "配送车辆监测信息导入模板.xlsx";
			List<PsCarJcInfo> list = Lists.newArrayList();
			// 第三个参数设置为“2”表示输出为导入模板（1:导出数据；2：导入模板）
			new ExportExcel("配送车辆监测信息", PsCarJcInfo.class).
					setDataList(list)
					.writeWithAjaxHeader(response, fileName)
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
	 * 校验数据
	 *
	 * @param list
	 */
	private void check(List<PsCarJcInfo> list, PsCarJcInfoListPo po) {
		Supplier<Stream<PsCarJcInfo>> supplier = list::stream;

		// 检查非空字段
		long count0 = supplier.get().filter(i -> ConverterUtil.isEmpty(i.getCarNum())).count();
		if (count0 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
		}
		List<String> importCarNums = supplier.get().map(PsCarJcInfo::getCarNum).distinct().collect(Collectors.toList());
		if (importCarNums.size() < list.size()) {
			throw new BusinessException(ConstantCodeMsg.ERR_115, ConstantCodeMsg.MSG_115);
		}

		List<PsCarJcInfoListVo> entity = psCarJcInfoMapper.findList(po);
		List<String> carNums = entity.stream().map(PsCarJcInfoListVo::getCarNum).collect(Collectors.toList());
		carNums.removeAll(importCarNums);
		if (carNums.size() < entity.size()) {
			throw new BusinessException(ConstantCodeMsg.ERR_115, ConstantCodeMsg.MSG_115);
		}
		long count1 = supplier.get().filter(i -> ConverterUtil.isEmpty(i.getCarType())).count();
		if (count1 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
		}
		long count2 = supplier.get().filter(i -> ConverterUtil.isEmpty(i.getSsDate())).count();
		if (count2 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
		}
		long count3 = supplier.get().filter(i -> ConverterUtil.isEmpty(i.getCxwd())).count();
		if (count3 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
		}
		long count4 = supplier.get().filter(i -> ConverterUtil.isEmpty(i.getCarJcState())).count();
		if (count4 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
		}
		long count5 = supplier.get().filter(i -> ConverterUtil.isEmpty(i.getCoordinate())).count();
		if (count5 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
		}

		// 检查坐标点是否规范
		long count6 = supplier.get().filter(i -> numberCheck(i.getCoordinate()).size() != 2).count();
		if (count6 > 0) {
			throw new BusinessException(ConstantCodeMsg.ERR_113, ConstantCodeMsg.MSG_113);
		}

	}


	/**
	 * 正则，直接取出数字
	 *
	 * @param coord
	 * @return
	 */
	public List<String> numberCheck(String coord) {

		String pattern = "-?([1-9]\\d*\\.\\d+|0\\.\\d*[1-9]\\d*|0?\\.0+|0|[1-9]\\d*|-[1-9]\\d*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(coord);
		List<String> result = new ArrayList<>();
		while (m.find()) {
			result.add(m.group());
		}
		return result;
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
                       List<PsCarJcInfo> psCarJcInfoList = importExcel.getDataList(PsCarJcInfo.class);
                       //校验
                       PsCarJcInfoListPo po = new PsCarJcInfoListPo();
                       po.setSubEntpId(Long.parseLong(subEntpId));
                       check(psCarJcInfoList,po);
                       Map<String, List<Dict>> val = systemCacheService.getDictMap();
                       psCarJcInfoList.forEach(i -> {
                    		i.preInsert();
                   			i.setSubEntpId(po.getSubEntpId());

                   			// 车辆类型
                   			// 转换字典值
                   			for (Dict ic : val.get("car_type")) {
                   				if (i.getCarType().equals(ic.getLabel())) {
                   					i.setCarType(ic.getValue());
                   				}
                   			}
                   			// 当前状态
                   			for (Dict ic : val.get("car_jc_state")) {
                   				if (i.getCarJcState().equals(ic.getLabel())) {
                   					i.setCarJcState(ic.getValue());
                   				}
                   			}
                   			List<String> zb = numberCheck(i.getCoordinate());
                   			i.setJd(Double.parseDouble(zb.get(0)));
                   			i.setWd(Double.parseDouble(zb.get(1)));

                   			psCarJcInfoMapper.insertSelective(i);

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
