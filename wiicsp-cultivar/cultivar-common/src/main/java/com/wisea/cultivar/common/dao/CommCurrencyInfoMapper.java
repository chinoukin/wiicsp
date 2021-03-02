package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.EntpCommPubExamType;
import com.wisea.cultivar.common.entity.ZhfwCommCurrencyInfo;
import com.wisea.cultivar.common.po.CommCurrencyInfoPageListPo;
import com.wisea.cultivar.common.vo.CommCurrencyInfoInfoVo;
import com.wisea.cultivar.common.vo.CommCurrencyInfoPageListVo;
import com.wisea.cultivar.common.vo.EntpCommPubExamTypeVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommCurrencyInfoMapper extends CrudDao<ZhfwCommCurrencyInfo> {
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

    EntpCommPubExamTypeVo findEntpCommPubExamType();

    int updateEntpCommPubExamType(EntpCommPubExamTypeVo vo);

    int insertEntpCommPubExamType(EntpCommPubExamType po);

}
