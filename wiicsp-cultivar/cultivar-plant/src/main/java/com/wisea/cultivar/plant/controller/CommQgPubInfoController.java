package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.vo.product.MeasUnitMageListVo;
import com.wisea.cultivar.plant.po.CommQgPubInfoPageListPo;
import com.wisea.cultivar.plant.po.CommQgPubInfoPo;
import com.wisea.cultivar.plant.vo.CommQgPubInfoInfoVo;
import com.wisea.cultivar.plant.vo.CommQgPubInfoPageListVo;
import com.wisea.cultivar.plant.vo.CommVo;
import com.wisea.cultivar.plant.service.CommQgPubInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className CommQgPubInfoController
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Api(tags = "种植求购相关接口")
@RestController
@RequestMapping("/w/commQgPubInfo")
public class CommQgPubInfoController {
    @Autowired
    private CommQgPubInfoService service;


    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 联系数+1CommGyPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/addCommGyPubInfoContactsNum", method = RequestMethod.POST)
    @ApiOperation(nickname = "联系数+1", value = "联系数+1", notes = "联系数+1", httpMethod = "POST")
    public ResultPoJo addCommQgPubInfoContactsNum(@RequestBody LongIdPo po) {
        return service.addCommQgPubInfoContactsNum(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 浏览数+1CommGyPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/addCommQgPubInfoViews", method = RequestMethod.POST)
    @ApiOperation(nickname = "浏览数+1", value = "浏览数+1", notes = "浏览数+1", httpMethod = "POST")
    public ResultPoJo addCommQgPubInfoViews(@RequestBody LongIdPo po) {
        return service.addCommQgPubInfoViews(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询CommQgPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<CommQgPubInfoPageListVo>> findPageList(@RequestBody CommQgPubInfoPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除CommQgPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 新增或修改CommQgPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody CommQgPubInfoPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CommQgPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<CommQgPubInfoInfoVo> findInfo(@RequestBody CommVo po) {
        return service.findInfo(po);
    }

    /**
     * 上下架操作
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/operation", method = RequestMethod.POST)
    @ApiOperation(nickname = "上下架操作", value = "上下架操作", notes = "上下架操作", httpMethod = "POST")
    public ResultPoJo operation(@RequestBody CommQgPubInfoPo po) {
        return service.operation(po);
    }

    /**
     * 获取计量单位列表
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/getMeasUnit", method = RequestMethod.POST)
    @ApiOperation(nickname = "获取计量单位列表", value = "获取计量单位列表", notes = "获取计量单位列表", httpMethod = "POST")
    public ResultPoJo<List<MeasUnitMageListVo>> getMeasUnit() {
        return service.getMeasUnit();
    }
}
