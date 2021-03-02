package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.plant.po.oritrapla.EquIdAndArchIdPo;
import com.wisea.cultivar.plant.vo.oritrapla.PadYjInfoListVo;
import com.wisea.cultivar.plant.service.oritrapla.PadYjInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/8/23 10:07 上午
 */
@Api(tags = "【原产地通】app端病虫害")
@RestController
@RequestMapping("/n/pad")
public class PadYjInfoController {
    @Autowired
    private PadYjInfoService padYjInfoService;

    @DataCheck
    @PostMapping("/warning")
    @ApiOperation("查询所有预警消息")
    public ResultPoJo<List<PadYjInfoListVo>> findWarningInfo(@RequestBody EquIdAndArchIdPo po) {
        return padYjInfoService.findWarningList(po);
    }

    @DataCheck
    @PostMapping("/delete")
    @ApiOperation("删除所有预警消息")
    public ResultPoJo deleteWarningListByEquId(@RequestBody EquIdAndArchIdPo po) {
        return padYjInfoService.deleteWarningListByEquId(po);
    }
}
