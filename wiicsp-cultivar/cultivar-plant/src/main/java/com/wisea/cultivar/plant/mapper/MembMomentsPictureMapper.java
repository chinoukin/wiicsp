package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.MembMomentsPicture;
import com.wisea.cultivar.plant.po.MembMomentsPicturePageListPo;
import com.wisea.cultivar.plant.vo.MembMomentsPictureInfoVo;
import com.wisea.cultivar.plant.vo.MembMomentsPicturePageListVo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MembMomentsPictureMapper extends CrudDao<MembMomentsPicture> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询MembMomentsPicture
     */
    List<MembMomentsPicturePageListVo> findPageList(MembMomentsPicturePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息MembMomentsPicture
     */
    MembMomentsPictureInfoVo findInfo(LongIdPo po);
}
