package com.wisea.cultivar.origin.service;

import java.util.ArrayList;
import java.util.List;

import com.wisea.cultivar.origin.constants.ConstantCodeMsg;
import com.wisea.cultivar.origin.constants.DictConstants;
import com.wisea.cultivar.origin.dao.OrmJudgeMeetInfoMapper;
import com.wisea.cultivar.origin.entity.JudgeMeetInfo;
import com.wisea.cultivar.origin.entity.SampInfo;
import com.wisea.cultivar.origin.dao.OrmSampInfoMapper;
import com.wisea.cultivar.origin.dao.OrmSampPictureMapper;
import com.wisea.cultivar.origin.util.OffsetDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.origin.entity.SampPicture;
import com.wisea.cultivar.origin.po.CheckJudgeMeetNamePo;
import com.wisea.cultivar.origin.po.ImgListPo;
import com.wisea.cultivar.origin.po.JudgeMeetChoiceListPo;
import com.wisea.cultivar.origin.po.JudgeMeetListPo;
import com.wisea.cultivar.origin.po.JudgeMeetListWebPo;
import com.wisea.cultivar.origin.po.LongIdPo;
import com.wisea.cultivar.origin.po.SaveOrUpdJudgeMeetPo;
import com.wisea.cultivar.origin.vo.ImgListVo;
import com.wisea.cultivar.origin.vo.JudgeMeetInfoVo;
import com.wisea.cultivar.origin.vo.JudgeMeetListVo;
import com.wisea.cultivar.origin.vo.JudgeMeetListWebVo;
import com.wisea.cultivar.origin.vo.ReportImgListVo;

/**
 *
 * @author wzx
 *
 *         品鉴会app service
 */
@Service
public class JudgeMeetInfoService extends BaseService {

	@Autowired
	private OrmJudgeMeetInfoMapper mapper;

	@Autowired
	private OrmSampPictureMapper sampPictureMapper;

	@Autowired
	private OrmSampInfoMapper sampInfoMapper;

	/**
	 * 分页查询品鉴会列表
	 * @param po
	 * @return
	 */
	public ResultPoJo<Page<JudgeMeetListVo>> findJudgeMeetList(JudgeMeetListPo po) {
		ResultPoJo<Page<JudgeMeetListVo>> result = new ResultPoJo<Page<JudgeMeetListVo>>(ConstantCodeMsg.NOMAL);

		Page<JudgeMeetListVo> page = po.getPage();
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		page.setList(mapper.findJudgeMeetList(po));
		result.setResult(page);
		return result;
	}
    /**
     * 分页选择品鉴会列表
     * @param po
     * @return
     */
	public ResultPoJo<Page<JudgeMeetListVo>> findChoiceList(JudgeMeetChoiceListPo po) {
		ResultPoJo<Page<JudgeMeetListVo>> result = new ResultPoJo<Page<JudgeMeetListVo>>(ConstantCodeMsg.NOMAL);

		Page<JudgeMeetListVo> page = po.getPage();
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		page.setList(mapper.findChoiceList(po));
		result.setResult(page);
		return result;
	}

	/**
	 * 分页查询品鉴会管理列表web
	 * @param po
	 * @return
	 */
	public ResultPoJo<Page<JudgeMeetListWebVo>> findJudgeMeetListWeb(JudgeMeetListWebPo po) {
		ResultPoJo<Page<JudgeMeetListWebVo>> result = new ResultPoJo<Page<JudgeMeetListWebVo>>(ConstantCodeMsg.NOMAL);

		Page<JudgeMeetListWebVo> page = po.getPage();
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		po.setStaDate(OffsetDateTimeUtils.getDayMinTime(po.getStaDate()));
		po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
		page.setList(mapper.findJudgeMeetListWeb(po));
		result.setResult(page);
		return result;
	}
	/**
	 * 删除品鉴会
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<?> delJudgeMeet(LongIdPo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		JudgeMeetInfo data  = mapper.selectByPrimaryKey(po.getId());
		//校验数据是否存在
		if(ConverterUtil.isEmpty(data)) {
			result.setCode(ConstantError.ERR_004);
			result.setMsg(ConstantError.MSG_004);
			return result;
		}
		data.preUpdate();
		data.setOperator(data.getUpdateBy());
		data.setOperatDate(data.getUpdateDate());
		data.setDelFlag(DictConstants.DEL_FLAG_1);
		mapper.updateByPrimaryKey(data);
		return result;
	}

	/**
	 * 查询品鉴会信息详情
	 * @param po
	 * @return
	 */
	public ResultPoJo<JudgeMeetInfoVo> getFindJudgeMeetByid(LongIdPo po) {
		ResultPoJo<JudgeMeetInfoVo> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		JudgeMeetInfoVo data  = mapper.getFindJudgeMeetByid(po.getId());
		//校验数据是否存在
		if(ConverterUtil.isEmpty(data)) {
			result.setCode(ConstantError.ERR_004);
			result.setMsg(ConstantError.MSG_004);
			return result;
		}
		result.setResult(data);
		return result;
	}

