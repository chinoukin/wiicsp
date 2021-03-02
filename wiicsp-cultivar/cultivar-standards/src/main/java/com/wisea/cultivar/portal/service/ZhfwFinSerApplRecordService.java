package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.entity.ZhfwFinSerApplRecord;
import com.wisea.cultivar.portal.mapper.ZhfwFinSerApplRecordMapper;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordGetPo;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordInsertPo;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordListPo;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordPagePo;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordUpdatePo;
import com.wisea.cultivar.portal.vo.ZhfwFinSerApplRecordGetVo;
import com.wisea.cultivar.portal.vo.ZhfwFinSerApplRecordListVo;

import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ZhfwFinSerApplRecordService
 * 种植服务金融服务申请记录 Service
 * 2020/08/24 20:28:13
 */
@Service
public class ZhfwFinSerApplRecordService extends BaseService {
    @Autowired
    protected ZhfwFinSerApplRecordMapper zhfwFinSerApplRecordMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZhfwFinSerApplRecordListVo>> findPage(ZhfwFinSerApplRecordPagePo zhfwFinSerApplRecordPagePo) {
        ResultPoJo<Page<ZhfwFinSerApplRecordListVo>> result = new ResultPoJo<>();
        Page<ZhfwFinSerApplRecordListVo> page = zhfwFinSerApplRecordPagePo.getPage();
        List<ZhfwFinSerApplRecordListVo> list = zhfwFinSerApplRecordMapper.findPage(zhfwFinSerApplRecordPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ZhfwFinSerApplRecordListVo>> findList(ZhfwFinSerApplRecordListPo zhfwFinSerApplRecordListPo) {
        ResultPoJo<List<ZhfwFinSerApplRecordListVo>> result = new ResultPoJo<>();
        result.setResult(zhfwFinSerApplRecordMapper.findList(zhfwFinSerApplRecordListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZhfwFinSerApplRecordGetVo> get(ZhfwFinSerApplRecordGetPo zhfwFinSerApplRecordGetPo) {
        ResultPoJo<ZhfwFinSerApplRecordGetVo> result = new ResultPoJo<>();
        ZhfwFinSerApplRecord entity = zhfwFinSerApplRecordMapper.selectByPrimaryKey(zhfwFinSerApplRecordGetPo.getId());
        ZhfwFinSerApplRecordGetVo vo = new ZhfwFinSerApplRecordGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ZhfwFinSerApplRecordInsertPo zhfwFinSerApplRecordInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwFinSerApplRecord zhfwFinSerApplRecord = new ZhfwFinSerApplRecord();
        ConverterUtil.copyProperties(zhfwFinSerApplRecordInsertPo, zhfwFinSerApplRecord);
        zhfwFinSerApplRecord.preInsert();
        zhfwFinSerApplRecord.setApplDate(OffsetDateTime.now());
        zhfwFinSerApplRecordMapper.insert(zhfwFinSerApplRecord);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ZhfwFinSerApplRecordUpdatePo zhfwFinSerApplRecordUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwFinSerApplRecord zhfwFinSerApplRecord = new ZhfwFinSerApplRecord();
        ConverterUtil.copyProperties(zhfwFinSerApplRecordUpdatePo, zhfwFinSerApplRecord);
        zhfwFinSerApplRecord.preUpdate();
        zhfwFinSerApplRecordMapper.updateByPrimaryKeySelective(zhfwFinSerApplRecord);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ZhfwFinSerApplRecordBatDeletePo zhfwFinSerApplRecordBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : zhfwFinSerApplRecordBatDeletePo.getDelList()) {
            ZhfwFinSerApplRecord zhfwFinSerApplRecord = new ZhfwFinSerApplRecord();
            zhfwFinSerApplRecord.setId(delId);
            zhfwFinSerApplRecord.preUpdate();
            zhfwFinSerApplRecordMapper.deleteLogic(zhfwFinSerApplRecord);
        }
        return result;
    }
}
