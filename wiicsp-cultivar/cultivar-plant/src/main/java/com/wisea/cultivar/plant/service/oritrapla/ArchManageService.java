package com.wisea.cultivar.plant.service.oritrapla;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.entity.oritrapla.*;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.*;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.utils.Md5Utils;
import com.wisea.cultivar.plant.utils.MembUtils;
import com.wisea.cultivar.plant.utils.OffsetDateTimeUtils;
import com.wisea.cultivar.plant.vo.oritrapla.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Auth： yangtao
 * projectName:  oritrapla
 * remark:  档案管理Service
 */
@Service
public class ArchManageService extends BaseService {

	@Autowired
    private FarmWorkRecdMapper farmWorkRecdMapper;
    @Autowired
    private ArchBasicInfoMapper archBasicInfoMapper;
    @Autowired
    private FarmWorkPictureMapper farmWorkPictureMapper;
    @Autowired
    private MineArchMapper mineArchMapper;
    @Autowired
    private ExamRecdRelaMapper examRecdRelaMapper;
    @Autowired
    private ArchSetupMapper archSetupMapper;
    @Autowired
    private BrandInfoMapper brandInfoMapper;
    @Autowired
    private OriExamRecdMapper oriExamRecdMapper;
    @Autowired
    private ExamReportPictureMapper examPictureMapper;
    @Autowired
    private FarmWorkTypeDictMapper farmWorkTypeDictMapper;
    @Autowired
    private ZhfwMembInfoMapper membInfoMapper;
    @Autowired
    private MembPictureInfoMapper membPictureInfoMapper;
    @Autowired
    private MassifMageMapper massifMageMapper;
    @Autowired
    private FarmingCycleMapper farmingCycleMapper;
    @Autowired
    private StagePictureMapper stagePictureMapper;
    @Autowired
    private PlantingMethodMapper plantingMethodMapper;


    /**
     * 新增我的档案
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> mineArchBasicSava (MineArchBasicPo mineArchBasicPo) {
    	ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);
    	if (mineArchBasicPo.getEndDate().isBefore(mineArchBasicPo.getStartDate())) {
    		result.setCode(ConstantCodeMsg.ERR_803);
        	result.setMsg(ConstantCodeMsg.MSG_803);
        	return result;
    	}
    	//校验种植方法
    	if (mineArchBasicPo.getPlatMethodId() != null) {
    		//查询种植方法
        	PlantingMethod plantingMethod = plantingMethodMapper.selectByPrimaryKey(mineArchBasicPo.getPlatMethodId());
        	//校验种植方法适不适合该档案
            if (!(plantingMethod.getCommId().equals(mineArchBasicPo.getCommId()) &&
            		plantingMethod.getPlantType().equals(mineArchBasicPo.getPlantType()))) {

            	result.setCode(ConstantCodeMsg.ERR_311);
            	result.setMsg("该种植方法不适合当前档案，请检查品类和种植类型！");
            	return result;
            }
    	}
    	/**新增档案详细信息*/
    	ArchBasicInfo archBasicInfo = new ArchBasicInfo();

    	ConverterUtil.copyProperties(mineArchBasicPo, archBasicInfo);
    	archBasicInfo.setMembId(SystemUtils.getUserOnlyId().getId());
    	archBasicInfo.setArchNum(Md5Utils.getMD5(Long.toString(OffsetDateTimeUtils.getLong())));
    	archBasicInfo.setPlantingMethodId(mineArchBasicPo.getPlatMethodId());
    	archBasicInfo.setId(IdGen.randomLong());
    	archBasicInfo.setIsNewRecord(true);
    	archBasicInfo.preInsert();
        archBasicInfo.setPlantingMethodId(mineArchBasicPo.getPlatMethodId());

    	archBasicInfoMapper.insertSelective(archBasicInfo);
    	/**新增我的档案信息*/
    	MineArch mineArch = new MineArch();

    	mineArch.setId(IdGen.randomLong());
    	mineArch.setMembId(SystemUtils.getUserOnlyId().getId());
    	mineArch.setArchType(DictConstants.ARCH_TYPE_2);
    	mineArch.setArchId(archBasicInfo.getId());
    	mineArch.setMineArchStatus(DictConstants.MINE_ARCH_STATUS_0);
    	mineArch.setIsNewRecord(true);
    	mineArch.preInsert();

    	mineArchMapper.insertSelective(mineArch);
    	/**新增档案设置*/
    	ArchSetup archSetup = new ArchSetup();

    	archSetup.setMineArchId(mineArch.getId());
    	archSetup.setArchEdNameFlag(DictConstants.ARCH_ED_NAME_FLAG_1);
    	archSetup.setMassifEdNameFlag(DictConstants.MASSIF_ED_NAME_FLAG_1);
    	archSetup.setCropEdFlag(DictConstants.CROP_ED_FLAG_0);
    	archSetup.setPlantAcreEdFlag(DictConstants.PLANT_ACRE_ED_FLAG_0);
    	archSetup.setPlantStandEdFlag(DictConstants.PLANT_STAND_ED_FLAG_0);
    	archSetup.setPlantStartEdFlag(DictConstants.PLANT_START_ED_FLAG_0);
    	archSetup.setListDateEdFlag(DictConstants.LIST_DATE_ED_FLAG_0);
    	archSetup.setExamInfoEdFlag(DictConstants.EXAM_INFO_ED_FLAG_0);
    	archSetup.setExamInfoType(DictConstants.EXAM_INFO_TYPE_0);
    	archSetup.preInsert();

    	archSetupMapper.insertSelective(archSetup);
    	/**新增检测记录关系*/
    	ExamRecdRela examRecdRela = new ExamRecdRela();

    	examRecdRela.setId(IdGen.randomLong());
    	examRecdRela.setMineArchId(mineArch.getId());
    	examRecdRela.setMembId(mineArch.getMembId());
    	examRecdRela.setArchId(archBasicInfo.getId());
    	examRecdRela.setIsNewRecord(true);
    	examRecdRela.preInsert();

