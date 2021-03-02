package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.OrderInfoMapper;
import com.wisea.cultivar.common.po.trade.SerListMageInfoPo;
import com.wisea.cultivar.common.po.trade.SerListMageListPo;
import com.wisea.cultivar.common.vo.trade.SerListMageInfoVo;
import com.wisea.cultivar.common.vo.trade.SerListMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className OrderInfoService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class OrderInfoService extends BaseService {
    @Autowired
    private OrderInfoMapper mapper;


    /**
     * @Author jirg
     * @Date 2020/4/29 14:32
     * @Description 商家/市场查询订单列表
     **/
    public ResultPoJo<Page<SerListMageListVo>> findMerchantOrderList(SerListMageListPo po) {
		LoggerUtil.infoWithContext("【findMerchantOrderList】商家/市场查询订单列表：", po);
		ResultPoJo<Page<SerListMageListVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
		po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        List<SerListMageListVo> merchantOrderList = mapper.findMerchantOrderList(po);
        Page<SerListMageListVo> page = po.getPage();
        page.setList(merchantOrderList);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @Author jirg
     * @Date 2020/4/29 14:32
     * @Description 商家/市场查询订单列表
     **/
    public List<SerListMageListVo> exportMerchantOrderList(SerListMageListPo po) {
        LoggerUtil.infoWithContext("【findMerchantOrderList】商家/市场导出订单列表：", po);
        po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        List<SerListMageListVo> merchantOrderList = mapper.findMerchantOrderList(po);
        return merchantOrderList;
    }

	/**
	 * 查询订单详细信息
	 * @param po
	 * @return
	 */
	public ResultPoJo<SerListMageInfoVo> findOrderInfo(SerListMageInfoPo po) {
		LoggerUtil.infoWithContext("【findOrderInfo】查询订单详细信息：", po);
		ResultPoJo<SerListMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        SerListMageInfoVo vo = mapper.findOrderInfo(po);
        resultPoJo.setResult(vo);
		return resultPoJo;
	}


}
