package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.dao.OrdCancelReasonMageMapper;
import com.wisea.cultivar.common.entity.OrdCancelReasonMage;
import com.wisea.cultivar.common.po.DelAllPo;
import com.wisea.cultivar.common.po.OrdCancelReasonMagePageListPo;
import com.wisea.cultivar.common.po.OrdCancelReasonMagePo;
import com.wisea.cultivar.common.vo.OrdCancelReasonMageInfoVo;
import com.wisea.cultivar.common.vo.OrdCancelReasonMagePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className OrdCancelReasonMageService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class OrdCancelReasonMageService extends BaseService {
    @Autowired
    private OrdCancelReasonMageMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询OrdCancelReasonMage
     */
    public ResultPoJo<Page<OrdCancelReasonMagePageListVo>> findPageList(OrdCancelReasonMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<OrdCancelReasonMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<OrdCancelReasonMagePageListVo> page = po.getPage();
		List<OrdCancelReasonMagePageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除OrdCancelReasonMage
     */
	@Transactional(rollbackFor = Exception.class)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		OrdCancelReasonMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(OrdCancelReasonMage.DEL_FLAG_DELETE);
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
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改OrdCancelReasonMage
     */
	@Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(OrdCancelReasonMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			OrdCancelReasonMage entity = mapper.selectByPrimaryKey(po.getId());
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
			OrdCancelReasonMage entity = new OrdCancelReasonMage();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息OrdCancelReasonMage
     */
    public ResultPoJo<OrdCancelReasonMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<OrdCancelReasonMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		OrdCancelReasonMageInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
	@Transactional(rollbackFor = Exception.class)
    public ResultPoJo delAll(DelAllPo po) {
		try{
			for (int i = 0; i < po.getIds().size(); i++) {
				LongIdPo longIdPo = new LongIdPo();
				longIdPo.setId(po.getIds().get(i));
				logicDel(longIdPo);
			}
		}catch (Exception e){
			ResultPoJo resultPoJo = new ResultPoJo();
			resultPoJo.setCode("500");
			return resultPoJo;
		}
    	return new ResultPoJo();
    }
}
