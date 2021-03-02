package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.standards.entity.IcsClassMage;
import com.wisea.cultivar.standards.mapper.IcsClassMageMapper;
import com.wisea.cultivar.standards.mapper.StandardRuleMageMapper;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.vo.IcsClassMageGetVo;
import com.wisea.cultivar.standards.vo.IcsClassMageListVo;

import java.util.ArrayList;
import java.util.List;

import com.wisea.cultivar.standards.vo.IcsClassMageTreeVo;
import com.wisea.cultivar.standards.vo.StandardRuleMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * IcsClassMageService
 * ICS分类管理 Service
 * 2020/07/24 11:21:45
 */
@Service
public class IcsClassMageService extends BaseService {
    @Autowired
    protected IcsClassMageMapper icsClassMageMapper;
    @Autowired
    private StandardRuleMageMapper standardRuleMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<IcsClassMageListVo>> findPage(IcsClassMagePagePo icsClassMagePagePo) {
        ResultPoJo<Page<IcsClassMageListVo>> result = new ResultPoJo<>();
        Page<IcsClassMageListVo> page = icsClassMagePagePo.getPage();
        List<IcsClassMageListVo> list = icsClassMageMapper.findPage(icsClassMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<IcsClassMageListVo>> findList(IcsClassMageListPo icsClassMageListPo) {
        ResultPoJo<List<IcsClassMageListVo>> result = new ResultPoJo<>();
        result.setResult(icsClassMageMapper.findList(icsClassMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<IcsClassMageGetVo> get(IcsClassMageGetPo icsClassMageGetPo) {
        ResultPoJo<IcsClassMageGetVo> result = new ResultPoJo<>();
        IcsClassMage entity = icsClassMageMapper.selectByPrimaryKey(icsClassMageGetPo.getId());
        IcsClassMageGetVo vo = new IcsClassMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(IcsClassMageInsertPo icsClassMageInsertPo) {
        if(ConverterUtil.isEmpty(icsClassMageInsertPo.getSort())){
            icsClassMageInsertPo.setSort(1);
        }
        ResultPoJo<Object> result = new ResultPoJo<>();
        IcsClassMage icsClassMage = new IcsClassMage();
        ConverterUtil.copyProperties(icsClassMageInsertPo, icsClassMage);
        icsClassMage.preInsert();
        if(icsClassMageInsertPo.getSort()==null){
            icsClassMage.setSort(1);
        }
        icsClassMageMapper.insert(icsClassMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(IcsClassMageUpdatePo icsClassMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        if(icsClassMageMapper.getOne(icsClassMageUpdatePo.getId())!=null){
            /*if(icsClassMageMapper.findicsClassMagePidByid(icsClassMageUpdatePo.getId()).size()>0){
                result.setResult(false);
                result.setCode(QdcyStandardsError.ERR_80003);
                result.setMsg(QdcyStandardsError.MSG_80003);
                return result;
            }*/
            IcsClassMage icsClassMage = new IcsClassMage();
            ConverterUtil.copyProperties(icsClassMageUpdatePo, icsClassMage);
            icsClassMage.preUpdate();
            icsClassMageMapper.updateByPrimaryKeySelective(icsClassMage);
            return result;
        }else{
            result.setResult(false);
            result.setCode(QdcyStandardsError.ERR_80002);
            result.setMsg(QdcyStandardsError.MSG_80002);
            return result;
        }

    }

    /**
    * TODO:删除
    * Author: xiehy
    * Date: 2020/8/25 18:09
    */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(IcsClassMageBatDeletePo icsClassMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        IcsClassMage one = icsClassMageMapper.getOne(icsClassMageBatDeletePo.getDelId());
        if(one!=null){
            if(isExist(one)){
                result.setResult(false);
                result.setCode(QdcyStandardsError.ERR_80004);
                result.setMsg(QdcyStandardsError.MSG_80004);
                return result;
            }else {
                icsClassMageMapper.deleteByPid(one.getId());
                icsClassMageMapper.deleteLogicByPrimaryKey(one.getId());
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
    public List<IcsClassMage> getMageList(IcsClassMage one, List<IcsClassMage> listout){
        System.err.println(one.getId());
        List<IcsClassMage> list = icsClassMageMapper.findicsClassMagePidByid(one.getId());
        if(list.size()>0){
            listout.addAll(list);
            for (IcsClassMage icsClassMage : list) {
                getMageList(icsClassMage,listout);
            }
        }
        return listout;
    }

    /**
     * TODO:判断子集是否关联
     * Author: xiehy
     * Date: 2020/8/25 16:41
     */
    public boolean isExist(IcsClassMage one){
        List<IcsClassMage> mageList = getMageList(one, new ArrayList<IcsClassMage>());
        if(mageList.size()>0){
            for (IcsClassMage chinaStandardTypeMage : mageList) {
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


    public ResultPoJo<List<IcsClassMageTreeVo>> icsClassMageGetTree(IcsClassMageTreePo icsClassMageTreePo) {

        List<IcsClassMageTreeVo> icsClassMageVos = icsClassMageMapper.icsClassMageGetTree(icsClassMageTreePo);
        ResultPoJo<List<IcsClassMageTreeVo>> resultPoJo = new ResultPoJo<>();
        resultPoJo.setResult(TreeUtils.listToTree(icsClassMageVos));
        return resultPoJo;
    }

    public List<IcsClassMageTreeVo> asyTreeVue(IcsClassMageTreeVo chinaStandardTypeMageTreeVo) {
        Long id = chinaStandardTypeMageTreeVo.getId();
        List<IcsClassMageTreeVo>  treeData=icsClassMageMapper.asyTreeVue(id);
        for (IcsClassMageTreeVo tree : treeData) {
            List<IcsClassMageTreeVo> children =icsClassMageMapper.asyTreeVue(tree.getId());
            if(children==null||children.size()==0){
               tree.setState(false);
            }else {
                tree.setState(true);
            }
        }
        return treeData;
    }

    public List<IcsClassMageTreeVo> asyTreeVuePS(IcsClassMageTreeVo chinaStandardTypeMageTreeVo) {
        Long id = chinaStandardTypeMageTreeVo.getPid();
        IcsClassMageTreeVo  treeData=icsClassMageMapper.asyTreeVuePS(id);
        List<IcsClassMageTreeVo> treeDataList=null;
        if (ConverterUtil.isNotEmpty(treeData)) {
            Long pid = treeData.getPid();
            treeDataList = icsClassMageMapper.asyTreeVue(pid);
            for (IcsClassMageTreeVo tree : treeDataList) {
                List<IcsClassMageTreeVo> children =icsClassMageMapper.asyTreeVue(tree.getId());
                if(children==null||children.size()==0){
                    tree.setState(false);
                }else {
                    tree.setState(true);
                }
            }
        }
        return treeDataList;
    }
}
