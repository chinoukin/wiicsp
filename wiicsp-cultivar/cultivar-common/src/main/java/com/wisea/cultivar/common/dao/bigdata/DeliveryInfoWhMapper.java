package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.DeliveryInfoWh;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhListPo;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhPagePo;
import com.wisea.cultivar.common.vo.bigdata.DeliveryInfoWhListVo;

import java.util.List;

/**
 * delivery_info_wh 表DAO
 * 配送信息维护
 * 2019/12/02 11:02:14
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface DeliveryInfoWhMapper extends CrudDao<DeliveryInfoWh> {
    List<DeliveryInfoWhListVo> findPage(DeliveryInfoWhPagePo deliveryInfoWhPagePo);

    List<DeliveryInfoWhListVo> findList(DeliveryInfoWhListPo deliveryInfoWhListPo);

	DeliveryInfoWh selectByPrimaryKeyByid(Long id);
}
