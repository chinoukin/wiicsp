package com.wisea.cultivar.bigdata.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.bigdata.JyOrdMageMapper;
import com.wisea.cultivar.common.dao.bigdata.SubEntpMageMapper;
import com.wisea.cultivar.common.dao.bigdata.SubEntpPictureMapper;
import com.wisea.cultivar.common.entity.bigdata.SubEntpMage;
import com.wisea.cultivar.common.entity.bigdata.SubEntpPicture;
import com.wisea.cultivar.common.po.bigdata.BuyerSalesRankPo;
import com.wisea.cultivar.common.po.bigdata.QueryTotalPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMageGetPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMageListPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMagePagePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMageUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.AreaReportVo;
import com.wisea.cultivar.common.vo.bigdata.BuyerSalesRankVo;
import com.wisea.cultivar.common.vo.bigdata.GetJxRankVo;
import com.wisea.cultivar.common.vo.bigdata.QueryTotalVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpMageListVo;
import com.wisea.cultivar.common.vo.bigdata.XlRankVo;
import com.wisea.cultivar.common.vo.bigdata.XsAnalysisVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * SubEntpMageService 分公司名录管理 Service 2019/12/02 11:02:15
 */
@Service
public class SubEntpMageService extends BaseService {
	@Autowired
	protected SubEntpMageMapper subEntpMageMapper;
	@Autowired
	protected SubEntpPictureMapper subEntpPictureMapper;
	@Autowired
	protected JyOrdMageMapper jyOrdMageMapper;

	/**
	 * 查询分页列表
	 */
	public ResultPoJo<Page<SubEntpMageListVo>> findPage(SubEntpMagePagePo subEntpMagePagePo) {
		ResultPoJo<Page<SubEntpMageListVo>> result = new ResultPoJo<>();
		Page<SubEntpMageListVo> page = subEntpMagePagePo.getPage();
		List<SubEntpMageListVo> list = subEntpMageMapper.findPage(subEntpMagePagePo);
		page.setList(list);
		result.setResult(page);
		return result;
	}

	/**
	 * 查询列表
	 */
	public ResultPoJo<List<SubEntpMageListVo>> findList(SubEntpMageListPo subEntpMageListPo) {
		ResultPoJo<List<SubEntpMageListVo>> result = new ResultPoJo<>();
		result.setResult(subEntpMageMapper.findList(subEntpMageListPo));
		return result;
	}

	/**
	 * 查询
	 */
	public ResultPoJo<SubEntpMageGetVo> get(SubEntpMageGetPo subEntpMageGetPo) {
		ResultPoJo<SubEntpMageGetVo> result = new ResultPoJo<>();
		SubEntpMage entity = subEntpMageMapper.selectByPrimaryKey(subEntpMageGetPo.getId());

		// 查询图片
		SubEntpPicture subEntpPicture = new SubEntpPicture();
		subEntpPicture.setSubEntpId(subEntpMageGetPo.getId());
		List<SubEntpPicture> list = subEntpPictureMapper.findList(subEntpPicture);
		SubEntpMageGetVo vo = new SubEntpMageGetVo();
		ConverterUtil.copyProperties(entity, vo);
//		vo.setSubEntpPicture(list);
		result.setResult(vo);
		return result;
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> insert(SubEntpMageInsertPo po) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		SubEntpMage subEntpMage = new SubEntpMage();
		ConverterUtil.copyProperties(po, subEntpMage);
		subEntpMage.preInsert();
		subEntpMageMapper.insertSelective(subEntpMage);

		// 介绍图片
//		if (ConverterUtil.isNotEmpty(po.getSubEntpPicture())) {
//			for (SubEntpPicture va : po.getSubEntpPicture()) {
//				SubEntpPicture subEntpPicture = new SubEntpPicture();
//				ConverterUtil.copyProperties(va,subEntpPicture);
//				subEntpPicture.preInsert();
//				subEntpPicture.setSubEntpId(subEntpMage.getId());
//				subEntpPictureMapper.insertSelective(subEntpPicture);
//			}
//
//		}

		return result;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> update(SubEntpMageUpdatePo po) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		SubEntpMage subEntpMage = new SubEntpMage();
		ConverterUtil.copyProperties(po, subEntpMage);
		subEntpMage.preUpdate();
		subEntpMageMapper.updateByPrimaryKeySelective(subEntpMage);

		subEntpPictureMapper.deleteBySubEntpId(po.getId());
		// 介绍图片
//		if (ConverterUtil.isNotEmpty(po.getSubEntpPicture())) {
//			for (SubEntpPicture va : po.getSubEntpPicture()) {
//				SubEntpPicture subEntpPicture = new SubEntpPicture();
//				ConverterUtil.copyProperties(va,subEntpPicture);
//				subEntpPicture.preInsert();
//				subEntpPicture.setSubEntpId(subEntpMage.getId());
//				subEntpPictureMapper.insertSelective(subEntpPicture);
//			}
//		}
		return result;
	}

