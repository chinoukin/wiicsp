package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.constants.DictConstants;
import com.wisea.cultivar.common.dao.FeedBackMageMapper;
import com.wisea.cultivar.common.entity.FeedBackMage;
import com.wisea.cultivar.common.entity.MembBaseInfo;
import com.wisea.cultivar.common.po.FeedBackMagePageListPo;
import com.wisea.cultivar.common.po.FeedBackMagePo;
import com.wisea.cultivar.common.utils.MembUtils;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

import com.wisea.cultivar.common.vo.FeedBackMageExportVo;
import com.wisea.cultivar.common.vo.FeedBackMageInfoVo;
import com.wisea.cultivar.common.vo.FeedBackMagePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className FeedBackMageService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class FeedBackMageService extends BaseService {
    @Autowired
    private FeedBackMageMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FeedBackMage
     */
    public ResultPoJo<Page<FeedBackMagePageListVo>> findPageList(FeedBackMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<FeedBackMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<FeedBackMagePageListVo> page = po.getPage();
        List<FeedBackMagePageListVo> list = mapper.findListByCond(po);

        //逻辑处理查询条件_状态、来源、前缀时间、后缀时间
        boolean status = Optional.ofNullable(po.getProcesStatusType())
                .filter(ConverterUtil::isNotEmpty)
                .isPresent();
        boolean source = Optional.ofNullable(po.getSourceType())
                .filter(ConverterUtil::isNotEmpty)
                .isPresent();
        boolean frontDate = Optional.ofNullable(po.getOprdateFront())
                .filter(ConverterUtil::isNotEmpty)
                .isPresent();
        boolean backDate = Optional.ofNullable(po.getOprdateBack())
                .filter(ConverterUtil::isNotEmpty)
                .isPresent();

        //如果存在
        if (status) {
            list = list.stream()
                    .filter(x -> x.getProcesStatusType().equals(po.getProcesStatusType()))
                    .collect(Collectors.toList());
        }
        if (source) {
            list = list.stream()
                    .filter(x -> x.getSourceType().equals(po.getSourceType()))
                    .collect(Collectors.toList());
        }
        if (frontDate && backDate) {
            list = list.stream()
                    .map(x->{
                        x.getOpreatDate().isAfter(po.getOprdateFront());
                        x.getOpreatDate().isBefore(po.getOprdateBack());
                        return x;
                    })
                    .collect(Collectors.toList());
        }
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除FeedBackMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        FeedBackMage entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(FeedBackMage.DEL_FLAG_DELETE);
            entity.preUpdate();
            mapper.updateByPrimaryKey(entity);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改FeedBackMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(FeedBackMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            FeedBackMage entity = mapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(entity)) {
                BeanUtils.copyProperties(po, entity);
                entity.preUpdate();
                mapper.updateByPrimaryKeySelective(entity);
            } else {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        } else {
            //新增
            FeedBackMage entity = new FeedBackMage();
            BeanUtils.copyProperties(po, entity);

            User user = SystemUtils.getUser();
            MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
            entity.setLoginName(membBaseInfo.getLoginName());
            entity.setName(membBaseInfo.getContName());
            entity.setTel(membBaseInfo.getRegistTel());
            entity.setEntpName(membBaseInfo.getAuthName());
            entity.setProcesStatusType(DictConstants.PROCES_STATUS_TYPE_1);


            entity.preInsert();
            mapper.insert(entity);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息FeedBackMage
     */
    public ResultPoJo<FeedBackMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<FeedBackMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        FeedBackMageInfoVo vo = mapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 导出
     */
    public List<FeedBackMageExportVo> export() {

        List<FeedBackMagePageListVo> pageList = mapper.findPageList(new FeedBackMagePageListPo());

        List<FeedBackMageExportVo> collect = pageList.stream().map((x) -> {
            FeedBackMageExportVo backVo = new FeedBackMageExportVo();
            if (x.getProblemType().equals("0")){
                x.setProblemType("功能问题");
            }
            else if (x.getProblemType().equals("1")){
                x.setProblemType("产品建议");
            }
            else if (x.getProblemType().equals("2")){
                x.setProblemType("账号问题");
            }
            else if (x.getProblemType().equals("3")){
                x.setProblemType("其他问题");
            }
            if (x.getProcesStatusType().equals("0")){
                x.setProcesStatusType("已处理");
            }else if (x.getProcesStatusType().equals("1")){
                x.setProcesStatusType("未处理");
            }
            ConverterUtil.copyProperties(x, backVo);
            return backVo;
        }).collect(Collectors.toList());

        return collect;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo deal(FeedBackMagePo po) {
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        FeedBackMage feedBackMage = mapper.selectByPrimaryKey(po.getId());
        if (feedBackMage == null) {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
            return resultPoJo;
        }
        if (feedBackMage.getProcesStatusType().equals(DictConstants.PROCES_STATUS_TYPE_0)) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("已经处理过该反馈");
            return resultPoJo;
        }
        feedBackMage.setProcesStatusType(DictConstants.PROCES_STATUS_TYPE_0);
        feedBackMage.setOpreatContent(po.getOpreatContent());
        feedBackMage.setOpreatDate(OffsetDateTime.now());
        feedBackMage.setOperator(SystemUtils.getUser().getId().toString());
        feedBackMage.preUpdate();


        mapper.updateByPrimaryKeySelective(feedBackMage);

        return resultPoJo;
    }
}
