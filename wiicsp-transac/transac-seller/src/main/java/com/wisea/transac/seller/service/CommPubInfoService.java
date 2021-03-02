package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.dao.CommPubInfoMapper;
import com.wisea.transac.common.po.CommPubInfoPageListPo;
import com.wisea.transac.common.po.seller.StallsIdAndCommVarietIdPo;
import com.wisea.transac.common.vo.CommMagePageListVo;
import com.wisea.transac.common.vo.CommPubInfoInfoVo;
import com.wisea.transac.common.vo.CommPubInfoPageListVo;
import com.wisea.transac.common.vo.product.CommVarietMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className CommPubInfoService
 * @date 2020/04/27 17:01:28
 * @Description
 */
@Service
public class CommPubInfoService extends BaseService {
    @Autowired
    private CommPubInfoMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询CommPubInfo
     */
    public ResultPoJo<Page<CommPubInfoPageListVo>> findPageList(CommPubInfoPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<CommPubInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<CommPubInfoPageListVo> page = po.getPage();
        List<CommPubInfoPageListVo> list = mapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }


    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息CommPubInfo
     */
    public ResultPoJo<CommPubInfoInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<CommPubInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        CommPubInfoInfoVo vo = mapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 查询档口所有可用的品类
     *
     * @param stallsMageId
     *
     * @return
     */
    public ResultPoJo<List<CommVarietMageListVo>> findCommVariet(Long stallsMageId) {
        List<CommVarietMageListVo> commVariet = mapper.findCommVariet(stallsMageId);
        ResultPoJo<List<CommVarietMageListVo>> result = new ResultPoJo<>();
        result.setResult(commVariet);
        return result;
    }

    /**
     * 根据品类ID和档口ID查询所有可用品种
     *
     * @return
     */
    public ResultPoJo<List<CommMagePageListVo>> findComm(StallsIdAndCommVarietIdPo po) {
        List<CommMagePageListVo> comm = mapper.findComm(po);
        ResultPoJo<List<CommMagePageListVo>> result = new ResultPoJo<>();
        result.setResult(comm);
        return result;
    }

}
