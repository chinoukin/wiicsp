package com.wisea.cultivar.supply.mapper;


import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.supply.entity.ZhfwCommPicture;
import com.wisea.cultivar.supply.vo.PictureVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZhfwCommPictureMapper extends CrudDao<ZhfwCommPicture> {

    /**
     * 根据商品id逻辑删除图片
     */
    void deleteByCommId(Long commPubId);

    /**
     * 通过主图片类型和商品id查询图片
     * @param commPubId 商品id
     * @param pictureType 主图片类型
     */
    List<PictureVo> findByCommPubId(@Param("commPubId") Long commPubId, @Param("pictureType") String pictureType);
}
