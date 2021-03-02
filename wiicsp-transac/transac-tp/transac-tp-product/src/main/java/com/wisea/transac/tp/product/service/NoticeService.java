package com.wisea.transac.tp.product.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.po.LongIdsPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.po.product.NoticeProcutPo;
import com.wisea.transac.common.po.seller.FindInfoByStallsMageIdPo;
import com.wisea.transac.common.service.TIMNoticeService;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMageInfoVo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMagePageListVo;
import com.wisea.transac.tp.product.mss.SellerMss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: 商品通知消息
 * @author: wangs
 * @date :2020/6/5
 */
@Service
public class NoticeService {

    @Autowired
    TIMNoticeService timNoticeService;
    @Autowired
    SellerMss sellerMss;

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
        ArrayList<String> list = Lists.newArrayList();
        List<SaleStaffInfoMageInfoVo> mangerList;
        if (ConverterUtil.isNotEmpty(noticeProcutPo.getMembId())) {
            // 查询管理员和 商户本身
            mangerList = sellerMss.findInfoByStallsMageId(findInfoByStallsMageIdPo);
            mangerList.forEach(e -> {
                list.add(e.getMembId().toString());
            });

        } else {
            // 查询档口下全部员工
            ResultPoJo<List<SaleStaffInfoMagePageListVo>> allEmployeList = sellerMss.findAll(longIdPo);
            // 查询管理员和 商户本身
            mangerList = sellerMss.findInfoByStallsMageId(findInfoByStallsMageIdPo);

            allEmployeList.getResult().forEach(e -> {
                list.add(e.getMembId().toString());
            });
            mangerList.forEach(e -> {
                list.add(e.getMembId().toString());
            });

        }
        if (ConverterUtil.isNotEmpty(list) && list.size() != 0) {
            // 商品审核成功
            if (noticeProcutPo.getCommPubStateType().equals(DictConstants.COMM_STATE_TYPE_0)) {
                Map<String, Object> dataModel = Maps.newHashMap();
                dataModel.put("commName", noticeProcutPo.getCommTitle());
                timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_PRD_PUB_SUC, dataModel, list);
            } else if (noticeProcutPo.getCommPubStateType().equals(DictConstants.COMM_STATE_TYPE_4)) {
                Map<String, Object> dataModel = Maps.newHashMap();
                dataModel.put("commName", noticeProcutPo.getCommTitle());
                dataModel.put("backReson", noticeProcutPo.getAuditReasons());
                timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_PRD_PUB_FAL, dataModel, list);
            } else if (noticeProcutPo.getCommPubStateType().equals(DictConstants.COMM_STATE_TYPE_6)) {
                Map<String, Object> dataModel = Maps.newHashMap();
                dataModel.put("commName", noticeProcutPo.getCommTitle());
                dataModel.put("backReson", noticeProcutPo.getAuditReasons());
                timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_PRD_PUB_OFF, dataModel, list);
            }
        }
        if (ConverterUtil.isNotEmpty(noticeProcutPo.getNoticeType()) && list.size() != 0) {
            if (noticeProcutPo.getNoticeType().equals(DictConstants.COMM_STATE_TYPE_0)) {
                // 商品库存预警
                Map<String, Object> dataModel = Maps.newHashMap();
                dataModel.put("commName", noticeProcutPo.getCommTitle());
                dataModel.put("commSpec", noticeProcutPo.getSpecName());
                timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_PRD_PUB_OFF, dataModel, list);
            } else if (noticeProcutPo.getNoticeType().equals(DictConstants.COMM_STATE_TYPE_1)) {
                // 商品库存不足
                Map<String, Object> dataModel = Maps.newHashMap();
                dataModel.put("commName", noticeProcutPo.getCommTitle());
                dataModel.put("commSpec", noticeProcutPo.getSpecName());
                timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_PRD_PUB_OFF, dataModel, list);
            }

        }
        return result;
    }

}
