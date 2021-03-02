package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sms.SmsService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.oritrapla.YjMage;
import com.wisea.cultivar.plant.mapper.oritrapla.YjMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.InsctWarningPo;
import com.wisea.cultivar.plant.po.oritrapla.YjMagePadinfoPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * 病虫害预警消息发送的处理
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月23日
 * @version 1.0
 */
@Service
public class InsectPestsWarningSendService extends BaseService {

	@Autowired
	private SmsService smsService;
	@Autowired
	private YjMageMapper yjMageMapper;
	@Autowired
	private JedisDao jedisDao;

	/**
	 * 发送预警消息到手机或者推送
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月23日
	 * @version 1.0
	 */
	public void sendWarningMsg(InsctWarningPo po){
		// 查询档案信息
		YjMagePadinfoPo yjMagePadinfoPo = yjMageMapper.getSendMsgInfoForYjmage(po.getId());
		if(yjMagePadinfoPo == null || ConverterUtil.isEmpty(yjMagePadinfoPo.getArchId())){
			return;
		}
		// 查询地块的预警发送设置
		YjMage yjMage = yjMageMapper.getInfoByArchId(yjMagePadinfoPo.getArchId());
		// 如果为空表示为设置预警
		if(yjMage == null){
			return;
		}
		String data = ConverterUtil.offsetDateTimeFormat(yjMagePadinfoPo.getReportTime(), ConverterUtil.FORMATE_DATE_TIME_24H_MLINE);
		DecimalFormat df = new DecimalFormat("######0.##");//设置保留位数
		String cxsjTime = df.format((float)yjMagePadinfoPo.getCxsjTime()/60);
		//发送手机号的情况（每天每个档案的没种病虫害只发送一次病虫害）
		if(DictConstants.MASSGE_PUSH_FLAG_0.equals(yjMage.getMassgePushFlag())
				&& ConverterUtil.isNotEmpty(yjMage.getYjTel())){
			String key = DictConstants.YJ_MAGE.concat(yjMagePadinfoPo.getArchId().toString())
						 .concat("_").concat(yjMagePadinfoPo.getPadId());
			String jedisValue = jedisDao.getStr(key);
			if(jedisValue == null){
				// 发送到手机的预警信息
				boolean sendMobile = smsService.sendMessage(yjMage.getYjTel(), "smsYjMage",
						data,yjMagePadinfoPo.getMassifName(),yjMagePadinfoPo.getPadName(),cxsjTime);
				if(sendMobile){
					jedisDao.setSerializeExpire(key, key, 86400);
				}
			}
		}
	}
}
