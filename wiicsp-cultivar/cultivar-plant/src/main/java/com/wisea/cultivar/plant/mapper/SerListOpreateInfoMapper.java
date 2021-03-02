package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.SerListOpreateInfo;
import com.wisea.cultivar.plant.po.SerListOpreateInfoPageListPo;
import com.wisea.cultivar.plant.vo.SerListOpreateInfoInfoVo;
import com.wisea.cultivar.plant.vo.SerListOpreateInfoPageListVo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SerListOpreateInfoMapper extends CrudDao<SerListOpreateInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询SerListOpreateInfo
     */
    List<SerListOpreateInfoPageListVo> findPageList(SerListOpreateInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息SerListOpreateInfo
     */
    SerListOpreateInfoInfoVo findInfo(LongIdPo po);

    /**
     * 根据服务单id查询操作日志
     * @param serListId
     * @return
     */
    List<SerListOpreateInfoInfoVo> findByserListId(Long serListId);
}
