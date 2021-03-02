package com.wisea.cultivar.origin.service.bigdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.tp.SampInfoMapper;
import com.wisea.cultivar.common.po.bigdata.SampJcCountPagePo;
import com.wisea.cultivar.common.po.bigdata.SampJcCountPo;
import com.wisea.cultivar.common.vo.bigdata.BigDataSampCountVo;
import com.wisea.cultivar.common.vo.bigdata.SampBaseInfoForBigDataVo;
import com.wisea.cultivar.common.vo.bigdata.SampJcCountVo;

/**
 * 大数据查询的处理
 *
 * @author wangh(wisea)
 *
 * @date 2019年11月7日
 * @version 1.0
 */
@Service
public class NotAuthIndexService extends BaseService{

	@Autowired
	private SampInfoMapper sampInfoMapper;
	/**
	 * 统计样品信息的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年11月7日
	 * @version 1.0
	 */
	public ResultPoJo<BigDataSampCountVo> sampJcCount(SampJcCountPo po){
		// 返回值初期化处理
		ResultPoJo<BigDataSampCountVo> result = new ResultPoJo<BigDataSampCountVo>(ConstantCodeMsg.NOMAL);
		BigDataSampCountVo vo = new BigDataSampCountVo();
		// 查询样品信息列表
		List<SampJcCountVo> list = sampInfoMapper.sampJcCount(po);
		for(SampJcCountVo entity : list){
			vo.setGross(entity.getGross() + vo.getGross());
			vo.setPassCount(entity.getPassCount() + vo.getPassCount());
		}
		vo.setFailedCount(vo.getGross() - vo.getPassCount());// 计算不合格数量
		Double passPercent = 0d;
		if(vo.getGross() != 0){
			passPercent = ConverterUtil.div(vo.getPassCount(),vo.getGross(), 2);
			vo.setFailedPercent(ConverterUtil.sub(1, passPercent));// 计算不合格率
		}else{
			vo.setFailedPercent(0d);
		}
		vo.setPassPercent(passPercent);// 计算合格率
		vo.setSampJcCountList(list);
		result.setResult(vo);
		return result;
	}
	/**
	 * 大数据分页查询样品基本信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年11月7日
	 * @version 1.0
	 */
	public ResultPoJo<Page<SampBaseInfoForBigDataVo>> findSampPage(SampJcCountPagePo po){
		// 返回值初期化处理
		ResultPoJo<Page<SampBaseInfoForBigDataVo>> result = new ResultPoJo<Page<SampBaseInfoForBigDataVo>>(ConstantCodeMsg.NOMAL);
		// 分页处理
		Page<SampBaseInfoForBigDataVo> page = po.getPage();
		page.setList(sampInfoMapper.findSampPage(po));
		result.setResult(page);
		return result;
	}
}
