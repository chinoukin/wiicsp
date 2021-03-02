package com.wisea.cultivar.seedlings.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.seedlings.entity.CheckFile;
import com.wisea.cultivar.seedlings.mapper.CheckFileMapper;
import com.wisea.cultivar.seedlings.po.CheckFileBatDeletePo;
import com.wisea.cultivar.seedlings.po.CheckFileGetPo;
import com.wisea.cultivar.seedlings.po.CheckFileInsertPo;
import com.wisea.cultivar.seedlings.po.CheckFileListPo;
import com.wisea.cultivar.seedlings.po.CheckFilePagePo;
import com.wisea.cultivar.seedlings.po.CheckFileUpdatePo;
import com.wisea.cultivar.seedlings.vo.CheckFileGetVo;
import com.wisea.cultivar.seedlings.vo.CheckFileListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CheckFileService
 * 验收材料 Service
 * 2020/08/06 14:19:24
 */
@Service
public class CheckFileService extends BaseService {
    @Autowired
    protected CheckFileMapper checkFileMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<CheckFileListVo>> findPage(CheckFilePagePo checkFilePagePo) {
        ResultPoJo<Page<CheckFileListVo>> result = new ResultPoJo<>();
        Page<CheckFileListVo> page = checkFilePagePo.getPage();
        List<CheckFileListVo> list = checkFileMapper.findPage(checkFilePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<CheckFileListVo>> findList(CheckFileListPo checkFileListPo) {
        ResultPoJo<List<CheckFileListVo>> result = new ResultPoJo<>();
        result.setResult(checkFileMapper.findList(checkFileListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<CheckFileGetVo> get(CheckFileGetPo checkFileGetPo) {
        ResultPoJo<CheckFileGetVo> result = new ResultPoJo<>();
        CheckFile entity = checkFileMapper.selectByPrimaryKey(checkFileGetPo.getId());
        CheckFileGetVo vo = new CheckFileGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(CheckFileInsertPo checkFileInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        CheckFile checkFile = new CheckFile();
        ConverterUtil.copyProperties(checkFileInsertPo, checkFile);
        checkFile.preInsert();
        checkFileMapper.insert(checkFile);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(CheckFileUpdatePo checkFileUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        CheckFile checkFile = new CheckFile();
        ConverterUtil.copyProperties(checkFileUpdatePo, checkFile);
        checkFile.preUpdate();
        checkFileMapper.updateByPrimaryKeySelective(checkFile);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(CheckFileBatDeletePo checkFileBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : checkFileBatDeletePo.getDelList()) {
            CheckFile checkFile = new CheckFile();
            checkFile.setId(delId);
            checkFile.preUpdate();
            checkFileMapper.deleteLogic(checkFile);
        }
        return result;
    }
}
