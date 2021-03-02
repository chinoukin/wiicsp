package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.vo.seller.SortingFactoryVo;
import com.wisea.transac.seller.service.SortingFactoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分选工厂管理
 * @author wjh
 * @since  2020/7/1 14:41
 */
@RestController
@RequestMapping("/w/buyer/sortingFactory")
@Api(tags = "【数字基地】分选工厂-买家")
public class SortingFactoryForBuyerController {
    @Autowired
    private SortingFactoryService service;

    /**
     * @author jirg
     * @date 2020/7/1 14:45
     * @Description 分选工厂列表
     */
    @DataCheck
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分选工厂列表【入参：基地ID】", value = "分选工厂列表【入参：基地ID】", notes = "分选工厂列表【入参：基地ID】", httpMethod = "POST")
    public ResultPoJo<List<SortingFactoryVo>> findList(@RequestBody LongIdPo po) {
        return service.findListForBuyer(po);
    }


    /**
     * @author jirg
     * @date 2020/7/2 9:43
     * @Description 分选工厂详细信息
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "分选工厂详细信息", value = "分选工厂详细信息", notes = "分选工厂详细信息", httpMethod = "POST")
    public ResultPoJo<SortingFactoryVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }
}
