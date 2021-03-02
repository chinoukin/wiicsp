package com.wisea.cultivar.plant.service.oritrapla;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.mss.RemoteFilesMss;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.*;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.common.vo.FileVo;
import com.wisea.cloud.common.vo.UploadVo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.oritrapla.ArchSetup;
import com.wisea.cultivar.plant.entity.oritrapla.MineArch;
import com.wisea.cultivar.plant.entity.oritrapla.RtspCodeMage;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.ArchSetupMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.MineArchMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.RtspCodeMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.utils.MembUtils;
import com.wisea.cultivar.plant.utils.RandomUtil;
import com.wisea.cultivar.plant.utils.RtspCodeUtil;
import com.wisea.cultivar.plant.vo.oritrapla.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * Auth： jirg
 * CreateDate:  2018/6/5
 * projectName:  oritrapla
 * remark:  追溯码管理Service
 */
@Service
public class RtspCodeMageService {

    @Autowired
    private RtspCodeMageMapper mapper;
    @Autowired
    private ZhfwMembInfoMapper membInfoMapper;
    @Autowired
    private ArchSetupMapper archSetupMapper;
    @Autowired
    private MineArchMapper mineArchMapper;
    @Autowired
    private ArchManageService archManageService;
    @Autowired
    private RemoteFilesMss filesMss;


