package com.wisea.transac.tp.trade.controller.seller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.RefundApplPageListPo;
import com.wisea.transac.common.po.trade.RefundApplHandlePo;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.RefundApplInfoVo;
import com.wisea.transac.common.vo.RefundApplPageListVo;
import com.wisea.transac.common.vo.trade.RefundHandleInfoVo;
import com.wisea.transac.tp.trade.service.RefundApplService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className RefundApplController
 * @date 2020/04/27 17:01:29
 * @Description 卖家退款管理
 */
@Api(tags = "【卖家】退款管理接口")
@RestController
@RequestMapping("/w/seller/refundAppl")
public class RefundApplController {
    @Autowired
    private RefundApplService service;

    /**
     * @Author jirg
     * @Date 2020/5/11 9:33
     * @Description 商家/市场 分页查询退款列表
     **/
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "商家/市场 分页查询退款列表", value = "【退款】商家/市场 分页查询退款列表", notes = "商家/市场 分页查询退款列表", httpMethod = "POST")
    public ResultPoJo<PageStateCountResultVo<RefundApplPageListVo>> findPageList(@RequestBody RefundApplPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/11 9:34
     * @Description 商家/市场 查询退款详情
     **/
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "商家/市场 查询退款详情", value = "【退款】商家/市场 查询退款详情", notes = "商家/市场 查询退款详情", httpMethod = "POST")
    public ResultPoJo<RefundApplInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/11 9:34
     * @Description 查询处理信息
     **/
    @DataCheck
    @RequestMapping(value = "/findHandleInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询处理信息", value = "【退款】查询处理信息", notes = "查询处理信息", httpMethod = "POST")
    public ResultPoJo<RefundHandleInfoVo> findRefundHandleInfo(@RequestBody LongIdPo po) {
        return service.findRefundHandleInfo(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/11 9:34
     * @Description 卖家退款处理
     **/
    @DataCheck
    @RequestMapping(value = "/refundApplHandle", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家退款处理", value = "【退款】卖家退款处理", notes = "卖家退款处理", httpMethod = "POST")
    public ResultPoJo<?> refundApplHandle(@RequestBody RefundApplHandlePo po) {
        return service.refundApplHandle(po);
    }
}
