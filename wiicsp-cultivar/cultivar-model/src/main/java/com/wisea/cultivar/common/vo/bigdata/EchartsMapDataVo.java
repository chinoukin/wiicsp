package com.wisea.cultivar.common.vo.bigdata;

import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.util.JsonMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/12/2 2:47 下午
 */
@ApiModel("Echarts物流地图展示VO")
public class EchartsMapDataVo implements Serializable {

    @ApiModelProperty("坐标点集合")
    private GeoCoordMap geoCoordMap;
    @ApiModelProperty("路线详情")
    private List<List<Object>> dataArr;

    //    demo
    public static void main(String[] args) {
        EchartsMapDataVo vo = new EchartsMapDataVo();

        GeoCoordMap map = new GeoCoordMap();
        map.put("河内", "105.491121", "20.127053");
        map.put("上海", "121.4648", "31.2891");
        map.put("东莞", "113.8953", "22.901");
        vo.setGeoCoordMap(map);

        List<Object> detail1 = getDetail(new Place("北京"), new Place("河内", 30),
                new OrderInfo("12345678901---订单编号",
                        "火龙果*2柜、龙眼*2柜----商品",
                        "2019年11月16日---下单时间",
                        "2019年11月17日---发货时间",
                        "正在清关---当前地点"));
        List<Object> detail2 = getDetail(new Place("北京"), new Place("南京", 30), new OrderInfo("12345678901---订单编号",
                "火龙果*2柜、龙眼*2柜----商品",
                "2019年11月16日---下单时间",
                "2019年11月17日---发货时间",
                "正在清关---当前地点"));


        List<Object> detail3 = getDetail(new Place("上海"), new Place("包头", 30),
                new OrderInfo("12345678901---订单编号",
                        "火龙果*2柜、龙眼*2柜----商品",
                        "2019年11月16日---下单时间",
                        "2019年11月17日---发货时间",
                        "正在清关---当前地点"));

        vo.setDataArr(Arrays.asList(getNode("上海", detail3), getNode("北京", detail1, detail2)));


        System.out.println("vo = " + JsonMapper.toJsonString(vo));

    }

    /**
     * 生成节点
     */
    @SafeVarargs
    public static List<Object> getNode(String startPlaceName, List<Object>... detail) {
        List<Object> result = new ArrayList<>();
        result.add(startPlaceName);
        result.addAll(Arrays.asList(detail));
        return result;
    }

    /**
     * 生成节点详情
     */
    public static List<Object> getDetail(Place startPlace, Place endPlace, OrderInfo orderInfo) {
        List<Object> result = new ArrayList<>();
        result.add(startPlace);
        result.add(endPlace);
        result.add(orderInfo);
        return result;
    }


    public GeoCoordMap getGeoCoordMap() {
        return geoCoordMap;
    }

    public void setGeoCoordMap(GeoCoordMap geoCoordMap) {
        this.geoCoordMap = geoCoordMap;
    }

    public List<List<Object>> getDataArr() {
        return dataArr;
    }

    public void setDataArr(List<List<Object>> dataArr) {
        this.dataArr = dataArr;
    }

    /**
     * 地点
     */
    public static class Place implements Serializable {
        //地点名称
        private String name;
        //地点图标大小,默认20
        private Integer value = 20;

        public Place() {
        }

        public Place(String name) {
            this.name = name;
        }

        public Place(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * 订单信息
     */
    public static class OrderInfo implements Serializable {

        /**
         * order : 12345678901---订单编号
         * goods : 火龙果*2柜、龙眼*2柜----商品
         * orderTime : 2019年11月16日---下单时间
         * goodsTime : 2019年11月17日---发货时间
         * currentNode : 正在清关---当前地点
         * receName：买家姓名
         * userName：卖家姓名
         * commTotalPrice：订单总金额
         */

        private String order;
        private String goods;
        private String orderTime;
        private String goodsTime;
        private String currentNode;
        private String receName;
        private String userName;
        private Double commTotalPrice;



        public OrderInfo() {
        }

        public OrderInfo(String order, String goods, String orderTime, String goodsTime, String currentNode) {
            this.order = order;
            this.goods = goods;
            this.orderTime = orderTime;
            this.goodsTime = goodsTime;
            this.currentNode = currentNode;
        }

        public OrderInfo(String order, String orderTime, String goodsTime,String receName,String userName, Double commTotalPrice) {
            this.order = order;
            this.orderTime = orderTime;
            this.goodsTime = goodsTime;
            this.receName = receName;
            this.userName = userName;
            this.commTotalPrice = commTotalPrice;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getGoods() {
            return goods;
        }

        public void setGoods(String goods) {
            this.goods = goods;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getGoodsTime() {
            return goodsTime;
        }

        public void setGoodsTime(String goodsTime) {
            this.goodsTime = goodsTime;
        }

        public String getCurrentNode() {
            return currentNode;
        }

        public void setCurrentNode(String currentNode) {
            this.currentNode = currentNode;
        }

        public String getReceName() {
            return receName;
        }

        public void setReceName(String receName) {
            this.receName = receName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Double getCommTotalPrice() {
            return commTotalPrice;
        }

        public void setCommTotalPrice(Double commTotalPrice) {
            this.commTotalPrice = commTotalPrice;
        }
    }

    /**
     * 坐标点
     */
    public static class GeoCoordMap extends HashMap<String, BigDecimal[]> implements Serializable {

        public void put(String key, String x, String y) {
            super.put(key, new BigDecimal[]{new BigDecimal(x), new BigDecimal(y)});
        }

        public void put(String key, String[] values) {
            if (values.length != 2) {
                throw new BusinessException("113", "坐标格式有误");
            }
            put(key, values[0], values[1]);
        }
    }
}
