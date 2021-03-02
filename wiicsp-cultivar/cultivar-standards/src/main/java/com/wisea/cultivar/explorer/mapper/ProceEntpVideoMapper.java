package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.ProceEntpVideo;
import com.wisea.cultivar.explorer.po.ProceEntpVideoListPo;
import com.wisea.cultivar.explorer.po.ProceEntpVideoPagePo;
import com.wisea.cultivar.explorer.vo.ProceEntpVideoListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * proce_entp_video 表DAO
 * 加工企业视频
 * 2020/08/27 13:47:43
 */
public interface ProceEntpVideoMapper extends CrudDao<ProceEntpVideo> {
    /**
     * 分页查询
     */
    List<ProceEntpVideoListVo> findPage(ProceEntpVideoPagePo proceEntpVideoPagePo);

    /**
     * 列表查询
     */
    List<ProceEntpVideoListVo> findList(ProceEntpVideoListPo proceEntpVideoListPo);

    /**
     * 根据ID，查询加工企业的视频链接集合
     *
     * @param entpInfoMageId 企业ID
     * @return List<String>
     */
    List<String> findVideoList(@Param("entpInfoMageId") Long entpInfoMageId);

}
