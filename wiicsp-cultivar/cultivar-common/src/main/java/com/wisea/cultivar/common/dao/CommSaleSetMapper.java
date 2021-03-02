package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.CommSaleSet;
import com.wisea.cultivar.common.po.CommSaleSetPageListPo;
import com.wisea.cultivar.common.po.product.CommMageTreePo;
import com.wisea.cultivar.common.po.product.CommSalesReleasePagePo;
import com.wisea.cultivar.common.vo.CommSaleSetInfoVo;
import com.wisea.cultivar.common.vo.CommSaleSetPageListVo;
import com.wisea.cultivar.common.vo.product.CammSalesReleaseMageListVo;
import com.wisea.cultivar.common.vo.product.CommSalesSetVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommSaleSetMapper extends CrudDao<CommSaleSet> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询CommSaleSet
     */
    List<CommSaleSetPageListVo> findPageList(CommSaleSetPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息CommSaleSet
     */
    CommSaleSetInfoVo findInfo(LongIdPo po);

    /**
     * 查询销售品类配置列表
     *
     * @param commSalesReleasePagePo
     * @return
     */
    List<CammSalesReleaseMageListVo> findSalesClassReleaseList(CommSalesReleasePagePo commSalesReleasePagePo);

    /**
     * 根据销售品类id 删除 对应的配置关系
     *
     * @param commSalesCatgId
     */
    void delBySalesClassId(Long commSalesCatgId);

    /**
     * 查询是否关联了销售分类配置
     *
     * @param po
     * @return
     */
    List<CommSaleSet> findSalesClassReleaseById(LongIdPo po);

    /**
     * 查询是否关联了销售分类配置,根据标准品类id
     *
     * @param po
     * @return
     */
    List<CommSaleSet> findSalesClassReleaseByCommId(LongIdPo po);

    /**
     * 根据销售分类配置的id 查询是否关联的了商品发布（已关联商品发布，不能删除）
     *
     * @param id
     * @return
     */
    Integer selectCommPubCount(Long id);

    /**
     * 模糊查询销售分类
     *
     * @param commMageTreePo
     * @return
     */
    List<CommSalesSetVo> likeQuerySalesSet(CommMageTreePo commMageTreePo);
}
