package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.FeedBackMageMapper;
import com.wisea.transac.common.entity.FeedBackMage;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.po.FeedBackMagePageListPo;
import com.wisea.transac.common.po.FeedBackMagePo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.FeedBackMageInfoVo;
import com.wisea.transac.common.vo.FeedBackMagePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className FeedBackMageService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class FeedBackMageMiNiService extends BaseService {
    @Autowired
    private FeedBackMageMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FeedBackMage
     */
    public ResultPoJo<Page<FeedBackMagePageListVo>> findPageList(FeedBackMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<FeedBackMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<FeedBackMagePageListVo> page = po.getPage();
		List<FeedBackMagePageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除FeedBackMage
     */
	@Transactional(readOnly = false)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		FeedBackMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(FeedBackMage.DEL_FLAG_DELETE);
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
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改FeedBackMage
     */
	@Transactional(readOnly = false)
    public ResultPoJo saveOrUpdate(FeedBackMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

		User user = SystemUtils.getUser();
		//获取会员基本信息
		MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());

		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			FeedBackMage entity = mapper.selectByPrimaryKey(po.getId());
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
			FeedBackMage entity = new FeedBackMage();
			BeanUtils.copyProperties(po, entity);
			entity.setLoginName(membBaseInfo.getLoginName());
			entity.setName(membBaseInfo.getPetName());
			entity.setTel(membBaseInfo.getRegistTel());
			entity.setEntpName(membBaseInfo.getAuthName());
			entity.setProcesStatusType(DictConstants.PROCES_STATUS_TYPE_1);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息FeedBackMage
     */
    public ResultPoJo<FeedBackMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<FeedBackMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		FeedBackMageInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
}
