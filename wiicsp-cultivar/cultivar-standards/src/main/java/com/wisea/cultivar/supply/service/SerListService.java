package com.wisea.cultivar.supply.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.constants.TIMNoticeConstants;
import com.wisea.cultivar.common.dao.DeadLineMageMapper;
import com.wisea.cultivar.common.entity.DeadLineMage;
import com.wisea.cultivar.common.service.TIMNoticeService;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.supply.entity.SerListInformation;
import com.wisea.cultivar.supply.entity.SerListMage;
import com.wisea.cultivar.supply.entity.SerListOpreateInfo;
import com.wisea.cultivar.supply.enums.SerStateEnum;
import com.wisea.cultivar.supply.mapper.SerListInformationMapper;
import com.wisea.cultivar.supply.mapper.SerListMageMapper;
import com.wisea.cultivar.supply.mapper.SerListOpreateInfoMapper;
import com.wisea.cultivar.supply.po.*;
import com.wisea.cultivar.supply.util.CustomUtils;
import com.wisea.cultivar.supply.vo.SerCountVo;
import com.wisea.cultivar.supply.vo.SerDetailsVo;
import com.wisea.cultivar.supply.vo.SerListVo;
import com.wisea.cultivar.supply.vo.SerOpreateInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * 服务单service
 * @author chengq
 * @date 2020/8/16 9:01
 */
@Service
public class SerListService {

    @Resource
    private SerListMageMapper serListMageMapper;

    @Resource
    private SerListOpreateInfoMapper serListOpreateInfoMapper;

    @Resource(name = "NbDeadLineMageMapper")
    private DeadLineMageMapper deadLineMageMapper;

    @Resource
    private TIMNoticeService timNoticeService;

    @Resource
    private SerListInformationMapper serListInformationMapper;

    /**
     * 服务单列表
     * @param serListPo 查询条件
     */
    public ResultPoJo<Page<SerListVo>> findSerList(SerListPo serListPo) {
        User user = SystemUtils.getUserOnlyId();
        serListPo.setMembId(user.getId());
        List<SerListVo> vo = serListMageMapper.findSerList(serListPo);
        DecimalFormat decimalFormat = CommodityService.df.get();
        vo.forEach(ser -> ser.setTotalPrice("¥" + decimalFormat.format(Double.valueOf(ser.getTotalPrice()))));
        Page<SerListVo> page = serListPo.getPage();
        page.setList(vo);
        return CustomUtils.result(page);
    }

    /**
     *服务单数量
     */
    public ResultPoJo<SerCountVo> serCount() {
        User user = SystemUtils.getUserOnlyId();
        SerCountVo vo = new SerCountVo();
        vo.setConfirmCount(serListMageMapper.selectSerCountByState(user.getId(), QdcyStandardsDict.SER_LIST_STATE_TYPE_0));
        vo.setServiceCount(serListMageMapper.selectSerCountByState(user.getId(), QdcyStandardsDict.SER_LIST_STATE_TYPE_1));
        vo.setCheckCount(serListMageMapper.selectSerCountByState(user.getId(), QdcyStandardsDict.SER_LIST_STATE_TYPE_2));
        return CustomUtils.result(vo);
    }

    /**
     * 服务单详情
     * @param serGetPo 服务单id
     * @return 详情
     */
    public ResultPoJo<SerDetailsVo> findSerDetails(SerGetPo serGetPo) {
        SerDetailsVo detailsVo = serListMageMapper.findSerDetails(serGetPo);
        Optional.ofNullable(detailsVo).orElseThrow(()->new VerifyException(QdcyStandardsError.ERR_10012, QdcyStandardsError.MSG_10012));
        //预约时间
        OffsetDateTime residueDate = detailsVo.getSubscribeDate();
        //查询过期间隔
        List<DeadLineMage> deadLines = deadLineMageMapper.findByDeadLineType(QdcyStandardsDict.DEAD_LINE_TYPE_0);
        //默认无过期时间
        if (ConverterUtil.isNotEmpty(deadLines)) {
            //期限
            Integer limitDays = deadLines.get(0).getLimitDays();
            if (ConverterUtil.isNotEmpty(limitDays) && limitDays > 0) {
                OffsetDateTime expiration = residueDate.plusHours(limitDays);
                detailsVo.setEndDate(expiration);
            }
        }

        return CustomUtils.result(detailsVo);
    }

    /**
     * 服务单日志
     */
    public ResultPoJo<SerOpreateInfoVo> findSerLog(SerGetPo serGetPo) {
        SerOpreateInfoVo serOpreateInfoVo = serListOpreateInfoMapper.findSerLog(serGetPo);
        return CustomUtils.result(serOpreateInfoVo);
    }

    /**
     * 修改价格
     */
    @Transactional
    public ResultPoJo<Object> savePrice(SerUpdatePricePo serUpdatePricePo) {
        //查询原价格
        SerListMage oldSerListMage = serListMageMapper.selectByPrimaryKey(serUpdatePricePo.getId());
        //修改价格
        SerListMage serListMage = new SerListMage();
        //计算总价
        serListMage.setTotalPrice(Optional.ofNullable(serUpdatePricePo.getPrice()).orElse(0D));
        Long serListId = serUpdatePricePo.getId();
        serListMage.setId(serListId);
        serListMage.preUpdate();
        serListMageMapper.updateByPrimaryKeySelective(serListMage);
        //插入日志
        DecimalFormat decimalFormat = CommodityService.df.get();
        String opreatContent = "商家修改价格，从" + decimalFormat.format(oldSerListMage.getTotalPrice()) + "修改为" + decimalFormat.format(serUpdatePricePo.getPrice());
        serListLog(opreatContent, serListId);
        //发送消息
        sendTpl(TIMNoticeConstants.TPL_KEY_SER_UPDATE_PRICE_TO_BUYER, serListId, oldSerListMage.getMembId());
        //记录服务单消息
        insertSerMgs(oldSerListMage.getMembId(), serListId, oldSerListMage.getSerListStateType());
        return CustomUtils.result();
    }

