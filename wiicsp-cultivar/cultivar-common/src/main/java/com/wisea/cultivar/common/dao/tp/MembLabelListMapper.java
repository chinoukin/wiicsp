package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.MembLabelList;
import com.wisea.cultivar.common.po.tp.MembLabelListListPo;
import com.wisea.cultivar.common.po.tp.MembLabelListPagePo;
import com.wisea.cultivar.common.vo.tp.MembLabelListGetVo;
import com.wisea.cultivar.common.vo.tp.MembLabelListListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * memb_label_list 表DAO
 * 会员标签列表
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface MembLabelListMapper extends CrudDao<MembLabelList> {
    List<MembLabelListListVo> findPage(MembLabelListPagePo membLabelListPagePo);

    List<MembLabelListListVo> findList(MembLabelListListPo membLabelListListPo);
    /**
     * 查询会员标签详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月12日
     * @version 1.0
     */
    public MembLabelListGetVo getDetailById(Long id);
    /**
     * app查询标签列表
     *
     * @author wangh(wisea)
     *
     * @date 2018年11月29日
     * @version 1.0
     */
    public List<MembLabelListGetVo> findLableTabList();

}
