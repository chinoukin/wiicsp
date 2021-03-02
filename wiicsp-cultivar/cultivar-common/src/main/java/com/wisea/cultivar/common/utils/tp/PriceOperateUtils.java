package com.wisea.cultivar.common.utils.tp;

import java.util.List;

import com.google.common.collect.Lists;
import com.wisea.cultivar.common.vo.tp.trade.ImportBillPriceOperateVo;

/**
 *商品价格的处理
 * projectName:  wtp
 * remark:
 */
public class PriceOperateUtils {


	/**
     * 处理批发价 以及代理价
     */
    public static List<ImportBillPriceOperateVo> priceOperate(String price) {
		String[] split = price.split(";");
		List<ImportBillPriceOperateVo> voList = Lists.newArrayList();
		int inOrderCount = 0;
		for (String string : split) {
			ImportBillPriceOperateVo vo = new ImportBillPriceOperateVo();
			String[] split2 = string.split("\\|");
			int j = 0;
			for (String string2 : split2) {
				String[] split3 = string2.split("-");
				if(split3.length != 1) {
					int i = 0;
					for (String string3 : split3) {
						if(i == 0) {
							vo.setMinCount(Integer.parseInt(string3));
						}else {
							vo.setMaxCount(Integer.parseInt(string3));
						}
						i++;
					}
					j++;
				}else {
					if(j == 0) {
						vo.setMinCount(Integer.parseInt(string2));
						vo.setMaxCount(Integer.parseInt(string2));
						j++;
					}else{
						vo.setPrice(Double.parseDouble(string2));
					}
				}
			}
			vo.setInOrderCount(inOrderCount);
			inOrderCount++;
			voList.add(vo);
		}
		return voList;
    }


    /**
     * 根据商品的数量计算价格       商品的价格(批发价或者代理价)    商品的数量
     */
    public static ImportBillPriceOperateVo calculationPrice(String commInfoprice,int count) {
    	List<ImportBillPriceOperateVo> vo = priceOperate(commInfoprice);
    	ImportBillPriceOperateVo importBillPriceOperateMsgVo = new ImportBillPriceOperateVo();
    	int maxPrice = vo.stream().mapToInt(i -> i.getMaxCount()).max().getAsInt();
    	if(count >= maxPrice) {
    		for (ImportBillPriceOperateVo importBillPriceOperateVo : vo) {
    			if(maxPrice == importBillPriceOperateVo.getMaxCount()) {
    				importBillPriceOperateMsgVo=importBillPriceOperateVo;
    			}
			}
    	}else {
    		for (ImportBillPriceOperateVo importBillPriceOperateVo : vo) {
    			if(count>=importBillPriceOperateVo.getMinCount()&&importBillPriceOperateVo.getMaxCount()>=count) {
    				importBillPriceOperateMsgVo=importBillPriceOperateVo;
    			}
    		}
    	}
    	return importBillPriceOperateMsgVo;
    }
}
