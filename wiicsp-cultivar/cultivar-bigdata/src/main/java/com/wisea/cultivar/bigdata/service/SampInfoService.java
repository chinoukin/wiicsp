package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.vo.bigdata.CityAndQuantity;
import com.wisea.cultivar.common.vo.bigdata.SampInfoCountVo;
import com.wisea.cultivar.common.vo.bigdata.SampInfoDataVo;
import com.wisea.cultivar.common.vo.bigdata.SampInformationVo;
import com.wisea.cultivar.common.dao.bigdata.GoodsRecallMapper;
import com.wisea.cultivar.common.dao.tp.SampInfoMapper;
import com.wisea.cultivar.common.dao.tp.SampPictureMapper;
import com.wisea.cultivar.common.po.bigdata.SampInfoPo;
import com.wisea.cultivar.common.vo.tp.SampPictureGetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className GoodsRecallService
 * @date 2020/09/03 10:07:58
 * @Description
 */
@Service
public class SampInfoService extends BaseService {
    @Autowired
    private SampInfoMapper mapper;
	@Autowired
	private SampPictureMapper sampPictureMapper;
    @Autowired
	GoodsRecallMapper goodsRecallMapper;
    /**
     * @author wbf-code-generator
     * @date 2020/09/03 10:07:58
     * @Description 查询详细信息GoodsRecall
     */
    public ResultPoJo<SampInfoDataVo> findInfo(SampInfoPo po) {

     	ResultPoJo<SampInfoDataVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SampInfoDataVo sampInfoDataVo = new SampInfoDataVo();
		//获取抽检数和比例
		SampInfoCountVo sampInfoCountVo=mapper.getCountAndRate(po);
		//获取抽样监测信息
		List<SampInformationVo> sampInformationVo = mapper.getSampInformationVo(po);
		if(ConverterUtil.isNotEmpty(sampInformationVo)){
			sampInformationVo.stream().forEach(s->{
				List<SampPictureGetVo> urls = sampPictureMapper.findUrlBySampId(s.getId());
				s.setPictures(urls);
			});
		}

		//湖南省各个市区样品数
		po.setParentId(goodsRecallMapper.getParentId());
		List<CityAndQuantity> cityAndQuantity = mapper.getCityAndQuantity(po);
		if(ConverterUtil.isNotEmpty(sampInfoCountVo)){
			sampInfoDataVo.setTotalStatistics(sampInfoCountVo.getTotalStatistics());
			sampInfoDataVo.setQualifiedQuantity(sampInfoCountVo.getQualifiedQuantity());
			sampInfoDataVo.setUnqualifiedQuantity(sampInfoCountVo.getUnqualifiedQuantity());
			sampInfoDataVo.setPassRate(sampInfoCountVo.getPassRate());
			sampInfoDataVo.setUnqualifiedRate(sampInfoCountVo.getUnqualifiedRate());
		}
		sampInfoDataVo.setSampInformationVo(sampInformationVo);
		sampInfoDataVo.setCityAndQuantity(cityAndQuantity);
		resultPoJo.setResult(sampInfoDataVo);
		return resultPoJo;
    }

	public ResultPoJo<SampInfoDataVo> findQDInfo(SampInfoPo po) {

		ResultPoJo<SampInfoDataVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SampInfoDataVo sampInfoDataVo = new SampInfoDataVo();
		//获取抽检数和比例
		SampInfoCountVo sampInfoCountVo=mapper.getQDCountAndRate(po);
		//获取抽样监测信息
		List<SampInformationVo> sampInformationVo = mapper.getQDSampInformationVo(po);
		if(ConverterUtil.isNotEmpty(sampInformationVo)){
			sampInformationVo.stream().forEach(s->{
				List<SampPictureGetVo> urls = sampPictureMapper.findUrlBySampId(s.getId());
				s.setPictures(urls);
			});
		}
		List<CityAndQuantity> cityAndQuantity = mapper.getQDCityAndQuantity(po);
		if(ConverterUtil.isNotEmpty(sampInfoCountVo)){
			sampInfoDataVo.setTotalStatistics(sampInfoCountVo.getTotalStatistics());
			sampInfoDataVo.setQualifiedQuantity(sampInfoCountVo.getQualifiedQuantity());
			sampInfoDataVo.setUnqualifiedQuantity(sampInfoCountVo.getUnqualifiedQuantity());
			sampInfoDataVo.setPassRate(sampInfoCountVo.getPassRate());
			sampInfoDataVo.setUnqualifiedRate(sampInfoCountVo.getUnqualifiedRate());
		}
		sampInfoDataVo.setSampInformationVo(sampInformationVo);
		sampInfoDataVo.setCityAndQuantity(cityAndQuantity);
		resultPoJo.setResult(sampInfoDataVo);
		return resultPoJo;
	}
}
