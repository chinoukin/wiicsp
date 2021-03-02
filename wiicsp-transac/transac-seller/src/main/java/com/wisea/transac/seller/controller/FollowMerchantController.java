package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.FollowMerchantPo;
import com.wisea.transac.common.po.seller.FindLocalityPageListPo;
import com.wisea.transac.common.po.seller.FollowMerchantBasePo;
import com.wisea.transac.common.po.seller.FollowMerchantminiPageListPo;
import com.wisea.transac.common.vo.FollowMerchantInfoVo;
import com.wisea.transac.common.vo.seller.FindLocalityPageListVo;
import com.wisea.transac.common.vo.seller.FollowMerchantminiPageListVo;
import com.wisea.transac.seller.service.FollowMerchantService;
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
 * @className FollowMerchantController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Api(tags = "关注的店铺")
@RestController
@RequestMapping("/w/FollowMerchant")
public class FollowMerchantController {
    @Autowired
    private FollowMerchantService service;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FollowMerchant
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "同城交易商家", value = "同城交易商家", notes = "同城交易商家", httpMethod = "POST")
    public ResultPoJo<Page<FollowMerchantminiPageListVo>> findPageList(@RequestBody FollowMerchantminiPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FollowMerchant
     */
    @DataCheck
    @RequestMapping(value = "/localityList", method = RequestMethod.POST)
    @ApiOperation(nickname = "产地交易商家", value = "产地交易商家", notes = "产地交易商家", httpMethod = "POST")
    public ResultPoJo<Page<FindLocalityPageListVo>> findLocalityPageList(@RequestBody FindLocalityPageListPo po) {
        return service.findLocalityPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除FollowMerchant
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
     * @Description 新增或修改FollowMerchant
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "收藏or取消", value = "收藏or取消", notes = "收藏or取消", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody FollowMerchantPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改FollowMerchant
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdBase", method = RequestMethod.POST)
    @ApiOperation(nickname = "收藏or取消(基地)", value = "收藏or取消(基地)", notes = "收藏or取消(基地)", httpMethod = "POST")
    public ResultPoJo saveOrUpdBase(@RequestBody FollowMerchantBasePo po) {
        return service.saveOrUpdBase(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息FollowMerchant
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<FollowMerchantInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

}
