package com.wisea.cultivar.common.dao.tp;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.tp.RetrospCxRecord;
import com.wisea.cultivar.common.po.tp.retro.RetrospCxRecordListPo;
import com.wisea.cultivar.common.vo.tp.retro.RetrospCxRecordListVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetrospCxRecordMapper extends CrudDao<RetrospCxRecord> {
    /**
     * @Author jirg
     * @Date 2019/12/21 11:43
     * @Description 查询追溯码第一次查询记录
     **/
    List<RetrospCxRecord> findFirstQueryRecord(@Param("retroCode") String retroCode);

    /**
     * @Author jirg
     * @Date 2019/12/21 12:47
     * @Description 查询追溯查询记录列表
     **/
    List<RetrospCxRecordListVo> findCxRecordList(RetrospCxRecordListPo po);

    /**
     * 按批次号查询记录条数
     * @param pcNum
     * @return
     */
    Integer findCountByPcNum(String pcNum);
}
