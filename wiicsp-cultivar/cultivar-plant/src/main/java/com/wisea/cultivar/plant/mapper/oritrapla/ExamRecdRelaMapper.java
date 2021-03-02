package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.ExamRecdRela;
import com.wisea.cultivar.plant.po.oritrapla.ExamRecdRelaKeyVo;
import com.wisea.cultivar.plant.vo.oritrapla.ExamRecdVo;

import java.util.List;

public interface ExamRecdRelaMapper extends CrudDao<ExamRecdRela> {
    /**
     * 查询检测记录列表
     * @return
     */
    public List<ExamRecdVo> examRecdList(ExamRecdRelaKeyVo key);

    /**
     * 查询检测关系列表
     * @return
     */
    public List<ExamRecdVo> examRecdListByKey(ExamRecdRelaKeyVo key);

    /**
     *
     * 批量插入
     * @param list
     */
    public void bethInsert(List<ExamRecdRela> list);
}
