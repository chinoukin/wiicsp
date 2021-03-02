package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.interceptor.MapF2F;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.CommPubInfo;
import com.wisea.cultivar.common.po.product.CommDataListPo;
import com.wisea.cultivar.common.po.product.CommPubInfoGetPo;
import com.wisea.cultivar.common.vo.product.CommDataListVo;
import com.wisea.cultivar.common.vo.product.CommPubInfoInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository("NbCommPubInfoMapper")
public interface CommPubInfoMapper extends CrudDao<CommPubInfo> {
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
    void updateCommPubInfoState(Map<String, Object> map);

    /**
     * 批量修改商品发布状态,档口删除商品变已下架
     * @param map
     */
    void updateCommPubState(Map<String, Object> map);

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
