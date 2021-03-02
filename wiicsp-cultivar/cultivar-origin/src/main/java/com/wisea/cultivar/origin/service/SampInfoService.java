package com.wisea.cultivar.origin.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.JsonMapper;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.WbfcJwtOauthUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.tp.SampInfoMapper;
import com.wisea.cultivar.common.entity.tp.MembBaseInfo;
import com.wisea.cultivar.common.po.tp.SampListForSynPo;
import com.wisea.cultivar.common.po.tp.StringPo;
import com.wisea.cultivar.common.utils.tp.MembUtils;
import com.wisea.cultivar.common.utils.tp.SystemAreaUtils;
import com.wisea.cultivar.common.vo.tp.SampInfoListForSynVo;
import com.wisea.cultivar.common.vo.tp.SampListForSynVo;
import com.wisea.cultivar.origin.dao.OrmDetectionMechMageMapper;
import com.wisea.cultivar.origin.entity.*;
import com.wisea.cultivar.origin.po.*;
import com.wisea.cultivar.origin.vo.ImgListVo;
import com.wisea.cultivar.origin.vo.SampInfoVo;
import com.wisea.cultivar.origin.vo.SampListVo;
import com.wisea.cultivar.origin.vo.SampListWebVo;
import com.wisea.cultivar.origin.constants.ConstantCodeMsg;
import com.wisea.cultivar.origin.constants.DictConstants;
import com.wisea.cultivar.origin.constants.FklmSampInfoPropertis;
import com.wisea.cultivar.origin.dao.OrmMembInfoMapper;
import com.wisea.cultivar.origin.dao.OrmSampInfoMapper;
import com.wisea.cultivar.origin.dao.OrmSampPictureMapper;
import com.wisea.cultivar.origin.util.HttpUtils;
import com.wisea.cultivar.origin.util.OffsetDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author wzx
 *
 *         检测样品app service
 */
@Service
@EnableConfigurationProperties({FklmSampInfoPropertis.class})
public class SampInfoService extends BaseService {

	@Autowired
	private OrmSampInfoMapper mapper;
	@Autowired
	private OrmDetectionMechMageMapper detectionMechMageMapper;
	@Autowired
	private OrmMembInfoMapper membInfoMapper;
	@Autowired
	private OrmSampPictureMapper sampPictureMapper;
	@Autowired
	private FklmSampInfoPropertis fklmSampInfoPropertis;
	@Autowired
	private SampInfoMapper sampInfoMapper;

	/**
	 * 分页查询检测样品列表
	 * @param po
	 * @return
	 */
	public ResultPoJo<Page<SampListVo>> findSampInfoList(SampListPo po) {
		ResultPoJo<Page<SampListVo>> result = new ResultPoJo<Page<SampListVo>>(ConstantCodeMsg.NOMAL);

		Page<SampListVo> page = po.getPage();
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		if(!Constants.USER_TYPE_ADMIN.equals(user.getUserType())){
			po.setSampTakerId(user.getId());
		}
		po.setStaDate(OffsetDateTimeUtils.getDayMinTime(po.getStaDate()));
		po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
		page.setList(mapper.findSampInfoList(po));
		result.setResult(page);
		return result;
	}
   /**
    * 确认上传（检测）
    * @param po
    * @return
    */
	@Transactional(readOnly = false)
	public ResultPoJo<?> updSampStateType(UpdSampStateTypePo po) {
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

		SampInfo sampInfo = mapper.selectByPrimaryKey(po.getSampId());
		//校验数据是否存在
		if(ConverterUtil.isEmpty(sampInfo)) {
			result.setCode(ConstantError.ERR_004);
			result.setMsg(ConstantError.MSG_004);
			return result;
		}
		if(ConverterUtil.isNotEmpty(po.getDetectionMechId())) {
			sampInfo.setDetectionMechId(po.getDetectionMechId());
		}
		sampInfo.preUpdate();
		sampInfo.setResultType(null);
		sampInfo.setSampStateType(DictConstants.SAMP_STATE_TYPE_2);
		mapper.updateByPrimaryKey(sampInfo);
		if(ConverterUtil.isEmpty(sampInfo.getJudgeMeetId())){
			if(ConverterUtil.isEmpty(sampInfo.getDetectionMechId())){
				result.setCode(ConstantCodeMsg.ERR_704);
				result.setMsg(ConstantCodeMsg.MSG_704);
				return result;
			}
			LongIdPo sampEntity = new LongIdPo();
			sampEntity.setId(po.getSampId());
			SampInfoVo data = mapper.getFindSampInfoByid(sampEntity);
			List<SampPicture> listPic = Lists.newArrayList();
			if(data != null && data.getImgList() != null && data.getImgList().size() > 0){
				for(ImgListVo imgListVo :data.getImgList()){
					SampPicture sampPicture = new SampPicture();
					ConverterUtil.copyProperties(imgListVo, sampPicture);
					listPic.add(sampPicture);
				}
			}
			ResultPoJo<Boolean> fklmResult = fklmSampAdd(sampInfo,listPic);
			if(fklmResult == null){
				throw new BusinessException(ConstantCodeMsg.ERR_301, ConstantCodeMsg.MSG_301);
			}else if(!ConstantError.NOMAL.equals(fklmResult.getCode())){
				throw new BusinessException(fklmResult.getCode(), fklmResult.getMsg());
			}
		}
		return result;
	}

