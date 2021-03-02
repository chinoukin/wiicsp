package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.ZdInfoMage;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMageListPo;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMagePagePo;
import com.wisea.cultivar.common.vo.bigdata.ZdInfoMageListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * zd_info_mage 表DAO
 * 站点信息管理
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface ZdInfoMageMapper extends CrudDao<ZdInfoMage> {
    List<ZdInfoMageListVo> findPage(ZdInfoMagePagePo zdInfoMagePagePo);

    List<ZdInfoMageListVo> findList(ZdInfoMageListPo zdInfoMageListPo);

    /**
     * 根据IDS批量删除
     * @param ids
     */
    void delByIds (@Param("ids") String ids);

    /**
     * 根据是否已选设置为null
     */
    void setNullBySfyx ();

    /**
     * 是否名字重复
     * @param zdInfoMageListPo
     * @return
     */
    ZdInfoMageListVo checkName(ZdInfoMageListPo zdInfoMageListPo);
}
