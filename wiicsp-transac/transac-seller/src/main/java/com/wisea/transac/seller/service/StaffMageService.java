package com.wisea.transac.seller.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.entity.SaleStaffInfoMage;
import com.wisea.transac.common.entity.StallsStaffRelaMage;
import com.wisea.transac.common.mss.RemoteCustomerMss;
import com.wisea.transac.common.mss.RemoteTIMAccountMss;
import com.wisea.transac.common.mss.UserMembInfoMss;
import com.wisea.transac.common.po.SaleStaffInfoMagePageListPo;
import com.wisea.transac.common.po.customer.SysImCustomerListDeletePo;
import com.wisea.transac.common.po.memb.MembStaffInfoAddPo;
import com.wisea.transac.common.po.memb.MembStaffInfoUpdPo;
import com.wisea.transac.common.po.seller.FindInfoByStallsMageIdPo;
import com.wisea.transac.common.po.seller.StaffMagePo;
import com.wisea.transac.common.po.seller.UpdEffeInvalStatePo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.utils.ShopUtils;
import com.wisea.transac.common.vo.PurchaseStaffMageInfoVo;
import com.wisea.transac.common.dao.*;
import com.wisea.transac.common.vo.seller.*;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffMageService extends BaseService {

    @Autowired
    private MembInfoMapper membInfoMapper;
    @Autowired
    private SaleStaffInfoMageMapper saleStaffInfoMageMapper;
    @Autowired
    private PurchaseStaffMageMapper purchaseStaffMageMapper;
//    @Autowired
//    private RemoteUserMss remoteUserMss;
    @Autowired
    private RemoteCustomerMss remoteCustomerMss;

    @Autowired
    private UserMembInfoMss userMembInfoMss;

    @Autowired
    private RemoteTIMAccountMss remoteTIMAccountMss;

    @Autowired
    private StallsStaffRelaMageMapper stallsStaffRelaMageMapper;

    @Autowired
    private BaseInfoMapper baseInfoMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询SaleStaffInfoMage
     */
    public ResultPoJo<Page<SaleStaffInfoMagePageListVo>> findPageList(SaleStaffInfoMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<SaleStaffInfoMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<SaleStaffInfoMagePageListVo> page = po.getPage();
        MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUser().getId());
        po.setMembId(membBaseInfo.getMembId());
        List<SaleStaffInfoMagePageListVo> list = saleStaffInfoMageMapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 新增或修改
     *
     * @param po
     * @return
     */
    //@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
    @GlobalTransactional
    @Transactional(readOnly = false)
    public ResultPoJo<StaffMageVo> saveOrUpdate(StaffMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        StaffMageVo vo = new StaffMageVo();
        User user = SystemUtils.getUser();
        MembBaseInfo membInfo = membInfoMapper.getMembInfoByMobile(po.getRegistTel());

        MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            SaleStaffInfoMage saleStaffInfoMage = saleStaffInfoMageMapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(saleStaffInfoMage)) {

                MembStaffInfoUpdPo membStaffInfoUpdPo = new MembStaffInfoUpdPo();
                membStaffInfoUpdPo.setId(membInfo.getId());
                membStaffInfoUpdPo.setStaffType("0");
                if (DictConstants.LOCALITY_MEMB_TYPE_0.equals(membBaseInfo.getLocalityMembType())){
                    BaseInfoVo baseInfo = baseInfoMapper.findByMembId(membBaseInfo.getMembId());
                    membStaffInfoUpdPo.setGroupId(baseInfo.getId().toString());
                }else{
                    ShopInfoInfoVo shopInfo = getShopInfoWithCheck();
                    membStaffInfoUpdPo.setGroupId(ConverterUtil.toString(shopInfo.getId()));
                }
                membStaffInfoUpdPo.setSfAdminFlag(po.getSfAdminFlag());
                membStaffInfoUpdPo.setMobile(po.getRegistTel());
                membStaffInfoUpdPo.setMenuIds(po.getMenuIds());

                ResultPoJo<Object> userResult =  userMembInfoMss.updUserMembStaff(membStaffInfoUpdPo);
                if (!userResult.getCode().equals(ConstantError.NOMAL)) {
                    checkRemoteResult(userResult);
                    resultPoJo.setCode(userResult.getCode());
                    resultPoJo.setMsg(userResult.getMsg());
                    return resultPoJo;
                }

                //修改销售员工
                BeanUtils.copyProperties(po, saleStaffInfoMage);
                saleStaffInfoMage.preUpdate();
                saleStaffInfoMageMapper.updateByPrimaryKeySelective(saleStaffInfoMage);

                vo.setId(saleStaffInfoMage.getSaleStaffId());
                resultPoJo.setResult(vo);
            } else {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        } else {
            Long membId;
            //如果是空就是没有用户
            if(ConverterUtil.isNotEmpty(membInfo)){
                //是否商家(agent_flag 0:是1:否) 是的话取商家
                if (membInfo.getAgentFlag().equals("0")) {
                    resultPoJo.setCode("999");
                    resultPoJo.setMsg("被添加者是商户，不能添加为员工");
                    return resultPoJo;
                }
                //员工只能绑定一家企业
                LongIdPo longIdPo = new LongIdPo();
                longIdPo.setId(membInfo.getId());
                PurchaseStaffMageInfoVo mageInfoVo = purchaseStaffMageMapper.findByPurchaseStaffIdNormal(longIdPo);
                if (ConverterUtil.isNotEmpty(mageInfoVo)) {
                    if (!mageInfoVo.getMembId().equals(user.getId())) {
                        resultPoJo.setCode("999");
                        resultPoJo.setMsg("已是其他企业采购员工不可以在被添加");
                        return resultPoJo;
                    }
                }
                SaleStaffInfoMage SaleStaffInfo = saleStaffInfoMageMapper.findInfoBySaleStaffId(membInfo.getId());
                if (ConverterUtil.isNotEmpty(SaleStaffInfo)){
                    resultPoJo.setCode("999");
                    resultPoJo.setMsg("已是其他企业销售员工不可以在被添加");
                    return resultPoJo;
                }
                //会员ID
                membId = membInfo.getId();

            }else{
                //销售员工会员ID
                membId = IdGen.randomLong();
            }

            //销售员工管理
            SaleStaffInfoMage saleStaffInfoMage = new SaleStaffInfoMage();
            BeanUtils.copyProperties(po, saleStaffInfoMage);
            saleStaffInfoMage.preInsert();
            saleStaffInfoMage.setMembId(membBaseInfo.getMembId());
            saleStaffInfoMage.setSaleStaffId(membId);
            saleStaffInfoMage.setPurchaseTeamState(DictConstants.PURCHASE_TEAM_STATE_1);
            saleStaffInfoMageMapper.insertSelective(saleStaffInfoMage);

            // 添加会员信息
            MembStaffInfoAddPo membStaffInfoAddPo = new MembStaffInfoAddPo();
            membStaffInfoAddPo.setId(membId);
            membStaffInfoAddPo.setStaffType("0");
            if (DictConstants.LOCALITY_MEMB_TYPE_0.equals(membBaseInfo.getLocalityMembType())){
                BaseInfoVo baseInfo = baseInfoMapper.findByMembId(membBaseInfo.getMembId());
                membStaffInfoAddPo.setGroupId(baseInfo.getId().toString());
            }else{
                ShopInfoInfoVo shopInfo = getShopInfoWithCheck();
                membStaffInfoAddPo.setGroupId(ConverterUtil.toString(shopInfo.getId()));
            }
            membStaffInfoAddPo.setSfAdminFlag(po.getSfAdminFlag());
            membStaffInfoAddPo.setMobile(po.getRegistTel());
            membStaffInfoAddPo.setPosition(po.getPosition());
            membStaffInfoAddPo.setSexType(po.getSexType());
            membStaffInfoAddPo.setContName(po.getStaffName());
            membStaffInfoAddPo.setMenuIds(po.getMenuIds());
            ResultPoJo<MembInfo> userResult = userMembInfoMss.addUserMembStaff(membStaffInfoAddPo);
            if (!userResult.getCode().equals(ConstantError.NOMAL)) {
                checkRemoteResult(userResult);
                resultPoJo.setCode(userResult.getCode());
                resultPoJo.setMsg(userResult.getMsg());
                return resultPoJo;
            }
            vo.setId(membId);
            resultPoJo.setResult(vo);
        }
        return resultPoJo;
    }


    /**
     * 删除
     *
     * @param po
     * @return
     */
    //@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
    @GlobalTransactional
    @Transactional(readOnly = false)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SaleStaffInfoMage saleStaffInfoMage = saleStaffInfoMageMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(saleStaffInfoMage)) {
            //删除销售员工
            saleStaffInfoMage.preUpdate();
            saleStaffInfoMage.setDelFlag(SaleStaffInfoMage.DEL_FLAG_DELETE);
            saleStaffInfoMage.setPurchaseTeamState(DictConstants.PURCHASE_TEAM_STATE_3);
            saleStaffInfoMage.setEffeInvalState(DictConstants.EFFE_INVAL_STATE_1);
            saleStaffInfoMageMapper.updateByPrimaryKey(saleStaffInfoMage);
            //解绑档口员工关系
            StallsStaffRelaMage rela = new StallsStaffRelaMage();
            rela.preUpdate();
            rela.setStaffInfoMageId(saleStaffInfoMage.getSaleStaffId());
            rela.setEffeInvalState(DictConstants.EFFE_INVAL_STATE_1);
            rela.setRelaStateType(DictConstants.RELA_STATE_TYPE_1);
            stallsStaffRelaMageMapper.updateBystaffInfoMageId(rela);
//            //删除用户
//            UpdUserMembInfoPo updUserMembInfoPo = new UpdUserMembInfoPo();
//            updUserMembInfoPo.setId(saleStaffInfoMage.getSaleStaffId());
//            updUserMembInfoPo.setClearMenuFlag(true);
//            updUserMembInfoPo.setPhysicalDelFLag("1");
//            ResultPoJo<String> userResult = userMembInfoMss.updUserMembInfo(updUserMembInfoPo);
//            if (!userResult.getCode().equals(ConstantError.NOMAL)) {
//                checkRemoteResult(userResult);
//                resultPoJo.setCode(userResult.getCode());
//                resultPoJo.setMsg(userResult.getMsg());
//                return resultPoJo;
//            }

            //删除客服
            SysImCustomerListDeletePo SysImCustomerListDeletePo =new SysImCustomerListDeletePo();
            ShopInfoInfoVo shopInfo = getShopInfoWithCheck();
            SysImCustomerListDeletePo.setGroupId(ConverterUtil.toString(shopInfo.getId()));
            List<Long> list = Lists.newArrayList();
            list.add(saleStaffInfoMage.getSaleStaffId());
            SysImCustomerListDeletePo.setUserList(list);
            ResultPoJo<Object> result = remoteCustomerMss.customerListDelete(SysImCustomerListDeletePo);
            if (!result.getCode().equals(ConstantError.NOMAL)) {
                checkRemoteResult(result);
                resultPoJo.setCode(result.getCode());
                resultPoJo.setMsg(result.getMsg());
                return resultPoJo;
            }

        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 冻结启用
     *
     * @param po
     * @return
     */
    //@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
    @GlobalTransactional
    @Transactional(readOnly = false)
    public ResultPoJo updEffeInvalState(UpdEffeInvalStatePo po) {
        LoggerUtil.infoWithContext("【updEffeInvalState】冻结启用：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SaleStaffInfoMage saleStaffInfoMage = saleStaffInfoMageMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(saleStaffInfoMage)) {
            //修改销售员工
            saleStaffInfoMage.preUpdate();
            saleStaffInfoMage.setEffeInvalState(po.getEffeInvalState());
            saleStaffInfoMageMapper.updateByPrimaryKeySelective(saleStaffInfoMage);
            //修改会员
            MembInfo membInfo = new MembInfo();
            membInfo.setId(saleStaffInfoMage.getSaleStaffId());
            membInfo.setAcctState(po.getEffeInvalState());
            membInfoMapper.updateByPrimaryKeySelective(membInfo);
            //停启档口员工关系
            StallsStaffRelaMage rela = new StallsStaffRelaMage();
            rela.preUpdate();
            rela.setStaffInfoMageId(saleStaffInfoMage.getSaleStaffId());
            rela.setEffeInvalState(po.getEffeInvalState());
            stallsStaffRelaMageMapper.updateBystaffInfoMageId(rela);
//            // 修改用户表中的状态
//            UpdUserMembInfoPo updUserMembInfoPo = new UpdUserMembInfoPo();
//           // LoginBatUpdatePo loginBatUpdate = new LoginBatUpdatePo();
//            updUserMembInfoPo.setLoginFlag(changeAcctState(membInfo.getAcctState()));
//            updUserMembInfoPo.setId(saleStaffInfoMage.getSaleStaffId());
//            ResultPoJo<String> loginFlagUserResult = userMembInfoMss.updUserMembInfo(updUserMembInfoPo);
//            if (!loginFlagUserResult.getCode().equals(ConstantError.NOMAL)) {
//                checkRemoteResult(loginFlagUserResult);
//                resultPoJo.setCode(loginFlagUserResult.getCode());
//                resultPoJo.setMsg(loginFlagUserResult.getMsg());
//                return resultPoJo;
//            }
            //清楚缓存
            MembUtils.delMembUser(po.getId());
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 查询详情
     *
     * @param po
     * @return
     */
    public ResultPoJo<SaleStaffInfoMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<SaleStaffInfoMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SaleStaffInfoMageInfoVo vo = saleStaffInfoMageMapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            MembInfo membInfo = membInfoMapper.selectByPrimaryKey(vo.getSaleStaffId());
            vo.setRegistTel(membInfo.getRegistTel());
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }
    /**
     * 根据档口ID查询销售员工
     * @param po
     * @return
     */
    public List<SaleStaffInfoMageInfoVo> findInfoByStallsMageId(FindInfoByStallsMageIdPo po) {
        LoggerUtil.infoWithContext("【findInfoByStallsMageId】根据档口ID查询销售员工：", po);
        List<SaleStaffInfoMageInfoVo> vo = Lists.newArrayList();
        if (ConverterUtil.isNotEmpty(po.getMembId())){
            vo = saleStaffInfoMageMapper.findListByMembId(po);
        }
        if (ConverterUtil.isNotEmpty(po.getStaffMageIds())){
            vo = saleStaffInfoMageMapper.findInfoByStallsMageId(po);
        }
        return vo;
    }

    private ShopInfoInfoVo getShopInfoWithCheck() {
        User loginUser = SystemUtils.getUserOnlyId();
        MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(loginUser.getId());
        // 查询店铺id 店铺员工 档口员工 都返回店铺
        ShopInfoInfoVo shopInfo = ShopUtils.getShopInfo(membBaseInfo.getMembId());

        // 如果没有取得店铺 说明不是店铺的人员
        if (null == shopInfo) {
            throw new VerifyException(ConstantCodeMsg.ERR_719, ConstantCodeMsg.MSG_719);
        }
        return shopInfo;
    }

    public static String changeAcctState(String acctState) {
        // 启用
        if (DictConstants.ACCT_STATE_0.equals(acctState)) {
            return Constants.YES;
        }
        // 停用
        if (DictConstants.ACCT_STATE_1.equals(acctState)) {
            return Constants.NO;
        }
        return null;
    }


}
