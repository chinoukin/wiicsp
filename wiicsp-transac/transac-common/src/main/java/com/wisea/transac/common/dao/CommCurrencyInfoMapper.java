package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.CommCurrencyInfo;
import com.wisea.transac.common.po.CommCurrencyInfoPageListPo;
import com.wisea.transac.common.vo.CommCurrencyInfoInfoVo;
import com.wisea.transac.common.vo.CommCurrencyInfoPageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommCurrencyInfoMapper extends CrudDao<CommCurrencyInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/05/11 14:30:27
     * @Description 分页查询CommCurrencyInfo
     */
    List<CommCurrencyInfoPageListVo> findPageList(CommCurrencyInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 14:30:27
     * @Description 查询详细信息CommCurrencyInfo
     */
    CommCurrencyInfoInfoVo findInfo(LongIdPo po);

    CommCurrencyInfoInfoVo findDetail();
}
