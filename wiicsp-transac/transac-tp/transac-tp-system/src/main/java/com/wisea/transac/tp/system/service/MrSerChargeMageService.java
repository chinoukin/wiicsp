package com.wisea.transac.tp.system.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.entity.MrSerChargeMage;
import com.wisea.transac.common.po.system.MrSerChargeMagePo;
import com.wisea.transac.common.po.system.MrSerChargeMageGetPo;
import com.wisea.transac.common.po.system.MrSerChargeMagePagePo;
import com.wisea.transac.common.po.system.MrSerChargeStatePo;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.system.MrSerChargeMageGetVo;
import com.wisea.transac.common.vo.system.MrSerChargeMageListVo;
import com.wisea.transac.common.dao.MrSerChargeMageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 默认服务费的业务层
 * @author: wangs
 * @date :2019/5/15
 */
@Service
@Transactional(readOnly = true)
public class MrSerChargeMageService extends BaseService {

    @Autowired
    MrSerChargeMageMapper mrSerChargeMageMapper;

    /**
     * 查询默认服务费
     * @param mrSerChargeMagePagePo
     * @return
     */
    public ResultPoJo<PageStateCountResultVo<MrSerChargeMageListVo>> list(MrSerChargeMagePagePo mrSerChargeMagePagePo) {
        ResultPoJo<PageStateCountResultVo<MrSerChargeMageListVo>> PoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        Page<MrSerChargeMageListVo> page = mrSerChargeMagePagePo.getPage();

        List<MrSerChargeMageListVo> infoListVo = mrSerChargeMageMapper.findSerChargeList(mrSerChargeMagePagePo);
        page.setList(infoListVo);
        PageStateCountResultVo<MrSerChargeMageListVo> vo = new PageStateCountResultVo();
        vo.setPage(page);
        PoJo.setResult(vo);

        return PoJo;
    }

    /**
     * 新增修改默认服务费
     *
     * @param mrSerChargeMagePo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> saveOrUpdate(MrSerChargeMagePo mrSerChargeMagePo) {
        ResultPoJo<String> poJo = new ResultPoJo(ConstantCodeMsg.NOMAL);
        LoggerUtil.infoWithContext("默认手续费信息", mrSerChargeMagePo);

        MrSerChargeMage mrSerChargeMage = new MrSerChargeMage();
        ConverterUtil.copyProperties(mrSerChargeMagePo, mrSerChargeMage);
        MrSerChargeMage checkMrSerChargeMage = mrSerChargeMageMapper.checkSaveOrUpdateMrSerChargeMage(mrSerChargeMage);
        if (ConverterUtil.isEmpty(checkMrSerChargeMage)) {
            if (ConverterUtil.isNotEmpty(mrSerChargeMagePo.getId())) {
                // 修改操作
                mrSerChargeMage.preUpdate();
                mrSerChargeMageMapper.updateByPrimaryKeySelective(mrSerChargeMage);
            } else {
                // 新增
                mrSerChargeMage.preInsert();
                mrSerChargeMageMapper.insertSelective(mrSerChargeMage);
            }
        } else {
            poJo.setCode(ConstantCodeMsg.ERR_356);
            poJo.setMsg(ConstantCodeMsg.MSG_356);
        }

        return poJo;
    }

    /**
     * 查询详情
     *
     * @param mrSerChargeMageGetPo
     * @return
     */
    public ResultPoJo<MrSerChargeMageGetVo> get(MrSerChargeMageGetPo mrSerChargeMageGetPo) {

        ResultPoJo<MrSerChargeMageGetVo> poJo = new ResultPoJo<>();

        MrSerChargeMageGetVo infoVo = mrSerChargeMageMapper.findById(mrSerChargeMageGetPo);

        poJo.setResult(infoVo);
        return poJo;
    }

    /**
     * 删除默认手续费信息
     *
     * @param mrSerChargeStatePo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo changeState(MrSerChargeStatePo mrSerChargeStatePo) {

        ResultPoJo PoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        MrSerChargeMage mrSerChargeMage = new MrSerChargeMage();
        mrSerChargeMage.setId(mrSerChargeStatePo.getId());
        mrSerChargeMage.preUpdate();

        // 删除
        mrSerChargeMage.setDelFlag("1");
        mrSerChargeMageMapper.updateByPrimaryKeySelective(mrSerChargeMage);

        return PoJo;
    }

}
