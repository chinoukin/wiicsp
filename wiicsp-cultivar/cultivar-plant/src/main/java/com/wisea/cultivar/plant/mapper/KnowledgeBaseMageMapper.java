package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.KnowledgeBaseMage;
import com.wisea.cultivar.plant.po.KnowledgeBaseMagePageListPo;
import com.wisea.cultivar.plant.vo.KnowledgeBaseMageInfoVo;
import com.wisea.cultivar.plant.vo.KnowledgeBaseMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface KnowledgeBaseMageMapper extends CrudDao<KnowledgeBaseMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/08 14:38:07
     * @Description 分页查询KnowledgeBaseMage
     */
    List<KnowledgeBaseMagePageListVo> findPageList(KnowledgeBaseMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/08 14:38:07
     * @Description 查询详细信息KnowledgeBaseMage
     */
    KnowledgeBaseMageInfoVo findInfo(Long id);

    void updateViewsByKey(Long id);

    @Select("select url from knowledge_base_picture where knowledge_base_mage_id=#{id} and del_flag=0 order by create_date asc limit 1")
    String findByIdPicture(Long id);
}
