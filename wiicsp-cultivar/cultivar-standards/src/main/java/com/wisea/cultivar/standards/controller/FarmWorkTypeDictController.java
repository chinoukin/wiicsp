package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictBatDeletePo;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictGetPo;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictInsertPo;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictPagePo;
import com.wisea.cultivar.standards.po.FarmWorkTypeDictUpdatePo;
import com.wisea.cultivar.standards.service.FarmWorkTypeDictService;
import com.wisea.cultivar.standards.vo.FarmWorkTypeDictGetVo;
import com.wisea.cultivar.standards.vo.FarmWorkTypeDictListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * FarmWorkTypeDictController
 * 农事操作类型字典 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "农事操作类型字典相关接口")
@RequestMapping(value = "/w/FarmWorkTypeDict")
@RestController
public class FarmWorkTypeDictController {
    @Autowired
    protected FarmWorkTypeDictService farmWorkTypeDictService;

    @ApiOperation(value = "获取农事操作类型字典分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<FarmWorkTypeDictListVo>> findPage(@RequestBody FarmWorkTypeDictPagePo farmWorkTypeDictPagePo) {
        return farmWorkTypeDictService.findPage(farmWorkTypeDictPagePo);
    }

    /**
     * 获取农事类型
     * @return
     */
    @ApiOperation(value = "获取一级农事操作类型字典列表")
    @RequestMapping(value = "findAllList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<FarmWorkTypeDictListVo>> findAllList() {
        return farmWorkTypeDictService.findAllList();
    }

//    /**
//     * 获取一级农事
//     * @param farmWorkTypeDictListPo
//     * @return
//     */
//    @ApiOperation(value = "获取一级农事操作类型字典列表")
//    @RequestMapping(value = "list", method = RequestMethod.POST)
//    @DataCheck
//    public ResultPoJo<List<FarmWorkTypeDictListVo>> list(@RequestBody FarmWorkTypeDictListPo farmWorkTypeDictListPo) {
//        return farmWorkTypeDictService.findPSList(farmWorkTypeDictListPo);
//    }
//
//    /**
//     * 获取二级农事
//     * @param farmWorkTypeDictListPo
//     * @return
//     */
//    @ApiOperation(value = "获取二级农事操作类型字典列表")
//    @RequestMapping(value = "twoList", method = RequestMethod.POST)
//    @DataCheck
//    public ResultPoJo<List<FarmWorkTypeDictListVo>> twoList(@RequestBody FarmWorkTypeDictListPo farmWorkTypeDictListPo) {
//        return farmWorkTypeDictService.findTwoList(farmWorkTypeDictListPo);
//    }

    @ApiOperation(value = "查询农事操作类型字典")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<FarmWorkTypeDictGetVo> get(@RequestBody FarmWorkTypeDictGetPo farmWorkTypeDictGetPo) {
        return farmWorkTypeDictService.get(farmWorkTypeDictGetPo);
    }

    @ApiOperation(value = "新增农事操作类型字典")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody FarmWorkTypeDictInsertPo farmWorkTypeDictInsertPo) {
        return farmWorkTypeDictService.insert(farmWorkTypeDictInsertPo);
    }

    @ApiOperation(value = "修改农事操作类型字典")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody FarmWorkTypeDictUpdatePo farmWorkTypeDictUpdatePo) {
        return farmWorkTypeDictService.update(farmWorkTypeDictUpdatePo);
    }

    @ApiOperation(value = "批量删除农事操作类型字典")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody FarmWorkTypeDictBatDeletePo farmWorkTypeDictBatDeletePo) {
        return farmWorkTypeDictService.batDelete(farmWorkTypeDictBatDeletePo);
    }
}
