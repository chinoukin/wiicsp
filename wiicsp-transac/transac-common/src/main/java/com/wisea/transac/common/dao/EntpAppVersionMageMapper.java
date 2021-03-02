package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.EntpAppVersionMage;
import com.wisea.transac.common.po.AppVersionPo;
import com.wisea.transac.common.po.EntpAppVersionMagePageListPo;
import com.wisea.transac.common.vo.EntpAppVersionMageInfoVo;
import com.wisea.transac.common.vo.EntpAppVersionMagePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EntpAppVersionMageMapper extends CrudDao<EntpAppVersionMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 分页查询EntpAppVersionMage
     */
    List<EntpAppVersionMagePageListVo> findPageList(EntpAppVersionMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 查询详细信息EntpAppVersionMage
     */
    EntpAppVersionMageInfoVo findInfo(LongIdPo po);

    /**
     * 根据appVersionType查询最新的一条记录
     * @param po
     * @return
     */
    EntpAppVersionMageInfoVo findLatest(AppVersionPo po);


    List<EntpAppVersionMagePageListVo> findList(EntpAppVersionMagePageListPo po);
}
