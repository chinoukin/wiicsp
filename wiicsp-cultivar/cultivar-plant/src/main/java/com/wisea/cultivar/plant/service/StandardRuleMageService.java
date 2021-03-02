package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.mapper.MembCollectionMapper;
import com.wisea.cultivar.plant.mapper.StandardRuleMageMapper;
import com.wisea.cultivar.plant.po.PolicyTechnologyInfoPo;
import com.wisea.cultivar.plant.po.StandardRuleMagePageListPo;
import com.wisea.cultivar.plant.po.linkMagePageListPo;
import com.wisea.cultivar.plant.vo.StandardRuleMageAndLinkVo;
import com.wisea.cultivar.plant.vo.StandardRuleMageInfoVo;
import com.wisea.cultivar.plant.vo.StandardRuleMagePageListVo;
import com.wisea.cultivar.plant.vo.linkMagePageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className StandardRuleMageService
 * @date 2020/08/08 16:53:01
 * @Description
 */
@Service
public class StandardRuleMageService extends BaseService {
    @Autowired
    private StandardRuleMageMapper mapper;
	@Autowired
	private com.wisea.cultivar.plant.mapper.linkMageMapper linkMageMapper;

	@Autowired
	private MembCollectionMapper membCollectionMapper;


	/**
	 * @author wbf-code-generator
	 * @date 2020/08/08 16:53:01
	 * @Description 分页查询StandardRuleMage
	 */
	@Transactional
	public ResultPoJo<StandardRuleMageAndLinkVo> findStandardRuleMagePageList(StandardRuleMagePageListPo po) {
		LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<StandardRuleMageAndLinkVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //包含两个vo的大vo
        StandardRuleMageAndLinkVo standardRuleMageAndLinkVo = new StandardRuleMageAndLinkVo();
        Page<StandardRuleMagePageListVo> page = po.getPage();
        //得到两个vo中的数据
		List<StandardRuleMagePageListVo> list = mapper.findPageList(po);
		List<linkMagePageListVo> linkMageMapperPageList = linkMageMapper.findPageList(new linkMagePageListPo());
		page.setList(list);
        standardRuleMageAndLinkVo.setStandardRuleMagePageListVos(page);
        standardRuleMageAndLinkVo.setLinkMagePageListVos(linkMageMapperPageList);
		resultPoJo.setResult(standardRuleMageAndLinkVo);
		return resultPoJo;
	}


	/**
	 * @author wbf-code-generator
	 * @date 2020/08/08 16:53:01
	 * @Description 查询详细信息StandardRuleMage
	 */
	@Transactional
	public ResultPoJo<StandardRuleMageInfoVo> findStandardRuleMageInfo(PolicyTechnologyInfoPo po) {
		LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<StandardRuleMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		//添加浏览次数
        mapper.updateViewsByKey(po.getId());
        //查询详细信息
		StandardRuleMageInfoVo vo = mapper.findInfo(po.getId());
		//查询是否收藏
		Long collectionId = membCollectionMapper.ifStatus(po);
		if (ConverterUtil.isNotEmpty(collectionId)) {
			vo.setMembCollectionId(collectionId);
			vo.setStatus("0");
		} else {
			vo.setStatus("1");
		}
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}

    public ResultPoJo<String> findOriginalInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查看标准原文：", po);
        ResultPoJo<String> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        String vo = mapper.findOriginalInfo(po);
        if(ConverterUtil.isNotEmpty(vo)){
            resultPoJo.setResult(vo);
        }else{
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }
}
