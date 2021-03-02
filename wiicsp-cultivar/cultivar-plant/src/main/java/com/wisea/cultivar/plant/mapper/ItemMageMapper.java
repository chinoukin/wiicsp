package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.ItemMage;
import com.wisea.cultivar.plant.po.ItemMagePageListPo;
import com.wisea.cultivar.plant.vo.ItemMageInfoVo;
import com.wisea.cultivar.plant.vo.ItemMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemMageMapper extends CrudDao<ItemMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/08 09:47:10
     * @Description 分页查询ItemMage
     */
    List<ItemMagePageListVo> findPageList(ItemMagePageListPo po);


    List<ItemMagePageListVo> findItemMagePageList(ItemMagePageListPo po);

    ItemMageInfoVo findGuideInfo(LongIdPo po);
}
