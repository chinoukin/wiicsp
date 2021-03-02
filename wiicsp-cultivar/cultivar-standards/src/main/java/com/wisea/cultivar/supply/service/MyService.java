package com.wisea.cultivar.supply.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sms.SmsService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.FeedBackMageMapper;
import com.wisea.cultivar.common.dao.MembInfoMapper;
import com.wisea.cultivar.common.entity.FeedBackMage;
import com.wisea.cultivar.common.entity.MembInfo;
import com.wisea.cultivar.common.mss.RemoteTIMAccountMss;
import com.wisea.cultivar.common.po.tim.RemotePortraitSetPo;
import com.wisea.cultivar.common.vo.MembInfoInfoVo;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.supply.mapper.ShopInfoMapper;
import com.wisea.cultivar.supply.po.AccountUpdatePo;
import com.wisea.cultivar.supply.po.FeedBackVo;
import com.wisea.cultivar.supply.po.MobileUpdatePo;
import com.wisea.cultivar.supply.util.CustomUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * APP管理-供应端-我的
 * @author chengq
 * @date 2020/8/25 17:16
 */
@Service
public class MyService {

    @Resource
    private SmsService smsService;

    @Resource
    private ShopInfoMapper shopInfoMapper;

    @Resource
    private FeedBackMageMapper feedBackMageMapper;

    @Resource
    private RemoteUserMss remoteUserMss;

    @Resource(name = "NbMembInfoMapper")
    private MembInfoMapper membInfoMapper;

    @Resource
    private RemoteTIMAccountMss timAccountMss;

    /**
     * 修改手机号
     * @param mobileUpdatePo 验证信息
     */
    @Transactional
    public ResultPoJo<Object> updateMobile(MobileUpdatePo mobileUpdatePo) {
        User user = SystemUtils.getUser();
        String mobile = user.getMobile();
        //验证原来用户是否存在手机号
        if (ConverterUtil.isEmpty(mobile)) {
            throw new VerifyException(ConstantCodeMsg.ERR_528, ConstantCodeMsg.MSG_528);
        }
        //验证是否号是否一致
        if (!Objects.equals(mobile, mobileUpdatePo.getRegisteredMobile())) {
            throw new VerifyException(ConstantCodeMsg.ERR_812, ConstantCodeMsg.MSG_812);
        }
        //验证验证码
        Boolean smsCode = smsService.checkSMSCode(mobileUpdatePo.getRegisteredMobile(), mobileUpdatePo.getValCode());
        if (!smsCode) {
            //验证码不正确
            throw new VerifyException(ConstantCodeMsg.ERR_503, ConstantCodeMsg.MSG_503);
        }
        // 设置手机号
        String newMobile = mobileUpdatePo.getNewMobile();
        user.setMobile(newMobile);
        user.setCurrentUser(user);
        user.preUpdate();
        remoteUserMss.mobileUpdate(user);

        // 更新memb_info表用户手机号
        MembInfo membInfo = new MembInfo();
        membInfo.setId(user.getId());
        membInfo.setRegistTel(newMobile);
        membInfoMapper.updateByPrimaryKeySelective(membInfo);
        return CustomUtils.result();
    }

    /**
     * 查询账号信息
     */
    public ResultPoJo<MembInfoInfoVo> findAccount() {
        MembInfoInfoVo membInfoInfoVo = shopInfoMapper.findAccount(SystemUtils.getUser().getId());
        return CustomUtils.result(membInfoInfoVo);
    }

    /**
     * 意见反馈
     */
    public ResultPoJo<Object> feedBack(FeedBackVo feedBackVo) {
        User user = SystemUtils.getUser();
        FeedBackMage feedBackMage = new FeedBackMage();
        //登录名
        feedBackMage.setLoginName(user.getLoginName());
        //手机号
        feedBackMage.setTel(user.getMobile());
        //反馈内容
        feedBackMage.setFeedbackContent(feedBackVo.getContent());
        //处理状态 默认未处理
        feedBackMage.setProcesStatusType(QdcyStandardsDict.PROCES_STATUS_TYPE_1);
        //用户拓展信息
        MembInfoInfoVo membInfo = findAccount().getResult();
        //企业姓名
        feedBackMage.setEntpName(membInfo.getEntpName());
        //姓名
        feedBackMage.setName(membInfo.getContName());
        //问题类型
        feedBackMage.setProblemType(QdcyStandardsDict.PROBLEM_TYPE_1);
        feedBackMage.preInsert();
        feedBackMageMapper.insert(feedBackMage);
        return CustomUtils.result();
    }

    /**
     * 修改账号信息
     */
    @Transactional
    public ResultPoJo<Object> updateAccount(AccountUpdatePo accountUpdatePo) {
        MembInfo membInfo = new MembInfo();
        ConverterUtil.copyProperties(accountUpdatePo, membInfo);
        Long userId = SystemUtils.getUserOnlyId().getId();
        membInfo.setId(userId);
        membInfo.preUpdate();
        membInfoMapper.updateByPrimaryKeySelective(membInfo);

        //同步tim信息
        updateTimAccount(accountUpdatePo);
        return CustomUtils.result();
    }

    /**
     * 同步tim信息
     */
    private void updateTimAccount(AccountUpdatePo accountUpdatePo) {
        RemotePortraitSetPo remotePo = new RemotePortraitSetPo();
        List<RemotePortraitSetPo.RemoteProfileItem> profileItems = Lists.newArrayList();
        profileItems.add(builderRemoteProfileItem("Tag_Profile_IM_Nick", accountUpdatePo.getContName()));
        profileItems.add(builderRemoteProfileItem("Tag_Profile_IM_Image", accountUpdatePo.getLogoUrl()));
        remotePo.setProfileItem(profileItems);
        remotePo.setFromAccount(SystemUtils.getUserOnlyId().getId().toString());
        timAccountMss.userPortraitSet(remotePo);
    }

    /**
     * 构建RemoteProfileItem
     */
    private RemotePortraitSetPo.RemoteProfileItem builderRemoteProfileItem(String tag, String value) {
        RemotePortraitSetPo.RemoteProfileItem profileItem = new RemotePortraitSetPo.RemoteProfileItem();
        profileItem.setTag(tag);
        profileItem.setValue(value);
       return profileItem;
    }
}
