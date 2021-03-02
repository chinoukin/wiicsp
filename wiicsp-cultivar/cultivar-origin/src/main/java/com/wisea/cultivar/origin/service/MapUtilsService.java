package com.wisea.cultivar.origin.service;

import com.wisea.cultivar.origin.po.MapDetailInfoPo;
import com.wisea.cultivar.origin.properties.TencentProperties;
import com.wisea.cultivar.origin.vo.MapDetailInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.wisea.cultivar.origin.constants.ConstantCodeMsg;
import com.wisea.cultivar.origin.util.HttpUtils;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;

import net.sf.json.JSONObject;

/**
 * 地图相关处理的Service
 *
 * @author wangh(wisea)
 *
 * @date 2019年10月11日
 * @version 1.0
 */
@Service
@EnableConfigurationProperties({TencentProperties.class})
public class MapUtilsService extends BaseService{

	@Autowired
	private TencentProperties tencentProperties;

	/**
	 * 根据经纬度获取地图的详细信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年10月11日
	 * @version 1.0
	 */
	public ResultPoJo<MapDetailInfoVo> getMapDetailByLatLng(MapDetailInfoPo po){
		// 返回值初期化处理
		ResultPoJo<MapDetailInfoVo> result = new ResultPoJo<MapDetailInfoVo>(ConstantCodeMsg.NOMAL);
		// 地址
		String urlStr = tencentProperties.getMapurl() + "location="
				        + po.getLat() +"," + po.getLng()
				        + "&get_poi=0&key=" + tencentProperties.getMapkey();
		try{
			// 获取详细信息
			String json = HttpUtils.getRequest(urlStr);
			JSONObject jsonObject = JSONObject.fromObject(json);
			if(jsonObject != null && jsonObject.getString("status").equals("0")){
				JSONObject resultMap = jsonObject.getJSONObject("result");
				MapDetailInfoVo vo = new MapDetailInfoVo();
				vo.setAreaCode(ConverterUtil.toString(resultMap.getJSONObject("address_reference").getJSONObject("town").get("id")));
				vo.setProvince(ConverterUtil.toString(resultMap.getJSONObject("address_component").get("province")));
				vo.setCity(ConverterUtil.toString(resultMap.getJSONObject("address_component").get("city")));
				vo.setCounty(ConverterUtil.toString(resultMap.getJSONObject("address_component").get("district")));
				vo.setTown(ConverterUtil.toString(resultMap.getJSONObject("address_reference").getJSONObject("town").get("title")));
				JSONObject village = resultMap.getJSONObject("address_reference").getJSONObject("street_number");
				vo.setVillage(ConverterUtil.toString(ConverterUtil.isEmpty(village) ? null : village.get("title")));
				vo.setDetial(ConverterUtil.toString(resultMap.get("address")));
				result.setResult(vo);
			}

		}catch(Exception e){
			result.setCode(ConstantCodeMsg.ERR_801);
			result.setMsg(ConstantCodeMsg.MSG_801);
			return result;
		}
		return result;
    }
}
