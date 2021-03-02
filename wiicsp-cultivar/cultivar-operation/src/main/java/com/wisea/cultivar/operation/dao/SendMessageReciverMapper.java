package com.wisea.cultivar.operation.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.po.SendMessageReciverPageListPo;
import com.wisea.cultivar.common.vo.memb.MembInfoListForMsgVo;
import com.wisea.cultivar.operation.entity.SendMessageReciver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SendMessageReciverMapper extends CrudDao<SendMessageReciver> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SendMessageReciver
     */
    List<MembInfoListForMsgVo> findPageList(SendMessageReciverPageListPo po);
    @Update("update send_message set del_flag=1 where id=#{id}")
    void batDelete(Long id);
}
