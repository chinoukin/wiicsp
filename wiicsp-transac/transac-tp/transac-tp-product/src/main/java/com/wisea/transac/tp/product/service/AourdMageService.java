package com.wisea.transac.tp.product.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.PlaceOriginMageMapper;
import com.wisea.transac.common.entity.PlaceOriginMage;
import com.wisea.transac.common.po.product.AbroadMageInsertPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @author: wangs
 * @date :2019/4/25
 */
@Service
@Transactional(readOnly = true)
public class AourdMageService {

    @Autowired
    PlaceOriginMageMapper placeOriginMageMapper;

    /**
     * 查询国外产地列表信息
     *
     * @param abroadMage
     * @return
     */
    public ResultPoJo<List<PlaceOriginMage>> findList(PlaceOriginMage abroadMage) {

        ResultPoJo<List<PlaceOriginMage>> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        List<PlaceOriginMage> list = placeOriginMageMapper.findList(abroadMage);

        poJo.setResult(list);
        return poJo;
    }

    /**
     * 删除国外产地列表
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo<?> del(LongIdPo po) {

        ResultPoJo<PlaceOriginMage> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        PlaceOriginMage abroadMage = new PlaceOriginMage();
        abroadMage.setId(po.getId());
        abroadMage.preUpdate();
        abroadMage.setDelFlag("1");
        placeOriginMageMapper.updateByPrimaryKeySelective(abroadMage);
        return poJo;
    }

    /**
     * 查询国外产地详情
     *
     * @param po
     * @return
     */
    public ResultPoJo<PlaceOriginMage> findAourdMageInfo(LongIdPo po) {

        ResultPoJo<PlaceOriginMage> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        PlaceOriginMage abroadMage = placeOriginMageMapper.selectByPrimaryKey(po.getId());
        poJo.setResult(abroadMage);
        return poJo;
    }

    /**
     * 保存或修改
     *
     * @param abroadMageInsertPo
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo<?> saveOrUpdate(AbroadMageInsertPo abroadMageInsertPo) {

        ResultPoJo<?> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        PlaceOriginMage abroadMage = new PlaceOriginMage();
        BeanUtils.copyProperties(abroadMageInsertPo, abroadMage);

        if (ConverterUtil.isNotEmpty(abroadMage.getId())) {
            abroadMage.preUpdate();
            placeOriginMageMapper.updateByPrimaryKeySelective(abroadMage);
        } else {
            abroadMage.preInsert();
            placeOriginMageMapper.insertSelective(abroadMage);
        }
        return poJo;
    }
}
