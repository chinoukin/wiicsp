package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.ZhfwCommPubInfo;
import com.wisea.cultivar.plant.po.ZhfwCommPubInfoPageListPo;
import com.wisea.cultivar.plant.vo.CommVo;
import com.wisea.cultivar.plant.vo.ZhfwCommPubInfoInfoVo;
import com.wisea.cultivar.plant.vo.ZhfwCommPubInfoPageListVo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ZhfwCommPubInfoMapper extends CrudDao<ZhfwCommPubInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询ZhfwCommPubInfo
     */
    List<ZhfwCommPubInfoPageListVo> findPageList(ZhfwCommPubInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息ZhfwCommPubInfo
     */
    ZhfwCommPubInfoInfoVo findInfo(CommVo po);

    List<ZhfwCommPubInfoPageListVo> findPurchasePageList(ZhfwCommPubInfoPageListPo po);



}
