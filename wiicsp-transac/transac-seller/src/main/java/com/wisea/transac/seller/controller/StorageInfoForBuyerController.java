package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.vo.seller.StorageInfoListVo;
import com.wisea.transac.common.vo.seller.StorageInfoVo;
import com.wisea.transac.seller.service.StorageInfoService;
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
 * @className StorageInfoController
 * @date 2020/7/2 13:46
 * @Description 仓储信息管理
 */
@RestController
@RequestMapping("/w/buyer/storage")
@Api(tags = "【数字基地】仓储信息-买家")
public class StorageInfoForBuyerController {
    @Autowired
    private StorageInfoService service;

    /**
     * @author jirg
     * @date 2020/7/2 14:06
     * @Description 仓储列表
     */
    @DataCheck
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @ApiOperation(nickname = "仓储列表【入参：基地ID】", value = "仓储列表【入参：基地ID】", notes = "仓储列表【入参：基地ID】", httpMethod = "POST")
    public ResultPoJo<List<StorageInfoListVo>> findList(@RequestBody LongIdPo po) {
        return service.findListForBuyer(po);
    }


    /**
     * @author jirg
     * @date 2020/7/2 14:07
     * @Description 仓储详细信息
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "仓储详细信息", value = "仓储详细信息", notes = "仓储详细信息", httpMethod = "POST")
    public ResultPoJo<StorageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfoForBuyer(po);
    }

}
