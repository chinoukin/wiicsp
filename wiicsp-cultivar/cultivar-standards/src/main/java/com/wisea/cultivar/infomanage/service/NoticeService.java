package com.wisea.cultivar.infomanage.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.po.LongIdsPo;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.po.memb.FindInfoByStallsMageIdPo;
import com.wisea.cultivar.common.po.product.NoticeProcutPo;
import com.wisea.cultivar.common.service.TIMNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 商品通知消息
 * @author: wangs
 * @date :2020/6/5
 */
@Service
public class NoticeService {

    @Autowired
    TIMNoticeService timNoticeService;
    /**
     * 商品发送消息
     *
     * @param noticeProcutPo
     * @return
     */
    public ResultPoJo<String> sendNoticeSer(NoticeProcutPo noticeProcutPo) {
        ResultPoJo<String> result = new ResultPoJo(ConstantCodeMsg.NOMAL);

        // 1,业务员 : 具有 管理商品的权限 , 同一档口下的人;
        //2,管理员 : 商户本身, 设置为管理员的人;
        List<Long> ids = Lists.newArrayList();
        LongIdsPo longIdPo = new LongIdsPo();
        FindInfoByStallsMageIdPo findInfoByStallsMageIdPo = new FindInfoByStallsMageIdPo();
        findInfoByStallsMageIdPo.setSfAdminFlag("0");
        if (ConverterUtil.isNotEmpty(noticeProcutPo.getStaffMageIds()) && noticeProcutPo.getStaffMageIds().size() != 0) {
            longIdPo.setIds(noticeProcutPo.getStaffMageIds());
            findInfoByStallsMageIdPo.setStaffMageIds(noticeProcutPo.getStaffMageIds());
        } else {
            ids.add(noticeProcutPo.getStaffMageId());
            longIdPo.setIds(ids);
            findInfoByStallsMageIdPo.setMembId(noticeProcutPo.getMembId());
        }
        return null;
    }

}
