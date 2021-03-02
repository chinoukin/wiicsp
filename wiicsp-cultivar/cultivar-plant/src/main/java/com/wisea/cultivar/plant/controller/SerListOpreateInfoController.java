package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.po.SerListOpreateInfoPageListPo;
import com.wisea.cultivar.plant.po.SerListOpreateInfoPo;
import com.wisea.cultivar.plant.vo.SerListOpreateInfoInfoVo;
import com.wisea.cultivar.plant.vo.SerListOpreateInfoPageListVo;
import com.wisea.cultivar.plant.service.SerListOpreateInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SerListOpreateInfoController
 * @date 2020/08/06 18:28:39
 * @Description
 */
@RestController
@RequestMapping("/w/SerListOpreateInfo")
public class SerListOpreateInfoController {
    @Autowired
    private SerListOpreateInfoService service;

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询SerListOpreateInfo
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<SerListOpreateInfoPageListVo>> findPageList(@RequestBody SerListOpreateInfoPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除SerListOpreateInfo
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
     * @Description 新增或修改SerListOpreateInfo
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody SerListOpreateInfoPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息SerListOpreateInfo
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<SerListOpreateInfoInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }
}
