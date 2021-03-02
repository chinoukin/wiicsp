package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.portal.entity.ZhfwZczxCatgMage;
import com.wisea.cultivar.portal.entity.ZhfwZczxListMage;
import com.wisea.cultivar.portal.mapper.ZhfwZczxCatgMageMapper;
import com.wisea.cultivar.portal.mapper.ZhfwZczxListMageMapper;
import com.wisea.cultivar.portal.po.*;
import com.wisea.cultivar.portal.vo.ZhfwZczxCatgMageGetVo;
import com.wisea.cultivar.portal.vo.ZhfwZczxCatgMageListVo;

import java.util.ArrayList;
import java.util.List;

import com.wisea.cultivar.portal.vo.ZhfwZczxCatgMageTreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ZhfwZczxCatgMageService
 * 种植服务资料分类管理 Service
 * 2020/08/24 20:28:13
 */
@Service
public class ZhfwZczxCatgMageService extends BaseService {
    @Autowired
    protected ZhfwZczxCatgMageMapper zhfwZczxCatgMageMapper;

    @Autowired
    private ZhfwZczxListMageMapper zhfwZczxListMageMapper;
    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZhfwZczxCatgMageListVo>> findPage(ZhfwZczxCatgMagePagePo zhfwZczxCatgMagePagePo) {
        ResultPoJo<Page<ZhfwZczxCatgMageListVo>> result = new ResultPoJo<>();
        Page<ZhfwZczxCatgMageListVo> page = zhfwZczxCatgMagePagePo.getPage();
        List<ZhfwZczxCatgMageListVo> list = zhfwZczxCatgMageMapper.findPage(zhfwZczxCatgMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ZhfwZczxCatgMageListVo>> findList(ZhfwZczxCatgMageListPo zhfwZczxCatgMageListPo) {
        ResultPoJo<List<ZhfwZczxCatgMageListVo>> result = new ResultPoJo<>();
        result.setResult(zhfwZczxCatgMageMapper.findList(zhfwZczxCatgMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZhfwZczxCatgMageGetVo> get(ZhfwZczxCatgMageGetPo zhfwZczxCatgMageGetPo) {
        ResultPoJo<ZhfwZczxCatgMageGetVo> result = new ResultPoJo<>();
        ZhfwZczxCatgMage entity = zhfwZczxCatgMageMapper.selectByPrimaryKey(zhfwZczxCatgMageGetPo.getId());
        ZhfwZczxCatgMageGetVo vo = new ZhfwZczxCatgMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ZhfwZczxCatgMageInsertPo zhfwZczxCatgMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwZczxCatgMage zhfwZczxCatgMage = new ZhfwZczxCatgMage();
        ConverterUtil.copyProperties(zhfwZczxCatgMageInsertPo, zhfwZczxCatgMage);
        zhfwZczxCatgMage.preInsert();
        zhfwZczxCatgMageMapper.insert(zhfwZczxCatgMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ZhfwZczxCatgMageUpdatePo zhfwZczxCatgMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwZczxCatgMage zhfwZczxCatgMage = new ZhfwZczxCatgMage();
        ConverterUtil.copyProperties(zhfwZczxCatgMageUpdatePo, zhfwZczxCatgMage);
        zhfwZczxCatgMage.preUpdate();
        zhfwZczxCatgMageMapper.updateByPrimaryKeySelective(zhfwZczxCatgMage);
        return result;
    }

    /**
     * 删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ZhfwZczxCatgMageBatDeletePo zhfwZczxCatgMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwZczxCatgMage zhfwZczxCatgMage = zhfwZczxCatgMageMapper.getOne(zhfwZczxCatgMageBatDeletePo.getDelId());
        if(zhfwZczxCatgMage!=null){
            if(isExist(zhfwZczxCatgMage)){
                result.setResult(false);
                result.setCode(QdcyStandardsError.ERR_80004);
                result.setMsg(QdcyStandardsError.MSG_80004);
                return result;
            }else{
                zhfwZczxCatgMageMapper.deleteByPid(zhfwZczxCatgMage.getId());
                zhfwZczxCatgMageMapper.deleteLogicByPrimaryKey(zhfwZczxCatgMage.getId());
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
    public List<ZhfwZczxCatgMage> getMageList(ZhfwZczxCatgMage one, List<ZhfwZczxCatgMage> listout){
        System.err.println(one.getId());
        List<ZhfwZczxCatgMage> list = zhfwZczxCatgMageMapper.findZhfwZczxCatgMagePidByid(one.getId());
        if(list.size()>0){
            listout.addAll(list);
            for (ZhfwZczxCatgMage chinaStandardTypeMage : list) {
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
    public boolean isExist(ZhfwZczxCatgMage one){
        List<ZhfwZczxCatgMage> mageList = getMageList(one, new ArrayList<ZhfwZczxCatgMage>());
        if(mageList.size()>0){
            for (ZhfwZczxCatgMage zhfwZczxCatgMage : mageList) {
                ZhfwZczxListMage po = new ZhfwZczxListMage();
                po.setZhfwZczxCatgId(zhfwZczxCatgMage.getId());
                List<ZhfwZczxListMage> list = zhfwZczxListMageMapper.findList(po);
                if(list.size()>0){
                    return true;
                }
            }
        }else{
            ZhfwZczxListMage po = new ZhfwZczxListMage();
            po.setZhfwZczxCatgId(one.getId());
            List<ZhfwZczxListMage> list = zhfwZczxListMageMapper.findList(po);
            if(list.size()>0){
                return true;
            }
        }
        return false;
    }
    /**
    * TODO:查询树形结构图
    * Author: xiehy
    * Date: 2020/8/25 9:30
    */
    public ResultPoJo<List<ZhfwZczxCatgMageTreeVo>> getTree(ZhfwZczxCatgMageTreePo zhfwZczxCatgMageTreePo) {
        ResultPoJo<List<ZhfwZczxCatgMageTreeVo>> resultPoJo = new ResultPoJo<>();
        ZhfwZczxCatgMageListPo zhfwZczxCatgMageListPo = new ZhfwZczxCatgMageListPo();
        zhfwZczxCatgMageListPo.setpCatgName(zhfwZczxCatgMageTreePo.getCatgName());
        List<ZhfwZczxCatgMageTreeVo> list = zhfwZczxCatgMageMapper.findTree(zhfwZczxCatgMageListPo);

        List<ZhfwZczxCatgMageTreeVo> tree = TreeUtils.listToTree(list);
        resultPoJo.setResult(tree);
        return resultPoJo;
    }



}
