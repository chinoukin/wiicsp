package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.MembCollection;
import com.wisea.cultivar.plant.po.MembCollectionPageListPo;
import com.wisea.cultivar.plant.po.MembCollectionPo;
import com.wisea.cultivar.plant.po.PolicyTechnologyInfoPo;
import com.wisea.cultivar.plant.vo.*;
import com.wisea.cultivar.plant.vo.oritrapla.PadMageListVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MembCollectionMapper extends CrudDao<MembCollection> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询MembCollection
     */
    List<MembCollectionPageListVo> findPageList(MembCollectionPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息MembCollection
     */
    MembCollectionInfoVo findInfo(LongIdPo po);

    /**
     * 查看这条收藏存在么
     * @param collectionId
     * @param membId
     * @return
     */
    MembCollectionInfoVo seeExist(@Param("collectionId") Long collectionId, @Param("membId") Long membId);

    /**
     * 根据收藏查看用户的求购信息列表
     * @param po
     * @return
     */
    List<CommQgPubInfoInfoVo> findQGList(MembCollectionPageListPo po);

    /**
     * 根据收藏查看用户的供应信息列表
     * @param po
     * @return
     */
    List<CommGyPubInfoPageListVo> findGYList(MembCollectionPageListPo po);

    /**
     * 查看收藏的知识库
     * @param po
     * @return
     */
    List<KnowledgeBaseMageInfoVo> knowledgeBaseMageList(MembCollectionPageListPo po);

    /**
     * 查看我的收藏病虫害
     * @param po
     * @return
     */
    List<PadMageListVo> findPadMageList(MembCollectionPageListPo po);

    /**
     * 查看标准
     * @param po
     * @return
     */
    List<StandardRuleMageInfoVo> findStandardRuleMageInfoVoList(MembCollectionPageListPo po);

    /**
     * 查看收藏的 服务单
     * @param po
     * @return
     */
    List<ZhfwCommPubInfoPageListVo> findCommPubInfoList(MembCollectionPageListPo po);

    Long ifStatus(PolicyTechnologyInfoPo po);

    List<MembCollectionInfoVo> findListByMemberIdAndCollectionId(MembCollectionPo po);
}
