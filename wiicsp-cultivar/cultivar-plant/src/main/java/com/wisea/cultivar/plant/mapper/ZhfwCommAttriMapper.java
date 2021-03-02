package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.ZhfwCommAttri;
import com.wisea.cultivar.plant.po.ZhfwCommAttriPageListPo;
import com.wisea.cultivar.plant.vo.ZhfwCommAttriInfoVo;
import com.wisea.cultivar.plant.vo.ZhfwCommAttriPageListVo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ZhfwCommAttriMapper extends CrudDao<ZhfwCommAttri> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询ZhfwCommAttri
     */
    List<ZhfwCommAttriPageListVo> findPageList(ZhfwCommAttriPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息ZhfwCommAttri
     */
    ZhfwCommAttriInfoVo findInfo(LongIdPo po);
}
