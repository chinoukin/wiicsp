package com.wisea.transac.seller.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.PortMageMapper;
import com.wisea.transac.common.entity.PortMage;
import com.wisea.transac.common.po.PortMagePagePo;
import com.wisea.transac.common.po.PortMagePo;
import com.wisea.transac.common.vo.PortMageListVo;
import com.wisea.transac.common.vo.PortMageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangjiahao
 * @since 2020/7/1 2:13 下午
 */
@Service
public class PortMageService {

    @Autowired
    private PortMageMapper portMageMapper;


    /**
     * 查询详情
     * @param po
     * @return
     */
    public ResultPoJo<PortMageVo> findById(LongIdPo po) {
        PortMageVo vo = portMageMapper.findById(po.getId());
        ResultPoJo<PortMageVo> result = new ResultPoJo<>();
        result.setResult(vo);
        return result;
    }

    /**
     * 分页查询
     * @param po
     * @return
     */
    public ResultPoJo<Page<PortMageVo>> findForPage(PortMagePagePo po) {
        ResultPoJo<Page<PortMageVo>> result = new ResultPoJo<>();

        Page<PortMageVo> page = po.getPage();
        List<PortMageVo> list = portMageMapper.findForPages(po);

        page.setList(list);
        result.setResult(page);

        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(PortMagePo po) {
        ResultPoJo result = new ResultPoJo();
        //新增
        if (ConverterUtil.isEmpty(po.getId())) {
            PortMage mage = new PortMage();
            ConverterUtil.copyProperties(po,mage);
            mage.preInsert();
            portMageMapper.insertSelective(mage);
        }else {
            PortMage mage = portMageMapper.selectByPrimaryKey(po.getId());
            if (mage == null) {
                result.setCode(ConstantCodeMsg.ERR_711);
                result.setMsg(ConstantCodeMsg.MSG_711);
            }else {
                ConverterUtil.copyProperties(po,mage);
                mage.preUpdate();
                portMageMapper.updateByPrimaryKeySelective(mage);
            }
        }

        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo delete(LongIdPo po) {
        ResultPoJo result = new ResultPoJo();
        PortMage mage = portMageMapper.selectByPrimaryKey(po.getId());
        if (mage == null) {
            result.setCode(ConstantCodeMsg.ERR_711);
            result.setMsg(ConstantCodeMsg.MSG_711);
            return result;
        }
        mage.setDelFlag(DictConstants.DEL_FLAG_1);
        mage.preUpdate();
        portMageMapper.updateByPrimaryKeySelective(mage);
        return result;
    }

    public ResultPoJo<List<PortMageListVo>> findAllList() {
        ResultPoJo<List<PortMageListVo>> resultPoJo = new ResultPoJo<>();
        List<PortMageVo> all = portMageMapper.findAll();

        Map<String, List<PortMageVo>> map = all.stream()
                .peek(i->{
                    i.setLabel(i.getPortName());
                    i.setValue(i.getId().toString());
                })
                .collect(Collectors.groupingBy(PortMageVo::getAreaProv));
        List<PortMageListVo> result = map.entrySet().stream().map(i -> {
            PortMageListVo vo = new PortMageListVo();
            vo.setProv(i.getKey());
            vo.setLabel(i.getValue().get(0).getAreaProvName());
            vo.setValue(i.getKey());
            vo.setProvName(i.getValue().get(0).getAreaProvName());
            vo.setChildren(i.getValue());
            return vo;
        }).collect(Collectors.toList());

        resultPoJo.setResult(result);

        return resultPoJo;
    }
}
