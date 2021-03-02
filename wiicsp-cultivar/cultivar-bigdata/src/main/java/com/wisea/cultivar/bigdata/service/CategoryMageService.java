package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.bigdata.CategoryMageMapper;
import com.wisea.cultivar.common.entity.bigdata.CategoryMage;
import com.wisea.cultivar.common.po.bigdata.CategoryMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.CategoryMageGetPo;
import com.wisea.cultivar.common.po.bigdata.CategoryMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.CategoryMageListPo;
import com.wisea.cultivar.common.po.bigdata.CategoryMagePagePo;
import com.wisea.cultivar.common.po.bigdata.CategoryMageUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.CategoryMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.CategoryMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * CategoryMageService
 * 品类管理 Service
 * 2019/12/03 14:35:19
 */
@Service
public class CategoryMageService extends BaseService {
    @Autowired
    protected CategoryMageMapper categoryMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<CategoryMageListVo>> findPage(CategoryMagePagePo categoryMagePagePo) {
        ResultPoJo<Page<CategoryMageListVo>> result = new ResultPoJo<>();
        Page<CategoryMageListVo> page = categoryMagePagePo.getPage();
        List<CategoryMageListVo> list = categoryMageMapper.findPage(categoryMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<CategoryMageListVo>> findList(CategoryMageListPo categoryMageListPo) {
        ResultPoJo<List<CategoryMageListVo>> result = new ResultPoJo<>();
        result.setResult(categoryMageMapper.findList(categoryMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<CategoryMageGetVo> get(CategoryMageGetPo categoryMageGetPo) {
        ResultPoJo<CategoryMageGetVo> result = new ResultPoJo<>();
        CategoryMage entity = categoryMageMapper.selectByPrimaryKey(categoryMageGetPo.getId());
        CategoryMageGetVo vo = new CategoryMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(CategoryMageInsertPo categoryMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        CategoryMage categoryMage = new CategoryMage();
        ConverterUtil.copyProperties(categoryMageInsertPo, categoryMage);
        if (ConverterUtil.isNotEmpty(categoryMageMapper.cheakRepetition(categoryMage))) {
        	  result.setCode(ConstantCodeMsg.MSG_510);
              result.setMsg(ConstantCodeMsg.MSG_510);
              return result;
		}
        categoryMage.preInsert();
        categoryMageMapper.insertSelective(categoryMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(CategoryMageUpdatePo categoryMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        CategoryMage categoryMage = new CategoryMage();
        ConverterUtil.copyProperties(categoryMageUpdatePo, categoryMage);
        if (ConverterUtil.isNotEmpty(categoryMageMapper.cheakRepetition(categoryMage))) {
      	    result.setCode(ConstantCodeMsg.MSG_510);
            result.setMsg(ConstantCodeMsg.MSG_510);
            return result;
		}
        categoryMage.preUpdate();
        categoryMageMapper.updateByPrimaryKeySelective(categoryMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(CategoryMageBatDeletePo categoryMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : categoryMageBatDeletePo.getDelList()) {
            CategoryMage categoryMage = new CategoryMage();
            categoryMage.setId(delId);
            categoryMage.preUpdate();
            categoryMageMapper.deleteLogic(categoryMage);
        }
        return result;
    }

    /**
     * 导出品类管理
     * @param po
     * @param response
     * @return
     * @throws IOException
     */
	public ResultPoJo<Object> export(CategoryMageListPo po, HttpServletResponse response) throws IOException {
		ResultPoJo<Object> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

		List<CategoryMageListVo> list = categoryMageMapper.findList(po);
		String fileName = "品类管理信息.xlsx";
		ExportExcel exportExcel = new ExportExcel("品类管理信息", CategoryMageListVo.class);
		exportExcel.setDataList(list).writeWithAjaxHeader(response, fileName).dispose();
		return pojo;
	}
}
