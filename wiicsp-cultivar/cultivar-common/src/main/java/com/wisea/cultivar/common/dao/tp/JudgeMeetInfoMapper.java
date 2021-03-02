package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.JudgeMeetInfo;
import com.wisea.cultivar.common.po.tp.JudgeMeetInfoListPo;
import com.wisea.cultivar.common.po.tp.JudgeMeetInfoPagePo;
import com.wisea.cultivar.common.vo.tp.JudgeMeetInfoListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * judge_meet_info 表DAO
 * 品鉴会信息
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface JudgeMeetInfoMapper extends CrudDao<JudgeMeetInfo> {
    List<JudgeMeetInfoListVo> findPage(JudgeMeetInfoPagePo judgeMeetInfoPagePo);

    List<JudgeMeetInfoListVo> findList(JudgeMeetInfoListPo judgeMeetInfoListPo);
}
