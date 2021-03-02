package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.FarmDictPo;
import com.wisea.cultivar.plant.po.oritrapla.FarmWorkDictPo;
import com.wisea.cultivar.plant.po.oritrapla.FarmWorkTypeDictPo;
import com.wisea.cultivar.plant.entity.oritrapla.FarmWorkTypeDict;
import com.wisea.cultivar.plant.entity.oritrapla.FarmWorkTypeDictVo;
import com.wisea.cultivar.plant.service.oritrapla.AgriculturalTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 农事类型控制类
 * @author: wangs
 * @date :2018/6/21
 * TODO 保留
 */
@Api(value = "【原产地通】web管理系统(配置管理农事类型控制类)", description = "供web端调用", tags = "web管理系统(配置管理农事类型控制类)农事类型功能调用接口")
@RestController
@RequestMapping(value = "/w/web/agriculturalType")
public class AgriculturalTypeController {

    @Autowired
    AgriculturalTypeService agriculturalTypeService;

    /**
     * 查询农事类型列表分页
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询农事类型列表分页", httpMethod = "POST")
    @RequestMapping(value = "/findListPage", method = RequestMethod.POST)
    public ResultPoJo<Page<FarmWorkTypeDictVo>> agriculturalTypeFindListPage(@RequestBody FarmWorkTypeDictPo farmWorkTypeDictPo) {
        return agriculturalTypeService.agriculturalTypeFindListPage(farmWorkTypeDictPo);
    }

    /**
     * 一级农事类型,供下拉框使用
     * @return
     */
    @ApiOperation(value = "一级农事类型,供下拉框使用", httpMethod = "POST")
    @RequestMapping(value = "/findOnDegreeList", method = RequestMethod.POST)
    public ResultPoJo<List<FarmWorkTypeDict>> findOnDegreeList() {
        return agriculturalTypeService.findOnDegreeList();
    }

    /**
     * 新增一级农事类型
     * @param farmWorkDictPo
     * @return
     */
    @ApiOperation(value = "新增一级农事类型", httpMethod = "POST")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo agriculturalTypeAdd(@RequestBody FarmWorkDictPo farmWorkDictPo) {
        return agriculturalTypeService.agriculturalTypeAdd(farmWorkDictPo);
    }

    /**
     * 修改农事类型
     *
     * @param
     * @return
     */
    @ApiOperation(value = "修改农事类型", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo agriculturalTypeUpdate(@RequestBody FarmWorkDictPo farmWorkDictPo) {
        return agriculturalTypeService.agriculturalTypeUpdate(farmWorkDictPo);
    }

    /**
     * 查询农事类型详情
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询农事类型详情", httpMethod = "POST")
    @RequestMapping(value = "/deatail", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<FarmWorkTypeDict> agriculturalTypeDeatail(@RequestBody FarmDictPo farmDictPo) {
        return agriculturalTypeService.agriculturalTypeDeatail(farmDictPo);
    }

    /**
     * 删除农事类型
     *
     * @param
     * @return
     */
    @ApiOperation(value = "删除农事类型", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo agriculturalTypeDelete(@RequestBody FarmDictPo farmDictPo) {
        return agriculturalTypeService.agriculturalTypeDelete(farmDictPo);
    }
}
