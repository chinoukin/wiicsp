package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.OrderInfoTb;
import com.wisea.cultivar.common.po.tp.StaticOrderPo;
import com.wisea.cultivar.common.vo.bigdata.OrderNumVo;
import com.wisea.cultivar.common.vo.bigdata.OrderSettlement;
import com.wisea.cultivar.common.vo.tp.statistics.ChartVo;
import com.wisea.cultivar.common.vo.tp.statistics.TransactionDataChartVo;
import com.wisea.cultivar.common.vo.tp.trade.OrderInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Mapper
@Repository
public interface OrderInfoTbMapper extends CrudDao<OrderInfoTb> {

    /**
     * @Description 获取全部订单的数量和金额
     **/
    List<OrderNumVo> orderCountSum();


    /**
     * 查询订单编号列表
     * @return
     */
    HashSet<String> findOrderNums();

    List<TransactionDataChartVo> transMouthChartVo (StaticOrderPo po);

    /**
     * 交收方式分析
     * @return
     */
    List<OrderSettlement> modeSettlement();


    /**
     *采购类别占比
     * @return
     */
    List<TransactionDataChartVo> transSaleCatgData (StaticOrderPo po);

    /**
     *热销品类榜单
     * @return
     */
    List<ChartVo> transCategoryData ();

    /**
     *采购品牌占比
     * @return
     */
    List<ChartVo> transBrandData ();

    /**
     *采购价格占比
     * @return
     */
    List<ChartVo> transOrdAmount();

    /**
     *供应商热销排行
     * @return
     */
    List<ChartVo> transSerllerPm ();

    /**
     *热销城市占比
     * @return
     */
    List<ChartVo> transRxCityData ();
}
