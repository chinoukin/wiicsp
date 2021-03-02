package com.wisea.cultivar.plant.service.oritrapla;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.SystemCacheService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.RequestContextUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.mapper.oritrapla.ExamRecdRelaMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.FarmWorkRecdMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.MassifMageMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.PadYjInfoMapper;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.utils.ExcelUtil;
import com.wisea.cultivar.plant.utils.OffsetDateTimeUtils;
import com.wisea.cultivar.plant.vo.oritrapla.*;
import com.wisea.cultivar.plant.vo.oritrapla.mss.ArchInfo;
import com.wisea.cultivar.plant.vo.oritrapla.mss.DemonsBaseEquArchVo;
import com.wisea.cultivar.plant.vo.oritrapla.mss.DetailedRecordVo;
import com.wisea.cultivar.plant.vo.oritrapla.mss.EquInfo;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author wzx
 * <p>
 * web 地块信息列表Service
 * TODO 保留
 */
@Service
public class MassifMageService {

    @Autowired
    private MassifMageMapper mapper;
    @Autowired
    private ExamRecdRelaMapper examRecdRelaMapper;
    @Autowired
    private FarmWorkRecdMapper farmWorkRecdMapper;
    @Autowired
    private PadYjInfoMapper padYjInfoMapper;
    @Autowired
    private SystemCacheService cacheService;


    private static JedisDao jedisDao;
    public final static String cacheKey = "SETTLE_MASSIF_LIST_CACHE_KEY_";

