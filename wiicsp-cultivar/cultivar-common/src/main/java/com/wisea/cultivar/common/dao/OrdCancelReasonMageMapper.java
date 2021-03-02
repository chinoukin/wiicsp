package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.OrdCancelReasonMage;
import com.wisea.cultivar.common.po.OrdCancelReasonMagePageListPo;
import com.wisea.cultivar.common.vo.OrdCancelReasonMageInfoVo;
import com.wisea.cultivar.common.vo.OrdCancelReasonMagePageListVo;
import com.wisea.cultivar.common.vo.trade.OrdCancelReasonMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("NbOrdCancelReasonMageMapper")
public interface OrdCancelReasonMageMapper extends CrudDao<OrdCancelReasonMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询OrdCancelReasonMage
     */
    List<OrdCancelReasonMagePageListVo> findPageList(OrdCancelReasonMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息OrdCancelReasonMage
     */
    OrdCancelReasonMageInfoVo findInfo(LongIdPo po);

    /**
     * 查询订单取消原因
     * @return
     */
    List<OrdCancelReasonMageListVo> findAllReason();
}
