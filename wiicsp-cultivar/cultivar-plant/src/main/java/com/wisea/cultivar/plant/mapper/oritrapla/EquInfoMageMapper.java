package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.EquInfoMage;
import com.wisea.cultivar.plant.po.oritrapla.EquInfoMageMonitorPo;
import com.wisea.cultivar.plant.po.oritrapla.EquInfoMagePo;
import com.wisea.cultivar.plant.vo.oritrapla.ArchBasicInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.EquInfoMageMonitorVo;
import com.wisea.cultivar.plant.vo.oritrapla.EquInfoMageVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EquInfoMageMapper extends CrudDao<EquInfoMage> {
    /**
     * @Author jirg
     * @Date 2019/2/25 10:01
     * @Description 分页查询设备信息列表
     **/
    List<EquInfoMageVo> findPageList(EquInfoMagePo po);

    /**
     * @Author jirg
     * @Date 2019/2/25 17:43
     * @Description 查询设备监控列表
     **/
    List<EquInfoMageMonitorVo> findPageEquInfoMageMonitor(EquInfoMageMonitorPo po);


    /**
     * 按设备编号查询设备
     *
     * @param equNum
     * @return
     */
    EquInfoMageVo findByEquipNum(String equNum);

    /**
     * 根据设备号查询档案ID
     *
     * @param equId
     * @return
     */
    List<Long> findArchIdByEquId(Long equId);

    /**
     * 按设备ID查询所有未过期档案
     *
     * @param equId
     * @return
     */
    List<ArchBasicInfoVo> findArchByEquId(Long equId);

    /**
     * 按档案Id查询设备
     *
     * @param archId
     * @return
     */
    List<EquInfoMage> findEquByArchId(Long archId);
}
