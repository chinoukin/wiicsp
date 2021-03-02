package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.entity.ZhfwAdverMage;
import com.wisea.cultivar.portal.mapper.ZhfwAdverMageMapper;
import com.wisea.cultivar.portal.po.ZhfwAdverMageBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwAdverMageGetPo;
import com.wisea.cultivar.portal.po.ZhfwAdverMageInsertPo;
import com.wisea.cultivar.portal.po.ZhfwAdverMageListPo;
import com.wisea.cultivar.portal.po.ZhfwAdverMagePagePo;
import com.wisea.cultivar.portal.po.ZhfwAdverMageUpdatePo;
import com.wisea.cultivar.portal.vo.ZhfwAdverMageGetVo;
import com.wisea.cultivar.portal.vo.ZhfwAdverMageListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ZhfwAdverMageService
 * 种植服务广告管理 Service
 * 2020/08/24 20:28:13
 */
@Service
public class ZhfwAdverMageService extends BaseService {
    @Autowired
    protected ZhfwAdverMageMapper zhfwAdverMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZhfwAdverMageListVo>> findPage(ZhfwAdverMagePagePo zhfwAdverMagePagePo) {
        ResultPoJo<Page<ZhfwAdverMageListVo>> result = new ResultPoJo<>();
        Page<ZhfwAdverMageListVo> page = zhfwAdverMagePagePo.getPage();
        List<ZhfwAdverMageListVo> list = zhfwAdverMageMapper.findPage(zhfwAdverMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ZhfwAdverMageListVo>> findList(ZhfwAdverMageListPo zhfwAdverMageListPo) {
        ResultPoJo<List<ZhfwAdverMageListVo>> result = new ResultPoJo<>();
        result.setResult(zhfwAdverMageMapper.findList(zhfwAdverMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZhfwAdverMageGetVo> get(ZhfwAdverMageGetPo zhfwAdverMageGetPo) {
        ResultPoJo<ZhfwAdverMageGetVo> result = new ResultPoJo<>();
        ZhfwAdverMage entity = zhfwAdverMageMapper.selectByPrimaryKey(zhfwAdverMageGetPo.getId());
        //获取广告位地址
        Long adverSpaceId = entity.getAdverSpaceId();
        if (adverSpaceId!=null){

        }
        ZhfwAdverMageGetVo vo = new ZhfwAdverMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ZhfwAdverMageInsertPo zhfwAdverMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwAdverMage zhfwAdverMage = new ZhfwAdverMage();
        ConverterUtil.copyProperties(zhfwAdverMageInsertPo, zhfwAdverMage);
        zhfwAdverMage.preInsert();
        zhfwAdverMageMapper.insert(zhfwAdverMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ZhfwAdverMageUpdatePo zhfwAdverMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwAdverMage zhfwAdverMage = new ZhfwAdverMage();
        ConverterUtil.copyProperties(zhfwAdverMageUpdatePo, zhfwAdverMage);
        zhfwAdverMage.preUpdate();
        zhfwAdverMageMapper.updateByPrimaryKeySelective(zhfwAdverMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ZhfwAdverMageBatDeletePo zhfwAdverMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : zhfwAdverMageBatDeletePo.getDelList()) {
            ZhfwAdverMage zhfwAdverMage = new ZhfwAdverMage();
            zhfwAdverMage.setId(delId);
            zhfwAdverMage.preUpdate();
            zhfwAdverMageMapper.deleteLogic(zhfwAdverMage);
        }
        return result;
    }

    /**
     * 首页
     * @param zhfwAdverMagePagePo
     * @return
     */
    public ResultPoJo<Page<ZhfwAdverMageListVo>> findByAdverSpaceId(ZhfwAdverMagePagePo zhfwAdverMagePagePo) {
        ResultPoJo<Page<ZhfwAdverMageListVo>> result = new ResultPoJo<>();
        Page<ZhfwAdverMageListVo> page = zhfwAdverMagePagePo.getPage();
        List<ZhfwAdverMageListVo> list = zhfwAdverMageMapper.findByAdverSpaceId(zhfwAdverMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }
}
