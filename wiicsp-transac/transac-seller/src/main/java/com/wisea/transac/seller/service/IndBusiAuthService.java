package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.IndBusiAuthMapper;
import com.wisea.transac.common.entity.IndBusiAuth;
import com.wisea.transac.common.po.IndBusiAuthPageListPo;
import com.wisea.transac.common.po.IndBusiAuthPo;
import com.wisea.transac.common.vo.IndBusiAuthInfoVo;
import com.wisea.transac.common.vo.IndBusiAuthPageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className IndBusiAuthService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class IndBusiAuthService extends BaseService {
    @Autowired
    private IndBusiAuthMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询IndBusiAuth
     */
    public ResultPoJo<Page<IndBusiAuthPageListVo>> findPageList(IndBusiAuthPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<IndBusiAuthPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<IndBusiAuthPageListVo> page = po.getPage();
		List<IndBusiAuthPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除IndBusiAuth
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		IndBusiAuth entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(IndBusiAuth.DEL_FLAG_DELETE);
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
     * @Description 新增或修改IndBusiAuth
     */
    public ResultPoJo saveOrUpdate(IndBusiAuthPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		IndBusiAuth entity = new IndBusiAuth();
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			IndBusiAuth entity1 = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity1)){
				//删除之前记录
				LongIdPo longIdPo = new LongIdPo();
				longIdPo.setId(po.getId());
				logicDel(longIdPo);

				//新增
				BeanUtils.copyProperties(po, entity);
				entity.preInsert();
				entity.setMembId(SystemUtils.getUser().getId());
				entity.setAuthDate(OffsetDateTime.now());
				entity.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_2);
				mapper.insert(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			entity.setMembId(SystemUtils.getUser().getId());
			entity.setAuthDate(OffsetDateTime.now());
			entity.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_2);
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息IndBusiAuth
     */
    public ResultPoJo<IndBusiAuthInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<IndBusiAuthInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		IndBusiAuthInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
}
