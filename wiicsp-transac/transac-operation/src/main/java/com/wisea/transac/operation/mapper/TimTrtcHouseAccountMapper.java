package com.wisea.transac.operation.mapper;

import java.util.List;

import com.wisea.transac.operation.entity.TimTrtcHouseAccount;
import org.apache.ibatis.annotations.Select;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * tim_trtc_house_account 表DAO
 * 实时音视频房间成员表
 * 2020/08/07 17:16:38
 */
public interface TimTrtcHouseAccountMapper extends CrudDao<TimTrtcHouseAccount> {
    @Select("select * from tim_trtc_house_account where del_flag = '0' and house_id = #{houseId}")
    List<TimTrtcHouseAccount> findListByHouseId(TimTrtcHouseAccount entity);

    @Select("select * from tim_trtc_house_account where del_flag = '0' and house_id = #{houseId} and account_id = #{accountId}")
    TimTrtcHouseAccount getByHouseIdAccountId(TimTrtcHouseAccount entity);
}
