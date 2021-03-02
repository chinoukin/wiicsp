package com.wisea.transac.common.dao;


import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;

import com.wisea.transac.common.entity.ReceAddress;
import com.wisea.transac.common.po.ReceAddressPageListPo;
import com.wisea.transac.common.vo.ReceAddressInfoVo;
import com.wisea.transac.common.vo.ReceAddressPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReceAddressMapper extends CrudDao<ReceAddress> {
    /**
     * @author wbf-code-generator
     * @date 2020/12/02 13:57:00
     * @Description 分页查询ReceAddress
     */
    List<ReceAddressPageListVo> findPageList(ReceAddressPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/12/02 13:57:00
     * @Description 查询详细信息ReceAddress
     */
    ReceAddressInfoVo findInfo(Long id);

    /**
     * 买家查看默认地址
     * @return
     */
    ReceAddressInfoVo buyerFindDefault();

    /**
     * 查找默认地址
     * @return
     */
    ReceAddress findByDefault();
}
