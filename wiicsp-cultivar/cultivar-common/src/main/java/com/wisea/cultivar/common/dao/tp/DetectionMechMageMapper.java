package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.DetectionMechMage;
import com.wisea.cultivar.common.po.tp.DetectionMechMageListPo;
import com.wisea.cultivar.common.po.tp.DetectionMechMagePagePo;
import com.wisea.cultivar.common.vo.tp.DetectionMechMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * detection_mech_mage 表DAO
 * 检测机构管理
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface DetectionMechMageMapper extends CrudDao<DetectionMechMage> {
    List<DetectionMechMageListVo> findPage(DetectionMechMagePagePo detectionMechMagePagePo);

    List<DetectionMechMageListVo> findList(DetectionMechMageListPo detectionMechMageListPo);
}
