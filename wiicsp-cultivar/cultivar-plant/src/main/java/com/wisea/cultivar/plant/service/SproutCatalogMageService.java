package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.mapper.OilTeaVarietMageMapper;
import com.wisea.cultivar.plant.mapper.SproutCatalogMageMapper;
import com.wisea.cultivar.plant.mapper.SproutEntpMapper;
import com.wisea.cultivar.plant.mapper.SysAreaMapper;
import com.wisea.cultivar.plant.po.OilTeaVarietMagePageListPo;
import com.wisea.cultivar.plant.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SproutCatalogMageService
 * @date 2020/08/07 10:13:35
 * @Description
 */
@Service
public class SproutCatalogMageService extends BaseService {
    @Autowired
    private SproutCatalogMageMapper mapper;

	@Autowired
	private SproutEntpMapper sproutEntpMapper;

    @Autowired
    private OilTeaVarietMageMapper oilTeaVarietMageMapper;

    @Autowired
    private SysAreaMapper sysAreaMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/08/07 10:13:35
     * @Description 分页查询SproutCatalogMage
     */
    @Transactional
    public ResultPoJo<SproutCatalogMageAndEntpVo> findPageList(OilTeaVarietMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<SproutCatalogMageAndEntpVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SproutCatalogMageAndEntpVo mageAndEntpVo = new SproutCatalogMageAndEntpVo();
		Page<OilTeaVarietMagePageListVo> page = po.getPage();
		//获取年份
		//获取种苗目录
        SproutCatalogMageInfoVo list = mapper.findByYear();
        //获取种苗目录品种
        List<OilTeaVarietMagePageListVo> oilList = mapper.findOilPageList(list.getSproutYear());
		//获取种苗定点采购企业
        List<ZhfwMembInfoInfoVo> pageList = sproutEntpMapper.findPageList();
        //获取地区名称
        pageList.stream().forEach(zhfwMembInfoInfoVo -> {
            AreaSSQVo areaSSQVo = sysAreaMapper.findSSQ(zhfwMembInfoInfoVo);
            Optional.ofNullable(areaSSQVo).ifPresent(a->{
                BeanUtils.copyProperties(a,zhfwMembInfoInfoVo);
            });
        });

        page.setList(oilList);
        mageAndEntpVo.setCatalogMagePageListVoPage(list);
        mageAndEntpVo.setOilTeaVarietMagePageListVoPage(page);
        mageAndEntpVo.setEntpPageListVoPage(pageList);
        resultPoJo.setResult(mageAndEntpVo);
		return resultPoJo;
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/07 10:13:35
     * @Description 查询详细信息SproutCatalogMage
     */
    @Transactional(readOnly = false)
    public ResultPoJo<OilTeaVarietMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<OilTeaVarietMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        OilTeaVarietMageInfoVo vo = oilTeaVarietMageMapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
}
