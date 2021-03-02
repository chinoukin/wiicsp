package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.ReceAddressMage;
import com.wisea.cultivar.common.po.tp.ReceAddressMageListPo;
import com.wisea.cultivar.common.po.tp.ReceAddressMagePagePo;
import com.wisea.cultivar.common.vo.tp.ReceAddressMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.DefaultAddressVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * rece_address_mage 表DAO
 * 收货地址管理
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
@Repository
public interface ReceAddressMageMapper extends CrudDao<ReceAddressMage> {
    List<ReceAddressMageListVo> findPage(ReceAddressMagePagePo receAddressMagePagePo);

    List<ReceAddressMageListVo> findList(ReceAddressMageListPo receAddressMageListPo);

    /*
    * 通过会员ID去获得用户个人的地址
    * */
    List<ReceAddressMageListVo> getAddressList(ReceAddressMageListPo po);


    /*
    * 通过用户ID查询是否存在默认的地址
    * */
    ReceAddressMageListVo selectDefaultBoolean(ReceAddressMageListPo po);

    /*
    * 通过查询出来的地址ID去修改默认地址的标识
    * */
    Integer updateDefaultAddr(ReceAddressMageListVo defaultAddress);

    /**
     * 修改其他地址为非默认
     */
    void updateDefaultToNo(Long membId);

    Integer saveDefaultAddr(ReceAddressMageListPo po);

    /**
     * 分页查询地址
     * @param po ReceAddressMagePagePo
     * @return List
     */
    List<ReceAddressMageListVo> findForPages(ReceAddressMagePagePo po);

    /**
     * 按地址ID查询
     * @param id Long
     * @return ReceAddressMageListVo
     */
    ReceAddressMageListVo findById(@Param("id")Long id);

    /**
     * 按membID统计可用地址总数
     * @param membId Long
     * @return Integer
     */
    Long countByMembId(@Param("membId") Long membId);

    /**
     * 按membID统计可用默认地址
     * @param membId
     * @return
     */
    Long countByMembIdAndDefault0(@Param("membId") Long membId);

    /**
     * 按membId更新所有记录defaultflag
     * @param po
     * @return
     */
    int updateAllDefaultFlagByMembId(ReceAddressMage po);

    /*
     * 根据会员的ID查询默认收货地址
     * */
    DefaultAddressVo selectDefaultAddrByMembId(Long membId);
}
