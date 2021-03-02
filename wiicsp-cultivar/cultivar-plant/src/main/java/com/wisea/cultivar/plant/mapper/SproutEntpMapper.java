package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.SproutEntp;
import com.wisea.cultivar.plant.vo.SproutEntpInfoVo;
import com.wisea.cultivar.plant.vo.ZhfwMembInfoInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SproutEntpMapper extends CrudDao<SproutEntp> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/07 10:41:14
     * @Description 分页查询SproutEntp
     */
    List<ZhfwMembInfoInfoVo> findPageList();

    /**
     * @author wbf-code-generator
     * @date 2020/08/07 10:41:14
     * @Description 查询详细信息SproutEntp
     */
    SproutEntpInfoVo findInfo(LongIdPo po);
}
