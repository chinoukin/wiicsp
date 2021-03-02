package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.entity.oritrapla.PadYjInfo;
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
public class PadYjInfoService extends BaseService {

    @Autowired
    private PadYjInfoMapper padYjInfoMapper;

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
     * @author jirg
     * @date 2020/9/3 14:05
     * @Description 查询病虫害列表（前20条）
     */
    public ResultPoJo<List<PadYjInfoListVo>> findPestWarning() {
        LoggerUtil.infoWithContext("【findDemonsBaseEquArch】查询示范基地设备/档案列表：", "");
        ResultPoJo<List<PadYjInfoListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        List<PadYjInfoListVo> list = padYjInfoMapper.findPestWarning();
        resultPoJo.setResult(list);
        return resultPoJo;
    }
}

