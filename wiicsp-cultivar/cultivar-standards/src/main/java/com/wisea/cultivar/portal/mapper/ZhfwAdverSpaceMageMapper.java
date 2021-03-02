package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.portal.entity.ZhfwAdverSpaceMage;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageGetPo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageListPo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMagePagePo;
import com.wisea.cultivar.portal.vo.ZhfwAdverSpaceMageListVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * zhfw_adver_space_mage 表DAO
 * 种植服务广告位管理
 * 2020/08/24 20:28:13
 */
@Component
public interface ZhfwAdverSpaceMageMapper extends CrudDao<ZhfwAdverSpaceMage> {
    /**
     * 分页查询
     */
    List<ZhfwAdverSpaceMageListVo> findPage(ZhfwAdverSpaceMagePagePo zhfwAdverSpaceMagePagePo);

    /**
     * 列表查询
     */
    List<ZhfwAdverSpaceMageListVo> findList(ZhfwAdverSpaceMageListPo zhfwAdverSpaceMageListPo);

    ZhfwAdverSpaceMage selectByAdverSpaceName(ZhfwAdverSpaceMageGetPo zhfwAdverSpaceMageGetPo);
}
