package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.po.UpdPhoneNumebrPo;
import com.wisea.cultivar.plant.po.ZhfwExamRecdOprePo;
import com.wisea.cultivar.plant.po.ZhfwMembInfoFindListPo;
import com.wisea.cultivar.plant.po.ZhfwMembInfoPo;
import com.wisea.cultivar.plant.vo.ZhfwMembInfoFindListVo;
import com.wisea.cultivar.plant.vo.ZhfwMembInfoInfoVo;
import com.wisea.cultivar.plant.service.ZhfwMembInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ZhfwMembInfoController
 * @date 2020/08/06 18:28:39
 * @Description
 */
@RestController
@RequestMapping("/w/zhfwMembInfo")
@Api(tags = "种植服务会员信息")
public class ZhfwMembInfoController {
    @Autowired
    private ZhfwMembInfoService service;

    @DataCheck
    @RequestMapping(value = "/addInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "服务商认证(入驻)提交审核", value = "服务商认证(入驻)提交审核", notes = "服务商认证(入驻)提交审核", httpMethod = "POST")
    public ResultPoJo addInfo(@RequestBody ZhfwMembInfoPo po) {
        return service.addInfo(po);
    }

    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询会员/服务商详细信息", value = "查询会员/服务商详细信息", notes = "查询会员/服务商详细信息", httpMethod = "POST")
    public ResultPoJo<ZhfwMembInfoInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }

    @DataCheck
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "修改服务商信息", value = "修改服务商信息", notes = "修改服务商信息", httpMethod = "POST")
    public ResultPoJo updateInfo(@RequestBody ZhfwMembInfoPo po) {
        return service.updateInfo(po);
    }

    @DataCheck
    @RequestMapping(value = "/findZhfwMembList", method = RequestMethod.POST)
    @ApiOperation(nickname = "种植会员管理列表/服务商列表", value = "种植会员管理列表/服务商列表", notes = "种植会员管理列表/服务商列表,服务商是会员的一部分", httpMethod = "POST")
    public ResultPoJo<Page<ZhfwMembInfoFindListVo>> findZhfwMembList(@RequestBody ZhfwMembInfoFindListPo po) {
        return service.findZhfwMembList(po);
    }

    @DataCheck
    @RequestMapping(value = "/exam", method = RequestMethod.POST)
    @ApiOperation(nickname = "服务商信息审核", value = "服务商信息审核", notes = "服务商信息审核", httpMethod = "POST")
    public ResultPoJo exam(@RequestBody ZhfwExamRecdOprePo po) {
        return service.exam(po);
    }

    @DataCheck
    @RequestMapping(value = "/exportZhfwMembList", method = RequestMethod.POST)
    @ApiOperation(nickname = "导出种植会员列表/服务商列表", value = "导出种植会员列表/服务商列表", notes = "导出种植会员列表/服务商列表", httpMethod = "POST")
    public void exportMembInfoList(@RequestBody ZhfwMembInfoFindListPo po, HttpServletResponse response) {
        service.exportMembInfoList(po, response);
    }

    @DataCheck
    @RequestMapping(value = "/setMomentsBjt", method = RequestMethod.POST)
    @ApiOperation(nickname = "设置会员圈子背景图", value = "设置会员圈子背景图", notes = "设置会员圈子背景图", httpMethod = "POST")
    public ResultPoJo setMomentsBjt(@RequestBody ZhfwMembInfoPo po) {
        return service.setMomentsBjt(po);
    }

    /**
     * 登录成功后获取我的信息
     * @param
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "登录成功后获取我的信息", value = "登录成功后获取我的信息", notes = "登录成功后获取我的信息", httpMethod = "POST")
    public ResultPoJo<ZhfwMembInfoInfoVo> getInfo(@RequestBody LongIdPo po) {

        return service.getInfo(po);
    }

    /**
     * 修改用户信息 头像  姓名
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/updateInformation", method = RequestMethod.POST)
    @ApiOperation(nickname = "修改用户信息 头像  姓名", value = "修改用户信息 头像  姓名", notes = "修改用户信息 头像  姓名", httpMethod = "POST")
    public ResultPoJo updateInformation(@RequestBody ZhfwMembInfoPo po) {

        return service.updateInformation(po);
    }

    /**
     * 更改手机号
     * @param po
     * @return
     */
    @RequestMapping(value = "/updPhoneNumber", method = RequestMethod.POST)
    @ApiOperation(nickname = "更改手机号", value = "更改手机号", notes = "更改手机号", httpMethod = "POST")
    public ResultPoJo updPhoneNumber(@Valid @RequestBody UpdPhoneNumebrPo po) {

        return service.changePhoneNumber(po);
    }
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询ZhfwMembInfo
     */
//    @DataCheck
//    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
//    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
//    public ResultPoJo<Page<ZhfwMembInfoPageListVo>> findPageList(@RequestBody ZhfwMembInfoPageListPo po) {
//        return service.findPageList(po);
//    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除ZhfwMembInfo
     */
//    @DataCheck
//    @RequestMapping(value = "/del", method = RequestMethod.POST)
//    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
//    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
//        return service.logicDel(po);
//    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 新增或修改ZhfwMembInfo
     */
//    @DataCheck
//    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
//    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
//    public ResultPoJo saveOrUpdate(@RequestBody ZhfwMembInfoPo po) {
//        return service.saveOrUpdate(po);
//    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息ZhfwMembInfo
     */
//    @DataCheck
//    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
//    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
//    public ResultPoJo<ZhfwMembInfoInfoVo> findInfo(@RequestBody LongIdPo po) {
//        return service.findInfo(po);
//    }
}
