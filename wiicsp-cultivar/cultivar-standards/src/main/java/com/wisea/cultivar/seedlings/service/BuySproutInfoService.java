package com.wisea.cultivar.seedlings.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.seedlings.entity.BuySproutInfo;
import com.wisea.cultivar.seedlings.mapper.BuySproutInfoMapper;
import com.wisea.cultivar.seedlings.po.BuySproutInfoBatDeletePo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoGetPo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoInsertPo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoListPo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoPagePo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoUpdatePo;
import com.wisea.cultivar.seedlings.vo.BuySproutInfoGetVo;
import com.wisea.cultivar.seedlings.vo.BuySproutInfoListVo;
import java.util.List;

import com.wisea.cultivar.seedlings.vo.SeedlingsProVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * BuySproutInfoService
 * 购苗信息 Service
 * 2020/08/06 14:19:24
 */
@Service
public class BuySproutInfoService extends BaseService {
    @Autowired
    protected BuySproutInfoMapper buySproutInfoMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<BuySproutInfoListVo>> findPage(BuySproutInfoPagePo buySproutInfoPagePo) {
        ResultPoJo<Page<BuySproutInfoListVo>> result = new ResultPoJo<>();
        Page<BuySproutInfoListVo> page = buySproutInfoPagePo.getPage();
        List<BuySproutInfoListVo> list = buySproutInfoMapper.findPage(buySproutInfoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<BuySproutInfoListVo>> findList(BuySproutInfoListPo buySproutInfoListPo) {
        ResultPoJo<List<BuySproutInfoListVo>> result = new ResultPoJo<>();
        List<BuySproutInfoListVo> list = buySproutInfoMapper.findList(buySproutInfoListPo);
        result.setResult(list);
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<BuySproutInfoGetVo> get(BuySproutInfoGetPo buySproutInfoGetPo) {
        ResultPoJo<BuySproutInfoGetVo> result = new ResultPoJo<>();
        BuySproutInfo entity = buySproutInfoMapper.selectByPrimaryKey(buySproutInfoGetPo.getId());
        BuySproutInfoGetVo vo = new BuySproutInfoGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(BuySproutInfoInsertPo buySproutInfoInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        BuySproutInfo buySproutInfo = new BuySproutInfo();
        ConverterUtil.copyProperties(buySproutInfoInsertPo, buySproutInfo);
        buySproutInfo.preInsert();
        buySproutInfoMapper.insert(buySproutInfo);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(BuySproutInfoUpdatePo buySproutInfoUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        BuySproutInfo buySproutInfo = new BuySproutInfo();
        ConverterUtil.copyProperties(buySproutInfoUpdatePo, buySproutInfo);
        buySproutInfo.preUpdate();
        buySproutInfoMapper.updateByPrimaryKeySelective(buySproutInfo);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(BuySproutInfoBatDeletePo buySproutInfoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : buySproutInfoBatDeletePo.getDelList()) {
            BuySproutInfo buySproutInfo = new BuySproutInfo();
            buySproutInfo.setId(delId);
            buySproutInfo.preUpdate();
            buySproutInfoMapper.deleteLogic(buySproutInfo);
        }
        return result;
    }

    /**
     * 种苗种植户购苗占比
     * @param id
     * @return
     */
    public ResultPoJo<List<SeedlingsProVo>> porSeedling(Long id) {
        ResultPoJo<List<SeedlingsProVo>> result = new ResultPoJo<>();
        result.setResult(buySproutInfoMapper.selectPorSeedlingById(id));
        return result;
    }
}
