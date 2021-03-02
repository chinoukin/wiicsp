package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.YmsjwhQyxx;
import com.wisea.cultivar.common.po.tp.system.YmsjwhQyxxPagePo;
import com.wisea.cultivar.common.vo.tp.system.YmsjwhQyxxListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * ymsjwh_qyxx 表DAO
 * 页面数据企业信息
 * 2019/08/29 17:45:19
 */
public interface YmsjwhQyxxMapper extends CrudDao<YmsjwhQyxx> {

    List<YmsjwhQyxxListVo> findForPages(YmsjwhQyxxPagePo po);
}