	/**
	 * 新增修改
	 * @param subEntpMageUpdatePo
	 * @return
	 */
	public ResultPoJo<Object> saveOrupdate(SubEntpMageUpdatePo po) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		SubEntpMage subEntpMage = new SubEntpMage();
		ConverterUtil.copyProperties(po, subEntpMage);
		if(ConverterUtil.isNotEmpty(po.getId())) {
			subEntpMage.preUpdate();
			subEntpMageMapper.updateByPrimaryKeySelective(subEntpMage);

			subEntpPictureMapper.deleteBySubEntpId(po.getId());
			// 介绍图片
//			if (ConverterUtil.isNotEmpty(po.getSubEntpPicture())) {
//				for (SubEntpPicture va : po.getSubEntpPicture()) {
//					SubEntpPicture subEntpPicture = new SubEntpPicture();
//					ConverterUtil.copyProperties(va,subEntpPicture);
//					subEntpPicture.preInsert();
//					subEntpPicture.setSubEntpId(subEntpMage.getId());
//					subEntpPictureMapper.insertSelective(subEntpPicture);
//				}
//			}
		}else {
			subEntpMage.preInsert();
			subEntpMageMapper.insertSelective(subEntpMage);
			// 介绍图片
//			if (ConverterUtil.isNotEmpty(po.getSubEntpPicture())) {
//				for (SubEntpPicture va : po.getSubEntpPicture()) {
//					SubEntpPicture subEntpPicture = new SubEntpPicture();
//					ConverterUtil.copyProperties(va,subEntpPicture);
//					subEntpPicture.preInsert();
//					subEntpPicture.setSubEntpId(subEntpMage.getId());
//					subEntpPictureMapper.insertSelective(subEntpPicture);
//				}
//
//			}

		}
		return result;
	}

	/**
	 * 批量删除
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> batDelete(SubEntpMageBatDeletePo subEntpMageBatDeletePo) {
		ResultPoJo<Object> result = new ResultPoJo<>();
		for (Long delId : subEntpMageBatDeletePo.getDelList()) {
			SubEntpMage subEntpMage = new SubEntpMage();
			subEntpMage.setId(delId);
			subEntpMage.preUpdate();
			subEntpMageMapper.deleteLogic(subEntpMage);
		}
		return result;
	}

	/**
	 * 导出分公司名录管理
	 *
	 * @param po
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ResultPoJo<Object> export(SubEntpMageListPo po, HttpServletResponse response) throws IOException {
		ResultPoJo<Object> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

		List<SubEntpMageListVo> list = subEntpMageMapper.findList(po);

		// 拼接经纬度
		for (SubEntpMageListVo subEntpMageListVo : list) {
			subEntpMageListVo.setCoordinate(subEntpMageListVo.getJd() + "," + subEntpMageListVo.getWd());
		}

		// 拼接经纬度
		for (SubEntpMageListVo subEntpMageListVo : list) {
			subEntpMageListVo.setCoordinate(subEntpMageListVo.getJd() + "," + subEntpMageListVo.getWd());
		}
		String fileName = "分公司名录管理数据.xlsx";
		ExportExcel exportExcel = new ExportExcel("分公司名录管理数据", SubEntpMageListVo.class);
		exportExcel.setDataList(list).writeWithAjaxHeader(response, fileName).dispose();
		return pojo;
	}

	/**
	 * 查询基础配置
	 *
	 * @param queryTotalPo
	 * @return
	 */
	public ResultPoJo<QueryTotalVo> getTotal(QueryTotalPo po) {
		ResultPoJo<QueryTotalVo> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

		QueryTotalVo vo = subEntpMageMapper.getTotal(po);

		pojo.setResult(vo);
		return pojo;
	}

	/**
	 * 采购商销售排行
	 *
	 * @param buyerSalesRankPo
	 * @return
	 */
	public ResultPoJo<List<BuyerSalesRankVo>> getXsRank(BuyerSalesRankPo buyerSalesRankPo) {
		ResultPoJo<List<BuyerSalesRankVo>> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		List<BuyerSalesRankVo> vo = subEntpMageMapper.getXsRank(buyerSalesRankPo);
		pojo.setResult(vo);
		return pojo;
	}

	/**
	 * 同比环比分析
	 *
	 * @param buyerSalesRankPo
	 * @return
	 */
	public ResultPoJo<List<XsAnalysisVo>> getXsAnalysis(BuyerSalesRankPo buyerSalesRankPo) {
		ResultPoJo<List<XsAnalysisVo>> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		List<XsAnalysisVo> vo = Lists.newArrayList();
		// （0:年、1:月）
		if (buyerSalesRankPo.getFlag().equals("0")) {
			vo = subEntpMageMapper.getXsAnalysisYear(buyerSalesRankPo);
		}
		if (buyerSalesRankPo.getFlag().equals("1")) {
			vo = subEntpMageMapper.getXsAnalysisMonth(buyerSalesRankPo);
		}
		pojo.setResult(vo);
		return pojo;
	}

	/**
	 * 单品交易排行
	 *
	 * @param buyerSalesRankPo
	 * @return
	 */
	public ResultPoJo<List<GetJxRankVo>> getJxRank(BuyerSalesRankPo buyerSalesRankPo) {
		ResultPoJo<List<GetJxRankVo>> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		List<GetJxRankVo> vo = subEntpMageMapper.getJxRank(buyerSalesRankPo);
		pojo.setResult(vo);
		return pojo;
	}

	/**
	 * 地图报表展示
	 *
	 * @param buyerSalesRankPo
	 * @return
	 */
	public ResultPoJo<List<AreaReportVo>> getAreaReport(BuyerSalesRankPo buyerSalesRankPo) {
		ResultPoJo<List<AreaReportVo>> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		List<AreaReportVo> vo = Lists.newArrayList();
		// （0:年、1:月）
		if(ConverterUtil.isEmpty(buyerSalesRankPo.getFlag())) {
			vo = subEntpMageMapper.getAreaReportYear(buyerSalesRankPo);
		}else {
			if (buyerSalesRankPo.getFlag().equals("0")) {
				vo = subEntpMageMapper.getAreaReportYear(buyerSalesRankPo);
			}
			if (buyerSalesRankPo.getFlag().equals("1")) {
				buyerSalesRankPo.setMonth(buyerSalesRankPo.getVal().getMonthValue()+"");
				vo = subEntpMageMapper.getAreaReportMonth(buyerSalesRankPo);
			}
		}

		pojo.setResult(vo);
		return pojo;
	}

	/**
	 * 分公司销量排行榜
	 *
	 * @param buyerSalesRankPo
	 * @return
	 */
	public ResultPoJo<List<XlRankVo>> getXlRank(BuyerSalesRankPo buyerSalesRankPo) {
		ResultPoJo<List<XlRankVo>> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		List<XlRankVo> vo = Lists.newArrayList();
		// （0:年、1:月）
		if (buyerSalesRankPo.getFlag().equals("0")) {
			vo = subEntpMageMapper.getXlRankYear(buyerSalesRankPo);
		}
		if (buyerSalesRankPo.getFlag().equals("1")) {
			buyerSalesRankPo.setMonth(buyerSalesRankPo.getVal().getMonthValue()+"");
			vo = subEntpMageMapper.getXlRankMonth(buyerSalesRankPo);
		}
		pojo.setResult(vo);
		return pojo;
	}




}
