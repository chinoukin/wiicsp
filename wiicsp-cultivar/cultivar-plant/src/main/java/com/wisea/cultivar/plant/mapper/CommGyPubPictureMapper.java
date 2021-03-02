package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.CommGyPubPicture;
import com.wisea.cultivar.plant.po.CommGyPubPicturePageListPo;
import com.wisea.cultivar.plant.vo.CommGyPubPictureInfoVo;
import com.wisea.cultivar.plant.vo.CommGyPubPicturePageListVo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommGyPubPictureMapper extends CrudDao<CommGyPubPicture> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询CommGyPubPicture
     */
    List<CommGyPubPicturePageListVo> findPageList(CommGyPubPicturePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CommGyPubPicture
     */
    CommGyPubPictureInfoVo findInfo(LongIdPo po);

    /**
     * 根据供应id 查看一张供应图片
     * @param commGyPubId
     * @return
     */
    CommGyPubPictureInfoVo getOneByCommGyPubId(Long commGyPubId);

    /**
     *
     * @param commGyPubId
     * @return
     */
    List<CommGyPubPicture> findListByCommGyPubId(Long commGyPubId);

    /**
     * 根据商品供应id删除
     * @param commGyPubId
     */
    void deleteByCommGyPubId(Long commGyPubId);
}
