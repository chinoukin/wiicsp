package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.CommSampRela;
import com.wisea.cultivar.common.po.tp.CommSampRelaListPo;
import com.wisea.cultivar.common.po.tp.CommSampRelaPagePo;
import com.wisea.cultivar.common.po.tp.SampInfoAddRelevancePo;
import com.wisea.cultivar.common.vo.tp.CommSampRelaGetVo;
import com.wisea.cultivar.common.vo.tp.CommSampRelaListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * comm_samp_rela 表DAO
 * 关系类型： 0检测关系 1品鉴关系
 * 2018/09/18 14:36:47
 */
@Repository
public interface CommSampRelaMapper extends CrudDao<CommSampRela> {
    /**
     * 分页查询
     */
    List<CommSampRelaListVo> findPage(CommSampRelaPagePo commSampRelaPagePo);

    /**
     * 列表查询
     */
    List<CommSampRelaListVo> findList(CommSampRelaListPo commSampRelaListPo);

    /**
     * 根据商品发布id删除商品样品关系表
     * @param id
     */
    void delByCommPubInfoId(Long id);

    /**
     * 根据样品id删除商品样品关系表
     * @param sampInfoAddRelevancePo
     */
    void delBySampId(SampInfoAddRelevancePo sampInfoAddRelevancePo);

    /**
     * 根据商品id查询总数
     * @param
     * @return
     */
    int selCommPubInfoIdCount(SampInfoAddRelevancePo sampInfoAddRelevancePo);


    List<CommSampRelaGetVo> selSampId(Long id);
}
