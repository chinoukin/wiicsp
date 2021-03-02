package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.oritrapla.FarmWorkTypeDict;
import com.wisea.cultivar.plant.entity.oritrapla.FarmWorkTypeDictVo;
import com.wisea.cultivar.plant.mapper.oritrapla.FarmWorkTypeDictMapper;
import com.wisea.cultivar.plant.po.oritrapla.FarmDictPo;
import com.wisea.cultivar.plant.po.oritrapla.FarmWorkDictPo;
import com.wisea.cultivar.plant.po.oritrapla.FarmWorkTypeDictPo;
import com.wisea.cultivar.plant.utils.OffsetDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 农事类型操作service
 * @author: wangs
 * @date :2018/6/21
 */
@Service
@Transactional(readOnly = true)
public class AgriculturalTypeService extends BaseService {

    @Autowired
    FarmWorkTypeDictMapper farmWorkTypeDictMapper;

    /**
     * 分页查询农事类型信息
     *
     * @param farmWorkTypeDictPo
     * @return
     */
    public ResultPoJo<Page<FarmWorkTypeDictVo>> agriculturalTypeFindListPage(FarmWorkTypeDictPo farmWorkTypeDictPo) {

        ResultPoJo poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        Page<FarmWorkTypeDictVo> page = farmWorkTypeDictPo.getPage();

        farmWorkTypeDictPo.setUpdStaDate(OffsetDateTimeUtils.getDayMinTime(farmWorkTypeDictPo.getUpdStaDate()));
        farmWorkTypeDictPo.setUpdEndDate(OffsetDateTimeUtils.getDayMaxTime(farmWorkTypeDictPo.getUpdEndDate()));
        // 查询农事类型列表
        List<FarmWorkTypeDictVo> list = null;
        try {
            list = farmWorkTypeDictMapper.findListPage(farmWorkTypeDictPo);
        } catch (Exception e) {
            poJo.setCode(ConstantCodeMsg.ERR_410);
            poJo.setMsg(ConstantCodeMsg.MSG_410);
        }
        page.setList(list);
        poJo.setResult(page);

        return poJo;
    }

    /**
     * 将农事类型分类保存到数据库
     *
     * @param farmWorkDictPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo agriculturalTypeAdd(FarmWorkDictPo farmWorkDictPo) {
        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        FarmWorkTypeDict farmWorkTypeDict = new FarmWorkTypeDict();
        // 由于前端新增一级和二级使用的是一个页面,不能保证新增一级农事记录时parentId为null.做手动处理
        if (farmWorkDictPo.getFarmWorkType().equals(DictConstants.FARM_WORK_TYPE_0)) {
            // 一级分类时 排除 parentId属性
            ConverterUtil.copyProperties(farmWorkDictPo, farmWorkTypeDict, "parentId");
        } else {
            ConverterUtil.copyProperties(farmWorkDictPo, farmWorkTypeDict);
        }
        farmWorkTypeDict.preInsert();
        farmWorkTypeDict.preUpdate();

        // 将农事类型分类保存到数据库
        int i = 0;
        try {
            i = farmWorkTypeDictMapper.insertSelective(farmWorkTypeDict);
        } catch (Exception e) {
            poJo.setCode(ConstantCodeMsg.ERR_411);
            poJo.setMsg(ConstantCodeMsg.MSG_411);
        }
        return poJo;
    }

    /**
     * 修改农事记录
     *
     * @param farmWorkDictPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo agriculturalTypeUpdate(FarmWorkDictPo farmWorkDictPo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        FarmWorkTypeDict workTypeDict = farmWorkTypeDictMapper.selectByPrimaryKey(farmWorkDictPo.getId());
        // 排他校验
        if (!farmWorkDictPo.getUpdateDate().equals(workTypeDict.getUpdateDate())) {
            poJo.setCode(ConstantError.ERR_009);
            poJo.setMsg(ConstantError.MSG_009);
            return poJo;
        }

        FarmWorkTypeDict farmWorkTypeDict = new FarmWorkTypeDict();

        ConverterUtil.copyProperties(farmWorkDictPo, farmWorkTypeDict);

        farmWorkTypeDict.preUpdate();

        // 修改农事类型分类
        farmWorkTypeDictMapper.updateByPrimaryKeySelective(farmWorkTypeDict);

        return poJo;
    }

    /**
     * 农事类型详情
     *
     * @param farmDictPo
     * @return
     */
    public ResultPoJo<FarmWorkTypeDict> agriculturalTypeDeatail(FarmDictPo farmDictPo) {

        ResultPoJo<FarmWorkTypeDict> poJo = new ResultPoJo<>(ConstantError.NOMAL);

        FarmWorkTypeDict farmWorkTypeDict = null;
        try {
            farmWorkTypeDict = farmWorkTypeDictMapper.selectByPrimaryKey(farmDictPo.getId());
        } catch (Exception e) {
            poJo.setMsg(ConstantCodeMsg.MSG_412);
            poJo.setCode(ConstantCodeMsg.ERR_412);
        }

        poJo.setResult(farmWorkTypeDict);

        return poJo;
    }

    /**
     * 删除农事类型信息
     *
     * @param farmDictPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> agriculturalTypeDelete(FarmDictPo farmDictPo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        FarmWorkTypeDict farmWorkTypeDict = new FarmWorkTypeDict();
        farmWorkTypeDict.setId(farmDictPo.getId());

        // 根据农事类型id 查询parentId的count(不为0:说明有引用不能删)
        int parentIdCount = farmWorkTypeDictMapper.selectParentIdCount(farmWorkTypeDict.getId());
        if (parentIdCount != 0) {

            poJo.setCode(ConstantCodeMsg.ERR_413);
            poJo.setMsg(ConstantCodeMsg.MSG_413);

        } else {

            farmWorkTypeDict.setDelFlag("1");
            farmWorkTypeDict.preUpdate();
            farmWorkTypeDictMapper.updateByPrimaryKeySelective(farmWorkTypeDict);
        }

        return poJo;
    }

    /**
     * 查询一级分类
     *
     * @return
     */
    public ResultPoJo<List<FarmWorkTypeDict>> findOnDegreeList() {

        ResultPoJo poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        List<FarmWorkTypeDict> farmWorkTypeDictList = farmWorkTypeDictMapper.findOnDegreeList();

        poJo.setResult(farmWorkTypeDictList);

        return poJo;
    }
}
