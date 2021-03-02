package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.bigdata.*;
import com.wisea.cultivar.common.entity.tp.SampInfo;
import com.wisea.cultivar.common.entity.tp.SampListWebPo;
import com.wisea.cultivar.common.entity.tp.SampListWebVo;
import com.wisea.cultivar.common.po.bigdata.SampInfoPo;
import com.wisea.cultivar.common.po.bigdata.SampJcCountPagePo;
import com.wisea.cultivar.common.po.bigdata.SampJcCountPo;
import com.wisea.cultivar.common.po.tp.SampInfoListPo;
import com.wisea.cultivar.common.po.tp.SampInfoPagePo;
import com.wisea.cultivar.common.po.tp.SampListForSynPo;
import com.wisea.cultivar.common.vo.tp.SampInfoListForSynVo;

/**
 * samp_info 表DAO
 * 样品信息
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface SampInfoMapper extends CrudDao<SampInfo> {
    List<SampInfoListForSynVo> findPage(SampInfoPagePo sampInfoPagePo);

    List<SampInfoListForSynVo> findList(SampInfoListPo sampInfoListPo);

    /**
     * 分页查询
     * @param sampInfoPagePo
     * @return
     */
    List<SampInfoListForSynVo> findSampInfoList(SampInfoPagePo sampInfoPagePo);

    /**
     * 关联样品商品信息查询列表
     * @param po
     * @return
     */
    List<SampListWebVo> findSampInfoListWebLabel(SampListWebPo po);

     /**
      * 查询检测样品
      * @param po
      * @return
      */
	List<SampInfoListForSynVo> findSampList(SampListForSynPo po);

	/**
	 * 根据传过来的未检测id去查询是否更新为已检测
	 * @param wjcList
	 * @return
	 */
	List<SampInfoListForSynVo> findYJCSampList(String id);


	/**
	 * 获取湖南省抽检数和比率
	 * @param po
	 * @return
	 */
	SampInfoCountVo getCountAndRate(SampInfoPo po);


    /**
     * 各市区抽样结果
     * @return
     */
    List<SampInformationVo> getSampInformationVo(SampInfoPo po);
    /**
     * 湖南省各个市 样品数
     * @return
     */
    List<CityAndQuantity> getCityAndQuantity(SampInfoPo po);
   /**
	 * 样品信息统计的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年11月7日
	 * @version 1.0
	 */
	public List<SampJcCountVo> sampJcCount(SampJcCountPo po);
	/**
	 *
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年11月7日
	 * @version 1.0
	 */
	public List<SampBaseInfoForBigDataVo> findSampPage(SampJcCountPagePo po);

	SampInfoCountVo getQDCountAndRate(SampInfoPo po);

	List<SampInformationVo> getQDSampInformationVo(SampInfoPo po);

	List<CityAndQuantity>   getQDCityAndQuantity(SampInfoPo po);

}
