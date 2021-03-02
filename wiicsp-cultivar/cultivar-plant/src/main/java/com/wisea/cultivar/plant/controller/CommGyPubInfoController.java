package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.po.CommGyPubInfoPageListPo;
import com.wisea.cultivar.plant.po.CommGyPubInfoPo;
import com.wisea.cultivar.plant.vo.CommGyPubInfoInfoVo;
import com.wisea.cultivar.plant.vo.CommGyPubInfoPageListVo;
import com.wisea.cultivar.plant.vo.CommVo;
import com.wisea.cultivar.plant.service.CommGyPubInfoService;
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
 * @className CommGyPubInfoController
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Api(tags = "【种植服务APP】前台->前台供应")
@RestController
@RequestMapping("/w/CommGyPubInfo")
public class CommGyPubInfoController {
    @Autowired
    private CommGyPubInfoService service;


    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 联系数+1CommGyPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/addCommGyPubInfoContactsNum", method = RequestMethod.POST)
    @ApiOperation(nickname = "联系数+1", value = "联系数+1", notes = "联系数+1", httpMethod = "POST")
    public ResultPoJo addCommGyPubInfoContactsNum(@RequestBody LongIdPo po) {
        return service.addCommGyPubInfoContactsNum(po);
    }
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 浏览数+1CommGyPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/addCommGyPubInfoViews", method = RequestMethod.POST)
    @ApiOperation(nickname = "浏览数+1", value = "浏览数+1", notes = "浏览数+1", httpMethod = "POST")
    public ResultPoJo addCommGyPubInfoViews(@RequestBody LongIdPo po) {
        return service.addCommGyPubInfoViews(po);
    }



    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询CommGyPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<CommGyPubInfoPageListVo>> findPageList(@RequestBody CommGyPubInfoPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除CommGyPubInfo
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
     * @Description 新增或修改CommGyPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody CommGyPubInfoPo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CommGyPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<CommGyPubInfoInfoVo> findInfo(@RequestBody CommVo po) {
        return service.findInfo(po);
    }


    /**
     * 上下架操作
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/operation", method = RequestMethod.POST)
    @ApiOperation(nickname = "上下架操作", value = "上下架操作", notes = "上下架操作", httpMethod = "POST")
    public ResultPoJo operation(@RequestBody CommGyPubInfoPo po) {
        return service.operation(po);
    }
}
