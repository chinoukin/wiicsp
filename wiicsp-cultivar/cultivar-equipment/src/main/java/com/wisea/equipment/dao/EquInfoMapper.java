package com.wisea.equipment.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.equipment.entity.EquInfo;
import com.wisea.equipment.po.EquInfoListPo;
import com.wisea.equipment.po.EquInfoPo;
import com.wisea.equipment.vo.EquInfoListVo;
import com.wisea.equipment.vo.EquInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EquInfoMapper extends CrudDao<EquInfo> {
    /**
     * @author jirg
     * @date 2020/7/7 10:45
     * @Description 分页查询设备列表
     */
    List<EquInfoListVo> findPageList(EquInfoListPo po);

    /**
     * @author jirg
     * @date 2020/7/7 10:45
     * @Description 根据设备编号查询设备
     */
    EquInfo selectByEquNum(EquInfoPo po);

    /**
     * @author jirg
     * @date 2020/7/7 10:54
     * @Description 查询设备详细信息
     */
    EquInfoVo findInfo(LongIdPo po);

    /**
     * @author jirg
     * @date 2020/7/9 14:26
     * @Description 根据设备厂商和编号查询设备
     */
    EquInfo findByEntpIdAndNum(@Param("equEntpId") Long equEntpId, @Param("equNum") String equNum);

    /**
     * 根据设备厂商和编号查询设备详细信息
     */
    EquInfoVo findInfoByEntpIdAndNum(@Param("equEntpName") String equEntpName, @Param("equNum") String equNum);
}