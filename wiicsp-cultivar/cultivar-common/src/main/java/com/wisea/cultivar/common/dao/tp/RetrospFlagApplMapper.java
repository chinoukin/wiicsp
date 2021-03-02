package com.wisea.cultivar.common.dao.tp;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.tp.RetrospFlagAppl;
import com.wisea.cultivar.common.po.tp.LongIdPo;
import com.wisea.cultivar.common.po.tp.retro.RetrospFlagApplListPo;
import com.wisea.cultivar.common.vo.tp.retro.RetrospFlagApplListVo;
import com.wisea.cultivar.common.vo.tp.retro.RetrospFlagApplPreviewVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetrospFlagApplMapper extends CrudDao<RetrospFlagAppl> {
    /**
     * @Author jirg
     * @Date 2019/12/20 11:12
     * @Description 查询追溯码申请记录列表
     **/
    List<RetrospFlagApplListVo> findFlagApplList(RetrospFlagApplListPo po);

    /**
     * @Author jirg
     * @Date 2019/12/20 14:11
     * @Description 预览
     **/
    RetrospFlagApplPreviewVo findFlagApplPreview(LongIdPo po);

    /**
     * 按追溯批次查询申请数量总和
     * @param pcId
     * @return
     */
    Integer findSumAppSlByPcId(Long pcId);
}
