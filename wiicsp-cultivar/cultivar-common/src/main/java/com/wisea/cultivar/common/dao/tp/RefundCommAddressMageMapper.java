package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.RefundCommAddressMage;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.RefundCommAddressListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RefundCommAddressMageMapper extends CrudDao<RefundCommAddressMage> {

    /**
     * @Author jirg
     * @Date 2019/4/18 17:55
     * @Description 查询退货地址列表
     **/
    List<RefundCommAddressListVo> findListBySellerId(@Param("membId") Long membId);


    /**
     * @Author jirg
     * @Date 2019/4/18 18:22
     * @Description 设置会员的退货地址为不是默认
     **/
    void updateDefaultFlagByMemberId(@Param("membId") Long membId);
}
