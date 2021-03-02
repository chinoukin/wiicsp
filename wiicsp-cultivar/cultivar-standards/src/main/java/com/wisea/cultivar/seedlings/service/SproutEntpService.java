package com.wisea.cultivar.seedlings.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.seedlings.entity.SproutEntp;
import com.wisea.cultivar.seedlings.mapper.SproutEntpMapper;
import com.wisea.cultivar.seedlings.po.SproutEntpBatDeletePo;
import com.wisea.cultivar.seedlings.po.SproutEntpGetPo;
import com.wisea.cultivar.seedlings.po.SproutEntpInsertPo;
import com.wisea.cultivar.seedlings.po.SproutEntpListPo;
import com.wisea.cultivar.seedlings.po.SproutEntpPagePo;
import com.wisea.cultivar.seedlings.po.SproutEntpUpdatePo;
import com.wisea.cultivar.seedlings.vo.SeedlingsProVo;
import com.wisea.cultivar.seedlings.vo.SproutEntpGetVo;
import com.wisea.cultivar.seedlings.vo.SproutEntpListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SproutEntpService
 * 定点种苗企业 Service
 * 2020/08/06 14:19:24
 */
@Service
public class SproutEntpService extends BaseService {
    @Autowired
    protected SproutEntpMapper sproutEntpMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<SproutEntpListVo>> findPage(SproutEntpPagePo sproutEntpPagePo) {
        ResultPoJo<Page<SproutEntpListVo>> result = new ResultPoJo<>();
        Page<SproutEntpListVo> page = sproutEntpPagePo.getPage();
        List<SproutEntpListVo> list = sproutEntpMapper.findPage(sproutEntpPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<SproutEntpListVo>> findList(SproutEntpListPo sproutEntpListPo) {
        ResultPoJo<List<SproutEntpListVo>> result = new ResultPoJo<>();
        result.setResult(sproutEntpMapper.findList(sproutEntpListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<SproutEntpGetVo> get(SproutEntpGetPo sproutEntpGetPo) {
        ResultPoJo<SproutEntpGetVo> result = new ResultPoJo<>();
        SproutEntp entity = sproutEntpMapper.selectByPrimaryKey(sproutEntpGetPo.getId());
        SproutEntpGetVo vo = new SproutEntpGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(SproutEntpInsertPo sproutEntpInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SproutEntp sproutEntp = new SproutEntp();
        ConverterUtil.copyProperties(sproutEntpInsertPo, sproutEntp);
        sproutEntp.preInsert();
        sproutEntpMapper.insert(sproutEntp);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(SproutEntpUpdatePo sproutEntpUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SproutEntp sproutEntp = new SproutEntp();
        ConverterUtil.copyProperties(sproutEntpUpdatePo, sproutEntp);
        sproutEntp.preUpdate();
        sproutEntpMapper.updateByPrimaryKeySelective(sproutEntp);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(SproutEntpBatDeletePo sproutEntpBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : sproutEntpBatDeletePo.getDelList()) {
            SproutEntp sproutEntp = new SproutEntp();
            sproutEntp.setId(delId);
            sproutEntp.preUpdate();
            sproutEntpMapper.deleteLogic(sproutEntp);
        }
        return result;
    }

    /**
     * 定点采购企业种苗占比
     * @param id
     * @return
     */
    public ResultPoJo<List<SeedlingsProVo>> provSeedling(Long id) {
        ResultPoJo<List<SeedlingsProVo>> result = new ResultPoJo<>();
        result.setResult(sproutEntpMapper.selectProvSeedlingById(id));
        return result;
    }
}
