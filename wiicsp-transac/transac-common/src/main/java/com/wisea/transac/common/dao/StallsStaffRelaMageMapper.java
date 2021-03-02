package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.StallsStaffRelaMage;
import com.wisea.transac.common.po.SaleStaffInfoMagePageListPo;
import com.wisea.transac.common.po.SaleStaffInfoMagePo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMagePageListVo;
import com.wisea.transac.common.vo.seller.StallsStaffRelaMageInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StallsStaffRelaMageMapper extends CrudDao<StallsStaffRelaMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询StallsStaffRelaMage
     */
    List<SaleStaffInfoMagePageListVo> findPageList(SaleStaffInfoMagePageListPo po);

    /**
     * 根据档口id查询所有员工
     * @param po
     * @return
     */
    List<SaleStaffInfoMagePageListVo> findAll(SaleStaffInfoMagePo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息StallsStaffRelaMage
     */
    StallsStaffRelaMageInfoVo findInfo(LongIdPo po);

    StallsStaffRelaMageInfoVo findInfoByStaffIdAndStallId(StallsStaffRelaMage po);
    /**
     * @Author jirg
     * @Date 2020/5/7 16:45
     * @Description 根据员工ID查询员工档口关联列表
     **/
    List<StallsStaffRelaMage> findByStaffInfoMageId(@Param("staffInfoMageId") Long id);

    /**
     * 修改关联根据员工ID
     * @param rela
     */
    void updateBystaffInfoMageId(StallsStaffRelaMage rela);
}
