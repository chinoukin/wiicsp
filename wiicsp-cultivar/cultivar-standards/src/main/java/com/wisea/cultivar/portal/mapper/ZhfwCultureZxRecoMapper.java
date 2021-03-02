package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.portal.entity.ZhfwCultureZxReco;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoListPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoPagePo;
import com.wisea.cultivar.portal.vo.ZhfwCultureZxRecoListVo;
import java.util.List;

/**
 * zhfw_culture_zx_reco 表DAO
 * 种植服务文化资讯推荐
 * 2020/08/24 20:28:13
 */
public interface ZhfwCultureZxRecoMapper extends CrudDao<ZhfwCultureZxReco> {
    /**
     * 分页查询
     */
    List<ZhfwCultureZxRecoListVo> findPage(ZhfwCultureZxRecoPagePo zhfwCultureZxRecoPagePo);

    /**
     * 列表查询
     */
    List<ZhfwCultureZxRecoListVo> findList(ZhfwCultureZxRecoListPo zhfwCultureZxRecoListPo);
}
