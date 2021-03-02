package com.wisea.cultivar.common.dao.tp;

import com.wisea.cloud.common.interceptor.MapF2F;
import com.wisea.cultivar.common.entity.tp.LtaCommRela;
import com.wisea.cultivar.common.po.tp.lta.LtaCommRelaGetPo;
import com.wisea.cultivar.common.po.tp.lta.LtaCommRelaPagePo;
import com.wisea.cultivar.common.vo.tp.lta.LtaCommRelaGetVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaCommRelaListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;
import java.util.Map;

public interface LtaCommRelaMapper extends CrudDao<LtaCommRela> {

    /**
     * 查询长协商品中编号的最大值
     * @param parameter
     * @return
     */
    List<String> findLtaCommRelaMaxNum(String parameter);

    /**
     * 获取详情编辑信息
     * @param ltaCommRelaGetPo
     * @return
     */
    LtaCommRelaGetVo findById(LtaCommRelaGetPo ltaCommRelaGetPo);

    /**
     * 分页查询长协商品信息
     * @param ltaCommRelaPagePo
     * @return
     */
    List<LtaCommRelaListVo> findListSubQuery(LtaCommRelaPagePo ltaCommRelaPagePo);

    /**
     * @Author jirg
     * @Date 2019/5/16 11:07
     * @Description 根据发布商品ID查询对应商品分类ID
     **/
    @MapF2F
    Map<Long, Long> getCommIdMap(List<Long> commRelaIds);
}
