package com.wisea.transac.tp.system.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.dao.EntpCommSerMapper;
import com.wisea.transac.common.entity.EntpCommSer;
import com.wisea.transac.common.po.system.EntpCommSerPageListPo;
import com.wisea.transac.common.po.system.EntpCommSerPo;
import com.wisea.transac.common.vo.system.EntpCommSerInfoVo;
import com.wisea.transac.common.vo.system.EntpCommSerPageListVo;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className EntpCommSerService
 * @date 2020/12/11 14:20:00
 * @Description
 */
@Service
public class EntpCommSerService extends BaseService {
    @Autowired
    private EntpCommSerMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/12/11 14:20:00
     * @Description 分页查询EntpCommSer
     */
    public ResultPoJo<Page<EntpCommSerPageListVo>> findPageList(EntpCommSerPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<EntpCommSerPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<EntpCommSerPageListVo> page = po.getPage();
		List<EntpCommSerPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/12/11 14:20:00
     * @Description 逻辑删除EntpCommSer
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		EntpCommSer entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(EntpCommSer.DEL_FLAG_DELETE);
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
     * @date 2020/12/11 14:20:00
     * @Description 新增或修改EntpCommSer
     */
    public ResultPoJo saveOrUpdate(EntpCommSerPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			EntpCommSer entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				if(po.getId() <= 10){
					//小于10的ID为固定数据，只能修改排序和启用停用状态（202-12-11 程佳硕定）
					entity.setSerType(null);
					entity.setSerAbbrev(null);
					entity.setSerIntr(null);
				}
				mapper.updateByPrimaryKeySelective(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增
			EntpCommSer entity = new EntpCommSer();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/12/11 14:20:00
     * @Description 查询详细信息EntpCommSer
     */
    public ResultPoJo<EntpCommSerInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<EntpCommSerInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		EntpCommSerInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
}
