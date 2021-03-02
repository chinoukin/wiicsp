package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.po.oritrapla.IdsAndFlagPo;
import com.wisea.cultivar.plant.po.oritrapla.LongIdPo;
import com.wisea.cultivar.plant.vo.oritrapla.ArchBasicInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.MineArchVo;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.entity.oritrapla.MassifMage;
import com.wisea.cultivar.plant.po.oritrapla.WebMineArchListPo;
import com.wisea.cultivar.plant.service.oritrapla.ArchManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Auth： yangtao
 * projectName:  oritrapla
 * remark:  档案管理后台管理端Controller
 */
@RestController
@RequestMapping("/w/web/sysApp/arch")
@Api(tags = "【原产地通】档案管理-台管理端")
public class SysArchManageController {

    @Autowired
    private ArchManageService archManageService;

    /**
     * 档案列表
     * @param webMineArchListPo
     * @return
     */
    @ApiOperation(value="oritrapla_109_【后台档案管理】档案、已删除档案列表（查询条件类型，0自建，1外采）", notes="oritrapla_109_【后台档案管理】档案、已删除档案列表（查询条件类型，0自建，1外采）")
    @DataCheck
    @RequestMapping(value="/list",method= RequestMethod.POST)
    public ResultPoJo<Page<ArchBasicInfoVo>> sysMineArchList(@RequestBody WebMineArchListPo webMineArchListPo){

    	ResultPoJo<Page<ArchBasicInfoVo>> result = new ResultPoJo<Page<ArchBasicInfoVo>>(ConstantCodeMsg.NOMAL);

    	Page<ArchBasicInfoVo> page = webMineArchListPo.getPage();

    	List<ArchBasicInfoVo> mineArckList = archManageService.webMineArckList(webMineArchListPo);
    	page.setList(mineArckList);

    	result.setResult(page);

        return result;
    }

    /**
     * 档案详细信息
     * @param longIdPo
     * @return
     */
    @ApiOperation(value="oritrapla_105_【后台档案管理】预览档案(传我的档案id)", notes="oritrapla_105_【后台档案管理】预览档案(传我的档案id)")
    @DataCheck
    @RequestMapping(value="/info",method= RequestMethod.POST)
    public ResultPoJo<MineArchVo> sysMineArchInfo(@RequestBody LongIdPo longIdPo){

    	ResultPoJo<MineArchVo> result = new ResultPoJo<MineArchVo>(ConstantCodeMsg.NOMAL);
    	MineArchVo mineArchVo = archManageService.mineArckAndArchInfo(longIdPo.getId());
    	result.setResult(mineArchVo);

        return result;
    }

    /**
     * 档案操作
     * @param idsAndFlagPo
     * @return
     */
    @ApiOperation(value="oritrapla_106_【后台档案管理】禁用、启用、恢复档案", notes="oritrapla_106_【后台档案管理】禁用、启用、恢复档案")
    @DataCheck
    @RequestMapping(value="/sysUpd",method= RequestMethod.POST)
    public ResultPoJo<Object> sysMineArchUpd(@RequestBody IdsAndFlagPo idsAndFlagPo){

        return archManageService.updMineStatus(idsAndFlagPo);
    }

    /**
     * 模糊查询会员主体名称
     * @return
     */
    @ApiOperation(value="oritrapla_107_【后台档案管理】查询所有会员主体名称", notes="oritrapla_107_【后台档案管理】查询所有会员主体名称")
    @DataCheck
    @RequestMapping(value="/orgName",method= RequestMethod.POST)
    public ResultPoJo<List<ZhfwMembInfo>> searchOrgName(){
    	ResultPoJo<List<ZhfwMembInfo>> result = new ResultPoJo<List<ZhfwMembInfo>>(ConstantCodeMsg.NOMAL);
    	List<ZhfwMembInfo> searchOrgName = archManageService.searchOrgName();
    	result.setResult(searchOrgName);
        return result;
    }

    /**
     * 查询所有地块名称
     * @return
     */
    @ApiOperation(value="oritrapla_108_【后台档案管理】查询所有地块名称", notes="oritrapla_108_【后台档案管理】查询所有地块名称")
    @DataCheck
    @RequestMapping(value="/mssiName",method= RequestMethod.POST)
    public ResultPoJo<List<MassifMage>> searchMssiName(){

    	ResultPoJo<List<MassifMage>> result = new ResultPoJo<List<MassifMage>>(ConstantCodeMsg.NOMAL);
    	List<MassifMage> searchOrgName = archManageService.searchMssiName();
    	result.setResult(searchOrgName);

        return result;
    }
}
