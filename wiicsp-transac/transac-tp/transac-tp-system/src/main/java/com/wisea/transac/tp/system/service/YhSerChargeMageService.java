package com.wisea.transac.tp.system.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.entity.YhSerChargeMage;
import com.wisea.transac.common.po.system.YhSerChargeMageGetPo;
import com.wisea.transac.common.po.system.YhSerChargeMagePagePo;
import com.wisea.transac.common.po.system.YhSerChargeMagePo;
import com.wisea.transac.common.po.system.YhSerChargeStatePo;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.system.YhSerChargeMageGetVo;
import com.wisea.transac.common.vo.system.YhSerChargeMageListVo;
import com.wisea.transac.common.dao.YhSerChargeMageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 优惠服务费业务层
 * @author: wangs
 * @date :2019/5/16
 */
@Service
@Transactional(readOnly = true)
public class YhSerChargeMageService extends BaseService {

    @Autowired
    YhSerChargeMageMapper yhSerChargeMageMapper;

    /**
     * 查询优惠服务费列表
     *
     * @param yhSerChargeMagePagePo
     * @return
     */
    public ResultPoJo<PageStateCountResultVo<YhSerChargeMageListVo>> list(YhSerChargeMagePagePo yhSerChargeMagePagePo) {
        ResultPoJo<PageStateCountResultVo<YhSerChargeMageListVo>> PoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        Page<YhSerChargeMageListVo> page = yhSerChargeMagePagePo.getPage();

        List<YhSerChargeMageListVo> infoListVo = yhSerChargeMageMapper.findYhSerChargeList(yhSerChargeMagePagePo);
        page.setList(infoListVo);
        PageStateCountResultVo<YhSerChargeMageListVo> vo = new PageStateCountResultVo();
        vo.setPage(page);
        PoJo.setResult(vo);

        return PoJo;
    }


    /**
     * 优惠手续费的新增和修改
     *
     * @param yhSerChargeMagePo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> saveOrUpdate(YhSerChargeMagePo yhSerChargeMagePo) {

        ResultPoJo<String> poJo = new ResultPoJo(ConstantCodeMsg.NOMAL);
        LoggerUtil.infoWithContext("优惠手续费信息", yhSerChargeMagePo);
        YhSerChargeMage yhSerChargeMage = new YhSerChargeMage();

        ConverterUtil.copyProperties(yhSerChargeMagePo, yhSerChargeMage);
        if (ConverterUtil.isNotEmpty(yhSerChargeMagePo.getId())) {
            YhSerChargeMage checkYhSerChargeMage = yhSerChargeMageMapper.checkSaveOrUpdateYhSerChargeMage(yhSerChargeMage);
            if (ConverterUtil.isEmpty(checkYhSerChargeMage)) {
                // 修改操作
                yhSerChargeMage.preUpdate();
                yhSerChargeMageMapper.updateByPrimaryKeySelective(yhSerChargeMage);
            } else {
                poJo.setCode(ConstantCodeMsg.ERR_355);
                poJo.setMsg(ConstantCodeMsg.MSG_355);
            }
        } else {
            YhSerChargeMage checkYhSerChargeMage = yhSerChargeMageMapper.checkSaveOrUpdateYhSerChargeMage(yhSerChargeMage);
            if (ConverterUtil.isEmpty(checkYhSerChargeMage)) {

                // 新增
                yhSerChargeMage.preInsert();
                yhSerChargeMageMapper.insertSelective(yhSerChargeMage);
            } else {
                poJo.setCode(ConstantCodeMsg.ERR_355);
                poJo.setMsg(ConstantCodeMsg.MSG_355);
            }
        }

        return poJo;
    }

    /**
     * 查询详情
     *
     * @param yhSerChargeMageGetPo
     * @return
     */
    public ResultPoJo<YhSerChargeMageGetVo> get(YhSerChargeMageGetPo yhSerChargeMageGetPo) {

        ResultPoJo<YhSerChargeMageGetVo> poJo = new ResultPoJo<>();

        YhSerChargeMageGetVo infoVo = yhSerChargeMageMapper.findById(yhSerChargeMageGetPo);
        poJo.setResult(infoVo);
        return poJo;
    }

    /**
     * 改变优惠手续费记录
     *
     * @param yhSerChargeStatePo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo changeState(YhSerChargeStatePo yhSerChargeStatePo) {

        ResultPoJo PoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        YhSerChargeMage yhSerChargeMage = new YhSerChargeMage();
        yhSerChargeMage.setId(yhSerChargeStatePo.getId());
        yhSerChargeMage.preUpdate();

        // 删除
        yhSerChargeMage.setDelFlag("1");
        yhSerChargeMageMapper.updateByPrimaryKeySelective(yhSerChargeMage);

        return PoJo;
    }
}
