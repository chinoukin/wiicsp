package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.MineArch;
import com.wisea.cultivar.plant.po.oritrapla.IdsAndFlagPo;
import com.wisea.cultivar.plant.po.oritrapla.MineArchListPo;
import com.wisea.cultivar.plant.vo.oritrapla.ArchBasicInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.MineArchInfoVo;
import com.wisea.cultivar.plant.po.oritrapla.WebMineArchListPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MineArchMapper extends CrudDao<MineArch> {

	/**
	 * 根据我的档案id查询详细信息
	 *
	 * @param id
	 * @return
	 */
	public MineArchInfoVo mineArchBasicInfo(Long id);

	/**
	 * 查询档案列表
	 *
	 * @param mineArchListPo
	 * @return
	 */
	public List<ArchBasicInfoVo> mineArckList(MineArchListPo mineArchListPo);

	/**
	 * 后台管理端查询档案列表
	 *
	 * @param webMineArchListPo
	 * @return
	 */
	public List<ArchBasicInfoVo> webMineArckList(WebMineArchListPo webMineArchListPo);

	/**
	 * 修改我的档案状态
	 * @param idsAndFlagPo
	 */
	public void updMineStatus(IdsAndFlagPo idsAndFlagPo);
}
