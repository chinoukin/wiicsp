package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.seller.StallsVideoMagePageListPo;
import com.wisea.transac.common.po.seller.StallsVideoMagePo;
import com.wisea.transac.seller.service.StallsVideoMageService;
import com.wisea.transac.common.vo.seller.StallsVideoMageInfoVo;
import com.wisea.transac.common.vo.seller.StallsVideoMagePageListVo;
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
 * @className StallsVideoMageController
 * @date 2020/04/27 17:01:28
 * @Description
 */
@RestController
@RequestMapping("/w/StallsVideoMage")
@Api(tags = "档口监控视频管理")
public class StallsVideoMageController {
    @Autowired
    private StallsVideoMageService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询StallsVideoMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<StallsVideoMagePageListVo>> findPageList(@RequestBody StallsVideoMagePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 逻辑删除StallsVideoMage
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 新增或修改StallsVideoMage
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody StallsVideoMagePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息StallsVideoMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<StallsVideoMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }


    @DataCheck
    @RequestMapping(value = "/setVideo", method = RequestMethod.POST)
    @ApiOperation(nickname = "设置是否打开视频", value = "设置是否打开视频", notes = "设置是否打开视频", httpMethod = "POST")
    public ResultPoJo setVideo(@RequestBody LongIdPo po) {
        return service.setVideo(po.getId());
    }

    @DataCheck
    @RequestMapping(value = "/setVideoCoverFlag", method = RequestMethod.POST)
    @ApiOperation(nickname = "设置视频为封面", value = "设置视频为封面", notes = "设置视频为封面，已经设置过了则不操作，未设置过就吧其他的改成非封面", httpMethod = "POST")
    public ResultPoJo setVideoCo(@RequestBody LongIdPo po) {
        return service.setCoverFlag(po);
    }
}
