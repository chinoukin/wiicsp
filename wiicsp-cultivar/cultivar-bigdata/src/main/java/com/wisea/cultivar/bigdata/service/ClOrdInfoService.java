package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.bigdata.ClOrdInfoMapper;
import com.wisea.cultivar.common.entity.bigdata.ClOrdInfo;
import com.wisea.cultivar.common.po.bigdata.ClOrdInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.ClOrdInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.ClOrdInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.ClOrdInfoListPo;
import com.wisea.cultivar.common.po.bigdata.ClOrdInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.ClOrdInfoUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.ClOrdInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.ClOrdInfoListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClOrdInfoService
 * 处理订单详情 Service
 * 2019/12/02 11:02:14
 */
@Service
public class ClOrdInfoService extends BaseService {
    @Autowired
    protected ClOrdInfoMapper clOrdInfoMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ClOrdInfoListVo>> findPage(ClOrdInfoPagePo clOrdInfoPagePo) {
        ResultPoJo<Page<ClOrdInfoListVo>> result = new ResultPoJo<>();
        Page<ClOrdInfoListVo> page = clOrdInfoPagePo.getPage();
        List<ClOrdInfoListVo> list = clOrdInfoMapper.findPage(clOrdInfoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ClOrdInfoListVo>> findList(ClOrdInfoListPo clOrdInfoListPo) {
        ResultPoJo<List<ClOrdInfoListVo>> result = new ResultPoJo<>();
        result.setResult(clOrdInfoMapper.findList(clOrdInfoListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ClOrdInfoGetVo> get(ClOrdInfoGetPo clOrdInfoGetPo) {
        ResultPoJo<ClOrdInfoGetVo> result = new ResultPoJo<>();
        ClOrdInfo entity = clOrdInfoMapper.selectByPrimaryKey(clOrdInfoGetPo.getId());
        ClOrdInfoGetVo vo = new ClOrdInfoGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ClOrdInfoInsertPo clOrdInfoInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ClOrdInfo clOrdInfo = new ClOrdInfo();
        ConverterUtil.copyProperties(clOrdInfoInsertPo, clOrdInfo);
        clOrdInfo.preInsert();
        clOrdInfoMapper.insert(clOrdInfo);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ClOrdInfoUpdatePo clOrdInfoUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ClOrdInfo clOrdInfo = new ClOrdInfo();
        ConverterUtil.copyProperties(clOrdInfoUpdatePo, clOrdInfo);
        clOrdInfo.preUpdate();
        clOrdInfoMapper.updateByPrimaryKeySelective(clOrdInfo);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ClOrdInfoBatDeletePo clOrdInfoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : clOrdInfoBatDeletePo.getDelList()) {
            ClOrdInfo clOrdInfo = new ClOrdInfo();
            clOrdInfo.setId(delId);
            clOrdInfo.preUpdate();
            clOrdInfoMapper.deleteLogic(clOrdInfo);
        }
        return result;
    }
}
