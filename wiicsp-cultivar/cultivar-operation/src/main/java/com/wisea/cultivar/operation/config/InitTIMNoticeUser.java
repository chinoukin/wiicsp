package com.wisea.cultivar.operation.config;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.annotation.LoadCompleted;
import com.wisea.cloud.common.service.SpringLoadCompleted;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.tencentim.constants.TencentIMConstant;
import com.wisea.cloud.tencentim.po.AccountImportPo;
import com.wisea.cloud.tencentim.service.TencentIMService;
import com.wisea.cultivar.operation.entity.TIMNoticeUser;
import com.wisea.cultivar.operation.properties.TIMNoticeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Map;

/**
 * 初始化TIM通知发送用户
 * <p/>
 * 启动时进行固定的帐户同步
 *
 * @author XuDL(Wisea)
 * <p>
 * 2020年5月6日 下午2:09:28
 */
@LoadCompleted
@EnableConfigurationProperties(TIMNoticeProperties.class)
public class InitTIMNoticeUser implements SpringLoadCompleted {
//
//    @Autowired
//    private TIMNoticeManagerService timNoticeManagerService;


    @Autowired
    private TIMNoticeProperties prop;

    @Autowired
    protected TencentIMService tencentIMService;

    @Async
    @Override
    public void init(ApplicationContext context) {
        Map<String, TIMNoticeUser> users = prop.getUsers();
        if (ConverterUtil.isNotEmpty(users)) {
            List<AccountImportPo> po = Lists.newArrayList();
            users.values().forEach(u -> {
                AccountImportPo acc = new AccountImportPo();
                acc.setIdentifier(u.getId());
                acc.setNick(u.getNick());
                acc.setFaceUrl(u.getFaceUrl());
                acc.setType(TencentIMConstant.ACCOUNT_NOTICE);
                po.add(acc);
            });
            // 同步配置好的用户到TIM和本地
            tencentIMService.userSynchronize(po);
        }
    }

}
