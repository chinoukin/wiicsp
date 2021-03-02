package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.EntpAppVersionMage;
import com.wisea.cultivar.common.po.AppVersionPo;
import com.wisea.cultivar.common.po.EntpAppVersionMagePageListPo;
import com.wisea.cultivar.common.vo.EntpAppVersionMageInfoVo;
import com.wisea.cultivar.common.vo.EntpAppVersionMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Update("update zhfw_entp_app_version_mage set del_flag=1 where id=#{id}")
    void batDelete(Long id);

    List<EntpAppVersionMagePageListVo> findPageListSelect(EntpAppVersionMagePageListPo po);

}
