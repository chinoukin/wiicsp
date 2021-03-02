package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.DivideEvent;
import com.wisea.cultivar.common.po.tp.DivideEventListPo;
import com.wisea.cultivar.common.po.tp.DivideEventPagePo;
import com.wisea.cultivar.common.vo.tp.DivideEventListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * divide_event 表DAO
 * 分账事件(用于定时任务实现延迟分账)
 * 2019/01/23 10:21:32
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface DivideEventMapper extends CrudDao<DivideEvent> {
    List<DivideEventListVo> findPage(DivideEventPagePo divideEventPagePo);

    List<DivideEventListVo> findList(DivideEventListPo divideEventListPo);

    /**
     * 查询所有可以分账的信息
     * @return
     */
    List<DivideEvent> selOutOfDivide ();

    DivideEvent selDivideByOrdId (DivideEvent divideEvent);
}
