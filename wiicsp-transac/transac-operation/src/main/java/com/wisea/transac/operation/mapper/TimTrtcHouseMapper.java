package com.wisea.transac.operation.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.operation.entity.TimTrtcHouse;
import com.wisea.transac.operation.po.TimTrtcHouseListPo;
import com.wisea.transac.operation.po.TimTrtcHousePagePo;
import com.wisea.transac.operation.vo.TimTrtcHouseListVo;
import java.util.List;

import org.apache.ibatis.annotations.Select;

/**
 * tim_trtc_house 表DAO 实时音视频房间表 2020/08/07 17:16:38
 */
public interface TimTrtcHouseMapper extends CrudDao<TimTrtcHouse> {
    /**
     * 分页查询
     */
    List<TimTrtcHouseListVo> findPage(TimTrtcHousePagePo timTrtcHousePagePo);

    /**
     * 列表查询
     */
    List<TimTrtcHouseListVo> findList(TimTrtcHouseListPo timTrtcHouseListPo);

    /**
     * 查询一个未使用的房间
     *
     * @return
     */
    @Select("select * from tim_trtc_house where del_flag = '0' and on_use = '0' order by update_date asc limit 1")
    TimTrtcHouse findNotUseHouse();

    /**
     * get max house num
     *
     * @return
     */
    @Select("select coalesce(max(house_num), 0) from tim_trtc_house where del_flag = '0'")
    int findMaxHouseNum();

    /**
     *
     *
     * @param houseNum
     * @return
     */
    @Select("select * from tim_trtc_house where del_flag = '0' and house_num = #{0}")
    TimTrtcHouse findHouseByNum(Integer houseNum);

    @Select("select t1.* from tim_trtc_house t1, tim_trtc_house_account t2 where t1.del_flag = '0' and t1.id = t2.house_id")
    List<TimTrtcHouse> findHouseByJoinAccount(Long accountId);
}
