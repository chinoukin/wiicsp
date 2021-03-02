package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.vo.oritrapla.*;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.entity.oritrapla.ArchSetup;
import com.wisea.cultivar.plant.entity.oritrapla.FarmWorkTypeDict;
import com.wisea.cultivar.plant.service.oritrapla.ArchManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Auth： yangtao
 * projectName:  oritrapla
 * remark:  档案管理App端Controller
 * TODO 保留
 */
@RestController
@RequestMapping("/w/app/arch")
@Api(tags = "【原产地通】档案管理-App端")
public class ArchManageController {

    @Autowired
    private ArchManageService archManageService;

    /**
     * 新增我的档案
     * @param
     * @return
     */
    @ApiOperation(value="oritrapla_042_【档案】保存档案信息", notes="oritrapla_042_【档案】保存档案信息")
    @DataCheck
    @RequestMapping(value="/sava",method= RequestMethod.POST)
    public ResultPoJo<Object> mineArchBasicSava(@RequestBody MineArchBasicPo mineArchBasicPo){
        return archManageService.mineArchBasicSava(mineArchBasicPo);
    }

    /**
     * 使用该种植方法到档案中（第一个id是种植方法id，第二个是档案id）
     * @param
     * @return
     */
    @ApiOperation(value="oritrapla_042_【档案】使用该种植方法到档案中（第一个id是种植方法id，第二个是档案id）", notes="oritrapla_042_【档案】使用该种植方法到档案中（第一个id是种植方法id，第二个是档案id）")
    @DataCheck
    @RequestMapping(value="/useMethod",method= RequestMethod.POST)
    public ResultPoJo<Object> useMethod(@RequestBody LongIdsPo po){
        return archManageService.useMethod(po);
    }

    /**
     * 编辑我的档案
     * @param
     * @return
     */
    @ApiOperation(value="oritrapla_046_【档案】修改档案信息", notes="oritrapla_046_【档案】修改档案信息")
    @DataCheck
    @RequestMapping(value="/upd",method= RequestMethod.POST)
    public ResultPoJo<Object> mineArchBasicUpd(@RequestBody MineArchBasicPo mineArchBasicPo){
        return archManageService.mineArchBasicUpd(mineArchBasicPo);
    }

    /**
     * 删除我的档案
     * @param
     * @return
     */
    @ApiOperation(value="oritrapla_066_【档案】删除我的档案（传我的档案id）", notes="oritrapla_066_【档案】删除我的档案（传我的档案id）")
    @DataCheck
    @RequestMapping(value="/del",method= RequestMethod.POST)
    public ResultPoJo<Object> mineArchBasicUpd(@RequestBody LongIdPo longIdPo){
        return archManageService.mineArchDel(longIdPo.getId());
    }

    /**
     * 档案列表
     * @param mineArchListPo
     * @return
     */
    @ApiOperation(value="oritrapla_045_【档案】查询档案列表", notes="oritrapla_045_【档案】查询档案列表")
    @DataCheck
    @RequestMapping(value="/list",method= RequestMethod.POST)
    public ResultPoJo<Page<ArchBasicInfoVo>> mineArchBasicList(@RequestBody MineArchListPo mineArchListPo){
    	ResultPoJo<Page<ArchBasicInfoVo>> result = new ResultPoJo<Page<ArchBasicInfoVo>>(ConstantCodeMsg.NOMAL);

    	Page<ArchBasicInfoVo> page = mineArchListPo.getPage();

    	List<ArchBasicInfoVo> mineArckList = archManageService.mineArckList(mineArchListPo);
    	page.setList(mineArckList);

    	result.setResult(page);

        return result;
    }

    /**
     * 档案详细信息
     * @param longIdPo
     * @return
     */
    @ApiOperation(value="oritrapla_040_【档案】查询档案详细信息(传我的档案id)", notes="oritrapla_040_【档案】查询档案详细信息(传我的档案id)")
    @DataCheck
    @RequestMapping(value="/info",method= RequestMethod.POST)
    public ResultPoJo<MineArchVo> mineArchBasicInfo(@RequestBody LongIdPo longIdPo){
    	ResultPoJo<MineArchVo> result = new ResultPoJo<MineArchVo>(ConstantCodeMsg.NOMAL);
    	MineArchVo mineArchVo = archManageService.mineArckAndArchInfo(longIdPo.getId());
    	result.setResult(mineArchVo);

        return result;
    }

