package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.GoodsRecall;
import com.wisea.cultivar.common.vo.bigdata.CityAndQuantity;
import com.wisea.cultivar.common.vo.bigdata.GoodsRecallInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsRecallMapper extends CrudDao<GoodsRecall> {

    /**
     * @author wbf-code-generator
     * @date 2020/09/03 10:07:58
     * @Description 根据批次号查询召回信息
     */
    List<GoodsRecallInfoVo> findInfo();
    /**
     * @author wbf-code-generator
     * @date 2020/09/03 10:07:58
     * @Description 根据批次号查询册亨县平级的县召回信息
     */
    List<GoodsRecallInfoVo> findCeHengInfo();
    /**
     * 统计总数
     * @return
     */
    long totalStatistics();

    /**
     * 统计贵州下黔西南布依族苗族自治州总数
     * @return
     */
    long ceHengtotalStatistics();

    /**
     * 统计湖南省各个市总数
     * @return
     */
    List<CityAndQuantity> groupStatistics(String parentId);

    /**
     * 统计黔西南布依族苗族自治州各个县总数
     * @return
     */
    List<CityAndQuantity> groupCeHengStatistics(String parentId);

    /**
     * 获取湖南省的id
     * @return
     */
    String getParentId();

    /**
     * 获取贵州下黔西南布依族苗族自治州的id
     * @return
     */
    String getCeHengParentId();
}
