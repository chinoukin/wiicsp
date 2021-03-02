package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.OrdOpreateInfo;
import com.wisea.transac.common.po.OrdOpreateInfoPageListPo;
import com.wisea.transac.common.vo.OrdOpreateInfoInfoVo;
import com.wisea.transac.common.vo.OrdOpreateInfoPageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrdOpreateInfoMapper extends CrudDao<OrdOpreateInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询OrdOpreateInfo
     */
    List<OrdOpreateInfoPageListVo> findPageList(OrdOpreateInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息OrdOpreateInfo
     */
    OrdOpreateInfoInfoVo findInfo(LongIdPo po);
}
