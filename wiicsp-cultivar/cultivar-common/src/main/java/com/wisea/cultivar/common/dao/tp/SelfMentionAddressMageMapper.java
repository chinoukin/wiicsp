package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.SelfMentionAddressMage;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.SelfMentionAddressListVo;

import java.util.List;

public interface SelfMentionAddressMageMapper extends CrudDao<SelfMentionAddressMage> {
    /**
     * @Author jirg
     * @Date 2019/4/19 10:21
     * @Description 根据会员查询自提地址列表
     **/
    List<SelfMentionAddressListVo> findListByMembId(Long membId);
}
