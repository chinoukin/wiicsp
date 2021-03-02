package com.wisea.equipment.service.jxiotcity;

import com.wisea.equipment.po.JxiotcityPushMessagePo;
import com.wisea.equipment.service.jxiotcity.PushMessageService;
import org.springframework.stereotype.Service;

/**
 * 写入继电器状态
 * @author chengq
 * @date 2020/11/26 10:54
 */
@Service
public class UpdateRelayServiceImpl extends PushMessageService {
    @Override
    String buildEffectiveData(JxiotcityPushMessagePo pushMessagePo) {
        return null;
    }
}
