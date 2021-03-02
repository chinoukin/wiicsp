package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.SysArea;
import com.wisea.cultivar.plant.po.SysAreaPageListPo;
import com.wisea.cultivar.plant.vo.AreaSSQVo;
import com.wisea.cultivar.plant.vo.SysAreaInfoVo;
import com.wisea.cultivar.plant.vo.SysAreaPageListVo;
import com.wisea.cultivar.plant.vo.ZhfwMembInfoInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysAreaMapper extends CrudDao<SysArea> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/19 17:24:52
     * @Description 分页查询SysArea
     */
    List<SysAreaPageListVo> findPageList(SysAreaPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/19 17:24:52
     * @Description 查询详细信息SysArea
     */
    SysAreaInfoVo findInfo(LongIdPo po);

    //通过地区编码获取地区名称
    AreaSSQVo findSSQ(ZhfwMembInfoInfoVo zhfwMembInfoInfoVo);
}
