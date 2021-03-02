package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.BrandMage;
import com.wisea.transac.common.entity.CommPubInfo;
import com.wisea.transac.common.po.BrandMagePageListPo;
import com.wisea.transac.common.po.product.BrandMagePagePo;
import com.wisea.transac.common.vo.BrandMageInfoVo;
import com.wisea.transac.common.vo.BrandMagePageListVo;
import java.util.List;

import com.wisea.transac.common.vo.product.BrandMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BrandMageMapper extends CrudDao<BrandMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询BrandMage
     */
    List<BrandMagePageListVo> findPageList(BrandMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息BrandMage
     */
    BrandMageInfoVo findInfo(LongIdPo po);

    /**
     * 查询名称是否重复
     */
    BrandMageListVo selectbyName(BrandMage insert);

    /**
     * 查询是否有商品关联信息
     */
    List<CommPubInfo> selectCommByBrandId(Long id);

    /**
     * 查询名称和ID是否重复
     */
    BrandMageListVo selectbyNameAndId(BrandMage po);

    /**
     * 查询品牌的顺序
     * @param po
     * @return
     */
    List<BrandMage> selectSortIsNotNull(BrandMagePagePo po);

    /**
     * 查询品牌序号
     * @param po
     * @return
     */
    List<BrandMageListVo> noAuthNoPageBrandList(BrandMagePagePo po);

    /**
     * 运营平台查询品牌列表
     * @param po
     * @return
     */
    List<BrandMageListVo> selectBrandList(BrandMagePagePo po);

    /**
     * 查询品牌列表信息
     * @return
     */
    List<BrandMageListVo> brandInterface();
}
