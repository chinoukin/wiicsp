package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.ReceAddress;
import com.wisea.cultivar.common.po.tp.ReceAddressListPo;
import com.wisea.cultivar.common.po.tp.ReceAddressPagePo;
import com.wisea.cultivar.common.vo.tp.ReceAddressListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * rece_address 表DAO
 * 收货地址
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface ReceAddressMapper extends CrudDao<ReceAddress> {
    List<ReceAddressListVo> findPage(ReceAddressPagePo receAddressPagePo);

    List<ReceAddressListVo> findList(ReceAddressListPo receAddressListPo);

    /**
     * 根据订单ID查询收货地址信息
     * @param ordId
     * @return
     */
    ReceAddress findByOrderId(Long ordId);

    /**
     * @Author jirg
     * @Date 2019/4/18 9:55
     * @Description 根据订单ID删除订单收货地址信息
     **/
    void deleteByOrderId(@Param("ordId") Long ordId);
}
