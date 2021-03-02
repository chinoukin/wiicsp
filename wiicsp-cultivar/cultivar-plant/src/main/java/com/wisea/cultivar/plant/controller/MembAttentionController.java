package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.po.MembAttentionCyqPo;
import com.wisea.cultivar.plant.po.MembAttentionPageListPo;
import com.wisea.cultivar.plant.po.MembAttentionPo;
import com.wisea.cultivar.plant.vo.MembAttentionInfoVo;
import com.wisea.cultivar.plant.vo.MembAttentionPageListVo;
import com.wisea.cultivar.plant.service.MembAttentionService;
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
 * @className MembAttentionController
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Api(tags = "【种植服务APP】前台->前台我的关注")
@RestController
@RequestMapping("/w/MembAttention")
public class MembAttentionController {
    @Autowired
    private MembAttentionService service;

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询MembAttention
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<MembAttentionPageListVo>> findPageList(@RequestBody MembAttentionPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除MembAttention
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
     * @Description 新增或修改MembAttention
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo<MembAttentionInfoVo> saveOrUpdate(@RequestBody MembAttentionPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息MembAttention
     */
//    @DataCheck
//    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
//    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
//    public ResultPoJo<MembAttentionInfoVo> findInfo(@RequestBody LongIdPo po) {
//        return service.findInfo(po);
//    }

    @DataCheck
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ApiOperation(nickname = "取消关注（物理删除）", value = "取消关注（物理删除）", notes = "取消关注（物理删除）", httpMethod = "POST")
    public ResultPoJo<MembAttentionInfoVo> cancel(@RequestBody MembAttentionCyqPo po) {
        return service.cancel(po);
    }

    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "关注情况查询（进入个人主页，被当前用户关注则不为空，否则为空）", value = "关注情况查询（进入个人主页，被当前用户关注则不为空，否则为空）", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<MembAttentionInfoVo> findInfo(@RequestBody MembAttentionCyqPo po) {
        return service.findInfo(po);
    }
}
