package com.wisea.transac.tp.system.service.memb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisea.transac.tp.system.utils.TpSystemMembUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.MerchantMembMageMapper;
import com.wisea.transac.common.po.memb.MarketMembAddTjPo;
import com.wisea.transac.common.vo.memb.EchartStaticVo;
import com.wisea.transac.common.vo.memb.MarketMembAddTjVo;

/**
 * 市场会员统计处理相关接口
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月29日
 * @version 1.0
 */
@Service
public class MarketMembStatisticsService {

	@Autowired
	private MerchantMembMageMapper merchantMembMageMapper;

	/**
	 * 会员增长情况的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月29日
	 * @version 1.0
	 */
	public ResultPoJo<MarketMembAddTjVo> marketMembAddTj(MarketMembAddTjPo po){
		// 返回值初期化处理
		ResultPoJo<MarketMembAddTjVo> result = new ResultPoJo<MarketMembAddTjVo>(ConstantCodeMsg.NOMAL);
		MarketMembAddTjVo vo = new MarketMembAddTjVo();
		if(ConverterUtil.isNotEmpty(po.getQuerDate())){
			po.setSelDate(TpSystemMembUtils.stringToYyyyMmDd(po.getQuerDate()));
		}
		po.setYear(po.getSelDate().getYear());
		po.setMonth(null);
		List<String> timeAxis = Lists.newArrayList();
		// 验证传入的参数 --按照月份统计
		if(po.getFlag().equals("0")){
			po.setMonth(po.getSelDate().getMonthValue());
			timeAxis = TpSystemMembUtils.getMonthDayList(po.getSelDate());
		}else{
			timeAxis = OffsetDateTimeUtils.getYearEndYm(po.getSelDate().getYear());
		}
		// 查询统计数据
		List<EchartStaticVo> echartDate = merchantMembMageMapper.sellerMembMageStatic(po);
		Map<String,Integer> map = new HashMap<String,Integer>();
		if(echartDate != null && echartDate.size() > 0){
			for(EchartStaticVo data : echartDate){
				map.put(ConverterUtil.convertBySize(data.getIndex(), ConverterUtil.DATA_TYPE_NUMBER,2),data.getNum());
			}
		}
		List<Integer> dataLis = Lists.newArrayList();
		for(String entity : timeAxis){
			Integer num = map.get(entity.substring(entity.length()-2));
			if(num != null){
				dataLis.add(num);
			}else{
				dataLis.add(0);
			}
		}
		vo.setTimeAxis(timeAxis);
		vo.setDataList(dataLis);
		result.setResult(vo);
		return result;
	}
	/**
	 * 市场运营中会员消费统计的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月3日
	 * @version 1.0
	 */
	public ResultPoJo<MarketMembAddTjVo> marketMembConsumeTj(MarketMembAddTjPo po){
		// 返回值初期化处理
		ResultPoJo<MarketMembAddTjVo> result = new ResultPoJo<MarketMembAddTjVo>(ConstantCodeMsg.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getQuerDate())){
			po.setSelDate(TpSystemMembUtils.stringToYyyyMmDd(po.getQuerDate()));
		}
		// 查询处理
		po.setYear(po.getSelDate().getYear());
		po.setMonth(null);
		// 验证传入的参数 --按照月份统计
		if(po.getFlag().equals("0")){
			po.setMonth(po.getSelDate().getMonthValue());
		}
		List<Double> list = merchantMembMageMapper.sellerMembConsumeTj(po);
		MarketMembAddTjVo vo = new MarketMembAddTjVo();
		List<String> timeAxis = Lists.newArrayList();
		List<Integer> dataList = Lists.newArrayList();
		if(list != null && list.size() > 0){
			Double minValue = 0d;
            Double maxValue = list.get(list.size() - 1);
            if(minValue.compareTo(maxValue) == 0 || maxValue.compareTo(50.0) < 0){
                //最大值和最小值相等，或者小于50的情况
            	maxValue = 50d;
            	timeAxis.add("0-50元");
            	dataList.add(list.size());
            }else{
            	List<Double> timeAxisList = Lists.newArrayList();
            	// 间隔
                Double interval = ConverterUtil.div(ConverterUtil.sub(maxValue, minValue), 8, 0);
                for(int i=1;i < 8;i++){
                	Double value = ConverterUtil.mul(interval, i);
                	timeAxisList.add(value);
                	if(i == 1){
                		timeAxis.add("0-"+ ConverterUtil.toInteger(value) + "元");
                	}else{
                		timeAxis.add(ConverterUtil.toInteger(ConverterUtil.mul(interval, i-1)+1) + "-"+ ConverterUtil.toInteger(value) + "元");
                	}
                	dataList.add(0);
                }
                timeAxis.add(ConverterUtil.toInteger(ConverterUtil.mul(interval, 7)+1)+"元以上");
                dataList.add(0);
                for(Double value : list){
                	if(value.compareTo(timeAxisList.get(0)) <= 0){
                		dataList.set(0, dataList.get(0)+1);
                	}else if(value.compareTo(timeAxisList.get(0)) > 0 && value.compareTo(timeAxisList.get(1)) <= 0){
                		dataList.set(1, dataList.get(1)+1);
                	}else if(value.compareTo(timeAxisList.get(1)) > 0 && value.compareTo(timeAxisList.get(2)) <= 0){
                		dataList.set(2, dataList.get(2)+1);
                	}else if(value.compareTo(timeAxisList.get(2)) > 0 && value.compareTo(timeAxisList.get(3)) <= 0){
                		dataList.set(3, dataList.get(3)+1);
                	}else if(value.compareTo(timeAxisList.get(3)) > 0 && value.compareTo(timeAxisList.get(4)) <= 0){
                		dataList.set(4, dataList.get(4)+1);
                	}else if(value.compareTo(timeAxisList.get(4)) > 0 && value.compareTo(timeAxisList.get(5)) <= 0){
                		dataList.set(5, dataList.get(5)+1);
                	}else if(value.compareTo(timeAxisList.get(5)) > 0 && value.compareTo(timeAxisList.get(6)) <= 0){
                		dataList.set(6, dataList.get(6)+1);
                	}else if(value.compareTo(timeAxisList.get(6)) > 0){
                		dataList.set(7, dataList.get(7)+1);
                	}
                }
            }
		}
		vo.setTimeAxis(timeAxis);
		vo.setDataList(dataList);
		result.setResult(vo);
		return result;
	}

}
