package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.ZhfwLevelSpecQuote;
import com.wisea.cultivar.plant.mapper.ZhfwLevelSpecQuoteMapper;
import com.wisea.cultivar.plant.po.ZhfwLevelSpecQuotePageListPo;
import com.wisea.cultivar.plant.po.ZhfwLevelSpecQuotePo;
import com.wisea.cultivar.plant.vo.ZhfwLevelSpecQuoteInfoVo;
import com.wisea.cultivar.plant.vo.ZhfwLevelSpecQuotePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ZhfwLevelSpecQuoteService
 * @date 2020/08/07 17:27:46
 * @Description
 */
@Service
public class ZhfwLevelSpecQuoteService extends BaseService {
    @Autowired
    private ZhfwLevelSpecQuoteMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/08/07 17:27:46
     * @Description 分页查询ZhfwLevelSpecQuote
     */
    public ResultPoJo<Page<ZhfwLevelSpecQuotePageListVo>> findPageList(ZhfwLevelSpecQuotePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<ZhfwLevelSpecQuotePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<ZhfwLevelSpecQuotePageListVo> page = po.getPage();
		List<ZhfwLevelSpecQuotePageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/07 17:27:46
     * @Description 逻辑删除ZhfwLevelSpecQuote
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ZhfwLevelSpecQuote entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(ZhfwLevelSpecQuote.DEL_FLAG_DELETE);
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
     * @date 2020/08/07 17:27:46
     * @Description 新增或修改ZhfwLevelSpecQuote
     */
    public ResultPoJo saveOrUpdate(ZhfwLevelSpecQuotePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			ZhfwLevelSpecQuote entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增
			ZhfwLevelSpecQuote entity = new ZhfwLevelSpecQuote();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/07 17:27:46
     * @Description 查询详细信息ZhfwLevelSpecQuote
     */
    public ResultPoJo<ZhfwLevelSpecQuoteInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<ZhfwLevelSpecQuoteInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ZhfwLevelSpecQuoteInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
}