	/**
	 * 样品信息保存/修改操作
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<?> saveOrUpdSamp(SaveOrUpdSampPo po) {
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
		SampInfo sampInfo = new SampInfo();
		List<SampPicture> sampPictureList = new ArrayList<SampPicture>();
		//判断新增还是修改
		if(ConverterUtil.isEmpty(po.getId())) {
			//新增
			 ConverterUtil.copyProperties(po, sampInfo);
			 sampInfo.setSampNum(returnSampNum());//8为随机数编号
			 sampInfo.preInsert();
             if(ConverterUtil.isNotEmpty(sampInfo.getUpdateBy())) {
            	 sampInfo.setSampTakerId(Long.parseLong(sampInfo.getUpdateBy()));//后来新加的采样时间 跟更新时间同步
			 }
			 sampInfo.setSampDate(sampInfo.getUpdateDate());//同步采样时间
			 //判断 按钮（0：保存，1保存并上传）
			 if(po.getButtonTag().equals("0")) {
				 sampInfo.setSampStateType(DictConstants.SAMP_STATE_TYPE_0);//未上传
			 }else {
				 sampInfo.setSampStateType(DictConstants.SAMP_STATE_TYPE_2);//已上传也是未检测
			 }
			// 设置数据来源是 果品
			sampInfo.setDataSourceType(fklmSampInfoPropertis.getDataSourceType());
			//样品表
			mapper.insertSelective(sampInfo);
			//插入现场图片
			//初始化图片表数据
			if(ConverterUtil.isNotEmpty(po.getImgList())) {
				for (int i = 0; i < po.getImgList().size(); i++) {
					if(ConverterUtil.isNotEmpty(po.getImgList().get(i).getUrl())) {
						SampPicture sampPicture = new SampPicture();
						ConverterUtil.copyProperties(po.getImgList().get(i),sampPicture);
						sampPicture.preInsert();
						sampPicture.setSampId(sampInfo.getId());//样品id
						sampPicture.setSort(i+1);
						sampPicture.setPictureType(DictConstants.PICTURE_TYPE_0);//样品图片
						sampPictureList.add(sampPicture);
					}
				}
				//图片表
				if(ConverterUtil.isNotEmpty(sampPictureList)) {
				  sampPictureMapper.insertBatchSampPicture(sampPictureList);
				}
			}
		}else {
			//修改
			SampInfo sampInfoCheck = mapper.selectByPrimaryKey(po.getId());
			//校验数据是否存在
			if(ConverterUtil.isEmpty(sampInfoCheck)) {
				result.setCode(ConstantError.ERR_004);
				result.setMsg(ConstantError.MSG_004);
				return result;
			}
		     ConverterUtil.copyProperties(po, sampInfo);
		     sampInfo.preUpdate();
		     if(ConverterUtil.isNotEmpty(sampInfo.getUpdateBy())) {
            	 sampInfo.setSampTakerId(Long.parseLong(sampInfo.getUpdateBy()));
			 }
			 sampInfo.setSampDate(sampInfo.getUpdateDate());//同步采样时间
	 	     //判断 按钮（0：保存，1保存并上传）
			 if(po.getButtonTag().equals("0")) {
				 sampInfo.setSampStateType(DictConstants.SAMP_STATE_TYPE_0);//未上传
			 }else {
				 sampInfo.setSampStateType(DictConstants.SAMP_STATE_TYPE_2);//已上传也是未检测
			 }
		     if(ConverterUtil.isNotEmpty(sampInfo.getUpdateBy())) {
            	 sampInfo.setSampTakerId(Long.parseLong(sampInfo.getUpdateBy()));//后来新加的采样时间 跟更新时间同步
			 }
			 sampInfo.setSampDate(sampInfo.getUpdateDate());//同步采样时间
			 //样品表
			 mapper.updateByPrimaryKeySelective(sampInfo);

			 //先把现场图片表批量更新为删除
		     SampPicture sampPict= new SampPicture();
		     sampPict.preUpdate();
		     sampPict.setSampId(po.getId());//样品id
		     sampPict.setDelFlag(DictConstants.DEL_FLAG_1);
		     sampPict.setPictureType(DictConstants.PICTURE_TYPE_0);
			 sampPictureMapper.delBatchSampPicture(sampPict);
			//插入现场图片
			//初始化图片表数据
			if(ConverterUtil.isNotEmpty(po.getImgList())) {
				for (int i = 0; i < po.getImgList().size(); i++) {
					if(ConverterUtil.isNotEmpty(po.getImgList().get(i).getUrl())){
						SampPicture sampPicture = new SampPicture();
						ConverterUtil.copyProperties(po.getImgList().get(i),sampPicture);
						sampPicture.preInsert();
						sampPicture.setSampId(sampInfo.getId());//样品id
						sampPicture.setSort(i+1);
						sampPicture.setPictureType(DictConstants.PICTURE_TYPE_0);//样品图片
						sampPictureList.add(sampPicture);
					}
				}
				//图片表
				if(ConverterUtil.isNotEmpty(sampPictureList)) {
					sampPictureMapper.insertBatchSampPicture(sampPictureList);
				}

			}
			sampInfo.setSampNum(sampInfoCheck.getSampNum());// 样品编号的修改
		}
		if(po.getButtonTag().equals("1") && ConverterUtil.isEmpty(po.getJudgeMeetId())) {
			ResultPoJo<Boolean> fklmResult = fklmSampAdd(sampInfo,sampPictureList);
			if(fklmResult == null){
				throw new BusinessException(ConstantCodeMsg.ERR_301, ConstantCodeMsg.MSG_301);
			}else if(!ConstantError.NOMAL.equals(fklmResult.getCode()) || fklmResult.getResult() != null){
				throw new BusinessException(fklmResult.getCode(), fklmResult.getMsg());
			}
		}
		return result;
	}

	public Long returnSampNum(){
		Long sampNum = getSampNum();
	    SampInfo data = mapper.selectBySampNum(sampNum);//生成的随机数进入数据库中查询一下，看时候有相同的。
	    if(ConverterUtil.isNotEmpty(data)){//如果有相同的数据
	        return returnSampNum();//再次调用方法，生成一个随机数
	    }else{
	        return sampNum;
	    }
	}
	  //生成随机数
    public static Long getSampNum(){
		String sampNum = ConverterUtil.getCheckCode(8);//8为随机数编号
		Long  num = Long.parseLong(sampNum);
		if(num.toString().length() != 8){
			return getSampNum();
		}
	    return num;
	}

	/**
	 * 查询样品信息详情
	 * @param po
	 * @return
	 */
	public ResultPoJo<SampInfoVo> getFindSampInfoByid(LongIdPo po) {
		ResultPoJo<SampInfoVo> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		SampInfo sampInfoCheck = mapper.selectByPrimaryKey(po.getId());
		//校验数据是否存在
		if(ConverterUtil.isEmpty(sampInfoCheck)) {
			result.setCode(ConstantError.ERR_004);
			result.setMsg(ConstantError.MSG_004);
			return result;
		}
		SampInfoVo data = mapper.getFindSampInfoByid(po);
		//根据JudgeMeetId校验是否品鉴样品  然后去查询报告图片
		if(ConverterUtil.isNotEmpty(data.getJudgeMeetId())) {
			 SampPicture sampPict= new SampPicture();
			 sampPict.setSampId(data.getId());
			 sampPict.setPictureType(DictConstants.PICTURE_TYPE_1);
			 List<ImgListVo> data1 = sampPictureMapper.getfingImgList(sampPict);
			 data.setReportImg(data1);
		}else {
			SampPicture sampPict= new SampPicture();
			 sampPict.setSampId(data.getId());
			 sampPict.setPictureType(DictConstants.PICTURE_TYPE_2);
			 List<ImgListVo> data1 = sampPictureMapper.getfingImgList(sampPict);
			 data.setReportImg(data1);
		}
		if(ConverterUtil.isNotEmpty(data)) {
			StringBuffer adr = new StringBuffer();
			adr.append(SystemAreaUtils.getNameByCode(data.getMembInfo().getRegistAddressProv()));
			adr.append(SystemAreaUtils.getNameByCode(data.getMembInfo().getRegistAddressCity()));
			adr.append(SystemAreaUtils.getNameByCode(data.getMembInfo().getRegistAddressCou()));
			data.getMembInfo().setAddress(adr.toString());
		}

		result.setResult(data);
		return result;
	}

