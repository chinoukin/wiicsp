package com.wisea.transac.common.utils;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.dao.LevelSpecQuoteMapper;
import com.wisea.transac.common.entity.LevelSpecQuote;
import com.wisea.transac.common.po.product.PricePoMage;
import com.wisea.transac.common.vo.product.AssembyPriceVo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 组装价格的最小值, 最大值以及成交金额
 * @author: wangs
 * @date :2020/5/11
 */
public class AssemblyPriceUtil {

    private static LevelSpecQuoteMapper levelSpecQuoteMapper = SpringBootContext.getBean(LevelSpecQuoteMapper.class);

    /**
     * 组装价格的最小值, 最大值以及成交金额
     *
     * @param id
     * @return
     */
    public static AssembyPriceVo getProductPrice(Long id) {
        AssembyPriceVo assembyPriceVo = new AssembyPriceVo();
        List<LevelSpecQuote> levelSpecQuoteList = levelSpecQuoteMapper.findListByCommPubId(id);
        if (ConverterUtil.isNotEmpty(levelSpecQuoteList)) {
            // 处理销售金额,销量
            levelSpecQuoteList.forEach(e -> {
                if (ConverterUtil.isNotEmpty(e.getTransactionAmount())) {
                    // 成交金额
                    double transactionSum = levelSpecQuoteList.stream().mapToDouble(LevelSpecQuote::getTransactionAmount).sum();
                    // 销量
                    double salesVolumeTotal = levelSpecQuoteList.stream().mapToDouble(LevelSpecQuote::getSalesVolume).sum();
                    // 产地基地显示库存量 = 可售数量转换成 吨
                    double avaiSupplyCountTotal = levelSpecQuoteList.stream().mapToDouble(LevelSpecQuote::getAvaiSupplyCount).sum();
                    // 总可售数量 * 净重
                    double totalW = ConverterUtil.mul(avaiSupplyCountTotal, e.getNetWeight());
                    // 转换成吨
                    double avaiSupplyCount = ConverterUtil.div(totalW, 2000, 0);

                    assembyPriceVo.setAvaiSupplyCountTotal(ConverterUtil.getRoundValue(avaiSupplyCount, 0).intValue());
                    assembyPriceVo.setTransactionAmount(ConverterUtil.getRoundValue(transactionSum, 2));
                    assembyPriceVo.setSalesVolumeTotal(ConverterUtil.getRoundValue(salesVolumeTotal, 2));
                }
            });
            // 单位
            List<Long> measUnitIds = levelSpecQuoteList.stream().map(LevelSpecQuote::getMeasUnitId).collect(Collectors.toList());
            assembyPriceVo.setMeasUnitIds(measUnitIds);
            // 阶梯价
            String[] split = levelSpecQuoteList.stream().map(LevelSpecQuote::getStartOrdExpres).collect(Collectors.joining("~")).split("~");
            List<PricePoMage> pricePoMages = toIntArray(split);
            Double max = pricePoMages.stream().max(Comparator.comparing(PricePoMage::getPrice)).get().getPrice();
            Double min = pricePoMages.stream().min(Comparator.comparing(PricePoMage::getPrice)).get().getPrice();
            java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");

            assembyPriceVo.setPriceRang(df.format(min).concat("~").concat(df.format(max)));
//            if (levelSpecQuoteList.size() == 1) {
//                levelSpecQuoteList.forEach(e -> {
//                    String priceExpres = e.getPriceExpres();
//                    String[] split = priceExpres.split("\\|");
//                    DecimalFormat df = new DecimalFormat("0.00");
//                    if (split.length == 3) {
//                        String format = df.format(Double.parseDouble(split[split.length - 1]));
//                        assembyPriceVo.setPriceRang(format);
//                    } else if (split.length == 4) {
//                        String format = df.format(Double.parseDouble(split[split.length - 1]));
//                        assembyPriceVo.setPriceRang(format);
//                    } else {
//                        String format = df.format(Double.parseDouble(split[0]));
//                        assembyPriceVo.setPriceRang(format);
//                    }
//                });
//            } else {
//            }
        }
        return assembyPriceVo;
    }

    /**
     * string类型转换成double
     */
    private static List<PricePoMage> toIntArray(String[] split) {
        // 定义一个int数组
        List<PricePoMage> arr = Lists.newArrayList();
        // 对字符串数组进行遍历
        for (int i = 0; i < split.length; i++) {
            PricePoMage pricePoMage = new PricePoMage();

            pricePoMage.setPrice(Double.valueOf(split[i]).doubleValue());
            arr.add(pricePoMage);
        }
        return arr;
    }

    public static void main(String[] args) {
        Long id = 7637543405874835487L;
        AssemblyPriceUtil.getProductPrice(id);
    }
}
