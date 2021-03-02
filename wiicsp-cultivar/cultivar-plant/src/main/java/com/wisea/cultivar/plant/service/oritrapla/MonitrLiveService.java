package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.entity.oritrapla.PadYjInfo;
import com.wisea.cultivar.plant.mapper.oritrapla.PadMageMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.PadYjInfoMapper;
import com.wisea.cultivar.plant.po.oritrapla.EquIdAndArchIdPo;
import com.wisea.cultivar.plant.po.oritrapla.PadYjInfoListPo;
import com.wisea.cultivar.plant.po.oritrapla.PadYjInfoPagePo;
import com.wisea.cultivar.plant.vo.oritrapla.PadYjInfoListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/8/22 3:04 下午
 */
@Service
public class MonitrLiveService extends BaseService {

//    @Autowired
//    private MonitrLiveMapper monitrLiveMapper;
    @Autowired
    private com.wisea.cultivar.plant.mapper.oritrapla.EquInfoMageMapper EquInfoMageMapper;
    @Autowired
    private PadMageMapper padMageMapper;
    @Autowired
    private PadYjInfoMapper padYjInfoMapper;
    @Autowired
    private JedisDao jedisdao;
    @Autowired
    private InsectPestsWarningSendService sendService;

    /**
     * 格式health_check_equ_id_设备ID_病虫害ID
     */
    private static final String HEALTH_CHECK_PREFIX = "health_check_equ_id_";

    /*@Transactional(rollbackFor = Exception.class)
    public ResultPoJo insert(List<BananaBdBaseInfoVo.BaseInfo> po) {
        if (po == null) {
            return new ResultPoJo();
        }
        for (BananaBdBaseInfoVo.BaseInfo info : po) {
            EquInfoMageVo eq = EquInfoMageMapper.findByEquipNum(info.getNo());
            if (eq == null) {
                continue;
            }
            MonitrLive live = BaseInfoEnvToMonitrLive(info, eq);
            live.setRemarks("香蕉检查");
            monitrLiveMapper.insert(live);
        }
        return new ResultPoJo();
    }*/

    /**
     * redisKey = health_check_equ_id_XXX_YYY_ZZZ
     * XXX=设备ID
     * YYY=病虫害ID
     * ZZZ=档案ID
     *
     * @param equNo
     * @return
     */


    /*@Transactional(rollbackFor = Exception.class)
    public ResultPoJo healthCheck(String equNo) {
        //redis存8分钟，每5分钟计算一次，第一次记录后，如果第二次断裂，则在第三次记录时重新记录
        int timeOut = 60 * 8;
        EquInfoMageVo eq = EquInfoMageMapper.findByEquipNum(equNo);
        if (eq == null) {
            return new ResultPoJo();
        }
        MonitrLive latest = monitrLiveMapper.findLatest(eq.getId());
        if (latest == null) {
            return new ResultPoJo();
        }
        List<ArchBasicInfoVo> archs = EquInfoMageMapper.findArchByEquId(eq.getId());

        for (ArchBasicInfoVo arch : archs) {
            latest.setCommId(arch.getCommId());
            List<PadMageListVo> padList = padMageMapper.healthCheck(latest);

            for (PadMageListVo pad : padList) {
                String redisKey = HEALTH_CHECK_PREFIX + eq.getId() + "_" + pad.getId() + "_" + arch.getArchId();
                if (jedisdao.exists(redisKey)) {
                    HealthCheckVo vo = jedisdao.getSerialize(redisKey, HealthCheckVo.class);
                    long duration = vo.getDuration() + 5;
                    long cxsj = vo.getBfTime() - duration;
                    if (cxsj <= 5 && cxsj >= -5) { //持续时间在爆发时间左右10分钟
                        PadYjInfo info = new PadYjInfo();
                        info.setArchId(arch.getArchId());
                        info.setEquId(eq.getId());
                        info.setPadId(pad.getId());
                        info.setPadName(pad.getPadName());
                        info.setCxsjTime((double) duration);
                        info.setReportTime(OffsetDateTime.now());
                        info.setContent("当前种植可能发生了病虫害，已经持续了" + (duration / 60) + "个小时，请尽快前往实地查看并提前做好防治工作！");
                        info.preInsert();
                        //插入预警记录
                        padYjInfoMapper.insertSelective(info);
                        //发送通知短信
                        InsctWarningPo insctWarningPo = new InsctWarningPo();
                        insctWarningPo.setId(info.getId());
                        insctWarningPo.setEquId(info.getEquId());
                        sendService.sendWarningMsg(insctWarningPo);
                        //删除redis记录
                        jedisdao.delSerialize(redisKey);

                    } else {
                        vo.setDuration(vo.getDuration() + 5);
                        vo.setUpdateDate(OffsetDateTime.now());
                        jedisdao.setSerializeExpire(redisKey, vo, timeOut);
                    }
                } else {
                    HealthCheckVo vo = new HealthCheckVo();
                    vo.setCreateDate(OffsetDateTime.now());
                    vo.setBfTime((long) (pad.getBfTime() * 60));
                    vo.setDuration(0L);
                    vo.setEquId(eq.getId());
                    vo.setPadId(pad.getId());
                    jedisdao.setSerializeExpire(redisKey, vo, timeOut);
                }
            }
        }
        return new ResultPoJo();
    }*/

