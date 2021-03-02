package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.system.EntpCommSerPageListPo;
import com.wisea.transac.common.po.system.EntpCommSerPo;
import com.wisea.transac.tp.system.service.EntpCommSerService;
import com.wisea.transac.common.vo.system.EntpCommSerInfoVo;
import com.wisea.transac.common.vo.system.EntpCommSerPageListVo;
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
 * @className EntpCommSerController
 * @date 2020/12/11 14:20:00
 * @Description
 */
@RestController
@RequestMapping("/w/EntpCommSer")
@Api(tags = "商家服务管理")
public class EntpCommSerController {
    @Autowired
    private EntpCommSerService service;

    /**
     * @author wbf-code-generator
     * @date 2020/12/11 14:20:00
     * @Description 分页查询EntpCommSer
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<EntpCommSerPageListVo>> findPageList(@RequestBody EntpCommSerPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/12/11 14:20:00
     * @Description 逻辑删除EntpCommSer
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/12/11 14:20:00
     * @Description 新增或修改EntpCommSer
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody EntpCommSerPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/12/11 14:20:00
     * @Description 查询详细信息EntpCommSer
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<EntpCommSerInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }
}
