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
import com.wisea.cultivar.plant.entity.SerListInformation;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.mapper.SerListInformationMapper;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.po.SerListInformationPageListPo;
import com.wisea.cultivar.plant.po.SerListInformationPo;
import com.wisea.cultivar.plant.vo.SerListInformationInfoVo;
import com.wisea.cultivar.plant.vo.SerListInformationPageListVo;
import com.wisea.cultivar.plant.vo.SerListMageInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SerListInformationService
 * @date 2020/08/13 11:33:06
 * @Description
 */
@Service
public class SerListInformationService extends BaseService {
    @Autowired
    private SerListInformationMapper mapper;
	@Autowired
	private ZhfwMembInfoMapper zhfwMembInfoMapper;
	@Autowired
	private SerListMageService serListMageService;

    /**
     * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
     * @Description 分页查询SerListInformation
     */
    public ResultPoJo<Page<SerListInformationPageListVo>> findPageList(SerListInformationPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<SerListInformationPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		User user = SystemUtils.getUser();
		//获取当前登录的用户会员信息
		ZhfwMembInfo zhfwMembInfo = zhfwMembInfoMapper.selectByPrimaryKey(user.getId());
		if (ConverterUtil.isEmpty(zhfwMembInfo)) {//用户信息不存在
			resultPoJo.setCode(ConstantCodeMsg.ERR_505);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_505);
			return resultPoJo;
		}
		po.setMembId(user.getId());
		Page<SerListInformationPageListVo> page = po.getPage();
		List<SerListInformationPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
     * @Description 逻辑删除SerListInformation
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SerListInformation entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(SerListInformation.DEL_FLAG_DELETE);
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
     * @date 2020/08/13 11:33:06
     * @Description 新增或修改SerListInformation
     */
    public ResultPoJo saveOrUpdate(SerListInformationPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			SerListInformation entity = mapper.selectByPrimaryKey(po.getId());
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
			SerListInformation entity = new SerListInformation();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
     * @Description 查询详细信息SerListInformation
     */
	public ResultPoJo<SerListMageInfoVo> findInfo(LongIdPo po) {
		LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		//更改状态
		mapper.updateState(po);
		SerListInformationInfoVo information = mapper.findInfo(po);
		LongIdPo longIdPo = new LongIdPo();
		longIdPo.setId(information.getSerListId());
		//获取服务单详情
		ResultPoJo<SerListMageInfoVo> info = serListMageService.findInfo(longIdPo);
		return info;
    }

	public ResultPoJo<Integer> countInformation() {
		ResultPoJo<Integer> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		User user = SystemUtils.getUser();
		//获取当前登录的用户会员信息
		ZhfwMembInfo zhfwMembInfo = zhfwMembInfoMapper.selectByPrimaryKey(user.getId());
		if (ConverterUtil.isEmpty(zhfwMembInfo)) {//用户信息不存在
			resultPoJo.setCode(ConstantCodeMsg.ERR_505);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_505);
			return resultPoJo;
		}
		Integer vo = mapper.countInformation(user.getId());
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}

	public ResultPoJo toRead() {
		ResultPoJo<Integer> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		User user = SystemUtils.getUser();
		//获取当前登录的用户会员信息
		ZhfwMembInfo zhfwMembInfo = zhfwMembInfoMapper.selectByPrimaryKey(user.getId());
		if (ConverterUtil.isEmpty(zhfwMembInfo)) {//用户信息不存在
			resultPoJo.setCode(ConstantCodeMsg.ERR_505);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_505);
			return resultPoJo;
		}
		mapper.toRead(user.getId());

		return resultPoJo;

	}
}
