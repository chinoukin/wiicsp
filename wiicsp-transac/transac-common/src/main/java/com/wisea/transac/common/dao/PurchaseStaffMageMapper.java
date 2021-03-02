package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.PurchaseStaffMage;
import com.wisea.transac.common.po.PurchaseStaffMagePageListPo;
import com.wisea.transac.common.vo.PurchaseStaffMageInfoVo;
import com.wisea.transac.common.vo.PurchaseStaffMagePageListVo;
import com.wisea.transac.common.vo.seller.PurchaseStaffCountVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PurchaseStaffMageMapper extends CrudDao<PurchaseStaffMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询PurchaseStaffMage
     */
    List<PurchaseStaffMagePageListVo> findPageList(PurchaseStaffMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息PurchaseStaffMage
     */
    PurchaseStaffMageInfoVo findInfo(LongIdPo po);

    /**
     * 根据采购员id查询，非关联状态
     * @param po
     * @return
     */
    List<PurchaseStaffMageInfoVo> findByPurchaseStaffId(LongIdPo po);

    /**
     * 根据采购员id查询，关联状态
     * @param po
     * @return
     */
    PurchaseStaffMageInfoVo findByPurchaseStaffIdNormal(LongIdPo po);

    /**
     * 根据手机号查询
     * @param tel
     * @return
     */
    PurchaseStaffMageInfoVo findByRemarks(String tel);

    /**
     * 查询采购人员总数和正常使用人数
     * @param membId
     * @return
     */
    PurchaseStaffCountVo findTotalCountAndNormalCount(Long membId);
    /**
     * 查询采购员是管理员的列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月4日
     * @version 1.0
     */
    public List<String> findPurMageAdminList(Long membId);

    PurchaseStaffMage findByStaffId(Long id);

    List<PurchaseStaffMage> findByMembId(Long id);
}
