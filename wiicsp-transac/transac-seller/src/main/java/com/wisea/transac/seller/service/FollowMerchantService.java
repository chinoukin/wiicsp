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
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.EntpAuthMapper;
import com.wisea.transac.common.dao.FollowMerchantMapper;
import com.wisea.transac.common.dao.IndBusiAuthMapper;
import com.wisea.transac.common.dao.RealPersonAuthMapper;
import com.wisea.transac.common.entity.FollowMerchant;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.po.FollowMerchantPo;
import com.wisea.transac.common.po.seller.FindLocalityPageListPo;
import com.wisea.transac.common.po.seller.FollowMerchantBasePo;
import com.wisea.transac.common.po.seller.FollowMerchantminiPageListPo;
import com.wisea.transac.common.po.seller.QueryEntpAuthPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.EntpAuthInfoVo;
import com.wisea.transac.common.vo.FollowMerchantInfoVo;
import com.wisea.transac.common.vo.seller.FindLocalityPageListVo;
import com.wisea.transac.common.vo.seller.FollowMerchantminiPageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className FollowMerchantService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class FollowMerchantService extends BaseService {
    @Autowired
    private FollowMerchantMapper followMerchantMapper;

    @Autowired
    private RealPersonAuthMapper realPersonAuthMapper;

    @Autowired
    private EntpAuthMapper entpAuthMapper;

    @Autowired
    private IndBusiAuthMapper indBusiAuthMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FollowMerchant
     */
    public ResultPoJo<Page<FollowMerchantminiPageListVo>> findPageList(FollowMerchantminiPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<FollowMerchantminiPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        User user = SystemUtils.getUser();
        po.setMembId(user.getId());
        Page<FollowMerchantminiPageListVo> page = po.getPage();
        List<FollowMerchantminiPageListVo> list = followMerchantMapper.findminiPageList(po);
        for (FollowMerchantminiPageListVo vo : list) {
            MembBaseInfo info = MembUtils.getMembInfoByUserId(vo.getMembId());
            //是否商家(agent_flag 0:是1:否) 是的话取商家
            if (info.getAgentFlag().equals("0")) {
                QueryEntpAuthPo queryEntpAuthPo = new QueryEntpAuthPo();
                queryEntpAuthPo.setMembId(vo.getMembId());
                queryEntpAuthPo.setAgentFlag(info.getAgentFlag());//标示字段
                queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_0);
                //查询企业信息
                EntpAuthInfoVo entpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
                if (ConverterUtil.isNotEmpty(entpAuthInfoVo)) {
                    if (DictConstants.AUTH_STATE_TYPE_3.equals(entpAuthInfoVo.getAuthStateType())){
                        vo.setEntpAuth(entpAuthInfoVo.getAuthStateType());
                    }
                }
            } else {
                QueryEntpAuthPo queryEntpAuthPo = new QueryEntpAuthPo();
                queryEntpAuthPo.setMembId(vo.getMembId());
                queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_0);
                //查询企业信息
                EntpAuthInfoVo entpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
                if (ConverterUtil.isNotEmpty(entpAuthInfoVo)) {
                    if (DictConstants.ENTP_AUTH_STATE_TYPE_0.equals(entpAuthInfoVo.getEntpAuthStateType())){
                        vo.setEntpAuth(entpAuthInfoVo.getEntpAuthStateType());
                    }
                }
            }
        }
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 产地交易商家
     * @param po
     * @return
     */
    public ResultPoJo<Page<FindLocalityPageListVo>> findLocalityPageList(FindLocalityPageListPo po) {
        LoggerUtil.infoWithContext("【findLocalityPageList】产地交易商家：", po);
        ResultPoJo<Page<FindLocalityPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        User user = SystemUtils.getUser();
        po.setMembId(user.getId());
        Page<FindLocalityPageListVo> page = po.getPage();
        List<FindLocalityPageListVo> list = followMerchantMapper.findLocalityPageList(po);
        for (FindLocalityPageListVo vo : list) {
            MembBaseInfo info = MembUtils.getMembInfoByUserId(vo.getMembId());
            //是否商家(agent_flag 0:是1:否) 是的话取商家
            if (info.getAgentFlag().equals("0")) {
                QueryEntpAuthPo queryEntpAuthPo = new QueryEntpAuthPo();
                queryEntpAuthPo.setMembId(vo.getMembId());
                queryEntpAuthPo.setAgentFlag(info.getAgentFlag());//标示字段
                queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_0);
                //查询企业信息
                EntpAuthInfoVo entpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
                if (ConverterUtil.isNotEmpty(entpAuthInfoVo)) {
                    if (DictConstants.AUTH_STATE_TYPE_3.equals(entpAuthInfoVo.getAuthStateType())){
                        vo.setEntpAuth(entpAuthInfoVo.getAuthStateType());
                    }
                }
            } else {
                QueryEntpAuthPo queryEntpAuthPo = new QueryEntpAuthPo();
                queryEntpAuthPo.setMembId(vo.getMembId());
                queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_0);
                //查询企业信息
                EntpAuthInfoVo entpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
                if (ConverterUtil.isNotEmpty(entpAuthInfoVo)) {
                    if (DictConstants.ENTP_AUTH_STATE_TYPE_0.equals(entpAuthInfoVo.getEntpAuthStateType())){
                        vo.setEntpAuth(entpAuthInfoVo.getEntpAuthStateType());
                    }
                }
            }
        }
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }



    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除FollowMerchant
     */
    @Transactional(readOnly = false)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】取消收藏：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        FollowMerchant entity = followMerchantMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(FollowMerchant.DEL_FLAG_DELETE);
            entity.preUpdate();
            followMerchantMapper.updateByPrimaryKey(entity);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改FollowMerchant
     */
    @Transactional(readOnly = false)
    public ResultPoJo saveOrUpdate(FollowMerchantPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        User user = SystemUtils.getUser();
        po.setMembId(user.getId());
        po.setFlag("1");
        FollowMerchant entity = followMerchantMapper.findExist(po);

        if (ConverterUtil.isNotEmpty(entity)) {
            if (entity.getDelFlag().equals(FollowMerchant.DEL_FLAG_DELETE)){
                entity.setDelFlag(FollowMerchant.DEL_FLAG_NORMAL);
                entity.preUpdate();
                followMerchantMapper.updateByPrimaryKeySelective(entity);
            }else{
                entity.setDelFlag(FollowMerchant.DEL_FLAG_DELETE);
                entity.preUpdate();
                followMerchantMapper.updateByPrimaryKeySelective(entity);
            }
        } else {
            entity = new FollowMerchant();
            //新增
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            followMerchantMapper.insert(entity);
        }
        return resultPoJo;
    }

    /**
     * 收藏or取消(基地)
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo saveOrUpdBase(FollowMerchantBasePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        User user = SystemUtils.getUser();
        po.setMembId(user.getId());
        po.setFlag("1");
        FollowMerchant entity = followMerchantMapper.findBaseExist(po);

        if (ConverterUtil.isNotEmpty(entity)) {
            if (entity.getDelFlag().equals(FollowMerchant.DEL_FLAG_DELETE)){
                entity.setDelFlag(FollowMerchant.DEL_FLAG_NORMAL);
                entity.preUpdate();
                followMerchantMapper.updateByPrimaryKeySelective(entity);
            }else{
                entity.setDelFlag(FollowMerchant.DEL_FLAG_DELETE);
                entity.preUpdate();
                followMerchantMapper.updateByPrimaryKeySelective(entity);
            }
        } else {
            entity = new FollowMerchant();
            //新增
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            followMerchantMapper.insert(entity);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息FollowMerchant
     */
    public ResultPoJo<FollowMerchantInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<FollowMerchantInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        FollowMerchantInfoVo vo = followMerchantMapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }


    public ResultPoJo<FollowMerchant> findByMembIdAndShopId(FollowMerchantPo po) {
		ResultPoJo<FollowMerchant> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		FollowMerchant merchant = followMerchantMapper.findExist(po);
		if (merchant == null) {
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}else {
			resultPoJo.setResult(merchant);
		}
		return resultPoJo;
	}



}
