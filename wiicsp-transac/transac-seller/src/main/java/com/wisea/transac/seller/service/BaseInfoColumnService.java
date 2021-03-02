package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.entity.BaseInfo;
import com.wisea.transac.common.po.seller.FindBaseInfoPo;
import com.wisea.transac.common.po.seller.FindSupPieceListPo;
import com.wisea.transac.common.po.seller.RecBaseInfoPo;
import com.wisea.transac.common.vo.FindSupPieceListVo;
import com.wisea.transac.common.vo.seller.BaseCertMageVo;
import com.wisea.transac.common.vo.seller.FindBaseInfoVo;
import com.wisea.transac.common.vo.seller.ProcurDynamicVo;
import com.wisea.transac.common.vo.seller.RecBaseInfoVo;
import com.wisea.transac.common.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseInfoColumnService extends BaseService {

    @Autowired
    private SupPieceInfoMapper supPieceInfoMapper;
    @Autowired
    private BaseInfoMapper baseInfoMapper;
    @Autowired
    private BaseCertMageMapper baseCertMageMapper;
    @Autowired
    private LocalityOrderInfoMapper localityOrderInfoMapper;
    @Autowired
    private LocalityOrdCommRelaMapper localityOrdCommRelaMapper;


    /**
     * 根据基地ID查询优势单品列表
     * @param po
     * @return
     */
    public ResultPoJo<Page<FindSupPieceListVo>> findSupPieceInfoList(FindSupPieceListPo po) {
        LoggerUtil.infoWithContext("【findSupPieceInfoList】根据基地ID查询优势单品列表", po);
        ResultPoJo<Page<FindSupPieceListVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        Page<FindSupPieceListVo> page = po.getPage();
        List<FindSupPieceListVo> list = supPieceInfoMapper.findSupPieceInfoList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 基地详情
     * @param po
     * @return
     */
    public ResultPoJo<FindBaseInfoVo> findBaseInfo(FindBaseInfoPo po) {
        LoggerUtil.infoWithContext("【findBaseInfo】基地详情", po);
        ResultPoJo<FindBaseInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //基地基础信息
        FindBaseInfoVo vo = baseInfoMapper.findByid(po);
        if (ConverterUtil.isEmpty(vo)){
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
            return resultPoJo;
        }
        //证书
        LongIdPo longIdPo = new LongIdPo();
        longIdPo.setId(po.getBaseId());
        List<BaseCertMageVo> baseCertList = baseCertMageMapper.findListByBaseId(longIdPo);
        if (ConverterUtil.isNotEmpty(baseCertList)){
            vo.setBaseCertMageVo(baseCertList);
        }
        //国外产地没有推荐
        BaseInfo  baseInfo= baseInfoMapper.selectByPrimaryKey(po.getBaseId());
        if(ConverterUtil.isEmpty(baseInfo.getAbroadId())){
                //推荐基地
                RecBaseInfoPo recBaseInfoPo = new RecBaseInfoPo();
                recBaseInfoPo.setId(vo.getId());
                recBaseInfoPo.setJd(vo.getJd());
                recBaseInfoPo.setWd(vo.getWd());
                List<RecBaseInfoVo> recBaseList  =  baseInfoMapper.findRecBaseByid(recBaseInfoPo);
                if (ConverterUtil.isNotEmpty(recBaseList)){
                    vo.setRecBaseList(recBaseList);
                }
        }
        //采购动态
        List<ProcurDynamicVo> procurDynamicVo = localityOrderInfoMapper.findListByBaseId(vo.getId());
        for (ProcurDynamicVo pd:procurDynamicVo){
            //根据订单ID查询主采购
            String MainBuyer = localityOrdCommRelaMapper.findMainBuyerByOrdId(pd.getOrdId());
            if (ConverterUtil.isNotEmpty(MainBuyer)){
                pd.setMainBuyer(MainBuyer);
            }
        }
        if (ConverterUtil.isNotEmpty(procurDynamicVo)){
            vo.setProcurDynamicVo(procurDynamicVo);
        }
        resultPoJo.setResult(vo);
       return resultPoJo;
    }
}
