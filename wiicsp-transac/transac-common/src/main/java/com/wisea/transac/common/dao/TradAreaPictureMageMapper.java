package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.TradAreaPictureMage;
import com.wisea.transac.common.po.TradAreaPictureMagePageListPo;
import com.wisea.transac.common.vo.TradAreaPictureMageInfoVo;
import com.wisea.transac.common.vo.TradAreaPictureMagePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TradAreaPictureMageMapper extends CrudDao<TradAreaPictureMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询TradAreaPictureMage
     */
    List<TradAreaPictureMagePageListVo> findPageList(TradAreaPictureMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息TradAreaPictureMage
     */
    TradAreaPictureMageInfoVo findInfo(LongIdPo po);

    /**
     * 按交易区ID删除图片
     * @param areaId
     */
    void deleteByAreaId(Long areaId);
}
