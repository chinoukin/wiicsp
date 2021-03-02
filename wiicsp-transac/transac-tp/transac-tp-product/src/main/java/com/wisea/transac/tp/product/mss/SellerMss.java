package com.wisea.transac.tp.product.mss;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdsPo;
import com.wisea.transac.common.po.seller.FindInfoByStallsMageIdPo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMageInfoVo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMagePageListVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author wangjiahao
 * @since 2020/6/8 2:51 下午
 */
@Service
@FeignClient(contextId = "SellerMss", name = "${wbfc.mss.seller:SellerMss}", url = "${wbfc.mssurl.seller:}")
public interface SellerMss {

    /**
     * 根据档口id查询所有关联的销售员工
     *
     * @param po
     * @return
     */
    @PostMapping("/w/StallsStaffRelaMage/findAll")
    ResultPoJo<List<SaleStaffInfoMagePageListVo>> findAll(@RequestBody LongIdsPo po);

    /**
     * 根据档口id 查询销售员工管理员
     *
     * @param po
     * @return
     */
    @PostMapping("/w/StaffMage/findInfoByStallsMageId")
    List<SaleStaffInfoMageInfoVo> findInfoByStallsMageId(@RequestBody FindInfoByStallsMageIdPo po);
}
