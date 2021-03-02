package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.EntpAuthMapper;
import com.wisea.transac.common.entity.EntpAuth;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.po.EntpAuthPageListPo;
import com.wisea.transac.common.po.EntpAuthPo;
import com.wisea.transac.common.po.seller.QueryEntpAuthPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.EntpAuthInfoVo;
import com.wisea.transac.common.vo.EntpAuthPageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className EntpAuthService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class EntpAuthService extends BaseService {
    @Autowired
    private EntpAuthMapper entpAuthMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询EntpAuth
     */
    public ResultPoJo<Page<EntpAuthPageListVo>> findPageList(EntpAuthPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<EntpAuthPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<EntpAuthPageListVo> page = po.getPage();
		List<EntpAuthPageListVo> list = entpAuthMapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除EntpAuth
     */
	@Transactional(readOnly = false)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		EntpAuth entity = entpAuthMapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(EntpAuth.DEL_FLAG_DELETE);
			entity.preUpdate();
			entpAuthMapper.updateByPrimaryKey(entity);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改EntpAuth
     */
	@Transactional(readOnly = false)
    public ResultPoJo saveOrUpdate(EntpAuthPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		User user = SystemUtils.getUser();
		MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
		EntpAuth entity = new EntpAuth();
		if(ConverterUtil.isNotEmpty(po.getId())){

			//校验如果有其他待审核不允许在添加
			if (po.getCustType().equals(DictConstants.CUST_TYPE_0)){
				QueryEntpAuthPo queryEntpAuthPo = new QueryEntpAuthPo();
				queryEntpAuthPo.setMembId(membBaseInfo.getMembId());
				queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_1);
				//查询企业信息
				EntpAuthInfoVo entpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
				if (ConverterUtil.isNotEmpty(entpAuthInfoVo)){
					if (entpAuthInfoVo.getEntpAuthStateType().equals(DictConstants.ENTP_AUTH_STATE_TYPE_2)||DictConstants.AUTH_STATE_TYPE_0.equals(entpAuthInfoVo.getAuthStateType())){
						resultPoJo.setCode(ConstantCodeMsg.ERR_950);
						resultPoJo.setMsg(ConstantCodeMsg.ERR_950);
						return resultPoJo;
					}
				}
			}else{

				QueryEntpAuthPo queryEntpAuthPo = new QueryEntpAuthPo();
				queryEntpAuthPo.setMembId(membBaseInfo.getMembId());
				queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_0);
				//查询企业信息
				EntpAuthInfoVo entpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
				if (ConverterUtil.isNotEmpty(entpAuthInfoVo)){
					if (DictConstants.ENTP_AUTH_STATE_TYPE_2.equals(entpAuthInfoVo.getEntpAuthStateType())||DictConstants.AUTH_STATE_TYPE_0.equals(entpAuthInfoVo.getAuthStateType())){
						resultPoJo.setCode(ConstantCodeMsg.ERR_951);
						resultPoJo.setMsg(ConstantCodeMsg.ERR_951);
						return resultPoJo;
					}
				}
			}

			//修改
			EntpAuth entity1 = entpAuthMapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity1)){
				//删除之前记录
				LongIdPo longIdPo = new LongIdPo();
				longIdPo.setId(po.getId());
				logicDel(longIdPo);
				//新增
				BeanUtils.copyProperties(po, entity);
				entity.preInsert();
				entity.setMembId(membBaseInfo.getMembId());
				entity.setAuthDate(OffsetDateTime.now());
				entity.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_2);
				entpAuthMapper.insert(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//校验如果有其他待审核不允许在添加
			if (po.getCustType().equals(DictConstants.CUST_TYPE_0)){
				QueryEntpAuthPo queryEntpAuthPo = new QueryEntpAuthPo();
				queryEntpAuthPo.setMembId(membBaseInfo.getMembId());
				queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_1);
				//查询企业信息
				EntpAuthInfoVo entpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
				if (ConverterUtil.isNotEmpty(entpAuthInfoVo)){
					if (DictConstants.ENTP_AUTH_STATE_TYPE_2.equals(entpAuthInfoVo.getEntpAuthStateType())||DictConstants.AUTH_STATE_TYPE_0.equals(entpAuthInfoVo.getAuthStateType())){
						resultPoJo.setCode(ConstantCodeMsg.ERR_950);
						resultPoJo.setMsg(ConstantCodeMsg.ERR_950);
						return resultPoJo;
					}
				}
			}else{

				QueryEntpAuthPo queryEntpAuthPo = new QueryEntpAuthPo();
				queryEntpAuthPo.setMembId(membBaseInfo.getMembId());
				queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_0);
				//查询企业信息
				EntpAuthInfoVo entpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
				if (ConverterUtil.isNotEmpty(entpAuthInfoVo)){
					if (DictConstants.ENTP_AUTH_STATE_TYPE_2.equals(entpAuthInfoVo.getEntpAuthStateType())||DictConstants.AUTH_STATE_TYPE_0.equals(entpAuthInfoVo.getAuthStateType())){
						resultPoJo.setCode(ConstantCodeMsg.ERR_951);
						resultPoJo.setMsg(ConstantCodeMsg.ERR_951);
						return resultPoJo;
					}
				}
			}

			//新增
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			entity.setMembId(membBaseInfo.getMembId());
			entity.setAuthDate(OffsetDateTime.now());
			entity.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_2);
			entpAuthMapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息EntpAuth
     */
    public ResultPoJo<EntpAuthInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<EntpAuthInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

		EntpAuth auth = new EntpAuth();
		auth.setId(po.getId());
		EntpAuthInfoVo vo = entpAuthMapper.findminiInfo(auth);

		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

	/**
	 * 按会员ID查询详情
	 * @param po
	 * @return
	 */
	public ResultPoJo<EntpAuthInfoVo> findInfoByMembId(LongIdPo po) {
		ResultPoJo<EntpAuthInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		List<EntpAuthInfoVo> vo = entpAuthMapper.findInfoByMembId(po);
		if(vo.size()>0){
			if (vo.size() == 1) {
				resultPoJo.setResult(vo.get(0));
			}else {
				EntpAuthInfoVo infoVo = vo.stream().sorted(Comparator.comparingInt(x -> Integer.parseInt(x.getCustType()))).findFirst().get();
				resultPoJo.setResult(infoVo);
			}
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}

}
