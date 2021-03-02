package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.QuarantineReport;
import com.wisea.cultivar.common.po.tp.QuarantineReportPagePo;
import com.wisea.cultivar.common.vo.tp.QuarantineReportGetVo;
import com.wisea.cultivar.common.vo.tp.QuarantineReportListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

public interface QuarantineReportMapper extends CrudDao<QuarantineReport> {

    /**
     * 查询检疫合格证列表
     * @param quarantineReportPagePo
     * @return
     */
    List<QuarantineReportListVo> findPage(QuarantineReportPagePo quarantineReportPagePo);

    /**
     * 查询检疫合格证详情
     * @param id
     * @return
     */
    QuarantineReportGetVo selectDetailById(Long id);
}
