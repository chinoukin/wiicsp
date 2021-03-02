package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.SaleStaffInfoMage;
import com.wisea.transac.common.po.SaleStaffInfoMagePageListPo;
import com.wisea.transac.common.po.seller.FindInfoByStallsMageIdPo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMageInfoVo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SaleStaffInfoMageMapper extends CrudDao<SaleStaffInfoMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询SaleStaffInfoMage
     */
    List<SaleStaffInfoMagePageListVo> findPageList(SaleStaffInfoMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息SaleStaffInfoMage
     */
    SaleStaffInfoMageInfoVo findInfo(LongIdPo po);

    /**
     * @Author jirg
     * @Date 2020/5/7 16:36
     * @Description 根据销售员ID查询销售员工信息
     **/
    SaleStaffInfoMage findBySaleStaffId(@Param("saleStaffId") Long id);

    /**
     * 根据档口ID查询销售员工
     * @param po
     * @return
     */
    List<SaleStaffInfoMageInfoVo> findInfoByStallsMageId(FindInfoByStallsMageIdPo po);

    /**
     * 根据会员ID查询员工列表
     * @param po
     * @return
     */
    List<SaleStaffInfoMageInfoVo> findListByMembId(FindInfoByStallsMageIdPo po);


    /**
     * 根据销售员ID查询销售员工信息状态正常采购
     * @param id
     * @return
     */
    SaleStaffInfoMage findInfoBySaleStaffId(@Param("saleStaffId") Long id);

    /**
     *
     * @param info
     * @return
     */
    SaleStaffInfoMage checkInfoExist(SaleStaffInfoMage info);
}
