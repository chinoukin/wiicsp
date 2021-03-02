package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.CarJcInfo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoListPo;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoPagePo;
import com.wisea.cultivar.common.vo.bigdata.CarJcInfoListVo;

import java.util.List;

/**
 * car_jc_info 表DAO
 * 车辆监测信息
 * 2019/12/02 11:02:14
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface CarJcInfoMapper extends CrudDao<CarJcInfo> {
    List<CarJcInfoListVo> findPage(CarJcInfoPagePo carJcInfoPagePo);

    List<CarJcInfoListVo> findList(CarJcInfoListPo carJcInfoListPo);

    List<CarJcInfo> findAllEntity();
}
