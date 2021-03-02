package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.bigdata.CategoryMageMapper;
import com.wisea.cultivar.common.dao.bigdata.VarietiesMageMapper;
import com.wisea.cultivar.common.entity.bigdata.VarietiesMage;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageGetPo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageListPo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMagePagePo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.VarietiesMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.VarietiesMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * VarietiesMageService 物料管理 Service 2019/12/03 14:35:19
 */
@Service
public class VarietiesMageService extends BaseService {
	@Autowired
	protected VarietiesMageMapper varietiesMageMapper;

	@Autowired
	protected CategoryMageMapper categoryMageMapper;

	/**
	 * 查询分页列表
	 */
	public ResultPoJo<Page<VarietiesMageListVo>> findPage(VarietiesMagePagePo varietiesMagePagePo) {
		ResultPoJo<Page<VarietiesMageListVo>> result = new ResultPoJo<>();
		Page<VarietiesMageListVo> page = varietiesMagePagePo.getPage();
		List<VarietiesMageListVo> list = varietiesMageMapper.findPage(varietiesMagePagePo);
		page.setList(list);
		result.setResult(page);
		return result;
	}

	/**
	 * 查询列表
	 */
	public ResultPoJo<List<VarietiesMageListVo>> findList(VarietiesMageListPo varietiesMageListPo) {
		ResultPoJo<List<VarietiesMageListVo>> result = new ResultPoJo<>();
		result.setResult(varietiesMageMapper.findList(varietiesMageListPo));
		return result;
	}

	/**
	 * 查询
	 */
	public ResultPoJo<VarietiesMageGetVo> get(VarietiesMageGetPo varietiesMageGetPo) {
		ResultPoJo<VarietiesMageGetVo> result = new ResultPoJo<>();
		VarietiesMage entity = varietiesMageMapper.selectByPrimaryKey(varietiesMageGetPo.getId());
		VarietiesMageGetVo vo = new VarietiesMageGetVo();
		ConverterUtil.copyProperties(entity, vo);
		result.setResult(vo);
		return result;
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> insert(VarietiesMageInsertPo varietiesMageInsertPo) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		VarietiesMage varietiesMage = new VarietiesMage();
		ConverterUtil.copyProperties(varietiesMageInsertPo, varietiesMage);
		//校验编号
		if (ConverterUtil.isNotEmpty(varietiesMageMapper.check(varietiesMageInsertPo))) {
			result.setCode(ConstantCodeMsg.MSG_512);
			result.setMsg(ConstantCodeMsg.MSG_512);
			return result;
		}
		//校验名称
		if (ConverterUtil.isNotEmpty(varietiesMageMapper.cheakRepetition(varietiesMage))) {
	   	     result.setCode(ConstantCodeMsg.MSG_511);
	         result.setMsg(ConstantCodeMsg.MSG_511);
	         return result;
		}
		varietiesMage.preInsert();
		varietiesMageMapper.insertSelective(varietiesMage);
		return result;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> update(VarietiesMageUpdatePo varietiesMageUpdatePo) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		VarietiesMage varietiesMage = new VarietiesMage();
		ConverterUtil.copyProperties(varietiesMageUpdatePo, varietiesMage);
		varietiesMage.preUpdate();
		//校验名称
		if (ConverterUtil.isNotEmpty(varietiesMageMapper.cheakRepetition(varietiesMage))) {
	   	     result.setCode(ConstantCodeMsg.MSG_511);
	         result.setMsg(ConstantCodeMsg.MSG_511);
	         return result;
		}
		varietiesMageMapper.updateByPrimaryKeySelective(varietiesMage);
		return result;
	}

	/**
	 * 批量删除
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> batDelete(VarietiesMageBatDeletePo varietiesMageBatDeletePo) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		for (Long delId : varietiesMageBatDeletePo.getDelList()) {
			VarietiesMage varietiesMage = new VarietiesMage();
			varietiesMage.setId(delId);
			varietiesMage.preUpdate();
			varietiesMageMapper.deleteLogic(varietiesMage);
		}
		return result;
	}

	/**
	 * 导出物料管理
	 *
	 * @param po
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ResultPoJo<Object> export(VarietiesMageListPo po, HttpServletResponse response) throws IOException {
		ResultPoJo<Object> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

		List<VarietiesMageListVo> list = varietiesMageMapper.findList(po);
		// for (VarietiesMageListVo vo : list) {
		// CategoryMage categoryMage =
		// categoryMageMapper.selectByPrimaryKey(vo.getCategoryId());
		// vo.setCategoryName(categoryMage.getCategoryName());
		// }
		String fileName = "物料管理信息.xlsx";
		ExportExcel exportExcel = new ExportExcel("物料管理信息", VarietiesMageListVo.class);
		exportExcel.setDataList(list).writeWithAjaxHeader(response, fileName).dispose();
		return pojo;
	}

	/**
	 * 校验物料编码是否存在
	 *
	 * @param varietiesMageInsertPo
	 * @return
	 */
	public ResultPoJo<VarietiesMage> check(VarietiesMageInsertPo varietiesMageInsertPo) {
		ResultPoJo<VarietiesMage> result = new ResultPoJo<>();
		VarietiesMage entity = varietiesMageMapper.check(varietiesMageInsertPo);
		result.setResult(entity);
		return result;
	}
}
