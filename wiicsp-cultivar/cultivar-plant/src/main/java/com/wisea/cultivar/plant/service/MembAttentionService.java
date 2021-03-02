package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.utils.BeanCopyUtils;
import com.wisea.cultivar.plant.entity.MembAttention;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.mapper.MembAttentionMapper;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.po.MembAttentionCyqPo;
import com.wisea.cultivar.plant.po.MembAttentionPageListPo;
import com.wisea.cultivar.plant.po.MembAttentionPo;
import com.wisea.cultivar.plant.vo.MembAttentionInfoVo;
import com.wisea.cultivar.plant.vo.MembAttentionPageListVo;
import com.wisea.cultivar.plant.vo.oritrapla.MembBaseInfoVo;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className MembAttentionService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class MembAttentionService extends BaseService {
    @Autowired
    private MembAttentionMapper mapper;
	@Autowired
	private ZhfwMembInfoMapper zhfwMembInfoMapper;
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询MembAttention
     */
    public ResultPoJo<Page<MembAttentionPageListVo>> findPageList(MembAttentionPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<MembAttentionPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		//获取当前登录的用户信息
		User user = SystemUtils.getUser();
		//获取当前登录的用户会员信息
		ZhfwMembInfo zhfwMembInfo = zhfwMembInfoMapper.selectByPrimaryKey(user.getId());
		if (ConverterUtil.isEmpty(zhfwMembInfo)) {//用户信息不存在
			resultPoJo.setCode(ConstantCodeMsg.ERR_505);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_505);
			return resultPoJo;
		}
		po.setMembId(user.getId());
		Page<MembAttentionPageListVo> page = po.getPage();
		List<MembAttentionPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除MembAttention
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembAttention entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(MembAttention.DEL_FLAG_DELETE);
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
     * @Description 新增或修改MembAttention
     */
	@Transactional(rollbackFor = Exception.class)
    public ResultPoJo<MembAttentionInfoVo> saveOrUpdate(MembAttentionPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo<MembAttentionInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembAttentionInfoVo membAttentionInfoVo = new MembAttentionInfoVo();
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			MembAttention entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
				BeanUtils.copyProperties(entity, membAttentionInfoVo);

			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			MembBaseInfoVo membBaseInfoById = zhfwMembInfoMapper.getMembBaseInfoById(po.getMembAttentionId());
			if (ConverterUtil.isEmpty(membBaseInfoById)){
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
				return resultPoJo;
			}

			List<MembAttentionInfoVo> listByMemberIdAndMembAttentionId = mapper.findListByMemberIdAndMembAttentionId(po);
			if (ConverterUtil.isNotEmpty(listByMemberIdAndMembAttentionId)){
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
				return resultPoJo;
			}
			//新增
			MembAttention entity = new MembAttention();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
			BeanUtils.copyProperties(entity, membAttentionInfoVo);
			membAttentionInfoVo.setId(entity.getId());
		}
		resultPoJo.setResult(membAttentionInfoVo);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息MembAttention
     */
//    public ResultPoJo<MembAttentionInfoVo> findInfo(LongIdPo po) {
//        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
//		ResultPoJo<MembAttentionInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
//		MembAttentionInfoVo vo = mapper.findInfo(po);
//		if(ConverterUtil.isNotEmpty(vo)){
//			resultPoJo.setResult(vo);
//		}else{
//			resultPoJo.setCode(ConstantError.ERR_004);
//			resultPoJo.setMsg(ConstantError.MSG_004);
//		}
//		return resultPoJo;
//    }

	/**
	 * 取消关注
	 * @param po
	 * @return
	 */
	public ResultPoJo<MembAttentionInfoVo> cancel(MembAttentionCyqPo po) {
		ResultPoJo<MembAttentionInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		// check
		StringBuffer errMsg = new StringBuffer();
		if (po.getId() == null) {
			errMsg.append("id不能为空;");
		}

		if (errMsg.length() > 0) {
			resultPoJo.setCode("70044");
			resultPoJo.setMsg(errMsg.toString());
			return resultPoJo;
		}
		mapper.deleteByPrimaryKey(po.getId());
		return resultPoJo;
    }

	/**
	 * 关注情况查询
	 * @param po
	 * @return
	 */
	public ResultPoJo<MembAttentionInfoVo> findInfo(MembAttentionCyqPo po) {
		ResultPoJo<MembAttentionInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		// check
		StringBuffer errMsg = new StringBuffer();
		if (ConverterUtil.isEmpty(po.getMembAttentionType())) {
			errMsg.append("关注类型[membAttentionType]不能为空;");
		}
		if (po.getMembAttentionId() == null) {
			errMsg.append("被关注会员id[membAttentionId]不能为空");
		}
		if (errMsg.length() > 0) {
			resultPoJo.setCode("70045");
			resultPoJo.setMsg(errMsg.toString());
			return resultPoJo;
		}
		po.setMembId(SystemUtils.getUser().getId());

		MembAttention membAttention = new MembAttention();
		BeanCopyUtils.copyPropertiesIgnoreNull(po, membAttention);
		MembAttentionInfoVo vo = mapper.findInfoByConditions(membAttention);

		resultPoJo.setResult(vo);
		return resultPoJo;
	}
}
