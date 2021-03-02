package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.CommPicture;
import com.wisea.transac.common.po.CommPicturePageListPo;
import com.wisea.transac.common.vo.CommPictureInfoVo;
import com.wisea.transac.common.vo.CommPicturePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommPictureMapper extends CrudDao<CommPicture> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询CommPicture
     */
    List<CommPicturePageListVo> findPageList(CommPicturePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息CommPicture
     */
    CommPictureInfoVo findInfo(LongIdPo po);

    CommPicture selectMinPictureByCommId(Long id);

    /**
     * 根据商品发布id删除照片
     * @param id
     */
    void delByCommPubInfoId(Long id);
}
