package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.standards.entity.StandardTypeMage;
import com.wisea.cultivar.standards.mapper.StandardRuleMageMapper;
import com.wisea.cultivar.standards.mapper.StandardTypeMageMapper;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.vo.StandardRuleMageListVo;
import com.wisea.cultivar.standards.vo.StandardTypeMageGetVo;
import com.wisea.cultivar.standards.vo.StandardTypeMageListVo;

import java.util.ArrayList;
import java.util.List;

import com.wisea.cultivar.standards.vo.StandardTypeMageTreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * StandardTypeMageService
 * 标准类型管理 Service
 * 2020/07/24 11:21:45
 */
@Service
public class StandardTypeMageService extends BaseService {
    @Autowired
    protected StandardTypeMageMapper standardTypeMageMapper;
    @Autowired
    private StandardRuleMageMapper standardRuleMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<StandardTypeMageListVo>> findPage(StandardTypeMagePagePo standardTypeMagePagePo) {
        ResultPoJo<Page<StandardTypeMageListVo>> result = new ResultPoJo<>();
        Page<StandardTypeMageListVo> page = standardTypeMagePagePo.getPage();
        List<StandardTypeMageListVo> list = standardTypeMageMapper.findPage(standardTypeMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<StandardTypeMageListVo>> findList(StandardTypeMageListPo standardTypeMageListPo) {
        ResultPoJo<List<StandardTypeMageListVo>> result = new ResultPoJo<>();
        result.setResult(standardTypeMageMapper.findList(standardTypeMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<StandardTypeMageGetVo> get(StandardTypeMageGetPo standardTypeMageGetPo) {
        ResultPoJo<StandardTypeMageGetVo> result = new ResultPoJo<>();
        StandardTypeMage entity = standardTypeMageMapper.selectByPrimaryKey(standardTypeMageGetPo.getId());
        StandardTypeMageGetVo vo = new StandardTypeMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(StandardTypeMageInsertPo standardTypeMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        StandardTypeMage standardTypeMage = new StandardTypeMage();
        ConverterUtil.copyProperties(standardTypeMageInsertPo, standardTypeMage);
        standardTypeMage.preInsert();
        if(standardTypeMageInsertPo.getSort()==null){
            standardTypeMage.setSort(1);
        }
        standardTypeMageMapper.insert(standardTypeMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(StandardTypeMageUpdatePo standardTypeMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        if(standardTypeMageMapper.getOne(standardTypeMageUpdatePo.getId())!=null){
            /*if(standardTypeMageMapper.findstandardTypeMagePidByid(standardTypeMageUpdatePo.getId()).size()>0){
                result.setResult(false);
                result.setCode(QdcyStandardsError.ERR_80003);
                result.setMsg(QdcyStandardsError.MSG_80003);
                return result;
            }*/
            StandardTypeMage standardTypeMage = new StandardTypeMage();
            ConverterUtil.copyProperties(standardTypeMageUpdatePo, standardTypeMage);
            standardTypeMage.preUpdate();
            standardTypeMageMapper.updateByPrimaryKeySelective(standardTypeMage);
            return result;
        }else{
            result.setResult(false);
            result.setCode(QdcyStandardsError.ERR_80002);
            result.setMsg(QdcyStandardsError.MSG_80002);
            return result;
        }

    }

    /**
     * 批量删除
     */
    /*@Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(StandardTypeMageBatDeletePo standardTypeMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        StandardRuleMageListPo standardRuleMageListPo = new StandardRuleMageListPo();
        for(Long delId : standardTypeMageBatDeletePo.getDelList()) {
            standardRuleMageListPo.setStandardTypeMageId(delId);
            if(standardRuleMageService.findList(standardRuleMageListPo).getResult().size()>0){
                result.setResult(false);
                result.setCode(QdcyStandardsError.ERR_80004);
                result.setMsg(QdcyStandardsError.MSG_80004);
                return result;
            }
            if(standardTypeMageMapper.getOne(delId)!=null){
                if(standardTypeMageMapper.findstandardTypeMagePidByid(delId).size()>0){
                    result.setResult(false);
                    result.setCode(QdcyStandardsError.ERR_80003);
                    result.setMsg(QdcyStandardsError.MSG_80003);
                    return result;
                }
                StandardTypeMage standardTypeMage = new StandardTypeMage();
                standardTypeMage.setId(delId);
                standardTypeMage.preUpdate();
                standardTypeMageMapper.deleteLogic(standardTypeMage);
            }else{
                result.setResult(false);
                result.setCode(QdcyStandardsError.ERR_80002);
                result.setMsg(QdcyStandardsError.MSG_80002);
                return result;
            }

        }
        return result;
    }*/
    /**
     * TODO:删除
     * Author: xiehy
     * Date: 2020/8/25 18:09
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(StandardTypeMageBatDeletePo standardTypeMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        StandardTypeMage one = standardTypeMageMapper.getOne(standardTypeMageBatDeletePo.getDelId());
        if(one!=null){
            if(isExist(one)){
                result.setResult(false);
                result.setCode(QdcyStandardsError.ERR_80004);
                result.setMsg(QdcyStandardsError.MSG_80004);
                return result;
            }else {
                standardTypeMageMapper.deleteByPid(one.getId());
                standardTypeMageMapper.deleteLogicByPrimaryKey(one.getId());
                return result;

                }
            }

        result.setResult(false);
        result.setCode(QdcyStandardsError.ERR_80002);
        result.setMsg(QdcyStandardsError.MSG_80002);
        return result;

    }

    /**
     * TODO:获取所有子集分类
     * Author: xiehy
     * Date: 2020/8/25 16:40
     */
    public List<StandardTypeMage> getMageList(StandardTypeMage one, List<StandardTypeMage> listout){
        System.err.println(one.getId());
        List<StandardTypeMage> list = standardTypeMageMapper.findstandardTypeMagePidByid(one.getId());
        if(list.size()>0){
            listout.addAll(list);
            for (StandardTypeMage standardTypeMage : list) {
                getMageList(standardTypeMage,listout);
            }
        }
        return listout;
    }

    /**
     * TODO:判断子集是否关联
     * Author: xiehy
     * Date: 2020/8/25 16:41
     */
    public boolean isExist(StandardTypeMage one){
        List<StandardTypeMage> mageList = getMageList(one, new ArrayList<StandardTypeMage>());
        if(mageList.size()>0){
            for (StandardTypeMage chinaStandardTypeMage : mageList) {
                StandardRuleMageListPo po = new StandardRuleMageListPo();
                po.setChinaStandardTypeMageId(chinaStandardTypeMage.getId());
                List<StandardRuleMageListVo> list = standardRuleMageMapper.findList(po);
                if(list.size()>0){
                    return true;
                }
            }
        }else{
            StandardRuleMageListPo po = new StandardRuleMageListPo();
            po.setChinaStandardTypeMageId(one.getId());
            List<StandardRuleMageListVo> list = standardRuleMageMapper.findList(po);
            if(list.size()>0){
                return true;
            }
        }
        return false;
    }

    /**
     * 树形数据表查询
     * @param standardTypeMageTreePo
     * @return
     */
    public ResultPoJo<List<StandardTypeMageTreeVo>> standardTypeMageGetTree(StandardTypeMageTreePo standardTypeMageTreePo) {
        List<StandardTypeMageTreeVo> standardTypeMageTreeVos = standardTypeMageMapper.standardTypeMageGetTree(standardTypeMageTreePo);
        ResultPoJo<List<StandardTypeMageTreeVo>> resultPoJo = new ResultPoJo<>();
        resultPoJo.setResult(TreeUtils.listToTree(standardTypeMageTreeVos));
        return resultPoJo;
    }
}
