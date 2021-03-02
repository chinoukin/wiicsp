package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.LoginBatUpdatePo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.EntpAuthMapper;
import com.wisea.cultivar.common.dao.MembInfoMapper;
import com.wisea.cultivar.common.entity.MembBaseInfo;
import com.wisea.cultivar.common.entity.MembInfo;
import com.wisea.cultivar.common.po.memb.FreezeMembUpdPo;
import com.wisea.cultivar.common.po.memb.MembCheckMobilePo;
import com.wisea.cultivar.common.po.memb.MembMobileUpdPo;
import com.wisea.cultivar.common.utils.MembUtils;
import com.wisea.cultivar.common.vo.memb.EntpAuthInfoInitVo;
import com.wisea.cultivar.common.vo.memb.MembEntpDetailBackVo;
import com.wisea.cultivar.common.vo.memb.MembProveBaseInfoVo;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;


/**
 * 会员后台管理相关的接口Service
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月25日
 * @version 1.0
 */
@Service
public class MembBackService extends BaseService{


	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private EntpAuthMapper entpAuthMapper;
    @Autowired
    private RemoteUserMss remoteUserMss;

	/**
	 * 冻结会员的操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	//@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<String> freezeMemb(FreezeMembUpdPo po){
        ResultPoJo<String> result  = new ResultPoJo<String>(ConstantCodeMsg.NOMAL);
        for (Long membId: po.getMembIds()) {
            User oldUser = SystemUtils.getById(membId);
            if(oldUser == null){
                result.setCode(ConstantCodeMsg.ERR_711);
                result.setMsg(ConstantCodeMsg.MSG_711);
                return result;
            }
            // 返回值初期化处理
            po.setUpdateDate(OffsetDateTime.now());
            MembInfo membInfo = new MembInfo();
            membInfo.setId(membId);
            membInfo.setAcctState(po.getAcctState());
            membInfoMapper.updateByPrimaryKeySelective(membInfo);
            LoginBatUpdatePo loginBatUpdatePo = new LoginBatUpdatePo();
            loginBatUpdatePo.setIds(String.valueOf(oldUser.getId()));
            loginBatUpdatePo.setLoginFlag(po.getAcctState());   //login_flag 0：允许登录(正常) 1：不允许登录（冻结）
            ResultPoJo<Object> loginFlagUserResult = remoteUserMss.loginBatUpdate(loginBatUpdatePo);
            if(!loginFlagUserResult.getCode().equals(ConstantError.NOMAL)){
                checkRemoteResult(loginFlagUserResult);
                result.setCode(loginFlagUserResult.getCode());
                result.setMsg(loginFlagUserResult.getMsg());
                return result;
            }
            // 清楚緩存
            MembUtils.delMembSelfUser(membId);
        }
        return result;
    }

	/**
	 * 后台会员注册手机号的修改
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	//@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<String> updMembMobile(MembMobileUpdPo po){
        // 返回参数定义
        ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
        // 验证登录用户的信息
        User loginUser = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(loginUser)){
            result.setCode(ConstantCodeMsg.ERR_912);
            result.setMsg(ConstantCodeMsg.MSG_912);
            return result;
        }
        // 验证参数是否真实存在
        MembBaseInfo exist = MembUtils.getMembInfoByUserId(po.getId());
        if(ConverterUtil.isEmpty(exist)){
            result.setCode(ConstantCodeMsg.ERR_513);
            result.setMsg(ConstantCodeMsg.MSG_513);
            return result;
        }
        // 手机号已经存在的情况
        MembCheckMobilePo membCheckMobilePo = new MembCheckMobilePo();
        membCheckMobilePo.setMobile(po.getMobile());
        membCheckMobilePo.setMembId(po.getId());
        int mobileCount = membInfoMapper.checkMobileExist(membCheckMobilePo);
        if(mobileCount > 0){
            result.setCode(ConstantCodeMsg.ERR_501);
            result.setMsg(ConstantCodeMsg.MSG_501);
            return result;
        }
        // 修改会员表中的信息
        MembInfo membInfo = new MembInfo();
        membInfo.setId(po.getId());
        membInfo.setRegistTel(po.getMobile());
        membInfo.preUpdate();
        membInfoMapper.updateByPrimaryKeySelective(membInfo);
        // 修改用户表中的手机号
        User user = new User();
        user.setId(po.getId());
        user.setMobile(po.getMobile());
        ResultPoJo<Object> userResult = remoteUserMss.mobileUpdate(user);
        if(!userResult.getCode().equals(ConstantError.NOMAL)){
            checkRemoteResult(userResult);
        }
        // 清楚緩存
        MembUtils.delMembSelfUser(po.getId());
        return result;
	}
	/**
	 * 根据会员ID查询会员详细信息(传入会员ID)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月22日
	 * @version 1.0
	 */
	public ResultPoJo<MembEntpDetailBackVo> getEntpMembDetail(LongIdPo po){
		// 返回值初期化处理
		ResultPoJo<MembEntpDetailBackVo> result = new ResultPoJo<MembEntpDetailBackVo>(ConstantCodeMsg.NOMAL);
		// 查询结果的处理
		MembEntpDetailBackVo vo = entpAuthMapper.getEntpMembDetail(po.getId());
        if(StringUtils.isEmpty(vo.getAuthType())){
            result.setResult(vo);
            return result;
        }
        //个人
        if(vo.getAuthType().equals(QdcyStandardsDict.AUTH_TYPE_1)){
            EntpAuthInfoInitVo entpAuthInfoInitVo = entpAuthMapper.findResAuth(vo.getMembId());
            vo.setEntpAuthVo(entpAuthInfoInitVo);
        }else if(vo.getAuthType().equals(QdcyStandardsDict.AUTH_TYPE_0)){
            //企业
            EntpAuthInfoInitVo entpAuthInfoInitVo = entpAuthMapper.findEntpAuth(vo.getId());
            vo.setEntpAuthVo(entpAuthInfoInitVo);
        }
        result.setResult(vo);
		return result;
	}


