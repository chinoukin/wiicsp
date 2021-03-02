package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.SupPiecePicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SupPiecePictureMapper extends CrudDao<SupPiecePicture> {
    /**
     * @author jirg
     * @date 2020/7/1 13:36
     * @Description 根据优势单品ID删除优势单品图片
     */
    void delBySupPieceId(@Param("supPieceId") Long supPieceId);
}
