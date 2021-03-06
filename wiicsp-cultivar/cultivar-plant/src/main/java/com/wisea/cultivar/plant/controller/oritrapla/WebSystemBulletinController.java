package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.AddPlatfNotiPo;
import com.wisea.cultivar.plant.po.oritrapla.PlatfNoticPo;
import com.wisea.cultivar.plant.po.oritrapla.PlatfNoticePo;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfNotice;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfNoticeVo;
import com.wisea.cultivar.plant.service.oritrapla.SystemBulletinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 系统公告控制类
 * @author: wangs
 * @date :2018/6/5
 */
@Api(value = "【原产地通】web管理系统(配置管理系统公告控制类)", description = "供web端调用", tags = "web管理系统(配置管理系统公告控制类)系统公告功能调用接口")
@RestController
@RequestMapping(value = "/w/web/systemBulletin")
public class WebSystemBulletinController {


    @Autowired
    SystemBulletinService systemBulletinService;

    /**
     * 查询系统公告列表分页
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询系统公告列表带分页", httpMethod = "POST")
    @RequestMapping(value = "/findListPage", method = RequestMethod.POST)
    public ResultPoJo<Page<PlatfNoticeVo>> systemBulletinFindListPage(@RequestBody PlatfNoticPo platfNoticPo) {

        return systemBulletinService.systemBulletinFindListPage(platfNoticPo);
    }

    /**
     * 查询系统公告详情
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询系统公告详情", httpMethod = "POST")
    @RequestMapping(value = "/deatail", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<PlatfNotice> systemBulletinDeatail(@RequestBody PlatfNoticePo platfNoticePo) {

        return systemBulletinService.systemBulletinDeatail(platfNoticePo);
    }

    /**
     * 新增系统公告
     *
     * @param
     * @return
     */
    @ApiOperation(value = "新增系统公告", httpMethod = "POST")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo systemBulletinAdd(@RequestBody AddPlatfNotiPo addplatfNotiPo) {

        return systemBulletinService.systemBulletinAdd(addplatfNotiPo);
    }

    /**
     * 修改系统公告
     *
     * @param
     * @return
     */
    @ApiOperation(value = "修改系统公告", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo systemBulletinUpdate(@RequestBody AddPlatfNotiPo addplatfNotiPo) {

        return systemBulletinService.systemBulletinUpdate(addplatfNotiPo);
    }

    /**
     * 删除系统公告
     *
     * @param
     * @return
     */
    @ApiOperation(value = "删除系统公告", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo systemBulletinDelete(@RequestBody PlatfNoticePo platfNoticePo) {

        return systemBulletinService.systemBulletinDelete(platfNoticePo);
    }
}
