package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.OrdOpreateInfo;
import com.wisea.cultivar.common.po.tp.OrdOpreateInfoListPo;
import com.wisea.cultivar.common.po.tp.OrdOpreateInfoPagePo;
import com.wisea.cultivar.common.vo.tp.OrdOpreateInfoListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * ord_opreate_info 表DAO
 * 订单操作信息
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface OrdOpreateInfoMapper extends CrudDao<OrdOpreateInfo> {
    List<OrdOpreateInfoListVo> findPage(OrdOpreateInfoPagePo ordOpreateInfoPagePo);

    List<OrdOpreateInfoListVo> findList(OrdOpreateInfoListPo ordOpreateInfoListPo);
}
