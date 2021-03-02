package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.ItemConfigure;
import com.wisea.transac.common.entity.ItemConfigureWithBLOBs;
import com.wisea.transac.common.po.ItemConfigurePageListPo;
import com.wisea.transac.common.vo.ItemConfigureInfoVo;
import com.wisea.transac.common.vo.ItemConfigurePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ItemConfigureMapper extends CrudDao<ItemConfigure> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询ItemConfigure
     */
    List<ItemConfigurePageListVo> findPageList(ItemConfigurePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息ItemConfigure
     */
    ItemConfigureInfoVo findInfo(LongIdPo po);
    ItemConfigureWithBLOBs findById(Long id);

    /**
     * 查询默认数据
     * @return
     */
    ItemConfigureInfoVo findDetail();
}
