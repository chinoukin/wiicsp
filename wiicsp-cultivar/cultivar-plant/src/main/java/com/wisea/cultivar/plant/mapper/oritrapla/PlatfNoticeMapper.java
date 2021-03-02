package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfNotice;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfNoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlatfNoticeMapper extends CrudDao<PlatfNotice> {

    /**
     * 翻页查询公告信息
     * @param platfnotice
     * @return
     */
    List<PlatfNoticeVo> findListPage(PlatfNotice platfnotice);
}
