package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.entity.ZhfwZczxCatgMage;
import com.wisea.cultivar.portal.entity.ZhfwZczxListMage;
import com.wisea.cultivar.portal.mapper.ZhfwZczxCatgMageMapper;
import com.wisea.cultivar.portal.mapper.ZhfwZczxListMageMapper;
import com.wisea.cultivar.portal.po.*;
import com.wisea.cultivar.portal.vo.ZhfwZczxListMageGetVo;
import com.wisea.cultivar.portal.vo.ZhfwZczxListMageListVo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ZhfwZczxListMageService
 * 种植服务政策咨询管理 Service
 * 2020/08/24 20:28:13
 */
@Service
public class ZhfwZczxListMageService extends BaseService {
    @Autowired
    protected ZhfwZczxListMageMapper zhfwZczxListMageMapper;
    @Autowired
    protected ZhfwZczxCatgMageMapper zhfwZczxCatgMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZhfwZczxListMageListVo>> findPage(ZhfwZczxListMagePagePo zhfwZczxListMagePagePo) {
        ResultPoJo<Page<ZhfwZczxListMageListVo>> result = new ResultPoJo<>();
        Page<ZhfwZczxListMageListVo> page = zhfwZczxListMagePagePo.getPage();
        List<ZhfwZczxListMageListVo> list = zhfwZczxListMageMapper.findPage(zhfwZczxListMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ZhfwZczxListMageListVo>> findList(ZhfwZczxListMageListPo zhfwZczxListMageListPo) {
        ResultPoJo<List<ZhfwZczxListMageListVo>> result = new ResultPoJo<>();
        result.setResult(zhfwZczxListMageMapper.findList(zhfwZczxListMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZhfwZczxListMageGetVo> get(ZhfwZczxListMageGetPo zhfwZczxListMageGetPo) {
        ResultPoJo<ZhfwZczxListMageGetVo> result = new ResultPoJo<>();
        ZhfwZczxListMage entity = zhfwZczxListMageMapper.selectByPrimaryKey(zhfwZczxListMageGetPo.getId());
        ZhfwZczxListMageGetVo vo = new ZhfwZczxListMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ZhfwZczxListMageInsertPo zhfwZczxListMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwZczxListMage zhfwZczxListMage = new ZhfwZczxListMage();
        ConverterUtil.copyProperties(zhfwZczxListMageInsertPo, zhfwZczxListMage);
        zhfwZczxListMage.preInsert();
        zhfwZczxListMageMapper.insert(zhfwZczxListMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ZhfwZczxListMageUpdatePo zhfwZczxListMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwZczxListMage zhfwZczxListMage = new ZhfwZczxListMage();
        ConverterUtil.copyProperties(zhfwZczxListMageUpdatePo, zhfwZczxListMage);
        zhfwZczxListMage.preUpdate();
        zhfwZczxListMageMapper.updateByPrimaryKeySelective(zhfwZczxListMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ZhfwZczxListMageBatDeletePo zhfwZczxListMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : zhfwZczxListMageBatDeletePo.getDelList()) {
            ZhfwZczxListMage zhfwZczxListMage = new ZhfwZczxListMage();
            zhfwZczxListMage.setId(delId);
            zhfwZczxListMage.preUpdate();
            zhfwZczxListMageMapper.deleteLogic(zhfwZczxListMage);
        }
        return result;
    }

    /**
    * TODO:根据pid和id获取选中得菜单数据
    * Author: xiehy
    * Date: 2020/8/25 9:40
    */
    public ResultPoJo<Page<ZhfwZczxListMageListVo>> getlevelList(ZhfwZczxListMagePagePo po){
        List<ZhfwZczxListMageListVo> list = new ArrayList<>();
        ResultPoJo<Page<ZhfwZczxListMageListVo>> resultPoJo = new ResultPoJo<>();
        Page<ZhfwZczxListMageListVo> page = po.getPage();
        if(ConverterUtil.isNotEmpty(po.getPid())&&ConverterUtil.isNotEmpty(po.getZhfwZczxCatgId())){
            if(po.getPid()==0){
                po.setPid(null);
                po.setZhfwZczxCatgId(null);
                list = zhfwZczxListMageMapper.findPage(po);
            }else if(zhfwZczxCatgMageMapper.selectByPrimaryKey(po.getPid()).getPid()==0){
                //如果pid为0说明是二级菜单
                List<ZhfwZczxCatgMage> zhfwZczxCatgMagePidByid = zhfwZczxCatgMageMapper.findZhfwZczxCatgMagePidByid(po.getZhfwZczxCatgId());
                List<Long> ids = new ArrayList<>();
                for (ZhfwZczxCatgMage zhfwZczxCatgMage : zhfwZczxCatgMagePidByid) {
                    ids.add(zhfwZczxCatgMage.getId());
                }
                po.setList(ids);
                list=zhfwZczxListMageMapper.findTwoLevelList(po);
                System.out.println("=======================================");
            }else{
                list = zhfwZczxListMageMapper.findPage(po);
            }
        }else{
           list = zhfwZczxListMageMapper.findPage(po);
        }
        resultPoJo.setResult(page.setList(list));
        return resultPoJo;
    }

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZhfwZczxListMageListVo>> findZhfwZczxListMagePage(ZhfwZczxListMagePagePo zhfwZczxListMagePagePo) {
        ResultPoJo<Page<ZhfwZczxListMageListVo>> result = new ResultPoJo<>();
        Page<ZhfwZczxListMageListVo> page = zhfwZczxListMagePagePo.getPage();
        List<ZhfwZczxListMageListVo> list = zhfwZczxListMageMapper.findZhfwZczxListMagePage(zhfwZczxListMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }
}
