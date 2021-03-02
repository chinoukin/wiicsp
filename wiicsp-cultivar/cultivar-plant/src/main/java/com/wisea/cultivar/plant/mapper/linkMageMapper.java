package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.linkMage;
import com.wisea.cultivar.plant.po.linkMagePageListPo;
import com.wisea.cultivar.plant.vo.linkMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface linkMageMapper extends CrudDao<linkMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/10 13:54:21
     * @Description 分页查询linkMage
     */
    List<linkMagePageListVo> findPageList(linkMagePageListPo po);


}