    /**
     * 插入操作日志
     * @param opreatContent 操作内容
     */
    @Transactional
    public void serListLog(String opreatContent, Long serListId) {
        //插入操作日志
        SerListOpreateInfo serListOpreateInfo = new SerListOpreateInfo();
        serListOpreateInfo.setOperator("商家");
        serListOpreateInfo.setOpreatContent(opreatContent);
        serListOpreateInfo.setOpreatDate(OffsetDateTime.now());
        serListOpreateInfo.setSerListId(serListId);
        serListOpreateInfo.preInsert();
        serListOpreateInfoMapper.insert(serListOpreateInfo);
    }

    /**
     * 修改预约信息
     * @param subscribePo 修改的信息
     */
    @Transactional
    public ResultPoJo<Object> saveSubscribe(SerUpdateSubscribePo subscribePo) {
        SerListMage serListMage = new SerListMage();
        //日期转换
        String serDate = subscribePo.getSerDate();
        serListMage.setSerDate(OffsetDateTime.parse(serDate.replace(".", "-") + "T00:00:00+00:00"));
        ConverterUtil.copyProperties(subscribePo, serListMage, "serDate", "serAreaProv", "serAreaCity", "serAreaCou");
        serListMage.setSerAreaProv(subscribePo.getSerAreaProvId());
        serListMage.setSerAreaCity(subscribePo.getSerAreaCityId());
        serListMage.setSerAreaCou(subscribePo.getSerAreaCouId());
        serListMageMapper.updateByPrimaryKeySelective(serListMage);
        SerListMage mage = serListMageMapper.selectByPrimaryKey(subscribePo.getId());
        //记录日志
        Long listMageId = serListMage.getId();
        Long membId = mage.getMembId();
        serListLog("商家修改预约信息", listMageId);
        //发送消息
        sendTpl(TIMNoticeConstants.TPL_KEY_SER_UPDATE_TO_BUYER, listMageId, membId);
        //记录服务单消息
        insertSerMgs(membId, listMageId, mage.getSerListStateType());
        return CustomUtils.result();
    }

    /**
     * 修改状态
     * @param serUpdateStatePo 状态
     */
    @Transactional
    public ResultPoJo<Object> saveState(SerUpdateStatePo serUpdateStatePo) {
        SerListMage serListMage = new SerListMage();
        ConverterUtil.copyProperties(serUpdateStatePo, serListMage);
        serListMageMapper.updateByPrimaryKeySelective(serListMage);
        //记录日志
        SerStateEnum stateEnum = SerStateEnum.findByState(serUpdateStatePo.getSerListStateType());
        stateEnum.setName(stateEnum.getName() + Optional.ofNullable(serUpdateStatePo.getSerListCancelReason()).orElse(""));
        serListLog(stateEnum.getName(), serUpdateStatePo.getId());

        SerListMage mage = serListMageMapper.selectByPrimaryKey(serUpdateStatePo.getId());
        Long listMageId = serListMage.getId();
        Long membId = mage.getMembId();
        //发送消息
        sendTpl(TIMNoticeConstants.TPL_KEY_SER_UPDATE_TO_BUYER, listMageId, membId);
        //记录服务单消息
        insertSerMgs(membId, listMageId, mage.getSerListStateType());
        return CustomUtils.result();
    }

    /**
     * 发送通知消息
     * @param tplKey key
     * @param serId 服务单id
     * @param rec 被通知用户id
     */
    private void sendTpl(String tplKey, Long serId, Long rec) {
        try {
            //通知内容
            HashMap<String, Object> dataModel = Maps.newHashMap();
            //前端根据这个字段可以去到服务单id
            HashMap<String, Object> payload = Maps.newHashMap();
            dataModel.put("serId", serId);
            payload.put("id", serId);
            ResultPoJo<Object> sendVo = timNoticeService.sendTpl(tplKey, dataModel, Lists.newArrayList(rec.toString()), payload);
            LoggerUtil.error("【发送消息成功】", ConverterUtil.gson.toJson(sendVo));
        }catch (Exception e) {
            LoggerUtil.error("【发送消息失败】", e);
        }
    }

    /**
     * 记录服务单消息
     * @param rec 接收人
     * @param serListId 服务单id
     * @param stateType 服务单类型
     */
    @Transactional
    public void insertSerMgs(Long rec, Long serListId, String stateType) {
        //消息发送成功则记录消息到消息表
        SerListInformation serListInformation = new SerListInformation();
        serListInformation.setIfShow(QdcyStandardsDict.IF_SHOW_0);
        serListInformation.setMembId(rec);
        serListInformation.setInformationDate(OffsetDateTime.now());
        serListInformation.setSerListId(serListId);
        serListInformation.setSerListStateType(stateType);
        serListInformation.setContent(serListId.toString());
        serListInformation.preInsert();
        serListInformationMapper.insert(serListInformation);
    }

}
