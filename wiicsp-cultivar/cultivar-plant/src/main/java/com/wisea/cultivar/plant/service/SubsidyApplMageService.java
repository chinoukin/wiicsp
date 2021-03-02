package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;

import com.wisea.cultivar.plant.entity.SubsidyApplMage;
import com.wisea.cultivar.plant.entity.SubsidyExamRecd;
import com.wisea.cultivar.plant.mapper.*;
import com.wisea.cultivar.plant.po.SerListMagePageListPo;
import com.wisea.cultivar.plant.po.SubsidyApplMagePageListPo;
import com.wisea.cultivar.plant.po.SubsidyDeclarePo;
import com.wisea.cultivar.plant.vo.CommVo;
import com.wisea.cultivar.plant.vo.SerListMagePageListVo;
import com.wisea.cultivar.plant.vo.SubsidyApplMageInfoVo;
import com.wisea.cultivar.plant.vo.SubsidyApplMagePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className subsidyApplMageService
 * @date 2020/08/11 16:30:13
 * @Description
 */
@Service
public class SubsidyApplMageService extends BaseService {
    @Autowired
    private SubsidyApplMageMapper mapper;
    @Autowired
    private CheckFileMapper checkFileMapper;
    @Autowired
    private BuySproutInfoMapper buySproutInfoMapper;
    @Autowired
    private ZhfwMembInfoMapper zhfwMembInfoMapper;
    @Autowired
    private SerListMageMapper serListMageMapper;
    @Autowired
    private SubsidyExamRecdMapper subsidyExamRecdMapper;
    /**
     * @author wbf-code-generator
     * @date 2020/08/11 16:30:13
     * @Description 分页查询subsidyApplMage
     */
    public ResultPoJo<Page<SubsidyApplMagePageListVo>> findPageList(SubsidyApplMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<SubsidyApplMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<SubsidyApplMagePageListVo> page = po.getPage();
		List<SubsidyApplMagePageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/11 16:30:13
     * @Description 逻辑删除subsidyApplMage
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SubsidyApplMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(SubsidyApplMage.DEL_FLAG_DELETE);
			entity.preUpdate();
			mapper.updateByPrimaryKey(entity);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/11 16:30:13
     * @Description 新增或修改subsidyApplMage
     */
    @Transactional(readOnly = false)
    public ResultPoJo saveOrUpdateSubsidy(SubsidyDeclarePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdateSubsidy】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

        if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			SubsidyApplMage entity = mapper.selectByPrimaryKey(po.getId());

            if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.setSubsidyApplStateType("0");
				entity.setMembId(po.getMembId());
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
                checkFileMapper.deleteByMageId(po.getId());
                buySproutInfoMapper.deleteByMageId(po.getId());
                this.save(po,entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增
            //补贴申请管理
            SubsidyApplMage entity = new SubsidyApplMage();
            BeanUtils.copyProperties(po, entity);
            entity.setApplDate(OffsetDateTime.now());
            entity.setSubsidyApplStateType("0");
            entity.setMembId(po.getMembId());
            entity.preInsert();
            mapper.insert(entity);
            this.save(po, entity);

        }
		return resultPoJo;
    }
    //保存图片和购苗信息
    private void save(SubsidyDeclarePo po, SubsidyApplMage entity) {
        //验收材料
        Optional.ofNullable(po).ifPresent(p->{
            p.getCheckFiles().stream().forEach(e->{
                e.setSubsidyApplMageId(entity.getId());
                e.preInsert();
                checkFileMapper.insert(e);
            });
        });

        //添加购苗审核记录
        SubsidyExamRecd subsidyExamRecd = new SubsidyExamRecd();
        subsidyExamRecd.setSubsidyApplMageId(entity.getId());
        subsidyExamRecd.setOperatDate(OffsetDateTime.now());
        subsidyExamRecd.setOperator(entity.getEntpPersonalName());
        subsidyExamRecd.setOperatorContent("提交申请");
        subsidyExamRecd.preInsert();
        subsidyExamRecdMapper.insert(subsidyExamRecd);
        //购苗信息
        po.getBuySproutInfos().stream().forEach(buySproutInfo->{
            buySproutInfo.setSubsidyApplMageId(entity.getId());
            buySproutInfo.preInsert();
            buySproutInfoMapper.insert(buySproutInfo);
        });

    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/11 16:30:13
     * @Description 查看补助的详情
     * @param po
     */
    @Transactional
    public ResultPoJo<SubsidyApplMageInfoVo> showSubsidyinfo(CommVo po) {
        LoggerUtil.infoWithContext("【showSubsidyinfo】查询详细信息：", po);
        ResultPoJo<SubsidyApplMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SubsidyApplMageInfoVo vo = mapper.showSubsidyinfo(po);
        //获取采购信息
		if(ConverterUtil.isNotEmpty(vo)){
            List<SerListMagePageListVo> sv = new ArrayList<>();
            List<Long> buySproutInfos = vo.getSerListId();
            Optional.ofNullable(buySproutInfos).ifPresent(b ->{
                b.stream().forEach(buySproutInfo ->{
                    SerListMagePageListPo serListMagePageListPo = new SerListMagePageListPo();
                    serListMagePageListPo.setMembId(po.getMembId());
                    serListMagePageListPo.setSerListId(buySproutInfo);
                    List<SerListMagePageListVo> recordPageList = serListMageMapper.findRecordPageList(serListMagePageListPo);
                    if (!(CollectionUtils.isEmpty(recordPageList))) {
                        SerListMagePageListVo serListMagePageListVo = recordPageList.get(0);
                        sv.add(serListMagePageListVo);
                    }

                });
            });
            vo.setSerListMagePageListVos(sv);
            resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }


}
