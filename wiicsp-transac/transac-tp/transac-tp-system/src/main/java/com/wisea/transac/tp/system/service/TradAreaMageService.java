package com.wisea.transac.tp.system.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.entity.BaseEntity;
import com.wisea.cloud.common.exception.BaseException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.dao.TradAreaCommRelaMageMapper;
import com.wisea.transac.common.dao.TradAreaMageMapper;
import com.wisea.transac.common.dao.TradAreaPictureMageMapper;
import com.wisea.transac.common.entity.TradAreaCommRelaMage;
import com.wisea.transac.common.entity.TradAreaMage;
import com.wisea.transac.common.entity.TradAreaPictureMage;
import com.wisea.transac.common.po.TradAreaMagePo;
import com.wisea.transac.common.po.system.ListTradAreaPo;
import com.wisea.transac.common.po.system.TradAreaCommRelaMageListPo;
import com.wisea.transac.common.po.system.TradAreaMageListPo;
import com.wisea.transac.common.vo.TradAreaMageInfoVo;
import com.wisea.transac.common.vo.system.TradAreaCommRelaMageListVo;
import com.wisea.transac.common.vo.system.TradAreaMageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className TradAreaMageService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class TradAreaMageService extends BaseService {
    @Autowired
    private TradAreaMageMapper mapper;
    @Autowired
    private TradAreaPictureMageMapper tradAreaPictureMageMapper;
    @Autowired
    private TradAreaCommRelaMageMapper tradAreaCommRelaMageMapper;


    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询TradAreaMage
     */
    public ResultPoJo<List<TradAreaMageListVo>> findPageList(TradAreaMageListPo po, String ifDisplayType) {
        ResultPoJo<List<TradAreaMageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        List<TradAreaMageListVo> list = mapper.findList(po);

        list.forEach(i -> {
            TradAreaCommRelaMageListPo relaMageListPo = new TradAreaCommRelaMageListPo();
            relaMageListPo.setTradAreaId(i.getId());
            relaMageListPo.setIfDisplayType(ifDisplayType);
            List<TradAreaCommRelaMageListVo> mapperList = tradAreaCommRelaMageMapper.findList(relaMageListPo);
            i.setComms(mapperList);
        });

        resultPoJo.setResult(list);
        return resultPoJo;
    }

    public ResultPoJo<Map<String,Object>> findPageListForTree(TradAreaMageListPo po, String ifDisplayType) {
        ResultPoJo<Map<String,Object>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

        Map<String, Object> map = Maps.newHashMap();

        map.put("id", 0);
        map.put("name", "交易区");
        map.put("level", 0);

        List<TradAreaMageListVo> list = mapper.findList(po);

        list.forEach(i -> {
            TradAreaCommRelaMageListPo relaMageListPo = new TradAreaCommRelaMageListPo();
            relaMageListPo.setTradAreaId(i.getId());
            relaMageListPo.setIfDisplayType(ifDisplayType);
            List<TradAreaCommRelaMageListVo> mapperList = tradAreaCommRelaMageMapper.findList(relaMageListPo);
            i.setComms(mapperList);
        });
        map.put("children", list);

        resultPoJo.setResult(map);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除TradAreaMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        TradAreaMage entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(TradAreaMage.DEL_FLAG_DELETE);
            entity.preUpdate();
            mapper.updateByPrimaryKey(entity);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改TradAreaMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(ListTradAreaPo po) {
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //查出以前交易区
        Long wholeSaleMarketId = po.getTradAreaMagePos().get(0).getWholeSaleMarketId();
        TradAreaMageListPo listPo = new TradAreaMageListPo();
        listPo.setWholeSaleMarketId(wholeSaleMarketId);
        List<TradAreaMageListVo> list = mapper.findList(listPo);

        List<Long> tradAreaIds = list.stream().map(TradAreaMageListVo::getId).collect(Collectors.toList());
        List<Long> newIds = po.getTradAreaMagePos().stream().map(TradAreaMagePo::getId).filter(i -> i != null).collect(Collectors.toList());

        if (tradAreaIds.size() != newIds.size()) {
            tradAreaIds.removeAll(newIds);
            int sum = tradAreaIds.stream().mapToInt(mapper::countStallsByTradAreaId)
                    .sum();
            if (sum != 0) {
                resultPoJo.setCode("999");
                resultPoJo.setMsg("交易区已被档口使用，无法删除");
                return resultPoJo;
            }
        }else {
            tradAreaIds.removeAll(newIds);
        }
        long countName = po.getTradAreaMagePos().stream().map(TradAreaMagePo::getCatgName).distinct().count();
        if (countName != po.getTradAreaMagePos().size()) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("交易区名称不能重复");
            return resultPoJo;
        }

        //删除被移除交易区
        tradAreaIds.forEach(i->{
            TradAreaMage mage = new TradAreaMage();
            mage.setId(i);
            mage.setDelFlag(BaseEntity.DEL_FLAG_DELETE);
            mage.preUpdate();
            mapper.updateByPrimaryKeySelective(mage);
        });
        //删除被移除交易区的图片
        tradAreaIds.forEach(i -> tradAreaPictureMageMapper.deleteByAreaId(i));
        //删除被移除交易区的分类
        tradAreaIds.forEach(i -> tradAreaCommRelaMageMapper.deleteByAreaId(i));

        po.getTradAreaMagePos().forEach(i -> {
            if (i.getId() == null) {
                //新增交易区
                TradAreaMage entity = new TradAreaMage();
                BeanUtils.copyProperties(i, entity);
                entity.preInsert();
                mapper.insert(entity);
                //新增图片
                if (i.getPictures() != null) {
                    i.getPictures().forEach(j -> {
                        TradAreaPictureMage pictureMage = new TradAreaPictureMage();
                        ConverterUtil.copyProperties(j, pictureMage);
                        pictureMage.setTradAreaId(entity.getId());
                        pictureMage.preInsert();
                        tradAreaPictureMageMapper.insertSelective(pictureMage);
                    });
                }
                //新增分类
//                if (i.getComms() != null) {
//                    i.getComms().forEach(k -> {
//                        TradAreaCommRelaMage commRelaMage = new TradAreaCommRelaMage();
//                        ConverterUtil.copyProperties(k, commRelaMage);
//                        commRelaMage.setTradAreaId(entity.getId());
//                        commRelaMage.preInsert();
//                        tradAreaCommRelaMageMapper.insertSelective(commRelaMage);
//                    });
//                }
            }else {
                TradAreaMage mage = mapper.selectByPrimaryKey(i.getId());
                if (mage == null) {
                    throw new BaseException("999","添加交易区失败");
                }
                mage.setCatgName(i.getCatgName());
                mage.setpCatgName(i.getpCatgName());
                mage.setIfDisplayType(i.getIfDisplayType());
                mage.setSort(i.getSort());
                mage.setWholeSaleMarketId(i.getWholeSaleMarketId());

                mage.preUpdate();
                mapper.updateByPrimaryKeySelective(mage);

                //删除交易区的图片
                tradAreaPictureMageMapper.deleteByAreaId(i.getId());
                //添加新的图片
                i.getPictures().forEach(j -> {
                    TradAreaPictureMage pictureMage = new TradAreaPictureMage();
                    ConverterUtil.copyProperties(j, pictureMage);
                    pictureMage.setTradAreaId(i.getId());
                    pictureMage.preInsert();
                    tradAreaPictureMageMapper.insertSelective(pictureMage);
                });
                // 删除以前的分类
                // tradAreaCommRelaMageMapper.deleteByAreaId(i.getId());
                //添加新的分类
//                i.getComms().forEach(k -> {
//                    TradAreaCommRelaMage commRelaMage = new TradAreaCommRelaMage();
//                    ConverterUtil.copyProperties(k, commRelaMage);
//                    commRelaMage.setTradAreaId(i.getId());
//                    commRelaMage.preInsert();
//                    tradAreaCommRelaMageMapper.insertSelective(commRelaMage);
//                });


            }
        });
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息TradAreaMage
     */
    public ResultPoJo<TradAreaMageInfoVo> findInfo(LongIdPo po) {
        ResultPoJo<TradAreaMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        TradAreaMage tradAreaMage = mapper.selectByPrimaryKey(po.getId());

        if (ConverterUtil.isNotEmpty(tradAreaMage)) {
            TradAreaMageInfoVo vo = new TradAreaMageInfoVo();
            ConverterUtil.copyProperties(tradAreaMage, vo);

            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

}
