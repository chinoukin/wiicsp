package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.SerListInformation;
import com.wisea.cultivar.plant.po.SerListInformationPageListPo;
import com.wisea.cultivar.plant.vo.SerListInformationInfoVo;
import com.wisea.cultivar.plant.vo.SerListInformationPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SerListInformationMapper extends CrudDao<SerListInformation> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
     * @Description 分页查询SerListInformation
     */
    List<SerListInformationPageListVo> findPageList(SerListInformationPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
     * @Description 查询详细信息SerListInformation
     */
    SerListInformationInfoVo findInfo(LongIdPo po);

    //统计未读总数
    Integer countInformation(Long id);

    //未读转为已读
    void toRead(Long id);

    void updateState(LongIdPo po);
}
