package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.CommQgPubInfo;
import com.wisea.cultivar.plant.po.CommQgPubInfoPageListPo;
import com.wisea.cultivar.plant.vo.CommQgPubInfoInfoVo;
import com.wisea.cultivar.plant.vo.CommQgPubInfoPageListVo;
import com.wisea.cultivar.plant.vo.CommVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommQgPubInfoMapper extends CrudDao<CommQgPubInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询CommQgPubInfo
     */
    List<CommQgPubInfoPageListVo> findPageList(CommQgPubInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CommQgPubInfo
     */
    CommQgPubInfoInfoVo findInfo(CommVo po);
    /**
     * 根据id ++ 联系数
     * @param id
     */
    void addCommQgPubInfoContactsNum(Long id);
    /**
     * 根据id ++ 浏览数
     * @param id
     */
    void addCommQgPubInfoViews(Long id);

}
