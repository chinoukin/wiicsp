package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.seller.BaseCertMagePo;
import com.wisea.transac.common.vo.seller.BaseCertMageVo;
import com.wisea.transac.seller.service.BaseCertMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className BaseCertMageController
 * @date 2020/7/1 9:33
 * @Description 基地证书管理
 */
@RestController
@RequestMapping("/w/seller/baseCert")
@Api(tags = "【数字基地】基地证书管理")
public class BaseCertMageController {
    @Autowired
    private BaseCertMageService service;

    /**
     * @author jirg
     * @date 2020/7/1 10:03
     * @Description 基地证书列表
     */
    @DataCheck
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @ApiOperation(nickname = "基地证书列表【入参：基地ID】", value = "基地证书列表【入参：基地ID】", notes = "基地证书列表【入参：基地ID】", httpMethod = "POST")
    public ResultPoJo<List<BaseCertMageVo>> findList(@RequestBody LongIdPo po) {
        return service.findList(po);
    }

    /**
     * @author jirg
     * @date 2020/7/1 10:03
     * @Description 基地证书详细信息
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "基地证书详细信息", value = "基地证书详细信息", notes = "基地证书详细信息", httpMethod = "POST")
    public ResultPoJo<BaseCertMageVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @author jirg
     * @date 2020/7/1 10:03
     * @Description 新增或修改基地证书
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改基地证书", value = "新增或修改基地证书", notes = "新增或修改基地证书", httpMethod = "POST")
    public ResultPoJo<?> saveOrUpdate(@RequestBody BaseCertMagePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author jirg
     * @date 2020/7/1 10:03
     * @Description 删除基地证书
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "删除基地证书", value = "删除基地证书", notes = "删除基地证书", httpMethod = "POST")
    public ResultPoJo<?> delBaseCert(@RequestBody LongIdPo po) {
        return service.delBaseCert(po);
    }


}
