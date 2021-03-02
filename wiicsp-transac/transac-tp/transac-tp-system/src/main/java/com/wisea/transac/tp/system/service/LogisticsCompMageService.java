package com.wisea.transac.tp.system.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.dao.LogisticsCompMageMapper;
import com.wisea.transac.common.entity.LogisticsCompMage;
import com.wisea.transac.common.po.LogisticsCompMagePageListPo;
import com.wisea.transac.common.po.LogisticsCompMagePo;
import com.wisea.transac.common.vo.LogisticsCompMageInfoVo;
import com.wisea.transac.common.vo.LogisticsCompMagePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className LogisticsCompMageService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class LogisticsCompMageService extends BaseService {
    @Autowired
    private LogisticsCompMageMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询LogisticsCompMage
     */
    public ResultPoJo<Page<LogisticsCompMagePageListVo>> findPageList(LogisticsCompMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<LogisticsCompMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<LogisticsCompMagePageListVo> page = po.getPage();
		List<LogisticsCompMagePageListVo> list = mapper.findList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

	/**
	 * @author wbf-code-generator
	 * @date 2020/04/27 17:01:29
	 * @Description 查询物流公司列表
	 */
	public ResultPoJo<List<LogisticsCompMagePageListVo>> findList(LogisticsCompMagePageListPo po) {
		LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<List<LogisticsCompMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		List<LogisticsCompMagePageListVo> list = mapper.findList(po);
		resultPoJo.setResult(list);
		return resultPoJo;
	}


    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除LogisticsCompMage
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		LogisticsCompMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(LogisticsCompMage.DEL_FLAG_DELETE);
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
     * @Description 新增或修改LogisticsCompMage
     */
    public ResultPoJo saveOrUpdate(LogisticsCompMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			LogisticsCompMage entity = mapper.selectByPrimaryKey(po.getId());
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
			LogisticsCompMage entity = new LogisticsCompMage();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息LogisticsCompMage
     */
    public ResultPoJo<LogisticsCompMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<LogisticsCompMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		LogisticsCompMageInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

	public ResultPoJo<LogisticsCompMagePageListVo> findByCompName(String name) {
		ResultPoJo<LogisticsCompMagePageListVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		List<LogisticsCompMagePageListVo> list = mapper.findByName(name);
		if (list.size() > 0) {
			resultPoJo.setResult(list.get(0));
		}else {
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}
}
