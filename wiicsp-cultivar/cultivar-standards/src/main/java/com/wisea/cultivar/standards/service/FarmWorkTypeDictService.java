package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.entity.FarmWorkTypeDict;
import com.wisea.cultivar.standards.mapper.FarmWorkTypeDictMapper;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictBatDeletePo;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictGetPo;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictInsertPo;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictListPo;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictPagePo;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictUpdatePo;
import com.wisea.cultivar.standards.vo.FarmWorkTypeDictGetVo;
import com.wisea.cultivar.standards.vo.FarmWorkTypeDictListVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FarmWorkTypeDictService
 * 农事操作类型字典 Service
 * 2020/07/24 11:21:45
 */
@Service
public class FarmWorkTypeDictService extends BaseService {
    @Autowired
    protected FarmWorkTypeDictMapper farmWorkTypeDictMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<FarmWorkTypeDictListVo>> findPage(FarmWorkTypeDictPagePo farmWorkTypeDictPagePo) {
        ResultPoJo<Page<FarmWorkTypeDictListVo>> result = new ResultPoJo<>();
        Page<FarmWorkTypeDictListVo> page = farmWorkTypeDictPagePo.getPage();
        List<FarmWorkTypeDictListVo> list = farmWorkTypeDictMapper.findPage(farmWorkTypeDictPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }


    /**
     * 获取农事类型
     * @param
     * @return
     */
    public ResultPoJo<List<FarmWorkTypeDictListVo>> findAllList() {
        //1.获取农事类型
        ResultPoJo<List<FarmWorkTypeDictListVo>> result = new ResultPoJo<>();
        FarmWorkTypeDictListPo farmWorkTypeDictListPo = new FarmWorkTypeDictListPo();
        List<FarmWorkTypeDictListVo> psList = farmWorkTypeDictMapper.findList(farmWorkTypeDictListPo);
        List<FarmWorkTypeDictListVo> parentList = new ArrayList<FarmWorkTypeDictListVo>(); //存放所有父菜单对象
        Map<Long,FarmWorkTypeDictListVo> allParent = new HashMap<Long,FarmWorkTypeDictListVo>(); //(Cache)临时集合，为了查找数据方便建立的。

        //2.组合父与子关系
        for (FarmWorkTypeDictListVo farmWorkTypeDictListVo : psList) {
            if (farmWorkTypeDictListVo.getParentId()==0){
                parentList.add(farmWorkTypeDictListVo);
                allParent.put(farmWorkTypeDictListVo.getId(), farmWorkTypeDictListVo);
            }
        }

        for (FarmWorkTypeDictListVo farmWorkTypeDictListVo : psList) {
            if(farmWorkTypeDictListVo.getParentId()!=0) {
                Long pid = farmWorkTypeDictListVo.getParentId();
                farmWorkTypeDictListVo.setChildren(null);
                FarmWorkTypeDictListVo parent = allParent.get(pid);
                parent.getChildren().add(farmWorkTypeDictListVo);
            }
        }

        //3.返回所有父菜单对象。
        result.setResult(parentList);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<FarmWorkTypeDictListVo>> findPSList(FarmWorkTypeDictListPo farmWorkTypeDictListPo) {
        ResultPoJo<List<FarmWorkTypeDictListVo>> result = new ResultPoJo<>();
        result.setResult(farmWorkTypeDictMapper.findPSList(farmWorkTypeDictListPo));
        return result;
    }

    /**
     * 查询二级农事
     * @param farmWorkTypeDictListPo
     * @return
     */
    public ResultPoJo<List<FarmWorkTypeDictListVo>> findTwoList(FarmWorkTypeDictListPo farmWorkTypeDictListPo) {
        ResultPoJo<List<FarmWorkTypeDictListVo>> result = new ResultPoJo<>();
        result.setResult(farmWorkTypeDictMapper.findTwoList(farmWorkTypeDictListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<FarmWorkTypeDictGetVo> get(FarmWorkTypeDictGetPo farmWorkTypeDictGetPo) {
        ResultPoJo<FarmWorkTypeDictGetVo> result = new ResultPoJo<>();
        FarmWorkTypeDict entity = farmWorkTypeDictMapper.selectByPrimaryKey(farmWorkTypeDictGetPo.getId());
        FarmWorkTypeDictGetVo vo = new FarmWorkTypeDictGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(FarmWorkTypeDictInsertPo farmWorkTypeDictInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        FarmWorkTypeDict farmWorkTypeDict = new FarmWorkTypeDict();
        ConverterUtil.copyProperties(farmWorkTypeDictInsertPo, farmWorkTypeDict);
        farmWorkTypeDict.preInsert();
        farmWorkTypeDictMapper.insert(farmWorkTypeDict);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(FarmWorkTypeDictUpdatePo farmWorkTypeDictUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        FarmWorkTypeDict farmWorkTypeDict = new FarmWorkTypeDict();
        ConverterUtil.copyProperties(farmWorkTypeDictUpdatePo, farmWorkTypeDict);
        farmWorkTypeDict.preUpdate();
        farmWorkTypeDictMapper.updateByPrimaryKeySelective(farmWorkTypeDict);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(FarmWorkTypeDictBatDeletePo farmWorkTypeDictBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : farmWorkTypeDictBatDeletePo.getDelList()) {
            FarmWorkTypeDict farmWorkTypeDict = new FarmWorkTypeDict();
            farmWorkTypeDict.setId(delId);
            farmWorkTypeDict.preUpdate();
            farmWorkTypeDictMapper.deleteLogic(farmWorkTypeDict);
        }
        return result;
    }


}
