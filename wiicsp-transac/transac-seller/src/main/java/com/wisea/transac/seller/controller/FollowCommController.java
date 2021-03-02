package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.FollowCommPo;
import com.wisea.transac.common.po.seller.FocusPo;
import com.wisea.transac.common.po.seller.FollowCommAllPo;
import com.wisea.transac.common.po.seller.FollowCommMiniPageListPo;
import com.wisea.transac.common.vo.FollowCommInfoVo;
import com.wisea.transac.common.vo.seller.FocusVo;
import com.wisea.transac.common.vo.seller.FollowCommMiniPageListVo;
import com.wisea.transac.seller.service.FollowCommService;
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
 * @className FollowCommController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Api(tags = "关注的商品")
@RestController
@RequestMapping("/w/FollowComm")
public class FollowCommController {
    @Autowired
    private FollowCommService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FollowComm
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "同城交易商品", value = "同城交易商品", notes = "同城交易商品", httpMethod = "POST")
    public ResultPoJo<Page<FollowCommMiniPageListVo>> findPageList(@RequestBody FollowCommMiniPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FollowComm
     */
    @DataCheck
    @RequestMapping(value = "/localityList", method = RequestMethod.POST)
    @ApiOperation(nickname = "产地交易商品", value = "产地交易商品", notes = "产地交易商品", httpMethod = "POST")
    public ResultPoJo<Page<FollowCommMiniPageListVo>> findLocalityPageList(@RequestBody FollowCommMiniPageListPo po) {
        return service.findLocalityPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除FollowComm
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "取消收藏", value = "取消收藏", notes = "取消收藏", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改FollowComm
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "收藏or取消", value = "收藏or取消", notes = "收藏or取消", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody FollowCommPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息FollowComm
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<FollowCommInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * 关注数量
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/gzSum", method = RequestMethod.POST)
    @ApiOperation(nickname = "关注数量", value = "关注数量", notes = "关注数量", httpMethod = "POST")
    public ResultPoJo<FocusVo> queryGZSum(@RequestBody FocusPo po) {
        return service.queryGZSum(po);
    }


    /**
     * 批量关注商品
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/saveAll", method = RequestMethod.POST)
    @ApiOperation(nickname = "批量关注商品", value = "批量关注商品", notes = "批量关注商品", httpMethod = "POST")
    public ResultPoJo saveAll(@RequestBody FollowCommAllPo po) {
        return service.saveAll(po);
    }

}
