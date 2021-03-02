package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.MembAttention;
import com.wisea.cultivar.plant.po.MembAttentionPageListPo;
import com.wisea.cultivar.plant.po.MembAttentionPo;
import com.wisea.cultivar.plant.vo.MembAttentionInfoVo;
import com.wisea.cultivar.plant.vo.MembAttentionPageListVo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MembAttentionMapper extends CrudDao<MembAttention> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询MembAttention
     */
    List<MembAttentionPageListVo> findPageList(MembAttentionPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息MembAttention
     */
    MembAttentionInfoVo findInfo(LongIdPo po);

    MembAttentionInfoVo findInfoByConditions(MembAttention membAttention);

    List<MembAttentionInfoVo> findListByMemberIdAndMembAttentionId(MembAttentionPo po);
}
