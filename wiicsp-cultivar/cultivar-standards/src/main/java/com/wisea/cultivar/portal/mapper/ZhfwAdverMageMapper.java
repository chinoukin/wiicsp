package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.portal.entity.ZhfwAdverMage;
import com.wisea.cultivar.portal.po.ZhfwAdverMageListPo;
import com.wisea.cultivar.portal.po.ZhfwAdverMagePagePo;
import com.wisea.cultivar.portal.vo.ZhfwAdverMageListVo;
import java.util.List;

/**
 * zhfw_adver_mage 表DAO
 * 种植服务广告管理
 * 2020/08/24 20:28:13
 */
public interface ZhfwAdverMageMapper extends CrudDao<ZhfwAdverMage> {
    /**
     * 分页查询
     */
    List<ZhfwAdverMageListVo> findPage(ZhfwAdverMagePagePo zhfwAdverMagePagePo);

    /**
     * 列表查询
     */
    List<ZhfwAdverMageListVo> findList(ZhfwAdverMageListPo zhfwAdverMageListPo);

    /**
     * 首页
     * @param zhfwAdverMagePagePo
     * @return
     */
    List<ZhfwAdverMageListVo> findByAdverSpaceId(ZhfwAdverMagePagePo zhfwAdverMagePagePo);
}