    	examRecdRelaMapper.insertSelective(examRecdRela);
    	/**新增农事记录*/
    	if (mineArchBasicPo.getPlatMethodId() != null) {
    		creatFormRe(mineArchBasicPo.getPlatMethodId(), archBasicInfo.getId());
    	}
    	return result;
    }

    /**
     * 使用该种植方法到档案中（第一个id是种植方法id，第二个是档案id）
     * @param po
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> useMethod (LongIdsPo po) {

    	ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);
    	//查询种植方法
    	PlantingMethod plantingMethod = plantingMethodMapper.selectByPrimaryKey(po.getIds().get(0));
    	//查询我的档案详细信息和主体信息
        MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(po.getIds().get(1));
        //校验种植方法有没有选过种植方法
        if (mineArchBasicInfo.getPlantingMethodId() != null) {

        	result.setCode(ConstantCodeMsg.ERR_311);
        	result.setMsg("该档案已经选过种植方法！");
        	return result;
        }
        //校验种植方法适不适合该档案
        if (!(plantingMethod.getCommId().equals(mineArchBasicInfo.getCommId()) &&
        		plantingMethod.getPlantType().equals(mineArchBasicInfo.getPlantType()))) {

        	result.setCode(ConstantCodeMsg.ERR_311);
        	result.setMsg("该种植方法不适合当前档案，请检查品类和种植类型！");
        	return result;
        }
        //更新档案主体信息
        ArchBasicInfo archBasicInfo = new ArchBasicInfo();
        archBasicInfo.setId(mineArchBasicInfo.getArchId());
        archBasicInfo.setPlantingMethodId(plantingMethod.getId());

        archBasicInfoMapper.updateByPrimaryKeySelective(archBasicInfo);
        //更新档案的农事记录
        creatFormRe(po.getIds().get(0), mineArchBasicInfo.getArchId());
        return result;
    }

    /**
     * 生成农事记录
     * @param methodId 种植方法id
     * @param archId 档案id
     */
    @Transactional(readOnly = false)
    public void creatFormRe (Long methodId, Long archId) {
    	//获取种植方法对应的周期列表
    	List<FarmingCyclInfoVo> farmingCyclInfoList = farmingCycleMapper.selCycAndStageByMethod(methodId);
    	//获取档案基本信息
    	ArchBasicInfo archBasicInfo = archBasicInfoMapper.selectByPrimaryKey(archId);
    	//档案结束日期
    	OffsetDateTime archEndDate = OffsetDateTimeUtils.getDayMaxTime(archBasicInfo.getEndDate());
    	//档案初始日期
    	OffsetDateTime archStartDate = OffsetDateTimeUtils.getDayMinTime(archBasicInfo.getStartDate());
    	//当前初始日期
    	OffsetDateTime nowStart = OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1));
    	//循环取农事周期
    	farmingCyclInfoList.stream().forEach(x -> {
    		//循环农事阶段
    		for (FarmingStageInfoVo vo : x.getFarmingStageInfoVo()) {
    			//农事记录开始日期
    			OffsetDateTime operatCsDate = archStartDate.plusDays((vo.getStartDays()-1));
    			//周期操作列表
    			List<OffsetDateTime> timeList = Lists.newArrayList();
    			timeList.add(operatCsDate);
    			//周期操作
    			if (vo.getCycleInterval() != null && vo.getCycleInterval() != "" && ConverterUtil.toLong(vo.getCycleInterval()) >0) {
    				//计算周期天数
    				int day = (vo.getEndDays()) - (vo.getStartDays());
    				//计算有几个周期
    				double div = ConverterUtil.getRoundDownValue(ConverterUtil.div(day, ConverterUtil.toDouble(vo.getCycleInterval()), 1), 0);
    				//生成每次开始的日期
    				for (int i = 1; i <= div; i++) {
    					//农事记录开始日期
    	    			OffsetDateTime operatDate = operatCsDate.plusDays((ConverterUtil.toLong(vo.getCycleInterval()))*i);

    	    			timeList.add(operatDate);
					}
    			}
    			//获取农事阶段图片
    			List<StagePicture> stagePic= stagePictureMapper.getPictByStageId(vo.getFarmingStageId());
    			//生成农事记录
    			for (OffsetDateTime opeDate : timeList) {
    				//生成的计划要在当前日期之后或者是当前日期，档案结束日期之前
	    			if (opeDate.isAfter(nowStart) && opeDate.isBefore(archEndDate)) {
	    				//生成一条农事记录
	    				FarmWorkRecd farmWorkRecd = new FarmWorkRecd();
	    				farmWorkRecd.setId(IdGen.randomLong());
	    				farmWorkRecd.setArchId(archId);
	    				farmWorkRecd.setFarmWorkTypeId(vo.getFarmWorkTypeId());
	    				farmWorkRecd.setOperatContent(vo.getFarmingRequire());
	    				farmWorkRecd.setRemarks(vo.getFarmingRequire());
	    				farmWorkRecd.setVideoUrl(vo.getVideoUrl());
	    				farmWorkRecd.setUsAgriculturalMaterials(vo.getUsAgriculturalMaterials());
	    				//判断今日代表
	    				if (OffsetDateTimeUtils.isEqualTime(opeDate, OffsetDateTime.now())) {

	    					farmWorkRecd.setRecordStatus(DictConstants.RECORD_STATUS_4);
	    				}else {

	    					farmWorkRecd.setRecordStatus(DictConstants.RECORD_STATUS_0);
	    				}
	    				farmWorkRecd.setOperatDate(opeDate);
	    				farmWorkRecd.setIsNewRecord(true);
	    				farmWorkRecd.preInsert();
	    				farmWorkRecdMapper.insertSelective(farmWorkRecd);
	    				//设置批量插入
	    				List<FarmWorkPicture> urlList = Lists.newArrayList();
	    				//添加农事记录照片
	    				if (stagePic != null && stagePic.size() > 0) {

	    					for (StagePicture url : stagePic) {

	    						FarmWorkPicture farmWorkPicture = new FarmWorkPicture();

	    						farmWorkPicture.setFarmWorkRecdId(farmWorkRecd.getId());
	    						farmWorkPicture.setUrl(url.getUrl());
	    						farmWorkPicture.preInsert();

	    						urlList.add(farmWorkPicture);
	    					}
	    					farmWorkPictureMapper.batchInsert(urlList);
	    				}
	    			}
				}
			}
    	});
    }

    /**
     * 修改我的档案
     *
     * @param mineArchBasicPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> mineArchBasicUpd (MineArchBasicPo mineArchBasicPo) {

    	ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);
    	//校验开始、结束日期
    	if (mineArchBasicPo.getEndDate().isBefore(mineArchBasicPo.getStartDate())) {

    		result.setCode(ConstantCodeMsg.ERR_803);
        	result.setMsg(ConstantCodeMsg.MSG_803);
        	return result;
    	}
    	//校验编辑标识
    	if ("0".equals(mineArchBasicPo.getSavaFlag())) {

    		result.setCode(ConstantError.ERR_004);
        	result.setMsg(ConstantError.MSG_004);
        	return result;
    	}
    	//校验是否可以操作
    	User userOnlyId = SystemUtils.getUserOnlyId();
    	String checkUser = checkUser(userOnlyId.getId());

    	if ("1".equals(checkUser)) {

			result.setCode(ConstantCodeMsg.ERR_801);
			result.setMsg(ConstantCodeMsg.MSG_801);
			return result;
		}
    	//查询我的档案详细信息
        MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(mineArchBasicPo.getMineArchId());
        //校验我的档案状态
    	if (DictConstants.MINE_ARCH_STATUS_2.equals(mineArchBasicInfo.getMineArchStatus())) {

    		result.setCode(ConstantCodeMsg.ERR_809);
        	result.setMsg(ConstantCodeMsg.MSG_809);
        	return result;
    	}
        //校验是否可以修改（自建的档案可以修改）
    	if (!DictConstants.ARCH_TYPE_2.equals(mineArchBasicInfo.getArchType())) {

    		result.setCode(ConstantCodeMsg.ERR_801);
        	result.setMsg(ConstantCodeMsg.MSG_801);
        	return result;
    	}
    	//排他校验
    	if (!mineArchBasicPo.getUpdateDate().equals(mineArchBasicPo.getUpdateDate())) {

    		result.setCode(ConstantCodeMsg.ERR_802);
        	result.setMsg(ConstantCodeMsg.MSG_802);
        	return result;
    	}
    	//校验是否可以填种植方法
    	if (mineArchBasicInfo.getPlantingMethodId() != null &&
    			mineArchBasicInfo.getPlantingMethodId().equals(mineArchBasicPo.getPlatMethodId())) {

    		result.setCode(ConstantCodeMsg.ERR_802);
        	result.setMsg("该作物已经生成种植方法！");
        	return result;
    	}
    	//校验种植方法
    	if (mineArchBasicInfo.getPlantingMethodId() == null && mineArchBasicPo.getPlatMethodId() != null) {
    		//查询种植方法
        	PlantingMethod plantingMethod = plantingMethodMapper.selectByPrimaryKey(mineArchBasicPo.getPlatMethodId());
            //校验种植方法适不适合该档案
            if (!(plantingMethod.getCommId().equals(mineArchBasicPo.getCommId()) &&
            		plantingMethod.getPlantType().equals(mineArchBasicPo.getPlantType()))) {

            	result.setCode(ConstantCodeMsg.ERR_311);
            	result.setMsg("该种植方法不适合当前档案，请检查品类和种植类型！");
            	return result;
            }
    	}
    	/**  修改档案详细信息  */
    	ArchBasicInfo archBasicInfo = new ArchBasicInfo();

    	ConverterUtil.copyProperties(mineArchBasicPo, archBasicInfo);
    	archBasicInfo.setId(mineArchBasicInfo.getArchId());
    	archBasicInfo.setPlantingMethodId(mineArchBasicPo.getPlatMethodId());
    	archBasicInfo.preUpdate();

    	archBasicInfoMapper.updateByPrimaryKeySelective(archBasicInfo);
    	/**新增农事记录*/
    	if (mineArchBasicInfo.getPlantingMethodId() == null && mineArchBasicPo.getPlatMethodId() != null) {

    		creatFormRe(mineArchBasicPo.getPlatMethodId(), mineArchBasicInfo.getArchId());
    	}

    	return result;
    }

    /**
     * 删除档案
     * @param mineArchId
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> mineArchDel (Long mineArchId) {

    	ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);
    	//校验是否可以操作
    	User userOnlyId = SystemUtils.getUserOnlyId();
    	String checkUser = checkUser(userOnlyId.getId());

    	if ("1".equals(checkUser)) {

			result.setCode(ConstantCodeMsg.ERR_801);
			result.setMsg(ConstantCodeMsg.MSG_801);
			return result;
		}
    	//校验状态
    	MineArch mineArch = mineArchMapper.selectByPrimaryKey(mineArchId);

    	if (!DictConstants.MINE_ARCH_STATUS_0.equals(mineArch.getMineArchStatus())) {

    		result.setCode(ConstantError.ERR_004);
			result.setMsg(ConstantError.MSG_004);
			return result;
    	}
    	mineArch.setMineArchStatus(DictConstants.MINE_ARCH_STATUS_2);
    	mineArch.preUpdate();
    	mineArchMapper.updateByPrimaryKeySelective(mineArch);

    	return result;
    }

    /**
     * 添加农事记录
     *
     * @param farmWorkRecdPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> farmWorkRecdSava(FarmWorkRecdPo farmWorkRecdPo) {

        ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);
        //查询我的档案详细信息
        MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(farmWorkRecdPo.getMineArchId());

        if (!DictConstants.MINE_ARCH_STATUS_0.equals(mineArchBasicInfo.getMineArchStatus())) {

        	result.setCode(ConstantCodeMsg.ERR_807);
        	result.setMsg(ConstantCodeMsg.MSG_807);
        	return result;
        }

        FarmWorkRecd farmWorkRecd = new FarmWorkRecd();

        farmWorkRecd.setArchId(mineArchBasicInfo.getArchId());//档案id
        farmWorkRecd.setFarmWorkTypeId(farmWorkRecdPo.getFarmWorkTypeId());//农事类型id
        farmWorkRecd.setOperatContent(farmWorkRecdPo.getOperatContent());//操作内容
        farmWorkRecd.setVideoUrl(farmWorkRecdPo.getVideoUrl());
        farmWorkRecd.setUsAgriculturalMaterials(farmWorkRecdPo.getUsAgriculturalMaterials());
        farmWorkRecd.setRemarks(farmWorkRecdPo.getRemarks());//备注
        farmWorkRecd.setOperatContent(farmWorkRecdPo.getRemarks());
        farmWorkRecd.setOperatDate(farmWorkRecdPo.getOperatDate());//操作时间

        if ("0".equals(farmWorkRecdPo.getSavaFlag())) {//添加农事记录

        	if (farmWorkRecdPo.getOperatDate().isAfter(OffsetDateTime.now())) {

        		result.setCode(ConstantCodeMsg.ERR_807);
            	result.setMsg("添加农事记录，操作时间必须在当前时间之前！");
            	return result;
        	}
        	farmWorkRecd.setRecordStatus(DictConstants.RECORD_STATUS_1);
        	farmWorkRecd.setId(IdGen.randomLong());
        	farmWorkRecd.setIsNewRecord(true);
        	farmWorkRecd.preInsert();
        	farmWorkRecdMapper.insertSelective(farmWorkRecd);

        }else if ("2".equals(farmWorkRecdPo.getSavaFlag())) {//添加农事计划

        	if (farmWorkRecdPo.getOperatDate().isBefore(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1)))) {

        		result.setCode(ConstantCodeMsg.ERR_807);
            	result.setMsg("添加农事计划，操作时间必须在当前时间之后！");
            	return result;
        	}
        	if (farmWorkRecdPo.getOperatDate().isBefore(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()))) {

        		farmWorkRecd.setRecordStatus(DictConstants.RECORD_STATUS_4);
        	}else {

        		farmWorkRecd.setRecordStatus(DictConstants.RECORD_STATUS_0);
        	}
        	farmWorkRecd.setId(IdGen.randomLong());
        	farmWorkRecd.setIsNewRecord(true);
        	farmWorkRecd.preInsert();
        	farmWorkRecdMapper.insertSelective(farmWorkRecd);

        }else {//编辑
        	//校验排他
        	FarmWorkRecd farmRecd = farmWorkRecdMapper.selectByPrimaryKey(farmWorkRecdPo.getFarmWorkRecdId());

        	if (!farmRecd.getUpdateDate().equals(farmWorkRecdPo.getUpdateDate())) {

        		result.setCode(ConstantCodeMsg.ERR_802);
            	result.setMsg(ConstantCodeMsg.MSG_802);
            	return result;
        	}
        	if ("1".equals(farmRecd.getDelFlag())) {

        		result.setCode(ConstantCodeMsg.ERR_802);
            	result.setMsg(ConstantCodeMsg.MSG_802);
            	return result;
        	}
        	//校验日期
        	if (farmWorkRecdPo.getOperatDate().isBefore(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1))) &&
        			!(DictConstants.RECORD_STATUS_1.equals(farmRecd.getRecordStatus()) || DictConstants.RECORD_STATUS_4.equals(farmRecd.getRecordStatus()))) {

        		result.setCode(ConstantCodeMsg.ERR_802);
            	result.setMsg("该日期已失效！");
            	return result;
        	}
        	if (farmWorkRecdPo.getOperatDate().isAfter(OffsetDateTime.now()) &&
                    (DictConstants.RECORD_STATUS_1.equals(farmRecd.getRecordStatus()) || DictConstants.RECORD_STATUS_4.equals(farmRecd.getRecordStatus()))) {

                result.setCode(ConstantCodeMsg.ERR_802);
                result.setMsg("不能选之后的日期！");
                return result;
            }

        	farmWorkRecd.setId(farmWorkRecdPo.getFarmWorkRecdId());

        	if (DictConstants.RECORD_STATUS_4.equals(farmRecd.getRecordStatus()) ||
        			DictConstants.RECORD_STATUS_1.equals(farmRecd.getRecordStatus())) {

        		farmWorkRecd.setRecordStatus(DictConstants.RECORD_STATUS_1);

        	}else {

        		if (farmWorkRecdPo.getOperatDate().isBefore(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()))) {

            		farmWorkRecd.setRecordStatus(DictConstants.RECORD_STATUS_4);
            	}else {

            		farmWorkRecd.setRecordStatus(DictConstants.RECORD_STATUS_0);
            	}
        	}
        	farmWorkRecd.preUpdate();
        	farmWorkRecdMapper.updateByPrimaryKeySelective(farmWorkRecd);
        	//删除以前的图片信息
        	farmWorkPictureMapper.delByFormId(farmWorkRecdPo.getFarmWorkRecdId());
        }
        //判断是否有图片
        if (farmWorkRecdPo.getFileUrls() == null || farmWorkRecdPo.getFileUrls().isEmpty()) {

        	result.setCode(ConstantError.ERR_005);
        	result.setMsg(ConstantError.MSG_005);
        	return result;
        }
        //判断照片张数
  		if (farmWorkRecdPo.getFileUrls().size() > 6) {

  			result.setCode(ConstantCodeMsg.ERR_804);
  			result.setMsg(ConstantCodeMsg.MSG_804);
  			return result;
  		}
        //设置批量插入
        List<FarmWorkPicture> urlList = Lists.newArrayList();

        for (String url : farmWorkRecdPo.getFileUrls()) {

        	FarmWorkPicture farmWorkPicture = new FarmWorkPicture();

        	farmWorkPicture.setFarmWorkRecdId(farmWorkRecd.getId());
        	farmWorkPicture.setUrl(url);
        	farmWorkPicture.preInsert();

        	urlList.add(farmWorkPicture);
		}

        farmWorkPictureMapper.batchInsert(urlList);

        return result;
    }

    /**
     * 立即执行今日代办农事记录
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> startFarmNow (LongIdPo po) {

    	ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);
    	FarmWorkRecd farmWorkRecd = farmWorkRecdMapper.selectByPrimaryKey(po.getId());
    	//校验状态
    	if (!DictConstants.RECORD_STATUS_4.equals(farmWorkRecd.getRecordStatus())) {

    		result.setCode(ConstantError.ERR_005);
        	result.setMsg(ConstantError.MSG_005);
        	return result;
    	}
    	//修改状态
    	farmWorkRecd.setRecordStatus(DictConstants.RECORD_STATUS_1);
    	farmWorkRecd.preUpdate();
    	farmWorkRecdMapper.updateByPrimaryKeySelective(farmWorkRecd);

    	return result;
    }

    /**
     * 查询档案列表
     * @param mineArchListPo
     * @return
     */
    public List<ArchBasicInfoVo> mineArckList (MineArchListPo mineArchListPo) {

    	String startType = mineArchListPo.getStartType();

    	User userOnlyId = SystemUtils.getUserOnlyId();
    	mineArchListPo.setMembId(userOnlyId.getId());

    	if (startType != null && startType != "") {
    		//设置查询时间
    		OffsetDateTime dayMaxTime = OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now());
    		OffsetDateTime dayMinTime = OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now());
    		//设置开始日期
    		mineArchListPo.setEndTime(dayMinTime);
    		//设置结束日期
    		if ("0".equals(startType)) {

    			dayMaxTime = OffsetDateTimeUtils.getLastTime(1);

    		}else if ("1".equals(startType)) {

    			dayMaxTime = OffsetDateTimeUtils.getLastTime(3);

    		}else if ("2".equals(startType)) {

    			dayMaxTime = OffsetDateTimeUtils.getLastTime(6);

    		}else if ("3".equals(startType)) {

    			dayMaxTime = dayMaxTime.withYear(dayMaxTime.getYear() - 1);
    		}

    		mineArchListPo.setStartTime(dayMaxTime);
    	}

    	List<ArchBasicInfoVo> mineArckList = mineArchMapper.mineArckList(mineArchListPo);

    	return mineArckList;
    }

    /**
     * 查询档案详细信息(便于前端)
     *
     * @param mineArchId
     * @return
     */
    public MineArchVo mineArckAndArchInfo (Long mineArchId) {

    	//查询我的档案详细信息和主体信息
        MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(mineArchId);

        Long membIdFromUser = MembUtils.getMembIdFromUser(SystemUtils.getUser());
        //查询会员资质照片
        List<MembPictureInfo> membPictureList = membPictureInfoMapper.findByMembId(membIdFromUser);
        //新建vo类（便于前端使用）
        MineArchVo mineArchVo = new MineArchVo();
        ArchBasicInfoVo archBasicInfoVo = new ArchBasicInfoVo();
        ConverterUtil.copyProperties(mineArchBasicInfo, mineArchVo);
        ConverterUtil.copyProperties(mineArchBasicInfo, archBasicInfoVo);
        //获取农事记录列表
        List<FarmWorkRecdVo> findListByArchId = farmList(mineArchBasicInfo.getArchId());
        //获取检测记录列表
        List<ExamRecdVo> examRecdList = examRecdList(mineArchId);
        //获取品牌信息列表
        List<BrandInfoVo> findBrandList = brandInfoMapper.findBrandList(mineArchBasicInfo.getMembId());

        mineArchVo.setMembPictureList(membPictureList);
        mineArchVo.setArchBasicInfoVo(archBasicInfoVo);
        mineArchVo.setFarmWorkRecdVoList(findListByArchId);
        mineArchVo.setExamRecdVoList(examRecdList);
        mineArchVo.setBrandInfoVo(findBrandList);

        return mineArchVo;
    }

    /**
     * 正常状态下的档案详情
     *
     * @param mineArchId
     * @return
     */
    public ResultPoJo<MineArchVo> mineArchInfoAndChack (Long mineArchId) {

    	ResultPoJo<MineArchVo> result = new ResultPoJo<MineArchVo>(ConstantCodeMsg.NOMAL);

    	MineArchVo mineArckAndArchInfo = mineArckAndArchInfo(mineArchId);
    	//校验档案状态
    	if (!DictConstants.MINE_ARCH_STATUS_0.equals(mineArckAndArchInfo.getArchBasicInfoVo().getMineArchStatus())) {

    		result.setCode(ConstantCodeMsg.ERR_807);
        	result.setMsg(ConstantCodeMsg.MSG_807);
        	return result;
    	}

    	result.setResult(mineArckAndArchInfo);

        return result;
    }

    /**
     * 查询档案详细信息
     *
     * @param mineArchId
     * @return
     */
    public MineArchInfoVo mineArckInfo (Long mineArchId) {

    	//查询我的档案详细信息和主体信息
        MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(mineArchId);
        //获取农事记录列表
        List<FarmWorkRecdVo> findListByArchId = farmList(mineArchBasicInfo.getArchId());
        //获取检测记录列表
        List<ExamRecdVo> examRecdList = examRecdList(mineArchId);
        //获取品牌信息列表
        List<BrandInfoVo> findBrandList = brandInfoMapper.findBrandList(1L);

        mineArchBasicInfo.setFarmWorkRecdVoList(findListByArchId);
        mineArchBasicInfo.setExamRecdVoList(examRecdList);
        mineArchBasicInfo.setBrandInfoVo(findBrandList);

        return mineArchBasicInfo;
    }

    /**
     * 添加、修改检测记录
     *
     * @param examRecdPo
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> examRecdSava (ExamRecdPo examRecdPo) {

    	ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);
    	//查询我的档案详细信息和主体信息
        MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(examRecdPo.getMineArchId());

    	if (!DictConstants.MINE_ARCH_STATUS_0.equals(mineArchBasicInfo.getMineArchStatus())) {

        	result.setCode(ConstantCodeMsg.ERR_807);
        	result.setMsg(ConstantCodeMsg.MSG_807);
        	return result;
        }

    	OriExamRecd oriExamRecd = new OriExamRecd();
    	ConverterUtil.copyProperties(examRecdPo, oriExamRecd);
    	//判断照片张数
		if (examRecdPo.getFileUrls() != null && examRecdPo.getFileUrls().size() > 6) {

			result.setCode(ConstantCodeMsg.ERR_804);
			result.setMsg(ConstantCodeMsg.MSG_804);
			return result;
		}
    	//判断是编辑还是保存
    	if ("1".equals(examRecdPo.getSavaFlag())) {//编辑

    		OriExamRecd oriExamRecdInfo = oriExamRecdMapper.selectByPrimaryKey(examRecdPo.getId());
    		//校验是否可以修改
    		String checkUser = checkUser(oriExamRecdInfo.getRecdBelongMembId());
    		if ("1".equals(checkUser)) {

    			result.setCode(ConstantCodeMsg.ERR_801);
    			result.setMsg(ConstantCodeMsg.MSG_801);
    			return result;
    		}

    		if ("1".equals(oriExamRecdInfo.getDelFlag())) {

    			result.setCode(ConstantCodeMsg.ERR_802);
    			result.setMsg(ConstantCodeMsg.MSG_802);
    			return result;
    		}
    		//校验排他
    		if (!oriExamRecdInfo.getUpdateDate().equals(examRecdPo.getUpdateDate())) {

        		result.setCode(ConstantCodeMsg.ERR_802);
            	result.setMsg(ConstantCodeMsg.MSG_802);
            	return result;
        	}

    		oriExamRecd.setId(oriExamRecdInfo.getId());
    		oriExamRecd.preUpdate();

    		oriExamRecdMapper.updateByPrimaryKeySelective(oriExamRecd);
    		//删除以前照片
    		examPictureMapper.delByExamId(examRecdPo.getId());

    	}else {
    		//查询该我的档案的检测记录关系
    		ExamRecdRelaKeyVo examRecdRelaKeyVo = new ExamRecdRelaKeyVo();
    		examRecdRelaKeyVo.setMineArchId(examRecdPo.getMineArchId());
    		examRecdRelaKeyVo.setMembId(mineArchBasicInfo.getMembId());
    		examRecdRelaKeyVo.setFlag("1");
    		//根据会员id和我的档案id查询出唯一的检测记录关系id
    		ExamRecdVo examRecdList = examRecdRelaMapper.examRecdList(examRecdRelaKeyVo).get(0);

    		oriExamRecd.setId(IdGen.randomLong());
    		oriExamRecd.setExamRecdRelaId(examRecdList.getExamRecdId());
    		oriExamRecd.setRecdBelongMembId(SystemUtils.getUserOnlyId().getId());
    		oriExamRecd.setIsNewRecord(true);
    		oriExamRecd.preInsert();

    		oriExamRecdMapper.insertSelective(oriExamRecd);
    	}

    	if (examRecdPo.getFileUrls() != null && examRecdPo.getFileUrls().size() > 0) {

    		//设置批量插入
    		List<ExamReportPicture> list = Lists.newArrayList();
    		int count = 1;
    		for (String url : examRecdPo.getFileUrls()) {

    			ExamReportPicture examReportPicture = new ExamReportPicture();

    			examReportPicture.setExamRecdId(oriExamRecd.getId());
    			examReportPicture.setUrl(url);
    			examReportPicture.preInsert();
    			examReportPicture.setRemarks(ConverterUtil.toString(count++));

    			list.add(examReportPicture);
    		}

    		examPictureMapper.batchInsert(list);
    	}

    	return result;
    }

    /**
     * 查询检测记录列表
     *
     * @param mineArchId
     * @return
     */
    public List<ExamRecdVo> examRecdList(Long mineArchId) {

        //获取检测记录列表
        ExamRecdRelaKeyVo examRecdRelaKey = new ExamRecdRelaKeyVo();
        examRecdRelaKey.setMineArchId(mineArchId);
        examRecdRelaKey.setFlag("0");
        List<ExamRecdVo> examRecdList = examRecdRelaMapper.examRecdList(examRecdRelaKey);

        return examRecdList;
    }

    /**
     * 校验我的档案状态
     * @param mineArchId
     * @return
     */
    public ResultPoJo<Object> chackStatus (Long mineArchId) {

    	ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);
    	//查询我的档案详细信息和主体信息
        MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(mineArchId);

    	if (!DictConstants.MINE_ARCH_STATUS_0.equals(mineArchBasicInfo.getMineArchStatus())) {

        	result.setCode(ConstantCodeMsg.ERR_807);
        	result.setMsg(ConstantCodeMsg.MSG_807);
        	return result;
        }

    	return result;
    }

    /**
     * 加校验的检测记录列表
     * @param mineArchId
     * @return
     */
    public ResultPoJo<List<ExamRecdVo>> examRecdListChack (Long mineArchId) {

    	ResultPoJo<List<ExamRecdVo>> result = new ResultPoJo<List<ExamRecdVo>>(ConstantCodeMsg.NOMAL);
    	//查询我的档案详细信息和主体信息
        MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(mineArchId);

    	if (!DictConstants.MINE_ARCH_STATUS_0.equals(mineArchBasicInfo.getMineArchStatus())) {

        	result.setCode(ConstantCodeMsg.ERR_807);
        	result.setMsg(ConstantCodeMsg.MSG_807);
        	return result;
        }

    	//获取检测记录列表
        ExamRecdRelaKeyVo examRecdRelaKey = new ExamRecdRelaKeyVo();
        examRecdRelaKey.setMineArchId(mineArchId);
        examRecdRelaKey.setFlag("0");
        List<ExamRecdVo> examRecdList = examRecdRelaMapper.examRecdList(examRecdRelaKey);
        result.setResult(examRecdList);

    	return result;
    }

    /**
     * 查询检测记录详情
     *
     * @param examRecdId
     * @return
     */
    public ExamRecdVo examRecdInfo (Long examRecdId) {

    	OriExamRecd oriExamRecd = oriExamRecdMapper.selectByPrimaryKey(examRecdId);

    	List<ExamReportPicture> picList = examPictureMapper.selByExamId(oriExamRecd.getId());
    	ExamRecdVo examRecdVo = new ExamRecdVo();
    	ConverterUtil.copyProperties(oriExamRecd, examRecdVo);
    	examRecdVo.setExamReportPicture(picList);
    	examRecdVo.setExamId(oriExamRecd.getId());
    	String checkUser = checkUser(oriExamRecd.getRecdBelongMembId());
    	if (oriExamRecd.getRecdBelongMembId().equals(SystemUtils.getUserOnlyId().getId()) && "0".equals(checkUser)) {

    		checkUser = "0";

    	}else {

    		checkUser = "1";
    	}
    	examRecdVo.setOuthFlag(checkUser);

        return examRecdVo;
    }

    /**
     * 删除检测记录详情
     *
     * @param examRecdId
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> examRecdDele (Long examRecdId) {

    	ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);

    	OriExamRecd oriExamRecd = oriExamRecdMapper.selectByPrimaryKey(examRecdId);
    	//查询我的档案详细信息和主体信息
        MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(oriExamRecd.getMineArchId());

    	if (!DictConstants.MINE_ARCH_STATUS_0.equals(mineArchBasicInfo.getMineArchStatus())) {

        	result.setCode(ConstantCodeMsg.ERR_807);
        	result.setMsg(ConstantCodeMsg.MSG_807);
        	return result;
        }

    	String checkUser = checkUser(oriExamRecd.getRecdBelongMembId());

    	//校验是否可以删除
		if ("1".equals(checkUser) || !oriExamRecd.getRecdBelongMembId().equals(SystemUtils.getUserOnlyId().getId())) {

			result.setCode(ConstantCodeMsg.ERR_801);
			result.setMsg(ConstantCodeMsg.MSG_801);
			return result;
		}

		oriExamRecd.setDelFlag("1");
		oriExamRecd.preUpdate();

		oriExamRecdMapper.updateByPrimaryKeySelective(oriExamRecd);
		examPictureMapper.delByExamIdFlag(examRecdId);

        return result;
    }

    /**
     * 查询档案农事记录列表
     *
     * @param archId
     * @return
     */
    public List<FarmWorkRecdVo> farmList (Long archId) {

    	FarmWorkSelPo farmWorkSelPo = new FarmWorkSelPo();
    	farmWorkSelPo.setId(archId);
    	farmWorkSelPo.setRecordStatus(DictConstants.RECORD_STATUS_1);
    	//获取农事记录列表
        List<FarmWorkRecdVo> findListByArchId = farmWorkRecdMapper.findListByArchId(farmWorkSelPo);

        return findListByArchId;
    }

    /**
     * 查询档案农事记录列表（校验我的档案id）
     *
     * @param po
     * @return
     */
    public ResultPoJo<List<FarmWorkRecdVo>> farmListChack (FarmWorkSelPo po) {

    	ResultPoJo<List<FarmWorkRecdVo>> result = new ResultPoJo<List<FarmWorkRecdVo>>(ConstantCodeMsg.NOMAL);
    	//查询我的档案详细信息和主体信息
        MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(po.getId());

    	if (!DictConstants.MINE_ARCH_STATUS_0.equals(mineArchBasicInfo.getMineArchStatus())) {

        	result.setCode(ConstantCodeMsg.ERR_807);
        	result.setMsg(ConstantCodeMsg.MSG_807);
        	return result;
        }
    	//获取农事记录列表
    	FarmWorkSelPo farmWorkSelPo = new FarmWorkSelPo();
    	farmWorkSelPo.setId(mineArchBasicInfo.getArchId());
    	farmWorkSelPo.setRecordStatus(po.getRecordStatus());
    	farmWorkSelPo.setSearchKey(po.getSearchKey());
        List<FarmWorkRecdVo> findListByArchId = farmWorkRecdMapper.findListByArchId(farmWorkSelPo);

        result.setResult(findListByArchId);

        return result;
    }

    /**
     * 查询档案农事记录详情
     *
     * @param id
     * @return
     */
    public FarmWorkRecdVo farmInfo (Long id) {

    	FarmWorkRecdVo findRecdInfo = farmWorkRecdMapper.findRecdInfo(id);
    	//设置操作标识
    	String checkUser = checkUser(findRecdInfo.getCreateBy());

    	findRecdInfo.setOuthFlag(checkUser);

        return findRecdInfo;
    }

    /**
     * 删除农事记录
     *
     * @param longIdsPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> delFarmRecd (LongIdsPo longIdsPo) {

    	ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);
    	//查询我的档案详细信息和主体信息
        MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(longIdsPo.getIds().get(1));

    	if (!DictConstants.MINE_ARCH_STATUS_0.equals(mineArchBasicInfo.getMineArchStatus())) {

        	result.setCode(ConstantCodeMsg.ERR_807);
        	result.setMsg(ConstantCodeMsg.MSG_807);
        	return result;
        }

    	FarmWorkRecdVo farmInfo = farmInfo(longIdsPo.getIds().get(0));
    	//校验是否可以删除
		if ("1".equals(farmInfo.getOuthFlag())) {

			result.setCode(ConstantCodeMsg.ERR_801);
			result.setMsg(ConstantCodeMsg.MSG_801);
			return result;
		}

		FarmWorkRecd farmWorkRecd = new FarmWorkRecd();

		farmWorkRecd.setId(longIdsPo.getIds().get(0));
		farmWorkRecd.setDelFlag("1");
		farmWorkRecd.preUpdate();

		farmWorkRecdMapper.updateByPrimaryKeySelective(farmWorkRecd);
		farmWorkPictureMapper.delByFarmIdUpd(longIdsPo.getIds().get(0));

		return result;
    }

    /**
     * 判断是否可以操作删除、编辑
     */
    public String checkUser (Long membId) {

    	String outhFlag = "1";
    	//获取当前登录用户
    	User user = SystemUtils.getUser();
    	//获取该用户主体账号
    	Long membIdFromUser = MembUtils.getMembIdFromUser(user);

    	if (user.getId().equals(membId) || membId.equals(membIdFromUser)) {

    		outhFlag = "0";
    	}
    	return outhFlag;
    }

    /**
     * 查询农事操作类型树
     *
     * @param farmWorkDicPo
     * @return
     */
    public Map<String, List<FarmWorkTypeDict>> farmTree (FarmWorkDicPo farmWorkDicPo) {

    	Map<String, List<FarmWorkTypeDict>> map = Maps.newHashMap();
    	//判断是否是“其他”，“其他”就展示常用标签
    	if ("0".equals(farmWorkDicPo.getIsOthType())) {
    		//获取所有父类标签
    		List<FarmWorkTypeDict> parentDic = farmWorkTypeDictMapper.selParentDic();
    		//获取所有常用标签
    		List<FarmWorkTypeDict> comUsedDic = farmWorkTypeDictMapper.selComUsedDic();

    		map.put("parentDic", parentDic);
    		map.put("comUsedDic", comUsedDic);

    	}else {

    		List<FarmWorkTypeDict> selDicByParentId = farmWorkTypeDictMapper.selDicByParentId(farmWorkDicPo.getId());

    		map.put("sunDic", selDicByParentId);
    	}

    	return map;
    }

    /**
     * 查询档案设置详情
     *
     * @param mineArchId
     * @return
     */
    public ResultPoJo<ArchSetup> mineArchSetUpInfo (Long mineArchId) {

    	ResultPoJo<ArchSetup> result = new ResultPoJo<ArchSetup>(ConstantCodeMsg.NOMAL);
    	//获取当前登录用户
    	Long membId = SystemUtils.getUserOnlyId().getId();
    	//设置类查询档案列表
    	MineArchListPo mineArchListPo = new MineArchListPo();
    	mineArchListPo.setId(mineArchId);
    	mineArchListPo.setMembId(membId);
    	//校验是否是该用户或主账号创建、接收
    	List<ArchBasicInfoVo> mineArckList = mineArchMapper.mineArckList(mineArchListPo);

    	if (mineArckList == null || ConverterUtil.isEmpty(mineArckList)) {

    		result.setCode(ConstantCodeMsg.ERR_801);
    		result.setMsg(ConstantCodeMsg.MSG_801);
    		return result;
    	}

    	if (!mineArckList.get(0).getMineArchStatus().equals(DictConstants.MINE_ARCH_STATUS_0)) {

    		result.setCode(ConstantCodeMsg.ERR_807);
    		result.setMsg(ConstantCodeMsg.MSG_807);
    		return result;
    	}

    	result.setResult(archSetupMapper.findByMineArchId(mineArchId));

    	return result;
    }

    /**
     * 保存档案设置
     *
     * @param archSetupPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> archSetupSava (ArchSetupPo archSetupPo) {

    	ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);
    	//获取当前登录用户
    	Long membId = SystemUtils.getUserOnlyId().getId();
    	//设置类查询档案列表
    	MineArchListPo mineArchListPo = new MineArchListPo();
    	mineArchListPo.setId(archSetupPo.getMineArchId());
    	mineArchListPo.setMembId(membId);
    	//校验是否是该用户或主账号创建、接收
    	List<ArchBasicInfoVo> mineArckList = mineArchMapper.mineArckList(mineArchListPo);

    	if (mineArckList == null || ConverterUtil.isEmpty(mineArckList)) {

    		result.setCode(ConstantCodeMsg.ERR_801);
    		result.setMsg(ConstantCodeMsg.MSG_801);
    		return result;
    	}
    	//校验排他
    	ArchSetup archSetup = archSetupMapper.findByMineArchId(archSetupPo.getMineArchId());

    	if (!archSetup.getUpdateDate().equals(archSetupPo.getUpdateDate())) {

    		result.setCode(ConstantCodeMsg.ERR_802);
    		result.setMsg(ConstantCodeMsg.MSG_802);
    		return result;
    	}

    	ConverterUtil.copyProperties(archSetupPo, archSetup);
    	archSetup.preUpdate();
    	archSetupMapper.updateByPrimaryKeySelective(archSetup);

    	return result;
    }

    /****后台管理端****/
    /**
     * 后台管理端查询档案列表
     *
     * @param webMineArchListPo
     * @return
     */
    public List<ArchBasicInfoVo> webMineArckList (WebMineArchListPo webMineArchListPo) {

    	webMineArchListPo.setStartDateStart(OffsetDateTimeUtils.getDayMinTime(webMineArchListPo.getStartDateStart()));
    	webMineArchListPo.setStartDateEnd(OffsetDateTimeUtils.getDayMaxTime(webMineArchListPo.getStartDateEnd()));
    	webMineArchListPo.setEndDateStart(OffsetDateTimeUtils.getDayMinTime(webMineArchListPo.getEndDateStart()));
    	webMineArchListPo.setEndDateEnd(OffsetDateTimeUtils.getDayMaxTime(webMineArchListPo.getEndDateEnd()));
    	webMineArchListPo.setEstListDateStart(OffsetDateTimeUtils.getDayMinTime(webMineArchListPo.getEstListDateStart()));
    	webMineArchListPo.setEstListDateEnd(OffsetDateTimeUtils.getDayMaxTime(webMineArchListPo.getEstListDateEnd()));

    	if (webMineArchListPo.getSeachKey() != null && "0".equals(webMineArchListPo.getSeachKey())) {

    		webMineArchListPo.setArchNum(webMineArchListPo.getValue());

    	}else if (webMineArchListPo.getSeachKey() != null && "1".equals(webMineArchListPo.getSeachKey())) {

    		webMineArchListPo.setMenbName(webMineArchListPo.getValue());

    	}else if (webMineArchListPo.getSeachKey() != null && "2".equals(webMineArchListPo.getSeachKey())) {

    		webMineArchListPo.setSouMenbName(webMineArchListPo.getValue());

    	}else {

    	}

    	List<ArchBasicInfoVo> mineArckList = mineArchMapper.webMineArckList(webMineArchListPo);

    	return mineArckList;
    }

    /**
     * 后台管理端档案操作
     *
     * @param idsAndFlagPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> updMineStatus (IdsAndFlagPo idsAndFlagPo) {

    	ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantCodeMsg.NOMAL);
    	//判断是那种操作
    	if ("0".equals(idsAndFlagPo.getFlag())) {//禁止操作

    		idsAndFlagPo.setMineArchStatus(DictConstants.MINE_ARCH_STATUS_1);
    		mineArchMapper.updMineStatus(idsAndFlagPo);

    	}else if ("1".equals(idsAndFlagPo.getFlag())) {

    		idsAndFlagPo.setMineArchStatus(DictConstants.MINE_ARCH_STATUS_0);
    		mineArchMapper.updMineStatus(idsAndFlagPo);

    	}else if ("2".equals(idsAndFlagPo.getFlag())) {

    		idsAndFlagPo.setDelFlag(DictConstants.DEL_FLAG_0);
    		idsAndFlagPo.setMineArchStatus(DictConstants.MINE_ARCH_STATUS_0);
    		mineArchMapper.updMineStatus(idsAndFlagPo);

    	}else {

    		result.setCode(ConstantError.ERR_005);
    		result.setMsg(ConstantError.MSG_005);
    		return result;
    	}

    	return result;
    }

    /**
     * 模糊查询主体名称
     * @return
     */
    public List<ZhfwMembInfo> searchOrgName() {

        return membInfoMapper.searchOrgName();
    }

    /**
     * 查询所有地块名称
     * @return
     */
    public List<MassifMage> searchMssiName() {
        return massifMageMapper.selAllMassiName();
    }

    /**
     * 根据手机号精确查找会员信息
     *
     * @param contTel
     * @return
     */
    public List<MembMainInfoVo> menbByTel(StringPo contTel) {
        return membInfoMapper.selByMembTel(contTel.getStr());
    }

    /**
     * 获取推送消息标题(当推送时mineArchId是推送人的id，当接收时是接收人的id)
     * @return
     */
    /*public String stringTitle (Long mineArchId, String flag) {
    	//查询我的档案信息
    	MineArchInfoVo mineArchBasicInfo = mineArchMapper.mineArchBasicInfo(mineArchId);
    	//查询档案设置
    	//推送时取自己的档案设置
    	ArchSetup archSetup = null;

    	if ("0".equals(flag)) {

    		archSetup = archSetupMapper.findByMineArchId(mineArchId);
    	}else {

    		archSetup = archSetupMapper.findByMineArchId(mineArchBasicInfo.getMineArchId());
    	}
    	//设置档案对外展示名称
    	String arckName = "";
    	//有对面名称则使用对外名称
    	if (DictConstants.ARCH_ED_NAME_FLAG_0.equals(archSetup.getArchEdNameFlag()) &&
    			archSetup.getArchEdName() != null && archSetup.getArchEdName() != "") {

    		arckName = archSetup.getArchEdName();
    	}else {

    		arckName = mineArchBasicInfo.getCommName();

    		if (mineArchBasicInfo.getVariName() != null) {

    			arckName = arckName.concat("-").concat(mineArchBasicInfo.getVariName());
    		}
    	}

    	String contTel = mineArchBasicInfo.getContTel().substring(0, 3).concat("*****").concat(mineArchBasicInfo.getContTel().substring(7, 11));

    	String infoTitle;
    	//判断是那种类型
    	if ("0".equals(flag)) {//推送消息

    		infoTitle = mineArchBasicInfo.getMenbName().concat("(").concat(contTel).concat(")").concat("向您推送了“").concat(arckName).concat("”档案");

    	}else if ("1".equals(flag)) {//扫码接收消息

    		infoTitle = mineArchBasicInfo.getMenbName().concat("(").concat(contTel).concat(")").concat("扫码接收了您的“").concat(arckName).concat("”档案");

    	}else {//推送接收消息

    		infoTitle = mineArchBasicInfo.getMenbName().concat("(").concat(contTel).concat(")").concat("接收了您推送的“").concat(arckName).concat("”档案");
    	}

    	return infoTitle;
    }*/

    /***************************************定时任务*********************************************/

    /**
     * 定时任务刷新农事记录状态
     */
    @Transactional(readOnly=false)
    public void farmWorkTask () {
    	//获取当天的最小时间
    	OffsetDateTime minTime = OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now());
    	//获取当天的最大时间
    	OffsetDateTime maxTime = OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now());
    	farmWorkRecdMapper.updRecordToNot(minTime);
    	farmWorkRecdMapper.updRecordToNext(minTime, maxTime);
    }
}
