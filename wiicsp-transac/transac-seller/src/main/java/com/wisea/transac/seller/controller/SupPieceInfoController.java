package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.seller.SupPieceInfoPo;
import com.wisea.transac.common.vo.seller.SupPieceInfoListVo;
import com.wisea.transac.common.vo.seller.SupPieceInfoVo;
import com.wisea.transac.seller.service.SupPieceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className SupPieceInfoController
 * @date 2020/7/1 11:18
 * @Description 优势单品管理
 */
@RestController
@RequestMapping("/w/seller/supPiece")
@Api(tags = "【数字基地】优势单品管理")
public class SupPieceInfoController {
    @Autowired
    private SupPieceInfoService service;

    /**
     * @author jirg
     * @date 2020/7/1 10:03
     * @Description 优势单品列表
     */
    @DataCheck
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @ApiOperation(nickname = "优势单品列表【入参：基地ID】", value = "优势单品列表【入参：基地ID】", notes = "优势单品列表【入参：基地ID】", httpMethod = "POST")
    public ResultPoJo<List<SupPieceInfoListVo>> findList(@RequestBody LongIdPo po) {
        return service.findList(po);
    }

    /**
     * @author jirg
     * @date 2020/7/1 10:03
     * @Description 优势单品详情
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "优势单品详情", value = "优势单品详情", notes = "优势单品详情", httpMethod = "POST")
    public ResultPoJo<SupPieceInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @author jirg
     * @date 2020/7/1 10:03
     * @Description 新增或修改优势单品
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改优势单品", value = "新增或修改优势单品", notes = "新增或修改优势单品", httpMethod = "POST")
    public ResultPoJo<?> saveOrUpdate(@RequestBody SupPieceInfoPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author jirg
     * @date 2020/7/1 10:03
     * @Description 删除优势单品
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "删除优势单品", value = "删除优势单品", notes = "删除优势单品", httpMethod = "POST")
    public ResultPoJo<?> delSupPiece(@RequestBody LongIdPo po) {
        return service.delSupPiece(po);
    }


}