    /**
     * 查询地块信息列表
     *
     * @param po
     * @return
     */
    public ResultPoJo<Page<WebMassifMageVo>> findListPage(WebMassifMageListPo po) {
        ResultPoJo<Page<WebMassifMageVo>> result = new ResultPoJo<Page<WebMassifMageVo>>(ConstantCodeMsg.NOMAL);

        Page<WebMassifMageVo> page = po.getPage();

        // 当前登录的用户信息
        User user = SystemUtils.getUser();
        if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
            result.setCode(ConstantCodeMsg.ERR_702);
            result.setMsg(ConstantCodeMsg.MSG_702);
            return result;
        }
        //将查询参数缓存，导出Excel时取出（过期时间 10分钟）
        String cacheId = UUID.randomUUID().toString().replaceAll("-", "");
        if (ConverterUtil.isEmpty(jedisDao)) {
            jedisDao = SpringBootContext.getBean(JedisDao.class);
        }
        po.setCreateStaDate(OffsetDateTimeUtils.getDayMinTime(po.getCreateStaDate()));
        po.setCreateEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getCreateEndDate()));
        po.setUpdateEndDate(OffsetDateTimeUtils.getDayMinTime(po.getUpdateStaDate()));
        po.setUpdateEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getUpdateEndDate()));

        jedisDao.setSerializeExpire(cacheKey.concat(cacheId), po, 10 * 60);
        result.setMsg(cacheId);
        page.setList(mapper.findMassifMageListPage(po));
        result.setResult(page);
        if (ConverterUtil.isEmpty(jedisDao)) {
            jedisDao = SpringBootContext.getBean(JedisDao.class);
        }
        return result;
    }

    /**
     * 导出地块信息的操作（未用）
     *
     * @param po
     * @param response
     * @throws Exception
     */
    public void exportMassifList(WebMassifMageListPo po, HttpServletResponse response) throws Exception {
        try {

            // 当前登录的用户信息
            User user = SystemUtils.getUser();
            if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
                response.addHeader("Access-Control-Expose-Headers", "error_code, error_msg");
                response.setHeader("error_code", ConstantCodeMsg.ERR_702);
                response.setHeader("error_msg", URLEncoder.encode(ConstantCodeMsg.MSG_702, "utf-8"));
                return;
            }
            // 查询导出数据
            List<WebMassifMageVo> data = mapper.findMassifMageListPage(po);
            String fileName = "{0}{1}.{2}";
            fileName = MessageFormat.format(fileName, "地块信息", OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "xls");
            response.reset();
            response.setContentType("application/octet-stream; charset=utf-8");
            response.addHeader("Access-Control-Expose-Headers", "ajax-mimeType, ajax-filename");
            OutputStream outputStream = response.getOutputStream();
            ServletContext context = RequestContextUtils.getCurrentRequest().getServletContext();
            String mimeType = context.getMimeType(fileName);
            String fName = ConverterUtil.toDownloadName(URLEncoder.encode(fileName, "utf-8"));
            response.setHeader("Content-Disposition", "attachment; filename=" + fName);
            response.setHeader("ajax-mimeType", mimeType);
            response.setHeader("ajax-filename", fName);
            response.setContentType(mimeType);

            DecimalFormat df = new DecimalFormat("#.##");

            List<String> rowMerge = Lists.newArrayList();
            rowMerge.add("序号");
            rowMerge.add("地块名称");
            rowMerge.add("地块类型");
            rowMerge.add("面积（亩）");
            rowMerge.add("主体名称");
            rowMerge.add("创建人");
            rowMerge.add("创建时间");
            rowMerge.add("更新人");
            rowMerge.add("更新时间");
            ExcelUtil excelUtil = new ExcelUtil();
            excelUtil.getTableTitle(rowMerge);
            final Integer[] index = {0};
            data.forEach(e -> {
                Integer cellIndex = 0;
                Row dataRow = excelUtil.addRow();

                excelUtil.setCellValue(dataRow, cellIndex++, ++index[0], "data");
                excelUtil.setCellValue(dataRow, cellIndex++, e.getMassifName(), "data");
                excelUtil.setCellValue(dataRow, cellIndex++, cacheService.getDictLabel(e.getMassifType(), "massif_type", ""), "data");
                excelUtil.setCellValue(dataRow, cellIndex++, df.format(e.getMassifAcre()), "data");
                excelUtil.setCellValue(dataRow, cellIndex++, e.getOrgName(), "data");
                excelUtil.setCellValue(dataRow, cellIndex++, e.getCreateName(), "data");
                excelUtil.setCellValue(dataRow, cellIndex++, OffsetDateTimeUtils.formatDateTimeToYmdhms(e.getCreateDate()), "data");
                excelUtil.setCellValue(dataRow, cellIndex++, e.getUpdateName(), "data");
                excelUtil.setCellValue(dataRow, cellIndex++, OffsetDateTimeUtils.formatDateTimeToYmdhms(e.getUpdateDate()), "data");

            });
            excelUtil.getWb().write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
            response.addHeader("Access-Control-Expose-Headers", "error_code, error_msg");
            response.setHeader("error_code", ConstantCodeMsg.ERR_110);
            response.setHeader("error_msg", URLEncoder.encode(ConstantCodeMsg.MSG_110, "utf-8"));
        }

    }

    /**
     * @author jirg
     * @date 2020/8/14 16:23
     * @Description 所有地块关联列表 - 提供【资源管理系统】使用
     */
    public ResultPoJo<List<MassifRelatedVo>> massifRelatedList(StringPo po) {
        LoggerUtil.infoWithContext("【massifRelatedList】所有地块关联列表", po);
        ResultPoJo<List<MassifRelatedVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<MassifRelatedVo> list = mapper.findMassifRelatedList(po);
        result.setResult(list);
        return result;
    }

    /**
     * @author jirg
     * @date 2020/9/3 10:30
     * @Description 查询地块关联的设备/档案列表
     */
    public ResultPoJo<DemonsBaseEquArchVo> findEquArchByMassifIds(List<Long> po) {
        LoggerUtil.infoWithContext("【findEquArchByMassifIds】查询地块关联的设备/档案列表", po);
        ResultPoJo<DemonsBaseEquArchVo> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        DemonsBaseEquArchVo vo = new DemonsBaseEquArchVo();
        //查询设备列表
        List<EquInfo> equInfos = mapper.findEquByMassifIds(po);
        //查询档案列表
        List<ArchInfo> archInfos = mapper.findArchByMassifIds(po);
        vo.setEquInfos(equInfos);
        vo.setArchInfos(archInfos);
        result.setResult(vo);
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/7/19 16:31
     * @Description 查询详细记录
     **/
    public ResultPoJo<DetailedRecordVo> detailedRecord(LongIdPo po) {
        ResultPoJo<DetailedRecordVo> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        DetailedRecordVo vo = mapper.detailedRecord(po);

        if (ConverterUtil.isNotEmpty(vo)) {
            //获取检测记录列表
            ExamRecdRelaKeyVo examRecdRelaKey = new ExamRecdRelaKeyVo();
            examRecdRelaKey.setMineArchId(vo.getMineArchId());
            examRecdRelaKey.setFlag("0");
            List<ExamRecdVo> examRecdVos = examRecdRelaMapper.examRecdList(examRecdRelaKey);
            vo.setExamRecdVos(examRecdVos);

            //获取农事记录列表
            FarmWorkSelPo farmWorkSelPo = new FarmWorkSelPo();
            farmWorkSelPo.setId(po.getId());
            List<FarmWorkRecdVo> farmWorkRecdVos = farmWorkRecdMapper.findListByArchId(farmWorkSelPo);
            //已完成的农事记录
            List<FarmWorkRecdVo> collect = farmWorkRecdVos.stream().filter(e -> {
                return DictConstants.RECORD_STATUS_1.equals(e.getRecordStatus());
            }).collect(Collectors.toList());
            vo.setFarmWorkRecdVos(collect);

            //封装统计数据
            Map<String, List<FarmWorkRecdVo>> map = farmWorkRecdVos.stream()
                    .filter(i -> (i.getRecordStatus().equals("1") || i.getRecordStatus().equals("2")))
                    .collect(groupingBy(FarmWorkRecdVo::getRecordStatus));

            if (map.get("1") != null) {
                vo.setCompletedFarmWorkRecdCount(map.get("1").size());
            } else {
                vo.setCompletedFarmWorkRecdCount(0);
            }
            if (map.get("2") != null) {
                vo.setPendingFarmWorkRecdCount(map.get("2").size());
            } else {
                vo.setPendingFarmWorkRecdCount(0);
            }
            vo.setFarmWorkRecdCount(vo.getCompletedFarmWorkRecdCount()+vo.getPendingFarmWorkRecdCount());

            //查询预警信息
            List<PadYjInfoListVo> list = padYjInfoMapper.find2ByArchId(po.getId());
            vo.setPadYjInfoListVos(list);
            result.setResult(vo);
        } else {
            result.setCode(ConstantCodeMsg.ERR_004);
            result.setMsg(ConstantCodeMsg.MSG_004);
        }
        return result;
    }
}
