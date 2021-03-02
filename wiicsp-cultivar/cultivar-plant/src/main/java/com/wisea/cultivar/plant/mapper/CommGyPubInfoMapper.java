package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.CommGyPubInfo;
import com.wisea.cultivar.plant.po.CommGyPubInfoPageListPo;
import com.wisea.cultivar.plant.vo.CommGyPubInfoInfoVo;
import com.wisea.cultivar.plant.vo.CommGyPubInfoPageListVo;
import com.wisea.cultivar.plant.vo.CommVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommGyPubInfoMapper extends CrudDao<CommGyPubInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询CommGyPubInfo
     */
    List<CommGyPubInfoPageListVo> findPageList(CommGyPubInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CommGyPubInfo
     */
    CommGyPubInfoInfoVo findInfo(CommVo po);
    /**
     * 根据id ++ 联系数
     * @param id
     */
    void addCommGyPubInfoContactsNum(Long id);
    /**
     * 根据id ++ 浏览数
     * @param id
     */
    void addCommGyPubInfoViews(Long id);

}
