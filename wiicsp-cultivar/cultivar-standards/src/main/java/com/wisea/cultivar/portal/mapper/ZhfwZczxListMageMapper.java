package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.portal.entity.ZhfwZczxListMage;
import com.wisea.cultivar.portal.po.ZhfwZczxListMageListPo;
import com.wisea.cultivar.portal.po.ZhfwZczxListMagePagePo;
import com.wisea.cultivar.portal.vo.ZhfwZczxListMageListVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * zhfw_zczx_list_mage 表DAO
 * 种植服务政策咨询管理
 * 2020/08/24 20:28:13
 */
@Component
public interface ZhfwZczxListMageMapper extends CrudDao<ZhfwZczxListMage> {
    /**
     * 分页查询
     */
    List<ZhfwZczxListMageListVo> findPage(ZhfwZczxListMagePagePo zhfwZczxListMagePagePo);

    /**
     * 列表查询
     */
    List<ZhfwZczxListMageListVo> findList(ZhfwZczxListMageListPo zhfwZczxListMageListPo);

    List<ZhfwZczxListMageListVo> findTwoLevelList(ZhfwZczxListMagePagePo po);

    List<ZhfwZczxListMageListVo> findZhfwZczxListMagePage(ZhfwZczxListMagePagePo zhfwZczxListMagePagePo);
}
