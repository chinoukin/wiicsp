package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.CommMage;
import com.wisea.transac.common.po.CommMagePageListPo;
import com.wisea.transac.common.po.product.CommMageTreePo;
import com.wisea.transac.common.vo.CommMageInfoVo;
import com.wisea.transac.common.vo.CommMagePageListVo;
import com.wisea.transac.common.vo.product.CommMageTreeVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommMageMapper extends CrudDao<CommMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询CommMage
     */
    List<CommMagePageListVo> findPageList(CommMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息CommMage
     */
    CommMageInfoVo findInfo(LongIdPo po);

    /**
     * 查询品类信息
     *
     * @param commMageListPo
     * @return
     */
    List<CommMageTreeVo> findList(CommMageTreePo commMageListPo);

    /**
     * 查询是否后商品关联
     *
     * @param id
     * @return
     */
    Integer selectCommPubCount(Long id);

    /**
     * 查询品种是不是和商品关联
     *
     * @param id
     * @return
     */
    Integer selectCommVaritPubCount(Long id);

    /**
     * 根据pid查询下面的所有品类信息
     * @param commId
     * @return
     */
    List<CommMage> findMageByParentId(Long commId);

    /**
     * 查询品类信息
     * @param po
     * @return
     */
    List<CommMage> findListMage(CommMage po);

}
