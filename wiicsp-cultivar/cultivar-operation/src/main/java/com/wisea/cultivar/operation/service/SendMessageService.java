package com.wisea.cultivar.operation.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.wisea.cultivar.common.dao.tp.MembInfoMapper;
import com.wisea.cultivar.operation.dao.SendMessageMapper;
import com.wisea.cultivar.operation.dao.SendMessageReciverMapper;
import com.wisea.cultivar.operation.entity.SendMessage;
import com.wisea.cultivar.operation.entity.SendMessageReciver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.exception.ErrorStatusCode;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.BatchUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cloud.model.po.LongIdsPo;
import com.wisea.cloud.tencentim.constants.TencentIMConstant;
import com.wisea.cloud.tencentim.constants.TencentIMErrorMapping;
import com.wisea.cloud.tencentim.vo.BatchError;
import com.wisea.cloud.tencentim.vo.BatchTencentIMVo;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.constants.TIMNoticeConstants;
import com.wisea.cultivar.common.po.SendMessagePageListPo;
import com.wisea.cultivar.common.po.SendMessagePo;
import com.wisea.cultivar.common.po.SendMessageReciverPageListPo;
import com.wisea.cultivar.common.po.TIMNoticeSendPo;
import com.wisea.cultivar.common.po.memb.MembListForMsgPo;
import com.wisea.cultivar.common.utils.MembUtils;
import com.wisea.cultivar.common.vo.SendMessageInfoVo;
import com.wisea.cultivar.common.vo.SendMessagePageListVo;
import com.wisea.cultivar.common.vo.memb.MembInfoListForMsgVo;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SendMessageService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class SendMessageService extends BaseService {
    @Autowired
    private SendMessageMapper mapper;
    @Autowired
    private SendMessageReciverMapper sendMessageReciverMapper;
    @Autowired
    private TIMNoticeManagerService timNoticeManagerService;
    @Autowired
    private MembInfoMapper membInfoMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SendMessage
     */
    public ResultPoJo<Page<SendMessagePageListVo>> findPageList(SendMessagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<SendMessagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<SendMessagePageListVo> page = po.getPage();
        List<SendMessagePageListVo> list = mapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @param po
     * @return
     */
    public ResultPoJo<Object> insert(SendMessagePo po) {
        LoggerUtil.infoWithContext("【insert】新增：", po);

        ResultPoJo<Object> resultPoJo = new ResultPoJo<>();
        TIMNoticeSendPo noticeSendPo = new TIMNoticeSendPo();
        noticeSendPo.setContent(po.getContent());
        noticeSendPo.setDesc(po.getSummary());
        noticeSendPo.setTitle(po.getTitle());
        noticeSendPo.setType(TIMNoticeConstants.TYPE_SYSTEM);
        // 发送范围为空时，使用指定具体会员列表
        if (ConverterUtil.isEmpty(po.getScope())) {
            noticeSendPo.setRecList(po.getRecList());
        } else {
            // 农资农技端发送消息的查询人员列表
            if("infomanage".equals(po.getPlatform())){
                noticeSendPo.setRecList(MembUtils.findMembListForMsg(po.getScope().stream().collect(Collectors.joining(","))));
            // 交易端发送消息的查询人员列表
            }else if("mall".equals(po.getPlatform())){
                noticeSendPo.setRecList(membInfoMapper.findAllMembList());
            }else{
                throw new BusinessException(ConstantCodeMsg.ERR_001, ConstantCodeMsg.MSG_001);
            }
            // 根据类型获取会员列表
        }
        // 如果需要发送列表为空就返回
        if (ConverterUtil.isEmpty(noticeSendPo.getRecList())) {
            return resultPoJo;
        }
        // 发送TIM通知
        ResultPoJo<Object> sendRes = timNoticeManagerService.sendTIMNotice(noticeSendPo);

        Map<String, String> faildMap = Maps.newHashMap();
        // 返回值为失败时 读取失败的用户
        if (!(ConstantError.NOMAL.equals(sendRes.getCode()) || ErrorStatusCode.OK.code().equals(sendRes.getCode()))) {
            @SuppressWarnings("unchecked")
            List<BatchTencentIMVo> voList = (List<BatchTencentIMVo>) sendRes.getResult();
            for (BatchTencentIMVo vo : voList) {
                // 校验返回值
                if (!TencentIMConstant.ACTION_STATUS_OK.equals(vo.getActionStatus())) {
                    List<BatchError> errorList = vo.getErrorList();
                    errorList.forEach(e -> {
                        faildMap.put(e.getTo_Account(), TencentIMErrorMapping.value(e.getErrorCode()));
                    });
                }
            }
        }
        // 过滤掉发送失败的
        List<String> recList = noticeSendPo.getRecList();
        List<String> successIdList = recList.stream().filter(r -> !faildMap.containsKey(r)).collect(Collectors.toList());

        // 如果没有成功的 直接返回
        if (ConverterUtil.isEmpty(successIdList)) {
            throw new BusinessException(ConstantCodeMsg.ERR_917, ConstantCodeMsg.MSG_917 + ConverterUtil.gson.toJson(faildMap));
        }

        // 新增主表
        SendMessage entity = new SendMessage();
        ConverterUtil.copyProperties(po, entity);
        List<String> scope = po.getScope();
        if (ConverterUtil.isNotEmpty(scope)) {
            for (int i = 0; i < scope.size(); i++) {
                entity.setScope(scope.get(0));
            }
        }else {
            entity.setScope("4");  //指定会员
        }
        // 类型为系统通知
        entity.setMessageType(TIMNoticeConstants.TYPE_SYSTEM);
        entity.preInsert();
        mapper.insert(entity);
        List<SendMessageReciver> msgReciverLst = successIdList.stream().map(s -> {
            SendMessageReciver sr = new SendMessageReciver();
            sr.setMsgId(entity.getId());
            sr.setMembId(ConverterUtil.toLong(s));
            sr.preInsert();
            return sr;
        }).collect(Collectors.toList());

        // 新增子表
        BatchUtils.batchSQL(msgReciverLst, s -> sendMessageReciverMapper.batchInsert(s));
        // 如果传入的和成功的数量不等 说明只有部分成功
        if (recList.size() != successIdList.size()) {
            resultPoJo.setCode(ConstantCodeMsg.ERR_918);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_918 + ConverterUtil.gson.toJson(faildMap));
        }

        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息SendMessage
     */
    public ResultPoJo<SendMessageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<SendMessageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SendMessageInfoVo vo = mapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 查询接收者翻页列表
     *
     * @param po
     * @return
     */
    public ResultPoJo<Page<MembInfoListForMsgVo>> findReciverPageList(SendMessageReciverPageListPo po) {
        LoggerUtil.infoWithContext("【findReciverPageList】分页查询列表：", po);
        ResultPoJo<Page<MembInfoListForMsgVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<MembInfoListForMsgVo> page = po.getPage();
        List<MembInfoListForMsgVo> list = sendMessageReciverMapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    public ResultPoJo batDelete(LongIdsPo po) {
        LoggerUtil.infoWithContext("【logicDel】批量删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        List<Long> ids = po.getIds();
        for (Long id : ids) {
            sendMessageReciverMapper.batDelete(id);
        }

        return resultPoJo;
    }
    /**
	 * 发送消息 -指定的时候查询所有的会员接口
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年7月16日
	 * @version 1.0
	 */
	public ResultPoJo<List<MembInfoListForMsgVo>> membListForMsg(MembListForMsgPo po){
		//  返回参数
		ResultPoJo<List<MembInfoListForMsgVo>> result = new ResultPoJo<List<MembInfoListForMsgVo>>(ConstantError.NOMAL);
		result.setResult(membInfoMapper.membListForMsg(po));
		return result;
	}
}
