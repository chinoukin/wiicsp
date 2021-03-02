package com.wisea.transac.common.dao;

import com.wisea.cloud.common.interceptor.MapF2F;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.SettleBillInvo;
import com.wisea.transac.common.po.SettleBillInvoPageListPo;
import com.wisea.transac.common.vo.SettleBillInvoInfoVo;
import com.wisea.transac.common.vo.SettleBillInvoPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SettleBillInvoMapper extends CrudDao<SettleBillInvo> {
    /**
     * @Author jirg
     * @Date 2020/5/19 17:19
     * @Description 分页查询结算单发票列表
     */
    List<SettleBillInvoPageListVo> findPageList(SettleBillInvoPageListPo po);

    /**
     * @Author jirg
     * @Date 2020/5/19 17:18
     * @Description 查询结算单发票详细信息
     */
    SettleBillInvoInfoVo findInfo(LongIdPo po);

    /**
     * @Author yangtao
     * @Date 2020/5/19 17:18
     * @Description 根据账期ID查询结算单发票详细信息
     */
    SettleBillInvoInfoVo findInfoBySettId(LongIdPo po);


    /**
     * @Author jirg
     * @Date 2020/5/19 17:09
     * @Description 查询个状态数量
     */
    @MapF2F
    Map<String, Integer> findCountByState(SettleBillInvoPageListPo po);

    /**
     * 查询待开票数量
     * @param sellerId
     * @return
     */
    String notOpenInvoCount (@Param("sellerId") Long sellerId);

    /**
     * 获取申请开票的申请编号
     * @param applNum
     * @return
     */
    List<String> findApplNumMaxNum(String applNum);
}
