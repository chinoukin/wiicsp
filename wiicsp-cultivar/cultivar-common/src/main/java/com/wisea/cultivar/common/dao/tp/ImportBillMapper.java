package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.ImportBill;
import com.wisea.cultivar.common.po.tp.ImportBillListPo;
import com.wisea.cultivar.common.po.tp.ImportBillPagePo;
import com.wisea.cultivar.common.po.tp.trade.BuyerDeleManyImportBillPo;
import com.wisea.cultivar.common.po.trade.MembAuthPo;
import com.wisea.cultivar.common.vo.tp.ImportBillListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.trade.MembAuthListVo;

import java.util.List;

/**
 * import_bill 表DAO
 * 进货单
 * 2018/09/19 16:06:10
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface ImportBillMapper extends CrudDao<ImportBill> {
    List<ImportBillListVo> findPage(ImportBillPagePo importBillPagePo);

    List<ImportBillListVo> findList(ImportBillListPo importBillListPo);

    /**
     * 查询进货单商品发布id列表
     * @param membId
     * @return
     */
    List<ImportBill> findCommIdList(Long membId);

    /**
     * 根据商品发布ID 以及 买家的ID 查询  是否已经添加此商品
     * @return
     */
    List<ImportBill> isHaveImportBillInfo(ImportBill importBill);

    /**
     * 认证企业的个数
     * @param membAuthPo
     * @return
     */
    MembAuthListVo selectMembList(MembAuthPo membAuthPo);

    /**
     * 根据发布商品的ID集合批量删除 进货单商品信息
     * @return
     */
    void deleImportBillInfoByCommPubIdList(BuyerDeleManyImportBillPo po);

    /**
     * 根据会员id查询进货单总数
     * @param id
     * @return
     */
    int selMyIncomingBillSum(Long id);
}
