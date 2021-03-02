package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.SzdkConfigure;
import com.wisea.cultivar.common.entity.SzdkConfigureWithBLOBs;
import com.wisea.cultivar.common.po.SzdkConfigurePageListPo;
import com.wisea.cultivar.common.vo.SzdkConfigureInfoVo;
import com.wisea.cultivar.common.vo.SzdkConfigurePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SzdkConfigureMapper extends CrudDao<SzdkConfigure> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SzdkConfigure
     */
    List<SzdkConfigurePageListVo> findPageList(SzdkConfigurePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息SzdkConfigure
     */
    SzdkConfigureInfoVo findInfo(LongIdPo po);
    SzdkConfigureWithBLOBs findById(Long id);

    /**
     * 查询默认数据
     * @return
     */
    SzdkConfigureInfoVo findDetail();
}
