package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.po.product.CommMageTreePo;
import com.wisea.cultivar.common.vo.product.ZhfwCommMageTreeVo;

import com.wisea.cultivar.plant.service.CommMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wangs
 * @Date 2019/1/14 13:36
 * @Description 基础分类Controller
 **/
@Api(tags = "基础分类")
@RestController
@RequestMapping("/w/commMage")
public class CommMageController {
    @Autowired
    private CommMageService commMageService;
    /**
     * 查询基础品类树
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询基础品类树", value = "查询基础品类树", notes = "查询基础品类树")
    @RequestMapping(value = "/findCommMageTree", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwCommMageTreeVo>> findCommMageTree(@RequestBody CommMageTreePo po) {
        return commMageService.findCommMageTree(po);
    }



}
