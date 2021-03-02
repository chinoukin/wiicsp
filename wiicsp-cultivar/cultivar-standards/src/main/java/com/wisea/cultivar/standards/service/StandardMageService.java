package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.standards.entity.PlantStandardDetails;
import com.wisea.cultivar.standards.entity.StandardMage;
import com.wisea.cultivar.standards.mapper.PlantStandardDetailsMapper;
import com.wisea.cultivar.standards.mapper.StandardMageMapper;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.vo.PlantStandardDetailsListVo;
import com.wisea.cultivar.standards.vo.PlantingMethodListVo;
import com.wisea.cultivar.standards.vo.StandardMageGetVo;
import com.wisea.cultivar.standards.vo.StandardMageListVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * StandardMageService
 * 标准管理 Service
 * 2020/07/24 11:21:45
 */
@Service
public class StandardMageService extends BaseService {

    @Autowired
    protected StandardMageMapper standardMageMapper;
    @Autowired
    protected PlantStandardDetailsMapper plantStandardDetailsMapper;
    @Autowired
    PlantingMethodService plantingMethodService;

    /**
     * 添加权限
     *
     * @param plantRecoProcessType
     * @return
     */
    public void checkAuth(String plantRecoProcessType) {
        boolean res = false;
        switch (plantRecoProcessType) {
            case QdcyStandardsDict.PLANT_RECO_PROCESS_TYPE_0:
                res = SystemUtils.hasAuthor("st:psg");
                break;
            case QdcyStandardsDict.PLANT_RECO_PROCESS_TYPE_1:
                res = SystemUtils.hasAuthor("st:has");
                break;
            case QdcyStandardsDict.PLANT_RECO_PROCESS_TYPE_2:
                res = SystemUtils.hasAuthor("st:prc");
                break;
        }
        if (!res) {
            throw ConstantError.VER_901;
        }
    }

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<StandardMageListVo>> findPage(StandardMagePagePo standardMagePagePo) {
        ResultPoJo<Page<StandardMageListVo>> result = new ResultPoJo<>();
        if (StringUtils.isNotBlank(standardMagePagePo.getPlantRecoProcessType())){
            checkAuth(standardMagePagePo.getPlantRecoProcessType());
            Page<StandardMageListVo> page = standardMagePagePo.getPage();
            List<StandardMageListVo> list = standardMageMapper.findPage(standardMagePagePo);
            page.setList(list);
            result.setResult(page);
            return result;
        }else {
            result.setMsg(ConstantError.MSG_003);
            return result;
        }

    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<StandardMageListVo>> findList(StandardMageListPo standardMageListPo) {
        ResultPoJo<List<StandardMageListVo>> result = new ResultPoJo<>();
        if (StringUtils.isNotBlank(standardMageListPo.getPlantRecoProcessType())){
            checkAuth(standardMageListPo.getPlantRecoProcessType());
            result.setResult(standardMageMapper.findList(standardMageListPo));
            return result;
        }else {
            result.setMsg(ConstantError.MSG_003);
            return result;
        }

    }

    /**
     * 查询
     */
    public ResultPoJo<StandardMageGetVo> get(StandardMageGetPo standardMageGetPo) {
        ResultPoJo<StandardMageGetVo> result = new ResultPoJo<>();
        if (StringUtils.isNotBlank(standardMageGetPo.getPlantRecoProcessType())) {
            checkAuth(standardMageGetPo.getPlantRecoProcessType());
            if (standardMageGetPo.getId() != null) {
                //回显种植数据
                StandardMage entity = standardMageMapper.selectByPrimaryKey(standardMageGetPo.getId());
                StandardMageGetVo vo = new StandardMageGetVo();
                ConverterUtil.copyProperties(entity, vo);
                //回显种植详情数据
                PlantStandardDetailsListPo plantStandardDetailsListPo = new PlantStandardDetailsListPo();
                Long id = standardMageGetPo.getId();
                plantStandardDetailsListPo.setPlantStandardMageId(id);
                List<PlantStandardDetailsListVo> plantStandardDetails = plantStandardDetailsMapper.findList(plantStandardDetailsListPo);
                //不为空
                if (plantStandardDetails.size() > 0) {
                    vo.setPlantStandardDetailsListVo(plantStandardDetails);
                }
                result.setResult(vo);
            } else {
                result.setCode(QdcyStandardsError.ERR_80002);
                result.setMsg(QdcyStandardsError.MSG_80002);
            }
            return result;
        }else {
            result.setMsg(ConstantError.MSG_003);
            return result;
        }
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(StandardMageInsertPo standardMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        if (StringUtils.isNotBlank(standardMageInsertPo.getPlantRecoProcessType())) {
            checkAuth(standardMageInsertPo.getPlantRecoProcessType());
            //新增+详情
            StandardMage standardMage = new StandardMage();
            ConverterUtil.copyProperties(standardMageInsertPo, standardMage);
            standardMage.preInsert();
            standardMageMapper.insert(standardMage);

            if (standardMageInsertPo.getPlantStandardDetailsInsertPo() != null) {
                //插入标准详情
                if (standardMageInsertPo.getPlantStandardDetailsInsertPo().size() > 0) {
                    insertStandardDetails(standardMage, standardMageInsertPo.getPlantStandardDetailsInsertPo());
                }
            }

            return result;
        }else {
            result.setMsg(ConstantError.MSG_003);
            return result;
        }
    }


    /**
     * 修改一条标准
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(StandardMageUpdatePo standardMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        if (StringUtils.isNotBlank(standardMageUpdatePo.getPlantRecoProcessType())) {
            StandardMage standardMage = new StandardMage();
//        if (standardMageMapper.selectByPrimaryKey(standardMageUpdatePo.getId()) != null) {
//
//        }
            ConverterUtil.copyProperties(standardMageUpdatePo, standardMage);
            standardMage.preUpdate();
            standardMageMapper.updateByPrimaryKeySelective(standardMage);

            //逻辑删除所有原来的详情记录
            PlantStandardDetails plantStandardDetails = new PlantStandardDetails();
            plantStandardDetails.setPlantStandardMageId(standardMageUpdatePo.getId());
            plantStandardDetails.preUpdate();
            plantStandardDetailsMapper.deleteByPSDId(plantStandardDetails);

            //插入标准详情
            if (standardMageUpdatePo.getPlantStandardDetailsInsertPo() != null) {
                if (standardMageUpdatePo.getPlantStandardDetailsInsertPo().size() > 0) {
                    insertStandardDetails(standardMage, standardMageUpdatePo.getPlantStandardDetailsInsertPo());
                }
            }
            return result;
        }else {
            result.setMsg(ConstantError.MSG_003);
            return result;
        }
    }

    /**
     * 插入StandardInfo
     *
     * @param entity
     */
    private void insertStandardDetails(StandardMage entity, List<PlantStandardDetailsInsertPo> plantStandardDetails) {
        if (plantStandardDetails.size() > 0) {
            List<PlantStandardDetailsInsertPo> details = plantStandardDetails;
            details.forEach(d -> {
                PlantStandardDetails info = new PlantStandardDetails();
                ConverterUtil.copyProperties(d, info);
                info.setPlantStandardMageId(entity.getId());
                info.preInsert();
                //保存新建种植详情
                plantStandardDetailsMapper.insert(info);
            });
        }
    }


    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(StandardMageBatDeletePo standardMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (Long delId : standardMageBatDeletePo.getDelList()) {
            StandardMage standardMage = new StandardMage();
            standardMage.setId(delId);
            standardMage.preUpdate();
            standardMageMapper.deleteLogic(standardMage);
        }
        return result;
    }

    /**
     * 删除
     *
     * @param standardMageOneDeletePo
     * @return
     */
    public ResultPoJo<Object> oneDelete(StandardMageOneDeletePo standardMageOneDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        if (StringUtils.isNotBlank(standardMageOneDeletePo.getPlantRecoProcessType())) {
            checkAuth(standardMageOneDeletePo.getPlantRecoProcessType());
            StandardMage standardMage = new StandardMage();
            PlantingMethodListPo plantingMethodListPo = new PlantingMethodListPo();
            plantingMethodListPo.setPlantStandardMageId(standardMageOneDeletePo.getId());
            List<PlantingMethodListVo> List = plantingMethodService.findPlantStandardMageId(plantingMethodListPo);
            Integer num = 0;
            if (List != null) {
                num = List.size();
            }
            if (num > 0) {
                result.setCode(QdcyStandardsError.ERR_80003);
                result.setMsg(QdcyStandardsError.MSG_80003);
                return result;
            } else {
                standardMage.setId(standardMageOneDeletePo.getId());
                standardMage.preUpdate();
                standardMageMapper.deleteLogic(standardMage);
                return result;
            }
        }else {
            result.setMsg(ConstantError.MSG_003);
            return result;
        }
    }

    /**
     * 根据id获取单条数据-关联标准
     *
     * @param standardMageGetPo
     * @return
     */
    public ResultPoJo<StandardMageGetVo> oneData(StandardMageGetPo standardMageGetPo) {
        ResultPoJo<StandardMageGetVo> result = new ResultPoJo<>();
        StandardMage entity = standardMageMapper.selectByPrimaryKey(standardMageGetPo.getId());
        StandardMageGetVo vo = new StandardMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }
}
