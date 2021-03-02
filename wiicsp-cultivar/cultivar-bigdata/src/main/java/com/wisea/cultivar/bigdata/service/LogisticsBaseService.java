package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.dao.bigdata.CarJcInfoMapper;
import com.wisea.cultivar.common.dao.bigdata.ClOrdInfoMapper;
import com.wisea.cultivar.common.dao.bigdata.GwldbtMapper;
import com.wisea.cultivar.common.dao.bigdata.JtgjdyfxMapper;
import com.wisea.cultivar.common.dao.bigdata.LogisticsMapInfoMapper;
import com.wisea.cultivar.common.dao.bigdata.NationalDistrStatisticsMapper;
import com.wisea.cultivar.common.dao.bigdata.OrdYjInfoMapper;
import com.wisea.cultivar.common.entity.bigdata.ClOrdInfo;
import com.wisea.cultivar.common.entity.bigdata.Gwldbt;
import com.wisea.cultivar.common.entity.bigdata.Jtgjdyfx;
import com.wisea.cultivar.common.po.bigdata.CarJcInfoListPo;
import com.wisea.cultivar.common.po.bigdata.ClOrdInfoListPo;
import com.wisea.cultivar.common.po.bigdata.GwldbtListPo;
import com.wisea.cultivar.common.po.bigdata.JtgjdyfxListPo;
import com.wisea.cultivar.common.po.bigdata.LogisticBasicDataPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsBasicDataUpdatePo;
import com.wisea.cultivar.common.po.bigdata.LogisticsTransferAnalysisUpdatePo;
import com.wisea.cultivar.common.po.bigdata.LogisticsTransferPo;
import com.wisea.cultivar.common.po.bigdata.MonthlyDistrTrendUpdatePo;
import com.wisea.cultivar.common.po.bigdata.MonthlyDistrUpdatePo;
import com.wisea.cultivar.common.po.bigdata.OrdYjInfoListPo;
import com.wisea.cultivar.common.vo.bigdata.CarJcInfoListVo;
import com.wisea.cultivar.common.vo.bigdata.ClOrdInfoListVo;
import com.wisea.cultivar.common.vo.bigdata.GwldbtListVo;
import com.wisea.cultivar.common.vo.bigdata.JtgjdyfxListVo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsBasePo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsBasicDataListVo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsTransferAnalysisListVo;
import com.wisea.cultivar.common.vo.bigdata.MonthlyDistrTrendListVo;
import com.wisea.cultivar.common.vo.bigdata.OrdYjInfoListVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/12/2 5:02 下午
 */
@Service
public class LogisticsBaseService extends BaseService {

    private static final Logger log = LoggerFactory.getLogger(LogisticsBaseService.class);

    @Autowired
    private ClOrdInfoMapper clOrdInfoMapper;
    @Autowired
    private LogisticsMapInfoMapper logisticsMapInfoMapper;
    @Autowired
    private CarJcInfoMapper carJcInfoMapper;
    @Autowired
    private OrdYjInfoMapper ordYjInfoMapper;
    @Autowired
    private JtgjdyfxMapper jtgjdyfxMapper;
    @Autowired
    private GwldbtMapper gwldbtMapper;
    @Autowired
    private NationalDistrStatisticsMapper nationalDistrStatisticsMapper;
    @Autowired
    private MonthlyDistrTrendService monthlyDistrTrendService;
    @Autowired
    private LogisticsTransferAnalysisService logisticsTransferAnalysisService;
    @Autowired
    private LogisticsBasicDataService logisticsBasicDataService;

