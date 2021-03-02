package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.FarmingStage;
import com.wisea.cultivar.plant.entity.oritrapla.StagePicture;
import com.wisea.cultivar.plant.po.oritrapla.StagePictureListPo;
import com.wisea.cultivar.plant.po.oritrapla.StagePicturePagePo;
import com.wisea.cultivar.plant.vo.oritrapla.StagePictureListVo;

import java.util.List;

/**
 * stage_picture 表DAO
 * 阶段参考图片
 * 2019/05/27 13:59:47
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface StagePictureMapper extends CrudDao<StagePicture> {
    List<StagePictureListVo> findPage(StagePicturePagePo stagePicturePagePo);

    List<StagePictureListVo> findList(StagePictureListPo stagePictureListPo);

    Integer deleteAllStage(List<FarmingStage> allStage);

    @Override
    int batchInsert(List<StagePicture> list);

    List<StagePicture> getPictByStageId(Long id);

    List<StagePicture> getAllPicture(List<FarmingStage> allStage);
}