	/**
	 * 品鉴会保存/修改操作
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<?> saveOrUpdJudgeMeet(SaveOrUpdJudgeMeetPo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		//校验传参
		if(ConverterUtil.isEmpty(po)) {
			result.setCode(ConstantError.ERR_001);
			result.setMsg(ConstantError.MSG_001);
			return result;
		}
		JudgeMeetInfo judgeMeetInfo = new JudgeMeetInfo();
		//判断新增修改
		if(ConverterUtil.isEmpty(po.getId())) {
			//新增
			ConverterUtil.copyProperties(po, judgeMeetInfo);
			judgeMeetInfo.preInsert();
			judgeMeetInfo.setOperator(judgeMeetInfo.getUpdateBy());
			judgeMeetInfo.setOperatDate(judgeMeetInfo.getUpdateDate());
			mapper.insertSelective(judgeMeetInfo);
		}else {
			judgeMeetInfo = mapper.selectByPrimaryKey(po.getId());
			//校验数据是否存在
			if(ConverterUtil.isEmpty(judgeMeetInfo)) {
				result.setCode(ConstantError.ERR_004);
				result.setMsg(ConstantError.MSG_004);
				return result;
			}
			// 排他校验
			/*if (!po.getUpdateDate().equals(judgeMeetInfo.getUpdateDate())) {
				result.setCode(ConstantError.ERR_009);
				result.setMsg(ConstantError.MSG_009);
				return result;
			}*/
			ConverterUtil.copyProperties(po, judgeMeetInfo);
			judgeMeetInfo.preUpdate();
			judgeMeetInfo.setOperator(judgeMeetInfo.getCreateBy());
			judgeMeetInfo.setOperatDate(judgeMeetInfo.getUpdateDate());
			mapper.updateByPrimaryKeySelective(judgeMeetInfo);
		}
		return result;
	}
	/**
	 * 录入报告保存操作
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<?> uploadReport(ImgListPo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		//校验传参
		if(ConverterUtil.isEmpty(po)) {
			result.setCode(ConstantError.ERR_001);
			result.setMsg(ConstantError.MSG_001);
			return result;
		}
		SampInfo sampInfo = sampInfoMapper.selectByPrimaryKey(po.getSampId());
		//校验数据是否存在
		if(ConverterUtil.isEmpty(sampInfo)) {
			result.setCode(ConstantError.ERR_004);
			result.setMsg(ConstantError.MSG_004);
			return result;
		}
		//更改品鉴会样品状态
		sampInfo.setSampStateType(DictConstants.SAMP_STATE_TYPE_3);
		sampInfo.preUpdate();
		sampInfoMapper.updateByPrimaryKeySelective(sampInfo);
		//添加报告
		List<SampPicture> sampPictureList = new ArrayList<SampPicture>();
		if(ConverterUtil.isNotEmpty(po.getImgList())) {
			for (int i = 0; i < po.getImgList().size(); i++) {
				if(ConverterUtil.isNotEmpty(po.getImgList().get(i).getUrl())) {
					SampPicture sampPicture = new SampPicture();
					ConverterUtil.copyProperties(po.getImgList().get(i),sampPicture);
					sampPicture.preInsert();
					sampPicture.setSampId(po.getSampId());//样品id
					sampPicture.setSort(i+1);
					sampPicture.setPictureType(DictConstants.PICTURE_TYPE_1);//品鉴报告
					sampPictureList.add(sampPicture);
				}
			}
		}
		//图片表
		if(ConverterUtil.isNotEmpty(sampPictureList)) {
		  sampPictureMapper.insertBatchSampPicture(sampPictureList);
		}
		return result;
	}

	/**
	 * 录入报告查询操作
	 * @param po
	 * @return
	 */
	public ResultPoJo<ReportImgListVo> getReportByid(LongIdPo po) {
		ResultPoJo<ReportImgListVo> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		 //查询报告
		 SampPicture sampPict= new SampPicture();
		 sampPict.setSampId(po.getId());
		 sampPict.setPictureType(DictConstants.PICTURE_TYPE_1);
		 List<ImgListVo> data = sampPictureMapper.getfingImgList(sampPict);

		 ReportImgListVo vo = new ReportImgListVo();
		 vo.setReportImg(data);
		 result.setResult(vo);
		return result;
	}

	/**
	 * 校验品鉴会名称
	 * @param po
	 * @return
	 */
	public ResultPoJo<?> checkName(CheckJudgeMeetNamePo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		JudgeMeetInfo judgeMeetInfo = mapper.checkName(po);
		if (ConverterUtil.isNotEmpty(judgeMeetInfo)) {
			result.setCode(ConstantCodeMsg.ERR_701);
			result.setMsg(ConstantCodeMsg.MSG_701);
		}
		return result;
	}

}
