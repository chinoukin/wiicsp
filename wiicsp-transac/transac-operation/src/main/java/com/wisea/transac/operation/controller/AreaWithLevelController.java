package com.wisea.transac.operation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.entity.AreaTree;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.SystemCacheService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "按等级查询行政区划")
@RestController
public class AreaWithLevelController {
    @Autowired
    private SystemCacheService systemCacheService;

    @ApiOperation(value = "查询全国市级行政区划", notes = "按等级查询行政区划 最多支持前3级 四个直辖市(北京市 天津市 上海市 重庆市)将返回1级省结构。" + "河北省、河南省、湖北省、海南省、新疆维吾尔自治区的省（自治区）的直辖县级行政单位不显示")
    @RequestMapping(value = "/w/area/getLevelList", method = RequestMethod.POST)
    public ResultPoJo<List<AreaTree>> getAllCityList() {
        ResultPoJo<List<AreaTree>> result = new ResultPoJo<>();
        List<AreaTree> cityList = getAreaListByLevel(2);
        // 过滤掉替换和不需要的
        List<AreaTree> subList = cityList.stream().filter(c -> {
            switch (c.getCode()) {
            case "110100000000":
                // 北京市
                return false;
            case "120100000000":
                // 天津市
                return false;
            case "310100000000":
                // 上海市
                return false;
            case "500100000000":
                // 重庆市
                return false;
            case "139000000000":
                // 河北省直辖县级行政区划
                return false;
            case "419000000000":
                // 河南省省直辖县级行政区划
                return false;
            case "429000000000":
                // 湖北省直辖县级行政区划
                return false;
            case "469000000000":
                // 海南省直辖县级行政区划
                return false;
            case "659000000000":
                // 新疆维吾尔自治区 自治区直辖县级行政区划
                return false;
            }
            return true;
        }).collect(Collectors.toList());
        // 添加直辖市行政区划
        subList.add(0, systemCacheService.getArea("110000000000"));
        subList.add(1, systemCacheService.getArea("120000000000"));
        subList.add(2, systemCacheService.getArea("310000000000"));
        subList.add(3, systemCacheService.getArea("500000000000"));
        result.setResult(subList);
        return result;
    }

    /**
     * 按等级查询行政区划 最多支持前3级
     *
     * @param level
     * @return
     */
    protected List<AreaTree> getAreaListByLevel(int level) {
        List<AreaTree> allList = TreeUtils.treeToList(systemCacheService.getAreaTreeList(), AreaTree.class);
        return allList.stream().filter(a -> a.getLevel() == level).map(k -> {
            AreaTree v = new AreaTree();
            ConverterUtil.copyProperties(k, v, "parent", "children");
            return v;
        }).collect(Collectors.toList());
    }
}
