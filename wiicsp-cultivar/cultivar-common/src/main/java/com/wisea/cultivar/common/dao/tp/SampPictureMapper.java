package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.vo.tp.SampPictureGetVo;
import com.wisea.cultivar.common.entity.tp.SampPicture;
import com.wisea.cultivar.common.po.tp.SampPictureListPo;
import com.wisea.cultivar.common.po.tp.SampPicturePagePo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.SampImgListForSynVo;
import com.wisea.cultivar.common.vo.tp.SampPictureListVo;

/**
 * samp_picture 表DAO
 * 样品图片信息
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface SampPictureMapper extends CrudDao<SampPicture> {
    List<SampPictureListVo> findPage(SampPicturePagePo sampPicturePagePo);

    List<SampPictureListVo> findList(SampPictureListPo sampPictureListPo);

	List<SampImgListForSynVo> findImgList(Long id);

	List<SampPictureGetVo> findUrlBySampId(Long id);
}
