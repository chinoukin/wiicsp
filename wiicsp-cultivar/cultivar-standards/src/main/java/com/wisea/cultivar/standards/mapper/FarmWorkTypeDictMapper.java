package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.FarmWorkTypeDict;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictListPo;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictPagePo;
import com.wisea.cultivar.standards.vo.FarmWorkTypeDictListVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * farm_work_type_dict 表DAO
 * 农事操作类型字典
 * 2020/07/24 11:21:45
 */
@Component
public interface FarmWorkTypeDictMapper extends CrudDao<FarmWorkTypeDict> {
    /**
     * 分页查询
     */
    List<FarmWorkTypeDictListVo> findPage(FarmWorkTypeDictPagePo farmWorkTypeDictPagePo);

    /**
     * 列表查询
     */
    List<FarmWorkTypeDictListVo> findList(FarmWorkTypeDictListPo farmWorkTypeDictListPo);
    /**
     * 一级农事查询
     */
    List<FarmWorkTypeDictListVo> findPSList(FarmWorkTypeDictListPo farmWorkTypeDictListPo);
    /**
     * 二级农事查询
     */
    List<FarmWorkTypeDictListVo> findTwoList(FarmWorkTypeDictListPo farmWorkTypeDictListPo);
}
