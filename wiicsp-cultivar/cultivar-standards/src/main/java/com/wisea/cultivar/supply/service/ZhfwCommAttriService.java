package com.wisea.cultivar.supply.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.entity.CommMage;
import com.wisea.cultivar.common.entity.ZhfwCommAttri;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.supply.mapper.ZhfwCommAttriMapper;
import com.wisea.cultivar.supply.mapper.ZhfwCommPubInfoMapper;
import com.wisea.cultivar.supply.po.CommAttriPo;
import com.wisea.cultivar.supply.po.CommoditySavePo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 商品属性值
 * @author chengq
 * @date 2020/8/13 18:22
 */
@Service
public class ZhfwCommAttriService {

    @Resource
    private ZhfwCommAttriMapper zhfwCommAttriMapper;
    @Resource
    private ZhfwCommPubInfoMapper zhfwCommPubInfoMapper;

    /**
     * 保存商品属性
     */
    @Transactional
    public void saveCommAttri(CommoditySavePo commoditySavePo) {
        //删除原商品属性
        zhfwCommAttriMapper.deleteByCommPubId(commoditySavePo.getId());
        commoditySavePo.getAttris().forEach(attr -> {
            //查询商品属性
            ZhfwCommAttri zhfwCommAttri = findAttri(attr.getAttriId(), commoditySavePo.getCommId());
            if (Objects.isNull(zhfwCommAttri)) {
                throw new VerifyException(QdcyStandardsError.ERR_10005, QdcyStandardsError.MSG_10005);
            }
            zhfwCommAttri.setCommPubId(commoditySavePo.getId());
            zhfwCommAttri.setCommAttriVal(attr.getAttriVal());
            //保存商品属性
            zhfwCommAttri.preInsert();
            zhfwCommAttriMapper.insert(zhfwCommAttri);
        });
    }

    /**
     * 递归查询属性
     */
    private ZhfwCommAttri findAttri(Long attriId, Long commId) {
        ZhfwCommAttri zhfwCommAttri = zhfwCommAttriMapper.selectByAttriId(attriId, commId);
        if (Objects.isNull(zhfwCommAttri)) {
            CommMage commMage = zhfwCommPubInfoMapper.selectAttriById(commId);
            if (Objects.nonNull(commMage)) {
                return findAttri(attriId, commMage.getPid());
            }
        }
        return zhfwCommAttri;
    }

    /**
     * 通过商品id查询属性
     * @param commPubId 商品id
     */
    public List<ZhfwCommAttri> findByCommPubId(Long commPubId) {
        List<ZhfwCommAttri> commAttris = zhfwCommAttriMapper.findByCommPubId(commPubId);
        return ConverterUtil.isNotEmpty(commAttris) ? commAttris : Lists.newArrayList();
    }

    /**
     * 给商品详情设置商品属性
     * @param commPubId 商品详情
     */
    public String findCommAttri(Long commPubId) {
        //设置属性
        List<ZhfwCommAttri> commAttris = findByCommPubId(commPubId);
        return commAttris.stream().map(ZhfwCommAttri::getCommAttriVal).collect(Collectors.joining(" "));
    }

    /**
     * 给商品详情设置商品属性
     * @param commPubId 商品详情
     */
    public List<CommAttriPo> findCommAttriPo(Long commPubId) {
        //设置属性id
        List<ZhfwCommAttri> commAttris = findByCommPubId(commPubId);
        return commAttris.stream().map(attr -> {
            CommAttriPo commAttriPo = new CommAttriPo();
            commAttriPo.setAttriId(attr.getCommAttriId());
            commAttriPo.setCommAttriName(attr.getCommAttriName());
            commAttriPo.setAttriVal(attr.getCommAttriVal());
            return commAttriPo;
        }).collect(Collectors.toList());

    }

    /**
     * 通过商品和用户商品查询
     */
    public ZhfwCommAttri findByCommPubIdAndAttriId(Long pubId, Long attriId) {
        return zhfwCommAttriMapper.findByCommPubIdAndAttriId(pubId,attriId);
    }
}
