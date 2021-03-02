package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.QuarantinePicture;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

public interface QuarantinePictureMapper extends CrudDao<QuarantinePicture> {

    /**
     * 根据检疫合格证ID删除检疫合格证的图片
     * @param id
     */
    void delByQuarantineReportId(Long id);
}
