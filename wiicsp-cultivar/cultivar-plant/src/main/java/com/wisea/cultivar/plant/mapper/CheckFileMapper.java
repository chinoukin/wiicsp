package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.CheckFile;
import com.wisea.cultivar.plant.po.CheckFilePageListPo;
import com.wisea.cultivar.plant.vo.CheckFileInfoVo;
import com.wisea.cultivar.plant.vo.CheckFilePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CheckFileMapper extends CrudDao<CheckFile> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/11 16:49:11
     * @Description 分页查询CheckFile
     */
    List<CheckFilePageListVo> findPageList(CheckFilePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/11 16:49:11
     * @Description 查询详细信息CheckFile
     */
    CheckFileInfoVo findInfo(LongIdPo po);

    void deleteByMageId(Long id);
}
