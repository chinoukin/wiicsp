package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.MassifMage;
import com.wisea.cultivar.plant.po.oritrapla.ExportPo;
import com.wisea.cultivar.plant.po.oritrapla.LongIdPo;
import com.wisea.cultivar.plant.po.oritrapla.MassifMageInfoListPo;
import com.wisea.cultivar.plant.vo.oritrapla.MassifMageInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.MassifRelatedVo;
import com.wisea.cultivar.plant.vo.oritrapla.WebMassifMageVo;
import com.wisea.cultivar.plant.vo.oritrapla.mss.ArchInfo;
import com.wisea.cultivar.plant.vo.oritrapla.mss.DetailedRecordVo;
import com.wisea.cultivar.plant.vo.oritrapla.mss.EquInfo;
import com.wisea.cultivar.plant.po.oritrapla.StringPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MassifMageMapper extends CrudDao<MassifMage> {

	/**
	 * app查询地块列表
	 *
	 */
	List<MassifMageInfoVo> findMassifPageList(MassifMageInfoListPo po);

	/**
	 *
	 * web查询地块信息列表
	 *
	 * @param po
	 * @return
	 */
	List<WebMassifMageVo> findMassifMageListPage(ExportPo po);

	/**
	 * 查询锁所有地块名称
	 * @return
	 */
	List<MassifMage> selAllMassiName();

    List<MassifRelatedVo> findMassifRelatedList(StringPo po);

    List<EquInfo> findEquByMassifIds(@Param("ids") List<Long> ids);

	List<ArchInfo> findArchByMassifIds(@Param("ids") List<Long> ids);

	/**
	 * @Author jirg
	 * @Date 2019/7/19 14:59
	 * @Description 查询地块种植面积统计信息-供大数据仪表盘使用
	 **/
    //BaseListVo finDashboard(@Param("ids") List<Long> ids);

    /**
     * @Author jirg
     * @Date 2019/7/19 15:12
     * @Description 查询基地详细信息-供大数据仪表盘使用
     **/
    //List<BaseInfoVo> findBaseInfo(BaseInfoPo po);

    /**
     * @Author jirg
     * @Date 2019/7/19 16:43
     * @Description 查询详细记录-供大数据仪表盘使用
     **/
    DetailedRecordVo detailedRecord(LongIdPo po);

    /**
     * @Author jirg
     * @Date 2019/7/19 17:59
     * @Description 查询设备列表-供大数据仪表盘使用
     **/
	//List<EquInfoMageListVo> selectEquInfoMageList(Long id);

	//List<EquInfoMageListVo> selectEquInfoMageListByMassidIdAndEquType(ArchIdAndTypePo po);


	//List<ArchAndEquInfoMageVo> findArchList(Long membId);
}
