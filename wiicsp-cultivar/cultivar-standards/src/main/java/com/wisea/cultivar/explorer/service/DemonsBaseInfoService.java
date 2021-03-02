package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.entity.DemonsBaseInfo;
import com.wisea.cultivar.explorer.mapper.DemonsBaseInfoMapper;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.explorer.vo.DemonsBaseInfoGetVo;
import com.wisea.cultivar.explorer.vo.DemonsBaseInfoListVo;
import java.util.List;

import com.wisea.cultivar.explorer.vo.DemonsBaseIntroduceListVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DemonsBaseInfoService
 * 示范基地信息 Service
 * 2020/08/11 13:21:46
 */
@Service
public class DemonsBaseInfoService extends BaseService {
    @Autowired
    protected DemonsBaseInfoMapper demonsBaseInfoMapper;
    @Autowired
    protected DemonsBaseIntroduceService introduceService;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<DemonsBaseInfoListVo>> findPage(DemonsBaseInfoPagePo demonsBaseInfoPagePo) {
        ResultPoJo<Page<DemonsBaseInfoListVo>> result = new ResultPoJo<>();
        Page<DemonsBaseInfoListVo> page = demonsBaseInfoPagePo.getPage();
        List<DemonsBaseInfoListVo> list = demonsBaseInfoMapper.findPage(demonsBaseInfoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<DemonsBaseInfoListVo>> findList(DemonsBaseInfoListPo demonsBaseInfoListPo) {
        ResultPoJo<List<DemonsBaseInfoListVo>> result = new ResultPoJo<>();
        result.setResult(demonsBaseInfoMapper.findList(demonsBaseInfoListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<DemonsBaseInfoGetVo> get(DemonsBaseInfoGetPo demonsBaseInfoGetPo) {
        ResultPoJo<DemonsBaseInfoGetVo> result = new ResultPoJo<>();
        DemonsBaseInfo entity = demonsBaseInfoMapper.selectByPrimaryKey(demonsBaseInfoGetPo.getId());
        DemonsBaseInfoGetVo vo = new DemonsBaseInfoGetVo();
        ConverterUtil.copyProperties(entity, vo);
        final ResultPoJo<List<DemonsBaseIntroduceListVo>> serviceList = introduceService.findList(new DemonsBaseIntroduceListPo(demonsBaseInfoGetPo.getId()));
        final List<DemonsBaseIntroduceListVo> baseIntroduceListVos = serviceList.getResult();
        if( baseIntroduceListVos.size() == 0 ){
            DemonsBaseIntroduceListVo introduceListVo = new DemonsBaseIntroduceListVo();
            introduceListVo.setTitle("基地信息介绍");
            introduceListVo.setContent("");
            introduceListVo.setSort(0);
            baseIntroduceListVos.add(introduceListVo);
        }
        vo.setIntroduceList(baseIntroduceListVos);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResultPoJo<Object> insert(DemonsBaseInfoInsertPo demonsBaseInfoInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        DemonsBaseInfo demonsBaseInfo = new DemonsBaseInfo();
        ConverterUtil.copyProperties(demonsBaseInfoInsertPo, demonsBaseInfo);
        demonsBaseInfo.preInsert();
        if(StringUtils.isNotBlank(demonsBaseInfoInsertPo.getJdWd())){
            demonsBaseInfo.setJd(demonsBaseInfoInsertPo.getJd());
            demonsBaseInfo.setWd(demonsBaseInfoInsertPo.getWd());
        }
        demonsBaseInfoMapper.insert(demonsBaseInfo);
        if(null != demonsBaseInfoInsertPo.getIntroduceList() && demonsBaseInfoInsertPo.getIntroduceList().size()>0){
            final List<DemonsBaseIntroduceInsertPo> introduceList = demonsBaseInfoInsertPo.getIntroduceList();
            for (DemonsBaseIntroduceInsertPo introduceInsertPo : introduceList) {
                introduceInsertPo.setDemonsBaseId(demonsBaseInfo.getId());
                introduceService.insert(introduceInsertPo);
            }
        }
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(DemonsBaseInfoUpdatePo demonsBaseInfoUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        DemonsBaseInfo demonsBaseInfo = new DemonsBaseInfo();
        ConverterUtil.copyProperties(demonsBaseInfoUpdatePo, demonsBaseInfo);
        demonsBaseInfo.preUpdate();
        if(StringUtils.isNotBlank(demonsBaseInfoUpdatePo.getJdWd())){
            demonsBaseInfo.setJd(demonsBaseInfoUpdatePo.getJd());
            demonsBaseInfo.setWd(demonsBaseInfoUpdatePo.getWd());
        }else{
            demonsBaseInfo.setJd(Double.valueOf("0"));
            demonsBaseInfo.setWd(Double.valueOf("0"));
        }
        demonsBaseInfoMapper.updateByPrimaryKeySelective(demonsBaseInfo);
        introduceService.delIntroduce(demonsBaseInfo.getId());
        if(null != demonsBaseInfoUpdatePo.getIntroduceList() && demonsBaseInfoUpdatePo.getIntroduceList().size()>0){
            final List<DemonsBaseIntroduceInsertPo> introduceList = demonsBaseInfoUpdatePo.getIntroduceList();
            for (DemonsBaseIntroduceInsertPo introduceInsertPo : introduceList) {
                introduceInsertPo.setDemonsBaseId(demonsBaseInfo.getId());
                introduceService.insert(introduceInsertPo);
            }
        }
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(DemonsBaseInfoBatDeletePo demonsBaseInfoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : demonsBaseInfoBatDeletePo.getDelList()) {
            DemonsBaseInfo demonsBaseInfo = new DemonsBaseInfo();
            demonsBaseInfo.setId(delId);
            demonsBaseInfo.preUpdate();
            demonsBaseInfoMapper.deleteLogic(demonsBaseInfo);
            demonsBaseInfoMapper.delMassifByDemonsBaseId(delId);
        }
        return result;
    }

    /**
     * 根据种植企业ID删除，示范基地信息，示范基地详细，删除示范基地信息
     *
     * @author wangjunming
     * @since 2020/9/9 15:11
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> delInfoByEnterId(Long enterpriseId) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        result.setResult(demonsBaseInfoMapper.delInfoByEnterId(enterpriseId));
        return result;
    }
}