    @Value("${oritrapla.qrcodeFix}")
    private String qrcodeFix;
    /**
     * 保存追溯码申请
     * @param po
     * @return
     */
    public ResultPoJo<String> saveRtspCode(RtspCodeMageSavePo po) {
        LoggerUtil.infoWithContext("【saveRtspCode】保存追溯码申请：", po);
        ResultPoJo<String> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        User user = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
            result.setCode(ConstantCodeMsg.ERR_702);
            result.setMsg(ConstantCodeMsg.MSG_702);
            LoggerUtil.infoWithContext("【saveRtspCode】操作异常：", ConstantCodeMsg.MSG_702);
            return result;
        }
        //校验我的档案状态
        MineArch mineArch = mineArchMapper.selectByPrimaryKey(po.getMineArchId());
        if(ConverterUtil.isNotEmpty(mineArch)){
            if(mineArch.getMineArchStatus().equals(DictConstants.MINE_ARCH_STATUS_0)){
                RtspCodeMage mage = new RtspCodeMage();
                BeanUtils.copyProperties(po, mage);
                mage.preInsert();
                mage.setApplyDate(OffsetDateTime.now());//设置申请时间
                mage.setBatchNum(RandomUtil.getFixLenthString(8));//设置批次编号
                mage.setMembId(user.getId());//设置所属会员
                LoggerUtil.infoWithContext("【saveRtspCode】追溯申请：", mage);
                mapper.insert(mage);
            }else{
                result.setCode(ConstantCodeMsg.ERR_118);
                result.setMsg(ConstantCodeMsg.MSG_118);
                LoggerUtil.infoWithContext("【saveRtspCode】操作异常：", ConstantCodeMsg.MSG_118);
            }
        }else{
            result.setCode(ConstantCodeMsg.ERR_117);
            result.setMsg(ConstantCodeMsg.MSG_117);
            LoggerUtil.infoWithContext("【saveRtspCode】操作异常：", ConstantCodeMsg.MSG_117);
            return result;
        }
        return result;
    }

    /**
     * 查询追溯码申请详细信息
     * @param po
     * @return
     */
    public ResultPoJo<RtspCodeMageInfoVo> findRtspCodeInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findRtspCodeInfo】查询追溯码申请详细信息：", po);
        ResultPoJo<RtspCodeMageInfoVo> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        RtspCodeMage codeMage = new RtspCodeMage();
        codeMage.setId(po.getId());
        RtspCodeMageInfoVo info = mapper.findRtspCodeInfo(codeMage);
        LoggerUtil.infoWithContext("【findRtspCodeInfo】追溯码申请详细信息：", info);
        result.setResult(info);
        if(ConverterUtil.isEmpty(info)){
            result.setCode(ConstantCodeMsg.ERR_004);
            result.setMsg(ConstantCodeMsg.MSG_004);
            LoggerUtil.infoWithContext("【findRtspCodeInfo】操作异常：", ConstantCodeMsg.MSG_004);
        }
        return result;
    }

    /**
     * 分页查询追溯码列表
     * @param po
     * @return
     */
    public ResultPoJo<Page<RtspCodeMageInfoVo>> findRtspCodeList(RtspCodeMageListPo po) {
        LoggerUtil.infoWithContext("【findRtspCodeList】分页查询追溯码列表：", po);
        ResultPoJo<Page<RtspCodeMageInfoVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        Page<RtspCodeMageInfoVo> page = po.getPage();
        User user = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
            result.setCode(ConstantCodeMsg.ERR_702);
            LoggerUtil.infoWithContext("【findRtspCodeList】user：", user, user.getId());
            result.setMsg(ConstantCodeMsg.MSG_702);
            LoggerUtil.infoWithContext("【findRtspCodeList】操作异常1：", ConstantCodeMsg.MSG_702);
            return result;
        }
        //判断是会员还是管理员
        LoginBaseInfoVo baseInfo = membInfoMapper.getBaseInfoById(user.getId());
        //App端查询，并且会员信息不为空
        if("0".equals(po.getQueryFlag()) && !SystemUtils.hasAuthor("ROLE_admin")){
            LoggerUtil.infoWithContext("【findRtspCodeList】会员查询该用户列表下所有追溯码申请列表：", user);
            po.setUserId(user.getId()); //查询该用户列表下所有追溯码申请列表
        }else if("1".equals(po.getQueryFlag()) && SystemUtils.hasAuthor("ROLE_admin")){
            //管理员查询追溯码申请列表
            po.setCreataDateStart(OffsetDateTimeUtils.getDayMinTime(po.getCreataDateStart()));
            po.setCreataDateEnd(OffsetDateTimeUtils.getDayMaxTime(po.getCreataDateEnd()));
            LoggerUtil.infoWithContext("【findRtspCodeList】管理员查询追溯码申请列表：", po);
        }else{
            result.setCode(ConstantCodeMsg.ERR_702);
            result.setMsg(ConstantCodeMsg.MSG_702);
            LoggerUtil.infoWithContext("【findRtspCodeList】操作异常2：", ConstantCodeMsg.MSG_702);
            return result;
        }
        List<RtspCodeMageInfoVo> rtspCodeList = mapper.findRtspCodeList(po);
        LoggerUtil.infoWithContext("【findRtspCodeList】追溯码列表：", rtspCodeList);
        page.setList(rtspCodeList);
        result.setResult(page);
        return result;
    }

    /**
     * 导出追溯码
     * @param po
     */
    public ResultPoJo<?> exportRtspCode(ExportRtspCodePo po){
        long timeStart = System.currentTimeMillis();
        LoggerUtil.infoWithContext("【exportRtspCode】导出追溯码：", po);
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        RtspCodeMage mage = new RtspCodeMage();
        mage.setId(po.getId());
        RtspCodeMageInfoVo info = mapper.findRtspCodeInfo(mage);
        if(ConverterUtil.isEmpty(info)){
            result.setCode(ConstantCodeMsg.ERR_004);
            result.setMsg(ConstantCodeMsg.MSG_004);
            return result;
        }

        RtspCodeMage rtspCodeMage = mapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(rtspCodeMage.getRemarks())){
            result.setResult(rtspCodeMage.getRemarks());
            return result;
        }

        try {
            long queryTime = System.currentTimeMillis();
            LoggerUtil.infoWithContext("查询用时：", (queryTime - timeStart));
            //循环生成追溯码
            List<RtspCodePdfVo> rtspCodes = RtspCodeUtil.generateRtspCodes(info, qrcodeFix);

            long generateTime = System.currentTimeMillis();
            LoggerUtil.infoWithContext("生成追溯码信息用时：", (generateTime - queryTime));

            String fileName = "{0}-{1}{2}{3}.{4}";

            //生成excel
            String excelFileName = MessageFormat.format(fileName, info.getMassifName(), info.getCommName(), ConverterUtil.isEmpty(info.getCommVarietName()) ? "" : "-".concat(info.getCommVarietName()), OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")), "xlsx");
            String filePath = "file_temp".concat(File.separator) + excelFileName ;
            File excelFile = new File(filePath);
            if(!excelFile.getParentFile().exists()){
                excelFile.getParentFile().mkdirs();
            }

            FileOutputStream excelFos = new FileOutputStream(excelFile);
            ExportExcel exportExcel = new ExportExcel("追溯码列表", RtspCodePdfVo.class);
            exportExcel.setDataList(rtspCodes).write(excelFos).dispose();
            //上传Excel至服务器
            MultipartFile excelMultipartFile = MultipartFileUtils.fileToMulitipart(excelFile);
            ResultPoJo<UploadVo> excelFileResult = filesMss.uploadFile(excelMultipartFile, false);
            //获取文件路径
            UploadVo uploadVo = excelFileResult.getResult();
            Map<String, List<FileVo>> filesMap = uploadVo.getFilesMap();
            List<FileVo> fileVos = filesMap.get("file");
            FileVo fileVo = fileVos.get(0);
            String excelPath = fileVo.getPath();

            excelFos.close();
            excelFile.delete();

            //生成PDF
            String pdfFileName = MessageFormat.format(fileName, info.getMassifName(), info.getCommName(), ConverterUtil.isEmpty(info.getCommVarietName()) ? "" : "-".concat(info.getCommVarietName()), OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")), "pdf");
            filePath = "file_temp".concat(File.separator) + pdfFileName ;
            File pdfFile = new File(filePath);
            if(!pdfFile.getParentFile().exists()){
                pdfFile.getParentFile().mkdirs();
            }

            FileOutputStream pdfFos = new FileOutputStream(pdfFile);

            Map<Object, Object> map = Maps.newHashMap();
            map.put("qrCodeList", rtspCodes);
            //导出PDF
            PdfHelper.generateToStream("qrcode.ftl", null, map, pdfFos, null);

            //上传PDF至服务器
            MultipartFile pdfMultipartFile = MultipartFileUtils.fileToMulitipart(pdfFile);
            ResultPoJo<UploadVo> pdfFileResult = filesMss.uploadFile(pdfMultipartFile, false);
            //获取文件路径
            UploadVo pdfUploadVo = pdfFileResult.getResult();
            Map<String, List<FileVo>> pdfFilesMap = pdfUploadVo.getFilesMap();
            List<FileVo> pdfFileVos = pdfFilesMap.get("file");
            FileVo pdfFileVo = pdfFileVos.get(0);
            String pdfPath = pdfFileVo.getPath();

            pdfFos.close();
            pdfFile.delete();

            //保存文件路径
            String remarks = excelPath.concat(";").concat(pdfPath); //拼接两种文件路径，保存至remarks中
            rtspCodeMage.setRemarks(remarks);
            rtspCodeMage.preUpdate();
            mapper.updateByPrimaryKeySelective(rtspCodeMage);
            result.setResult(remarks);
        } catch (Exception e) {
            result.setCode(ConstantCodeMsg.ERR_999);
            result.setMsg(ConstantCodeMsg.MSG_999);
            LoggerUtil.error("生成或上传追溯文件失败，异常信息{}", e);
        }
        return result;
    }

    /**
     * 根据批次号/追溯码 查询档案详细信息
     * @param po
     * @return
     */
    public ResultPoJo<MineArchInfoVo> findArchInfo(CheckStringPo po) {
        LoggerUtil.infoWithContext("【findArchInfo】根据批次号/追溯码 查询档案详细信息：", po);
        ResultPoJo<MineArchInfoVo> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        User user = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
            result.setCode(ConstantCodeMsg.ERR_702);
            result.setMsg(ConstantCodeMsg.MSG_702);
            LoggerUtil.infoWithContext("【findArchInfo】操作异常：", ConstantCodeMsg.MSG_702);
            return result;
        }
        String batchNum = "";
        if(po.getStr().length() == 8){
            //批次号
            batchNum = po.getStr();
        }else if(po.getStr().length() == 20){
            //追溯码，对追溯码进行奇校验
            String substring = po.getStr().substring(0, po.getStr().length() - 1);
            String binaryStr = Long.toBinaryString(Long.valueOf(substring));
            String parity = po.getStr().substring(po.getStr().length() - 1);
            if((RandomUtil.parityCheck(binaryStr) && parity.equals("0")) || (!RandomUtil.parityCheck(binaryStr) && parity.equals("1"))){
                batchNum = po.getStr().substring(0, 8);
            }else{
                //追溯码不满足奇校验
                result.setCode(ConstantCodeMsg.ERR_112);
                result.setMsg(ConstantCodeMsg.MSG_112);
                LoggerUtil.infoWithContext("【findArchInfo】操作异常：", ConstantCodeMsg.MSG_112);
                return result;
            }
        }else{
            //错误的查询码
            result.setCode(ConstantCodeMsg.ERR_111);
            result.setMsg(ConstantCodeMsg.MSG_111);
            LoggerUtil.infoWithContext("【findArchInfo】操作异常：", ConstantCodeMsg.MSG_111);
            return result;
        }
        //判断是会员还是管理员
        LoginBaseInfoVo baseInfo = membInfoMapper.getBaseInfoById(user.getId());
        if(ConverterUtil.isNotEmpty(baseInfo)){
            RtspCodeMage codeMage = new RtspCodeMage();
            codeMage.setBatchNum(batchNum);
            RtspCodeMageInfoVo rtspCodeInfo = mapper.findRtspCodeInfo(codeMage);
            List<Long> membInfoIds = Lists.newArrayList();
            membInfoIds.add(user.getId());
            //根据父级ID查询子账户IDs
            membInfoIds.addAll(membInfoMapper.findIdsByParentId(user.getId()));
            if(membInfoIds.contains(rtspCodeInfo.getMembId())){
                MineArchInfoVo mineArckInfo = archManageService.mineArckInfo(rtspCodeInfo.getMineArchId());
                result.setResult(mineArckInfo);
            }else{
                result.setCode(ConstantCodeMsg.ERR_113);
                result.setMsg(ConstantCodeMsg.MSG_113);
                LoggerUtil.infoWithContext("【findArchInfo】操作异常：", ConstantCodeMsg.MSG_113);
            }
        }else{
            result.setCode(ConstantCodeMsg.ERR_702);
            result.setMsg(ConstantCodeMsg.MSG_702);
            LoggerUtil.infoWithContext("【findArchInfo】操作异常：", ConstantCodeMsg.MSG_702);
        }
        return result;
    }

    /**
     * 消费者通过追溯二维码查询档案信息
     * @param po
     * @return
     */
    public ResultPoJo<ScanQRCodeVo> findByQRCode(CheckStringPo po) {
        LoggerUtil.infoWithContext("【findByQRCode】消费者通过追溯二维码查询档案信息：", po);
        ResultPoJo<ScanQRCodeVo> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //追溯码，对追溯码进行奇校验
        if(po.getStr().length() == 20){
            String substring = po.getStr().substring(0, po.getStr().length() - 1);
            String binaryStr = Long.toBinaryString(Long.valueOf(substring));
            String parity = po.getStr().substring(po.getStr().length() - 1);
            if((RandomUtil.parityCheck(binaryStr) && parity.equals("0")) || (!RandomUtil.parityCheck(binaryStr) && parity.equals("1"))){
                String batchNum = po.getStr().substring(0, 8);
                //消费者查询档案信息
                RtspCodeMage codeMage = new RtspCodeMage();
                codeMage.setBatchNum(batchNum);
                RtspCodeMageInfoVo rtspCodeInfo = mapper.findRtspCodeInfo(codeMage);
                LoggerUtil.infoWithContext("【findByQRCode】追溯码申请：", rtspCodeInfo);
                if(ConverterUtil.isNotEmpty(rtspCodeInfo)){
                    if(rtspCodeInfo.getMineArchStatus().equals(DictConstants.MINE_ARCH_STATUS_0) || rtspCodeInfo.getMineArchStatus().equals(DictConstants.MINE_ARCH_STATUS_2)){
                        //查询我的档案设置
                        ArchSetup archSetup = archSetupMapper.findByMineArchId(rtspCodeInfo.getMineArchId());
                        LoggerUtil.infoWithContext("【findByQRCode】档案设置：", archSetup);
                        User user = SystemUtils.getById(rtspCodeInfo.getMembId());
                        // 获取会员主体账户的ID
                        Long membId = MembUtils.getMembIdFromUser(user);
                        Map<String, Long> parameterMap = Maps.newHashMap();
                        parameterMap.put("membId", membId);
                        parameterMap.put("mineArchId", rtspCodeInfo.getMineArchId());
                        //查询档案信息
                        RtspMineArchInfoVo rtspMineArchInfoVo = mapper.findMineArchInfo(parameterMap);
                        LoggerUtil.infoWithContext("【findByQRCode】原始档案信息：", rtspMineArchInfoVo);
                        //根据我的档案设置封装需要返回的数据
                        archSetup(archSetup, rtspMineArchInfoVo);
                        ScanQRCodeVo vo = new ScanQRCodeVo();
                        vo.setArchSetup(archSetup);
                        vo.setRtspMineArchInfoVo(rtspMineArchInfoVo);
                        result.setResult(vo);
                        LoggerUtil.infoWithContext("【findByQRCode】展示档案信息：", vo);
                    }else{
                        //档案无法查看
                        result.setCode(ConstantCodeMsg.ERR_115);
                        result.setMsg(ConstantCodeMsg.MSG_115);
                        LoggerUtil.infoWithContext("【findByQRCode】查询异常：", ConstantCodeMsg.MSG_115);
                    }
                }else{
                    result.setCode(ConstantCodeMsg.ERR_114);
                    result.setMsg(ConstantCodeMsg.MSG_114);
                    LoggerUtil.infoWithContext("【findByQRCode】查询异常：", ConstantCodeMsg.MSG_114);
                }
            }else{
                //追溯码不满足奇校验
                result.setCode(ConstantCodeMsg.ERR_114);
                result.setMsg(ConstantCodeMsg.MSG_114);
                LoggerUtil.infoWithContext("【findByQRCode】查询异常：", ConstantCodeMsg.MSG_114);
            }
        }else{
            result.setCode(ConstantCodeMsg.ERR_114);
            result.setMsg(ConstantCodeMsg.MSG_114);
            LoggerUtil.infoWithContext("【findByQRCode】查询异常：", ConstantCodeMsg.MSG_114);
        }
        return result;
    }

    /**
     * 根据我的档案设置封装需要返回的数据
     * @param archSetup
     * @param vo
     */
    private void archSetup(ArchSetup archSetup, RtspMineArchInfoVo vo) {
        //是否设置对外展示档案名称
        if(DictConstants.ARCH_ED_NAME_FLAG_0.equals(archSetup.getArchEdNameFlag())){
            vo.setMineArchName(archSetup.getArchEdName());
        }else{
            vo.setMineArchName(vo.getCommName().concat(ConverterUtil.isNotEmpty(vo.getVariName()) ? "-".concat(vo.getVariName()) : ""));
        }

        //是否设置对外展示地块名
        if(DictConstants.MASSIF_ED_NAME_FLAG_0.equals(archSetup.getMassifEdNameFlag())){
            vo.setMassifName(archSetup.getMassifEdName());
        }

        //是否对外展示作物品类/品种
        if(DictConstants.CROP_ED_FLAG_1.equals(archSetup.getCropEdFlag())){
            vo.setCommName(null);
            vo.setVariName(null);
        }

        //是否对外展示种植面积
        if(DictConstants.PLANT_ACRE_ED_FLAG_1.equals(archSetup.getPlantAcreEdFlag())){
            vo.setPlantAcre(null);
        }

        //是否对外展示种植标准
        if(DictConstants.PLANT_STAND_ED_FLAG_1.equals(archSetup.getPlantStandEdFlag())){
            vo.setPlantType(null);
        }

        //是否对外展示种植开始时间
        if(DictConstants.PLANT_START_ED_FLAG_1.equals(archSetup.getPlantStartEdFlag())){
            vo.setStartDate(null);
        }

        //是否对外展示上市时间
        if(DictConstants.LIST_DATE_ED_FLAG_1.equals(archSetup.getListDateEdFlag())){
            vo.setEstListDate(null);
        }

        //是否对外展示检测信息
        if(DictConstants.EXAM_INFO_ED_FLAG_0.equals(archSetup.getExamInfoEdFlag()) && DictConstants.EXAM_INFO_TYPE_0.equals(archSetup.getExamInfoType())){
            //对外只展示最新一条检测记录
            List<ExamRecdVo> examRecdVoList = vo.getExamRecdVoList();
            if(ConverterUtil.isNotEmpty(examRecdVoList) && examRecdVoList.size() > 1){
                ExamRecdVo examRecdVo = examRecdVoList.get(0);
                examRecdVoList.removeAll(examRecdVoList);
                examRecdVoList.add(examRecdVo);
                vo.setExamRecdVoList(examRecdVoList);
            }
        }

    }

    /**
     * 根据批次编号查询档案详细信息（追溯列表档案预览）
     * @param po
     * @return
     */
    public ResultPoJo<ScanQRCodeVo> findArchByBatchNum(CheckStringPo po) {
        LoggerUtil.infoWithContext("【findArchByBatchNum】根据批次编号查询档案详细信息（追溯列表档案预览）：", po);
        ResultPoJo<ScanQRCodeVo> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        if(po.getStr().length() == 8){
            //封装追溯码
            String rtspCodeTemplate = "{0}{1}{2}";
            String suffix0 = "0";
            String suffix1 = "1";
            //追溯码规则：8位批次编号 + 7位自增数 + 4位随机数 + 1位奇校验码（前面19位数字的二进制数中1的个数为奇数时为0否则为1）
            String format = MessageFormat.format(rtspCodeTemplate, po.getStr(), String.format("%07d", 1), RandomUtil.getFixLenthString(4));
            //奇校验
            String binaryStr = Long.toBinaryString(Long.valueOf(format));
            String rtspCode = format.concat(RandomUtil.parityCheck(binaryStr) ? suffix0 : suffix1); //前面19位数字的二进制数中1的个数为奇数时补0否则补1
            po.setStr(rtspCode);
            LoggerUtil.infoWithContext("【findArchByBatchNum】封装追溯码：", rtspCode);
            return findByQRCode(po);
        }else{
            //批次编号不正确
            result.setCode(ConstantCodeMsg.ERR_116);
            result.setMsg(ConstantCodeMsg.MSG_116);
            LoggerUtil.infoWithContext("【findArchByBatchNum】查询异常：", ConstantCodeMsg.MSG_116);
        }
        return result;
    }

    /**
     * 平台追溯监管
     * @param po
     * @return
     */
    public ResultPoJo<ArchInfoCirculationVo> findArchInfoCirculation(CheckStringPo po) {
        LoggerUtil.infoWithContext("【findArchInfoCirculation】平台追溯监管：", po);
        ResultPoJo<ArchInfoCirculationVo> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //追溯码，对追溯码进行奇校验
        if(po.getStr().length() == 20){
            String substring = po.getStr().substring(0, po.getStr().length() - 1);
            String binaryStr = Long.toBinaryString(Long.valueOf(substring));
            String parity = po.getStr().substring(po.getStr().length() - 1);
            if((RandomUtil.parityCheck(binaryStr) && parity.equals("0")) || (!RandomUtil.parityCheck(binaryStr) && parity.equals("1"))){
                String batchNum = po.getStr().substring(0, 8);
                //消费者查询档案信息
                RtspCodeMage codeMage = new RtspCodeMage();
                codeMage.setBatchNum(batchNum);
                RtspCodeMageInfoVo rtspCodeInfo = mapper.findRtspCodeInfo(codeMage);
                LoggerUtil.infoWithContext("【findArchInfoCirculation】追溯申请：", rtspCodeInfo);
                if(ConverterUtil.isNotEmpty(rtspCodeInfo)){
                    ArchInfoCirculationVo vo = mapper.findArchInfoCirculation(rtspCodeInfo.getArchId());
                    LoggerUtil.infoWithContext("【findArchInfoCirculation】档案流转：", vo);
                    result.setResult(vo);
                }else{
                    result.setCode(ConstantCodeMsg.ERR_114);
                    result.setMsg(ConstantCodeMsg.MSG_114);
                    LoggerUtil.infoWithContext("【findArchInfoCirculation】查询异常：", ConstantCodeMsg.MSG_114);
                }
            }else{
                //追溯码不满足奇校验
                result.setCode(ConstantCodeMsg.ERR_114);
                result.setMsg(ConstantCodeMsg.MSG_114);
                LoggerUtil.infoWithContext("【findArchInfoCirculation】查询异常：", ConstantCodeMsg.MSG_114);
            }
        }else{
            result.setCode(ConstantCodeMsg.ERR_114);
            result.setMsg(ConstantCodeMsg.MSG_114);
            LoggerUtil.infoWithContext("【findArchInfoCirculation】查询异常：", ConstantCodeMsg.MSG_114);
        }
        return result;
    }

    /**
     * 后台 - 平台追溯监管 - 档案预览
     * @param po
     * @return
     */
    public ResultPoJo<ScanQRCodeVo> findArchByMineArchId(LongIdPo po) {
        LoggerUtil.infoWithContext("【findArchByMineArchId】后台 - 平台追溯监管 - 档案预览：", po);
        ResultPoJo<ScanQRCodeVo> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        MineArch mineArch = mineArchMapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(mineArch)){
            //查询我的档案设置
            ArchSetup archSetup = archSetupMapper.findByMineArchId(po.getId());
            LoggerUtil.infoWithContext("【findArchByMineArchId】档案设置：", archSetup);
            User user = SystemUtils.getById(mineArch.getMembId());
            // 获取会员主体账户的ID
            Long membId = MembUtils.getMembIdFromUser(user);
            Map<String, Long> parameterMap = Maps.newHashMap();
            parameterMap.put("membId", membId);
            parameterMap.put("mineArchId", po.getId());
            //查询档案信息
            RtspMineArchInfoVo rtspMineArchInfoVo = mapper.findMineArchInfo(parameterMap);
            LoggerUtil.infoWithContext("【findArchByMineArchId】档案信息：", rtspMineArchInfoVo);
            //根据我的档案设置封装需要返回的数据
            archSetup(archSetup, rtspMineArchInfoVo);
            ScanQRCodeVo vo = new ScanQRCodeVo();
            vo.setArchSetup(archSetup);
            vo.setRtspMineArchInfoVo(rtspMineArchInfoVo);
            result.setResult(vo);
        }else{
            result.setCode(ConstantCodeMsg.ERR_004);
            result.setMsg(ConstantCodeMsg.MSG_004);
            LoggerUtil.infoWithContext("【findArchByMineArchId】查询异常：", ConstantCodeMsg.MSG_004);
        }
        return result;
    }
}
