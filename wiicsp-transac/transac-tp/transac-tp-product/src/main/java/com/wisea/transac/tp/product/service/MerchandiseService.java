package com.wisea.transac.tp.product.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.CommPubInfoMapper;
import com.wisea.transac.common.entity.CommPubInfo;
import com.wisea.transac.common.po.product.*;
import com.wisea.transac.common.utils.AssemblyPriceUtil;
import com.wisea.transac.common.utils.ShopUtils;
import com.wisea.transac.common.vo.product.AssembyPriceVo;
import com.wisea.transac.common.vo.product.CommDataListVo;
import com.wisea.transac.common.vo.seller.ShopInfoInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: wangs
 * @date :2020/4/29
 */
@Service
@Transactional(readOnly = true)
public class MerchandiseService {

    @Autowired
    CommPubInfoMapper commPubInfoMapper;
    @Autowired
    CommditySearchService commditySearchService;
    @Autowired
    NoticeService noticeService;

    /**
     * 商品信息列表
     */
    public Page<CommDataListVo> commList(CommDataListPo po) {

        // 查询批发市场下对应的所有店铺
        if (ConverterUtil.isEmpty(po.getShopMageIds())) {
            List<ShopInfoInfoVo> shopByMarketId = ShopUtils.getShopByMarketId(po.getMarketId());
            if (ConverterUtil.isNotEmpty(shopByMarketId)) {
                List<Long> shopMageIds = Lists.newArrayList();
                shopByMarketId.forEach(e -> {
                    shopMageIds.add(e.getMerchantId());
                });
                po.setShopMageIds(shopMageIds);
            }
        }
        List<CommDataListVo> commDataListVos = commPubInfoMapper.commList(po);
        if (ConverterUtil.isNotEmpty(commDataListVos)) {
            commDataListVos.forEach(e -> {
                AssembyPriceVo productPrice = AssemblyPriceUtil.getProductPrice(e.getId());
                String priceRang = productPrice.getPriceRang();
                e.setStartOrdExpres(priceRang);
            });
        }
        Page<CommDataListVo> page = po.getPage();
        page.setList(commDataListVos);
        return page;
    }

    /**
     * 市场 - 变更商品审核设置,
     * <p>
     * 如果需要审核 ,需要将之前所有待审核的商品状态变成销售中
     * 同时 更新到索引库中
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo updateCommPubState(CommDataListPo po) {

        ResultPoJo poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        CommPubInfo commPubInfo = new CommPubInfo();
        // 变更
        commPubInfo.setCommStateType(DictConstants.COMM_STATE_TYPE_0);
        commPubInfo.setRejectReason("");
        commPubInfo.preUpdate();
        Map<String, Object> maps = Maps.newHashMap();
        maps.put("commPubInfo", commPubInfo);

        po.setCommStateType(DictConstants.COMM_STATE_TYPE_2);
        List<CommDataListVo> commDataListVos = commPubInfoMapper.commListAll(po);
        if (commDataListVos.size() > 0) {
            // 修改发布商品状态
            List<Long> ids = commDataListVos.stream().map(CommDataListVo::getId).collect(Collectors.toList());
            maps.put("ids", ids);
            commPubInfoMapper.updateCommPubInfoState(maps);
            // 变更索引信息
            BatchUpdSearchPo batchUpdSearchPo = new BatchUpdSearchPo();
            batchUpdSearchPo.setListIdPo(ids);
            commditySearchService.updateBatchCommditySearch(batchUpdSearchPo);
        }
        return poJo;
    }

    /**
     * 运营后台 审核发布商品信息
     *
     * @param commPubExamPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> examCommPubInfo(CommPubExamPo commPubExamPo) {

        ResultPoJo<String> Pojo = new ResultPoJo(ConstantCodeMsg.NOMAL);
        CommPubInfo commPubInfo = new CommPubInfo();
        CommPubInfo commInfoState = commPubInfoMapper.selectByPrimaryKey(commPubExamPo.getId());
        if (commInfoState.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_2)) {
            if (commPubExamPo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_0)) {
                // 审核通过
                commPubInfo.preUpdate();
                commPubInfo.setId(commPubExamPo.getId());
                if (ConverterUtil.isNotEmpty(commPubExamPo.getExamYj())) {
                    commPubInfo.setRejectReason(commPubExamPo.getExamYj());
                }
                commPubInfo.setCommStateType(commPubExamPo.getCommStateType());
                // 更新商品发布表中状态
                commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
                // 插入索引库
                TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
                        CommPubInfoGetPo commPubInfoGetPo = new CommPubInfoGetPo();
                        commPubInfoGetPo.setId(commPubInfo.getId());
                        commditySearchService.addIndexSearch(commPubInfoGetPo);
                        NoticeProcutPo noticeProcutPo = new NoticeProcutPo();
                        noticeProcutPo.setCommPubStateType(commPubExamPo.getCommStateType());
                        noticeProcutPo.setCommTitle(commInfoState.getCommTitle());
                        if (ConverterUtil.isEmpty(commInfoState.getBaseId())) {
                            noticeProcutPo.setStaffMageId(commInfoState.getStallsMageId());
                        } else {
                            noticeProcutPo.setMembId(commInfoState.getMembId());
                        }
                        noticeService.sendNoticeSer(noticeProcutPo);
                    }
                });
            } else {
                // 驳回
                commPubInfo.preUpdate();
                commPubInfo.setId(commPubExamPo.getId());
                // 设置审核意见
                commPubInfo.setRejectReason(commPubExamPo.getExamYj());
                commPubInfo.setCommStateType(commPubExamPo.getCommStateType());
                // 更新商品发布表中状态
                commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
                NoticeProcutPo noticeProcutPo = new NoticeProcutPo();
                noticeProcutPo.setCommPubStateType(commPubExamPo.getCommStateType());
                noticeProcutPo.setCommTitle(commInfoState.getCommTitle());
                if (ConverterUtil.isEmpty(commInfoState.getBaseId())) {
                    noticeProcutPo.setStaffMageId(commInfoState.getStallsMageId());
                } else {
                    noticeProcutPo.setMembId(commInfoState.getMembId());
                }
                noticeService.sendNoticeSer(noticeProcutPo);
            }
        } else if (commInfoState.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_0)) {
            // 驳回(强制下架)
            if (commPubExamPo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_4)) {

                commPubInfo.preUpdate();
                commPubInfo.setId(commPubExamPo.getId());
                // 设置审核意见
                commPubInfo.setRejectReason(commPubExamPo.getExamYj());
                commPubInfo.setCommStateType(commPubExamPo.getCommStateType());
                // 更新商品发布表中状态
                commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
                // 删除索引库
                TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
                        CommPubInfoGetPo commPubInfoGetPo = new CommPubInfoGetPo();
                        commPubInfoGetPo.setId(commPubInfo.getId());
                        commditySearchService.delIndexSearch(commPubInfoGetPo);
                        // 发送消息给管理员,业务员 商品被强制下架
                        NoticeProcutPo noticeProcutPo = new NoticeProcutPo();
                        noticeProcutPo.setCommPubStateType(DictConstants.COMM_STATE_TYPE_6);
                        noticeProcutPo.setCommTitle(commInfoState.getCommTitle());
                        if (ConverterUtil.isEmpty(commInfoState.getBaseId())) {
                            noticeProcutPo.setStaffMageId(commInfoState.getStallsMageId());
                        } else {
                            noticeProcutPo.setMembId(commInfoState.getMembId());
                        }
                        noticeService.sendNoticeSer(noticeProcutPo);
                    }
                });
            }
        }
        return Pojo;
    }
}
