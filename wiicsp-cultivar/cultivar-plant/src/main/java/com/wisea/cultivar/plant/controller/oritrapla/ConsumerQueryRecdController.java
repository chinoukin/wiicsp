package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.ConsumerQueryRecdPo;
import com.wisea.cultivar.plant.entity.oritrapla.ConsumerQueryRecd;
import com.wisea.cultivar.plant.service.oritrapla.ConsumerQueryRecdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Auth： jirg
 * CreateDate:  2018/6/25
 * projectName:  oritrapla
 * remark:
 */
@RestController
@RequestMapping("/w/web/queryRecd")
@Api(value = "【原产地通】后台消费者查询记录控制类", description = "后台消费者查询", tags = "后台消费者查询调用接口")
public class ConsumerQueryRecdController {
    @Autowired
    private ConsumerQueryRecdService service;


    /**
     * 查询消费者查询列表
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findQueryRecdList", method = RequestMethod.POST)
    @ApiOperation(nickname="WEB端【后台】", value = "oritrapla-125_【追溯】查询消费者查询列表", notes = "查询消费者查询列表")
    public ResultPoJo<Page<ConsumerQueryRecd>> findQueryRecdList(@RequestBody ConsumerQueryRecdPo po){
        return service.findQueryRecdList(po);
    }
}
