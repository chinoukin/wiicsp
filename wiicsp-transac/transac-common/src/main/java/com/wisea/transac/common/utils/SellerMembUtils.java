package com.wisea.transac.common.utils;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.dao.SaleStaffInfoMageMapper;
import com.wisea.transac.common.dao.StallsMageMapper;
import com.wisea.transac.common.dao.StallsStaffRelaMageMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.SaleStaffInfoMage;
import com.wisea.transac.common.entity.StallsStaffRelaMage;
import com.wisea.transac.common.po.seller.StallsMagePo;
import com.wisea.transac.common.vo.seller.StallsMageListVo;
import com.wisea.transac.common.vo.seller.StallsMagePageListVo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jirg
 * @version 1.0
 * @className SellMembUtils
 * @date 2020/5/7 15:35
 * @Description 卖家会员工具类
 */
public class SellerMembUtils {

    private static SaleStaffInfoMageMapper staffInfoMageMapper = SpringBootContext.getBean(SaleStaffInfoMageMapper.class);
    private static StallsStaffRelaMageMapper staffRelaMageMapper = SpringBootContext.getBean(StallsStaffRelaMageMapper.class);
    private static StallsMageMapper stallsMageMapper = SpringBootContext.getBean(StallsMageMapper.class);


    /**
     * @Author jirg
     * @Date 2020/5/7 16:13
     * @Description 根据当前登录用户查询所有档口信息
     **/
    public static List<StallsMageListVo> getStallsList(Long id){
        List<StallsMageListVo> stallsMages;
        if(ConverterUtil.isEmpty(id)){
            return null;
        }
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(id);
        //查询当前登录用户是否为销售员工
        SaleStaffInfoMage saleStaffInfoMage = staffInfoMageMapper.findBySaleStaffId(id);
        if(ConverterUtil.isNotEmpty(saleStaffInfoMage)){
            //查询销售员工绑定的档口列表
            List<StallsStaffRelaMage> staffRelaMages = staffRelaMageMapper.findByStaffInfoMageId(saleStaffInfoMage.getId());
            if(ConverterUtil.isNotEmpty(staffRelaMages) && staffRelaMages.size() > 0){
                //用户关联档口
                List<Long> ids = staffRelaMages.stream().map(StallsStaffRelaMage::getStallsMageId).collect(Collectors.toList());
                stallsMages = stallsMageMapper.findByIds(ids);
                return stallsMages;
            }
        }
        //用户为管理员或没有关联档口，查询用户所在商户所有档口
        stallsMages = stallsMageMapper.findByMembId(membInfo.getMembId());
        return stallsMages;
    }

    /**
     * @Author jirg
     * @Date 2020/5/7 16:13
     * @Description 根据当前登录用户查询所有档口ID
     **/
    public static List<Long> getStallsIds(Long id){
        List<StallsMageListVo> stallsList = getStallsList(id);
        List<Long> stallsIds = stallsList.stream().map(StallsMageListVo::getId).collect(Collectors.toList());
        return stallsIds;
    }

    /**
     * @Author jirg
     * @Date 2020/5/8 10:57
     * @Description 卖家校验订单是否是当前用户所在档口
     **/
    public static Boolean checkStalls(Long stallsId){
        User user = SystemUtils.getUser();
        List<Long> stallsIds = SellerMembUtils.getStallsIds(user.getId());
        return stallsIds.contains(stallsId);
    }

    /**
     * 根据店铺ID查询所有档口
     * @param shopId
     * @return
     */
    public static List<StallsMagePageListVo> getAllStallsMage(Long shopId) {
        StallsMagePo po = new StallsMagePo();
        po.setShopId(shopId);
        return stallsMageMapper.findAll(po);
    }
}