    public ResultPoJo<LogisticsBasePo> findDetails() {
        LogisticsBasePo po = new LogisticsBasePo();

        //物流流通总件数
        //处理订单统计
        List<ClOrdInfoListVo> clOrders = clOrdInfoMapper.findList(new ClOrdInfoListPo());
        ClOrdInfoListVo clOrder;
        if (clOrders.size() != 0) {
            clOrder = clOrders.get(0);
        } else {
            clOrder = new ClOrdInfoListVo();
            clOrder.setDcl(0);
            clOrder.setDbz(0);
            clOrder.setZtz(0);
            clOrder.setYwc(0);
        }
        po.setLogisticsCount(clOrder.getDbz() + clOrder.getDcl() + clOrder.getZtz() + clOrder.getYwc());
        po.setClOrdInfo(clOrder);

        //预警总数
        List<OrdYjInfoListVo> ordYjInfos = ordYjInfoMapper.findList(new OrdYjInfoListPo());
        po.setWarningCount(ordYjInfos.size());

        //各交通工具调用
        List<JtgjdyfxListVo> jtgjdyfxs = jtgjdyfxMapper.findList(new JtgjdyfxListPo());
        po.setTrafficInvokeList(jtgjdyfxs);

        //各物流对比
        List<GwldbtListVo> gwldbts = gwldbtMapper.findList(new GwldbtListPo());
        po.setLogisticsContrastList(gwldbts);

        //车辆检测总条数
        List<CarJcInfoListVo> carJcInfos = carJcInfoMapper.findList(new CarJcInfoListPo());
        po.setCarCount(carJcInfos.size());

        //查询全国物流配送地址面积的分布总数据量
        Integer all = nationalDistrStatisticsMapper.countAll();
        po.setNationalDistrCount(all);

        //查询月配送单量
        ResultPoJo<List<MonthlyDistrTrendListVo>> list = monthlyDistrTrendService.findAllList();
        po.setMonthlyDistrTrendList(list.getResult());

        //查询物流中转分析
        ResultPoJo<List<LogisticsTransferAnalysisListVo>> listResultPoJo = logisticsTransferAnalysisService.findAllList();
        po.setLogisticsTransferAnalysisList(listResultPoJo.getResult());

        //物流基础数据
        ResultPoJo<List<LogisticsBasicDataListVo>> dataServiceList = logisticsBasicDataService.findList();
        po.setLogisticsBasicDataList(dataServiceList.getResult());

        ResultPoJo<LogisticsBasePo> result = new ResultPoJo<>();
        result.setResult(po);

        return result;

    }

    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo updateDetails(LogisticsBasePo po) {
        //处理订单统计
        clOrdInfoMapper.findList(new ClOrdInfoListPo()).forEach(i -> {
            ClOrdInfo info = new ClOrdInfo();
            info.setId(i.getId());
            info.setDelFlag("1");
            info.preUpdate();
            clOrdInfoMapper.updateByPrimaryKeySelective(info);
        });
        ClOrdInfo info = new ClOrdInfo();
        ConverterUtil.copyProperties(po.getClOrdInfo(), info);
        info.setDelFlag("0");
        info.preInsert();
        clOrdInfoMapper.insertSelective(info);

        //各交通工具调用
        jtgjdyfxMapper.findList(new JtgjdyfxListPo()).forEach(i -> {
            Jtgjdyfx jtgjdyfx = new Jtgjdyfx();
            jtgjdyfx.setId(i.getId());
            jtgjdyfx.setDelFlag("1");
            jtgjdyfx.preUpdate();
            jtgjdyfxMapper.updateByPrimaryKeySelective(jtgjdyfx);
        });
        po.getTrafficInvokeList().forEach(i -> {
            Jtgjdyfx jtgjdyfx = new Jtgjdyfx();
            ConverterUtil.copyProperties(i, jtgjdyfx);
            jtgjdyfx.setDelFlag("0");
            jtgjdyfx.preInsert();
            jtgjdyfxMapper.insertSelective(jtgjdyfx);
        });

        //各物流对比
        gwldbtMapper.findList(new GwldbtListPo()).forEach(i -> {
            Gwldbt gwldbt = new Gwldbt();
            gwldbt.setDelFlag("1");
            gwldbt.setId(i.getId());
            gwldbt.preUpdate();
            gwldbtMapper.updateByPrimaryKeySelective(gwldbt);
        });
        po.getLogisticsContrastList().forEach(i -> {
            Gwldbt gwldbt = new Gwldbt();
            ConverterUtil.copyProperties(i, gwldbt);
            gwldbt.setDelFlag("0");
            gwldbt.preInsert();
            gwldbtMapper.insertSelective(gwldbt);
        });

        //月配送单量
        List<MonthlyDistrTrendListVo> list = po.getMonthlyDistrTrendList();
        MonthlyDistrUpdatePo monthlyDistrUpdatePo = new MonthlyDistrUpdatePo();
        monthlyDistrUpdatePo.setList(
                list.stream().map(i -> {
                    MonthlyDistrTrendUpdatePo trendUpdatePo = new MonthlyDistrTrendUpdatePo();
                    trendUpdatePo.setNum(i.getNum());
                    trendUpdatePo.setRemarks(i.getRemarks());
                    return trendUpdatePo;
                }).collect(toList())
        );
        monthlyDistrTrendService.update(monthlyDistrUpdatePo);
        //物流中转分析
        LogisticsTransferPo logisticsTransferPo = new LogisticsTransferPo();
        logisticsTransferPo.setList(
                po.getLogisticsTransferAnalysisList().stream().map(i -> {
                    LogisticsTransferAnalysisUpdatePo updatePo = new LogisticsTransferAnalysisUpdatePo();
                    updatePo.setLogisticsTransferAnalysisType(i.getLogisticsTransferAnalysisType());
                    updatePo.setRemarks(i.getRemarks());
                    updatePo.setNum(i.getNum());
                    return updatePo;
                }).collect(toList())
        );
        logisticsTransferAnalysisService.update(logisticsTransferPo);
        //物流基础数据
        LogisticBasicDataPo logisticBasicDataPo = new LogisticBasicDataPo();
        logisticBasicDataPo.setList(
                po.getLogisticsBasicDataList().stream().map(i -> {
                    LogisticsBasicDataUpdatePo updatePo = new LogisticsBasicDataUpdatePo();
                    updatePo.setLogisticsBasicDataType(i.getLogisticsBasicDataType());
                    updatePo.setNum(i.getNum());
                    return updatePo;
                }).collect(toList())
        );
        logisticsBasicDataService.update(logisticBasicDataPo);

        return new ResultPoJo();
    }

}
