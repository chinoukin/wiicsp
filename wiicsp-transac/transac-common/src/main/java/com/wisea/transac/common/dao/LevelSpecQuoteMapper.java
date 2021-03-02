package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.LevelSpecQuote;
import com.wisea.transac.common.po.LevelSpecQuotePageListPo;
import com.wisea.transac.common.po.trade.ImportListPo;
import com.wisea.transac.common.vo.LevelSpecQuoteInfoVo;
import com.wisea.transac.common.vo.LevelSpecQuotePageListVo;
import com.wisea.transac.common.vo.trade.ImportCommListVo;
import com.wisea.transac.common.vo.trade.ImportStallsListVo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LevelSpecQuoteMapper extends CrudDao<LevelSpecQuote> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询LevelSpecQuote
     */
    List<LevelSpecQuotePageListVo> findPageList(LevelSpecQuotePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息LevelSpecQuote
     */
    LevelSpecQuoteInfoVo findInfo(LongIdPo po);

    /**
     * 在删除之前做查询判断是否有商品引用该计量单位
     */
    List<LevelSpecQuoteInfoVo> beforeDelSelectMeas(Long id);

    /**
     *查询预订单商品信息
     * @param po
     * @return
     */
    List<ImportStallsListVo> findPreCommList (ImportListPo po);

    /**
     * 获取商品信息
     * @param id
     * @return
     */
    ImportCommListVo selCommLeveInfo (Long id);

    /**
     * 根据商品发布id 查询规格报价信息
     * @param id
     * @return
     */
    List<LevelSpecQuote> findListByCommPubId(Long id);
}