    /**
     * 正常状态下的档案详细信息
     * @param longIdPo
     * @return
     */
    @ApiOperation(value="oritrapla_127_【档案】带状态校验的档案详情", notes="oritrapla_127_【档案】带状态校验的档案详情")
    @DataCheck
    @RequestMapping(value="/check/info",method= RequestMethod.POST)
    public ResultPoJo<MineArchVo> mineArchInfoCheck(@RequestBody LongIdPo longIdPo){
        return archManageService.mineArchInfoAndChack(longIdPo.getId());
    }

    /**
     * 添加、编辑农事记录
     * @param farmWorkRecdPo
     * @return
     */
    @ApiOperation(value="oritrapla_046_【档案】保存、修改农事记录", notes="oritrapla_046_【档案】保存、修改农事记录")
    @DataCheck
    @RequestMapping(value="/farm/sava",method= RequestMethod.POST)
    public ResultPoJo<Object> farmWorkRecdSava(@RequestBody FarmWorkRecdPo farmWorkRecdPo){
        return archManageService.farmWorkRecdSava(farmWorkRecdPo);
    }

    /**
     * 添加检测记录
     * @param examRecdPo
     * @return
     */
    @ApiOperation(value="oritrapla_051_【档案】保存、修改检测记录", notes="oritrapla_051_【档案】保存、修改检测记录")
    @DataCheck
    @RequestMapping(value="/exam/sava",method= RequestMethod.POST)
    public ResultPoJo<Object> examSava(@RequestBody ExamRecdPo examRecdPo){
        return archManageService.examRecdSava(examRecdPo);
    }

    /**
     * 查询档案检测记录列表
     * @param longIdPo
     * @return
     */
    @ApiOperation(value="oritrapla_050_【档案】查询档案检测记录列表(传我的档案id)", notes="oritrapla_050_【档案】查询档案检测记录列表(传我的档案id)")
    @DataCheck
    @RequestMapping(value="/exam/list",method= RequestMethod.POST)
    public ResultPoJo<List<ExamRecdVo>> examList(@RequestBody LongIdPo longIdPo){
        return archManageService.examRecdListChack(longIdPo.getId());
    }

    /**
     * 查询档案检测记录详情
     * @param longIdPo
     * @return
     */
    @ApiOperation(value="oritrapla_062_【档案】查看检测记录详细信息(传检测记录id)", notes="oritrapla_062_【档案】查看检测记录详细信息(传检测记录id)")
    @DataCheck
    @RequestMapping(value="/exam/info",method= RequestMethod.POST)
    public ResultPoJo<ExamRecdVo> examInfo(@RequestBody LongIdPo longIdPo){
    	ResultPoJo<ExamRecdVo> result = new ResultPoJo<ExamRecdVo>(ConstantCodeMsg.NOMAL);
    	ExamRecdVo examRecdList = archManageService.examRecdInfo(longIdPo.getId());
    	result.setResult(examRecdList);

        return result;
    }

    /**
     * 删除档案检测记录详情
     * @param longIdPo
     * @return
     */
    @ApiOperation(value="oritrapla_063_【档案】删除检测记录(传检测记录id)", notes="oritrapla_063_【档案】删除检测记录(传检测记录id)")
    @DataCheck
    @RequestMapping(value="/exam/dele",method= RequestMethod.POST)
    public ResultPoJo<Object> examInfoDel(@RequestBody LongIdPo longIdPo){
        return archManageService.examRecdDele(longIdPo.getId());
    }

    /**
     * 查询档案农事记录列表
     * @param po
     * @return
     */
    @ApiOperation(value="oritrapla_047_【档案】查询档案农事记录列表(传我的档案id)", notes="oritrapla_047_【档案】查询档案农事记录列表(传我的档案id)")
    @DataCheck
    @RequestMapping(value="/farm/list",method= RequestMethod.POST)
    public ResultPoJo<List<FarmWorkRecdVo>> farmList(@RequestBody FarmWorkSelPo po){
        return archManageService.farmListChack(po);
    }

