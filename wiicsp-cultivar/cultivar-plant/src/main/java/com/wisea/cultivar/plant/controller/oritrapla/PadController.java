package com.wisea.cultivar.plant.controller.oritrapla;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/8/23 10:07 上午
 */
/*@Api(tags = "【原产地通】app端病虫害")
@RestController
@RequestMapping("/n/pad")
public class PadController {

    @Autowired
    private MonitrLiveService monitrLiveService;

    *//*@DataCheck
    @PostMapping("/chart")
    @ApiOperation("按当前日期查询设备整点检测数据")
    public ResultPoJo<MonitrAndPadVo> chart(@RequestBody LongIdPo po) {
        return monitrLiveService.findMonitrLiveByDay(po.getId(), OffsetDateTime.now());
    }*//*

    @DataCheck
    @PostMapping("/warning")
    @ApiOperation("查询所有预警消息")
    public ResultPoJo<List<PadYjInfoListVo>> findWarningInfo(@RequestBody EquIdAndArchIdPo po) {
        return monitrLiveService.findWarningList(po);
    }

    @DataCheck
    @PostMapping("/delete")
    @ApiOperation("删除所有预警消息")
    public ResultPoJo deleteWarningListByEquId(@RequestBody EquIdAndArchIdPo po) {
        return monitrLiveService.deleteWarningListByEquId(po);
    }
}*/
