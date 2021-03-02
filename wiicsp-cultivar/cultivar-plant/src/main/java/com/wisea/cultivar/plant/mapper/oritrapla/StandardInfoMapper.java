package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.StandardInfo;
import com.wisea.cultivar.plant.po.oritrapla.StandardInfoListPo;
import com.wisea.cultivar.plant.po.oritrapla.StandardInfoPagePo;
import com.wisea.cultivar.plant.vo.oritrapla.StandardInfoListVo;

import java.util.List;

/**
 * standard_info 表DAO
 * 标准详情
 * 2019/05/27 13:59:47
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface StandardInfoMapper extends CrudDao<StandardInfo> {
    List<StandardInfoListVo> findPage(StandardInfoPagePo standardInfoPagePo);

    List<StandardInfoListVo> findList(StandardInfoListPo standardInfoListPo);

    /**
     * 根据standard_specification_id删除所有记录
     * @return
     */
    int deleteBySSId(StandardInfo info);

    /**
     * 根据standard_specification_id查询所有可用记录
     * @param ssid
     * @return
     */
    List<StandardInfoListVo> findListBySSId(Long ssid);
}
