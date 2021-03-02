package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.entity.ZhfwBrandEntpReco;
import com.wisea.cultivar.portal.mapper.ZhfwBrandEntpRecoMapper;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoGetPo;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoInsertPo;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoListPo;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoPagePo;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoUpdatePo;
import com.wisea.cultivar.portal.vo.ZhfwBrandEntpRecoGetVo;
import com.wisea.cultivar.portal.vo.ZhfwBrandEntpRecoListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ZhfwBrandEntpRecoService
 * 种植服务品牌企业推荐 Service
 * 2020/08/24 20:28:13
 */
@Service
public class ZhfwBrandEntpRecoService extends BaseService {
    @Autowired
    protected ZhfwBrandEntpRecoMapper zhfwBrandEntpRecoMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZhfwBrandEntpRecoListVo>> findPage(ZhfwBrandEntpRecoPagePo zhfwBrandEntpRecoPagePo) {
        ResultPoJo<Page<ZhfwBrandEntpRecoListVo>> result = new ResultPoJo<>();
        Page<ZhfwBrandEntpRecoListVo> page = zhfwBrandEntpRecoPagePo.getPage();
        List<ZhfwBrandEntpRecoListVo> list = zhfwBrandEntpRecoMapper.findPage(zhfwBrandEntpRecoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ZhfwBrandEntpRecoListVo>> findList(ZhfwBrandEntpRecoListPo zhfwBrandEntpRecoListPo) {
        ResultPoJo<List<ZhfwBrandEntpRecoListVo>> result = new ResultPoJo<>();
        result.setResult(zhfwBrandEntpRecoMapper.findList(zhfwBrandEntpRecoListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZhfwBrandEntpRecoGetVo> get(ZhfwBrandEntpRecoGetPo zhfwBrandEntpRecoGetPo) {
        ResultPoJo<ZhfwBrandEntpRecoGetVo> result = new ResultPoJo<>();
        ZhfwBrandEntpReco entity = zhfwBrandEntpRecoMapper.selectByPrimaryKey(zhfwBrandEntpRecoGetPo.getId());
        ZhfwBrandEntpRecoGetVo vo = new ZhfwBrandEntpRecoGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ZhfwBrandEntpRecoInsertPo zhfwBrandEntpRecoInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwBrandEntpReco zhfwBrandEntpReco = new ZhfwBrandEntpReco();
        ConverterUtil.copyProperties(zhfwBrandEntpRecoInsertPo, zhfwBrandEntpReco);
        zhfwBrandEntpReco.preInsert();
        zhfwBrandEntpRecoMapper.insert(zhfwBrandEntpReco);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ZhfwBrandEntpRecoUpdatePo zhfwBrandEntpRecoUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwBrandEntpReco zhfwBrandEntpReco = new ZhfwBrandEntpReco();
        ConverterUtil.copyProperties(zhfwBrandEntpRecoUpdatePo, zhfwBrandEntpReco);
        zhfwBrandEntpReco.preUpdate();
        zhfwBrandEntpRecoMapper.updateByPrimaryKeySelective(zhfwBrandEntpReco);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ZhfwBrandEntpRecoBatDeletePo zhfwBrandEntpRecoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : zhfwBrandEntpRecoBatDeletePo.getDelList()) {
            ZhfwBrandEntpReco zhfwBrandEntpReco = new ZhfwBrandEntpReco();
            zhfwBrandEntpReco.setId(delId);
            zhfwBrandEntpReco.preUpdate();
            zhfwBrandEntpRecoMapper.deleteLogic(zhfwBrandEntpReco);
        }
        return result;
    }
}
