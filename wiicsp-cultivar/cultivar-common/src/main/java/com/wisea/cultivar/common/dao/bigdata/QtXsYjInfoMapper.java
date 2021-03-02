package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.QtXsYjInfo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoListPo;
import com.wisea.cultivar.common.po.bigdata.QtXsYjInfoPagePo;
import com.wisea.cultivar.common.vo.bigdata.QtXsYjInfoListVo;

import java.util.List;

/**
 * qt_xs_yj_info 表DAO
 * 24小时预警信息
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface QtXsYjInfoMapper extends CrudDao<QtXsYjInfo> {
    List<QtXsYjInfoListVo> findPage(QtXsYjInfoPagePo qtXsYjInfoPagePo);

    List<QtXsYjInfoListVo> findList(QtXsYjInfoListPo qtXsYjInfoListPo);
}
