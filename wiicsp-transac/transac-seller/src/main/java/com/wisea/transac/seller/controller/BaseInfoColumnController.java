package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.po.seller.FindBaseInfoPo;
import com.wisea.transac.common.po.seller.FindSupPieceListPo;
import com.wisea.transac.common.vo.FindSupPieceListVo;
import com.wisea.transac.common.vo.seller.FindBaseInfoVo;
import com.wisea.transac.seller.service.BaseInfoColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * wzx
 */
@Api(tags = "基地详情栏目")
@RestController
@RequestMapping("/w/Column")
public class BaseInfoColumnController {

    @Autowired
    private BaseInfoColumnService baseInfoColumnService;

    @DataCheck
    @RequestMapping(value = "/findSupPieceList", method = RequestMethod.POST)
    @ApiOperation(nickname = "优势单品", value = "优势单品", notes = "优势单品", httpMethod = "POST")
    public ResultPoJo<Page<FindSupPieceListVo>> findPageList(@RequestBody FindSupPieceListPo po) {
        return baseInfoColumnService.findSupPieceInfoList(po);
    }

    @DataCheck
    @RequestMapping(value = "/findBaseInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "基地详情", value = "基地详情", notes = "基地详情", httpMethod = "POST")
    public ResultPoJo<FindBaseInfoVo> findBaseInfo(@RequestBody FindBaseInfoPo po) {
        return baseInfoColumnService.findBaseInfo(po);
    }

}
