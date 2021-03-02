package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.ZhfwCommAttriMage;
import com.wisea.cultivar.common.po.CommAttriMagePageListPo;
import com.wisea.cultivar.common.po.product.CommAttriMagePagePo;
import com.wisea.cultivar.common.po.product.CommTree;
import com.wisea.cultivar.common.vo.CommAttriMageInfoVo;
import com.wisea.cultivar.common.vo.CommAttriMagePageListVo;
import com.wisea.cultivar.common.vo.product.CommAttriMageGetVo;
import com.wisea.cultivar.common.vo.product.CommAttriMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("NbCommAttriMageMapper")
public interface CommAttriMageMapper extends CrudDao<ZhfwCommAttriMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询CommAttriMage
     */
    List<CommAttriMagePageListVo> findPageList(CommAttriMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息CommAttriMage
     */
    CommAttriMageInfoVo findInfo(LongIdPo po);

    /**
     * 基础商品 设置 属性列表
     *
     * @param po
     * @return
     */
    List<CommAttriMageListVo> selectList(CommAttriMagePagePo po);

    /**
     * 属性字段唯一性校验
     *
     * @param po
     * @return
     */
    List<CommAttriMageGetVo> getAttriColumnOnlyState(ZhfwCommAttriMage po);

    /**
     * 查询商品分类的集合
     *
     * @return
     */
    List<CommTree> beforeInsertGetCatgList();

    /**
     * 查询属性集合
     *
     * @return
     */
    List<CommAttriMageGetVo> beforeInsertAttriList();
}