    /**
     * 查询档案农事记录详情
     * @param longIdPo
     * @return
     */
    @ApiOperation(value="oritrapla_064_【档案】查询农事记录详情(传农事记录id)", notes="oritrapla_064_【档案】查询农事记录详情(传农事记录id)")
    @DataCheck
    @RequestMapping(value="/farm/info",method= RequestMethod.POST)
    public ResultPoJo<FarmWorkRecdVo> farmInfo(@RequestBody LongIdPo longIdPo){
    	ResultPoJo<FarmWorkRecdVo> result = new ResultPoJo<FarmWorkRecdVo>(ConstantCodeMsg.NOMAL);
    	FarmWorkRecdVo farmInfo = archManageService.farmInfo(longIdPo.getId());
    	result.setResult(farmInfo);

        return result;
    }

    /**
     * 立即执行今日代办农事记录
     * @param po
     * @return
     */
    @ApiOperation(value="oritrapla_051_【档案】立即执行今日代办农事记录(传农事记录id)", notes="oritrapla_051_【档案】立即执行今日代办农事记录(传农事记录id)")
    @DataCheck
    @RequestMapping(value="/farm/startFarmNow",method= RequestMethod.POST)
    public ResultPoJo<Object> startFarmNow(@RequestBody LongIdPo po){
        return archManageService.startFarmNow(po);
    }

    /**
     * 删除档案农事记录
     * @param longIdsPo
     * @return
     */
    @ApiOperation(value="oritrapla_065_【档案】删除档案农事记录(传农事记录id：index0和我的档案id：index1)", notes="oritrapla_065_【档案】删除档案农事记录(传农事记录id：index0和我的档案id：index1)")
    @DataCheck
    @RequestMapping(value="/farm/dele",method= RequestMethod.POST)
    public ResultPoJo<Object> farmInfoDel(@RequestBody LongIdsPo longIdsPo){
        return archManageService.delFarmRecd(longIdsPo);
    }

    /**
     * 查询农事操作类型树
     * @param farmWorkDicPo
     * @return
     */
    @ApiOperation(value="oritrapla_049_【档案】查询农事操作类型树", notes="oritrapla_049_【档案】查询农事操作类型树")
    @DataCheck
    @RequestMapping(value="/farm/tree",method= RequestMethod.POST)
    public ResultPoJo<Map<String, List<FarmWorkTypeDict>>> farmTree(@RequestBody FarmWorkDicPo farmWorkDicPo){
    	ResultPoJo<Map<String, List<FarmWorkTypeDict>>> result = new ResultPoJo<Map<String, List<FarmWorkTypeDict>>>(ConstantCodeMsg.NOMAL);
    	Map<String, List<FarmWorkTypeDict>> farmTree = archManageService.farmTree(farmWorkDicPo);
    	result.setResult(farmTree);

        return result;
    }

    /**
     * 查询档案设置详情
     * @param longIdPo
     * @return
     */
    @ApiOperation(value="oritrapla_052_【档案】查询档案设置(传我的档案id)", notes="oritrapla_052_【档案】查询档案设置(传我的档案id)")
    @DataCheck
    @RequestMapping(value="/setup/info",method= RequestMethod.POST)
    public ResultPoJo<ArchSetup> setupInfo (@RequestBody LongIdPo longIdPo){
        return archManageService.mineArchSetUpInfo(longIdPo.getId());
    }

    /**
     * 保存档案设置
     * @param archSetupPo
     * @return
     */
    @ApiOperation(value="oritrapla_053_【档案】保存档案设置", notes="oritrapla_053_【档案】保存档案设置")
    @DataCheck
    @RequestMapping(value="/setup/sava",method= RequestMethod.POST)
    public ResultPoJo<Object> setupSava (@RequestBody ArchSetupPo archSetupPo){
        return archManageService.archSetupSava(archSetupPo);
    }

    /**
     * 根据手机号精确查询会员信息
     * @param contTel
     * @return
     */
    @ApiOperation(value="oritrapla_128_【档案】根据手机号精确查询会员信息", notes="oritrapla_128_【档案】根据手机号精确查询会员信息")
    @DataCheck
    @RequestMapping(value="/seach/menbByTel",method= RequestMethod.POST)
    public ResultPoJo<List<MembMainInfoVo>> menbByTel(@RequestBody StringPo contTel){
    	ResultPoJo<List<MembMainInfoVo>> result = new ResultPoJo<List<MembMainInfoVo>>(ConstantCodeMsg.NOMAL);
    	List<MembMainInfoVo> menbByTel = archManageService.menbByTel(contTel);

    	result.setResult(menbByTel);

        return result;
    }
}
