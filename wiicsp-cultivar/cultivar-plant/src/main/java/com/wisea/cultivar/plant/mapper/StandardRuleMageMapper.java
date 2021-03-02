package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.StandardRuleMage;
import com.wisea.cultivar.plant.po.StandardRuleMagePageListPo;
import com.wisea.cultivar.plant.vo.StandardRuleMageInfoVo;
import com.wisea.cultivar.plant.vo.StandardRuleMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StandardRuleMageMapper extends CrudDao<StandardRuleMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/08 16:53:01
     * @Description 分页查询StandardRuleMage
     */
    List<StandardRuleMagePageListVo> findPageList(StandardRuleMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/08 16:53:01
     * @Description 查询详细信息StandardRuleMage
     */
    StandardRuleMageInfoVo findInfo(Long po);

    String findOriginalInfo(LongIdPo po);

    void updateViewsByKey(Long id);
}
