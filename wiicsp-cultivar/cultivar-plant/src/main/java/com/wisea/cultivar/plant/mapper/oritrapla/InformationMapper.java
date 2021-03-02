package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.Information;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @author: wangs
 * @date :2018/6/5
 */
@Mapper
@Repository
public interface InformationMapper extends CrudDao<Information> {

    /**
     * 查询我的系统消息未读总数
     * @param membId
     * @return
     */
    int platformMessageSum(Long membId);
}
