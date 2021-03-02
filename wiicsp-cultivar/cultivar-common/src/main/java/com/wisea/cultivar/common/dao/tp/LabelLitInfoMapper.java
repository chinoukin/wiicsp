package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.LabelLitInfo;
import com.wisea.cultivar.common.po.tp.LabelLitInfoListPo;
import com.wisea.cultivar.common.po.tp.LabelLitInfoPagePo;
import com.wisea.cultivar.common.po.tp.SampInfoAddRelevancePo;
import com.wisea.cultivar.common.vo.tp.LabelLitInfoGetVo;
import com.wisea.cultivar.common.vo.tp.LabelLitInfoListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * label_lit_info 表DAO
 * 标签点亮信息
 * 2018/09/18 14:36:47
 * 分页查询
 */
public interface LabelLitInfoMapper extends CrudDao<LabelLitInfo> {

    /**
     * 分页查询
     */
    List<LabelLitInfoListVo> findPage(LabelLitInfoPagePo labelLitInfoPagePo);

    /**
     * 列表查询
     */
    List<LabelLitInfoListVo> findList(LabelLitInfoListPo labelLitInfoListPo);

    /**
     * 根据发布商品id删除商家对应的标签信息
     *
     * @param id
     */
    void delByCommPubInfoId(Long id);

    /**
     * 根据发布商品id和id删除商家对应的标签信息 delByCommPubIdLabelType
     *
     * @param labelLitInfo
     */
    void delByCommPubIdAndLabelType(LabelLitInfo labelLitInfo);

    /**
     * 根据发布商品id和标签type信息
     *
     * @param labelLitInfo
     */
    void delByCommPubIdLabelType(LabelLitInfo labelLitInfo);

    /**
     * 根据商品id查询那些标签点亮
     *
     * @param id
     * @return
     */
    List<LabelLitInfoGetVo> selLabelitInfoByComPubId(Long id);

    /**
     * 根据商品id,检疫合格证id,检疫合格证type 查询是否点亮了检疫合格证
     * @param sampInfoAddRelevancePo
     * @return
     */
    int selCommPubInfoIdCount(SampInfoAddRelevancePo sampInfoAddRelevancePo);

    /**
     * 批量插入检疫合格证type
     * @param labelLitInfos
     */
    void batchInsertType(List<LabelLitInfo> labelLitInfos);
}
