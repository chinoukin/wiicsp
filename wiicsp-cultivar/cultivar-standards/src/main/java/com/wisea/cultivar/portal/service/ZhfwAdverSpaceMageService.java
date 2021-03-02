package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.entity.ZhfwAdverSpaceMage;
import com.wisea.cultivar.portal.mapper.ZhfwAdverSpaceMageMapper;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageGetPo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageInsertPo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageListPo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMagePagePo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageUpdatePo;
import com.wisea.cultivar.portal.vo.ZhfwAdverSpaceMageGetVo;
import com.wisea.cultivar.portal.vo.ZhfwAdverSpaceMageListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ZhfwAdverSpaceMageService
 * 种植服务广告位管理 Service
 * 2020/08/24 20:28:13
 */
@Service
public class ZhfwAdverSpaceMageService extends BaseService {
    @Autowired
    protected ZhfwAdverSpaceMageMapper zhfwAdverSpaceMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZhfwAdverSpaceMageListVo>> findPage(ZhfwAdverSpaceMagePagePo zhfwAdverSpaceMagePagePo) {
        ResultPoJo<Page<ZhfwAdverSpaceMageListVo>> result = new ResultPoJo<>();
        Page<ZhfwAdverSpaceMageListVo> page = zhfwAdverSpaceMagePagePo.getPage();
        List<ZhfwAdverSpaceMageListVo> list = zhfwAdverSpaceMageMapper.findPage(zhfwAdverSpaceMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ZhfwAdverSpaceMageListVo>> findList(ZhfwAdverSpaceMageListPo zhfwAdverSpaceMageListPo) {
        ResultPoJo<List<ZhfwAdverSpaceMageListVo>> result = new ResultPoJo<>();
        result.setResult(zhfwAdverSpaceMageMapper.findList(zhfwAdverSpaceMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZhfwAdverSpaceMageGetVo> get(ZhfwAdverSpaceMageGetPo zhfwAdverSpaceMageGetPo) {
        ResultPoJo<ZhfwAdverSpaceMageGetVo> result = new ResultPoJo<>();
        ZhfwAdverSpaceMage entity = zhfwAdverSpaceMageMapper.selectByPrimaryKey(zhfwAdverSpaceMageGetPo.getId());
        ZhfwAdverSpaceMageGetVo vo = new ZhfwAdverSpaceMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ZhfwAdverSpaceMageInsertPo zhfwAdverSpaceMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwAdverSpaceMage zhfwAdverSpaceMage = new ZhfwAdverSpaceMage();
        ConverterUtil.copyProperties(zhfwAdverSpaceMageInsertPo, zhfwAdverSpaceMage);
        zhfwAdverSpaceMage.preInsert();
        zhfwAdverSpaceMageMapper.insert(zhfwAdverSpaceMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ZhfwAdverSpaceMageUpdatePo zhfwAdverSpaceMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwAdverSpaceMage zhfwAdverSpaceMage = new ZhfwAdverSpaceMage();
        ConverterUtil.copyProperties(zhfwAdverSpaceMageUpdatePo, zhfwAdverSpaceMage);
        zhfwAdverSpaceMage.preUpdate();
        zhfwAdverSpaceMageMapper.updateByPrimaryKeySelective(zhfwAdverSpaceMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ZhfwAdverSpaceMageBatDeletePo zhfwAdverSpaceMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : zhfwAdverSpaceMageBatDeletePo.getDelList()) {
            ZhfwAdverSpaceMage zhfwAdverSpaceMage = new ZhfwAdverSpaceMage();
            zhfwAdverSpaceMage.setId(delId);
            zhfwAdverSpaceMage.preUpdate();
            zhfwAdverSpaceMageMapper.deleteLogic(zhfwAdverSpaceMage);
        }
        return result;
    }

    /**
     * 根据名称查询id
     */
    public ZhfwAdverSpaceMage selectByAdverSpaceName(String adverSpaceName) {
        ResultPoJo<ZhfwAdverSpaceMageGetVo> result = new ResultPoJo<>();
        ZhfwAdverSpaceMageGetPo zhfwAdverSpaceMageGetPo = new ZhfwAdverSpaceMageGetPo();
        zhfwAdverSpaceMageGetPo.setAdverSpaceName(adverSpaceName);
        ZhfwAdverSpaceMage zhfwAdverSpaceMage = zhfwAdverSpaceMageMapper.selectByAdverSpaceName(zhfwAdverSpaceMageGetPo);
        return zhfwAdverSpaceMage;
    }
}
