package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.GpPjResult;
import com.wisea.cultivar.common.po.tp.product.GpPjResultListPo;
import com.wisea.cultivar.common.po.tp.product.GpPjResultMagePo;
import com.wisea.cultivar.common.po.tp.product.GpPjResultStatePo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.product.GpPjResultListVo;
import com.wisea.cultivar.common.vo.tp.product.GpPjResultPjZbVo;
import com.wisea.cultivar.common.vo.tp.product.GpPjResultVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * gp_pj_result 表DAO
 * 果品评价结果
 * 2019/06/05 10:28:32
 */
@Repository
public interface GpPjResultMapper extends CrudDao<GpPjResult> {

    /**
     * 查询评价结果列表
     * @param gpPjResultListPo
     * @return
     */
    List<GpPjResultListVo> findListGpPjResult(GpPjResultListPo gpPjResultListPo);

    /**
     * 查询评价结果列表
     * @param gpPjResultListPo
     * @return
     */
    List<GpPjResultListVo> findListGpPjResultDistin(GpPjResultListPo gpPjResultListPo);


    /**
     * 查询评价结果详情
     * @param gpPjResultStatePo
     * @return
     */
    GpPjResultPjZbVo findById(GpPjResultStatePo gpPjResultStatePo);

    /**
     * 返回首页大宗单品页的水果指标信息
     * @param gpPjResultMagePo
     * @return
     */
    List<GpPjResultVo> findPjmxCsList(GpPjResultMagePo gpPjResultMagePo);

    /**
     * 验证评价结果中品类是否重复设置
     * @param
     * @return
     */
    GpPjResult checkPjResultCommVariet(GpPjResult gpPjResult);
}
