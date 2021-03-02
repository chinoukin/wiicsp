package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.PlaceOriginMage;
import com.wisea.transac.common.po.PlaceOriginMagePageListPo;
import com.wisea.transac.common.vo.PlaceOriginMageInfoVo;
import com.wisea.transac.common.vo.PlaceOriginMagePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlaceOriginMageMapper extends CrudDao<PlaceOriginMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询PlaceOriginMage
     */
    List<PlaceOriginMagePageListVo> findPageList(PlaceOriginMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息PlaceOriginMage
     */
    PlaceOriginMageInfoVo findInfo(LongIdPo po);

    List<PlaceOriginMagePageListVo> findAbroadList();

}
