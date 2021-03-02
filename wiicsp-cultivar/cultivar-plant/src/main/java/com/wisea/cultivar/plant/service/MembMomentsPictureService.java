package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.MembMomentsPicture;
import com.wisea.cultivar.plant.mapper.MembMomentsPictureMapper;
import com.wisea.cultivar.plant.po.MembMomentsPicturePageListPo;
import com.wisea.cultivar.plant.po.MembMomentsPicturePo;
import com.wisea.cultivar.plant.vo.MembMomentsPictureInfoVo;
import com.wisea.cultivar.plant.vo.MembMomentsPicturePageListVo;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className MembMomentsPictureService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class MembMomentsPictureService extends BaseService {
    @Autowired
    private MembMomentsPictureMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询MembMomentsPicture
     */
    public ResultPoJo<Page<MembMomentsPicturePageListVo>> findPageList(MembMomentsPicturePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<MembMomentsPicturePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<MembMomentsPicturePageListVo> page = po.getPage();
		List<MembMomentsPicturePageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除MembMomentsPicture
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembMomentsPicture entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(MembMomentsPicture.DEL_FLAG_DELETE);
			entity.preUpdate();
			mapper.updateByPrimaryKey(entity);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 新增或修改MembMomentsPicture
     */
    public ResultPoJo saveOrUpdate(MembMomentsPicturePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			MembMomentsPicture entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增
			MembMomentsPicture entity = new MembMomentsPicture();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息MembMomentsPicture
     */
    public ResultPoJo<MembMomentsPictureInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<MembMomentsPictureInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembMomentsPictureInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
}
