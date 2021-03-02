package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.po.CertMagePageListPo;
import com.wisea.cultivar.plant.po.CertMagePo;
import com.wisea.cultivar.plant.vo.CertMageInfoVo;
import com.wisea.cultivar.plant.service.CertMageService;
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
 * @className CertMageController
 * @date 2020/08/06 18:28:39
 * @Description
 */
@RestController
@RequestMapping("/w/certMage")
@Api(tags = "证书管理")
public class CertMageController {
    @Autowired
    private CertMageService service;

    @DataCheck
    @RequestMapping(value = "/findShopCerts", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询店铺证书列表信息", value = "查询店铺证书列表信息", notes = "查询店铺证书列表信息", httpMethod = "POST")
    public ResultPoJo<List<CertMageInfoVo>> findShopCerts(@RequestBody CertMagePageListPo po) {
        return service.findShopCerts(po);
    }

    @DataCheck
    @RequestMapping(value = "/addInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "添加证书信息", value = "添加证书信息", notes = "添加证书信息", httpMethod = "POST")
    public ResultPoJo addInfo(@RequestBody CertMagePo po) {
        return service.addInfo(po);
    }

    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "删除证书信息", value = "删除证书信息", notes = "删除证书信息", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CertMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "证书详情", value = "证书详情", notes = "证书详情", httpMethod = "POST")
    public ResultPoJo<CertMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CertMage
     */
    @DataCheck
    @RequestMapping(value = "/findCertPicture", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询证书图片", value = "查询证书图片", notes = "查询证书图片", httpMethod = "POST")
    public ResultPoJo<List<String>> findCertPicture(@RequestBody LongIdPo po) {
        return service.findCertPicture(po);
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询CertMage
     */
//    @DataCheck
//    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
//    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
//    public ResultPoJo<Page<CertMagePageListVo>> findPageList(@RequestBody CertMagePageListPo po) {
//        return service.findPageList(po);
//    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 新增或修改CertMage
     */
//    @DataCheck
//    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
//    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
//    public ResultPoJo saveOrUpdate(@RequestBody CertMagePo po) {
//        return service.saveOrUpdate(po);
//    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CertMage
     */
//    @DataCheck
//    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
//    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
//    public ResultPoJo<CertMageInfoVo> findInfo(@RequestBody LongIdPo po) {
//        return service.findInfo(po);
//    }
}
