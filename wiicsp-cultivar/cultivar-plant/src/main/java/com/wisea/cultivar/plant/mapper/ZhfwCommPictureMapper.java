package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.ZhfwCommPicture;
import com.wisea.cultivar.plant.po.ZhfwCommPicturePageListPo;
import com.wisea.cultivar.plant.vo.ZhfwCommPictureInfoVo;
import com.wisea.cultivar.plant.vo.ZhfwCommPicturePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ZhfwCommPictureMapper extends CrudDao<ZhfwCommPicture> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/07 17:27:46
     * @Description 分页查询ZhfwCommPicture
     */
    List<ZhfwCommPicturePageListVo> findPageList(ZhfwCommPicturePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/07 17:27:46
     * @Description 查询详细信息ZhfwCommPicture
     */
    ZhfwCommPictureInfoVo findInfo(LongIdPo po);

    /**
     * 根据商品发布id查询商品图片
     * @param commPubId
     * @return
     */
    List<ZhfwCommPictureInfoVo> findByCommPubId(Long commPubId);
    /**
     * 根据商品发布id查询商品细节图片
     * @param commPubId
     * @return
     */
    List<ZhfwCommPictureInfoVo> findByCommPubIdDetailsPicture(Long commPubId);

}
