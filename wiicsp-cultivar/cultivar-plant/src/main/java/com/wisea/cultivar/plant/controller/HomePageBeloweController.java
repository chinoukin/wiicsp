package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.po.KnowledgeBaseMagePageListPo;
import com.wisea.cultivar.plant.po.PolicyTechnologyInfoPo;
import com.wisea.cultivar.plant.po.StandardRuleMagePageListPo;
import com.wisea.cultivar.plant.vo.KnowledgeBaseMageInfoVo;
import com.wisea.cultivar.plant.vo.KnowledgeBaseMagePageListVo;
import com.wisea.cultivar.plant.vo.StandardRuleMageAndLinkVo;
import com.wisea.cultivar.plant.vo.StandardRuleMageInfoVo;
import com.wisea.cultivar.plant.service.KnowledgeBaseMageService;
import com.wisea.cultivar.plant.service.StandardRuleMageService;
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
 * @className 看政策/学农技/防虫害/查标准
 * @date 2020/08/07 10:13:35
 * @Description
 */
@Api(tags = "看政策/学农技/查标准")
@RestController
@RequestMapping("/w/HomePageBelowe")
public class HomePageBeloweController {

    @Autowired
    private KnowledgeBaseMageService service;


    @Autowired
    private StandardRuleMageService standardRuleMageService;
    /**
     * @author wbf-code-generator
     * @date 2020/08/08 14:38:07
     * @Description 看政策/学农技分页查询KnowledgeBaseMage
     */
    @DataCheck
    @RequestMapping(value = "/findPolicyTechnologyPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "看政策/学农技分页查询列表", value = "看政策/学农技分页查询列表", notes = "看政策/学农技分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<KnowledgeBaseMagePageListVo>> findPageList(@RequestBody KnowledgeBaseMagePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/08 14:38:07
     * @Description 看政策/学农技查询详细信息KnowledgeBaseMage
     */
    @DataCheck
    @RequestMapping(value = "/findPolicyTechnologyInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "看政策/学农技查询详细信息", value = "看政策/学农技查询详细信息", notes = "看政策/学农技查询详细信息", httpMethod = "POST")
    public ResultPoJo<KnowledgeBaseMageInfoVo> findInfo(@RequestBody PolicyTechnologyInfoPo po) {
        return service.findInfo(po);
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/08 16:53:01
     * @Description 分页查询标准列表
     */
    @DataCheck
    @RequestMapping(value = "/findStandardRuleMagePageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询标准列表", value = "分页查询标准列表", notes = "分页查询标准列表", httpMethod = "POST")
    public ResultPoJo<StandardRuleMageAndLinkVo> findStandardRuleMagePageList(@RequestBody StandardRuleMagePageListPo po) {
        return standardRuleMageService.findStandardRuleMagePageList(po);
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/08 16:53:01
     * @Description 查询标准详细信息
     */
    @DataCheck
    @RequestMapping(value = "/findStandardRuleMageInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询标准详细信息", value = "查询标准详细信息", notes = "查询标准详细信息", httpMethod = "POST")
    public ResultPoJo<StandardRuleMageInfoVo> findStandardRuleMageInfo(@RequestBody PolicyTechnologyInfoPo po) {
        return standardRuleMageService.findStandardRuleMageInfo(po);
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/08 16:53:01
     * @Description 查看标准原文
     */
    @DataCheck
    @RequestMapping(value = "/findOriginalInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查看标准原文", value = "查看标准原文", notes = "查看标准原文", httpMethod = "POST")
    public ResultPoJo<String> findOriginalInfo(@RequestBody LongIdPo po) {
        return standardRuleMageService.findOriginalInfo(po);
    }


}
