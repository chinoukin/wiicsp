package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cultivar.common.dao.bigdata.GoodsRecallMapper;
import com.wisea.cultivar.common.vo.bigdata.CityAndQuantity;
import com.wisea.cultivar.common.vo.bigdata.GoodsRecallInfoVo;
import com.wisea.cultivar.common.vo.bigdata.GoodsRecallVo;
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
public class GoodsRecallService extends BaseService {
    @Autowired
    private GoodsRecallMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/09/03 10:07:58
     * @Description 查询详细信息GoodsRecall
     */
    public ResultPoJo<GoodsRecallVo> findInfo() {

		ResultPoJo<GoodsRecallVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		GoodsRecallVo goodsRecallVo = new GoodsRecallVo();
		//召回总数量
		long totalStatistics=mapper.totalStatistics();
		//根据市名 分组查询 召回数量
		List<CityAndQuantity> cityAndQuantityList=mapper.groupStatistics(mapper.getParentId());
		//根据批次号分组召回信息
		List<GoodsRecallInfoVo> goodsRecallInfoVo = mapper.findInfo();
		goodsRecallVo.setCityAndQuantityList(cityAndQuantityList);
		goodsRecallVo.setGoodsRecallInfoVo(goodsRecallInfoVo);
		goodsRecallVo.setTotalRecall(totalStatistics);
			resultPoJo.setResult(goodsRecallVo);
		return resultPoJo;
    }

	/**
	 * 查询册亨县平级的县相关信息
	 * @return
	 */
	public ResultPoJo<GoodsRecallVo> findCeHengInfo() {

		ResultPoJo<GoodsRecallVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		GoodsRecallVo goodsRecallVo = new GoodsRecallVo();
		//召回总数量
		long totalStatistics=mapper.ceHengtotalStatistics();
		//根据市名 分组查询 召回数量
		List<CityAndQuantity> cityAndQuantityList=mapper.groupCeHengStatistics(mapper.getCeHengParentId());
		//根据批次号分组召回信息
		List<GoodsRecallInfoVo> goodsRecallInfoVo = mapper.findCeHengInfo();
		goodsRecallVo.setCityAndQuantityList(cityAndQuantityList);
		goodsRecallVo.setGoodsRecallInfoVo(goodsRecallInfoVo);
		goodsRecallVo.setTotalRecall(totalStatistics);
		resultPoJo.setResult(goodsRecallVo);
		return resultPoJo;
	}
}
