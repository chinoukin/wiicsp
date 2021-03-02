package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.portal.entity.ZhfwBrandEntpReco;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoListPo;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoPagePo;
import com.wisea.cultivar.portal.vo.ZhfwBrandEntpRecoListVo;
import java.util.List;

/**
 * zhfw_brand_entp_reco 表DAO
 * 种植服务品牌企业推荐
 * 2020/08/24 20:28:13
 */
public interface ZhfwBrandEntpRecoMapper extends CrudDao<ZhfwBrandEntpReco> {
    /**
     * 分页查询
     */
    List<ZhfwBrandEntpRecoListVo> findPage(ZhfwBrandEntpRecoPagePo zhfwBrandEntpRecoPagePo);

    /**
     * 列表查询
     */
    List<ZhfwBrandEntpRecoListVo> findList(ZhfwBrandEntpRecoListPo zhfwBrandEntpRecoListPo);
}
