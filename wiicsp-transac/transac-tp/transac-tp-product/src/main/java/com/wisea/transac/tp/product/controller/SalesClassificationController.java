package com.wisea.transac.tp.product.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.CommSaleCatg;
import com.wisea.transac.common.po.product.CommMageTreePo;
import com.wisea.transac.common.po.product.CommSaleMageInsertPo;
import com.wisea.transac.common.vo.product.SalesClassificationListVo;
import com.wisea.transac.tp.product.service.SalesClassificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 商品销售分类
 * @author: wangs
 * @date :2020/4/30
 */
@Api(tags = "运营后台 - 商品销售分类")
@RestController
@RequestMapping(value = "/w/salesClassification")
public class SalesClassificationController {

    @Autowired
    SalesClassificationService salesClassificationServices;

    /**
     * 查询销售分类树
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询销售品类树", value = "查询销售品类树", notes = "查询销售品类树")
    @RequestMapping(value = "/findCommMageTree", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SalesClassificationListVo>> findCommMageTree(@RequestBody CommMageTreePo po) {
        return salesClassificationServices.findCommMageTree(po);
    }

    /**
     * 运营平台添加和修改销售分类信息
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "添加和修改销售分类", value = "添加和修改销售分类信息", notes = "添加和修改销售分类信息")
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> saveOrUpdate(@RequestBody CommSaleMageInsertPo po) {
        return salesClassificationServices.saveOrUpdate(po);
    }

    /**
     * 查询销售分类详细信息
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询销售分类详细信息", value = "查询销售分类详细信息", notes = "查询销售分类详细信息")
    @RequestMapping(value = "/findCommMageInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<CommSaleCatg> findCommMageInfo(@RequestBody LongIdPo po) {
        return salesClassificationServices.findCommMageInfo(po);
    }

    /**
     * 删除销售分类
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "删除销售分类", value = "删除销售分类", notes = "删除销售分类")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> del(@RequestBody LongIdPo po) {
        return salesClassificationServices.del(po);
    }
}
