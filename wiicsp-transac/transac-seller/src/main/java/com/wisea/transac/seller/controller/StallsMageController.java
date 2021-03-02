package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.po.seller.StallsMagePageListPo;
import com.wisea.transac.common.po.seller.StallsMagePo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.seller.StallsMageInfoVo;
import com.wisea.transac.common.vo.seller.StallsMageListVo;
import com.wisea.transac.common.vo.seller.StallsMagePageListVo;
import com.wisea.transac.seller.service.StallsMageService;
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
 * @className StallsMageController
 * @date 2020/04/27 17:01:28
 * @Description
 */
@RestController
@RequestMapping("/w/StallsMage")
@Api(tags = "档口管理")
public class StallsMageController {
    @Autowired
    private StallsMageService service;

    /**
     * 修改后的档口列表信息
     * 店铺的关注数进行排序;  档口下所有商品销量总和 排序;
     */
    @DataCheck
    @RequestMapping(value = "/findPageStallsList", method = RequestMethod.POST)
    @ApiOperation(nickname = "修改后的档口列表信息", value = "修改后的档口列表信息", notes = "修改后的档口列表信息", httpMethod = "POST")
    public ResultPoJo<Page<StallsMagePageListVo>> findPageStallsList(@RequestBody StallsMagePageListPo po) {
        return service.findPageStallsList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询StallsMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<StallsMagePageListVo>> findPageList(@RequestBody StallsMagePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 逻辑删除StallsMage
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
     * @Description 新增或修改StallsMage
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody StallsMagePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息StallsMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<StallsMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/7 17:15
     * @Description 查询当前登录用户所有档口列表
     **/
    @RequestMapping(value = "/findByUser", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询当前登录用户所有档口列表", value = "查询当前登录用户所有档口列表", notes = "查询当前登录用户所有档口列表", httpMethod = "POST")
    public ResultPoJo<List<StallsMageListVo>> findByUser() {
        return service.findByUser();
    }

    @DataCheck
    @RequestMapping(value = "/uploadBackPic", method = RequestMethod.POST)
    @ApiOperation(nickname = "上传并修改图片", value = "上传并修改图片", notes = "上传并修改图片", httpMethod = "POST")
    public ResultPoJo uploadBackPic(@RequestBody StallsMagePo po) {
        return service.uploadBackPic(po);
    }


    @DataCheck
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @ApiOperation(nickname = "根据当前登录人分页查询列表", value = "根据当前登录人分页查询列表", notes = "根据当前登录人分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<StallsMagePageListVo>> findList(@RequestBody StallsMagePageListPo po) {
        Long currentId = SystemUtils.getUser().getId();
        MembBaseInfo parentInfo = MembUtils.getMembInfoByUserId(currentId);
        if (!currentId.equals(parentInfo.getMembId())) {
            po.setSaleId(currentId);
        }
        po.setEffeInvalState(DictConstants.EFFE_INVAL_STATE_0);
        return service.findPageList(po);
    }

}
