package com.wisea.transac.operation.dao;

import java.util.List;

import com.wisea.transac.operation.entity.SendMessageReciver;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.po.SendMessageReciverPageListPo;
import com.wisea.transac.common.vo.memb.MembInfoListForMsgVo;

@Mapper
@Repository
public interface SendMessageReciverMapper extends CrudDao<SendMessageReciver> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SendMessageReciver
     */
    List<MembInfoListForMsgVo> findPageList(SendMessageReciverPageListPo po);
}
