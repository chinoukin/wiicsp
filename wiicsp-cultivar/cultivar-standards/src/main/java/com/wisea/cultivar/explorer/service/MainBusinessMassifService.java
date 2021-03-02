package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.entity.MainBusinessMassif;
import com.wisea.cultivar.explorer.mapper.MainBusinessMassifMapper;
import com.wisea.cultivar.explorer.po.MainBusinessMassifBatDeletePo;
import com.wisea.cultivar.explorer.po.MainBusinessMassifGetPo;
import com.wisea.cultivar.explorer.po.MainBusinessMassifInsertPo;
import com.wisea.cultivar.explorer.po.MainBusinessMassifListPo;
import com.wisea.cultivar.explorer.po.MainBusinessMassifPagePo;
import com.wisea.cultivar.explorer.po.MainBusinessMassifUpdatePo;
import com.wisea.cultivar.explorer.vo.MainBusinessMassifGetVo;
import com.wisea.cultivar.explorer.vo.MainBusinessMassifListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * MainBusinessMassifService
 * 主体地块信息 Service
 * 2020/08/24 20:19:05
 */
@Service
public class MainBusinessMassifService extends BaseService {
    @Autowired
    protected MainBusinessMassifMapper mainBusinessMassifMapper;
    @Autowired
    protected DemonsBaseInfoService demonsBaseInfoService;
    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<MainBusinessMassifListVo>> findPage(MainBusinessMassifPagePo mainBusinessMassifPagePo) {
        ResultPoJo<Page<MainBusinessMassifListVo>> result = new ResultPoJo<>();
        Page<MainBusinessMassifListVo> page = mainBusinessMassifPagePo.getPage();
        List<MainBusinessMassifListVo> list = mainBusinessMassifMapper.findPage(mainBusinessMassifPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<MainBusinessMassifListVo>> findList(MainBusinessMassifListPo mainBusinessMassifListPo) {
        ResultPoJo<List<MainBusinessMassifListVo>> result = new ResultPoJo<>();
        result.setResult(mainBusinessMassifMapper.findList(mainBusinessMassifListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<MainBusinessMassifGetVo> get(MainBusinessMassifGetPo mainBusinessMassifGetPo) {
        ResultPoJo<MainBusinessMassifGetVo> result = new ResultPoJo<>();
        MainBusinessMassif entity = mainBusinessMassifMapper.selectByPrimaryKey(mainBusinessMassifGetPo.getId());
        MainBusinessMassifGetVo vo = new MainBusinessMassifGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(MainBusinessMassifInsertPo mainBusinessMassifInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        MainBusinessMassif mainBusinessMassif = new MainBusinessMassif();
        ConverterUtil.copyProperties(mainBusinessMassifInsertPo, mainBusinessMassif);
        mainBusinessMassif.preInsert();
        mainBusinessMassifMapper.insert(mainBusinessMassif);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(MainBusinessMassifUpdatePo mainBusinessMassifUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        MainBusinessMassif mainBusinessMassif = new MainBusinessMassif();
        ConverterUtil.copyProperties(mainBusinessMassifUpdatePo, mainBusinessMassif);
        mainBusinessMassif.preUpdate();
        mainBusinessMassifMapper.updateByPrimaryKeySelective(mainBusinessMassif);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(MainBusinessMassifBatDeletePo mainBusinessMassifBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : mainBusinessMassifBatDeletePo.getDelList()) {
            MainBusinessMassif mainBusinessMassif = new MainBusinessMassif();
            mainBusinessMassif.setId(delId);
            mainBusinessMassif.preUpdate();
            mainBusinessMassifMapper.deleteLogic(mainBusinessMassif);
        }
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> deleteEntpInfoId(MainBusinessMassifBatDeletePo mainBusinessMassifBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : mainBusinessMassifBatDeletePo.getDelList()) {
            mainBusinessMassifMapper.deleteEntpInfoId(delId);
            demonsBaseInfoService.delInfoByEnterId(delId);
        }
        return result;
    }
}
