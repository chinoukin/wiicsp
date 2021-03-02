package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.mapper.KnowledgeBaseMageMapper;
import com.wisea.cultivar.plant.mapper.MembCollectionMapper;
import com.wisea.cultivar.plant.po.KnowledgeBaseMagePageListPo;
import com.wisea.cultivar.plant.po.PolicyTechnologyInfoPo;
import com.wisea.cultivar.plant.vo.KnowledgeBaseMageInfoVo;
import com.wisea.cultivar.plant.vo.KnowledgeBaseMagePageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className KnowledgeBaseMageService
 * @date 2020/08/08 14:38:07
 * @Description
 */
@Service
public class KnowledgeBaseMageService extends BaseService {
    @Autowired
    private KnowledgeBaseMageMapper mapper;
	@Autowired
	private MembCollectionMapper membCollectionMapper;
    /**
     * @author wbf-code-generator
     * @date 2020/08/08 14:38:07
     * @Description 分页查询KnowledgeBaseMage
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Page<KnowledgeBaseMagePageListVo>> findPageList(KnowledgeBaseMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<KnowledgeBaseMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<KnowledgeBaseMagePageListVo> page = po.getPage();
		List<KnowledgeBaseMagePageListVo> list = mapper.findPageList(po);
        Optional.ofNullable(list).ifPresent(s->{
            s.stream().forEach(i->{
                String url = mapper.findByIdPicture(i.getId());
                if (ConverterUtil.isNotEmpty(url)) {
                    i.setUrl(url);
                }
            });
        });
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/08 14:38:07
     * @Description 查询详细信息KnowledgeBaseMage
     */
    @Transactional
    public ResultPoJo<KnowledgeBaseMageInfoVo> findInfo(PolicyTechnologyInfoPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<KnowledgeBaseMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //添加浏览次数
		mapper.updateViewsByKey(po.getId());
        //查询数据详细信息
		KnowledgeBaseMageInfoVo vo = mapper.findInfo(po.getId());
		//查询是否收藏
		Long collectionId = membCollectionMapper.ifStatus(po);
		if (ConverterUtil.isNotEmpty(collectionId)) {
			vo.setMembCollectionId(collectionId);
			vo.setStatus("0");
		}else {
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
}
