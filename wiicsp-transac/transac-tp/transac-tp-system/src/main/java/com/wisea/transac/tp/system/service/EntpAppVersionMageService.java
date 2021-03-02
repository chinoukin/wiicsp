package com.wisea.transac.tp.system.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.BaseException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.dao.EntpAppVersionMageMapper;
import com.wisea.transac.common.entity.EntpAppVersionMage;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.po.AppVersionPo;
import com.wisea.transac.common.po.EntpAppVersionMagePageListPo;
import com.wisea.transac.common.po.EntpAppVersionMagePo;
import com.wisea.transac.common.po.LastVersionPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.EntpAppVersionMageInfoVo;
import com.wisea.transac.common.vo.EntpAppVersionMagePageListVo;
import com.wisea.transac.common.vo.VersionMageVo;
import com.wisea.transac.common.vo.VersionResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className EntpAppVersionMageService
 * @date 2020/05/11 13:38:11
 * @Description
 */
@Service
public class EntpAppVersionMageService extends BaseService {
    @Autowired
    private EntpAppVersionMageMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 分页查询EntpAppVersionMage
     */
    public ResultPoJo<Page<EntpAppVersionMagePageListVo>> findPageList(EntpAppVersionMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<EntpAppVersionMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<EntpAppVersionMagePageListVo> page = po.getPage();
        List<EntpAppVersionMagePageListVo> list = mapper.findPageList(po);
        list.forEach(i -> {
            MembBaseInfo baseInfo = MembUtils.getMembInfoByUserId(Long.parseLong(i.getUpdateBy()));
            i.setUpdateBy(baseInfo.getLoginName());
        });
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 逻辑删除EntpAppVersionMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EntpAppVersionMage entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(EntpAppVersionMage.DEL_FLAG_DELETE);
            entity.preUpdate();
            mapper.updateByPrimaryKey(entity);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    public static void main(String[] args) {

    }

    /**
     * 检查字符串你能不能转换成数值
     * @param str
     * @return
     */
    private boolean isNumber(String str) {
        try {
            double v = Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 新增或修改EntpAppVersionMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(EntpAppVersionMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //
        if (!isNumber(po.getVersionNum())) {
            throw new BaseException("999", "版本号必须是数值");
        }

        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            EntpAppVersionMage entity = mapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(entity)) {
                //如果当前最新的版本号大于或等于当前po的，则返回
                if (Double.parseDouble(entity.getVersionNum()) >= Double.parseDouble(po.getVersionNum())) {
                    throw new BaseException("999", "输入的版本号不能比现在最新版本号低");
                }
                BeanUtils.copyProperties(po, entity);
                entity.preUpdate();
                mapper.updateByPrimaryKeySelective(entity);
            } else {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        } else {
            AppVersionPo appVersionPo = new AppVersionPo();
            appVersionPo.setSourceType(po.getSourceType());
            appVersionPo.setAppVersionType(po.getAppVersionType());
            EntpAppVersionMageInfoVo latest = mapper.findLatest(appVersionPo);

            //如果当前最新的版本号大于或等于当前po的，则返回
            if (latest!=null) {
                if (Double.parseDouble(latest.getVersionNum()) >= Double.parseDouble(po.getVersionNum())) {
                    throw new BaseException("999", "输入的版本号不能比现在最新版本号低");
                }
            }

            //新增
            EntpAppVersionMage entity = new EntpAppVersionMage();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            mapper.insert(entity);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 查询详细信息EntpAppVersionMage
     */
    public ResultPoJo<EntpAppVersionMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<EntpAppVersionMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EntpAppVersionMageInfoVo vo = mapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            MembBaseInfo baseInfo = MembUtils.getMembInfoByUserId(Long.parseLong(vo.getUpdateBy()));
            vo.setUpdateBy(baseInfo.getLoginName());
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    public ResultPoJo<EntpAppVersionMageInfoVo> findLatest(AppVersionPo po) {
        ResultPoJo<EntpAppVersionMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EntpAppVersionMageInfoVo vo = mapper.findLatest(po);
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 获取最新版本信息
     */
    public VersionResultVo latest(LastVersionPo latestPo) {
        AppVersionPo appVersionPo = new AppVersionPo();
        appVersionPo.setSourceType(latestPo.getSourceType());
        if (Objects.equals("1101", latestPo.getType())) {
            appVersionPo.setAppVersionType("0");
        }else {
            appVersionPo.setAppVersionType("1");
        }
        EntpAppVersionMageInfoVo vo = mapper.findLatest(appVersionPo);
        if (Objects.isNull(vo)) {
            return new VersionResultVo("200", null);
        }
        //对比版本号，版本号一样就不进行更新
        int i = compareVersion(vo.getVersionNum(), latestPo.getVersionCode());
        if (i <= 0) {
            return new VersionResultVo("200", null);
        }
        VersionMageVo versionMageVo = new VersionMageVo();
        versionMageVo.setDownloadUrl(vo.getUpdateUrl());
        versionMageVo.setVersionCode(vo.getVersionNum());
        versionMageVo.setId(vo.getId());
        versionMageVo.setVersionName(vo.getAppVersionName());
        versionMageVo.setVersionInfo(vo.getUpdateContent());
        versionMageVo.setForceUpdate(Objects.equals(Optional.ofNullable(vo.getIfDisplayType()).orElse("0"), "0"));
        versionMageVo.setVersionType(latestPo.getType());
        versionMageVo.setSourceType(vo.getSourceType());
        return new VersionResultVo("200", versionMageVo);
    }

    /**
     * 版本号比较
     * @param v1 新版本
     * @param v2 原版本
     * @return 1-新版比原版大 0-版本号相同 -1新版比原版小
     */
    public int compareVersion(String v1, String v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        String[] version1Array = v1.split("[._]");
        String[] version2Array = v2.split("[._]");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;

        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }
}
