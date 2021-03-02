package com.wisea.cultivar.infomanage.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.po.SendMessagePageListPo;
import com.wisea.cultivar.common.vo.SendMessageInfoVo;
import com.wisea.cultivar.common.vo.SendMessagePageListVo;
import com.wisea.cultivar.infomanage.entity.SendMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SendMessageMapper extends CrudDao<SendMessage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SendMessage
     */
    List<SendMessagePageListVo> findPageList(SendMessagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息SendMessage
     */
    SendMessageInfoVo findInfo(LongIdPo po);
}
