package com.wisea.cultivar.common.dao.tp;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.tp.RetrospPcMage;
import com.wisea.cultivar.common.po.tp.retro.RetrospPcMageListPo;
import com.wisea.cultivar.common.po.tp.retro.RetrospPcMagePagePo;
import com.wisea.cultivar.common.vo.tp.retro.RetrospPcMageListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * retrosp_pc_mage 表DAO
 * 追溯批次管理
 * 2019/12/20 14:20:02
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface RetrospPcMageMapper extends CrudDao<RetrospPcMage> {
    List<RetrospPcMageListVo> findPage(RetrospPcMagePagePo retrospPcMagePagePo);

    List<RetrospPcMageListVo> findList(RetrospPcMageListPo retrospPcMageListPo);

    RetrospPcMageListVo findByPcNum(String pcNum);

    /**
     * @Author jirg
     * @Date 2019/12/21 10:14
     * @Description 查询批次号列表
     **/
    List<String> findTraceBatchNumCode(@Param("prefix") String prefix);
}
