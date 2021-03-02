package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.standards.entity.ChinaStandardTypeMage;
import com.wisea.cultivar.standards.mapper.ChinaStandardTypeMageMapper;
import com.wisea.cultivar.standards.mapper.StandardRuleMageMapper;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.vo.ChinaStandardTypeMageGetVo;
import com.wisea.cultivar.standards.vo.ChinaStandardTypeMageListVo;

import java.util.ArrayList;
import java.util.List;

import com.wisea.cultivar.standards.vo.ChinaStandardTypeMageTreeVo;
import com.wisea.cultivar.standards.vo.StandardRuleMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ChinaStandardTypeMageService
 * 中标分类管理 Service
 * 2020/07/24 11:21:45
 */
@Service
public class ChinaStandardTypeMageService extends BaseService {
    @Autowired
    protected ChinaStandardTypeMageMapper chinaStandardTypeMageMapper;
    @Autowired
    private StandardRuleMageMapper standardRuleMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ChinaStandardTypeMageListVo>> findPage(ChinaStandardTypeMagePagePo chinaStandardTypeMagePagePo) {
        ResultPoJo<Page<ChinaStandardTypeMageListVo>> result = new ResultPoJo<>();
        Page<ChinaStandardTypeMageListVo> page = chinaStandardTypeMagePagePo.getPage();
        List<ChinaStandardTypeMageListVo> list = chinaStandardTypeMageMapper.findPage(chinaStandardTypeMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ChinaStandardTypeMageListVo>> findList(ChinaStandardTypeMageListPo chinaStandardTypeMageListPo) {
        ResultPoJo<List<ChinaStandardTypeMageListVo>> result = new ResultPoJo<>();
        result.setResult(chinaStandardTypeMageMapper.findList(chinaStandardTypeMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ChinaStandardTypeMageGetVo> get(ChinaStandardTypeMageGetPo chinaStandardTypeMageGetPo) {
        ResultPoJo<ChinaStandardTypeMageGetVo> result = new ResultPoJo<>();
        ChinaStandardTypeMage entity = chinaStandardTypeMageMapper.selectByPrimaryKey(chinaStandardTypeMageGetPo.getId());
        ChinaStandardTypeMageGetVo vo = new ChinaStandardTypeMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ChinaStandardTypeMageInsertPo chinaStandardTypeMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ChinaStandardTypeMage chinaStandardTypeMage = new ChinaStandardTypeMage();
        ConverterUtil.copyProperties(chinaStandardTypeMageInsertPo, chinaStandardTypeMage);
        chinaStandardTypeMage.preInsert();
        if (chinaStandardTypeMageInsertPo.getSort()==null){
            chinaStandardTypeMage.setSort(1);
        }
        chinaStandardTypeMageMapper.insert(chinaStandardTypeMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ChinaStandardTypeMageUpdatePo chinaStandardTypeMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ChinaStandardTypeMage chinaStandardTypeMage = new ChinaStandardTypeMage();
        ConverterUtil.copyProperties(chinaStandardTypeMageUpdatePo, chinaStandardTypeMage);
        chinaStandardTypeMage.preUpdate();
        chinaStandardTypeMageMapper.updateByPrimaryKeySelective(chinaStandardTypeMage);
        return result;
    }

    /**
    * TODO:删除
    * Author: xiehy
    * Date: 2020/8/25 11:24
    */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> oneDelete(ChinaStandardTypeMageBatDeletePo chinaStandardTypeMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ChinaStandardTypeMage one = chinaStandardTypeMageMapper.getOne(chinaStandardTypeMageBatDeletePo.getDelId());
        if(one!=null){
            if(isExist(one)){
                result.setResult(false);
                result.setCode(QdcyStandardsError.ERR_80004);
                result.setMsg(QdcyStandardsError.MSG_80004);
                return result;
            }else{
                chinaStandardTypeMageMapper.deleteByPid(one.getId());
                chinaStandardTypeMageMapper.deleteLogicByPrimaryKey(one.getId());
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
    public List<ChinaStandardTypeMage> getMageList(ChinaStandardTypeMage one, List<ChinaStandardTypeMage> listout){
        System.err.println(one.getId());
        List<ChinaStandardTypeMage> list = chinaStandardTypeMageMapper.findChinaStandardTypeMagePidByid(one.getId());
        if(list.size()>0){
            listout.addAll(list);
            for (ChinaStandardTypeMage chinaStandardTypeMage : list) {
                getMageList(chinaStandardTypeMage,listout);
            }
        }
        return listout;
    }

    /**
    * TODO:判断子集是否关联
    * Author: xiehy
    * Date: 2020/8/25 16:41
    */
    public boolean isExist(ChinaStandardTypeMage one){
        List<ChinaStandardTypeMage> mageList = getMageList(one, new ArrayList<ChinaStandardTypeMage>());
        if(mageList.size()>0){
            for (ChinaStandardTypeMage chinaStandardTypeMage : mageList) {
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
     * 批量删除
     */
    /*@Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ChinaStandardTypeMageBatDeletePo chinaStandardTypeMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        StandardRuleMageListPo standardRuleMageListPo = new StandardRuleMageListPo();
        for(Long delId : chinaStandardTypeMageBatDeletePo.getDelList()) {
            //根据Id获取删除对象
            ChinaStandardTypeMage chinaStandardTypeMageInfo = chinaStandardTypeMageMapper.getOne(delId);
            //判断删除对象是否存在
            if(chinaStandardTypeMageInfo!=null){
                standardRuleMageListPo.setChinaStandardTypeMageId(delId);
                if(standardRuleMageService.findList(standardRuleMageListPo).getResult().size()>0){
                    result.setResult(false);
                    result.setCode(QdcyStandardsError.ERR_80004);
                    result.setMsg(QdcyStandardsError.MSG_80004);
                    return result;
                }
                ChinaStandardTypeMage chinaStandardTypeMage = new ChinaStandardTypeMage();
                chinaStandardTypeMage.setId(delId);
                chinaStandardTypeMage.preUpdate();
                chinaStandardTypeMageMapper.deleteLogic(chinaStandardTypeMage);
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
     * 树形数据表查询
     * @param chinaStandardTypeMageTreePo
     * @return
     */
    public List<ChinaStandardTypeMageTreeVo> ChinaStandardTypeMageGetTree(ChinaStandardTypeMageTreePo chinaStandardTypeMageTreePo) {
        List<ChinaStandardTypeMageTreeVo> treeList=chinaStandardTypeMageMapper.ChinaStandardTypeMageGetTree(chinaStandardTypeMageTreePo);
        return TreeUtils.listToTree(treeList);

    }

    public List<ChinaStandardTypeMageTreeVo> asyTreeVue(ChinaStandardTypeMageTreeVo chinaStandardTypeMageTreeVo) {
        Long id = chinaStandardTypeMageTreeVo.getId();
        List<ChinaStandardTypeMageTreeVo>  treeData=chinaStandardTypeMageMapper.asyTreeVue(id);
        for (ChinaStandardTypeMageTreeVo tree : treeData) {
            List<ChinaStandardTypeMageTreeVo> children =chinaStandardTypeMageMapper.asyTreeVue(tree.getId());
            if(children==null||children.size()==0){
                tree.setState(false);
            }else {
                tree.setState(true);
            }
        }
        return treeData;
    }

    public List<ChinaStandardTypeMageTreeVo> asyTreeVuePS(ChinaStandardTypeMageTreeVo chinaStandardTypeMageTreeVo) {
        Long id = chinaStandardTypeMageTreeVo.getPid();
        ChinaStandardTypeMageTreeVo treeData = chinaStandardTypeMageMapper.asyTreeVuePS(id);
        List<ChinaStandardTypeMageTreeVo> treeDataList = null;
        if (ConverterUtil.isNotEmpty(treeData)) {
            Long pid = treeData.getPid();
            treeDataList = chinaStandardTypeMageMapper.asyTreeVue(pid);
            for (ChinaStandardTypeMageTreeVo tree : treeDataList) {
                List<ChinaStandardTypeMageTreeVo> children = chinaStandardTypeMageMapper.asyTreeVue(tree.getId());
                if (children == null || children.size() == 0) {
                    tree.setState(false);
                } else {
                    tree.setState(true);
                }
            }
        }
        return treeDataList;
    }
}
