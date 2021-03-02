package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.FarmingStage;
import com.wisea.cultivar.standards.entity.StagePicture;
import com.wisea.cultivar.standards.po.StagePictureListPo;
import com.wisea.cultivar.standards.po.StagePicturePagePo;
import com.wisea.cultivar.standards.vo.StagePictureListVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * stage_picture 表DAO
 * 阶段参考图片
 * 2020/07/24 11:21:45
 */
@Component
public interface StagePictureMapper extends CrudDao<StagePicture> {
    /**
     * 分页查询
     */
    List<StagePictureListVo> findPage(StagePicturePagePo stagePicturePagePo);

    /**
     * 列表查询
     */
    List<StagePictureListVo> findList(StagePictureListPo stagePictureListPo);

    /**
     * 列表查询
     */
    List<StagePictureListVo> findFarmingStageIdList(StagePictureListPo stagePictureListPo);

    Integer deleteAllStage(List<FarmingStage> allStage);

    List<StagePicture> getAllPicture(List<FarmingStage> allStage);
}
