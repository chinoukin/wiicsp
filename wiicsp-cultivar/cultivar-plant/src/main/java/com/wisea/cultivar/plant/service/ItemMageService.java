package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.mapper.ItemMageMapper;
import com.wisea.cultivar.plant.mapper.ZhfwCommPictureMapper;
import com.wisea.cultivar.plant.mapper.ZhfwCommPubInfoMapper;
import com.wisea.cultivar.plant.po.ItemMagePageListPo;
import com.wisea.cultivar.plant.po.ZhfwCommPubInfoPageListPo;
import com.wisea.cultivar.plant.vo.ItemMageInfoVo;
import com.wisea.cultivar.plant.vo.ItemMagePageListVo;
import com.wisea.cultivar.plant.vo.ZhfwCommPictureInfoVo;
import com.wisea.cultivar.plant.vo.ZhfwCommPubInfoPageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ItemMageService
 * @date 2020/08/08 09:47:10
 * @Description
 */
@Service
public class ItemMageService extends BaseService {
    @Autowired
    private ItemMageMapper mapper;

	@Autowired
	private ZhfwCommPubInfoMapper zhfwCommPubInfoMapper;
    @Autowired
    private ZhfwCommPictureMapper zhfwCommPictureMapper;



    /**
     * @author wbf-code-generator
     * @date 2020/08/08 09:47:10
     * @Description 分页查询ItemMage
     */
    public ResultPoJo<Page<ItemMagePageListVo>> findItemMagePageList(ItemMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<ItemMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<ItemMagePageListVo> page = po.getPage();
        List<ItemMagePageListVo> list = mapper.findItemMagePageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }
    @Transactional(readOnly = false)
	public ResultPoJo<ItemMageInfoVo> findGuideInfo(LongIdPo po) {
		LoggerUtil.infoWithContext("【findGuideInfo】查询申请指南：", po);
		ResultPoJo<ItemMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ItemMageInfoVo vo = mapper.findGuideInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}


	/**
	 * @author wbf-code-generator
	 * @date 2020/08/06 18:28:39
	 * @Description 分页查询ZhfwCommPubInfo
	 */
	public ResultPoJo<Page<ZhfwCommPubInfoPageListVo>> findPurchasePageList(ZhfwCommPubInfoPageListPo po) {
		LoggerUtil.infoWithContext("【findPurchasePageList】分页查询列表：", po);
		ResultPoJo<Page<ZhfwCommPubInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<ZhfwCommPubInfoPageListVo> page = po.getPage();
		List<ZhfwCommPubInfoPageListVo> list = zhfwCommPubInfoMapper.findPurchasePageList(po);
        Optional.ofNullable(list).ifPresent(s->{s.stream().forEach(l->{
            List<ZhfwCommPictureInfoVo> zhfwCommPictureInfoVo = zhfwCommPictureMapper.findByCommPubId(l.getId());
            if(ConverterUtil.isNotEmpty(zhfwCommPictureInfoVo)){
                l.setUrl(zhfwCommPictureInfoVo.get(0).getUrl());
            }
        });});
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
	}


	/*    *//**
     * @author wbf-code-generator
     * @date 2020/08/08 09:47:10
     * @Description 逻辑删除ItemMage
     *//*
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ItemMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(ItemMage.DEL_FLAG_DELETE);
			entity.preUpdate();
			mapper.updateByPrimaryKey(entity);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    *//**
     * @author wbf-code-generator
     * @date 2020/08/08 09:47:10
     * @Description 新增或修改ItemMage
     *//*
    public ResultPoJo saveOrUpdate(ItemMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			ItemMage entity = mapper.selectByPrimaryKey(po.getId());
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
			ItemMage entity = new ItemMage();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    *//**
     * @author wbf-code-generator
     * @date 2020/08/08 09:47:10
     * @Description 查询详细信息ItemMage
     *//*
    public ResultPoJo<ItemMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<ItemMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ItemMageInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }*/
}
