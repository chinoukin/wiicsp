package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.SubEntpPicture;

import java.util.List;


/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface SubEntpPictureMapper extends CrudDao<SubEntpPicture> {

    List<SubEntpPicture> findList(SubEntpPicture subEntpPicture);

	void deleteBySubEntpId(Long subEntpId);
}
