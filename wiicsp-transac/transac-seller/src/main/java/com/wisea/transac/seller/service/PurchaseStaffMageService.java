package com.wisea.transac.seller.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.entity.PurchaseStaffMage;
import com.wisea.transac.common.entity.SaleStaffInfoMage;
import com.wisea.transac.common.mss.RemoteCustomerMss;
import com.wisea.transac.common.mss.UserMembInfoMss;
import com.wisea.transac.common.po.PurchaseStaffMagePageListPo;
import com.wisea.transac.common.po.PurchaseStaffMagePo;
import com.wisea.transac.common.po.memb.MembStaffInfoAddPo;
import com.wisea.transac.common.po.memb.MembStaffInfoUpdPo;
import com.wisea.transac.common.po.trade.BuyerOrderInfoListPo;
import com.wisea.transac.common.service.TIMNoticeService;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.MembInfoInfoVo;
import com.wisea.transac.common.vo.PurchaseStaffMageInfoVo;
import com.wisea.transac.common.vo.PurchaseStaffMagePageListVo;
import com.wisea.transac.common.vo.seller.PurchaseStaffCountVo;
import com.wisea.transac.common.vo.seller.ShopInfoInfoVo;
import com.wisea.transac.common.vo.trade.BuyerOrderInfoListVo;
import com.wisea.transac.common.dao.*;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className PurchaseStaffMageService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class PurchaseStaffMageService extends BaseService {
    @Autowired
    private PurchaseStaffMageMapper mapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private ShopInfoMapper shopInfoMapper;
    //    @Autowired
//    SmsService smsService;
    @Autowired
    private MembInfoMapper membInfoMapper;
    @Autowired
    private UserMembInfoMss userMembInfoMss;
    @Autowired
    private TIMNoticeService timNoticeService;
    @Autowired
    private SaleStaffInfoMageMapper saleStaffInfoMageMapper;
    @Autowired
    private RemoteCustomerMss remoteCustomerMss;
    @Autowired
    private EntpAuthMapper entpAuthMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询PurchaseStaffMage
     */
    public ResultPoJo<Map<String, Object>> findPageList(PurchaseStaffMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Map<String, Object>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<PurchaseStaffMagePageListVo> page = po.getPage();
        List<PurchaseStaffMagePageListVo> list = mapper.findPageList(po);
        page.setList(list);

        PurchaseStaffCountVo countVo = mapper.findTotalCountAndNormalCount(po.getMembId());
        countVo.setNormalCount(countVo.getNormalCount() == null ? 0 : countVo.getNormalCount());
        countVo.setTotalCount(countVo.getTotalCount() == null ? 0 : countVo.getTotalCount());
        countVo.setDisableCount(countVo.getTotalCount() - countVo.getNormalCount());

        HashMap<String, Object> map = Maps.newHashMap();

        map.put("page", page);
        map.put("count", countVo);
        resultPoJo.setResult(map);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除PurchaseStaffMage
     */
    @Transactional
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        PurchaseStaffMage entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {

            //未结清账期和订单，直接返回
            Integer orderCount = orderInfoMapper.countOrderNoCompleteByBuyerId(entity.getPurchaseStaffId());
            if (orderCount > 0) {
                resultPoJo.setCode("999");
                resultPoJo.setMsg("被邀请者有未结清的帐期和未完成的订单");
                return resultPoJo;
            }

//            //删除客服
//            SysImCustomerListDeletePo SysImCustomerListDeletePo =new SysImCustomerListDeletePo();
//            SysImCustomerListDeletePo.setGroupId(SystemUtils.getUser().getId().toString());
//            List<Long> list = Lists.newArrayList();
//            list.add(po.getId());
//            SysImCustomerListDeletePo.setUserList(list);
//
//            ResultPoJo<Object> result = remoteCustomerMss.customerListDelete(SysImCustomerListDeletePo);
//            if (!result.getCode().equals("000")) {
//                throw new BaseException("999","删除客服配置失败");
//            }

            entity.setDelFlag(PurchaseStaffMage.DEL_FLAG_DELETE);
            entity.preUpdate();
            mapper.updateByPrimaryKey(entity);

            //清除缓存
            MembUtils.delMembUser(po.getId());
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 新增或修改PurchaseStaffMage
     * <p>
     * 新增：
     * </p>
     *
     * <p>
     * 1.已经是会员，检查是不是店铺管理员，是不是已经成为采购员，是否有订单未完成
     * </p>
     * <p>
     * 2.不是会员，可以直接邀请
     * </p>
     *
     * @date 2020/04/27 17:01:29
     */
    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional
    public ResultPoJo saveOrUpdate(PurchaseStaffMagePo po) {

        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        // 获取主体账户信息
        MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUser().getId());
        MembBaseInfo membInfo = membInfoMapper.getMembInfoByMobile(po.getRegistTel());
        //添加分支在销售端已经是该用户的二级员工直接添加不发送邀请 flag表示是否二级
        boolean flags = true;
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            PurchaseStaffMage entity = mapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(entity)) {
                //修改的时候添加修改会员信息
                MembStaffInfoUpdPo membStaffInfoUpdPo = new MembStaffInfoUpdPo();
                membStaffInfoUpdPo.setId(entity.getPurchaseStaffId());
                membStaffInfoUpdPo.setSfAdminFlag(po.getSfAdminFlag());
                membStaffInfoUpdPo.setMobile(po.getRegistTel());
                ResultPoJo<Object> userResult =  userMembInfoMss.updUserMembStaff(membStaffInfoUpdPo);
                if (!userResult.getCode().equals(ConstantError.NOMAL)) {
                    checkRemoteResult(userResult);
                    resultPoJo.setCode(userResult.getCode());
                    resultPoJo.setMsg(userResult.getMsg());
                    return resultPoJo;
                }
                // 修改员工表中的信息
                BeanUtils.copyProperties(po, entity);
                entity.setMembId(membBaseInfo.getMembId());
                entity.setRemarks(po.getRegistTel());
                entity.preUpdate();
                mapper.updateByPrimaryKeySelective(entity);
            } else {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        } else {
            Long newUserId;
            //新增
            PurchaseStaffMage entity = new PurchaseStaffMage();
            BeanUtils.copyProperties(po, entity);
            entity.setMembId(membBaseInfo.getMembId());
            if (membInfo != null) {

                //未结清账期和订单，直接返回
                Integer orderCount = orderInfoMapper.countOrderNoCompleteByBuyerId(membInfo.getId());
                if (orderCount > 0) {
                    resultPoJo.setCode("999");
                    resultPoJo.setMsg("被邀请者有未结清的帐期和未完成的订单");
                    return resultPoJo;
                }
                //添加分支在销售端已经是该用户的二级员工直接添加不发送邀请
                SaleStaffInfoMage parameter = new SaleStaffInfoMage();
                parameter.setMembId(membBaseInfo.getMembId());
                parameter.setSaleStaffId(membInfo.getId());
                SaleStaffInfoMage saleStaffInfo =  saleStaffInfoMageMapper.checkInfoExist(parameter);
                if (ConverterUtil.isNotEmpty(saleStaffInfo)){
                    flags = false;
                }else{
                //检查被邀请人下面有没有采购成员
                List<PurchaseStaffMage> purchaseStaffMages = mapper.findByMembId(membInfo.getId());
                if (purchaseStaffMages.size() > 0) {
                    //发送消息通知他解除团队
                    Map<String, Object> dataModel = Maps.newHashMap();
                    dataModel.put("membName", SystemUtils.getUser().getLoginName());

                    Map<String, Object> payload = Maps.newHashMap();
                    payload.put("flag", "1");
                    payload.put("membId", membBaseInfo.getMembId());
                    timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_DISSOLVE_PURCHASE_TEAM, dataModel, Arrays.asList(membInfo.getId().toString()), payload);
                    resultPoJo.setCode("999");
                    resultPoJo.setMsg("被邀请者为采购主体下存在采购员不可以邀请");
                    return resultPoJo;
                }

                //是否商家(agent_flag 0:是1:否) 是的话取商家
                if (membInfo.getAgentFlag().equals("0")) {
                    resultPoJo.setCode("999");
                    resultPoJo.setMsg("被邀请者是商户，不能邀请为采购员");
                    return resultPoJo;
                }
                //商户存在认证不可以邀请
                int count  =  entpAuthMapper.checkInfoExistByMembId(membInfo.getId());
                if (count > 0){
                    resultPoJo.setCode("999");
                    resultPoJo.setMsg("被邀请者存在商户认证审核中不可以邀请");
                    return resultPoJo;
                }

                //检查是不是别人的二级会员
                SaleStaffInfoMage saleStaffInfoMage = saleStaffInfoMageMapper.findBySaleStaffId(membInfo.getId());
                if (saleStaffInfoMage!=null&&!saleStaffInfoMage.getMembId().equals(membBaseInfo.getMembId())) {
                    resultPoJo.setCode("999");
                    resultPoJo.setMsg("被邀请者已经成为他人销售员工");
                    return resultPoJo;
                }


                //自身是其他店铺管理员
                ShopInfoInfoVo info = shopInfoMapper.findInfoByMerchantId(membInfo.getId());
                if (info != null) {
                    resultPoJo.setCode("999");
                    resultPoJo.setMsg("被邀请者本身是商家管理员");
                    return resultPoJo;
                }

                //是不是已成为采购员
                LongIdPo longIdPo = new LongIdPo();
                longIdPo.setId(membInfo.getId());
                PurchaseStaffMageInfoVo mageInfoVo = mapper.findByPurchaseStaffIdNormal(longIdPo);
                if (mageInfoVo != null) {
                    resultPoJo.setCode("999");
                    resultPoJo.setMsg("被邀请者本身是采购员");
                    return resultPoJo;
                }

             }
                entity.setPurchaseStaffId(membInfo.getId());
                newUserId = membInfo.getId();
            } else {
                PurchaseStaffMageInfoVo staffMageInfoVo = mapper.findByRemarks(po.getRegistTel());
                if (staffMageInfoVo != null) {
                    resultPoJo.setCode("999");
                    resultPoJo.setMsg("被邀请者本身是采购员");
                    return resultPoJo;
                }

                newUserId = IdGen.randomLong();

                // 添加会员信息
                MembStaffInfoAddPo membStaffInfoAddPo = new MembStaffInfoAddPo();
                membStaffInfoAddPo.setId(newUserId);
                membStaffInfoAddPo.setGroupId(entity.getMembId().toString());

                membStaffInfoAddPo.setSfAdminFlag(po.getSfAdminFlag());
                membStaffInfoAddPo.setMobile(po.getRegistTel());
                membStaffInfoAddPo.setPosition(po.getPosition());
                membStaffInfoAddPo.setSexType(po.getSexType());
                membStaffInfoAddPo.setContName(po.getStaffName());
                membStaffInfoAddPo.setParentId(entity.getMembId());
                ResultPoJo<MembInfo> userResult = userMembInfoMss.addUserMembStaff(membStaffInfoAddPo);

                if (!userResult.getCode().equals(ConstantError.NOMAL)
                        || ConverterUtil.isEmpty(userResult.getResult().getId())) {
                    throw new BusinessException(userResult.getCode(), userResult.getMsg());
                }

                entity.setPurchaseStaffId(newUserId);
            }
            entity.setRemarks(po.getRegistTel());
            //没有任何关联操作的初始化
            //添加分支在销售端已经是该用户的二级员工直接添加不发送邀请 flag表示是否二级
            if (flags){
                entity.setPurchaseTeamState(DictConstants.PURCHASE_TEAM_STATE_0);
            }else{
                entity.setPurchaseTeamState(DictConstants.PURCHASE_TEAM_STATE_1);
            }
            entity.setSffsdxyqFlag(DictConstants.SFFSDXYQ_FLAG_1);
            entity.preInsert();
            mapper.insert(entity);

//            发送通知
            if (flags) {
                Map<String, Object> dataModel = Maps.newHashMap();
                dataModel.put("membName", SystemUtils.getUser().getLoginName());
                Map<String, Object> payload = Maps.newHashMap();
                payload.put("flag", "1");
                payload.put("membId", membBaseInfo.getMembId());
                timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_INVITED_BUYER, dataModel, Arrays.asList(newUserId.toString()), payload);
            }
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息PurchaseStaffMage
     */
    public ResultPoJo<PurchaseStaffMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<PurchaseStaffMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        PurchaseStaffMageInfoVo vo = mapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {

            BuyerOrderInfoListPo infoListPo = new BuyerOrderInfoListPo();
            infoListPo.setPurchaseId(vo.getPurchaseStaffId());
            List<BuyerOrderInfoListVo> list = orderInfoMapper.findBuyerList(infoListPo);
            vo.setOrders(list);
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo send(LongIdPo po) {
        ResultPoJo resultPoJo = new ResultPoJo();
        PurchaseStaffMageInfoVo info = mapper.findInfo(po);
        if (info == null) {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
            return resultPoJo;
        }
        //已经关联或正在关联的就不操作了
        if (info.getPurchaseTeamState().equals(DictConstants.PURCHASE_TEAM_STATE_0)
                || info.getPurchaseTeamState().equals(DictConstants.PURCHASE_TEAM_STATE_1)) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("已关联成功或正在关联中");
            return resultPoJo;
        }
        String tel = "";
        if (info.getPurchaseStaffId() != null) {
            LongIdPo idPo = new LongIdPo();
            idPo.setId(info.getPurchaseStaffId());
            tel = membInfoMapper.findInfo(idPo).getRegistTel();
        } else {
            tel = info.getRemarks();
        }
        info.setPurchaseTeamState(DictConstants.PURCHASE_TEAM_STATE_0);
        info.setSffsdxyqFlag("0");
        //todo:发送短信
//        String message = "邀请您加入我们采购团队，url:{}";
//        smsService.sendMessage(tel,String.format(message,"链接"));

        PurchaseStaffMage mage = new PurchaseStaffMage();
        ConverterUtil.copyProperties(info, mage);
        mage.preUpdate();
        mapper.updateByPrimaryKey(mage);

        return resultPoJo;
    }

    /**
     * 接受邀请
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo accept(Long currentUserId, Long membId) {
        ResultPoJo resultPoJo = new ResultPoJo();
        LongIdPo longIdPo = new LongIdPo();
        longIdPo.setId(currentUserId);
        List<PurchaseStaffMageInfoVo> info = mapper.findByPurchaseStaffId(longIdPo);
        MembInfoInfoVo membInfo = membInfoMapper.findInfo(longIdPo);

        if (info.size() <= 0 || membInfo == null) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("找不到此用户");
            return resultPoJo;
        }

        List<PurchaseStaffMage> purchaseStaffMages = mapper.findByMembId(currentUserId);
        if (purchaseStaffMages.size() > 0) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("还没有解散采购团队");
            return resultPoJo;
        }

        PurchaseStaffMageInfoVo vo = info.stream().filter(i -> i.getMembId().equals(membId)).findAny().get();
        if (!vo.getPurchaseTeamState().equals(DictConstants.PURCHASE_TEAM_STATE_0)) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("已关联完成");
            return resultPoJo;
        }

        //未结清账期和订单，直接返回
        Integer orderCount = orderInfoMapper.countOrderNoCompleteByBuyerId(vo.getPurchaseStaffId());
        if (orderCount > 0) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("被邀请者有未结清的帐期和未完成的订单");
            return resultPoJo;
        }

//        //添加客服
//        SysImCustomerListInsertPo siccipo = new SysImCustomerListInsertPo();
//        siccipo.setGroupId(membId.toString());
//        CustomerConfigUserInsertPo CCUPo = new CustomerConfigUserInsertPo();
//        CCUPo.setUserId(currentUserId);
//
//        CCUPo.setAdmin("0");
//        siccipo.getUserList().add(CCUPo);
//        ResultPoJo<Object> result = remoteCustomerMss.customerListInsert(siccipo);
//        if (!result.getCode().equals("000")) {
//            throw new BaseException("999","添加客服配置失败");
//        }

        PurchaseStaffMage mage = new PurchaseStaffMage();
        ConverterUtil.copyProperties(vo, mage);
        if (mage.getPurchaseStaffId() == null) {
            mage.setPurchaseStaffId(currentUserId);
        }
        mage.setPurchaseTeamState(DictConstants.PURCHASE_TEAM_STATE_1);
        mage.preUpdate();
        mapper.updateByPrimaryKey(mage);

        //清除缓存
        MembUtils.delMembUser(currentUserId);

        //拒绝其他人的邀请
        info.stream().filter(i -> !i.getMembId().equals(membId)).forEach(i -> notAccept(currentUserId, i.getMembId()));



        return resultPoJo;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo notAccept(Long currentUserId, Long membId) {
        ResultPoJo resultPoJo = new ResultPoJo();
        LongIdPo longIdPo = new LongIdPo();
        longIdPo.setId(currentUserId);
        List<PurchaseStaffMageInfoVo> info = mapper.findByPurchaseStaffId(longIdPo);
        MembInfoInfoVo membInfo = membInfoMapper.findInfo(longIdPo);
        if (info.size() <= 0 || membInfo == null) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("找不到此用户");
            return resultPoJo;
        }
        PurchaseStaffMageInfoVo vo = info.stream().filter(i -> i.getMembId().equals(membId)).findAny().get();
        if (!vo.getPurchaseTeamState().equals(DictConstants.PURCHASE_TEAM_STATE_0)) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("已关联完成");
            return resultPoJo;
        }


        PurchaseStaffMage mage = new PurchaseStaffMage();
        ConverterUtil.copyProperties(vo, mage);
        if (mage.getPurchaseStaffId() == null) {
            mage.setPurchaseStaffId(currentUserId);
        }
        mage.setPurchaseTeamState(DictConstants.PURCHASE_TEAM_STATE_2);
        mage.preUpdate();
        mapper.updateByPrimaryKey(mage);

        //清除缓存
        MembUtils.delMembUser(currentUserId);

        return resultPoJo;
    }

}
