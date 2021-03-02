package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.PsCarJcInfo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoListPo;
import com.wisea.cultivar.common.po.bigdata.PsCarJcInfoPagePo;
import com.wisea.cultivar.common.vo.bigdata.PsCarJcInfoListVo;

import java.util.List;

/**
 * ps_car_jc_info 表DAO
 * 配送车辆监测信息
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface PsCarJcInfoMapper extends CrudDao<PsCarJcInfo> {
    List<PsCarJcInfoListVo> findPage(PsCarJcInfoPagePo psCarJcInfoPagePo);

    List<PsCarJcInfoListVo> findList(PsCarJcInfoListPo psCarJcInfoListPo);
}
