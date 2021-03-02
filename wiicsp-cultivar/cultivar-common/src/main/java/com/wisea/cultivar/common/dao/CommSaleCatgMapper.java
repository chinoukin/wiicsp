package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.CommSaleCatg;
import com.wisea.cultivar.common.po.CommSaleCatgPageListPo;
import com.wisea.cultivar.common.po.product.CommMageTreePo;
import com.wisea.cultivar.common.vo.CommSaleCatgInfoVo;
import com.wisea.cultivar.common.vo.CommSaleCatgPageListVo;
import com.wisea.cultivar.common.vo.product.SalesClassificationListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommSaleCatgMapper extends CrudDao<CommSaleCatg> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询CommSaleCatg
     */
    List<CommSaleCatgPageListVo> findPageList(CommSaleCatgPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息CommSaleCatg
     */
    CommSaleCatgInfoVo findInfo(LongIdPo po);

    /**
     * 查询销售分类列表
     *
     * @param commMageListPo
     * @return
     */
    List<SalesClassificationListVo> findList(CommMageTreePo commMageListPo);

    /**
     * 查询是否后商品关联
     *
     * @param id
     * @return
     */
    Integer selectCommPubCount(Long id);

}
