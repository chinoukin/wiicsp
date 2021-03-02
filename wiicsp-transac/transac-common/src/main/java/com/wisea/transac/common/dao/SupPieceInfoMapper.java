package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.SupPieceInfo;
import com.wisea.transac.common.po.seller.FindSupPieceListPo;
import com.wisea.transac.common.vo.FindSupPieceListVo;
import com.wisea.transac.common.vo.seller.BaseCataListVo;
import com.wisea.transac.common.vo.seller.SupPieceInfoListVo;
import com.wisea.transac.common.vo.seller.SupPieceInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SupPieceInfoMapper extends CrudDao<SupPieceInfo> {
    /**
     * @author jirg
     * @date 2020/7/1 11:32
     * @Description 根据基地ID查询基地优势单品列表
     */
    List<SupPieceInfoListVo> findListByBaseId(LongIdPo po);

    /**
     * @author jirg
     * @date 2020/7/1 13:20
     * @Description 优势单品详细信息
     */
    SupPieceInfoVo findSupPieceInfo(LongIdPo po);

    /**
     * 根据基地ID查询优势单品列表
     * @param po
     * @return
     */
    List<FindSupPieceListVo> findSupPieceInfoList(FindSupPieceListPo po);

    Integer countAllByBaseId(Long baseId);

    List<BaseCataListVo> findCataList();
    List<BaseCataListVo> findAbroadCataList();
}
