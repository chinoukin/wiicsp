package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.VersionInfoMage;
import com.wisea.cultivar.plant.vo.oritrapla.VersionInfoMageVo;
import com.wisea.cultivar.plant.po.oritrapla.VersionInfoMagePo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VersionInfoMageMapper extends CrudDao<VersionInfoMage> {

    /**
     * 查询版本列表
     * @param versionInfoMagePo
     * @return
     */
    List<VersionInfoMage> findListPage(VersionInfoMagePo versionInfoMagePo);

    /**
     * 获取最新的版本信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月27日
     * @version 1.0
     */
    public VersionInfoMageVo getDetailForNewly(String versionTyp);
}
