package com.wisea.transac.tp.system.service;

import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.BaseException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.*;
import com.wisea.transac.common.entity.MarketAcctNumMage;
import com.wisea.transac.common.entity.WholeSaleMarketMage;
import com.wisea.transac.common.po.TradAreaMagePo;
import com.wisea.transac.common.po.WholeSaleMarketMagePageListPo;
import com.wisea.transac.common.po.WholeSaleMarketMagePo;
import com.wisea.transac.common.po.system.ListTradAreaPo;
import com.wisea.transac.common.po.system.MarketRankPo;
import com.wisea.transac.common.po.system.StallsMageCount;
import com.wisea.transac.common.po.system.TradAreaMageListPo;
import com.wisea.transac.common.vo.WholeSaleMarketMageInfoVo;
import com.wisea.transac.common.vo.WholeSaleMarketMagePageListVo;
import com.wisea.transac.common.vo.seller.StallsMagePageListVo;
import com.wisea.transac.common.vo.system.MarketRankVo;
import com.wisea.transac.common.vo.system.TradAreaMageListVo;
import com.wisea.transac.tp.system.service.memb.MarketAcctService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className WholeSaleMarketMageService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class WholeSaleMarketMageService extends BaseService {
    @Autowired
    private WholeSaleMarketMageMapper mapper;
    @Autowired
    private TradAreaMageMapper tradAreaMageMapper;
    @Autowired
    private TradAreaCommRelaMageMapper tradAreaCommRelaMageMapper;
    @Autowired
    private MarketAcctService marketAcctService;
    @Autowired
    private TradAreaMageService service;
    @Autowired
    private JedisDao jedisDao;

    @Autowired
    private MarketAcctNumMageMapper marketAcctNumMageMapper;
    @Autowired
    private StallsMageMapper StallsMageMapper;


    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询WholeSaleMarketMage
     */
    public ResultPoJo<Page<WholeSaleMarketMagePageListVo>> findPageList(WholeSaleMarketMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<WholeSaleMarketMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

        Page<WholeSaleMarketMagePageListVo> page = po.getPage();


        List<WholeSaleMarketMagePageListVo> list = mapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除WholeSaleMarketMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        WholeSaleMarketMage entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(WholeSaleMarketMage.DEL_FLAG_DELETE);
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
     * @Description 新增或修改WholeSaleMarketMage
     */
    //@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(WholeSaleMarketMagePo po) {
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            WholeSaleMarketMage entity = mapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(entity)) {
                if (ConverterUtil.isNotEmpty(po.getCoordinatePoint())) {
                    if (!checkCoordinate(po.getCoordinatePoint())) {
                        resultPoJo.setCode(ConstantCodeMsg.ERR_311);
                        resultPoJo.setMsg("不能获取正确定位");
                        return resultPoJo;
                    }
                }
                BeanUtils.copyProperties(po, entity);
                entity.preUpdate();
                mapper.updateByPrimaryKeySelective(entity);
//                //修改用户信息
//                ResultPoJo<String> addUserResult = marketAcctService.addMarketAdminForAddMarket(po.getId(), po.getMarketMageNum(), po.getPassWord());
//                if (addUserResult.getCode().equals(ConstantError.NOMAL)) {
//                    resultPoJo.setResult(entity.getId());
//                } else {
//                    checkRemoteResult(addUserResult);
//                }
            } else {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        } else {
            if (!checkCoordinate(po.getCoordinatePoint())) {
                resultPoJo.setCode(ConstantCodeMsg.ERR_311);
                resultPoJo.setMsg("不能获取正确定位");
                return resultPoJo;
            }
            //新增
            WholeSaleMarketMage entity = new WholeSaleMarketMage();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            mapper.insert(entity);
//            ListTradAreaPo areaPo = new ListTradAreaPo();
//            TradAreaMagePo areaMagePo = new TradAreaMagePo();
//            areaMagePo.setCatgName("交易区");
//            areaMagePo.setIfDisplayType("0");
//            areaMagePo.setpCatgName("交易区");
//            areaMagePo.setSort(10);
//            areaMagePo.setWholeSaleMarketId(entity.getId());
//            areaPo.setTradAreaMagePos(Arrays.asList(areaMagePo));
//            ResultPoJo poJo = service.saveOrUpdate(areaPo);
//            if (!poJo.getCode().equals("000")) {
//                throw new BaseException("999", "初始化交易区失败");
//            }

            //保存用户信息
            ResultPoJo<String> addUserResult = marketAcctService.addMarketAdminForAddMarket(entity.getId(), po.getMarketMageNum(), po.getPassWord());
            if (addUserResult.getCode().equals(ConstantError.NOMAL)) {
                resultPoJo.setResult(entity.getId());
            } else {
                checkRemoteResult(addUserResult);
            }
        }

        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息WholeSaleMarketMage
     */
    public ResultPoJo<WholeSaleMarketMageInfoVo> findInfo(WholeSaleMarketMagePo po, String ifDisplayType) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<WholeSaleMarketMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        WholeSaleMarketMageInfoVo vo;
        if (ConverterUtil.isNotEmpty(po.getWxCoordinate())) {
            vo = mapper.findInfoWithDistance(po);
        } else {
            LongIdPo idPo = new LongIdPo();
            idPo.setId(po.getId());
            vo = mapper.findInfo(idPo);
        }
        //查询管理员
        MarketAcctNumMage marketAcc = marketAcctNumMageMapper.getMarketAcctByMarketId(po.getId());
        if (marketAcc != null) {
            vo.setMarketMageNum(marketAcc.getLoginName());
        }
        if (ConverterUtil.isNotEmpty(vo)) {
            //交易区
            TradAreaMageListPo listPo = new TradAreaMageListPo();
            listPo.setWholeSaleMarketId(po.getId());
            listPo.setIfDisplayType(ifDisplayType);
            List<TradAreaMageListVo> list = tradAreaMageMapper.findList(listPo);
            // TODO 需求变更 交易区和分类 不在关联了
            list.forEach(i -> {
                // 根据交易区查询档口-> 根据档口找到商品
                List<StallsMagePageListVo> stallsMageList = StallsMageMapper.findByTradAreaId(i.getId());
                //查询商品数根据档口id
                if (ConverterUtil.isNotEmpty(stallsMageList)) {
                    List<Long> stallsIds = stallsMageList.stream().map(StallsMagePageListVo::getId).collect(Collectors.toList());
                    StallsMageCount stallsMageCount = new StallsMageCount();
                    stallsMageCount.setStallsMageIds(stallsIds);
                    Long countAllComm = tradAreaMageMapper.stallsMageIdCount(stallsMageCount);
                    i.setCount(countAllComm);
                }
            });
            vo.setTradAreas(list);
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    public ResultPoJo<WholeSaleMarketMageInfoVo> findClosestInfo(WholeSaleMarketMagePo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<WholeSaleMarketMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (!checkCoordinate(po.getWxCoordinate())) {
            resultPoJo.setCode(ConstantCodeMsg.ERR_311);
            resultPoJo.setMsg("不能获取正确定位");
            return resultPoJo;
        }
        WholeSaleMarketMageInfoVo vo;
        vo = mapper.findClosestInfoWithDistance(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            //交易区
            TradAreaMageListPo listPo = new TradAreaMageListPo();
            listPo.setWholeSaleMarketId(vo.getId());
            listPo.setIfDisplayType("0");
            List<TradAreaMageListVo> list = tradAreaMageMapper.findList(listPo);
//            list.forEach(i -> {
//                TradAreaCommRelaMageListPo relaMageListPo = new TradAreaCommRelaMageListPo();
//                relaMageListPo.setTradAreaId(i.getId());
//                relaMageListPo.setIfDisplayType("0");
//                List<TradAreaCommRelaMageListVo> mapperList = tradAreaCommRelaMageMapper.findList(relaMageListPo);
//                i.setComms(mapperList);
//                //查询所有商品总数
//                Long countAllComm = tradAreaCommRelaMageMapper.countAllComm(i.getId());
//                i.setCount(countAllComm);
//
//            });
            vo.setTradAreas(list);
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    public ResultPoJo<List<MarketRankVo>> findMarketRank(MarketRankPo po) {
        po.checkDate();
        po.checkOrder();
        List<MarketRankVo> rank = mapper.findMarketRank(po);
        ResultPoJo<List<MarketRankVo>> result = new ResultPoJo<>();

        result.setResult(rank);

        return result;
    }

    /**
     * 校验坐标格式
     *
     * @param coordinate
     * @return
     */
    private boolean checkCoordinate(String coordinate) {
        String reg = "(-)?\\d*(.\\d*)?,(-)?\\d*(.\\d*)?";
        return ConverterUtil.isNotEmpty(coordinate) && coordinate.matches(reg);
    }
}