    /**
     * 根据企业ID查询企业详细信息(传入企业ID)
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月22日
     * @version 1.0
     */
    public ResultPoJo<MembEntpDetailBackVo> getEntpDetail(LongIdPo po){
        // 返回值初期化处理
        ResultPoJo<MembEntpDetailBackVo> result = new ResultPoJo<MembEntpDetailBackVo>(ConstantCodeMsg.NOMAL);
        // 查询结果的处理
        MembEntpDetailBackVo vo = entpAuthMapper.getEntpDetail(po.getId());
        if(StringUtils.isEmpty(vo.getAuthType())){
            result.setResult(vo);
            return result;
        }
        //个人
        if(vo.getAuthType().equals(QdcyStandardsDict.AUTH_TYPE_1)){
            EntpAuthInfoInitVo entpAuthInfoInitVo = entpAuthMapper.findResTypeAuth(vo.getMembId());
            vo.setEntpAuthVo(entpAuthInfoInitVo);
        }else if(vo.getAuthType().equals(QdcyStandardsDict.AUTH_TYPE_0)){
            //企业
            EntpAuthInfoInitVo entpAuthInfoInitVo = entpAuthMapper.findEntpTypeAuth(vo.getId());
            vo.setEntpAuthVo(entpAuthInfoInitVo);
        }
        result.setResult(vo);
        return result;
    }

	/**
	 * 冻结/修改手机号/重置密码时初期化会员基本信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月28日
	 * @version 1.0
	 */
	public ResultPoJo<MembProveBaseInfoVo> membProveInit(LongIdPo po){
		// 返回值初期化处理
		ResultPoJo<MembProveBaseInfoVo> result = new ResultPoJo<MembProveBaseInfoVo>(ConstantCodeMsg.NOMAL);
		// 验证登录用户的信息
		User loginUser = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(loginUser)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 验证参数是否真实存在
		MembProveBaseInfoVo vo = membInfoMapper.getMembProveInit(po.getId());
		if(vo == null){
			result.setCode(ConstantCodeMsg.ERR_513);
			result.setMsg(ConstantCodeMsg.MSG_513);
			return result;
		}
		result.setResult(vo);
		return result;
	}
}
