package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.seller.SortingFactoryListVo;
import com.wisea.transac.common.po.seller.SortingFactoryPo;
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
 * @author jirg
 * @version 1.0
 * @className SortingFactoryController
 * @date 2020/7/1 14:41
 * @Description 分选工厂管理
 */
@RestController
@RequestMapping("/w/seller/sortingFactory")
@Api(tags = "【数字基地】分选工厂管理")
public class SortingFactoryController {
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
    public ResultPoJo<List<SortingFactoryListVo>> findList(@RequestBody LongIdPo po) {
        return service.findList(po);
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

    /**
     * @author jirg
     * @date 2020/7/2 9:43
     * @Description 新增或修改分选工厂
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改分选工厂", value = "新增或修改分选工厂", notes = "新增或修改分选工厂", httpMethod = "POST")
    public ResultPoJo<?> saveOrUpdate(@RequestBody SortingFactoryPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author jirg
     * @date 2020/7/2 9:43
     * @Description 删除分选工厂
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "删除分选工厂", value = "删除分选工厂", notes = "删除分选工厂", httpMethod = "POST")
    public ResultPoJo<?> delSortingFactory(@RequestBody LongIdPo po) {
        return service.delSortingFactory(po);
    }
}
