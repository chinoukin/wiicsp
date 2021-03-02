package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.dao.bigdata.AnnualSalesTargetMapper;
import com.wisea.cultivar.common.entity.bigdata.AnnualSalesTarget;
import com.wisea.cultivar.common.po.bigdata.AnnualSalesTargetPageListPo;
import com.wisea.cultivar.common.po.bigdata.AnnualSalesTargetPo;
import com.wisea.cultivar.common.po.bigdata.TotalSalesPo;
import com.wisea.cultivar.common.vo.bigdata.AnnualSalesTargetInfoVo;
import com.wisea.cultivar.common.vo.bigdata.AnnualSalesTargetPageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className AnnualSalesTargetService
 * @date 2020/02/07 18:53:13
 * @Description
 */
@Service
public class AnnualSalesTargetService extends BaseService {
    @Autowired
    private AnnualSalesTargetMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/02/07 18:53:13
     * @Description 分页查询AnnualSalesTarget
     */
    public ResultPoJo<Page<AnnualSalesTargetPageListVo>> findPageList(AnnualSalesTargetPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<AnnualSalesTargetPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<AnnualSalesTargetPageListVo> page = po.getPage();
		List<AnnualSalesTargetPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/02/07 18:53:13
     * @Description 逻辑删除AnnualSalesTarget
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		AnnualSalesTarget entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(AnnualSalesTarget.DEL_FLAG_DELETE);
			entity.preUpdate();
			mapper.updateByPrimaryKey(entity);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }



    /**
     * @author wbf-code-generator
     * @date 2020/02/07 18:53:13
     * @Description 查询详细信息AnnualSalesTarget
     */
    public ResultPoJo<AnnualSalesTargetInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<AnnualSalesTargetInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		AnnualSalesTargetInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

	/**
	 * @author wbf-code-generator
	 * @date 2020/02/07 18:53:13
	 * @Description 根据年份查询年销售额目标
	 */
	public ResultPoJo<AnnualSalesTarget> findByYear(TotalSalesPo po) {
		LoggerUtil.infoWithContext("【findByYear】根据年份查询年销售额目标：", po);
		ResultPoJo<AnnualSalesTarget> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		AnnualSalesTarget vo = mapper.findByYear(po);
		resultPoJo.setResult(vo);
		return resultPoJo;
	}

	/**
	 * @author wbf-code-generator
	 * @date 2020/02/07 18:53:13
	 * @Description 新增或修改AnnualSalesTarget
	 */
	public ResultPoJo saveOrUpdate(AnnualSalesTargetPo po) {
		LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		TotalSalesPo totalSalesPo = new TotalSalesPo();
		totalSalesPo.setYear(po.getYear());
		AnnualSalesTarget vo = mapper.findByYear(totalSalesPo);
		if(ConverterUtil.isNotEmpty(vo)){
			//修改
			vo.setSalesTarget(po.getSalesTarget());
			vo.preUpdate();
			mapper.updateByPrimaryKeySelective(vo);
		}else{
			//新增
			AnnualSalesTarget entity = new AnnualSalesTarget();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
	}
}
