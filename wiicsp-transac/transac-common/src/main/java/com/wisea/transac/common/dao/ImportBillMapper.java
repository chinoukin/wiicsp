package com.wisea.transac.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.ImportBill;
import com.wisea.transac.common.po.ImportBillPageListPo;
import com.wisea.transac.common.po.trade.ImportListPo;
import com.wisea.transac.common.vo.ImportBillInfoVo;
import com.wisea.transac.common.vo.ImportBillPageListVo;
import com.wisea.transac.common.vo.trade.ImportStallsListVo;

@Mapper
@Repository
public interface ImportBillMapper extends CrudDao<ImportBill> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询ImportBill
     */
    List<ImportBillPageListVo> findPageList(ImportBillPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息ImportBill
     */
    ImportBillInfoVo findInfo(LongIdPo po);

    /**
     * 查看进货单是否已经存在
     * @param po
     * @return
     */
    ImportBill isHaveImportBillInfo (ImportBill po);

    /**
     * 查询进货单列表
     * @return
     */
    List<ImportStallsListVo> findImportList (ImportListPo po);

    List<ImportStallsListVo> findLocalImportList (ImportListPo po);

    /**
     * 进货单商品数量角标
     * @param po
     * @return
     */
    String commInfoListNum (ImportListPo po);
}
