package com.wisea.cultivar.operation.service;

import java.util.List;
import java.util.stream.Collectors;

import com.wisea.cultivar.operation.dao.OperationCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.entity.DiffInfos;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.po.customer.CustomerConfigUserInsertPo;
import com.wisea.cultivar.common.po.customer.OperationCustomerConfigGetVo;
import com.wisea.cultivar.common.po.customer.OperationCustomerSavePo;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigGetVo;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigInsertPo;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigUpdatePo;
import com.wisea.cultivar.common.po.customer.SysImCustomerListDeletePo;
import com.wisea.cultivar.common.po.customer.SysImCustomerListInsertPo;
import com.wisea.cultivar.common.vo.MarketAcctNumMageInfoVo;
import com.wisea.cultivar.operation.customer.service.SysImCustomerConfigService;

@Service
public class OperationCustomerService extends BaseService {
    @Autowired
    private SysImCustomerConfigService sysImCustomerConfigService;
    @Autowired
    private OperationCustomerMapper operationCustomerMapper;

    /**
     * 查询运营平台的客服配置信息
     *
     * @return
     */
    public ResultPoJo<OperationCustomerConfigGetVo> getConfig() {
        ResultPoJo<OperationCustomerConfigGetVo> result = new ResultPoJo<>();
        // 1是固定的系统客服
        SysImCustomerConfigGetVo vo = sysImCustomerConfigService.get(Constants.YES);
        if (null != vo) {
            OperationCustomerConfigGetVo res = new OperationCustomerConfigGetVo();
            ConverterUtil.copyProperties(vo, res);
            res.setCustomerList(getCustomerList());
            result.setResult(res);
        }
        return result;
    }

    /**
     * 查询运营平台客服人员列表
     *
     * @return
     */
    private List<MarketAcctNumMageInfoVo> getCustomerList() {
        return operationCustomerMapper.getCustomerList();
    }

    /**
     * 更新运营平台客服配置信息
     *
     * @param updatePo
     * @return
     */
    public ResultPoJo<Object> save(OperationCustomerSavePo updatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SysImCustomerConfigUpdatePo po = new SysImCustomerConfigUpdatePo();
        ResultPoJo<OperationCustomerConfigGetVo> cofigVo = getConfig();
        // 为空时是新增
        if (null == cofigVo.getResult()) {
            SysImCustomerConfigInsertPo insPo = new SysImCustomerConfigInsertPo();
            // 1是固定的系统客服
            insPo.setGroupId(Constants.YES);
            insPo.setType(Constants.NO);
            // 用户列表
            List<CustomerConfigUserInsertPo> userList = updatePo.getUserIdList().stream().map(u -> new CustomerConfigUserInsertPo(u)).collect(Collectors.toList());
            insPo.setUserList(userList);
            sysImCustomerConfigService.insert(insPo);
        } else {
            // 修改
            ConverterUtil.copyProperties(cofigVo.getResult(), po);
            po.setSerMaxCount(updatePo.getSerMaxCount());
            sysImCustomerConfigService.update(po);

            List<Long> custIdList = cofigVo.getResult().getCustomerList().stream().map(MarketAcctNumMageInfoVo::getId).collect(Collectors.toList());
            // 差分客服用户id列表
            DiffInfos<Long> diffInfos = ConverterUtil.diff(custIdList, updatePo.getUserIdList());
            // 需要删除的
            if (diffInfos.getDeleteList().size() > 0) {
                SysImCustomerListDeletePo delPo = new SysImCustomerListDeletePo();
                delPo.setGroupId(Constants.YES);
                delPo.setUserList(diffInfos.getDeleteList());
                sysImCustomerConfigService.customerListDelete(delPo);
            }
            // 需要新增的
            if (diffInfos.getInsertList().size() > 0) {
                SysImCustomerListInsertPo insPo = new SysImCustomerListInsertPo();
                insPo.setGroupId(Constants.YES);
                // 用户列表
                List<CustomerConfigUserInsertPo> userList = diffInfos.getInsertList().stream().map(u -> new CustomerConfigUserInsertPo(u)).collect(Collectors.toList());
                insPo.setUserList(userList);
                sysImCustomerConfigService.customerListInsert(insPo);
            }
            // 因为平台客服没有管理员不参与这项 就没有更新的
        }
        return result;
    }
}
