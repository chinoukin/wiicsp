package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.SubEntpMbInfoMage;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageGetPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageListPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMagePagePo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpMbInfoMageListVo;

import java.util.List;

/**
 * sub_entp_mb_info_mage 表DAO
 * 分公司目标信息维护
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface SubEntpMbInfoMageMapper extends CrudDao<SubEntpMbInfoMage> {
    List<SubEntpMbInfoMageListVo> findPage(SubEntpMbInfoMagePagePo subEntpMbInfoMagePagePo);

    List<SubEntpMbInfoMageListVo> findList(SubEntpMbInfoMageListPo subEntpMbInfoMageListPo);

	SubEntpMbInfoMage selectByPrimaryKeyById(SubEntpMbInfoMageGetPo subEntpMbInfoMageGetPo);

	void updateBySubEntpIdOrYearType(SubEntpMbInfoMage subEntpMbInfoMage);
}