    /**
     * 分页查询预警信息
     *
     * @param po
     * @return
     */
    public ResultPoJo<Page<PadYjInfoListVo>> findWarningPages(PadYjInfoPagePo po) {
        if (ConverterUtil.isNotEmpty(po.getSearch())) {
            po.setSearch("%" + po.getSearch() + "%");
        }
        Page<PadYjInfoListVo> page = po.getPage();
        List<PadYjInfoListVo> list = padYjInfoMapper.findPage(po);
        page.setList(list);
        ResultPoJo<Page<PadYjInfoListVo>> poJo = new ResultPoJo<>();
        poJo.setResult(page);
        return poJo;
    }

    /**
     * 查询所有预警信息
     */
    public ResultPoJo<List<PadYjInfoListVo>> findWarningList(EquIdAndArchIdPo po) {
        PadYjInfoListPo listPo = new PadYjInfoListPo();
        listPo.setEquId(po.getEquId());
        listPo.setArchId(po.getArchId());
        List<PadYjInfoListVo> list = padYjInfoMapper.findList(listPo);
        ResultPoJo<List<PadYjInfoListVo>> poJo = new ResultPoJo<>();
        poJo.setResult(list);
        return poJo;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo deleteWarningListByEquId(EquIdAndArchIdPo po) {
        PadYjInfoListPo listPo = new PadYjInfoListPo();
        listPo.setEquId(po.getEquId());
        listPo.setArchId(po.getArchId());
        List<PadYjInfoListVo> list = padYjInfoMapper.findList(listPo);
        list.forEach(i -> {
            PadYjInfo info = new PadYjInfo();
            info.setId(i.getId());
            info.setDelFlag("1");
            info.preUpdate();
            padYjInfoMapper.updateByPrimaryKeySelective(info);
        });
        return new ResultPoJo();
    }

    /**
     * 按日期查询某设备的整点检测情况
     *
     * @param equId
     * @return
     */
   /* public ResultPoJo<MonitrAndPadVo> findMonitrLiveByDay(Long equId, OffsetDateTime date) {
        ResultPoJo<MonitrAndPadVo> poJo = new ResultPoJo<>();

        Map<String, Object> map = Maps.newHashMap();
        map.put("date", date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        map.put("equId", equId);

        List<MonitrLive> list = monitrLiveMapper.findListByDay(map);
        if (list.size() > 0) {

            PadMageListPo po = new PadMageListPo();
            po.setCommId(list.get(0).getCommId());
            List<PadMageListVo> pads = padMageMapper.findList(po);

            MonitrAndPadVo vo = new MonitrAndPadVo();
            vo.setMonitrLives(list);
            vo.setPads(pads);

            poJo.setResult(vo);
        }
        return poJo;
    }*/

    /**
     * 转换BananaBdBaseInfoVo.BaseInfo.Env为MonitrLive
     *
     * @param i
     * @param eq
     * @return
     */
    /*private MonitrLive BaseInfoEnvToMonitrLive(BananaBdBaseInfoVo.BaseInfo i, EquInfoMageVo eq) {
        BananaBdBaseInfoVo.BaseInfo.Env env = i.getEnv();
        MonitrLive entity = new MonitrLive();
        entity.setEquId(eq.getId());
        //设置数据
        if (env.getTemp() != null && !"--".equals(env.getTemp())) {
            entity.setTemperature(Double.parseDouble(env.getTemp()));
        }
        if (env.getHumi() != null && !"--".equals(env.getHumi())) {
            entity.setHumidity(Double.parseDouble(env.getHumi()));
        }
        if (env.getLux() != null && !"--".equals(env.getLux())) {
            entity.setIntenIllum(Double.parseDouble(env.getLux()));
        }
        if (env.getRainfall() != null && !"--".equals(env.getRainfall())) {
            entity.setRainfall(Double.parseDouble(env.getRainfall()));
        }
//            entity.setFlFx();//无风力
        if (env.getPress() != null && !"--".equals(env.getPress())) {
            entity.setAtmPress(Double.parseDouble(env.getPress()));
        }
//            entity.setSoilTemper();//无土壤温度
//            entity.setSoilMois();//无土壤湿度
        if (env.getCo2() != null && !"--".equals(env.getCo2())) {
            entity.setCo2(Double.parseDouble(env.getCo2()));
        }
        if (env.getPh() != null && !"--".equals(env.getPh())) {
            entity.setTrPh(Double.parseDouble(env.getPh()));
        }
        if (env.getFlow() != null && !"--".equals(env.getFlow())) {
            entity.setLl(Double.parseDouble(env.getFlow()));
        }
        if (env.getWd() != null && !"--".equals(env.getWd())) {
            entity.setFx(env.getWd());
        }

        entity.preInsert();
        return entity;
    }*/

   /* @Transactional(rollbackFor = Exception.class)
    public ResultPoJo huiyunHealthCheck(String equNo) throws IOException {
        EquInfoMageVo eq = EquInfoMageMapper.findByEquipNum(equNo);
        if (eq == null) {
            return new ResultPoJo();
        }
        OffsetDateTime now = OffsetDateTime.now();
        String endDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String startDate = now.minusMinutes(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        MonitrLive monitrLive = new MonitrLive();
        monitrLive.setEquId(eq.getId());
//        空气温度:1,空气湿度:2,土壤温度:3,土壤水分:4,光照强度:5,二氧化碳:6,降雨量:7,风速:8,流量:9,风向:10,水压:11
        for (int i = 1; i <= 9; i++) {
            Optional<HuiyunGetDeviceTypeDataResponse> opt = HuiyunClient.getDeviceTypeData(i, startDate, endDate);
            if (opt.isPresent()) {
                HuiyunGetDeviceTypeDataResponse.Item item = opt.get().getItems().stream()
                        .filter(e -> e.getDataId().equals(equNo)).findFirst().get();
                switch (i) {
                    case 1:
                        monitrLive.setTemperature(Double.parseDouble(item.getDataValue()));
                        break;
                    case 2:
                        monitrLive.setHumidity(Double.parseDouble(item.getDataValue()));
                        break;
                    case 3:
                        monitrLive.setSoilTemper(Double.parseDouble(item.getDataValue()));
                        break;
                    case 4:
                        monitrLive.setSoilMois(Double.parseDouble(item.getDataValue()));
                        break;
                    case 5:
                        monitrLive.setIntenIllum(Double.parseDouble(item.getDataValue()));
                        break;
                    case 6:
                        monitrLive.setCo2(Double.parseDouble(item.getDataValue()));
                        break;
                    case 7:
                        monitrLive.setRainfall(Double.parseDouble(item.getDataValue()));
                        break;
                    case 8:
                        monitrLive.setFlFx(Double.parseDouble(item.getDataValue()));
                        break;
                    case 9:
                        monitrLive.setLl(Double.parseDouble(item.getDataValue()));
                        break;
                    case 10:
                        monitrLive.setFx(item.getDataValue());
                        break;
//                    case 11:;break;
                    default:
                        break;
                }
            }
        }
        monitrLive.preInsert();
        monitrLive.setRemarks("慧云检查");
        monitrLiveMapper.insertSelective(monitrLive);
        return new ResultPoJo();
    }*/
}

