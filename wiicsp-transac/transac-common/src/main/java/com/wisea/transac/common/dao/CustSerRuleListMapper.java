package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.CustSerRuleList;
import com.wisea.transac.common.po.CustSerRuleListPageListPo;
import com.wisea.transac.common.vo.CustSerRuleListInfoVo;
import com.wisea.transac.common.vo.CustSerRuleListPageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CustSerRuleListMapper extends CrudDao<CustSerRuleList> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询CustSerRuleList
     */
    List<CustSerRuleListPageListVo> findPageList(CustSerRuleListPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息CustSerRuleList
     */
    CustSerRuleListInfoVo findInfo(LongIdPo po);
}
