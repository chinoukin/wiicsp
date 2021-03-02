package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.StallsVideoMage;
import com.wisea.transac.common.po.seller.StallsVideoMagePageListPo;
import com.wisea.transac.common.vo.seller.StallsVideoMageInfoVo;
import com.wisea.transac.common.vo.seller.StallsVideoMagePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StallsVideoMageMapper extends CrudDao<StallsVideoMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询StallsVideoMage
     */
    List<StallsVideoMagePageListVo> findPageList(StallsVideoMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息StallsVideoMage
     */
    StallsVideoMageInfoVo findInfo(LongIdPo po);

    /**
     * 按shopID查询店铺默认视频
     * @param shopId 店铺ID
     * @return
     */
    List<StallsVideoMageInfoVo> findShopVideoByShopId(Long shopId);

    List<StallsVideoMageInfoVo> findShopVideoByStallsId(Long stallsId);

}