	/**
	 * 删除样品信息
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<?> delSampInfo(LongIdPo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		SampInfo sampInfoCheck = mapper.selectByPrimaryKey(po.getId());
		//校验数据是否存在
		if(ConverterUtil.isEmpty(sampInfoCheck)) {
			result.setCode(ConstantError.ERR_004);
			result.setMsg(ConstantError.MSG_004);
			return result;
		}
		SampInfo sampInfo = new SampInfo();
		ConverterUtil.copyProperties(sampInfoCheck, sampInfo);
		sampInfo.preUpdate();
		sampInfo.setDelFlag(DictConstants.DEL_FLAG_1);
		mapper.updateByPrimaryKey(sampInfo);
		return result;
	}

	/**
	 * 分页查询检测信息列表web
	 * @param po
	 * @return
	 */
	public ResultPoJo<Page<SampListWebVo>> findSampInfoListWeb(SampListWebPo po) {
		ResultPoJo<Page<SampListWebVo>> result = new ResultPoJo<Page<SampListWebVo>>(ConstantCodeMsg.NOMAL);

		Page<SampListWebVo> page = po.getPage();
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		//如果当前登录的是普通用户(商家)
		if(user.getUserType().equals(Constants.USER_TYPE_USER)) {
			Long membId = MembUtils.getMembIdFromUser(user);
			MembBaseInfo  membInfo = MembUtils.getMembInfoByUserId(membId);
			po.setCompId(membInfo.getCompId());
		}
		//根据查询条件判断 如果value有值,key没有值,查询的是样品名称 key默认0
		if(ConverterUtil.isNotEmpty(po.getValue())&&ConverterUtil.isEmpty(po.getKey())) {
			po.setKey("0");
		}
		po.setStaDate(OffsetDateTimeUtils.getDayMinTime(po.getStaDate()));
		po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
		page.setList(mapper.findSampInfoListWeb(po));
		result.setResult(page);
		return result;
	}

