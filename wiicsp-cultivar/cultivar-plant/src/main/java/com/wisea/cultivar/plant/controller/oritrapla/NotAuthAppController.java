package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.plant.po.oritrapla.CheckStringPo;
import com.wisea.cultivar.plant.po.oritrapla.LongIdPo;
import com.wisea.cultivar.plant.po.oritrapla.PlatfNoticePo;
import com.wisea.cultivar.plant.service.oritrapla.*;
import com.wisea.cultivar.plant.vo.oritrapla.MineArchVo;
import com.wisea.cultivar.plant.vo.oritrapla.RtspMineArchInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.ScanQRCodeVo;
import com.wisea.cultivar.plant.vo.oritrapla.VersionInfoMageVo;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.oritrapla.ConsumerQueryRecd;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfNotice;
import com.wisea.cultivar.plant.mapper.oritrapla.VersionInfoMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.VersionTypePo;
import com.wisea.cultivar.plant.utils.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;

/**
 * Auth： jirg
 * CreateDate:  2018/6/11
 * projectName:  oritrapla
 * remark:  无权限接口Controller
 */
@RestController
@Api(value = "【原产地通】无权限接口控制类", description = "App端-无权限接口", tags = "App端-无权限接口")
@RequestMapping("/n")
public class NotAuthAppController {
    @Autowired
    private RtspCodeMageService rtspCodeMageService;
    @Autowired
    private ConsumerQueryRecdService queryRecdService;
    @Autowired
    private ArchManageService archManageService;
    @Autowired
    private PlatfAndOpinRetroaAppService platfAndOpinRetroaAppService;
    @Autowired
    private VersionInfoMageMapper versionInfoMageMapper;
    @Autowired
    private SystemBulletinService systemBulletinService;
    /**
     * 消费者扫描追溯二维码查询档案信息
     *
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/app/arch/findByQRCode", method = RequestMethod.POST)
    @ApiOperation(nickname = "App端【消费者】扫描追溯二维码查询档案信息", value = "oritrapla-061_【消费者】扫描追溯二维码查询档案信息", notes = "消费者扫描追溯二维码查询档案信息")
    public ResultPoJo<ScanQRCodeVo> findByQRCode(@ApiParam(name = "追溯码(必填)") @RequestBody CheckStringPo po, HttpServletRequest request) {
        ResultPoJo<ScanQRCodeVo> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        if(po.getStr().length() == 8) {
           result = rtspCodeMageService.findArchByBatchNum(po);
        }else{
            result = rtspCodeMageService.findByQRCode(po);
            if (result.getCode().equals(ConstantError.NOMAL)) {
                ScanQRCodeVo vo = result.getResult();
                RtspMineArchInfoVo rtspMineArchInfoVo = vo.getRtspMineArchInfoVo();
                ConsumerQueryRecd queryRecd = new ConsumerQueryRecd();
                queryRecd.setRtspCode(po.getStr());
                queryRecd.setQueryDate(OffsetDateTime.now());
                queryRecd.setBatchNum(po.getStr().substring(0, 8));
                queryRecd.setQueryMethType(DictConstants.QUERY_METH_TYPE_1); //扫码查询为wap方式查询
                queryRecd.setQueryIp(RandomUtil.getIPAddress(request));
                queryRecd.setArchNum(rtspMineArchInfoVo.getArchNum());
                queryRecdService.save(queryRecd);
            }
        }
        return result;
    }

    /**
     *
     * App端分享查看档案详细信息
     * @param longIdPo
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/app/arch/findArchInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "App端分享查看档案详细信息", value = "oritrapla-130_App端分享查看档案详细信息", notes = "App端分享查看档案详细信息")
    public ResultPoJo<MineArchVo> findArchInfo(@RequestBody LongIdPo longIdPo) {
        ResultPoJo<MineArchVo> result = new ResultPoJo<MineArchVo>(ConstantCodeMsg.NOMAL);
        MineArchVo mineArchVo = archManageService.mineArckAndArchInfo(longIdPo.getId());
        result.setResult(mineArchVo);
        return result;
    }

    /**
     * 用户注册协议和关于我们
     *
     * @param
     * @return
     */
    @ApiOperation(nickname = "用户注册协议和关于我们", value = "用户注册协议和关于我们", notes = "用户注册协议和关于我们")
    @RequestMapping(value = "/app/platfAndOpin/findPlatfInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> findPlatfInfo() {
        return platfAndOpinRetroaAppService.findPlatfInfo();
    }

    /**
     * oritrapla_023_【会员】版本更新的处理(获取最新的版本)
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月27日
     * @version 1.0
     */
    @ApiOperation(nickname="版本更新的处理(获取最新的版本)",value="oritrapla_023_【会员】版本更新的处理(获取最新的版本)",notes="版本更新的处理(获取最新的版本)")
    @RequestMapping(value="/app/memb/getVersionInfo",method= RequestMethod.POST)
    @DataCheck
	public ResultPoJo<VersionInfoMageVo> getVersionInfo(@RequestBody VersionTypePo po){
		// 返回参数初期化
		ResultPoJo<VersionInfoMageVo> result = new ResultPoJo<VersionInfoMageVo>(ConstantError.NOMAL);
		result.setResult(versionInfoMageMapper.getDetailForNewly(po.getVersionType()));
		// 返回参数
		return result;
	}

    /**
     * 查询系统公告详情
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询系统公告详情", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<PlatfNotice> systemBulletinDeatail(@RequestBody PlatfNoticePo platfNoticePo) {
        return systemBulletinService.systemBulletinDeatail(platfNoticePo);
    }
}
