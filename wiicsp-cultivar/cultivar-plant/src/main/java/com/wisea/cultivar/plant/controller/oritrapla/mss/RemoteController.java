package com.wisea.cultivar.plant.controller.oritrapla.mss;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.plant.po.oritrapla.LongIdPo;
import com.wisea.cultivar.plant.vo.oritrapla.PadYjInfoListVo;
import com.wisea.cultivar.plant.vo.oritrapla.mss.DemonsBaseEquArchVo;
import com.wisea.cultivar.plant.vo.oritrapla.mss.DetailedRecordVo;
import com.wisea.cultivar.plant.service.oritrapla.MassifMageService;
import com.wisea.cultivar.plant.service.oritrapla.PadYjInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className RemoteController
 * @date 2020/9/3 10:23
 * @Description
 */
@Api(value = "【种植服务】远程调用接口", tags = "提供远程调用服务，前端请勿调用", hidden = true)
@RestController
@RequestMapping(value = "/i/remotPlant")
public class RemoteController {

    @Autowired
    private MassifMageService massifMageService;
    @Autowired
    private PadYjInfoService padYjInfoService;
    /**
     * @author jirg
     * @date 2020/9/3 10:28
     * @Description 查询地块关联的设备/档案列表
     */
    @ApiOperation(value = "查询地块关联的设备/档案列表", httpMethod = "POST")
    @RequestMapping(value = "/findEquArchByMassifIds", method = RequestMethod.POST)
    ResultPoJo<DemonsBaseEquArchVo> findEquArchByMassifIds(@RequestBody List<Long> po){
        return massifMageService.findEquArchByMassifIds(po);
    }

    /**
     * @author jirg
     * @date 2020/9/3 10:28
     * @Description 查询病虫害列表（前20条）
     */
    @ApiOperation(value = "查询病虫害列表（前20条）", httpMethod = "POST")
    @RequestMapping(value = "/findPestWarning", method = RequestMethod.POST)
    ResultPoJo<List<PadYjInfoListVo>> findPestWarning(){
        return padYjInfoService.findPestWarning();
    }

    /**
     * @Author jirg
     * @Date 2019/7/19 15:07
     * @Description 查询详细记录
     **/
    @ApiOperation(value = "oritrapla_【仪表盘】查询详细记录", notes = "oritrapla_【仪表盘】查询详细记录，入参档案ID")
    @DataCheck
    @RequestMapping(value = "/detailedRecord", method = RequestMethod.POST)
    public ResultPoJo<DetailedRecordVo> detailedRecord(@RequestBody LongIdPo po) {
        return massifMageService.detailedRecord(po);
    }
}
