package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.po.SerListInformationPageListPo;
import com.wisea.cultivar.plant.vo.SerListInformationPageListVo;
import com.wisea.cultivar.plant.vo.SerListMageInfoVo;
import com.wisea.cultivar.plant.service.SerListInformationService;
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
 * @className SerListInformationController
 * @date 2020/08/13 11:33:06
 * @Description
 */
@Api(tags = "消息模块")
@RestController
@RequestMapping("/w/SerListInformation")
public class SerListInformationController {
    @Autowired
    private SerListInformationService service;

    /**
     * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
     * @Description 分页查询SerListInformation
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<SerListInformationPageListVo>> findPageList(@RequestBody SerListInformationPageListPo po) {
        return service.findPageList(po);
    }

     /**
      * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
      * @Description 统计未读数量
     */
    @DataCheck
    @RequestMapping(value = "/countInformation", method = RequestMethod.POST)
    @ApiOperation(nickname = "统计未读数量", value = "统计未读数量", notes = "统计未读数量", httpMethod = "POST")
    public ResultPoJo<Integer> countInformation() {
        return service.countInformation();
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
     * @Description 全部转为已读
     */
    @DataCheck
    @RequestMapping(value = "/toRead", method = RequestMethod.POST)
    @ApiOperation(nickname = "全部转为已读", value = "全部转为已读", notes = "全部转为已读", httpMethod = "POST")
    public ResultPoJo toRead() {
        return service.toRead();
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
     * @Description 查看消息详情
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细服务单信息", value = "查询详细服务单信息", notes = "查询详细服务单信息", httpMethod = "POST")
    public ResultPoJo<SerListMageInfoVo> findInfo(@RequestBody LongIdPo po) {

        return service.findInfo(po);
    }

/*    *//**
     * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
     * @Description 逻辑删除SerListInformation
     *//*
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    *//**
     * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
     * @Description 新增或修改SerListInformation
     *//*
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody SerListInformationPo po) {
        return service.saveOrUpdate(po);
    }

    *//**
     * @author wbf-code-generator
     * @date 2020/08/13 11:33:06
     * @Description 查询详细信息SerListInformation
     *//*
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<SerListInformationInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }*/
}
