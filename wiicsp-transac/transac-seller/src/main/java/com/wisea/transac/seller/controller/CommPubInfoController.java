package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.CommPubInfoPageListPo;
import com.wisea.transac.common.po.seller.StallsIdAndCommVarietIdPo;
import com.wisea.transac.common.vo.CommMagePageListVo;
import com.wisea.transac.common.vo.CommPubInfoPageListVo;
import com.wisea.transac.common.vo.product.CommVarietMageListVo;
import com.wisea.transac.seller.service.CommPubInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className CommPubInfoController
 * @date 2020/04/27 17:01:28
 * @Description
 */
@RestController
@RequestMapping("/w/CommPubInfo")
@Api("档口商品查询")
public class CommPubInfoController {
    @Autowired
    private CommPubInfoService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询CommPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表",
            notes = "分页查询列表,查询全部commId为空就行", httpMethod = "POST")
    public ResultPoJo<Page<CommPubInfoPageListVo>> findPageList(@RequestBody CommPubInfoPageListPo po) {
        return service.findPageList(po);
    }

    @DataCheck
    @PostMapping("/findAllCommVariet")
    @ApiOperation("查询档口现有的所有品类")
    public ResultPoJo<List<CommVarietMageListVo>> findAllType(@RequestBody LongIdPo po) {
        return service.findCommVariet(po.getId());
    }

    @DataCheck
    @PostMapping("/findAllComm")
    @ApiOperation("查询档口现有的所有品种")
    public ResultPoJo<List<CommMagePageListVo>> findAllComm(@RequestBody StallsIdAndCommVarietIdPo po) {
        return service.findComm(po);
    }


}
