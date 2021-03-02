package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.constants.DictConstants;
import com.wisea.cultivar.common.dao.CommPubInfoMapper;
import com.wisea.cultivar.common.entity.CommPubInfo;
import com.wisea.cultivar.common.po.product.CommDataListPo;
import com.wisea.cultivar.common.po.product.CommPubExamPo;

import com.wisea.cultivar.common.vo.product.CommDataListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * 商品信息列表
     */
    public ResultPoJo<Page<CommDataListVo>> commList(CommDataListPo po) {
        List<CommDataListVo> commDataListVos = commPubInfoMapper.commList(po);
        Page<CommDataListVo> page = po.getPage();
        page.setList(commDataListVos);
        ResultPoJo<Page<CommDataListVo>> result = new ResultPoJo<>();
        result.setResult(page);
        return result;
    }

    /**
     * 导出商品信息列表
     */
    public List<CommDataListVo> exportList(CommDataListPo po) {
        List<CommDataListVo> commDataListVos = commPubInfoMapper.commList(po);
        return commDataListVos;
    }

    /**
     * 运营后台 审核发布商品信息
     *
     * @param commPubExamPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> examCommPubInfo(CommPubExamPo commPubExamPo) {

        ResultPoJo<String> poJo = new ResultPoJo(ConstantCodeMsg.NOMAL);
        CommPubInfo commPubInfo = new CommPubInfo();
        CommPubInfo commInfoState = commPubInfoMapper.selectByPrimaryKey(commPubExamPo.getId());
        /**
         * 2 待审核
         */
        if (commInfoState.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_2)) {
            // COMM_STATE_TYPE_0 销售中
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
            } else {
                // 驳回 下架
                commPubInfo.preUpdate();
                commPubInfo.setId(commPubExamPo.getId());
                // 设置审核意见
                commPubInfo.setRejectReason(commPubExamPo.getExamYj());
                commPubInfo.setCommStateType(commPubExamPo.getCommStateType());
                // 更新商品发布表中状态
                commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
            }
        } else if (commInfoState.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_0)
            && commPubExamPo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_4)) {
            // 驳回(强制下架)
                commPubInfo.preUpdate();
                commPubInfo.setId(commPubExamPo.getId());
                // 设置审核意见
                commPubInfo.setRejectReason(commPubExamPo.getExamYj());
                commPubInfo.setCommStateType(commPubExamPo.getCommStateType());
                // 更新商品发布表中状态
                commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
        }
        return poJo;
    }
}
