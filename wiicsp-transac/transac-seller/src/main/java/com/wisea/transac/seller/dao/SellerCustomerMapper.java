package com.wisea.transac.seller.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wisea.transac.common.po.customer.SaleStaffInfoMageCustomerInfoVo;

public interface SellerCustomerMapper {
    /**
     * 查询店铺客服人员列表
     *
     * @param groupId
     * @param userId
     * @return
     */
    @Select("SELECT DISTINCT " +
            "    stim.sale_staff_id, " +
            "    stim.staff_name, " +
            "    stim.sf_admin_flag, " +
            "    mi.regist_tel, " +
            "IF ( " +
            "    ISNULL(sic.id), " +
            "    '0', " +
            "    '1' " +
            ") is_customer " +
            "FROM " +
            "    sale_staff_info_mage stim " +
            "LEFT JOIN sys_im_customer sic ON ( " +
            "    sic.user_id = stim.sale_staff_id " +
            "    AND sic.group_id = #{0} AND sic.del_flag = '0' " +
            ") " +
            "LEFT JOIN memb_info mi ON (mi.id = stim.sale_staff_id AND mi.del_flag = '0') " +
            "WHERE " +
            "    stim.del_flag = '0' " +
            "and stim.memb_id = #{0} " +
            "ORDER BY stim.create_date")
    public List<SaleStaffInfoMageCustomerInfoVo> getShopCustomerList(String groupId);

    /**
     * 查询档口客服人员列表
     *
     * @param groupId
     * @param userId
     * @return
     */
    @Select("SELECT DISTINCT " +
            "    stim.sale_staff_id, " +
            "    stim.staff_name, " +
            "    stim.sf_admin_flag, " +
            "    mi.regist_tel, " +
            "IF ( " +
            "    ISNULL(sic.id), " +
            "    '0', " +
            "    '1' " +
            ") is_customer " +
            "FROM " +
            "    sale_staff_info_mage stim " +
            "join stalls_staff_rela_mage ssrm on (ssrm.staff_info_mage_id = stim.id) " +
            "LEFT JOIN sys_im_customer sic ON ( " +
            "    sic.user_id = stim.sale_staff_id " +
            "    AND sic.group_id = #{0} AND sic.del_flag = '0' " +
            ") " +
            "LEFT JOIN memb_info mi ON (mi.id = stim.sale_staff_id AND mi.del_flag = '0') " +
            "WHERE " +
            "    stim.del_flag = '0' " +
            "and stim.memb_id = #{0} " +
            "ORDER BY stim.create_date")
    public List<SaleStaffInfoMageCustomerInfoVo> getStallCustomerList(String groupId);
}
