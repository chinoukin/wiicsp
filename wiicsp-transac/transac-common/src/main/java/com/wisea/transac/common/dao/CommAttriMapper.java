package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.CommAttri;
import com.wisea.transac.common.po.CommAttriPageListPo;
import com.wisea.transac.common.vo.CommAttriInfoVo;
import com.wisea.transac.common.vo.CommAttriPageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommAttriMapper extends CrudDao<CommAttri> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询CommAttri
     */
    List<CommAttriPageListVo> findPageList(CommAttriPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息CommAttri
     */
    CommAttriInfoVo findInfo(LongIdPo po);

    void delByCommPubInfoId(Long id);
}
