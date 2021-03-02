package com.wisea.cultivar.bigdata.service;


import com.wisea.cloud.common.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * JydzMageService
 * 交易递增配置 Service
 * 2019/12/02 14:39:38
 */
@Service
public class JydzMageService extends BaseService {
    /*@Autowired
    protected JydzMageMapper jydzMageMapper;
    @Autowired(required = false)
    private QuartzManager quartzManager;
    @Autowired
    private TimerTaskSchedule timerTaskSchedule;

    *//**
     * @Author jirg
     * @Date 2019/12/2 15:21
     * @Description 获取交易递增配置
     **//*
    public ResultPoJo<JydzMageListVo> getJydzMage() {
        ResultPoJo<JydzMageListVo> result = new ResultPoJo<>();
        List<JydzMageListVo> list = jydzMageMapper.findList(new JydzMageListPo());
        if (ConverterUtil.isNotEmpty(list) && list.size() > 0){
            result.setResult(list.get(0));
        }
        return result;
    }

    *//**
     * @Author jirg
     * @Date 2019/12/2 15:21
     * @Description 新增或修改交易递增配置
     **//*
    public ResultPoJo<Object> saveOrUpdate(JydzMageUpdatePo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        if(ConverterUtil.isEmpty(po.getId())){
            //新增
            List<JydzMageListVo> list = jydzMageMapper.findList(new JydzMageListPo());
            //判断数据库中是否有数据，保证数据只有一条
            JydzMage jydzMage = new JydzMage();
            if (ConverterUtil.isNotEmpty(list) && list.size() > 0){
                JydzMageListVo jydzMageListVo = list.get(0);
                jydzMage.preInsert();
                po.setId(jydzMageListVo.getId());
                BeanUtils.copyProperties(po, jydzMage);
                jydzMageMapper.updateByPrimaryKey(jydzMage);
                updateJob(jydzMage);
            }else{
                BeanUtils.copyProperties(po, jydzMage);
                jydzMage.preInsert();
                jydzMageMapper.insert(jydzMage);
                updateJob(jydzMage);
            }
        }else{
            //修改
            JydzMage jydzMage = jydzMageMapper.selectByPrimaryKey(po.getId());
            if(ConverterUtil.isNotEmpty(jydzMage)){
                BeanUtils.copyProperties(po, jydzMage);
                jydzMage.preUpdate();
                jydzMageMapper.updateByPrimaryKeySelective(jydzMage);
                updateJob(jydzMage);
            }else{
                result.setCode(ConstantCodeMsg.ERR_004);
                result.setMsg(ConstantCodeMsg.MSG_004);
            }
        }
        return result;
    }

    *//**
     * @Author jirg
     * @Date 2019/12/2 15:35
     * @Description 重新累计
     **//*
    public ResultPoJo<Object> reloadAccumulate(JydzReloadAccumulatePo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        JydzMage jydzMage = jydzMageMapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(jydzMage)){
            if(po.getPlaceOriginType().equals(DictConstants.PLACE_ORIGIN_TYPE_0)){
                jydzMage.setYdiJe(0D);
            }else{
                jydzMage.setGwYdiJe(0D);
            }
            jydzMage.preUpdate();
            jydzMageMapper.updateByPrimaryKeySelective(jydzMage);
        }else{
            result.setCode(ConstantCodeMsg.ERR_004);
            result.setMsg(ConstantCodeMsg.MSG_004);
        }
        return result;
    }

    *//**
     * @Author jirg
     * @Date 2019/12/6 18:24
     * @Description 更新定时任务
     **//*
    private void updateJob(JydzMage jydzMage){
        if(jydzMage.getSfkqFlag().equals(DictConstants.SFKQ_FLAG_0)){
            //新建定时任务
            DomesticTransactionsIncreasingJob domesticJob = new DomesticTransactionsIncreasingJob();
            domesticJob.setIntervalInSeconds(jydzMage.getZddzDate());
            timerTaskSchedule.addJob(domesticJob);
        }else{
            //删除定时任务
            quartzManager.removeJob(DomesticTransactionsIncreasingJob.JOB_NAME, DomesticTransactionsIncreasingJob.JOB_GROUP_NAME);
        }

        if(jydzMage.getGwSfkqFlag().equals(DictConstants.SFKQ_FLAG_0)){
            //新建定时任务
            ForeignTransactionsIncreasingJob foreignJob = new ForeignTransactionsIncreasingJob();
            foreignJob.setIntervalInSeconds(jydzMage.getGwZddzDate());
            timerTaskSchedule.addJob(foreignJob);
        }else{
            //删除定时任务
            quartzManager.removeJob(ForeignTransactionsIncreasingJob.JOB_NAME, ForeignTransactionsIncreasingJob.JOB_GROUP_NAME);
        }
    }*/
}
