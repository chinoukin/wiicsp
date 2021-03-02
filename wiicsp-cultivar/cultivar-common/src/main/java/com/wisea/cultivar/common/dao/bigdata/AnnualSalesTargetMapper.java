package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.bigdata.AnnualSalesTarget;
import com.wisea.cultivar.common.po.bigdata.AnnualSalesTargetPageListPo;
import com.wisea.cultivar.common.po.bigdata.TotalSalesPo;
import com.wisea.cultivar.common.vo.bigdata.AnnualSalesTargetInfoVo;
import com.wisea.cultivar.common.vo.bigdata.AnnualSalesTargetPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnnualSalesTargetMapper extends CrudDao<AnnualSalesTarget> {
    /**
     * @author wbf-code-generator
     * @date 2020/02/07 18:53:13
     * @Description 分页查询AnnualSalesTarget
     */
    List<AnnualSalesTargetPageListVo> findPageList(AnnualSalesTargetPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/02/07 18:53:13
     * @Description 查询详细信息AnnualSalesTarget
     */
    AnnualSalesTargetInfoVo findInfo(LongIdPo po);

    /**
     * 根据年份查询年销售额目标
     * @param po
     * @return
     */
    AnnualSalesTarget findByYear(TotalSalesPo po);
}
