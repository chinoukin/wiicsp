package com.wisea.cultivar.plant.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.constants.TIMNoticeConstants;
import com.wisea.cultivar.common.dao.DeadLineMageMapper;
import com.wisea.cultivar.common.dao.OrdCancelReasonMageMapper;
import com.wisea.cultivar.common.entity.DeadLineMage;
import com.wisea.cultivar.common.service.TIMNoticeService;
import com.wisea.cultivar.common.vo.trade.OrdCancelReasonMageListVo;
import com.wisea.cultivar.plant.entity.SerListMage;
import com.wisea.cultivar.plant.entity.SerListOpreateInfo;
import com.wisea.cultivar.plant.entity.ZhfwCommPubInfo;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.mapper.*;
import com.wisea.cultivar.plant.po.MembPo;
import com.wisea.cultivar.plant.po.SerListMagePageListPo;
import com.wisea.cultivar.plant.po.SerListMagePo;
import com.wisea.cultivar.plant.po.SerListMageSavePo;
import com.wisea.cultivar.plant.utils.RandomUtil;
import com.wisea.cultivar.plant.vo.*;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SerListMageService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class SerListMageService extends BaseService {
    @Autowired
    private SerListMageMapper mapper;
    @Autowired
    private ZhfwMembInfoMapper zhfwMembInfoMapper;
    @Autowired
    private ZhfwCommPictureMapper zhfwCommPictureMapper;
    @Autowired
    private ZhfwCommPubInfoMapper zhfwCommPubInfoMapper;
    @Autowired
    private SerListOpreateInfoMapper serListOpreateInfoMapper;
    @Autowired
    private OrdCancelReasonMageMapper ordCancelReasonMageMapper;
    @Autowired
    private DeadLineMageMapper deadLineMageMapper;
    @Autowired
    private TIMNoticeService  tIMNoticeService;
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询服务单列表 ,包含搜索 ser_list_state_type 0：待确认 1：待服务 2：服务中 3：已取消
     */
    public ResultPoJo<Page<SerListMagePageListVo>> findPageList(SerListMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<SerListMagePageListVo>> resultPoJo = new ResultPoJo<>();
        Page<SerListMagePageListVo> page = po.getPage();
        List<SerListMagePageListVo> list = mapper.findPageList(po);
        Optional.ofNullable(list).ifPresent(li->{
                    li.stream().forEach(l->{
                        //查询产品图片
                        List<ZhfwCommPictureInfoVo> zhfwCommPictureInfoVo = zhfwCommPictureMapper.findByCommPubId(l.getCommPubId());
                        if(ConverterUtil.isNotEmpty(zhfwCommPictureInfoVo)){
                            l.setUrl(zhfwCommPictureInfoVo.get(0).getUrl());
                        }
                    });
                }
           );
        page.setList(list);
        resultPoJo.setResult(page);
        resultPoJo.setCode(ConstantCodeMsg.ERR_000);
        resultPoJo.setMsg(ConstantCodeMsg.MSG_000);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description type 0:修改服务时间  1:取消服务单 2:完成服务单
     */
    public ResultPoJo updSerListMage(SerListMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>();
        //查询服务单信息
        SerListMage serListMage = mapper.selectByPrimaryKey(po.getId());
        //操作类型
        String type = po.getType();
        Optional.ofNullable(serListMage).ifPresent(s -> {
            //修改服务时间
            if ("0".equals(type)) {
                //修改服务时间
                s.setSerDate(po.getSerDate());
                s.preUpdate();
                mapper.updateByPrimaryKeySelective(s);
            }
            //取消服务单
            if ("1".equals(type)) {
                //取消服务单[待确定 和待服务状态可取消]
                s.setSerListStateType("3");
                s.setSerListCancelReason(po.getSerListCancelReason());
                s.preUpdate();
                mapper.updateByPrimaryKeySelective(s);
                //新增服务单操作日志
                SerListOpreateInfo serListOpreateInfo = new SerListOpreateInfo();
                serListOpreateInfo.setSerListId(po.getId());
                serListOpreateInfo.setOperator("买家");
                serListOpreateInfo.setOpreatDate(OffsetDateTime.now());
                serListOpreateInfo.setOpreatContent("取消服务单");
                serListOpreateInfo.preInsert();
                serListOpreateInfoMapper.insert(serListOpreateInfo);
                /*********给服务商发 买家手动取消通知**********/
                this.sendTpl(TIMNoticeConstants.TPL_KEY_SER_CANCEL_TO_SALLER,po.getId(), getMembId(serListMage.getCommPubId()));
            }
            //完成服务单
            if ("2".equals(type)) {
                //完成服务单
                //已完成
                s.setSerListStateType("4");
                s.preUpdate();
                mapper.updateByPrimaryKeySelective(s);
                //新增服务单操作日志
                SerListOpreateInfo serListOpreateInfo = new SerListOpreateInfo();
                serListOpreateInfo.setSerListId(po.getId());
                serListOpreateInfo.setOperator("买家");
                serListOpreateInfo.setOpreatDate(OffsetDateTime.now());
                serListOpreateInfo.setOpreatContent("完成服务单");
                serListOpreateInfo.preInsert();
                serListOpreateInfoMapper.insert(serListOpreateInfo);
                /*********给服务商发 买家手动完成通知**********/
                this.sendTpl(TIMNoticeConstants.TPL_KEY_SER_OVER_TO_SALLER,po.getId(), getMembId(serListMage.getCommPubId()));
            }
        });
        resultPoJo.setCode(ConstantCodeMsg.ERR_000);
        resultPoJo.setMsg(ConstantCodeMsg.MSG_000);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询服务单详细信息SerListMage
     */
    public ResultPoJo<SerListMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<SerListMageInfoVo> resultPoJo = new ResultPoJo<>();
        //服务单id
        Long id = po.getId();
        //服务单相关信息 ,商品信息 ，商家信息
        SerListMageInfoVo serListMageInfoVo = mapper.findInfo(id);
        Optional.ofNullable(serListMageInfoVo).ifPresent(s -> {
            List<ZhfwCommPictureInfoVo> zhfwCommPictureInfoVo = zhfwCommPictureMapper.findByCommPubId(s.getCommPubId());
            if(ConverterUtil.isNotEmpty(zhfwCommPictureInfoVo)){
                s.setUrl(zhfwCommPictureInfoVo.get(0).getUrl());
            }
            //查询自动取消和自动确认时间限制
            if ("0".equals(s.getSerListStateType())||"1".equals(s.getSerListStateType())) {
                //待确认状态返回 自动取消小时限制
                List<DeadLineMage> deadLineType = deadLineMageMapper.findByDeadLineType("0");
                if (ConverterUtil.isNotEmpty(deadLineType)) {
                    s.setLimitDays(deadLineType.get(0).getLimitDays());
                }
            }
            if ("2".equals(s.getSerListStateType())) {
                //服务中状态返回 自动确认天数限制
                List<DeadLineMage> deadLineType = deadLineMageMapper.findByDeadLineType("1");
                if (ConverterUtil.isNotEmpty(deadLineType)) {
                    s.setLimitDays(deadLineType.get(0).getLimitDays());
                }
            }
            //服务单日志
            List<SerListOpreateInfoInfoVo> serOperateInfoList = serListOpreateInfoMapper.findByserListId(id);
            s.setSerOperateList(serOperateInfoList);
        });

        resultPoJo.setResult(serListMageInfoVo);
        resultPoJo.setCode(ConstantCodeMsg.ERR_000);
        resultPoJo.setMsg(ConstantCodeMsg.MSG_000);
        return resultPoJo;
    }

    /**
     * 查询不同状态服务单数量
     *
     * @return
     */
    public ResultPoJo<List<SerListStateTypeCountVo>> getSerListStateType(MembPo po) {

        ResultPoJo<List<SerListStateTypeCountVo>> resultPoJo = new ResultPoJo<>();
        //查询不同状态服务单数量
        List<SerListStateTypeCountVo> serListStateTypeCount = mapper.getSerListStateType(po.getMembId());
        resultPoJo.setResult(serListStateTypeCount);
        resultPoJo.setCode(ConstantCodeMsg.ERR_000);
        resultPoJo.setMsg(ConstantCodeMsg.MSG_000);
        return resultPoJo;

    }

    /**
     * 获取服务单取消原因
     *
     * @return
     */
    public ResultPoJo<List<OrdCancelReasonMageListVo>> getOrdCancelReason() {
        ResultPoJo<List<OrdCancelReasonMageListVo>> resultPoJo = new ResultPoJo();
        List<OrdCancelReasonMageListVo> allReason = ordCancelReasonMageMapper.findAllReason();
        resultPoJo.setResult(allReason);
        resultPoJo.setCode(ConstantCodeMsg.ERR_000);
        resultPoJo.setMsg(ConstantCodeMsg.MSG_000);
        return resultPoJo;
    }


    /**
     * 新增服务单
     *
     * @param po
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo<SerListMage> addSerListMagePo(SerListMageSavePo po) {
        ResultPoJo<SerListMage> resultPoJo = new ResultPoJo(ConstantCodeMsg.ERR_000);
        //获取当前登录的用户信息
        User user = SystemUtils.getUser();
        //获取当前登录的用户会员信息
        ZhfwMembInfo zhfwMembInfo = zhfwMembInfoMapper.selectByPrimaryKey(user.getId());
        if (ConverterUtil.isEmpty(zhfwMembInfo)) {//用户信息不存在
            resultPoJo.setCode(ConstantCodeMsg.ERR_505);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_505);
            return resultPoJo;
        }
        po.setMembId(user.getId());
        ZhfwCommPubInfo zhfwCommPubInfo = zhfwCommPubInfoMapper.selectByPrimaryKey(po.getCommPubId());
        if (ConverterUtil.isEmpty(zhfwCommPubInfo)) {//商品信息不存在
            resultPoJo.setCode(ConstantCodeMsg.ERR_386);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_386);
            return resultPoJo;
        }
        if (user.getId().equals(zhfwCommPubInfo.getMembId())) {// 不能购买自己的商品
            resultPoJo.setCode(ConstantCodeMsg.ERR_384);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_384);
            return resultPoJo;
        }

        SerListMage serListMage = new SerListMage();
        BeanUtils.copyProperties(po, serListMage);
        serListMage.preInsert();


        //服务编号 生成10位不重复的随机
      /*  Long num = mapper.findSerListNo();
        Long aLong = Optional.ofNullable(num).orElse(10000000000L);
        aLong++;*/

        serListMage.setSerListNo(RandomUtil.getFixLenthString(10));
        serListMage.setSubscribeDate(OffsetDateTime.now());
//        serListMage.setSerListNo(CodeUtils.generateSettleBillCode());
        mapper.insert(serListMage);
        //新增服务单操作日志
        SerListOpreateInfo serListOpreateInfo = new SerListOpreateInfo();
        serListOpreateInfo.setSerListId(serListMage.getId());
        serListOpreateInfo.setOperator("买家");
        serListOpreateInfo.setOpreatDate(OffsetDateTime.now());
        serListOpreateInfo.setOpreatContent("新增服务单");
        serListOpreateInfo.preInsert();
        serListOpreateInfoMapper.insert(serListOpreateInfo);
        resultPoJo.setResult(serListMage);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 采购记录显示分页查询列表
     */
    public ResultPoJo<Page<SerListMagePageListVo>> findRecordPageList(SerListMagePageListPo po) {
        LoggerUtil.infoWithContext("【findRecordPageList】分页查询列表：", po);
        ResultPoJo<Page<SerListMagePageListVo>> resultPoJo = new ResultPoJo<>();
        Page<SerListMagePageListVo> page = po.getPage();
        //会员主键
        po.setMembId(po.getMembId());
        List<SerListMagePageListVo> list = mapper.findRecordPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        resultPoJo.setCode(ConstantCodeMsg.ERR_000);
        resultPoJo.setMsg(ConstantCodeMsg.MSG_000);
        return resultPoJo;
    }

    /**
     * 服务单取消的定时任务
     */
    public void cancleSerListMageTask() {
        //待确认状态返回 自动取消小时限制
        List<DeadLineMage> deadLineTypeHour = deadLineMageMapper.findByDeadLineType("0");
        //查询 待服务待确认状态下，到时间自动取消
        List<SerListMageInfoVo> serListStateTypeHourList = mapper.findCancelBySerListStateType();
        Optional.ofNullable(serListStateTypeHourList).ifPresent(s -> {
            s.stream().forEach(e -> {
                //得到服务单下单时间
                OffsetDateTime subscribeDate = e.getSubscribeDate();
                if (ConverterUtil.isNotEmpty(deadLineTypeHour)) {
                    int limitHour = deadLineTypeHour.get(0).getLimitDays();
                    if (limitHour > 0) {
                        subscribeDate = subscribeDate.plusHours(limitHour);
                        OffsetDateTime nowDate = OffsetDateTime.now();
                        if (nowDate.compareTo(subscribeDate) >= 0) {
                            //自动取消
                            Long id = e.getId();
                            SerListMage serListMage = mapper.selectByPrimaryKey(id);
                            serListMage.setSerListStateType("3");//改为已取消
                            serListMage.setSerListCancelReason("超时取消");
                            serListMage.preUpdate();
                            mapper.updateByPrimaryKeySelective(serListMage);
                            //新增操作日志
                            SerListOpreateInfo serListOpreateInfo = new SerListOpreateInfo();
                            serListOpreateInfo.setSerListId(id);
                            serListOpreateInfo.setOperator("系统");
                            serListOpreateInfo.setOpreatDate(OffsetDateTime.now());
                            serListOpreateInfo.setOpreatContent("超时取消");
                            serListOpreateInfo.preInsert();
                            serListOpreateInfoMapper.insert(serListOpreateInfo);
                            //给买家 和卖家 都发送系统自动取消通知
                            //卖家
                            this.sendTpl(TIMNoticeConstants.TPL_KEY_SER_CANCEL_TIMEOUT_TO_SALLER,id, getMembId(serListMage.getCommPubId()));
                            //买家
                            this.sendTpl(TIMNoticeConstants.TPL_KEY_SER_CANCEL_TIMEOUT_TO_BUYER,id, serListMage.getMembId());
                        }
                    }
                }
            });
        });
    }

    /**
     * 服务单自动确认到期完成定时任务
     */
    public void confirmSerListMageTask() {
        //服务中状态返回 自动确认天限制
        List<DeadLineMage> deadLineTypeDay = deadLineMageMapper.findByDeadLineType("1");
        //查询服务中状态下，到时间自动确认完成
        List<SerListMageInfoVo> serListStateTypeDayList = mapper.findBySerListStateType("2");
        Optional.ofNullable(serListStateTypeDayList).ifPresent(s -> {
            s.stream().forEach(e -> {
                //得到服务单服务时间
                OffsetDateTime serDate = e.getSerDate();
                if (ConverterUtil.isNotEmpty(serDate)) {
                    int limitDays = deadLineTypeDay.get(0).getLimitDays();
                    if (limitDays > 0) {
                        serDate = serDate.plusDays(limitDays);
                        OffsetDateTime nowDate = OffsetDateTime.now();
                        if (nowDate.compareTo(serDate) >= 0) {
                            //自动确认完成
                            Long id = e.getId();
                            SerListMage serListMage = mapper.selectByPrimaryKey(id);
                            serListMage.setSerListStateType("4");//改为已确认
                            serListMage.preUpdate();
                            mapper.updateByPrimaryKeySelective(serListMage);
                            //新增操作日志
                            SerListOpreateInfo serListOpreateInfo = new SerListOpreateInfo();
                            serListOpreateInfo.setSerListId(id);
                            serListOpreateInfo.setOperator("系统");
                            serListOpreateInfo.setOpreatDate(OffsetDateTime.now());
                            serListOpreateInfo.setOpreatContent("超时自动确认完成");
                            serListOpreateInfo.preInsert();
                            serListOpreateInfoMapper.insert(serListOpreateInfo);
                            //给买家 和卖家 都发送系统自动取消通知
                            //卖家
                            this.sendTpl(TIMNoticeConstants.TPL_KEY_SER_OVER_TIMEOUT_TO_SALLER,id, getMembId(serListMage.getCommPubId()));
                            //买家
                            this.sendTpl(TIMNoticeConstants.TPL_KEY_SER_OVER_TIMEOUT_TO_BUYER,id, serListMage.getMembId());
                        }
                    }
                }
            });
        });
    }
    /*
    * 发通知 买家手动取消服务单
    * */
    void   sendTpl(String tplKey ,long serId,long membId){
        HashMap<String,Object> dataModel = new HashMap<String,Object>();
        dataModel.put("serId",serId);
        List<String> recList=Lists.newArrayList();
        recList.add(String.valueOf(membId));
        HashMap<String,Object> payload = new HashMap<String,Object>();
        payload.put("id",serId);
        tIMNoticeService.sendTpl(tplKey,dataModel,recList,payload);
    }
    //获取商家会员id
    Long getMembId(long commPubId){
        ZhfwCommPubInfo zhfwCommPubInfo = zhfwCommPubInfoMapper.selectByPrimaryKey(commPubId);
        if(ConverterUtil.isNotEmpty(zhfwCommPubInfo)){
            return zhfwCommPubInfo.getMembId();
        }
        return null;
    }
}

