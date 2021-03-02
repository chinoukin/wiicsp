package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.entity.ZhfwCultureZxReco;
import com.wisea.cultivar.portal.mapper.ZhfwCultureZxRecoMapper;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoGetPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoInsertPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoListPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoPagePo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoUpdatePo;
import com.wisea.cultivar.portal.vo.ZhfwCultureZxRecoGetVo;
import com.wisea.cultivar.portal.vo.ZhfwCultureZxRecoListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ZhfwCultureZxRecoService
 * 种植服务文化资讯推荐 Service
 * 2020/08/24 20:28:13
 */
@Service
public class ZhfwCultureZxRecoService extends BaseService {
    @Autowired
    protected ZhfwCultureZxRecoMapper zhfwCultureZxRecoMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZhfwCultureZxRecoListVo>> findPage(ZhfwCultureZxRecoPagePo zhfwCultureZxRecoPagePo) {
        ResultPoJo<Page<ZhfwCultureZxRecoListVo>> result = new ResultPoJo<>();
        Page<ZhfwCultureZxRecoListVo> page = zhfwCultureZxRecoPagePo.getPage();
        List<ZhfwCultureZxRecoListVo> list = zhfwCultureZxRecoMapper.findPage(zhfwCultureZxRecoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ZhfwCultureZxRecoListVo>> findList(ZhfwCultureZxRecoListPo zhfwCultureZxRecoListPo) {
        ResultPoJo<List<ZhfwCultureZxRecoListVo>> result = new ResultPoJo<>();
        result.setResult(zhfwCultureZxRecoMapper.findList(zhfwCultureZxRecoListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZhfwCultureZxRecoGetVo> get(ZhfwCultureZxRecoGetPo zhfwCultureZxRecoGetPo) {
        ResultPoJo<ZhfwCultureZxRecoGetVo> result = new ResultPoJo<>();
        ZhfwCultureZxReco entity = zhfwCultureZxRecoMapper.selectByPrimaryKey(zhfwCultureZxRecoGetPo.getId());
        ZhfwCultureZxRecoGetVo vo = new ZhfwCultureZxRecoGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ZhfwCultureZxRecoInsertPo zhfwCultureZxRecoInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwCultureZxReco zhfwCultureZxReco = new ZhfwCultureZxReco();
        ConverterUtil.copyProperties(zhfwCultureZxRecoInsertPo, zhfwCultureZxReco);
        zhfwCultureZxReco.preInsert();
        zhfwCultureZxRecoMapper.insert(zhfwCultureZxReco);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ZhfwCultureZxRecoUpdatePo zhfwCultureZxRecoUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwCultureZxReco zhfwCultureZxReco = new ZhfwCultureZxReco();
        ConverterUtil.copyProperties(zhfwCultureZxRecoUpdatePo, zhfwCultureZxReco);
        zhfwCultureZxReco.preUpdate();
        zhfwCultureZxRecoMapper.updateByPrimaryKeySelective(zhfwCultureZxReco);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ZhfwCultureZxRecoBatDeletePo zhfwCultureZxRecoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : zhfwCultureZxRecoBatDeletePo.getDelList()) {
            ZhfwCultureZxReco zhfwCultureZxReco = new ZhfwCultureZxReco();
            zhfwCultureZxReco.setId(delId);
            zhfwCultureZxReco.preUpdate();
            zhfwCultureZxRecoMapper.deleteLogic(zhfwCultureZxReco);
        }
        return result;
    }
}
