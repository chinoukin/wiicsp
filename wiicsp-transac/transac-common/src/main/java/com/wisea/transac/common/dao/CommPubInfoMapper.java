package com.wisea.transac.common.dao;

import com.wisea.cloud.common.interceptor.MapF2F;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.CommPubInfo;
import com.wisea.transac.common.po.CommPubInfoPageListPo;
import com.wisea.transac.common.po.product.*;
import com.wisea.transac.common.po.seller.StallsIdAndCommVarietIdPo;
import com.wisea.transac.common.vo.CommMagePageListVo;
import com.wisea.transac.common.vo.CommPubInfoInfoVo;
import com.wisea.transac.common.vo.CommPubInfoPageListVo;
import com.wisea.transac.common.vo.CommPubNumAndWeightVo;
import com.wisea.transac.common.vo.product.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface CommPubInfoMapper extends CrudDao<CommPubInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询CommPubInfo
     */
    List<CommPubInfoPageListVo> findPageList(CommPubInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息CommPubInfo
     */
    CommPubInfoInfoVo findInfo(LongIdPo po);

    /**
     * 根据品类id 查询品牌信息
     *
     * @param longIdPo
     * @return
     */
    List<CommPubInfo> findBrandListByCommMageId(LongIdPo longIdPo);

    /**
     * 运营后台查询 - 商品信息
     *
     * @param po
     * @return
     */
    List<CommDataListVo> commList(CommDataListPo po);

    /**
     * 运营后台查询 - 所有商品信息
     *
     * @param po
     * @return
     */
    List<CommDataListVo> commListAll(CommDataListPo po);

    /**
     * 根据档口ID查询可用的所有品类
     *
     * @param stallsMageId
     * @return
     */
    List<CommVarietMageListVo> findCommVariet(Long stallsMageId);

    /**
     * 根据档口ID和品类ID查询所有可以用品种
     *
     * @param po
     * @return
     */
    List<CommMagePageListVo> findComm(StallsIdAndCommVarietIdPo po);

    /**
     * 查询商品最大编号
     *
     * @param commNum
     * @return
     */
    List<String> findCommPubInfoMaxNum(String commNum);

    /**
     * @Author jirg
     * @Date 2019/5/16 11:16
     * @Description 根据发布商品ID查询对应品类ID
     **/
    @MapF2F()
    Map<Long, Long> getCommIdMap(List<Long> commPubIds);

    /**
     * 根据id查询修改前数据信息 包括 商品标题、商品品类、品种,商品属性中commAttriVal字段,
     *
     * @param id
     * @return
     */
    CheckShopCartProduct findDetailById(Long id);

    /**
     * 查询状态信息
     *
     * @param commPubInfoPagePo
     * @return
     */
    @MapF2F()
    Map<String, Integer> getStateCountMap(CommPubInfoPagePo commPubInfoPagePo);

    /**
     * 查询商家商品管理列表
     *
     * @param commPubInfoPagePo
     * @return
     */
    List<CommPubInfoListVo> findCommPubList(CommPubInfoPagePo commPubInfoPagePo);

    /**
     * 查询产地 状态信息
     *
     * @param commPubInfoPagePo
     * @return
     */
    @MapF2F()
    Map<String, Integer> getStateCountMapOrigin(CommPubInfoPagePo commPubInfoPagePo);

    /**
     * 查询商家商品管理列表 产地
     *
     * @param commPubInfoPagePo
     * @return
     */
    List<CommPubInfoListVo> findCommPubListOrigin(CommPubInfoPagePo commPubInfoPagePo);

    /**
     * 根据档口id 查询销售分类设置信息
     *
     * @param commPubInfoPagePo
     * @return
     */
    List<CommListStaffMageVo> findCommMageListByStaffId(CommPubInfoPagePo commPubInfoPagePo);

    /**
     * 根据档口id 查询销售分类 去重
     * @param commPubInfoPagePo
     * @return
     */
    List<DistincCommSaleVo> findCommMageListDistincStaffId(CommPubInfoPagePo commPubInfoPagePo);

    /**
     * 根据商品发布id 获取详细信息
     * @param commPubInfoGetPo
     * @return
     */
    CommPubInfoInfoVo findById(CommPubInfoGetPo commPubInfoGetPo);

    /**
     * 根据状态和发布商品id 查询发布商品列表
     * @param maps
     * @return
     */
    List<CommPubInfo> findListByCommPubInfoStateType(Map<String, Object> maps);

    /**
     * 批量修改商品发布状态
     * @param map
     */
    void updateCommPubInfoState(Map<String , Object> map);

    /**
     * 批量修改商品发布状态,档口删除商品变已下架
     * @param map
     */
    void updateCommPubState(Map<String , Object> map);

    /**
     * 商家App 商品统计信息
     * @param commodityStatisticsPo
     * @return
     */
    List<CommodityStatisticsVo> selCommodityStatisticsList(CommodityStatisticsPo commodityStatisticsPo);

    /**
     * 运营后台 商品类目销售top10
     * @param commStatisPo
     * @return
     */
    List<CommdityCategoriesVo> commSetSaleScale(CommStatisPo commStatisPo);

    /**
     * 根据基地ID和仓储类型查询所有商品数量和重量单位
     * @param commPubInfo
     * @return
     */
    List<CommPubNumAndWeightVo> findAllByBaseIdAndStoreType(CommPubInfo commPubInfo);

    /**
     * @author jirg
     * @date 2020/7/3 10:15
     * @Description 根据仓库ID查询正在销售商品列表
     */
    List<CommPubInfo> findBySortingFactoryId(@Param("sortingFactoryId") Long sortingFactoryId);

    /**
     * @author jirg
     * @date 2020/7/3 10:15
     * @Description 根据种植园ID查询正在销售商品列表
     */
    List<CommPubInfo> findByPlantationId(@Param("plantationId") Long plantationId);
}
