package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.entity.oritrapla.ConsumerQueryRecd;
import com.wisea.cultivar.plant.mapper.oritrapla.ConsumerQueryRecdMapper;
import com.wisea.cultivar.plant.po.oritrapla.ConsumerQueryRecdPo;
import com.wisea.cultivar.plant.utils.OffsetDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Auth： jirg
 * CreateDate:  2018/6/25
 * projectName:  oritrapla
 * remark:  消费者查询记录Service
 */
@Service
public class ConsumerQueryRecdService extends BaseService {
    @Autowired
    private ConsumerQueryRecdMapper mapper;

    /**
     * 保存消费者查询记录
     * @param queryRecd
     */
    @Transactional(readOnly = false)
    public void save(ConsumerQueryRecd queryRecd) {
        queryRecd.preInsert();
        mapper.insert(queryRecd);
    }

    /**
     * 查询消费者查询列表
     * @param po
     * @return
     */
    public ResultPoJo<Page<ConsumerQueryRecd>> findQueryRecdList(ConsumerQueryRecdPo po) {
        ResultPoJo<Page<ConsumerQueryRecd>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        Page<ConsumerQueryRecd> page = po.getPage();
        User user = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
            result.setCode(ConstantCodeMsg.ERR_702);
            result.setMsg(ConstantCodeMsg.MSG_702);
            return result;
        }

        po.setQueryDateStart(OffsetDateTimeUtils.getDayMinTime(po.getQueryDateStart()));
        po.setQueryDateEnd(OffsetDateTimeUtils.getDayMaxTime(po.getQueryDateEnd()));

        List<ConsumerQueryRecd> queryRecdList = mapper.findQueryRecdList(po);
        page.setList(queryRecdList);
        result.setResult(page);
        return result;
    }
}
