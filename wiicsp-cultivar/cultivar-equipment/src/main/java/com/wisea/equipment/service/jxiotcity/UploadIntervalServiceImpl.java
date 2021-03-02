package com.wisea.equipment.service.jxiotcity;

import com.wisea.equipment.po.JxiotcityPushMessagePo;
import com.wisea.equipment.service.jxiotcity.PushMessageService;
import org.springframework.stereotype.Service;

/**
 * 上传间隔消息推送
 * @author chengq
 * @date 2020/11/26 10:54
 */
@Service
public class UploadIntervalServiceImpl extends PushMessageService {

    /**
     * 修改上传间隔
     */
    @Override
    String buildEffectiveData(JxiotcityPushMessagePo pushMessagePo) {
        return prefix(pushMessagePo.getContent(), 8);
    }
}
