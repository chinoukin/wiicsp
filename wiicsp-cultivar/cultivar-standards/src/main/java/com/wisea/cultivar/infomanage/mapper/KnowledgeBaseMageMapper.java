package com.wisea.cultivar.infomanage.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.infomanage.entity.KnowledgeBaseMage;
import com.wisea.cultivar.infomanage.entity.KnowledgeBasePicture;
import com.wisea.cultivar.infomanage.po.KnowledgeBaseMageListPo;
import com.wisea.cultivar.infomanage.po.KnowledgeBaseMagePagePo;
import com.wisea.cultivar.infomanage.po.KnowledgeBaseMageStatus;
import com.wisea.cultivar.infomanage.vo.KnowledgeBaseMageListVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * knowledge_base_mage 表DAO
 * 知识库管理
 * 2020/08/05 09:31:34
 */
public interface KnowledgeBaseMageMapper extends CrudDao<KnowledgeBaseMage> {
    /**
     * 分页查询
     */
    List<KnowledgeBaseMageListVo> findPage(KnowledgeBaseMagePagePo knowledgeBaseMagePagePo);

    /**
     * 列表查询
     */
    List<KnowledgeBaseMageListVo> findList(KnowledgeBaseMageListPo knowledgeBaseMageListPo);

    @Insert("insert into knowledge_base_picture(id,knowledge_base_mage_id,url,create_date,update_date,del_flag)\n" +
            "values (#{id},#{knowledgeBaseMageId},#{url},#{createDate},#{updateDate},0)")
    void addImg(KnowledgeBasePicture knowledgeBasePicture);
     @Select("select id,knowledge_base_mage_id knowledgeBaseMageId,url from knowledge_base_picture where knowledge_base_mage_id=#{id} and del_flag=0")
    List<KnowledgeBasePicture> queryImgList(Long id);
    @Update("update knowledge_base_picture set url=#{url},update_date=#{updateDate} where id=#{id} and del_flag=0")
    void updateImg(KnowledgeBasePicture dataImg);
    @Update("update knowledge_base_picture set del_flag=1,update_date=#{updateDate} where knowledge_base_mage_id=#{knowledgeBaseMageId} and del_flag=0")
    void deleteImg(KnowledgeBasePicture id);

    @Update("update knowledge_base_mage set if_show=#{ifShow},update_date=#{updateDate},update_by=#{updateBy} where id=#{id} and del_flag=0")
    void status(KnowledgeBaseMageStatus po);
}
