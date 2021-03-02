package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.entity.oritrapla.VersionInfoMage;
import com.wisea.cultivar.plant.mapper.oritrapla.VersionInfoMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.FarmDictPo;
import com.wisea.cultivar.plant.utils.OffsetDateTimeUtils;
import com.wisea.cultivar.plant.po.oritrapla.VersionInfoMagePo;
import com.wisea.cultivar.plant.po.oritrapla.VersionInfoPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 系统版本service层
 * @author: wangs
 * @date :2018/6/22
 * TODO 保留
 */
@Service
@Transactional(readOnly = true)
public class SystemVersionService {

    @Autowired
    VersionInfoMageMapper versionInfoMageMapper;

    /**
     * 系统版本列表查询
     *
     * @param versionInfoMagePo
     * @return
     */
    public ResultPoJo<Page<VersionInfoMage>> systemVersionFindListPage(VersionInfoMagePo versionInfoMagePo) {

        ResultPoJo poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        Page<VersionInfoMage> page = versionInfoMagePo.getPage();

        versionInfoMagePo.setUpdStaDate(OffsetDateTimeUtils.getDayMinTime(versionInfoMagePo.getUpdStaDate()));
        versionInfoMagePo.setUpdEndDate(OffsetDateTimeUtils.getDayMaxTime(versionInfoMagePo.getUpdEndDate()));

        // 查询系统版本列表
        List<VersionInfoMage> list = null;
        try {
            list = versionInfoMageMapper.findListPage(versionInfoMagePo);
        } catch (Exception e) {
            poJo.setCode(ConstantCodeMsg.ERR_510);
            poJo.setMsg(ConstantCodeMsg.MSG_510);
        }
        page.setList(list);
        poJo.setResult(page);

        return poJo;
    }

    /**
     * 新增系统版本
     *
     * @param versionInfoPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo systemVersionAdd(VersionInfoPo versionInfoPo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        VersionInfoMage versionInfoMage = new VersionInfoMage();

        ConverterUtil.copyProperties(versionInfoPo, versionInfoMage);

        versionInfoMage.preInsert();
        versionInfoMage.preUpdate();

        // 将公告信息保存到数据库
        int i = 0;
        try {
            i = versionInfoMageMapper.insert(versionInfoMage);
        } catch (Exception e) {
            poJo.setCode(ConstantCodeMsg.ERR_512);
            poJo.setMsg(ConstantCodeMsg.MSG_512);
        }

        return poJo;
    }

    /**
     * 修改系统版本
     * @param versionInfoPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo systemVersionUpdate(VersionInfoPo versionInfoPo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        VersionInfoMage versionInfoMage = versionInfoMageMapper.selectByPrimaryKey(versionInfoPo.getId());
        // 排他校验
        if (!versionInfoPo.getUpdateDate().equals(versionInfoMage.getUpdateDate())) {
            poJo.setCode(ConstantError.ERR_009);
            poJo.setMsg(ConstantError.MSG_009);
            return poJo;
        }

        VersionInfoMage farmWorTypeDict = new VersionInfoMage();

        ConverterUtil.copyProperties(versionInfoPo, farmWorTypeDict);

        farmWorTypeDict.preUpdate();

        // 修改农事类型分类
        versionInfoMageMapper.updateByPrimaryKeySelective(farmWorTypeDict);

        return poJo;
    }

    /**
     * 系统版本详情
     * @param farmDictPo
     * @return
     */
    public ResultPoJo<VersionInfoMage> systemVersionDeatail(FarmDictPo farmDictPo) {

        ResultPoJo<VersionInfoMage> poJo = new ResultPoJo<>(ConstantError.NOMAL);

        VersionInfoMage versionInfoMage = null;
        try {
            versionInfoMage = versionInfoMageMapper.selectByPrimaryKey(farmDictPo.getId());
            /// 标识信息(传递参数是校验信息使用,无其他用途)
            versionInfoMage.setIsSaveOrUpdate("1");
        } catch (Exception e) {
            poJo.setMsg(ConstantCodeMsg.MSG_513);
            poJo.setCode(ConstantCodeMsg.ERR_513);
        }

        poJo.setResult(versionInfoMage);

        return poJo;
    }

    /**
     * 删除系统版本
     * @param farmDictPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo systemVersionDelete(FarmDictPo farmDictPo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        VersionInfoMage versionInfoMage = new VersionInfoMage();
        versionInfoMage.setId(farmDictPo.getId());
        versionInfoMage.setDelFlag("1");
        versionInfoMage.preUpdate();

        versionInfoMageMapper.updateByPrimaryKeySelective(versionInfoMage);
        return poJo;
    }
}