	/**
	 * 将样品信息同步到风控联盟的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月4日
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	public ResultPoJo<Boolean> fklmSampAdd(SampInfo sampInfo,List<SampPicture> listPic){
		ResultPoJo<Boolean> result = new ResultPoJo<>(ConstantError.NOMAL);
		try{
			// 将数据添加到风控联盟平台
			DeteSampInfo deteSampInfo = new DeteSampInfo();
			ConverterUtil.copyProperties(sampInfo, deteSampInfo);
			deteSampInfo.setDataSourceType(fklmSampInfoPropertis.getDataSourceType());
			// 设置现场图片信息
			deteSampInfo.setImgList(listPic);
			//设置采样人和采样时间
			MembInfo sampUser = membInfoMapper.selectByPrimaryKey(sampInfo.getSampTakerId());
			if(sampUser != null){
				deteSampInfo.setSampPerson(sampUser.getUserName());
			}
			if(sampInfo.getSampDate() != null){
				deteSampInfo.setSampDateStr(sampInfo.getSampDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			}
			if(sampInfo.getPrdctDate() != null){
				deteSampInfo.setPrdctDateStr(sampInfo.getPrdctDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			}
			// 设置检测机构信息
			DetectionMechMage detectionMechMage  = detectionMechMageMapper.selectByPrimaryKey(deteSampInfo.getDetectionMechId());
			if(ConverterUtil.isEmpty(detectionMechMage.getOrgNum())){
				result.setCode(ConstantCodeMsg.ERR_705);
				result.setMsg(ConstantCodeMsg.MSG_705);
				return result;
			}
			deteSampInfo.setDetectionMechId(ConverterUtil.toLong(detectionMechMage.getOrgNum()));
			// 设置企业信息
			MembEntpInfo membInfo = membInfoMapper.getMembAndEntpByMembId(sampInfo.getCompId());
			deteSampInfo.setCompName(membInfo.getCompName());
			deteSampInfo.setCompContacts(membInfo.getContacts());
			StringBuilder  adr = new StringBuilder();
			adr.append(SystemAreaUtils.getNameByCode(membInfo.getRegistAddressProv()));
			adr.append(SystemAreaUtils.getNameByCode(membInfo.getRegistAddressCity()));
			adr.append(SystemAreaUtils.getNameByCode(membInfo.getRegistAddressCou()));
			deteSampInfo.setCompAddress(adr.toString());
			deteSampInfo.setCompDetailAddress(membInfo.getAddress());
			deteSampInfo.setCompTel(membInfo.getCompTel());
			deteSampInfo.setCreateDate(null);
			deteSampInfo.setUpdateDate(null);
			String jwt = WbfcJwtOauthUtil.encode(deteSampInfo);
			Map<String,Object> map =  new HashMap<String,Object>();
			map.put("str", jwt);
			String url = fklmSampInfoPropertis.getSampadd();
			String str = HttpUtils.connect(url,JsonMapper.toJsonString(map));
			logger.debug("请求路径：".concat(url)
							.concat("返回内容：").concat(JsonMapper.toJsonString(str)));
			result = (ResultPoJo<Boolean>) JsonMapper.fromJsonString(str, ResultPoJo.class);
		}catch(Exception e){
			e.getStackTrace();
			result.setCode(ConstantCodeMsg.ERR_301);
			result.setMsg(ConstantCodeMsg.MSG_301);
		}
		return result;
	}

	/**
	 * 刷新未检测的样品是否已经检测
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月5日
	 * @version 1.0
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public ResultPoJo<String> freshen() {
		ResultPoJo<String> result = new ResultPoJo<>(ConstantError.NOMAL);
		try{
			// 查询未检测的样品列表
			List<String> notDeteList = mapper.getNotDetectedList();
			// 如果是空则不需要同步
			if(notDeteList != null && !notDeteList.isEmpty()){
				// 加密传入的信息
				String jwt = WbfcJwtOauthUtil.encode(notDeteList);
				Map<String,Object> map =  new HashMap<String,Object>();
				map.put("str", jwt);
				// 调用风控联盟相关的接口返回已经检测的信息
				String str = HttpUtils.connect(fklmSampInfoPropertis.getSampfreshen(),JsonMapper.toJsonString(map));
				ResultPoJo<String> res = (ResultPoJo<String>) JsonMapper.fromJsonString(str, ResultPoJo.class);
				if(res != null && res.getCode().equals(ConstantError.NOMAL) && res.getResult() == null){
					return result;
				}
				// 检测结果有值的情况
				if(res != null && ConverterUtil.isNotEmpty(res.getResult())){
					List<Map<String,Object>> deteYcmPojo =  WbfcJwtOauthUtil.decode(res.getResult(), List.class);
					//检测结果图片地址
					if(deteYcmPojo != null && !deteYcmPojo.isEmpty()){
						List<SampPicture> addPicList = new ArrayList<SampPicture>();//添加图片的列表
						List<SampPicture> delPicList = new ArrayList<SampPicture>();// 删除图片的列表
						// 返回的已经检测的样品数量
						for(int i = 0; i < deteYcmPojo.size(); i++){
							SampPicture delSampPicture = new SampPicture();
							DeteYcmPojo entity = new DeteYcmPojo();
							ConverterUtil.mapToProperty(entity, deteYcmPojo.get(i));
							if(entity.getPicList() != null){
								for(Map<String, Object> picEntity : entity.getPicList()){
									SampPicture sampPicture = new SampPicture();
									sampPicture.preInsert();
									if(ConverterUtil.isNotEmpty(picEntity.get("createDate"))){
										String date = ConverterUtil.toString(picEntity.get("createDate"));
										DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										Date date1 = format1.parse(date);
										if(date1 != null){
											sampPicture.setCreateDate(ConverterUtil.longToOffsetDateTime(date1.getTime()));
										}
									}
									sampPicture.setId(ConverterUtil.toLong(picEntity.get("id")));
									sampPicture.setUrl(ConverterUtil.toString(picEntity.get("url")));
									sampPicture.setPictureType("2");
									sampPicture.setSampId(ConverterUtil.toLong(picEntity.get("sampId")));
									sampPicture.setSort(ConverterUtil.toInteger(picEntity.get("sort")));
									addPicList.add(sampPicture);
								}
							}
							// 需要刪除的部分
							Long sampId = ConverterUtil.toLong(deteYcmPojo.get(i).get("id"));
							delSampPicture.setSampId(sampId);
							delPicList.add(delSampPicture);
							// 修改样品状态
							SampInfo statusSampInfo = new SampInfo();
							statusSampInfo.setId(sampId);
							statusSampInfo.setSampStateType(DictConstants.SAMP_STATE_TYPE_3);
							statusSampInfo.setDetecDate(ConverterUtil.longToOffsetDateTime(ConverterUtil.toLong(deteYcmPojo.get(i).get("detecDate"))));
							statusSampInfo.setResultType(deteYcmPojo.get(i).get("resultType") == null ? "1":deteYcmPojo.get(i).get("resultType").toString());
							mapper.updateByPrimaryKeySelective(statusSampInfo);
						}
						//先把现场图片表批量更新为删除
						if(!delPicList.isEmpty()){
							sampPictureMapper.batchDelPicByList(delPicList);
						}
						// 保存图片信息
						if(!addPicList.isEmpty()){
							sampPictureMapper.insertBatchSampPicture(addPicList);
						}
					}
				}else{
					result.setCode(ConstantCodeMsg.ERR_301);
					result.setMsg(ConstantCodeMsg.MSG_301);
				}
			}
		}catch(Exception e){
			e.getStackTrace();
			logger.debug("301异常信息："+ e);
			result.setCode(ConstantCodeMsg.ERR_301);
			result.setMsg(ConstantCodeMsg.MSG_301);
			throw new BusinessException(result.getCode(), result.getMsg());
		}
		return result;
	}
	/**
	 * 查询样品详情(无权限)
	 * @param po
	 * @return
	 */
	public ResultPoJo<SampInfoVo> getNotAuthSampInfoByid(LongIdPo po) {
		ResultPoJo<SampInfoVo> result = new ResultPoJo<>(ConstantError.NOMAL);

		SampInfo sampInfoCheck = mapper.selectByPrimaryKey(po.getId());
		//校验数据是否存在
		if(ConverterUtil.isEmpty(sampInfoCheck)) {
			result.setCode(ConstantError.ERR_004);
			result.setMsg(ConstantError.MSG_004);
			return result;
		}
		SampInfoVo data = mapper.getFindSampInfoByid(po);
		//根据JudgeMeetId校验是否品鉴样品  然后去查询报告图片
		if(ConverterUtil.isNotEmpty(data.getJudgeMeetId())) {
			 SampPicture sampPict= new SampPicture();
			 sampPict.setSampId(data.getId());
			 sampPict.setPictureType(DictConstants.PICTURE_TYPE_1);
			 List<ImgListVo> data1 = sampPictureMapper.getfingImgList(sampPict);
			 data.setReportImg(data1);
		}else {
			SampPicture sampPict= new SampPicture();
			 sampPict.setSampId(data.getId());
			 sampPict.setPictureType(DictConstants.PICTURE_TYPE_2);
			 List<ImgListVo> data1 = sampPictureMapper.getfingImgList(sampPict);
			 data.setReportImg(data1);
		}
		if(ConverterUtil.isNotEmpty(data)) {
			StringBuffer adr = new StringBuffer();
			adr.append(SystemAreaUtils.getNameByCode(data.getMembInfo().getRegistAddressProv()));
			adr.append(SystemAreaUtils.getNameByCode(data.getMembInfo().getRegistAddressCity()));
			adr.append(SystemAreaUtils.getNameByCode(data.getMembInfo().getRegistAddressCou()));
			data.getMembInfo().setAddress(adr.toString());
		}

		result.setResult(data);
		return result;
	}
	/**
	 * 查询企业检测数据 --农资同步使用
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月14日
	 * @version 1.0
	 */
	public ResultPoJo<String> getSampInfo(StringPo po) {
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantCodeMsg.NOMAL);
		try{
			// 解密
			SampListForSynPo value = WbfcJwtOauthUtil.decode(po.getKeyStr(),SampListForSynPo.class);
			if(value == null){
				result.setCode(ConstantError.ERR_001);
				result.setMsg(ConstantError.MSG_001);
				return result;
			}
			// 同步已经检测的信息
			freshen();
			// 返回值初期化处理
			SampListForSynVo vo = new SampListForSynVo();
			// 根据企业id和时间查询检测样品信息
			List<SampInfoListForSynVo> list = sampInfoMapper.findSampList(value);

			List<SampInfoListForSynVo> yjcList = Lists.newArrayList();
	        // 根据传过来的未检测id去查询是否更新为已检测
			if(ConverterUtil.isNotEmpty(value.getWjcList())) {
				String id = String.join(",", value.getWjcList());
				 yjcList = sampInfoMapper.findYJCSampList(id);
			}
			if (ConverterUtil.isNotEmpty(list)) {
				vo.setListVo(list);
			}
			if (ConverterUtil.isNotEmpty(yjcList)) {
				vo.setYjcListVo(yjcList);
			}
			String jwt = WbfcJwtOauthUtil.encode(vo);
			result.setResult(jwt);
		}catch(Exception e){
			LoggerUtil.infoWithContext("同步数据查询异常：",e);
			result.setCode(ConstantError.ERR_999);
			result.setMsg(ConstantError.MSG_999);
			return result;
		}
		return result;
	}

}
