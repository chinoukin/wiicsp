package com.wisea.transac.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.OrdInvo;
import com.wisea.transac.common.po.OrdInvoPageListPo;
import com.wisea.transac.common.po.trade.OrdInvoPagePo;
import com.wisea.transac.common.vo.OrdInvoInfoVo;
import com.wisea.transac.common.vo.OrdInvoPageListVo;
import com.wisea.transac.common.vo.StateTypeVo;
import com.wisea.transac.common.vo.trade.OrdInvoPageVo;

@Mapper
@Repository
public interface OrdInvoMapper extends CrudDao<OrdInvo> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询OrdInvo
     */
    List<OrdInvoPageListVo> findPageList(OrdInvoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息OrdInvo
     */
    OrdInvoInfoVo findInfo(LongIdPo po);

    /**
     * @Author jirg
     * @Date 2019/4/18 11:22
     * @Description 根据订单ID查询订单发票
     **/
    OrdInvo findByOrdId(@Param("ordId") Long ordId);

    /**
     * @param po
     * @return
     * 根据用户查询信息
     */
    List<OrdInvoPageListVo> findminiPageList(OrdInvoPageListPo po);

    /**
     * 更改该用户的默认发票
     * @param entity
     */
    void updateOrdInfo(OrdInvo entity);

    /**
     * 获取申请开票的申请编号
     * @param applNum
     * @return
     */
    List<String> findApplNumMaxNum(String applNum);

    /**
     * 查询订单发票列表
     * @param po
     * @return
     */
    List<OrdInvoPageVo> ordInvoList(OrdInvoPagePo po);

    /**
     * 查询订单发票列表
     * @param po
     * @return
     */
    List<StateTypeVo> orderInvoNumb(OrdInvoPagePo po);

    /**
     * 查询待开票数量
     * @param sellerId
     * @return
     */
    String notOpenInvoCount (@Param("sellerId") Long sellerId);
}
