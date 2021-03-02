package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.OrdYjInfo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoListPo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoPagePo;
import com.wisea.cultivar.common.vo.bigdata.OrdYjInfoListVo;

import java.util.List;

/**
 * ord_yj_info 表DAO
 * 订单预警信息
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface OrdYjInfoMapper extends CrudDao<OrdYjInfo> {
    List<OrdYjInfoListVo> findPage(OrdYjInfoPagePo ordYjInfoPagePo);

    List<OrdYjInfoListVo> findList(OrdYjInfoListPo ordYjInfoListPo);

    /**
     * 查询全部数据,返回entity对象集合
     * @return
     */
    List<OrdYjInfo> findAllEntity();
}
